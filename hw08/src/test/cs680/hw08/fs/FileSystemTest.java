package cs680.hw08.fs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FileSystemTest {
    @BeforeAll
    public static void setup() { TestFixtureInitializer.createSampleFS(); }

    @Test
    public void singletonHoldsRoot() {
        FileSystem fs = FileSystem.getFileSystem();
        assertNotNull(fs.getRoot());
        assertEquals("root", fs.getRoot().getName());
    }
}
