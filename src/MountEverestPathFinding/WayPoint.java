package MountEverestPathFinding;

public class WayPoint {
    private int weight;
    private int gCost;
    private int x;
    private int y;
    private WayPoint parent;

    public WayPoint(int weight, int x, int y) {
        this.weight = weight;
        this.gCost = 0;
        this.parent = null;
        this.x = x;
        this.y = y;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getgCost() {
        return gCost;
    }

    public void setgCost(int gCost) {
        this.gCost = gCost;
    }

    public WayPoint getParent() {
        return parent;
    }

    public void setParent(WayPoint parent) {
        this.parent = parent;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
