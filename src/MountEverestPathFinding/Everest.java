package MountEverestPathFinding;


import java.util.Random;

/**
 * NOTICE: Due to time constraints, I was unable to complete this assignment. The partial algorithm is a
 *         variation of the A* algorithm, tweaked to calculate cost using the distance of way points instead
 *         of a constant as used in the traditional implementation.
 */
public class Everest {

    private PathFinder pathFinder;

    public Everest() {
        this.pathFinder = new PathFinder();
    }

    public WayPoint[] findPath(WayPoint[][] map, WayPoint start, WayPoint finish) {
        return pathFinder.findPath(map, start, finish);
    }

    public WayPoint[] findPathFromRandomPointToFinish(WayPoint[][] map, WayPoint finish) {

        // A* implementation
        return pathFinder.findPath(map, getRandomPosition(map, finish), finish);
    }

    /**
     * Finds a random waypoint in a given map.
     *
     * @param map       - A matrix of way points.
     * @param exclude   - A specific way point to exclude. The calculated way point must not exist at the same
     *                    coordinates as this point.
     * @return          - A random way point.
     */
    private WayPoint getRandomPosition(WayPoint[][] map, WayPoint exclude) {
        WayPoint wayPoint = null;
        Random random = new Random();

        while(wayPoint == null || wayPoint.getX() == exclude.getX() && wayPoint.getY() == exclude.getY()) {
            wayPoint = map[random.nextInt(map.length-1)][map.length-1];
        }

        return wayPoint;
    }

    /**
     * Converts a map of weights to a matrix of WayPoints.
     *
     * @param map   - A matrix of weights.
     * @return      - A matrix of way points.
     */
    public WayPoint[][] convertMatrixToMap(int[][] map) {
        WayPoint[][] wayPointMap = new WayPoint[map.length][map.length];

        for(int y = 0; y < map.length; y++) {
            for(int x = 0; x < map.length; x++) {
                wayPointMap[y][x] = new WayPoint(map[y][x], x, y);
            }
        }

        return wayPointMap;
    }
}
