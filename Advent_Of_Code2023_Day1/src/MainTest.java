import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MainTest {
    @Test
    void TestingFinalFunction(){
        Assertions.assertEquals(13, Main.finalFunction("abcone2threexyz"));
        Assertions.assertEquals(24, Main.finalFunction( "xtwone3four"));
        Assertions.assertEquals(42, Main.finalFunction("4nineeightseven2"));
        Assertions.assertEquals(14, Main.finalFunction("zoneight234"));
        Assertions.assertEquals(76, Main.finalFunction("7pqrstsixteen"));
        Assertions.assertEquals(29, Main.finalFunction("two1nine"));
        Assertions.assertEquals(83, Main.finalFunction("eightwothree"));
        Assertions.assertEquals(11, Main.finalFunction("one"));
        Assertions.assertEquals(11, Main.finalFunction("1"));


        Assertions.assertEquals(51, Main.finalFunction("sq5fivetwothree1"));
        Assertions.assertEquals(65, Main.finalFunction("six5gc"));
        Assertions.assertEquals(35, Main.finalFunction("txb3qfzsbzbxlzslfourone1vqxgfive"));
        Assertions.assertEquals(75, Main.finalFunction("cseven7nqqxnkzngndtddfiverkxkxqjjsr"));
        Assertions.assertEquals(24, Main.finalFunction("2lvpmzh4"));
    }

    @Test
    void TestingSearchingForNums(){
        Assertions.assertTrue(Main.searchForNums("abcone2threexyz").equals("abc123xyz"));
        Assertions.assertTrue(Main.searchForNums("xtwone3four").equals("x2ne34"));
        Assertions.assertTrue(Main.searchForNums("4nineeightseven2").equals("49872"));
        Assertions.assertTrue(Main.searchForNums("zoneight234").equals("z1ight234"));
        Assertions.assertTrue(Main.searchForNums("7pqrstsixteen").equals("7pqrst6teen"));
        Assertions.assertTrue(Main.searchForNums("two1nine").equals("219"));
        Assertions.assertTrue(Main.searchForNums("eightwothree").equals("8wo3"));
    }

    @Test
    void TestingNumsToDigits(){
        Assertions.assertTrue(Main.numToDigits("one").equals("1"));
        Assertions.assertTrue(Main.numToDigits("two").equals("2"));
        Assertions.assertTrue(Main.numToDigits("three").equals("3"));
        Assertions.assertTrue(Main.numToDigits("four").equals("4"));
        Assertions.assertTrue(Main.numToDigits("five").equals("5"));
        Assertions.assertTrue(Main.numToDigits("six").equals("6"));
        Assertions.assertTrue(Main.numToDigits("seven").equals("7"));
        Assertions.assertTrue(Main.numToDigits("eight").equals("8"));
        Assertions.assertTrue(Main.numToDigits("nine").equals("9"));

        Assertions.assertTrue(Main.numToDigits("two1nine").equals("219"));
        Assertions.assertTrue(Main.numToDigits("eighttwo").equals("82"));
        Assertions.assertTrue(Main.numToDigits("threefour").equals("34"));
        Assertions.assertTrue(Main.numToDigits("fivesix").equals("56"));

    }

    @Test
    void TestingExtractingDigitsToString(){
        Assertions.assertTrue(Main.extractDigitsToString("4one5twoxqfcflcbjqsixeightdlknnzdbzlrqfkhvm").equals("45"));
        Assertions.assertTrue(Main.extractDigitsToString("44kmn").equals("44"));
        Assertions.assertTrue(Main.extractDigitsToString("rlxrbhtwobmhfcgnmtg6zlgz95sncg").equals("695"));
    }

    @Test
    void TestingExtractingDigitsToIntArr(){
        Assertions.assertArrayEquals(new int[]{4, 5}, Main.extractDigitsToIntArr("4one5twoxqfcflcbjqsixeightdlknnzdbzlrqfkhvm"));
        Assertions.assertArrayEquals(new int[]{4, 4}, Main.extractDigitsToIntArr("44kmn"));
        Assertions.assertArrayEquals(new int[]{6,9,5}, Main.extractDigitsToIntArr("rlxrbhtwobmhfcgnmtg6zlgz95sncg"));
    }

    @Test
    void TestingFirstAndLastInAnArray(){
        Assertions.assertEquals(19, Main.firstAndLastInAnArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        Assertions.assertEquals(69, Main.firstAndLastInAnArray(new int[]{6, 3, 3, 4, 5, 6, 33, 8, 9}));

    }

}