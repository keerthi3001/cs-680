package cs680.hw06;

import org.junit.jupiter.api.BeforeAll;
import java.time.LocalDateTime;

/** Builds a reusable fixture for all tests. */
public class TestFixtureInitializer {
    protected static FileSystem fs;
    protected static Directory root;
    protected static Directory home;
    protected static Directory src;
    protected static File readme;
    protected static File aJava;
    protected static File bJava;
    protected static File buildXml;
    protected static Directory hw01;

    @BeforeAll
    public static void setUpFileSystem() {
        fs = FileSystem.getFileSystem();

        LocalDateTime t = LocalDateTime.of(2024, 11, 1, 12, 0);

        root = new Directory(null, "root", t);
        fs.appendRootDir(root);

        home = new Directory(root, "home", t.plusMinutes(1));
        src  = new Directory(home, "src",  t.plusMinutes(2));

        readme   = new File(home, "readme.md", 120, t.plusMinutes(3));
        aJava    = new File(src,  "A.java",      80, t.plusMinutes(4));
        bJava    = new File(src,  "B.java",      90, t.plusMinutes(5));
        buildXml = new File(root, "build.xml",   60, t.plusMinutes(6));
        hw01     = new Directory(root, "hw01",   t.plusMinutes(7));
    }
}
