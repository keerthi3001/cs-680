package cs680.hw11.fs;

import java.util.Comparator;

/** Sort by size ascending. */
public class SizeComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement a, FSElement b) {
        return Integer.compare(a.getSize(), b.getSize());
    }
}
