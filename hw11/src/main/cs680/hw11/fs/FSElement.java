package cs680.hw11.fs;

import java.time.LocalDateTime;

/**
 * Common base class for all file system elements:
 * directories, files, and links.
 */
public abstract class FSElement {

    protected String name;
    protected int size;
    protected LocalDateTime creationTime;
    protected Directory parent;

    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

    // --- basic getters ---

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    // --- type checks ---

    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public abstract boolean isLink();

    // --- Visitor hook ---

    public abstract void accept(FSVisitor visitor);
}
