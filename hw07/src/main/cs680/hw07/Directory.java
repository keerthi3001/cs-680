package cs680.hw07;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {

    private LinkedList<FSElement> children = new LinkedList<>();

    /**
     *  Constructor that matches the tests:
     * new Directory(parent, "name", time)
     */
    public Directory(Directory parent, String name, LocalDateTime creationTime) {
        // Directory's own size can be treated as 0.
        super(parent, name, 0, creationTime);
        if (parent != null) {
            parent.appendChild(this);
        }
    }

    /**
     * Optional constructor with explicit size
     * (kept in case any main code uses it).
     */
    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
        if (parent != null) {
            parent.appendChild(this);
        }
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public boolean isLink() {
        return false;
    }

    public void appendChild(FSElement child) {
        if (child == null) {
            return;
        }
        children.add(child);
        child.setParent(this);
    }

    public LinkedList<FSElement> getChildren() {
        return new LinkedList<>(children);
    }

    public int countChildren() {
        return children.size();
    }

    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> dirs = new LinkedList<>();
        for (FSElement child : children) {
            if (child instanceof Directory) {
                dirs.add((Directory) child);
            }
        }
        return dirs;
    }

    public LinkedList<File> getFiles() {
        LinkedList<File> files = new LinkedList<>();
        for (FSElement child : children) {
            if (child instanceof File) {
                files.add((File) child);
            }
        }
        return files;
    }

    /**  Needed by DirectoryTest */
    public LinkedList<Link> getLinks() {
        LinkedList<Link> links = new LinkedList<>();
        for (FSElement child : children) {
            if (child instanceof Link) {
                links.add((Link) child);
            }
        }
        return links;
    }

    /** Often used to compute total size of a directory subtree. */
    public int getTotalSize() {
        int total = 0;
        for (FSElement child : children) {
            if (child instanceof Directory) {
                total += ((Directory) child).getTotalSize();
            } else {
                total += child.getSize();
            }
        }
        return total;
    }
}
