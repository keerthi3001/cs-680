package cs680.hw07;

import java.time.LocalDateTime;

public class Link extends FSElement {
    private FSElement target;

    public Link(Directory parent, String name, LocalDateTime created, FSElement target) {
        // links typically have 0 size; they reference the target
        super(parent, name, 0, created);
        this.target = target;
    }

    public FSElement getTarget() { return target; }
    public void setTarget(FSElement target) { this.target = target; }
}
