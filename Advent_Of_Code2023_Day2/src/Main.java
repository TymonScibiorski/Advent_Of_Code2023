import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int out = 0;
        try {
            File input = new File("src/input.txt");
            Scanner scanner = new Scanner(input);
            for (int i = 0; i < input.length(); i++){ //foring through the input data
                if (scanner.hasNextLine()) {
                    out += finalFunction(scanner.nextLine()); //final function returns game's number if it was possible
                }
            }
            System.out.println(out);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int finalFunction(String line){
        String[] gameIntAndSets = splitAtColons(line); //gameIntAndSets contains "Game x" and all subsets in a single line
        String[] Sets = splitAtSemicolons(gameIntAndSets[1]); //Sets contains single subsets

        for(int i = 0; i<Sets.length; i++){ //foring through the sets
            if(!isPossible(Sets[i])){ //If even a single one is not possible, the game doesn't count, so 0 is returned
                return 0;
            }
        }
        //If none of the subsets were impossible, the function returns int "x" from "Game x"
        return getID(gameIntAndSets[0]);
    }

    public static boolean isPossible(String SingleSet){ //Checks if a single subset is possible
        String[] data = SingleSet.split(", "); //The amounts of cubes are formatted in the following style: "x red, y green, z blue" in no particular order of colors

        for (int i = 0; i<data.length; i++) {
            if (12 < amountOfRedCubes(data, i)) { //the limits were provided in the task description
                return false;
            }

            if (13 < amountOfGreenCubes(data, i)) {
                return false;
            }

            if(14 < amountOfBlueCubes(data, i)){
                return false;
            }
        }
        return true; //if none of the subsets exceeded the limit of 12 red, 13 green or 14 blue, then the game is possible
    }

    public static int amountOfRedCubes(String[] data, int i){
        if (IsRed(data, i)){
                return Integer.parseInt(data[i].split(" ")[0]); //the values are separated from the color declaration by a space like so: "x red". The same is true for the following methods
            }
        return 0;
    }
    public static int amountOfGreenCubes(String[] data, int i){
        if (IsGreen(data, i)){
                return Integer.parseInt(data[i].split(" ")[0]);
            }
        return 0;
    }
    public static int amountOfBlueCubes(String[] data, int i){
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

    public static int getID(String GameAndInt){ //takes the string containing game number "Game x" and returns int of x
        String[] GameAndGameInt = GameAndInt.split(" ");
        return Integer.parseInt(GameAndGameInt[1]);
    }
}
