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
    void TestFinalFunctionForPartTwo(){
        Assertions.assertEquals(48, Main.finalFunctionForPartTwo("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"));
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
    void TestProductOfTheSmallestAmountOfCubesForAGame(){
        Assertions.assertEquals(48, Main.productOfTheSmallestAmountOfCubesForAGame(new String[]{"3 blue, 4 red", "1 red, 2 green, 6 blue", "2 green"}));
    }

    @Test
    void TestTheSmallestAmountOfCubesForAGame(){
        Assertions.assertEquals(new int[]{1, 2, 3}, Main.theSmallestAmountOfCubesForAGame(new String[]{"3 blue, 4 red", "1 red, 2 green, 6 blue", "2 green"}));
    }

    @Test
    void TestAmountOfRedCubes(){
        Assertions.assertEquals(1, Main.amountOfRedCubes("1 red"));
        Assertions.assertEquals(2, Main.amountOfRedCubes("2 red"));
        Assertions.assertEquals(3, Main.amountOfRedCubes("3 red"));
        Assertions.assertEquals(4, Main.amountOfRedCubes("4 red"));
        Assertions.assertEquals(5, Main.amountOfRedCubes("5 red"));
        Assertions.assertEquals(6, Main.amountOfRedCubes("6 red"));
        Assertions.assertEquals(7, Main.amountOfRedCubes("7 red"));
        Assertions.assertEquals(8, Main.amountOfRedCubes("8 red"));
        Assertions.assertEquals(9, Main.amountOfRedCubes(", 9 red"));
        Assertions.assertEquals(10, Main.amountOfRedCubes("10 red"));
        Assertions.assertEquals(11, Main.amountOfRedCubes("11 red"));
        Assertions.assertEquals(12, Main.amountOfRedCubes("12 red"));
        Assertions.assertEquals(13, Main.amountOfRedCubes("13 red"));
        Assertions.assertEquals(14, Main.amountOfRedCubes("14 red"));
        Assertions.assertEquals(15, Main.amountOfRedCubes(" 15 red"));
    }

    @Test
    void TestAmountOfGreenCubes(){
        Assertions.assertEquals(1, Main.amountOfGreenCubes("1 green"));
        Assertions.assertEquals(2, Main.amountOfGreenCubes("2 green"));
        Assertions.assertEquals(3, Main.amountOfGreenCubes("3 green"));
        Assertions.assertEquals(4, Main.amountOfGreenCubes("4 green"));
        Assertions.assertEquals(5, Main.amountOfGreenCubes("5 green"));
        Assertions.assertEquals(6, Main.amountOfGreenCubes("6 green"));
        Assertions.assertEquals(7, Main.amountOfGreenCubes("7 green"));
        Assertions.assertEquals(8, Main.amountOfGreenCubes("8 green"));
        Assertions.assertEquals(9, Main.amountOfGreenCubes(" 9 green"));
        Assertions.assertEquals(10, Main.amountOfGreenCubes("10 green"));
        Assertions.assertEquals(11, Main.amountOfGreenCubes("11 green"));
        Assertions.assertEquals(12, Main.amountOfGreenCubes("12 green"));
        Assertions.assertEquals(13, Main.amountOfGreenCubes("13 green"));
        Assertions.assertEquals(14, Main.amountOfGreenCubes("14 green"));
        Assertions.assertEquals(15, Main.amountOfGreenCubes(" 15 green"));
    }

    @Test
    void TestAmountOfBlue(){
        Assertions.assertEquals(1, Main.amountOfBlueCubes("1 blue"));
        Assertions.assertEquals(2, Main.amountOfBlueCubes("2 blue"));
        Assertions.assertEquals(3, Main.amountOfBlueCubes("3 blue"));
        Assertions.assertEquals(4, Main.amountOfBlueCubes("4 blue"));
        Assertions.assertEquals(5, Main.amountOfBlueCubes("5 blue"));
        Assertions.assertEquals(6, Main.amountOfBlueCubes("6 blue"));
        Assertions.assertEquals(7, Main.amountOfBlueCubes("7 blue"));
        Assertions.assertEquals(8, Main.amountOfBlueCubes("8 blue"));
        Assertions.assertEquals(9, Main.amountOfBlueCubes(" 9 blue"));
        Assertions.assertEquals(10, Main.amountOfBlueCubes("10 blue"));
        Assertions.assertEquals(11, Main.amountOfBlueCubes("11 blue"));
        Assertions.assertEquals(12, Main.amountOfBlueCubes("12 blue"));
        Assertions.assertEquals(13, Main.amountOfBlueCubes("13 blue"));
        Assertions.assertEquals(14, Main.amountOfBlueCubes("14 blue"));
        Assertions.assertEquals(15, Main.amountOfBlueCubes(" 15 blue"));
    }

    @Test
    void TestIsRed(){
        Assertions.assertTrue(Main.IsRed("4 red"));
        Assertions.assertTrue(Main.IsRed(" 20 red"));
        Assertions.assertFalse(Main.IsRed("6 blue"));
    }

    @Test
    void TestIsBlue(){
        Assertions.assertTrue(Main.IsBlue("3 blue"));
        Assertions.assertTrue(Main.IsBlue("6 blue"));
        Assertions.assertFalse(Main.IsBlue("8 green"));
    }

    @Test
    void TestIsGreen(){
        Assertions.assertFalse(Main.IsGreen("3 blue"));
        Assertions.assertFalse(Main.IsGreen("4 red"));
        Assertions.assertTrue(Main.IsGreen("8 green"));
        Assertions.assertFalse(Main.IsGreen("20 red"));
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