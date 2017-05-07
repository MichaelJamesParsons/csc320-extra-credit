package TravelingSalesman;
import java.util.*;

public class TravelingSalesman {

    public int[] calculateRoute(int[][] matrix) {
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

        for(int k = 0; k <= matrix.length - 1; k++) {
            for(HashSet<Integer> subset : powerSet) {
                for(int i = 1; i < matrix.length; i++) {
                    if(subset.contains(i) || subset.size() == 0) {
                        continue;
                    }

                    if(subset.size() == 1 && subset.contains(3)) {
                        int breakt = 1;
                    }

                    int minVal = Integer.MAX_VALUE;
                    int min = Integer.MAX_VALUE;
                    for(Integer j : subset) {
                        int c = matrix[i][j] + D[j][map.get(subset) - j];

                        if(c < min) {
                            min = c;
                            minVal = j;
                        }
                    }

                    D[i][map.get(subset)] = min;
                    P[i][map.get(subset)] = minVal;
                }
            }
        }

        /*int minVal = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for(int j = 1; j < matrix.length; j++) {
            int tmpMin = matrix[1][j] + D[j][]
        }*/

        printDMatrix(map, matrix.length, D);

        return null;
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
        ArrayList<ArrayList<Integer>> powerSet = new ArrayList<>();
        int numSubSets = 1 << size;

        for(int i = 1; i < numSubSets; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            int mask = 1;

            for(int j = 1; j < size; j++) {
                if((mask & i) != 0) {
                    tmp.add(j);
                }

                mask = mask << 1;
            }

            powerSet.add(tmp);
        }
/*
        Collections.sort(powerSet, new Comparator<ArrayList>(){
            public int compare(ArrayList a1, ArrayList a2) {
                return a2.size() - a1.size(); // assumes you want biggest to smallest
            }
        });*/

        return null;
    }
}