import javax.sound.sampled.Line;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        System.out.println(FinalFunctionForPartOne());
    }
    //  The IsAPartNumber method is not functioning properly, which must be because of the ExtractSurroundings method.
    //  TODO: To the ExtractSurroundings method: tests to be added, problem to be figured out.

        public static int FinalFunctionForPartOne(){
        String[][] matrix = filledMatrix();
        ArrayList <Integer> ArrayOfValidNumbers = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(IsAPartNumber(matrix, i, j)){
                    ArrayOfValidNumbers.add(Integer.valueOf(matrix[i][j]));
                }
            }
        }

        return SumAllNumbersInAnArray(ConvertArrayListIntegerToIntArray(ArrayOfValidNumbers));
    }

    public static String[][] createMatrix(){
        // The input has 140 lines.
        String[][] matrix = new String[140][];
        return matrix;
    }

    public static String[][] filledMatrix(){
        // This method creates a matrix, that contains 140 empty String[], using the createMatrix method
        // and fills it with ready-to-use lines from the input, vetted with the RawInputLineToStrArray method.
        String[][] matrix = createMatrix();

        try {
            File input = new File("src/input.txt");
            Scanner scanner = new Scanner(input);

            for (int i = 0; i < input.length(); i++){
                if (scanner.hasNextLine()) {
                    matrix[i] = RawInputLineToStrArray(scanner.nextLine());
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return matrix;
    }


    public static boolean IsAPartNumber(String[][] matrix, int NumbersLine, int NumbersPlaceInLine){
        // This method determines if a given number is a partNumber,
        // by checking if it is adjacent to a symbol with the IsASymbol method.
        // As input, it takes the matrix and the number's coordinates.

        Stack<String> Surroundings = ExtractSurroundings(matrix, NumbersLine, NumbersPlaceInLine);

        if(!IsANumber(matrix[NumbersLine][NumbersPlaceInLine])){
            // If the target is not a number it cannot be a partNumber
            return false;
        }

        for (String oneOfStringSurrounding : Surroundings) {
            if (IsASymbol(oneOfStringSurrounding)) {
                return true;
            }
        }

        return false;
    }


    public static Stack<String> ExtractSurroundings(String[][] matrix, int LineNumber, int PlaceInLineIndex){
        //This function extracts strings surrounding a provided coordinate in a matrix
        //Example:
        // matrix = {
        //      {"$", "#", "@"},
        //      {"*", "1", "%"},
        //      {"-", "=", "+"}
        //        };
        // A stack containing the following strings would be returned: "$", "#", "@", "*", "%", "-", "=", "+"

        Stack<String> out = new Stack<>();

        boolean isTargetOnLeftEdgeOfMatrix = IsIndexOnLeftEdgeOfMatrix(PlaceInLineIndex);
        boolean isTargetOnRightEdgeOfMatrix = IsIndexOnRightEdgeOfMatrix(matrix, LineNumber, PlaceInLineIndex);
        boolean isTargetLineOnTopEdgeOfMatrix = IsLineOnTopEdgeOfMatrix(LineNumber);
        boolean isTargetLineOnBottomEdgeOfMatrix = IsLineOnBottomEdgeOfMatrix(LineNumber, matrix);

        int targetsLength = matrix[LineNumber][PlaceInLineIndex].length();

        //Adding all stacks to the outStack
        Stack<String> LineAbove = ExtractLineAboveInMatrix(matrix, LineNumber, PlaceInLineIndex, targetsLength, isTargetOnLeftEdgeOfMatrix, isTargetOnRightEdgeOfMatrix, isTargetLineOnTopEdgeOfMatrix);
        for (String currentStringInStackLineAbove : LineAbove) {
            out.push(currentStringInStackLineAbove);
        }

        out.push(ExtractIndexOnTheLeftInMatrix(matrix, LineNumber, PlaceInLineIndex, isTargetOnLeftEdgeOfMatrix));
        out.push(ExtractIndexOnTheRightInMatrix(matrix, LineNumber, PlaceInLineIndex, isTargetOnRightEdgeOfMatrix));

        Stack<String> LineBelow = ExtractLineBelowInMatrix(matrix, LineNumber, PlaceInLineIndex, targetsLength, isTargetOnLeftEdgeOfMatrix, isTargetOnRightEdgeOfMatrix, isTargetLineOnBottomEdgeOfMatrix);
        for (String currentStringInStackLineBelow : LineBelow) {
            out.push(currentStringInStackLineBelow);
        }
        

        return out;
    }

    public static Stack<String> ExtractLineAboveInMatrix(String[][] matrix, int LineNumber, int PlaceInLineIndex, int targetsLength, boolean isTargetOnLeftEdgeOfMatrix, boolean isTargetOnRightEdgeOfMatrix, boolean isTargetLineOnTopEdgeOfMatrix){
        // Extracts contents that are directly above and diagonally to the top-right and top-left to a certain target.
        // Example:
//        String[][] matrix1 = {
//                {"$", "46", "1"},
//                {"*", ".", "@", "5"},
//                {"-", "=", "+", "."}
//        };
        // Returns a stack containing: 1, 46, $
        Stack<String> out = new Stack<>();

        if(isTargetLineOnTopEdgeOfMatrix){
            return out;
        }

        // Top-left diagonal
        if(!isTargetOnLeftEdgeOfMatrix){
            out.push(matrix[LineNumber-1][PlaceInLineIndex-1]);
        }

        for (int i = PlaceInLineIndex; i < PlaceInLineIndex+targetsLength; i++) {
            String currentString = matrix[LineNumber-1][i];

            if(IsANumber(currentString)){
                i += currentString.length();
            }

            out.push(currentString);
        }

        // Top-right diagonal
        if(!isTargetOnRightEdgeOfMatrix){
            out.push(matrix[LineNumber-1][PlaceInLineIndex+targetsLength-1]);
        }

        return out;
    }

    public static String ExtractIndexOnTheLeftInMatrix(String[][] matrix, int LineNumber, int PlaceInLineIndex, boolean isTargetOnLeftEdgeOfMatrix){
        if(!isTargetOnLeftEdgeOfMatrix){
            return matrix[LineNumber][PlaceInLineIndex-1];
        }
        return null;
    }

    public static String ExtractIndexOnTheRightInMatrix(String[][] matrix, int LineNumber, int PlaceInLineIndex, boolean isTargetOnRightEdgeOfMatrix){
        if(!isTargetOnRightEdgeOfMatrix){
            return matrix[LineNumber][PlaceInLineIndex+1];
        }
        return null;
    }

    public static Stack<String> ExtractLineBelowInMatrix(String[][] matrix, int LineNumber, int PlaceInLineIndex, int targetsLength, boolean isTargetOnLeftEdgeOfMatrix, boolean isTargetOnRightEdgeOfMatrix, boolean isTargetLineOnBottomEdgeOfMatrix){
        // Extracts contents that are directly above and diagonally to the top-right and top-left to a certain target.
        // Example:
//        String[][] matrix1 = {
//                {"$", "46", "1"},
//                {"*", ".", "@", "5"},
//                {"-", "=", "+", "."}
//        };
        // Returns a stack containing: 1, 46, $
        Stack<String> out = new Stack<>();

        if(isTargetLineOnBottomEdgeOfMatrix){
            return out;
        }

        // Extracts bottom-left diagonal
        if(!isTargetOnLeftEdgeOfMatrix){
            out.push(matrix[LineNumber+1][PlaceInLineIndex-1]);
        }

        // Extracts directly beneath the entire target's length
        for (int i = PlaceInLineIndex; i < PlaceInLineIndex+targetsLength; i++) {
            String currentString = matrix[LineNumber+1][i];

            if(IsANumber(currentString)){
                i += currentString.length();
            }

            out.push(currentString);
        }

        // Extracts bottom-right diagonal
        if(!isTargetOnRightEdgeOfMatrix){
            out.push(matrix[LineNumber+1][PlaceInLineIndex+targetsLength-1]);
        }

        return out;
    }

    public static String[] RawInputLineToStrArray(String line){
        // This method takes a line and returns an array that will be usable by the code.
        // Examples:
        // "...." -> [".", ".", ".", "."]
        // "..46.$" -> [".", ".", "46", ".", "$"]

        char[] ChoppedUpLine = line.toCharArray();
        ArrayList<String> out = new ArrayList<>();

        for (int i = 0; i < ChoppedUpLine.length; i++) {
            // If it's not a number, it takes up one space only.
            // If it is a number, it can take up more than one space, therefore next items must be checked as well
            if (IsANumber(ChoppedUpLine[i]) == false){
                out.add(String.valueOf(ChoppedUpLine[i]));
                continue;
            }

            if (IsANumber(ChoppedUpLine[i]) == true){
                StringBuilder Number = new StringBuilder();
                Number.append(ChoppedUpLine[i]);

                while(i + 1 < ChoppedUpLine.length && IsANumber(ChoppedUpLine[i+1])){
                    i++;
                    Number.append(ChoppedUpLine[i]);
                }
                out.add(String.valueOf(Number));
            }
        }

        return ConvertArrayListStringToStringArray(out);
    }

    public static String[] ConvertArrayListStringToStringArray(ArrayList<String> givenArrayList){
        // ArrayList {".", "34", "5"} -> String[] {".", "34", "5"}

        String[] out = new String[givenArrayList.size()];

        for (int i = 0; i < givenArrayList.size(); i++) {
            out[i] = givenArrayList.get(i);
        }
        return out;
    }

    public static int[] ConvertArrayListIntegerToIntArray(ArrayList<Integer> givenArrayList){
        // ArrayList {1, 2, 3} -> int[] {1, 2, 3}

        int[] out = new int[givenArrayList.size()];

        for (int i = 0; i < givenArrayList.size(); i++) {
            out[i] = givenArrayList.get(i);
        }
        return out;
    }

    public static int SumAllNumbersInAnArray(int[] ArrayWithNumbers){
        // This method takes in an array containing ints and returns the sum of them,
        // it will be used in the final function, for summing all of the valid numbers in the input text.
        // Example:
        // int[] {1, 2, 3, 4, 5} -> 15

        int sum = 0;

        for(int i = 0; i<ArrayWithNumbers.length; i++){
            sum += ArrayWithNumbers[i];
        }

        return sum;
    }

    public static boolean IsASymbol(String str){
        if (str == null || str.length()!=1){
            return false;
        }
        if(str.equals(".")){
            return false;
        }
        if(IsANumber(str)){
            return false;
        }
        //Symbols can't be dots, longer than one or digits.

        if(str.matches("[@#\\$%&*\\-\\+=]")){
            return true;
        }
        //Symbols are any of the following: @#$%&*-+=

        return false;
    }


    public static String CharToStr(char character){
        return String.valueOf(character);
    }

    public static boolean IsANumber(String str){
        // Takes in a String and determines if it's a written number.
        if(str.matches("\\d+")){
            return true;
        }
        return false;
    }

    public static boolean IsANumber(char ch){
        // Takes in a char and determines if it's a written number.
        if(String.valueOf(ch).matches("\\d")){
            return true;
        }
        return false;
    }

    public static boolean IsIndexOnLeftEdgeOfMatrix(int placeInLine){
        // Determines if a specific item is on the left end of a line in a matrix.
        // matrix = {
        //      {"$", "#", "@"},
        //      {"*", "%", "1"},
        //      {"-", "=", "+"}
        //        };
        // If supplied the x coordinate of either "$", "*" or "-" the method would return True,
        // and False for any of the following: "#", "@", "%", "1", "=", "+"

        return placeInLine == 0;
    }
    public static boolean IsIndexOnRightEdgeOfMatrix(String[][] matrix, int LineNumber, int placeInLine){
        // Determines if a specific item is on the right end of a line in a matrix.
        // matrix = {
        //      {"$", "#", "@"},
        //      {"*", "%", "1"},
        //      {"-", "=", "+"}
        //        };
        // If supplied with this matrix and the coordinates of either "@", "1" or "+" the method would return True,
        // and False for any of the following: "$", "#", "*", "%", "-", "="

        if(placeInLine+1 == matrix[LineNumber].length){
            return true;
        }
        return false;
    }


    //I figure the code should "for" through the input and convert it into a two-dimensional array.
    //This array would store three types of objects: Periods, Symbols and Numbers
    //Then, the array would be "for'ed" through once again and part numbers would be determined and sorted.

    public static boolean IsLineOnTopEdgeOfMatrix(int LineNumber){
        // Returns true if a given line is on the top edge of a matrix, which is true only when it's line zero.
        return LineNumber == 0;
    }

    public static boolean IsLineOnBottomEdgeOfMatrix(int LineNumber, String[][] matrix){
        // Returns true if a line is on the bottom edge of a matrix, which is true only when it's matching the matrix's length (- one, because of how it's counted).
        return LineNumber == (matrix.length - 1);
    }
}
