package cs680.hw08.fs;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Directory extends FSElement {
    private final LinkedList<FSElement> children = new LinkedList<>();

    public Directory(Directory parent, String name, LocalDateTime time) {
        super(parent, name, 0, time);
    }

    @Override
    public boolean isDirectory() { return true; }

    void appendChild(FSElement child) {
        if (child == null) return;
        children.add(child);
        child.setParent(this);
    }

    public List<FSElement> getChildren() { return new LinkedList<>(children); }

    public List<Directory> getSubDirectories() {
        return children.stream()
                .filter(FSElement::isDirectory)
                .map(e -> (Directory) e)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public List<File> getFiles() {
        return children.stream()
                .filter(e -> !e.isDirectory() && !(e instanceof Link))
                .map(e -> (File) e)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public List<Link> getLinks() {
        return children.stream()
                .filter(e -> e instanceof Link)
                .map(e -> (Link) e)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public int getTotalSize() {
        int s = 0;
        for (FSElement e : children) {
            if (e instanceof Directory) s += ((Directory) e).getTotalSize();
            else s += e.getSize();
        }
        return s;
    }

    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
        for (FSElement c : children) c.accept(v);
    }
}
