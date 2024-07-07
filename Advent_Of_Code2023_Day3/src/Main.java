public class Main {
    public static void main(String[] args) {

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

    //I figure the code should "for" through the input and convert it into a two-dimensional array.
    //This array would store three types of objects: Periods, Symbols and Numbers
    //Then, the array would be "for'ed" through once again and part numbers would be determined and sorted.

}
