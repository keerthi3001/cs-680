package cs680.hw11.fs;

import java.util.Comparator;


public class SizeComparator implements Comparator<FSElement> {

    @Override
    public int compare(FSElement a, FSElement b) {
        if (a == null && b == null) return 0;
        if (a == null) return -1;
        if (b == null) return 1;

        int sa = a.getSize();
        int sb = b.getSize();

        if (sa != sb) {
            return Integer.compare(sa, sb);
        }
        return a.getName().compareToIgnoreCase(b.getName());
    }
}
