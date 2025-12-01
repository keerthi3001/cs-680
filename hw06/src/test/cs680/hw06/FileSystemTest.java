package cs680.hw06;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest extends TestFixtureInitializer {

    @Test
    void singleton_returnsSameInstance() {
        FileSystem a = FileSystem.getFileSystem();
        FileSystem b = FileSystem.getFileSystem();
        assertSame(a, b);
    }

    @Test
    void rootDirs_areTrackedAndUnmodifiable() {
        assertTrue(fs.getRootDirs().stream().anyMatch(d -> d.getName().equals("root")));
        assertThrows(UnsupportedOperationException.class, () ->
            fs.getRootDirs().add(new Directory(null, "x", java.time.LocalDateTime.now()))
        );
    }
}
