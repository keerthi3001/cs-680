package cs680.hw08.fs;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class Directory extends FSElement {

    private LinkedList<FSElement> children = new LinkedList<>();

    public Directory(Directory parent, String name, LocalDateTime creationTime) {
        super(parent, name, creationTime);
        if (parent != null) {
            parent.appendChild(this);
        }
    }

    public void appendChild(FSElement child) {
        if (child == null) return;
        children.add(child);
    }

    public List<FSElement> getChildren() {
        return children;
    }

    // ---- tests require these ----

    public int countChildren() {
        return children.size();
    }

    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> dirs = new LinkedList<>();
        for (FSElement e : children) {
            if (e instanceof Directory) dirs.add((Directory) e);
        }
        return dirs;
    }

    public LinkedList<File> getFiles() {
        LinkedList<File> files = new LinkedList<>();
        for (FSElement e : children) {
            if (e instanceof File) files.add((File) e);
        }
        return files;
    }

    public LinkedList<Link> getLinks() {
        LinkedList<Link> links = new LinkedList<>();
        for (FSElement e : children) {
            if (e instanceof Link) links.add((Link) e);
        }
        return links;
    }

    // DO NOT put @Override here (your FSElement probably doesn't declare getTotalSize)
    public int getTotalSize() {
        int total = 0;
        for (FSElement e : children) {
            if (e instanceof Directory) {
                total += ((Directory) e).getTotalSize();
            } else if (e instanceof File) {
                total += ((File) e).getSize();
            }
            // Link contributes 0 (as test says)
        }
        return total;
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public int getSize() {
        return 0; // directory size is 0
    }

    // Visitor Pattern B: traversal happens here
    @Override
    public void accept(FSVisitor visitor) {
        visitor.visit(this);
        for (FSElement child : children) {
            child.accept(visitor);
        }
    }
}
