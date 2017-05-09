package MountEverestPathFinding;

import java.util.*;

/**
 * NOTICE: Due to time constraints, I was unable to complete this assignment. The partial algorithm is a
 *         variation of the A* algorithm, tweaked to calculate cost using the distance of way points instead
 *         of a constant as used in the traditional implementation.
 */
public class PathFinder {

    public WayPoint[] findPath(WayPoint[][] map, WayPoint start, WayPoint dest) {
        LinkedHashSet<WayPoint> open = new LinkedHashSet();
        HashSet<WayPoint> closed = new HashSet<>();

        start.setCost(0);
        //Add initial point to open set.
        open.add(start);

        //While there are positions to search.
        while(open.size() > 0) {
            WayPoint wp = getOptimalOpenWayPoint(open);

            if(wp == dest) {
                System.out.println("complete!");
                return null;
            }

            open.remove(wp);
            closed.add(wp);

            ArrayList<WayPoint> neighbors = collectWayPointNeighbors(wp, dest, map);
            for(WayPoint neighbor : neighbors) {
                if(closed.contains(neighbor)) {
                    continue;
                }

                if(!open.contains(neighbor)) {
                    open.add(neighbor);
                }

                if(neighbor.getCost() < wp.getCost()) {
                    neighbor.setParent(wp);
                    neighbor.setCost(neighbor.getWeight());
                }
            }
        }

        return null;
    }

    private WayPoint getOptimalOpenWayPoint(HashSet<WayPoint> openWayPoints) {
        WayPoint optimalWayPoint = null;

        for(WayPoint wp : openWayPoints) {
            if(optimalWayPoint == null || wp.getCost() < optimalWayPoint.getCost()) {
                optimalWayPoint = wp;
            }
        }

        return optimalWayPoint;
    }

    private double calculateCost(WayPoint parent, WayPoint wp, WayPoint dest) {
        double e = euclideanHeuristic(wp, dest);
        return e + (parent.getWeight() - wp.getWeight());
    }

    private ArrayList<WayPoint> collectWayPointNeighbors(WayPoint start, WayPoint dest, WayPoint[][] map) {
        ArrayList<WayPoint> neighbors = new ArrayList<>();

        //Add top way point
        if(start.getY() + 1 < map.length) {
            WayPoint topWayPoint = map[start.getX()][start.getY() + 1];
            topWayPoint.setCost(calculateCost(start, topWayPoint, dest));
            neighbors.add(topWayPoint);
        }

        //Add right way point
        if(start.getX() + 1 < map.length) {
            WayPoint rightWayPoint = map[start.getX() + 1][start.getY()];
            rightWayPoint.setCost(calculateCost(start, rightWayPoint, dest));
            neighbors.add(rightWayPoint);
        }

        //Add bottom way point
        if(start.getY() - 1 < map.length) {
            WayPoint bottomWayPoint = map[start.getX()][start.getY() - 1];
            bottomWayPoint.setCost(calculateCost(start, bottomWayPoint, dest));
            neighbors.add(bottomWayPoint);
        }

        //Add right way point
        if(start.getX() - 1 < map.length ) {
            WayPoint rightWayPoint = map[start.getX() - 1][start.getY()];
            rightWayPoint.setCost(calculateCost(start, rightWayPoint, dest));
            neighbors.add(rightWayPoint);
        }

        return neighbors;
    }

    /**
     * Calculates euclidean heuristic to determine the F cost of two points.
     *
     * @param start - A starting way point.
     * @param end   - The desired destination way point.
     * @return The euclidean distance between the points.
     */
    private double euclideanHeuristic(WayPoint start, WayPoint end) {
        double dx = end.getX() - start.getX();
        double dy = end.getY() - start.getY();

        return Math.sqrt(Math.pow(dx,2) + Math.pow(dy, 2));
    }
}
