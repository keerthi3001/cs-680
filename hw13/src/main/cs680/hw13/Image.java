package cs680.hw13;

import java.util.ArrayList;

public class Image {
    private int width;
    private int height;
    private ArrayList<ArrayList<Color>> pixels;

    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new ArrayList<>();

        for (int y = 0; y < height; y++) {
            pixels.add(new ArrayList<>());
            for (int x = 0; x < width; x++) {
                pixels.get(y).add(new Color(0, 0, 0));
            }
        }
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public Color getColor(int x, int y) { return pixels.get(y).get(x); }
    public void setColor(int x, int y, Color c) { pixels.get(y).set(x, c); }
}
