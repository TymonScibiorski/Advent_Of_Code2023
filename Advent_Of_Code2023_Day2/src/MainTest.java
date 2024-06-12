import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void TestSplitAtColons(){
        Assertions.assertArrayEquals(new String[]{"Game 2", "1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"}, Main.splitAtColons("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"));
    }

    @Test
    void TestSplitAtSemicolons() {
        Assertions.assertArrayEquals(new String[]{"3 blue, 4 red", "1 red, 2 green, 6 blue", "2 green"}, Main.splitAtSemicolons("3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"));
        Assertions.assertArrayEquals(new String[]{"1 blue, 2 green", "3 green, 4 blue, 1 red", "1 green, 1 blue"}, Main.splitAtSemicolons("1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"));
    }
}