package cs680.hw07;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class LinkTest {

    @Test
    public void testLinkPointsToTarget() {
        LocalDateTime now = LocalDateTime.now();
        Directory root = new Directory(null, "root", now);
        File target = new File(root, "target.txt", 30, now);

        Link link = new Link(root, "target-link", now, target);

        assertEquals("target-link", link.getName());
        assertEquals(target, link.getTarget());
        assertEquals(0, link.getSize());   // links have size 0
        assertFalse(link.isDirectory());
        assertEquals(root, link.getParent());
    }
}
