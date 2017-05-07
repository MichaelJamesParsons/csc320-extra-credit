package MountEverestPathFinding;

import java.util.*;

public class PathFinder {

    public WayPoint[] findPath(WayPoint[][] map, WayPoint start, WayPoint end) {
        LinkedHashSet<WayPoint> open = new LinkedHashSet();
        HashSet<WayPoint> closed = new HashSet<>();

        //Add initial point to open set.
        open.add(start);

        //While there are positions to search.
        while(open.size() > 0) {

        }

        return null;
    }

    /**
     * 
     * @param start
     * @param open
     * @param closed
     * @param map
     */
    private void collectNeighboringWayPoints(WayPoint start, Set<WayPoint> open, Set<WayPoint> closed, WayPoint[][] map) {
        //Add top way point
        if(start.getY() + 1 < map.length && !open.contains(map[start.getX()][start.getY() + 1])) {
            open.add(map[start.getX()][start.getY() + 1]);
        }

        //Add right way point
        if(start.getX() + 1 < map.length && !open.contains(map[start.getX() + 1][start.getY()])) {
            open.add(map[start.getX() + 1][start.getY()]);
        }

        //Add bottom way point
        if(start.getY() - 1 < map.length && !open.contains(map[start.getX()][start.getY() - 1])) {
            open.add(map[start.getX()][start.getY() - 1]);
        }

        //Add right way point
        if(start.getX() - 1 < map.length && !open.contains(map[start.getX() - 1][start.getY()])) {
            open.add(map[start.getX() - 1][start.getY()]);
        }
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
