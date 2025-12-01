package cs680.hw06;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Collectors;

class DirectoryTest extends TestFixtureInitializer {

    private String[] dirInfo(Directory d) {
        return new String[] {
            d.getName(),
            String.valueOf(d.getSize()), // 0 for directories
            d.getCreationTime().toString(),
            d.getParent() == null ? "null" : d.getParent().getName()
        };
    }

    @Test
    void countChildren_and_lists_areCorrect() {
        // root has: home (dir), build.xml (file), hw01 (dir)
        assertEquals(3, root.countChildren());

        assertEquals(2, root.getSubDirectories().size());
        assertEquals(1, root.getFiles().size());

        assertEquals("build.xml",
            root.getFiles().stream().map(File::getName).collect(Collectors.toList()).get(0));
    }

    @Test
    void totalSize_isRecursiveSumOfFilesOnly() {
        // src: A.java(80) + B.java(90) = 170
        assertEquals(170, src.getTotalSize());

        // home: readme(120) + src(170) = 290
        assertEquals(290, home.getTotalSize());

        // root: build.xml(60) + home(290) + hw01(0) = 350
        assertEquals(350, root.getTotalSize());
    }

    @Test
    void directory_projection_equality() {
        String[] expected = dirInfo(home);
        String[] actual   = dirInfo(home);
        assertArrayEquals(expected, actual);
    }
}
