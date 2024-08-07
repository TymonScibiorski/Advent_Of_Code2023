import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

    }

//    public static int FinalFunctionForPartOne(){
//
//        return SumAllNumbersInAnArray(ArrayOfValidNumbers);
//    }

    public static boolean IsAPartNumber(String[][] matrix, int NumbersLine, int NumbersPlaceInLine){
        // This method determines if a given number is a partNumber,
        // by checking if it is adjacent to a symbol with the IsASymbol method.
        // As input, it takes the matrix and the number's coordinates.

        int NumbersLength = matrix[NumbersLine][NumbersPlaceInLine].length();

        if(!matrix[NumbersLine][NumbersPlaceInLine].matches("\\d+")){
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

        // Checking the line of the number, if the number isn't on the edge of the matrix.
        if (NumbersPlaceInLine != 0){ // Checking if the number isn't on the left edge.
            if(IsASymbol(matrix[NumbersLine][NumbersPlaceInLine-1])){
                return true;
            }
        }
        if (NumbersLength+NumbersPlaceInLine < matrix[NumbersLine].length) { // Checking if the number isn't on the right edge.
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

    public static String[] StringWithSymbolsDotsAndNumbersToStrArray(String line){
        // This method takes a line and returns an array that will be usable by the code.
        // Examples:
        // "...." -> [".", ".", ".", "."]
        // "..46.." -> [".", ".", "46", ".", "."]

        char[] ChoppedUpLine = line.toCharArray();
        ArrayList<String> out = new ArrayList<>();

        for (int i = 0; i < ChoppedUpLine.length; i++) {
            if (IsANumber(ChoppedUpLine[i]) == false){
                out.add(String.valueOf(ChoppedUpLine[i]));
                continue;
            }

            if (IsANumber(ChoppedUpLine[i]) == true){
                StringBuilder Number = new StringBuilder();

                while(IsANumber(ChoppedUpLine[i])){
                    Number.append(ChoppedUpLine[i]);
                    i++;
                }

                out.add(String.valueOf(Number));
                i--;
            }
        }

        return ConvertArrayListStringToStringArray(out);
    }

    public static String[] ConvertArrayListStringToStringArray(ArrayList<String> givenArrayList){
        String[] out = new String[givenArrayList.size()];

        for (int i = 0; i < givenArrayList.size(); i++) {
            out[i] = givenArrayList.get(i);
        }
        return out;
    }

    public static int SumAllNumbersInAnArray(int[] ArrayWithNumbers){
        // This method takes in an array containing ints and returns the sum of it.
        // This method will be used in the final function, for summing all of the valid numbers in the input text.
        // The sum could be calculated in the loop determining if a number is valid,
        // but contracting two methods into one would reduce the readability and wouldn't change the BigO of the algorithm

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
        //Symbols can't be digits, dots or longer than one.

        if(str.matches("[@#\\$%&*\\-\\+=]")){
            return true;
        }
        //Symbols are any of the following: @#$%&*-+=

        return false;
    }



//    public static int ExtractNumber(String str){
//        //takes in a
//    }

    public static String CharToStr(char character){
        return String.valueOf(character);
    }

    public static boolean IsANumber(String str){
        //Takes in a String and determines if it's a number
        if(str.matches("\\d+")){
            return true;
        }
        return false;
    }

    public static boolean IsANumber(char ch){
        if(String.valueOf(ch).matches("\\d")){
            return true;
        }
        return false;
    }

    public static boolean IsOnTheRightEdgeOfTheMatrix(String[][] matrix, int LineNumber, int placeInLine){
        if(placeInLine+1 == matrix[LineNumber].length){
            return true;
        }
        return false;
    }

    public static boolean IsOnTheLeftEdgeOfTheMatrix(int placeInLine){
        if(placeInLine == 0){
            return true;
        }
        return false;
    }

    //I figure the code should "for" through the input and convert it into a two-dimensional array.
    //This array would store three types of objects: Periods, Symbols and Numbers
    //Then, the array would be "for'ed" through once again and part numbers would be determined and sorted.

}
