import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Files_Paths {

    public static void main(String[] args) throws IOException {
        //skip: 跳过行数
        //limit: 读取几行
        //操作无法终止，即在forEach无法跳出
        Files.lines(Paths.get("README.md")).skip(1).limit(10).forEach(System.out::println);

        System.out.println("-----------------------");

        //try-with-resource关闭流，否则会造成流未关闭。上面代码就是没有正确关闭
        //onClose: 流正常关闭后调用
        try (Stream<String> stream = Files.lines(Paths.get("README.md"))) {
            stream.onClose(() -> System.out.println("On Close")).skip(0).limit(20).forEach(System.out::println);
        }

        System.out.println("++++++++++++++++++++++");

        //count: 统计总行数
        try (Stream<String> stream = Files.lines(Paths.get("README.md"))) {
            //总行数
            System.out.println(stream.count());
        }
    }

}
