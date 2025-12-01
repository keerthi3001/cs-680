package cs680.hw08.util;

import cs680.hw08.fs.Directory;
import cs680.hw08.fs.TestFixtureInitializer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FileCrawlingVisitorTest {
    @Test
    public void absolutePathsCollected() {
        Directory root = new TestFixtureInitializer().create();
        FileCrawlingVisitor v = new FileCrawlingVisitor();
        root.accept(v);

        assertTrue(v.getAbsolutePaths().contains("/drive/users/keerthi/notes.txt"));
        assertTrue(v.getAbsolutePaths().contains("/drive/logs/system.log"));
        assertEquals(4, v.getAbsolutePaths().size());
    }
}
