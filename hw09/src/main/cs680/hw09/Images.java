package cs680.hw09;

public class Images {

    private Images() {}

    public static Image transform(Image image, ColorAdjuster adjuster) {
        if (image == null) throw new NullPointerException("image is null");
        if (adjuster == null) throw new NullPointerException("adjuster is null");

        Image result = new Image(image.getHeight(), image.getWidth());

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color oldColor = image.getColor(x, y);
                Color newColor = adjuster.adjust(oldColor);
                result.setColor(x, y, newColor);
            }
        }

        return result;
    }
}
