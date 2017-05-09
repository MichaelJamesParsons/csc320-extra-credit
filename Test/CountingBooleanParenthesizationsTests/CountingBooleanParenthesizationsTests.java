package CountingBooleanParenthesizationsTests;

import CountingBooleanParenthesizations.CountingBooleanParenthesizations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CountingBooleanParenthesizationsTests {
    private CountingBooleanParenthesizations counter;

    @BeforeEach
    void init() {
        counter = new CountingBooleanParenthesizations();
    }

    /**
     * Example set from instructional video.
     * @link https://www.youtube.com/watch?v=OF9Lhzjrv-E
     */
    @Test
    void test1() {
        char[] symbols = {'T','T','F','T'};
        char[] operators = {'|','&','^'};

        Assertions.assertEquals(counter.count(symbols, operators), 4);
    }
}
