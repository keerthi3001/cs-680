package cs680.hw07;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Directory extends FSElement {
    private final List<FSElement> children = new ArrayList<>();

    public Directory(Directory parent, String name, LocalDateTime created) {
        super(parent, name, 0, created);
    }

    @Override
    public boolean isDirectory() { return true; }

    void appendChild(FSElement child) {
        if (!children.contains(child)) {
            children.add(child);
            child.setParent(this);
        }
    }

    public List<FSElement> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public int countChildren() {
        return children.size();
    }

    public List<Directory> getSubDirectories() {
        List<Directory> dirs = new ArrayList<>();
        for (FSElement e : children) if (e instanceof Directory) dirs.add((Directory) e);
        return Collections.unmodifiableList(dirs);
    }

    public List<File> getFiles() {
        List<File> files = new ArrayList<>();
        for (FSElement e : children) if (e instanceof File) files.add((File) e);
        return Collections.unmodifiableList(files);
    }

    public List<Link> getLinks() {
        List<Link> links = new ArrayList<>();
        for (FSElement e : children) if (e instanceof Link) links.add((Link) e);
        return Collections.unmodifiableList(links);
    }

    @Override
    public int getSize() {
        int sum = 0;
        for (FSElement e : children) {
            sum += e.getSize();
        }
        return sum;
    }
}
