package cs680.hw08.fs;

import java.time.LocalDateTime;

public class Link extends FSElement {
    private final FSElement target;

    public Link(Directory parent, String name, FSElement target, LocalDateTime time) {
        super(parent, name, 0, time);
        this.target = target;
    }

    public FSElement getTarget() { return target; }
    @Override public boolean isDirectory() { return false; }
    @Override public void accept(FSVisitor v) { v.visit(this); }
}
