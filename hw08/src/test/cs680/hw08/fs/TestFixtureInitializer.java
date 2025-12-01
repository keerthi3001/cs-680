package cs680.hw08.fs;

import java.time.LocalDateTime;

public class TestFixtureInitializer {

    public Directory create() {
        FileSystem fs = FileSystem.getFileSystem();

        LocalDateTime t = LocalDateTime.of(2025, 4, 1, 10, 0);

        // Your HW06/HW07-style constructors:
        // Directory(Directory parent, String name, LocalDateTime created)
        Directory root   = new Directory(null,  "drive",  t);
        fs.setRoot(root);

        Directory users   = new Directory(root,   "users",   t.plusMinutes(1));
        Directory keerthi = new Directory(users,  "keerthi", t.plusMinutes(2));
        Directory guest   = new Directory(users,  "guest",   t.plusMinutes(3));
        Directory logs    = new Directory(root,   "logs",    t.plusMinutes(4));

        // File(Directory parent, String name, int size, LocalDateTime created)
        new File(keerthi, "notes.txt",  64, t.plusMinutes(5));
        new File(keerthi, "todo.md",     8, t.plusMinutes(6));
        new File(guest,   "readme.txt", 16, t.plusMinutes(7));
        File appLog = new File(logs, "app.log", 120, t.plusMinutes(8));

        // Link(Directory parent, String name, FSElement target, LocalDateTime created)
        new Link(keerthi, "app.log.link", appLog, t.plusMinutes(9));

        return root;
    }
}
