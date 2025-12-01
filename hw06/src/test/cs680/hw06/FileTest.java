package cs680.hw06;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FileTest extends TestFixtureInitializer {

    private String[] fileInfo(File f) {
        return new String[] {
            f.getName(),
            String.valueOf(f.getSize()),
            f.getCreationTime().toString(),
            f.getParent() == null ? "null" : f.getParent().getName()
        };
    }

    @Test
    void fileProperties_areCorrect() {
        String[] expected = {
            "A.java", "80",
            aJava.getCreationTime().toString(),
            "src"
        };
        assertArrayEquals(expected, fileInfo(aJava));
        assertFalse(aJava.isDirectory());
    }

    @Test
    void parentLinks_areSet() {
        assertEquals("home", readme.getParent().getName());
        assertEquals("root", buildXml.getParent().getName());
    }
}
