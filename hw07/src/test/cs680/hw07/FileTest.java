package cs680.hw07;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FileTest extends TestFixtureInitializer {

    @Test
    void fileProps() {
        assertEquals("A.java", aJava.getName());
        assertEquals(80, aJava.getSize());
        assertFalse(aJava.isDirectory());
        assertFalse(aJava.isLink());
        assertEquals("src", aJava.getParent().getName());
    }
}
