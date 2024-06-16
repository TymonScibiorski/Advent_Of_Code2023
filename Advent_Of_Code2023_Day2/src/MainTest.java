import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void TestFinalFunction(){
        Assertions.assertEquals(1, Main.finalFunctionForPartOne("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"));
        Assertions.assertEquals(2, Main.finalFunctionForPartOne("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"));
        Assertions.assertEquals(5, Main.finalFunctionForPartOne("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"));

        Assertions.assertEquals(0, Main.finalFunctionForPartOne("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red"));
        Assertions.assertEquals(0, Main.finalFunctionForPartOne("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red"));
    }

    @Test
    void TestIsPossible(){
        Assertions.assertTrue(Main.isPossible("3 blue, 4 red"));
        Assertions.assertTrue(Main.isPossible("1 red, 2 green, 6 blue"));
        Assertions.assertTrue(Main.isPossible("2 green"));
        Assertions.assertTrue(Main.isPossible("1 blue"));
        Assertions.assertTrue(Main.isPossible("2 green"));
        Assertions.assertTrue(Main.isPossible("3 green, 4 blue, 1 red"));
        Assertions.assertTrue(Main.isPossible("1 green, 1 blue"));
        Assertions.assertTrue(Main.isPossible("6 red, 1 blue, 3 green"));
        Assertions.assertTrue(Main.isPossible("2 blue, 1 red, 2 green"));
        Assertions.assertTrue(Main.isPossible("5 blue, 4 red, 13 green"));
        Assertions.assertTrue(Main.isPossible("5 green, 1 red"));
        Assertions.assertFalse(Main.isPossible("8 green, 6 blue, 20 red"));
        Assertions.assertFalse(Main.isPossible("15 blue, 14 red"));
    }

    @Test
    void TestIsRed(){
        Assertions.assertTrue(Main.IsRed("4 red"));
        Assertions.assertTrue(Main.IsRed("20 red"));
        Assertions.assertFalse(Main.IsRed("6 blue"));
    }

    @Test
    void TestIsBlue(){
        Assertions.assertTrue(Main.IsBlue(new String[]{"3 blue", "4 red"}, 0));
        Assertions.assertTrue(Main.IsBlue(new String[]{"8 green", "6 blue", "20 red"}, 1));
        Assertions.assertFalse(Main.IsBlue(new String[]{"8 green", "6 blue", "20 red"}, 0));
    }

    @Test
    void TestIsGreen(){
        Assertions.assertFalse(Main.IsGreen(new String[]{"3 blue", "4 red"}, 0));
        Assertions.assertTrue(Main.IsGreen(new String[]{"8 green", "6 blue", "20 red"}, 0));
        Assertions.assertFalse(Main.IsGreen(new String[]{"8 green", "6 blue", "20 red"}, 2));
    }


    @Test
    void TestSplitAtColons(){
        Assertions.assertArrayEquals(new String[]{"Game 2", "1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"},
                Main.splitAtColons("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"));
    }

    @Test
    void TestSplitAtSemicolons() {
        Assertions.assertArrayEquals(new String[]{"3 blue, 4 red", "1 red, 2 green, 6 blue", "2 green"}, Main.splitAtSemicolons("3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"));
        Assertions.assertArrayEquals(new String[]{"1 blue, 2 green", "3 green, 4 blue, 1 red", "1 green, 1 blue"}, Main.splitAtSemicolons("1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"));
    }

    @Test
    void TestGetID(){
        Assertions.assertEquals(1, Main.getID("Game 1"));
        Assertions.assertEquals(2, Main.getID("Game 2"));
        Assertions.assertEquals(3, Main.getID("Game 3"));
        Assertions.assertEquals(4, Main.getID("Game 4"));
        Assertions.assertEquals(5, Main.getID("Game 5"));
        Assertions.assertEquals(6, Main.getID("Game 6"));
        Assertions.assertEquals(7, Main.getID("Game 7"));
        Assertions.assertEquals(8, Main.getID("Game 8"));
        Assertions.assertEquals(9, Main.getID("Game 9"));
        Assertions.assertEquals(10, Main.getID("Game 10"));
    }
}