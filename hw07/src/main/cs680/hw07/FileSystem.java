package cs680.hw07;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class FileSystem {

    private static FileSystem fileSystem = null;
    private LinkedList<Directory> rootDirs;

    
    private FileSystem() {
        rootDirs = new LinkedList<>();
    }

    
    public static FileSystem getFileSystem() {
        if (fileSystem == null) {
            fileSystem = new FileSystem();
        }
        return fileSystem;
    }

    
    public List<Directory> getRootDirs() {
        return Collections.unmodifiableList(rootDirs);
    }

    
    public void appendRootDir(Directory root) {
        if (root == null) {
            throw new IllegalArgumentException("root directory cannot be null");
        }
        rootDirs.add(root);
    }

   
    public void clearRootDirs() {
        rootDirs.clear();
    }
}
