package cs680.hw09;

public class BinarizationAdjuster implements ColorAdjuster {

    private final int threshold;

    public BinarizationAdjuster() {
        this.threshold = 125;  // default
    }

    public BinarizationAdjuster(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public Color adjust(Color color) {
        if (color == null) {
            throw new NullPointerException("color is null");
        }

        int avg = (color.getRedScale()
                 + color.getGreenScale()
                 + color.getBlueScale()) / 3;

        if (avg <= threshold) {
            return new Color(0, 0, 0);       // black
        } else {
            return new Color(255, 255, 255); // white
        }
    }
}
