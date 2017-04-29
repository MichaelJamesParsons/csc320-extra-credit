package BuildingBridges;

/**
 *  Implementation of building bridges problem.
 *
 *  @link https://people.cs.clemson.edu/~bcdean/dp_practice/dp_6.swf
 */
class BuildingBridges {

    /**
     * Calculates the longest sequence of bridges that may be built without crossing paths.
     *
     * O(n^2)
     *
     * @param topBridges    - An unordered list of bridges.
     * @param bottomBridges - An ordered list of bridges where each index corresponds to a bridge in the first list.
     *
     * @return Longest sequence of bridges.
     * @throws Exception - Thrown if number of top bridges is not equal to the number of bottom bridges.
     */
    int[] build(int[] topBridges, int[] bottomBridges) throws Exception {
        if(topBridges.length != bottomBridges.length) {
            throw new Exception("Length of top bridges must match length of bottom bridges.");
        }

        if(topBridges.length == 1) {
            return topBridges;
        }

        //Sort top bridges, mapping the bridge id (x) to its unordered position in
        //the top bridges list.
        int[] orderedTopBridges = new int[topBridges.length];
        for(int x = 0; x < topBridges.length; x++) {
            orderedTopBridges[topBridges[x]] = x;
        }

        int longestSequenceIndex = 0;
        int[] longestSequence = new int[topBridges.length];

        int tmpIndex;
        int[] tmp;

        for(int x = 0; x < bottomBridges.length; x++) {
            tmpIndex = 0;
            tmp = new int[topBridges.length];
            tmp[tmpIndex] = x;

            for(int y = x + 1; y < bottomBridges.length; y++) {
                if(y == x) {
                    continue;
                }

                if(orderedTopBridges[y] > orderedTopBridges[tmp[tmpIndex]]) {
                    tmpIndex++;
                    tmp[tmpIndex] = y;
                }
            }

            if(tmpIndex > longestSequenceIndex) {
                longestSequenceIndex = tmpIndex;
                longestSequence = tmp;
            }
        }

        return getSequenceFromAnswer(longestSequence, longestSequenceIndex);
    }

    /**
     * Truncates unused spaces in the answer array.
     *
     * @param answer - The sequence of bridges.
     * @param index - The last index of answer with a valid value.
     *
     * @return The maximum number of bridges that can be built.
     */
    private int[] getSequenceFromAnswer(int[] answer, int index) {
        int[] sequence = new int[index + 1];
        System.arraycopy(answer, 0, sequence, 0, sequence.length);
        return sequence;
    }

}
