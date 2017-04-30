package BoxStacking;

public class Box implements Comparable<Box> {
    private int height;
    private int width;
    private int length;

    Box(int h, int w, int l) {
        this.width = w;
        this.height = h;
        this.length = l;
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

    int getLength() {
        return length;
    }

    private int getBaseArea() {
        return this.width * this.length;
    }

    @Override
    public int compareTo(Box box) {
        return box.getBaseArea() - this.getBaseArea();
    }
}
