package cs680.hw07;

import java.util.List;

public class FileSystem {
    private static FileSystem instance = null;
    private Directory root;

    private FileSystem() { }

    public static FileSystem getFileSystem() {
        if (instance == null) instance = new FileSystem();
        return instance;
    }

    // --- APIs expected by tests ---

    // Some test fixtures call this to register the root directory
    public void appendRootDir(Directory root) {
        this.root = root;
    }

    // Some tests ask for a list of roots
    public List<Directory> getRootDirs() {
        return (root == null) ? List.of() : List.of(root);
    }

    // Convenience (sometimes used)
    public Directory getRoot() { return root; }

    // Reset between tests if needed
    public void clear() { this.root = null; }
}
