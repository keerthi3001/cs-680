package cs680.hw08.fs;

public class FileSystem {
    private static final FileSystem instance = new FileSystem();
    private Directory root;

    private FileSystem() {}

    public static FileSystem getFileSystem() { return instance; }

    public void setRoot(Directory root) { this.root = root; }
    public Directory getRoot() { return root; }

    public void accept(FSVisitor v) { if (root != null) root.accept(v); }
}
