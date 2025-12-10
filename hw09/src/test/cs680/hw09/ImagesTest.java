import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import cs680.hw09.Image;
import cs680.hw09.Color;
import cs680.hw09.Images;
import cs680.hw09.GrayScaleAdjuster;
import cs680.hw09.BinarizationAdjuster;

public class ImagesTest {

    @Test
    public void testGrayScale() {
        Image img = new Image(1, 1);
        img.setColor(0, 0, new Color(100, 150, 200));

        Image gray = Images.transform(img, new GrayScaleAdjuster());
        Color c = gray.getColor(0, 0);

        int expected = (100 + 150 + 200) / 3;

        assertEquals(expected, c.getRedScale());
        assertEquals(expected, c.getGreenScale());
        assertEquals(expected, c.getBlueScale());
    }

    @Test
    public void testBinarization() {
        Image img = new Image(1, 2);
        img.setColor(0, 0, new Color(10, 10, 10));        // dark
        img.setColor(1, 0, new Color(200, 200, 200));     // bright

        Image bin = Images.transform(img, new BinarizationAdjuster());

        assertEquals(0,   bin.getColor(0, 0).getRedScale());
        assertEquals(255, bin.getColor(1, 0).getRedScale());
    }

    @Test
    public void testOriginalNotChanged() {
        Image img = new Image(1, 1);
        img.setColor(0, 0, new Color(50, 60, 70));

        Images.transform(img, new GrayScaleAdjuster());

        Color original = img.getColor(0, 0);
        assertEquals(50, original.getRedScale());
        assertEquals(60, original.getGreenScale());
        assertEquals(70, original.getBlueScale());
    }
}
