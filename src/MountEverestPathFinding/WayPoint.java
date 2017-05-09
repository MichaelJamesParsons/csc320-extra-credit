package MountEverestPathFinding;

public class WayPoint {
    private int weight;
    private double cost;
    private int x;
    private int y;
    private WayPoint parent;

    public WayPoint(int weight, int x, int y) {
        this.weight = weight;
        this.cost = 0;
        this.parent = null;
        this.x = x;
        this.y = y;
    }

    public double getGCost() {
        if(parent != null) {
            return parent.getGCost() + (parent.getWeight() - weight);
        }

        return 0;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
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
