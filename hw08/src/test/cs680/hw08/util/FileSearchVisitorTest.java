package cs680.hw08.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import cs680.hw08.fs.FileSystem;
import cs680.hw08.fs.TestFixtureInitializer;

public class FileSearchVisitorTest {
    @BeforeAll
    public static void setup() { TestFixtureInitializer.createSampleFS(); }

    @Test
    public void findsByExactName() {
        FileSearchVisitor v = new FileSearchVisitor("x");
        FileSystem.getFileSystem().accept(v);
        assertEquals(1, v.getFoundFiles().size());
        assertEquals("x", v.getFoundFiles().get(0).getName());
    }

    @Test
    public void noMatchReturnsEmptyList() {
        FileSearchVisitor v = new FileSearchVisitor("nope.md");
        FileSystem.getFileSystem().accept(v);
        assertTrue(v.getFoundFiles().isEmpty());
    }
}
