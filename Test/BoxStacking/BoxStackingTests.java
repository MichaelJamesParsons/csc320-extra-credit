package BoxStacking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoxStackingTests {

    private BoxStacking stacker;

    @BeforeEach
    void init() {
        stacker = new BoxStacking();
    }

    @Test
    void testBoxStacking2() {
        Box[] boxes = new Box[]{
                new Box(4,7,9),
                new Box(5,8,9),
                new Box(11,20, 40),
                new Box(1,2,3)
        };

        Assertions.assertEquals(77, stacker.stackBoxes(boxes));
    }

    @Test
    void testBoxStacking3() {
        Box[] boxes = new Box[]{
                new Box(4,6,7),
                new Box(1,2,3),
                new Box(4,5,6),
                new Box(10,12,32)
        };

        Assertions.assertEquals(60, stacker.stackBoxes(boxes));
    }
}
