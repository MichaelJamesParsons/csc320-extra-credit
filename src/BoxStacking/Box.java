package BoxStacking;

import java.util.Comparator;

public class Box implements Comparable<Box> {

    private int width;
    private int height;
    private int length;

    public Box(int w, int h, int l) {
        this.width = w;
        this.height = h;
        this.length = l;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBaseArea() {
        return this.width * this.length;
    }

    @Override
    public int compareTo(Box box) {
        return box.getBaseArea() - this.getBaseArea();
    }
}
