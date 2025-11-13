package cs680.hw07;

import java.time.LocalDateTime;

public class File extends FSElement {
    public File(Directory parent, String name, int size, LocalDateTime created) {
        super(parent, name, size, created);
    }
}
