package cs680.hw14.fs;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedList;

public class Directory extends FSElement {

    private LinkedList<FSElement> children = new LinkedList<>();

    public Directory(Directory parent, String name, LocalDateTime time) {
        super(parent, name, 0, time);
        if (parent != null) parent.appendChild(this);
    }

    public void appendChild(FSElement child) {
        children.add(child);
        child.setParent(this);
    }

    public LinkedList<FSElement> getChildren() {
        return new LinkedList<>(children);
    }

    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> dirs = new LinkedList<>();
        for (FSElement e : children)
            if (e.isDirectory()) dirs.add((Directory) e);
        return dirs;
    }

    public LinkedList<File> getFiles() {
        LinkedList<File> files = new LinkedList<>();
        for (FSElement e : children)
            if (e.isFile()) files.add((File) e);
        return files;
    }

    public LinkedList<File> getFiles(Comparator<FSElement> comp) {
        LinkedList<FSElement> sorted = new LinkedList<>(children);
        sorted.sort(comp);

        LinkedList<File> files = new LinkedList<>();
        for (FSElement e : sorted)
            if (e.isFile()) files.add((File) e);
        return files;
    }

    @Override public boolean isDirectory() { return true; }
    @Override public boolean isFile() { return false; }
    @Override public boolean isLink() { return false; }

    @Override
    public void accept(FSVisitor visitor) {
        visitor.visit(this);
        for (FSElement e : children) e.accept(visitor);
    }
}
