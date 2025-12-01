package cs680.hw08.fs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DirectoryTest {

    @Test
    public void rootDirectoryHasNameRoot() {
        Directory root = new TestFixtureInitializer().create();
        assertNotNull(root);
        assertEquals("root", root.getName());
        assertTrue(root.isDirectory());
    }
}
