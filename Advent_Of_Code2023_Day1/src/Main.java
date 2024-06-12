import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int out = 0;
        try {
            File input = new File("src/input.txt");
            Scanner scanner = new Scanner(input);
            for (int i = 0; i < input.length(); i++){
                if (scanner.hasNextLine()) {
                    out += finalFunction(scanner.nextLine());
                }
            }
            System.out.println(out);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static int finalFunction(String str){
        return firstAndLastInAnArray(extractDigitsToIntArr(searchForNums(str)));
    }

    public static String searchForNums(String str){
        String out = "";

        for (int i = 0; i <= str.length(); i++){
            out = numToDigits(str.substring(0, i));
            //numToDigits gets fed letter by letter, so if two written numbers share letters
            //the first one will be returned.
            if (out.length() != str.substring(0,i).length()){
                str = out + str.substring(i);
                i = 0;
            }
            //if the lengths don't match, the numToDigits method must've found something.
            //The string is modified, otherwise the code would keep repeating with the original,
            // i.e. eightwo, and "two" would be found first, which is what this function is meant to prevent
        }
        return out;
    }

    public static String numToDigits(String str){
        //the string must be checked letter by letter, otherwise eightwo give eigh2 not 8wo like it's supposed to

        str = str.replaceAll("one", "1");
        str = str.replaceAll("two","2");
        str = str.replaceAll("three","3");
        str = str.replaceAll("four","4");
        str = str.replaceAll("five","5");
        str = str.replaceAll("six","6");
        str = str.replaceAll("seven","7");
        str = str.replaceAll("eight","8");
        str = str.replaceAll("nine","9");


        return str;
    }

    public static String extractDigitsToString(String str){
        return str.replaceAll("[^0-9]", "");
        //if it's not in the regex 0-9 it gets thrown out (replaced with nothing)
        //returns a string that contains only the digits from the input string
    }

    public static int[] extractDigitsToIntArr(String str){
        String strDigits = extractDigitsToString(str);
        //string containing only the digits from the original string
        char[] charArrDigits = strDigits.toCharArray();
        //char array containing only the digits from the original string
        int[] digits = new int[strDigits.length()];
        //int array of the size of the string containing only digits from the original string

        for (int i = 0; i<strDigits.length(); i++){
            digits[i] = Integer.parseInt(String.valueOf(charArrDigits[i]));
        }
        //fills the int array called digits with the digits from the original string
        return digits;

    }


    public static int firstAndLastInAnArray(int[] intArr){
        return Integer.parseInt(String.valueOf(intArr[0])+String.valueOf(intArr[intArr.length-1]));
        //returns an integer that is made out of the first and last int
    }


}
