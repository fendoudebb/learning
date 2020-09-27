import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class WatchServiceDemo {

    public static void main(String[] args) {
        watchSingleDir();
//        watchRecursionDir(System.out::println);
    }

    private static void watchSingleDir() {
        try {
            String filePath = System.getProperty("user.home");
            WatchService watchService = FileSystems.getDefault().newWatchService();
            Path path = Paths.get(filePath);
            path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.OVERFLOW);
            System.out.println("开始监听文件夹#" + filePath);
            WatchKey key;
            while ((key = watchService.take()) != null) {
                List<WatchEvent<?>> watchEvents = key.pollEvents();
                for (WatchEvent<?> watchEvent : watchEvents) {
                    WatchEvent.Kind<?> kind = watchEvent.kind();
                    if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
                        System.out.println("新建#" + watchEvent.context() + ", 次数#" + watchEvent.count());
                    } else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
                        System.out.println("删除#" + watchEvent.context() + ", 次数#" + watchEvent.count());
                    } else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                        System.out.println("修改#" + watchEvent.context() + ", 次数#" + watchEvent.count());
                    } else if (kind == StandardWatchEventKinds.OVERFLOW) {
                        System.out.println("overflow#" + watchEvent.context() + ", 次数#" + watchEvent.count());
                    }
                }
                key.reset();
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获取监听器失败");
        }
    }

    /**
     * 有 Bug
     */
    @SuppressWarnings("unchecked")
    public static void watchRecursionDir(Consumer<Path> consumer) {
        try {
//            String filePath = System.getProperty(""user.home"");
            String filePath = "C:\\Users\\zhangbj94\\Desktop";
            Path targetPath = Paths.get(filePath);
            WatchService watchService = targetPath.getFileSystem().newWatchService();
            Files.walkFileTree(targetPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                        throws IOException {
                    dir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE);
                    return FileVisitResult.CONTINUE;
                }
            });
            Executors.newFixedThreadPool(10).execute(() -> {
                WatchKey watchKey = null;
                while (true) {
                    try {
                        watchKey = watchService.take();

                        List<WatchEvent<?>> watchEvents = watchKey.pollEvents();
                        for (WatchEvent<?> event : watchEvents) {
                            WatchEvent<Path> watchEvent = (WatchEvent<Path>) event;
                            WatchEvent.Kind<Path> kind = watchEvent.kind();
                            if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
                                Path watchable = (Path) watchKey.watchable();
                                if (Files.isDirectory(watchable)) {
                                    watchable.resolve(watchEvent.context()).register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE);
                                }
                            }
                        }
                        consumer.accept(targetPath);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if(watchKey != null){
                            watchKey.reset();
                        }
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
