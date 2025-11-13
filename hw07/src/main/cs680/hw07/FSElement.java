package cs680.hw07;

import java.time.LocalDateTime;

public abstract class FSElement {
    private Directory parent;
    private String name;
    private int size;
    private final LocalDateTime created;
    private LocalDateTime modified;

    protected FSElement(Directory parent, String name, int size, LocalDateTime created) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.created = created;
        this.modified = created;
        if (parent != null) {
            parent.appendChild(this);
        }
    }

    public Directory getParent() { return parent; }
    public void setParent(Directory parent) { this.parent = parent; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; touch(); }
    public int getSize() { return size; }
    protected void setSize(int size) { this.size = size; touch(); }
    public LocalDateTime getCreationTime() { return created; }
    public LocalDateTime getLastModifiedTime() { return modified; }
    protected void touch() { this.modified = LocalDateTime.now(); }

    public boolean isDirectory() { return false; }
}
