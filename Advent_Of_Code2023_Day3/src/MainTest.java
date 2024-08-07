import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MainTest {

//    @Test
//    void TestMain() {
//    }

    @Test
    public void TestIsAPartNumber(){
        String[][] matrix = {
                {".", ".", "."},
                {".", "1", "."},
                {".", ".", "."}
        };
        Assert.assertFalse(
                Main.IsAPartNumber(matrix, 1, 1)
        );
        String[][] matrix1 = {
                {".", ".", "."},
                {"1", ".", "."},
                {".", ".", "."}
        };
        Assert.assertFalse(
                Main.IsAPartNumber(matrix1, 1, 0)
        );

        String[][] matrix2 = {
                {"$", "#", "@"},
                {"*", "1", "%"},
                {"-", "=", "+"}
        };
        Assert.assertTrue(
                Main.IsAPartNumber(matrix2, 1, 1)
        );
        String[][] matrix3 = {
                {"$", "#", "@"},
                {"*", "%", "1"},
                {"-", "=", "+"}
        };
        Assert.assertTrue(
                Main.IsAPartNumber(matrix3, 1, 2)
        );


    }

    @Test
    public void TestStringWithSymbolsDotsAndNumbersToStrArray(){
        Assert.assertEquals(new String[]{"467", ".", ".", "114", ".", ".", "."},
                Main.StringWithSymbolsDotsAndNumbersToStrArray("467..114..."));

        Assert.assertEquals(new String[]{".", ".", ".", "."},
                Main.StringWithSymbolsDotsAndNumbersToStrArray("...."));

        Assert.assertEquals(new String[]{".", ".", "46", ".", "."},
                Main.StringWithSymbolsDotsAndNumbersToStrArray("..46.."));


    }

    @Test
    public void TestConvertArrayListStringToStringArray(){
        ArrayList<String> arrayList0 = new ArrayList<>(Arrays.asList("dupa"));
        String[] stringArray0 = new String[]{"dupa"};
        Assert.assertEquals(stringArray0, Main.ConvertArrayListStringToStringArray(arrayList0));

        ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList("467", ".", ".", "114", ".", "."));
        String[] stringArray1 = new String[]{"467", ".", ".", "114", ".", "."};
        Assert.assertEquals(stringArray1, Main.ConvertArrayListStringToStringArray(arrayList1));
    }

    @Test
    public void TestSumAllNumbersInAnArray(){
        Assert.assertEquals(Main.SumAllNumbersInAnArray(new int[]{99, 1}), 100);
        Assert.assertEquals(Main.SumAllNumbersInAnArray(new int[]{467, 35, 633, 617, 592, 755, 664, 598}), 4361);
    }

    @Test
    public void TestIsASymbol(){
        Assert.assertFalse(Main.IsASymbol("1"));
        Assert.assertFalse(Main.IsASymbol("2"));
        Assert.assertFalse(Main.IsASymbol("3"));
        Assert.assertFalse(Main.IsASymbol("4"));
        Assert.assertFalse(Main.IsASymbol("5"));
        Assert.assertFalse(Main.IsASymbol("6"));
        Assert.assertFalse(Main.IsASymbol("7"));
        Assert.assertFalse(Main.IsASymbol("8"));
        Assert.assertFalse(Main.IsASymbol("9"));
        Assert.assertFalse(Main.IsASymbol("0"));
        Assert.assertFalse(Main.IsASymbol("."));
        Assert.assertFalse(Main.IsASymbol("^"));
        Assert.assertFalse(Main.IsASymbol("!"));
        Assert.assertFalse(Main.IsASymbol("("));
        Assert.assertFalse(Main.IsASymbol(")"));

        Assert.assertTrue(Main.IsASymbol("@"));
        Assert.assertTrue(Main.IsASymbol("#"));
        Assert.assertTrue(Main.IsASymbol("$"));
        Assert.assertTrue(Main.IsASymbol("%"));
        Assert.assertTrue(Main.IsASymbol("&"));
        Assert.assertTrue(Main.IsASymbol("*"));
        Assert.assertTrue(Main.IsASymbol("-"));
        Assert.assertTrue(Main.IsASymbol("+"));
        Assert.assertTrue(Main.IsASymbol("="));
    }

    @Test
    public void TestIsANumber(){
        Assert.assertTrue(Main.IsANumber("0"));
        Assert.assertTrue(Main.IsANumber("1"));
        Assert.assertTrue(Main.IsANumber("2"));
        Assert.assertTrue(Main.IsANumber("3"));
        Assert.assertTrue(Main.IsANumber("4"));
        Assert.assertTrue(Main.IsANumber("5"));
        Assert.assertTrue(Main.IsANumber("6"));
        Assert.assertTrue(Main.IsANumber("7"));
        Assert.assertTrue(Main.IsANumber("8"));
        Assert.assertTrue(Main.IsANumber("9"));
        Assert.assertTrue(Main.IsANumber("10"));
        Assert.assertTrue(Main.IsANumber("999"));

        Assert.assertFalse(Main.IsANumber("asdf"));
        Assert.assertFalse(Main.IsANumber("--"));
        Assert.assertFalse(Main.IsANumber("="));
        Assert.assertFalse(Main.IsANumber("a"));
        Assert.assertFalse(Main.IsANumber("99-99"));
        Assert.assertFalse(Main.IsANumber("99-98"));
        Assert.assertFalse(Main.IsANumber("dsfasdfas 45546456 sadfasdfadsfgas"));
        Assert.assertFalse(Main.IsANumber("[]"));
    }

    @Test
    public void TestIsOnTheRightEdgeOfTheMatrix(){
        String[][] matrix = {
                {".", ".", "."},
                {".", "1", "."},
                {".", ".", "."}
        };
        Assert.assertFalse(Main.IsOnTheRightEdgeOfTheMatrix(matrix, 1, 1));

        String[][] matrix1 = {
                {".", ".", "."},
                {"1", ".", "."},
                {".", ".", "."}
        };
        Assert.assertFalse(Main.IsOnTheRightEdgeOfTheMatrix(matrix1, 0, 1));

        String[][] matrix2 = {
                {"$", "#", "@"},
                {"*", "%", "34"},
                {"-", "=", "+"}
        };
        Assert.assertTrue(Main.IsOnTheRightEdgeOfTheMatrix(matrix2, 1, 2));
    }

    @Test
    public void TestIsOnTheLeftEdgeOfTheMatrix(){
        String[][] matrix = {
                {".", ".", "."},
                {".", "1", "."},
                {".", ".", "."}
        };
        Assert.assertFalse(Main.IsOnTheLeftEdgeOfTheMatrix(1));

        String[][] matrix1 = {
                {".", ".", "."},
                {"1", ".", "."},
                {".", ".", "."}
        };
        Assert.assertTrue(Main.IsOnTheLeftEdgeOfTheMatrix(0));

        String[][] matrix2 = {
                {"$", "#", "@"},
                {"*", "%", "34"},
                {"-", "=", "+"}
        };
        Assert.assertFalse(Main.IsOnTheLeftEdgeOfTheMatrix(2));
    }
}
