package cs680.hw08.fs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LinkTest {

    @Test
    public void linksPointToTargets() {
        Directory root = new TestFixtureInitializer().create();
        Directory home = root.getSubDirectories()
                             .stream()
                             .filter(d -> d.getName().equals("home"))
                             .findFirst()
                             .orElseThrow();

        // any link under home should have a non-null target
        home.getLinks().forEach(link -> assertNotNull(link.getTarget()));
    }
}
