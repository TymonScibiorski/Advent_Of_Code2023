import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


public class ExtractSurroundingsTest {
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
                {".", "423", "."},
                {".", ".", ".", ".", "%"}
        };
        Assert.assertTrue(
                Main.IsAPartNumber(matrix6, 0, 1)
        );

        String[][] matrix7 = {
                {"$", ".", "1"},
                {"*", ".", "@"},
                {"-", "=", "+"}
        };
        Assert.assertTrue(
                Main.IsAPartNumber(matrix7, 0, 2)
        ); //Isn't working because in the ExtractSurroundings function, if an item in the i. e. "LineAbove" stack is null it's just stepped over.
        // If null is first (sometimes nulls get added to the stacks, that are later to be stripped) then the rest of the stack won't be added. Rewrite code so nulls do not get added.
        //Turns out it's not feasible to make functions not return nulls, so a popper of nulls was added, but for some reason it pops off of stacks that are sized below zero, despite the if. To be fixed.
    }

    @Test
    public void TestExtractSurroundings(){
        String[][] matrix = {
                {"$", ".", "1"},
                {"*", ".", "@"},
                {"-", "=", "+"}
        };
        Stack<String> expectedStack = new Stack<>();
        expectedStack.push("1");
        expectedStack.push(".");
        expectedStack.push("$");
        expectedStack.push("*");
        expectedStack.push("@");
        expectedStack.push("+");
        expectedStack.push("=");
        expectedStack.push("-");
        Stack<String> actualStack = ExtractSurroundings.ExtractSurroundings(matrix, 1, 1);
        boolean forAssertion = true;

        for(int i = 0; i < expectedStack.size(); i++){
            String currentStringFromActualStack = actualStack.pop();
            String currentStringFromExpectedStack = expectedStack.pop();
            if(!currentStringFromExpectedStack.equals(currentStringFromActualStack)){
                forAssertion = false;
                break;
            }
        }
        Assert.assertTrue(forAssertion);

        String[][] matrix1 = {
                {"$", "46", "1"},
                {"*", ".", "@", "5"},
                {"-", "=", "+", "."}
        };
        Stack<String> expectedStack1 = new Stack<>();
        expectedStack1.push("46");
        expectedStack1.push("$");
        expectedStack1.push("*");
        expectedStack1.push("@");
        expectedStack1.push("+");
        expectedStack1.push("=");
        expectedStack1.push("-");
        Stack<String> actualStack1 = ExtractSurroundings.ExtractSurroundings(matrix1, 1, 1);
        forAssertion = true;

        for(int i = 0; i < expectedStack1.size(); i++){
            String currentStringFromActualStack = actualStack1.pop();
            String currentStringFromExpectedStack = expectedStack1.pop();
            if(!currentStringFromExpectedStack.equals(currentStringFromActualStack)){
                forAssertion = false;
                break;
            }
        }
        Assert.assertTrue(forAssertion);

        String[][] matrix2 = {
                {"a", "423", "b"},
                {"c", "d", "e", "f", "%"}
        };
        String[] expectedOutput = {"c", "f", "e", "d", "%", "b", "a"};
        forAssertion = true;
        Stack<String> testStack = ExtractSurroundings.ExtractSurroundings(matrix2, 0, 1);
        for (String s : expectedOutput) {
            if (!s.equals(testStack.pop())) {
                forAssertion = false;
                break;
            }
        }
        Assert.assertTrue(forAssertion);
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
        Stack<String> actualStack = ExtractSurroundings.ExtractLineAboveInMatrix(matrix, 1, 1, 1);
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
        Stack<String> actualStack1 = ExtractSurroundings.ExtractLineAboveInMatrix(matrix1, 1, 1, 1);
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
        Assert.assertEquals(".", ExtractSurroundings.ExtractTopLeftDiagonalInMatrix(matrix, 1, 2));
        Assert.assertEquals("*", ExtractSurroundings.ExtractTopLeftDiagonalInMatrix(matrix, 2, 1));
        Assert.assertEquals(".", ExtractSurroundings.ExtractTopLeftDiagonalInMatrix(matrix, 2, 2));
        Assert.assertNull(ExtractSurroundings.ExtractTopLeftDiagonalInMatrix(matrix, 0, 0));
        Assert.assertNull(ExtractSurroundings.ExtractTopLeftDiagonalInMatrix(matrix, 0, 1));
        Assert.assertNull(ExtractSurroundings.ExtractTopLeftDiagonalInMatrix(matrix, 0, 2));
        Assert.assertNull(ExtractSurroundings.ExtractTopLeftDiagonalInMatrix(matrix, 1, 0));
        Assert.assertNull(ExtractSurroundings.ExtractTopLeftDiagonalInMatrix(matrix, 2, 0));
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
        Stack<String> actualStack = ExtractSurroundings.ExtractLineAboveInMatrix(matrix1, 1, 1, 1);
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
        Assert.assertFalse(ExtractSurroundings.executeExtractTopRightDiagonalInMatrix(matrix, 1, 1, 1));
        Assert.assertTrue(ExtractSurroundings.executeExtractTopRightDiagonalInMatrix(matrix, 2, 0, 1));
    }

    @Test
    public void TestExtractTopRightDiagonalInMatrix() {
        String[][] matrix = {
                {"$", ".", "1"},
                {"*", ".", "@"},
                {"-", "=", "+"}
        };
        Assert.assertEquals("1", ExtractSurroundings.ExtractTopRightDiagonalInMatrix(matrix, 1, 1, 1));
        Assert.assertNull(ExtractSurroundings.ExtractTopRightDiagonalInMatrix(matrix, 0, 1, 1));
        Assert.assertNull(ExtractSurroundings.ExtractTopRightDiagonalInMatrix(matrix, 1, 2, 1));
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

        Assert.assertNull(ExtractSurroundings.ExtractIndexOnTheLeftInMatrix(matrix, 0, 0));
        Assert.assertNull(ExtractSurroundings.ExtractIndexOnTheLeftInMatrix(matrix, 1, 0));
        Assert.assertNull(ExtractSurroundings.ExtractIndexOnTheLeftInMatrix(matrix, 2, 0));
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

        Assert.assertNull(null, ExtractSurroundings.ExtractIndexOnTheRightInMatrix(matrix, 0, 2));
        Assert.assertNull(null, ExtractSurroundings.ExtractIndexOnTheRightInMatrix(matrix, 1, 2));
        Assert.assertNull(null, ExtractSurroundings.ExtractIndexOnTheRightInMatrix(matrix, 2, 2));
    }

    @Test
    public void TestExtractLineBelow(){
        String[][] matrix = {
                {"a", "423", "b"},
                {"c", "d", "e", "f", "%"}
        };
        String[] expectedOutput = {"%", "d", "e", "f", "c"};
        boolean forAssertion = true;
        Stack<String> testStack = ExtractSurroundings.ExtractLineBelowInMatrix(matrix, 0, 1, 3);
        for (int i = 0; i < expectedOutput.length; i++) {
            if (!expectedOutput[i].equals(testStack.pop())) {
                forAssertion = false;
                break;
            }
        }
        Assert.assertTrue(forAssertion);
    }

    @Test
    public void TestExtractBottomLeftDiagonalInMatrix(){
        String[][] matrix = {
                {"$", ".", "1"},
                {"*", ".", "9"},
                {"-", "=", "+"}
        };
        Assert.assertEquals("*", ExtractSurroundings.ExtractBottomLeftDiagonalInMatrix(matrix, 0, 1));
        Assert.assertEquals(".", ExtractSurroundings.ExtractBottomLeftDiagonalInMatrix(matrix, 0, 2));
        Assert.assertEquals("-", ExtractSurroundings.ExtractBottomLeftDiagonalInMatrix(matrix, 1, 1));
        Assert.assertEquals("=", ExtractSurroundings.ExtractBottomLeftDiagonalInMatrix(matrix, 1, 2));
        Assert.assertNull(ExtractSurroundings.ExtractBottomLeftDiagonalInMatrix(matrix, 0, 0));
        Assert.assertNull(ExtractSurroundings.ExtractBottomLeftDiagonalInMatrix(matrix, 2, 0));
        Assert.assertNull(ExtractSurroundings.ExtractBottomLeftDiagonalInMatrix(matrix, 2, 1));
        Assert.assertNull(ExtractSurroundings.ExtractBottomLeftDiagonalInMatrix(matrix, 2, 2));
    }

    @Test
    public void ExtractDirectlyBelowInMatrix(){
        String[][] matrix = {
                {"$", ".", "1"},
                {"*", ".", "9"},
                {"-", "=", "+"}
        };
        Stack<String> testStack = ExtractSurroundings.ExtractDirectlyBelowInMatrix(matrix, 0, 0, 1);
        Assert.assertEquals("*", testStack.pop());

        testStack = ExtractSurroundings.ExtractDirectlyBelowInMatrix(matrix, 0, 1, 1);
        Assert.assertEquals(".", testStack.pop());

        testStack = ExtractSurroundings.ExtractDirectlyBelowInMatrix(matrix, 0, 2, 1);
        Assert.assertEquals("9",testStack.pop());

        testStack = ExtractSurroundings.ExtractDirectlyBelowInMatrix(matrix, 1, 0, 1);
        Assert.assertEquals("-", testStack.pop());

        testStack = ExtractSurroundings.ExtractDirectlyBelowInMatrix(matrix, 1, 2, 1);
        Assert.assertEquals("+", testStack.pop());

        String[][] matrix3 = {
                {"a", "423", "b"},
                {"c", "d", "e", "f", "%"}
        };
        testStack = ExtractSurroundings.ExtractDirectlyBelowInMatrix(matrix3, 0, 1, 3);
        Assert.assertEquals("f", testStack.pop());
        Assert.assertEquals("e", testStack.pop());
        Assert.assertEquals("d", testStack.pop());

        Assert.assertNull(ExtractSurroundings.ExtractDirectlyBelowInMatrix(matrix, 2, 0, 1).pop());
//        Assert.assertNull(ExtractSurroundings.ExtractDirectlyBelowInMatrix(matrix, 2, 1, 1));
//        Assert.assertNull(ExtractSurroundings.ExtractDirectlyBelowInMatrix(matrix, 2, 2, 1));
    }

    @Test
    public void TestExecuteExtractBottomRightDiagonalInMatrix(){
        String[][] matrix = {
                {".", "423", "."},
                {".", ".", ".", ".", "%"}
        };
        Assert.assertTrue(ExtractSurroundings.executeExtractBottomRightDiagonalInMatrix(matrix, 0, 1, 3));
    }

    @Test
    public void TestExtractBottomRightDiagonalInMatrix(){
        String[][] matrix = {
                {"$", ".", "1"},
                {"*", ".", "9"},
                {"-", "=", "+"}
        };
        Assert.assertEquals(".",ExtractSurroundings.ExtractBottomRightDiagonalInMatrix(matrix, 0, 0, 1));
        Assert.assertEquals("9",ExtractSurroundings.ExtractBottomRightDiagonalInMatrix(matrix, 0, 1, 1));
        Assert.assertEquals("=",ExtractSurroundings.ExtractBottomRightDiagonalInMatrix(matrix, 1, 0, 1));
        Assert.assertEquals("+",ExtractSurroundings.ExtractBottomRightDiagonalInMatrix(matrix, 1, 1, 1));
        Assert.assertNull(ExtractSurroundings.ExtractBottomRightDiagonalInMatrix(matrix, 0, 2, 1));
        Assert.assertNull(ExtractSurroundings.ExtractBottomRightDiagonalInMatrix(matrix, 1, 2, 1));
        Assert.assertNull(ExtractSurroundings.ExtractBottomRightDiagonalInMatrix(matrix, 2, 0, 1));
        Assert.assertNull(ExtractSurroundings.ExtractBottomRightDiagonalInMatrix(matrix, 2, 1, 1));
        Assert.assertNull(ExtractSurroundings.ExtractBottomRightDiagonalInMatrix(matrix, 2, 2, 1));

        String[][] matrix1 = {
                {".", "423", "."},
                {".", ".", ".", ".", "%"}
        };
        Assert.assertEquals("%",ExtractSurroundings.ExtractBottomRightDiagonalInMatrix(matrix1, 0, 1, 3));
    }
}
