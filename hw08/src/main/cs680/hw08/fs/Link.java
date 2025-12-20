package cs680.hw08.fs;

import java.time.LocalDateTime;

public class Link extends FSElement {

    private FSElement target;

    public Link(Directory parent, String name, FSElement target, LocalDateTime creationTime) {
        super(parent, name, creationTime);
        this.target = target;

        if (parent != null) {
            parent.appendChild(this);
        }
    }

    public FSElement getTarget() {
        return target;
    }

    @Override
    public int getSize() {
        return 0; // links have size 0 (as tests say)
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public void accept(FSVisitor visitor) {
        visitor.visit(this);
    }
}
