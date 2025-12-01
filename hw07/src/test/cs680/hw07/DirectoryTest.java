package cs680.hw07;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest extends TestFixtureInitializer {

    @Test
    void childrenByKind() {
        // root has: home(dir), hw01(dir), build.xml(file), link-home(link)
        assertEquals(4, root.countChildren());
        assertEquals(2, root.getSubDirectories().size());
        assertEquals(1, root.getFiles().size());
        assertEquals(1, root.getLinks().size());
        assertEquals("link-home", root.getLinks().get(0).getName());
    }

    @Test
    void totalSizeCountsFilesOnly() {
        // src: 80 + 90 = 170
        assertEquals(170, src.getTotalSize());
        // home: 120 + 170 = 290
        assertEquals(290, home.getTotalSize());
        // root: 60 + 290 + 0 = 350 (links contribute 0)
        assertEquals(350, root.getTotalSize());
    }
}
