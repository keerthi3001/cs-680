package cs680.hw08.fs;

import java.time.LocalDateTime;

public class File extends FSElement {
    public File(Directory parent, String name, int size, LocalDateTime time) {
        super(parent, name, size, time);
    }
    @Override public boolean isDirectory() { return false; }
    @Override public void accept(FSVisitor v) { v.visit(this); }
}
