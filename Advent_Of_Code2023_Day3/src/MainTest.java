import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MainTest {

//    @Test
//    void TestMain() {
//    }

    @Test
    public void TestCreateMatrix(){
        String[][] matrix = Main.createMatrix();
        boolean isFilledWithNulls = true;

        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i] != null){
                isFilledWithNulls = false;
            }
        }

        Assert.assertEquals(matrix.length, 140);
        Assert.assertTrue(isFilledWithNulls);
    }

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

        String[][] matrix4 = {
                {".", "423", "."},
                {".", ".", ".", ".", "."}
        };
        Assert.assertFalse(
                Main.IsAPartNumber(matrix4, 0, 1)
        );

        String[][] matrix5 = {
                {".", "423", "."},
                {".", ".", "%", ".", "."}
        };
        Assert.assertTrue(
                Main.IsAPartNumber(matrix5, 0, 1)
        );

        String[][] matrix6 = {
                {"$", ".", "1"},
                {"*", ".", "@"},
                {"-", "=", "+"}
        };
        Assert.assertTrue(
                Main.IsAPartNumber(matrix6, 0, 2)
        );
    }

    @Test
    public void TestExtractSurroundings(){
//        String[][] matrix = {
//                {"$", ".", "1"},
//                {"*", ".", "@"},
//                {"-", "=", "+"}
//        };
//        Stack<String> expectedStack = new Stack<>();
//        expectedStack.push("$");
//        expectedStack.push(".");
//        expectedStack.push("1");
//        expectedStack.push("*");
//        expectedStack.push("@");
//        expectedStack.push("-");
//        expectedStack.push("=");
//        expectedStack.push("+");
//        Stack<String> actualStack = ExtractSurroundings.ExtractSurroundings(matrix, 1, 1);
//        boolean forAssertion0 = true;
//
//        for(int i = 0; i < expectedStack.size(); i++){
//            String currentStringFromActualStack = actualStack.pop();
//            String currentStringFromExpectedStack = expectedStack.pop();
//            if(!currentStringFromExpectedStack.equals(currentStringFromActualStack)){
//                forAssertion0 = false;
//                break;
//            }
//        }
//        Assert.assertTrue(forAssertion0);

        String[][] matrix1 = {
                {"$", "46", "1"},
                {"*", ".", "@", "5"},
                {"-", "=", "+", "."}
        };
        Stack<String> expectedStack1 = new Stack<>();
        expectedStack1.push("$");
        expectedStack1.push("46");
        expectedStack1.push("*");
        expectedStack1.push("@");
        expectedStack1.push("-");
        expectedStack1.push("=");
        expectedStack1.push("+");
        Stack<String> actualStack1 = ExtractSurroundings.ExtractSurroundings(matrix1, 1, 1);
        boolean forAssertion1 = true;

        for(int i = 0; i < expectedStack1.size(); i++){
            String currentStringFromActualStack = actualStack1.pop();
            String currentStringFromExpectedStack = expectedStack1.pop();
            if(!currentStringFromExpectedStack.equals(currentStringFromActualStack)){
                forAssertion1 = false;
                break;
            }
        }
        Assert.assertTrue(forAssertion1);
    }

    @Test
    public void TestExtractLineAboveInMatrix() {
        String[][] matrix = {
                {"$", ".", "1"},
                {"*", ".", "@"},
                {"-", "=", "+"}
        };
        Stack<String> expectedStack = new Stack<>();
        expectedStack.push("$");
        expectedStack.push(".");
        expectedStack.push("1");
        Stack<String> actualStack = ExtractSurroundings.ExtractLineAboveInMatrix(matrix, 1, 1);
        boolean forAssertion0 = true;

        for (int i = 0; i < expectedStack.size(); i++) {
            String currentStringFromActualStack = actualStack.pop();
            String currentStringFromExpectedStack = expectedStack.pop();
            if (!currentStringFromExpectedStack.equals(currentStringFromActualStack)) {
                forAssertion0 = false;
                break;
            }
        }
        Assert.assertTrue(forAssertion0);

        String[][] matrix1 = {
                {"$", "46", "1"},
                {"*", ".", "@", "5"},
                {"-", "=", "+", "."}
        };
        Stack<String> expectedStack1 = new Stack<>();
        expectedStack1.push("$");
        expectedStack1.push("46");
        Stack<String> actualStack1 = ExtractSurroundings.ExtractLineAboveInMatrix(matrix1, 1, 1);
        boolean forAssertion1 = true;

        for (int i = 0; i < expectedStack1.size(); i++) {
            String currentStringFromExpectedStack = expectedStack1.pop();
            String currentStringFromActualStack = actualStack1.pop();
            if (!currentStringFromExpectedStack.equals(currentStringFromActualStack)) {
                forAssertion1 = false;
                break;
            }
        }
        Assert.assertTrue(forAssertion1);
    }

    @Test
    public void TestExtractTopLeftDiagonalInMatrix() {
        String[][] matrix = {
                {"$", ".", "1"},
                {"*", ".", "@"},
                {"-", "=", "+"}
        };
        Assert.assertEquals("$", ExtractSurroundings.ExtractTopLeftDiagonalInMatrix(matrix, 1, 1));
        Assert.assertNull(ExtractSurroundings.ExtractTopLeftDiagonalInMatrix(matrix, 0, 1));
        Assert.assertNull(ExtractSurroundings.ExtractTopLeftDiagonalInMatrix(matrix, 1, 0));
    }

    @Test
    public void TestExtractDirectlyOnTopInMatrix(){
        String[][] matrix = {
                {"$", ".", "1"},
                {"*", ".", "@"},
                {"-", "=", "+"}
        };
        Assert.assertEquals(".", ExtractSurroundings.ExtractDirectlyOnTopInMatrix(matrix, 1, 1).pop());
        Assert.assertNull(ExtractSurroundings.ExtractDirectlyOnTopInMatrix(matrix, 0, 0).pop());
        Assert.assertNull(ExtractSurroundings.ExtractDirectlyOnTopInMatrix(matrix, 0, 1).pop());
        Assert.assertNull(ExtractSurroundings.ExtractDirectlyOnTopInMatrix(matrix, 0, 2).pop());

        String[][] matrix1 = {
                {"*", ".", "@", "5"},
                {"$", "46", "1"},
                {"-", "=", "+", "."}
        };
        Stack<String> expectedStack = new Stack<>();
        expectedStack.push(".");
        expectedStack.push("@");
        Stack<String> actualStack = ExtractSurroundings.ExtractLineAboveInMatrix(matrix1, 1, 1);
        boolean forAssertion1 = true;

        for (int i = 0; i < expectedStack.size(); i++) {
            String currentStringFromExpectedStack = expectedStack.pop();
            String currentStringFromActualStack = actualStack.pop();
            if (!currentStringFromExpectedStack.equals(currentStringFromActualStack)) {
                forAssertion1 = false;
                break;
            }
        }
        Assert.assertTrue(forAssertion1);

    }

    @Test
    public void TestExecuteExtractTopRightDiagonalInMatrix(){
        String[][] matrix = {
                {"$", "46", "1"},
                {"*", ".", "@", "5"},
                {"-", "=", "+", "."}
        };
        Assert.assertFalse(ExtractSurroundings.executeExtractTopRightDiagonalInMatrix(matrix, 1, 1));
        Assert.assertTrue(ExtractSurroundings.executeExtractTopRightDiagonalInMatrix(matrix, 2, 0));
    }

    @Test
    public void TestExtractTopRightDiagonalInMatrix() {
        String[][] matrix = {
                {"$", ".", "1"},
                {"*", ".", "@"},
                {"-", "=", "+"}
        };
        Assert.assertEquals("1", ExtractSurroundings.ExtractTopRightDiagonalInMatrix(matrix, 1, 1));
        Assert.assertNull(ExtractSurroundings.ExtractTopRightDiagonalInMatrix(matrix, 0, 1));
        Assert.assertNull(ExtractSurroundings.ExtractTopRightDiagonalInMatrix(matrix, 1, 2));
    }

    @Test
    public void TestExtractIndexOnTheLeftInMatrix(){
        String[][] matrix = {
                {"$", ".", "1"},
                {"36", ".", "@"},
                {"-", "=", "+"}
        };
        Assert.assertEquals("$", ExtractSurroundings.ExtractIndexOnTheLeftInMatrix(matrix, 0, 1));
        Assert.assertEquals("36", ExtractSurroundings.ExtractIndexOnTheLeftInMatrix(matrix, 1, 1));
        Assert.assertEquals("-", ExtractSurroundings.ExtractIndexOnTheLeftInMatrix(matrix, 2, 1));

        Assert.assertEquals(".", ExtractSurroundings.ExtractIndexOnTheLeftInMatrix(matrix, 0, 2));
        Assert.assertEquals(".", ExtractSurroundings.ExtractIndexOnTheLeftInMatrix(matrix, 1, 2));
        Assert.assertEquals("=", ExtractSurroundings.ExtractIndexOnTheLeftInMatrix(matrix, 2, 2));

        Assert.assertEquals(null, ExtractSurroundings.ExtractIndexOnTheLeftInMatrix(matrix, 0, 0));
        Assert.assertEquals(null, ExtractSurroundings.ExtractIndexOnTheLeftInMatrix(matrix, 1, 0));
        Assert.assertEquals(null, ExtractSurroundings.ExtractIndexOnTheLeftInMatrix(matrix, 2, 0));
    }

    @Test
    public void TestExtractIndexOnTheRightInMatrix(){
        String[][] matrix = {
                {"$", ".", "1"},
                {"*", ".", "9"},
                {"-", "=", "+"}
        };
        Assert.assertEquals(".", ExtractSurroundings.ExtractIndexOnTheRightInMatrix(matrix, 0, 0));
        Assert.assertEquals(".", ExtractSurroundings.ExtractIndexOnTheRightInMatrix(matrix, 1, 0));
        Assert.assertEquals("=", ExtractSurroundings.ExtractIndexOnTheRightInMatrix(matrix, 2, 0));

        Assert.assertEquals("1", ExtractSurroundings.ExtractIndexOnTheRightInMatrix(matrix, 0, 1));
        Assert.assertEquals("9", ExtractSurroundings.ExtractIndexOnTheRightInMatrix(matrix, 1, 1));
        Assert.assertEquals("+", ExtractSurroundings.ExtractIndexOnTheRightInMatrix(matrix, 2, 1));

        Assert.assertEquals(null, ExtractSurroundings.ExtractIndexOnTheRightInMatrix(matrix, 0, 2));
        Assert.assertEquals(null, ExtractSurroundings.ExtractIndexOnTheRightInMatrix(matrix, 1, 2));
        Assert.assertEquals(null, ExtractSurroundings.ExtractIndexOnTheRightInMatrix(matrix, 2, 2));
    }


    @Test
    public void TestRawInputLineToStrArray(){
        Assert.assertEquals(new String[]{"467", ".", ".", "114", ".", ".", "."},
                Main.RawInputLineToStrArray("467..114..."));

        Assert.assertEquals(new String[]{".", ".", ".", "."},
                Main.RawInputLineToStrArray("...."));

        Assert.assertEquals(new String[]{".", ".", "46", ".", "."},
                Main.RawInputLineToStrArray("..46.."));

        Assert.assertEquals(new String[]{".", ".", "731"},
                Main.RawInputLineToStrArray("..731"));
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
    public void TestIsIndexOnLeftEdgeOfMatrix(){
        Assert.assertFalse(Main.IsIndexOnLeftEdgeOfMatrix(1));
        Assert.assertTrue(Main.IsIndexOnLeftEdgeOfMatrix(0));
        Assert.assertFalse(Main.IsIndexOnLeftEdgeOfMatrix(2));
    }
    @Test
    public void TestIsIndexOnRightEdgeOfMatrix(){
        String[][] matrix = {
                {".", ".", "."},
                {".", "1", "."},
                {".", ".", "."}
        };
        Assert.assertFalse(Main.IsIndexOnRightEdgeOfMatrix(matrix, 1, 1));

        String[][] matrix1 = {
                {".", ".", "."},
                {"1", ".", "."},
                {".", ".", "."}
        };
        Assert.assertFalse(Main.IsIndexOnRightEdgeOfMatrix(matrix1, 0, 1));

        String[][] matrix2 = {
                {"$", "#", "@"},
                {"*", "%", "34"},
                {"-", "=", "+"}
        };
        Assert.assertTrue(Main.IsIndexOnRightEdgeOfMatrix(matrix2, 1, 2));
    }

    @Test
    public void TestIsLineOnTopEdgeOfMatrix(){
        Assert.assertFalse(Main.IsLineOnTopEdgeOfMatrix(2));
        Assert.assertFalse(Main.IsLineOnTopEdgeOfMatrix(1));
        Assert.assertTrue(Main.IsLineOnTopEdgeOfMatrix(0));
    }

    @Test
    public void TestIsLineOnBottomEdgeOfMatrix(){
        String[][] matrix = {
                {".", ".", "."},
                {".", "1", "."},
                {".", ".", "."}
        };
        Assert.assertTrue(Main.IsLineOnBottomEdgeOfMatrix(2, matrix));
        Assert.assertFalse(Main.IsLineOnBottomEdgeOfMatrix(1, matrix));
        Assert.assertFalse(Main.IsLineOnBottomEdgeOfMatrix(0, matrix));
    }

    @Test
    public void TestIsIndexInBoundsOfMatrix(){
        String[][] matrix = {
                {".", ".", "."},
                {".", "1", "."},
                {".", ".", "."}
        };
        Assert.assertTrue(ExtractSurroundings.isIndexInBoundsOfMatrix(matrix, 0, 0));
        Assert.assertTrue(ExtractSurroundings.isIndexInBoundsOfMatrix(matrix, 0,1));
        Assert.assertTrue(ExtractSurroundings.isIndexInBoundsOfMatrix(matrix, 0,2));
        Assert.assertTrue(ExtractSurroundings.isIndexInBoundsOfMatrix(matrix, 1,0));
        Assert.assertTrue(ExtractSurroundings.isIndexInBoundsOfMatrix(matrix, 1,1));
        Assert.assertTrue(ExtractSurroundings.isIndexInBoundsOfMatrix(matrix, 1,2));
        Assert.assertTrue(ExtractSurroundings.isIndexInBoundsOfMatrix(matrix, 2,0));
        Assert.assertTrue(ExtractSurroundings.isIndexInBoundsOfMatrix(matrix, 2,1));
        Assert.assertTrue(ExtractSurroundings.isIndexInBoundsOfMatrix(matrix, 2,2));

        Assert.assertFalse(ExtractSurroundings.isIndexInBoundsOfMatrix(matrix, -1,1));
        Assert.assertFalse(ExtractSurroundings.isIndexInBoundsOfMatrix(matrix, 3,0));
        Assert.assertFalse(ExtractSurroundings.isIndexInBoundsOfMatrix(matrix, 1,-1));
    }
}
