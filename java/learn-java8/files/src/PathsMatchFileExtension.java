import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

//https://docs.oracle.com/javase/tutorial/essential/io/find.html
public class PathsMatchFileExtension {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{gitignore,java,class,md,html}");

        Path filename = Paths.get(".gitignore");
        if (matcher.matches(filename)) {
            System.out.println(filename);
        } else {
            System.out.println("not match");
        }
    }
}
