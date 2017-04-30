package BoxStacking;

import java.util.Arrays;

class BoxStacking {

    int stackBoxes(Box[] boxes) {
        Box[] boxVariations = buildBoxVariations(boxes);
        Arrays.sort(boxVariations);

        int[] maxHeights = new int[boxVariations.length];
        int[] result = new int[boxVariations.length];

        for(int x = 0; x < boxVariations.length; x++) {
            maxHeights[x] = boxVariations[x].getHeight();
        }

        for(int x = 0; x < boxVariations.length; x++) {
            result[x] = x;
        }

        for(int i = 1; i < maxHeights.length; i++) {
            for(int j = 0; j < maxHeights.length; j++) {
                if(boxVariations[i].getLength() >= boxVariations[j].getLength() ||
                        boxVariations[i].getWidth() >= boxVariations[j].getWidth()) {
                    break;
                }

                maxHeights[i] = boxVariations[i].getHeight() + maxHeights[j];
                result[i] = j;
            }
        }

        return maxHeights[maxHeights.length - 1];
    }

    private Box[] buildBoxVariations(Box[] baseBoxes) {
        Box[] boxVariations = new Box[baseBoxes.length*3];

        for(int x = 0; x < baseBoxes.length; x++) {
            boxVariations[x] = baseBoxes[x];
            boxVariations[x + baseBoxes.length] = new Box(
                    baseBoxes[x].getWidth(),
                    Math.min(baseBoxes[x].getHeight(), baseBoxes[x].getLength()),
                    Math.max(baseBoxes[x].getHeight(), baseBoxes[x].getLength())
            );
            boxVariations[x + baseBoxes.length*2] = new Box(
                baseBoxes[x].getLength(),
                Math.min(baseBoxes[x].getHeight(), baseBoxes[x].getWidth()),
                Math.max(baseBoxes[x].getHeight(), baseBoxes[x].getWidth())
            );
        }

        return boxVariations;
    }
}
