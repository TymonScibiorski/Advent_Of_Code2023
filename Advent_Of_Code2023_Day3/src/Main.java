import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public static int FinalFunctionForPartOne(){

        return SumAllNumbersInAnArray(ArrayOfValidNumbers);
    }

    public static List<String> StringWithSymbolsDotsAndNumbersToStrArray(String line){
        char[] ChoppedUpLine = line.toCharArray();
        List out = new List<>;

        for (int i = 0; i < ChoppedUpLine.length; i++) {
            if (IsANumber(ChoppedUpLine[i]) == false){
                out.add(String.valueOf(ChoppedUpLine[i]));
            }
        }

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
