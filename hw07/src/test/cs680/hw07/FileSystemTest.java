package cs680.hw07;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest extends TestFixtureInitializer {

    @Test
    void singleton() {
        assertSame(FileSystem.getFileSystem(), fs);
    }

    @Test
    void rootDirsListIsUnmodifiable() {
        assertTrue(fs.getRootDirs().stream().anyMatch(d -> d.getName().equals("root")));
        assertThrows(UnsupportedOperationException.class,
            () -> fs.getRootDirs().add(new Directory(null, "x", java.time.LocalDateTime.now())));
    }
}
