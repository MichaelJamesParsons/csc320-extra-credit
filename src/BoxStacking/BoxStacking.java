package BoxStacking;

import java.util.Arrays;

public class BoxStacking {

    public void stackBoxes(Box[] boxes) {
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

        outerLoop:
        for(int i = 1; i < maxHeights.length; i++) {
            for(int j = 0; j < maxHeights.length; j++) {
                if(boxVariations[i].getBaseArea() >= boxVariations[j].getBaseArea()) {
                    continue outerLoop;
                }

                maxHeights[i] = maxHeights[i] + maxHeights[j];
                result[i] = j;
                j++;
            }
        }
        /*int tallestSequenceIndex = 0;
        Box[] tallestSequence = new Box[boxes.length];

        for(int x = 0; x < boxes.length; x++) {
            int tmpIndex = 0;
            Box[] tmp = new Box[boxes.length];
        }*/

    }

    private Box[] buildBoxVariations(Box[] baseBoxes) {
        Box[] boxVariations = new Box[baseBoxes.length*3];

        for(int x = 0; x < baseBoxes.length; x += 3) {
            boxVariations[x] = baseBoxes[x];
            boxVariations[x+1] = new Box( baseBoxes[x].getHeight(), baseBoxes[x].getWidth(), baseBoxes[x].getLength());
            boxVariations[x+2] = new Box(baseBoxes[x].getHeight(), baseBoxes[x].getLength(), baseBoxes[x].getWidth());
        }

        return boxVariations;
    }
}
