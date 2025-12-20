package cs680.hw08.fs;

import java.time.LocalDateTime;

public abstract class FSElement {

    protected Directory parent;
    protected String name;
    protected LocalDateTime creationTime;

    public FSElement(Directory parent, String name, LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.creationTime = creationTime;
    }

    public Directory getParent() {
        return parent;
    }

    protected void setParent(Directory parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public boolean isDirectory() {
        return false;
    }

    public abstract int getSize();

    public abstract void accept(FSVisitor v);
}
