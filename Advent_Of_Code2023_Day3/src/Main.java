import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

    }

//    public static int FinalFunctionForPartOne(){
//
//        return SumAllNumbersInAnArray(ArrayOfValidNumbers);
//    }

    public static boolean IsAPartNumber(String[][] matrix, int NumbersLine, int NumbersPlaceInLine){
        boolean out = false;
        int NumbersLength = matrix[NumbersLine][NumbersPlaceInLine].length();

        while (out == false){
            for (int i = NumbersPlaceInLine; i < NumbersLength+NumbersPlaceInLine; i++) {
                if(IsASymbol(
                        matrix[NumbersLine][i]
                )){
                    out = true;
                    break;
                }
            }
        }

        return out;
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

    public static boolean IsASymbol(String character){
        if (character.length()!=1){
            return false;
        }
        if(character.matches("\\d+")){
            return false;
        }
        if(character.matches("^.")){
            return false;
        }
        //Symbols can't be digits, dots or longer than one.

        if(character.matches("[@#\\$%&*\\-\\+=]")){
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

    //I figure the code should "for" through the input and convert it into a two-dimensional array.
    //This array would store three types of objects: Periods, Symbols and Numbers
    //Then, the array would be "for'ed" through once again and part numbers would be determined and sorted.

}
