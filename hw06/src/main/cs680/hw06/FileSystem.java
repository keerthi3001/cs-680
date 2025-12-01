package cs680.hw06;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class FileSystem {
    private static final FileSystem INSTANCE = new FileSystem();
    private final LinkedList<Directory> rootDirs = new LinkedList<>();

    private FileSystem() { }

    public static FileSystem getFileSystem() { return INSTANCE; }

    public void appendRootDir(Directory root) {
        if (root == null) throw new IllegalArgumentException("root required");
        if (root.getParent() != null) throw new IllegalArgumentException("root must not have a parent");
        rootDirs.add(root);
    }

    public List<Directory> getRootDirs() {
        return Collections.unmodifiableList(rootDirs);
    }
}
