package cs680.hw13;

public class Images {

    public static Image transform(Image image, ColorAdjuster adjuster) {
        Image result = new Image(image.getWidth(), image.getHeight());

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                result.setColor(
                    x,
                    y,
                    adjuster.adjust(image.getColor(x, y))
                );
            }
        }
        return result;
    }
}
