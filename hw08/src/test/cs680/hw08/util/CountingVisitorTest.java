package cs680.hw08.util;

import cs680.hw08.fs.Directory;
import cs680.hw08.fs.TestFixtureInitializer;
import org.junit.jupiter.api.Test;

public class CountingVisitorTest {

    @Test
    public void traversesFileSystemWithoutError() {
        Directory root = new TestFixtureInitializer().create();
        CountingVisitor v = new CountingVisitor();
        root.accept(v);
        // If no exception is thrown, we consider this basic test passed.
    }
}
