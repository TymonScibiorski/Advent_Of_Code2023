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
//        String[][] matrix = {
//                {".", ".", "."},
//                {".", "1", "."},
//                {".", ".", "."}
//        };
//        Assert.assertFalse(
//                Main.IsAPartNumber(matrix, 1, 1)
//        );
//        String[][] matrix1 = {
//                {".", ".", "."},
//                {"1", ".", "."},
//                {".", ".", "."}
//        };
//        Assert.assertFalse(
//                Main.IsAPartNumber(matrix1, 1, 0)
//        );
//
//        String[][] matrix2 = {
//                {"$", "#", "@"},
//                {"*", "1", "%"},
//                {"-", "=", "+"}
//        };
//        Assert.assertTrue(
//                Main.IsAPartNumber(matrix2, 1, 1)
//        );
//        String[][] matrix3 = {
//                {"$", "#", "@"},
//                {"*", "%", "1"},
//                {"-", "=", "+"}
//        };
//        Assert.assertTrue(
//                Main.IsAPartNumber(matrix3, 1, 2)
//        );
//
//        String[][] matrix4 = {
//                {".", "423", "."},
//                {".", ".", ".", ".", "."}
//        };
//        Assert.assertFalse(
//                Main.IsAPartNumber(matrix4, 0, 1)
//        );
//
//        String[][] matrix5 = {
//                {".", "423", "."},
//                {".", ".", "%", ".", "."}
//        };
//        Assert.assertTrue(
//                Main.IsAPartNumber(matrix5, 0, 1)
//        );
//
//        String[][] matrix6 = {
//                {".", "423", "."},
//                {".", ".", ".", ".", "%"}
//        };
//        Assert.assertTrue(
//                Main.IsAPartNumber(matrix6, 0, 1)
//        );
//
//        String[][] matrix7 = {
//                {"$", ".", "1"},
//                {"*", ".", "@"},
//                {"-", "=", "+"}
//        };
//        Assert.assertTrue(
//                Main.IsAPartNumber(matrix7, 0, 2)
//        );

        String[][] matrix8 = {
                Main.RawInputLineToStrArray(".......*372..747."),
                Main.RawInputLineToStrArray("....684.........."),
                Main.RawInputLineToStrArray("...........487..."),
                Main.RawInputLineToStrArray(".....&.574.*....."),
                Main.RawInputLineToStrArray("..374....+.307..."),
                Main.RawInputLineToStrArray(".................")
        };
        Assert.assertTrue(Main.IsAPartNumber(matrix8, 0, 8));
        Assert.assertFalse(Main.IsAPartNumber(matrix8, 0, 11));
        Assert.assertFalse(Main.IsAPartNumber(matrix8, 1, 5));
        Assert.assertTrue(Main.IsAPartNumber(matrix8, 2, 12));
//        Assert.assertTrue(Main.IsAPartNumber(matrix8, ,));
//        Assert.assertTrue(Main.IsAPartNumber(matrix8, ,));
//        Assert.assertTrue(Main.IsAPartNumber(matrix8, ,));
//        Assert.assertTrue(Main.IsAPartNumber(matrix8, ,));

        Assert.assertTrue(
                Main.IsAPartNumber(new String[][]{
                        Main.RawInputLineToStrArray("....."),
                        Main.RawInputLineToStrArray(".455#"),
                        Main.RawInputLineToStrArray(".....")
                }, 1, 1)
        );

        Assert.assertTrue(
                Main.IsAPartNumber(new String[][]{
                        Main.RawInputLineToStrArray(".*..."),
                        Main.RawInputLineToStrArray(".569."),
                        Main.RawInputLineToStrArray(".....")
                }, 1, 1)
        );

        Assert.assertTrue(
                Main.IsAPartNumber(
                        new String[][]{
                                Main.RawInputLineToStrArray("...*."),
                                Main.RawInputLineToStrArray(".127."),
                                Main.RawInputLineToStrArray(".....")
                        }, 1,1
                        ));

        Assert.assertFalse(
                Main.IsAPartNumber(
                        new String[][]{
                                Main.RawInputLineToStrArray("......."),
                                Main.RawInputLineToStrArray("......."),
                                Main.RawInputLineToStrArray("......")
                        }, 2,2
                        ));

        Assert.assertTrue(
                Main.IsAPartNumber(
                        new String[][]{
                                Main.RawInputLineToStrArray("....."),
                                Main.RawInputLineToStrArray(".875."),
                                Main.RawInputLineToStrArray("....*")
                        }, 1,1
                ));

        Assert.assertTrue(
                Main.IsAPartNumber(
                        new String[][]{
                                Main.RawInputLineToStrArray("....."),
                                Main.RawInputLineToStrArray(".653+"),
                                Main.RawInputLineToStrArray(".....")
                        }, 1, 1
                ));
        Assert.assertTrue(
                Main.IsAPartNumber(
                        new String[][]{
                                Main.RawInputLineToStrArray("...."),
                                Main.RawInputLineToStrArray("*86."),
                                Main.RawInputLineToStrArray("....")
                        }, 1, 1
                ));
        Assert.assertTrue(
                Main.IsAPartNumber(
                        new String[][]{
                                Main.RawInputLineToStrArray("....."),
                                Main.RawInputLineToStrArray(".972."),
                                Main.RawInputLineToStrArray("....*")
                        }, 1, 1
                ));



//        Assert.assertTrue(
//                Main.IsAPartNumber(
//                        new String[][]{
//                                Main.RawInputLineToStrArray(""),
//                                Main.RawInputLineToStrArray(""),
//                                Main.RawInputLineToStrArray("")
//                        }, ,
//                ));
//        Assert.assertTrue(
//                Main.IsAPartNumber(
//                        new String[][]{
//                                Main.RawInputLineToStrArray(""),
//                                Main.RawInputLineToStrArray(""),
//                                Main.RawInputLineToStrArray("")
//                        }, ,
//                ));
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
        Assert.assertEquals(Main.SumAllNumbersInAnArray(new int[]{99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}), 99);
        Assert.assertEquals(Main.SumAllNumbersInAnArray(new int[]{232342342}), 232342342);
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
        Assert.assertFalse(ExtractSurroundings.isIndexOnLeftEdgeOfMatrix(1));
        Assert.assertTrue(ExtractSurroundings.isIndexOnLeftEdgeOfMatrix(0));
        Assert.assertFalse(ExtractSurroundings.isIndexOnLeftEdgeOfMatrix(2));
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
