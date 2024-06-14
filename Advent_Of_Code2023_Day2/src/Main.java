import java.io.File;
import java.io.FileNotFoundException;
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

    public static int finalFunction(String line){
        String[] gameIntAndSets = splitAtColons(line);
        String[] Sets = splitAtSemicolons(gameIntAndSets[1]);
        for(int i = 0; i<Sets.length; i++){
            if(!isPossible(Sets[i])){
                return 0;
            }
        }
        return getID(gameIntAndSets[0]);
    }

    public static boolean isPossible(String SingleSet){
        String[] data = SingleSet.split(", ");
        for (int i = 0; i<data.length; i++) {
            if (12 < amountOfRed(data, i)) {
                return false;
            }

            if (13 < amountOfGreen(data, i)) {
                return false;
            }

            if(14 < amountOfBlue(data, i)){
                return false;
            }
        }
        return true; //if none of the subsets exceeded the limit of 12 red, 13 green or 14 blue, then the game is possible
    }

    public static int amountOfRed(String[] data, int i){
        if (IsRed(data, i)){
                return Integer.parseInt(data[i].split(" ")[0]);
            }
        return 0;
    }
    public static int amountOfGreen(String[] data, int i){
        if (IsGreen(data, i)){
                return Integer.parseInt(data[i].split(" ")[0]);
            }
        return 0;
    }
    public static int amountOfBlue(String[] data, int i){
        if (IsBlue(data, i)){
                return Integer.parseInt(data[i].split(" ")[0]);
            }
        return 0;
    }

    public static boolean IsRed(String[] data, int i){
        if (data[i].matches("\\d+ red")){
            return true;
        }
        return false;
    }
    public static boolean IsGreen(String[] data, int i){
        if (data[i].matches("\\d+ green")){
            return true;
        }
        return false;
    }
    public static boolean IsBlue(String[] data, int i){
        if (data[i].matches("\\d+ blue")){
            return true;
        }
        return false;
    }

    public static String[] splitAtSemicolons(String line){
        return line.split("; ");
    }

    public static String[] splitAtColons(String line){
        return line.split(": ");
    }

    public static int getID(String GameInt){
        return Integer.parseInt(GameInt.substring(GameInt.length()-1));
    }
}
