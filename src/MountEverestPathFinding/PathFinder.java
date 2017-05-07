package MountEverestPathFinding;

import java.util.Random;

public class PathFinder {

    public WayPoint[] findPath(int[][] weightedMap) {
        WayPoint[][] map = convertMatrixToMap(weightedMap);


        return null;
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
            wayPoint = map[random.nextInt(map.length)][map.length];
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
