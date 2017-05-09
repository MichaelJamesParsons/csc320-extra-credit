package TravelingSalesman;
import java.util.*;

public class TravelingSalesman {

    public int[] calculateRoute(int[][] matrix) {
        //Calculate power set
        HashSet<HashSet<Integer>> powerSet = getPowerSet(matrix.length);

        HashMap<HashSet<Integer>, Integer> map = new HashMap<>();
        int[][] P = new int[matrix.length][powerSet.size()];
        int[][] D = new int[matrix.length][powerSet.size()];

        //Fill empty sets
        int z = 0;
        for(HashSet<Integer> subset : powerSet) {
            if(subset.size() == 1) {
                int value = subset.iterator().next();
                D[value][0] = matrix[value][0];
            }

            map.put(subset, z);
            z++;
        }

        int pSetCount = 0;
        HashSet<Integer> lastSet = null;
        for(int k = 0; k <= matrix.length - 1; k++) {
            for(HashSet<Integer> subset : powerSet) {
                for(int i = 1; i < matrix.length; i++) {
                    if(subset.contains(i) || subset.size() == 0) {
                        continue;
                    }

                    int minVal = Integer.MAX_VALUE;
                    int min = Integer.MAX_VALUE;
                    for(Integer j : subset) {
                        int d = map.get(subset) - j - ((subset.size() > 1) ? 1 : 0);
                        int c = matrix[i][j] + D[j][d];

                        if(c < min) {
                            min = c;
                            minVal = j;
                        }
                    }

                    D[i][map.get(subset)] = min;
                    P[i][map.get(subset)] = minVal;
                }

                pSetCount++;

                if(pSetCount == powerSet.size()) {
                    lastSet = subset;
                }
            }
        }

        //Print out D and P matrix
        printDMatrix(map, matrix.length, D);
        System.out.println("\n");
        printDMatrix(map, matrix.length, P);


        //Find min D and P values
        System.out.print("Finding min of: ");

        int minVal = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        assert lastSet != null;
        for(Integer s : lastSet) {
            int mappedPos = map.get(findSubSetInPowerSet(powerSet, lastSet, s));
            int tmpMin = matrix[1][s] + D[1][mappedPos];
            int tmpVal = P[1][mappedPos];

            System.out.print(tmpMin + ",");

            if(min > tmpMin) {
                min = tmpMin;
                minVal = tmpVal;
            }
        }

        System.out.println("\nMin is " + min);
        System.out.println("P = " + minVal);

        return null;
    }

    HashSet<Integer> findSubSetInPowerSet(HashSet<HashSet<Integer>> powerset, HashSet<Integer> currSet, Integer exclude) {
        HashSet<Integer> clone = (HashSet<Integer>) currSet.clone();
        clone.remove(exclude);
        HashSet<Integer> subset = null;

        for(HashSet<Integer> s : powerset) {
            if(s.containsAll(clone)) {
                subset = s;
                break;
            }
        }

        return subset;
    }

    void printDMatrix(HashMap<HashSet<Integer>, Integer> map, int wLen, int[][] D) {
        for(HashSet<Integer> entry : map.keySet()) {
            System.out.print("   {");
            int z = 0;
            for(Integer key : entry) {
                System.out.print(key);

                if(z != entry.size() - 1) {
                    System.out.print(",");
                }

                z++;
            }
            System.out.print("} ");
        }

        System.out.println();

        for(int i = 1; i < wLen; i++) {
            for(HashSet<Integer> j : map.keySet()) {
                String val = (D[i][map.get(j)] >= 99) ? "inf" : D[i][map.get(j)] + "";
                System.out.print("|\t" + val + "\t");
            }
            System.out.println();
        }
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

        for(int i = 1; i < numSubSets; i++) {
            HashSet<Integer> tmp = new HashSet<>();
            int mask = 1;

            for(int j = 1; j < size; j++) {
                if((mask & i) != 0) {
                    tmp.add(j);
                }

                mask = mask << 1;
            }

            powerSet.add(tmp);
        }

        ArrayList<HashSet<Integer>> tmp = new ArrayList<>();
        tmp.addAll(powerSet);
        tmp.sort((o1, o2) -> o1.size() > o2.size() ? 1 : -1);

        powerSet = new HashSet<>();
        powerSet.addAll(tmp);

        return powerSet;
    }
    
}
