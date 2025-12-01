package cs680.hw08.fs;

import java.time.LocalDateTime;

public abstract class FSElement {
    private final String name;
    private final int size;
    private final LocalDateTime creationTime;
    private Directory parent;

    protected FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
        if (parent != null) parent.appendChild(this);
    }

    public String getName() { return name; }
    public int getSize() { return size; }
    public LocalDateTime getCreationTime() { return creationTime; }
    public Directory getParent() { return parent; }
    void setParent(Directory parent) { this.parent = parent; }

    public abstract boolean isDirectory();
    public abstract void accept(FSVisitor v);
}
