package cs680.hw11.fs;

/**
 * Visitor interface for the file system tree.
 */
public interface FSVisitor {

    void visit(Directory dir);

    void visit(File file);

    void visit(Link link);
}
