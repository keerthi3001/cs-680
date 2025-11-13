package cs680.hw07;

import cs680.hw07.*;
import org.junit.jupiter.api.BeforeAll;
import java.time.LocalDateTime;

public class TestFixtureInitializer {
    protected static FileSystem fs;
    protected static Directory root, home, src, hw01;
    protected static File readme, aJava, bJava, buildXml;
    protected static Link linkToHome, linkToAjava, linkChain;

    @BeforeAll
    public static void setUpFS() {
        fs = FileSystem.getFileSystem();
        LocalDateTime t = LocalDateTime.of(2024, 12, 1, 10, 0);

        root = new Directory(null, "root", t);
        fs.appendRootDir(root);

        home = new Directory(root, "home", t.plusMinutes(1));
        src  = new Directory(home, "src",  t.plusMinutes(2));
        hw01 = new Directory(root, "hw01", t.plusMinutes(3));

        readme   = new File(home, "readme.md", 120, t.plusMinutes(4));
        aJava    = new File(src,  "A.java",      80, t.plusMinutes(5));
        bJava    = new File(src,  "B.java",      90, t.plusMinutes(6));
        buildXml = new File(root, "build.xml",   60, t.plusMinutes(7));

        // Links (proxies)
        linkToHome  = new Link(root, "link-home",   t.plusMinutes(8),  home);
        linkToAjava = new Link(home, "a.java.link", t.plusMinutes(9),  aJava);
        linkChain   = new Link(src,  "chain.link",  t.plusMinutes(10), linkToAjava); // link -> link -> file
    }
}






