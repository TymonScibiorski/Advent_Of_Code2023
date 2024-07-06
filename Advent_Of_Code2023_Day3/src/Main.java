public class Main {
    public static void main(String[] args) {

    }

    public static boolean IsASymbol(String character){
        if (character.length()!=1){
            return false;
        }
        if(character.matches("\\d+") || character.matches("^.")){
            return false;
        }
        return true;
    }

    //I figure the code should "for" through the input and convert it into a two-dimensional array.
    //This array would store three types of objects: Periods, Symbols and Numbers
    //Then, the array would be "for'ed" through once again and part numbers would be determined and sorted.

}
