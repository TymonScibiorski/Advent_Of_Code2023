import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println(FinalFunctionForPartOne());
    }
    // TODO: The IsAPartNumber method is not functioning properly, indexes can go out of bounds for the above and below line of the checked number.

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

        int NumbersLength = matrix[NumbersLine][NumbersPlaceInLine].length();

        if(!IsANumber(matrix[NumbersLine][NumbersPlaceInLine])){
            return false;
            // A partNumber must be a number.
        }

        // Checking the line above the number, if it exists (if the number's line isn't the first one).
        if(NumbersLine != 0) {
            int OneIfNumberOnTheLeftEdge = 0;
            int OneIfNumberOnTheRightEdge = 0;
            if(IsOnTheLeftEdgeOfTheMatrix(NumbersPlaceInLine)){
                OneIfNumberOnTheLeftEdge = 1;
            }
            if (IsOnTheRightEdgeOfTheMatrix(matrix, NumbersLine, NumbersPlaceInLine)){
                OneIfNumberOnTheRightEdge = 1;
            }

                for (int i = NumbersPlaceInLine + OneIfNumberOnTheLeftEdge; i < NumbersLength + NumbersPlaceInLine + OneIfNumberOnTheRightEdge; i++) {
                    if (IsASymbol(
                            matrix[NumbersLine - 1][i]
                    )) {
                        return true;
                    }
                }
        }

        // Checking the line of the number, if the number isn't on an edge of the matrix.
        if (IsOnTheLeftEdgeOfTheMatrix(NumbersLine)){ // Checking if the number isn't on the left edge.
            if(IsASymbol(matrix[NumbersLine][NumbersPlaceInLine-1])){
                return true;
            }
        }
        if (IsOnTheRightEdgeOfTheMatrix(matrix, NumbersLine, NumbersPlaceInLine)) { // Checking if the number isn't on the right edge.
            if (IsASymbol(matrix[NumbersLine][NumbersPlaceInLine + NumbersLength])){
                return true;
            }
        }

        // Checking the line after the number, if number's line isn't the last one in the matrix
        if(NumbersLine+1 < matrix.length) {
            int OneIfNumberOnTheLeftEdge = 0;
            int OneIfNumberOnTheRightEdge = 0;
            if(NumbersPlaceInLine == 0){
                OneIfNumberOnTheLeftEdge = 1;
            }
            if (NumbersLength + NumbersPlaceInLine < matrix[NumbersLine + 1].length){
                OneIfNumberOnTheRightEdge = 1;
            }

            for (int i = NumbersPlaceInLine + OneIfNumberOnTheLeftEdge; i < NumbersLength + NumbersPlaceInLine + OneIfNumberOnTheRightEdge; i++) {
                if (IsASymbol(
                        matrix[NumbersLine + 1][i]
                )) {
                    return true;
                }
            }
        }

        return false;
    }

    public static String[] RawInputLineToStrArray(String line){
        // This method takes a line and returns an array that will be usable by the code.
        // Examples:
        // "...." -> [".", ".", ".", "."]
        // "..46.." -> [".", ".", "46", ".", "."]

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
        if(str.equals(".")){
            return false;
        }
        if (str.length()!=1){
            return false;
        }
        if(str.matches("\\d+")){
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

    public static boolean IsOnTheRightEdgeOfTheMatrix(String[][] matrix, int LineNumber, int placeInLine){
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

    public static boolean IsOnTheLeftEdgeOfTheMatrix(int placeInLine){
        // Determines if a specific item is on the left end of a line in a matrix.
        // matrix = {
        //      {"$", "#", "@"},
        //      {"*", "%", "1"},
        //      {"-", "=", "+"}
        //        };
        // If supplied the x coordinate of either "$", "*" or "-" the method would return True,
        // and False for any of the following: "#", "@", "%", "1", "=", "+"

        if(placeInLine == 0){
            return true;
        }
        return false;
    }

    //I figure the code should "for" through the input and convert it into a two-dimensional array.
    //This array would store three types of objects: Periods, Symbols and Numbers
    //Then, the array would be "for'ed" through once again and part numbers would be determined and sorted.

}
