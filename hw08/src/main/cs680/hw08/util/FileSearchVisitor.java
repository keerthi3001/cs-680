package cs680.hw08.util;

import cs680.hw08.fs.*;
import java.util.LinkedList;
import java.util.List;

public class FileSearchVisitor implements FSVisitor {
    private final String fileName;
    private final LinkedList<File> found = new LinkedList<>();

    public FileSearchVisitor(String fileName) { this.fileName = fileName; }

    @Override public void visit(Directory dir) { }
    @Override public void visit(File file) {
        if (file.getName().equals(fileName)) found.add(file);
    }
    @Override public void visit(Link link) { }

    public List<File> getFoundFiles() { return new LinkedList<>(found); }
}
