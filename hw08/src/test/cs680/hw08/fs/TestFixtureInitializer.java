package cs680.hw08.fs;

import java.time.LocalDateTime;

public class TestFixtureInitializer {

    public static FileSystem createSampleFS() {
        FileSystem fs = FileSystem.getFileSystem();
        LocalDateTime now = LocalDateTime.now();

        Directory root = new Directory(null, "root", now);
        fs.setRoot(root);

        Directory apps = new Directory(root, "apps", now);
        Directory bin  = new Directory(root, "bin",  now);
        Directory home = new Directory(root, "home", now);

        new File(apps, "x", 100, now);
        new File(apps, "y", 200, now);

        new File(bin, "a", 50, now);
        new File(bin, "b", 70, now);

        Directory pictures = new Directory(home, "pictures", now);
        new File(pictures, "vacation.jpg", 1200, now);
        new File(pictures, "family.png",   800,  now);

        new File(home, "readme.txt", 10, now);
        new Link(home, "b-link", bin, now);
        new Link(pictures, "x-link", apps.getFiles().get(0), now);

        return fs;
    }
}
