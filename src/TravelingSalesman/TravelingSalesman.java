package TravelingSalesman;

import java.util.HashMap;
import java.util.HashSet;

public class TravelingSalesman {

    public int[] calculateRoute(int[][] matrix) {
        HashSet<HashSet<Integer>> powerSet = getPowerSet(matrix.length);

        HashMap<HashSet<Integer>, Integer> map = new HashMap<>();
        int[][] M = new int[matrix.length][powerSet.size()];
        int[][] D = new int[matrix.length][powerSet.size()];

        for(int i = 0; i < powerSet.size(); i++) {
            //map.put();
        }

        return null;
    }

    /**
     * Calculate power set
     *
     * This technique was inspired by an article written by GeeksForGeeks.
     * @link http://www.geeksforgeeks.org/power-set/
     *
     * Generates:
     *  {1}
     *  {2}
     *  {3}
     *  {1,2}
     *  {1,3}
     *  {2,3}
     *  {1,2,3}
     */
    HashSet<HashSet<Integer>> getPowerSet(int size) {
        HashSet<HashSet<Integer>> powerSet = new HashSet<>();

        int numSubSets = 1 << size;

        for(int i = 0; i < numSubSets; i++) {
            HashSet<Integer> tmp = new HashSet<>();
            int mask = 1;

            for(int j = 0; j < size; j++) {
                if((mask&i) != 0) {
                    tmp.add(i);
                }

                mask = mask << 1;
            }

            powerSet.add(tmp);
        }

        return powerSet;
    }
}
