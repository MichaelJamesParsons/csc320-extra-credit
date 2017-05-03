package EditDistance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EditDistanceTests {

    private EditDistance diff;

    private final int COST_INSERT  = 1;
    private final int COST_DELETE  = 1;
    private final int COST_REPLACE = 1;

    @BeforeEach
    void init() {
        diff = new EditDistance();
    }

    /**
     * Regular example (all costs = 1)
     *
     * Problem set used in online example.
     *
     * https://www.youtube.com/watch?v=We3YDTzNXEk
     */
    @Test
    void testProblemSet1() {
        String a = "azced";
        String b = "abcdef";

        Assertions.assertEquals(3, diff.calculate(a,b, COST_INSERT, COST_DELETE, COST_REPLACE));
    }

    /**
     * Levenshtein example (insert/delete = 1, replace = 2)
     *
     * Problem set used in online example.
     *
     * https://www.youtube.com/watch?v=We3YDTzNXEk
     */
    @Test
    void testProblemSet2() {
        String a = "intention";
        String b = "execution";

        Assertions.assertEquals(8, diff.calculate(a,b, COST_INSERT, COST_DELETE, 2));
    }
}
