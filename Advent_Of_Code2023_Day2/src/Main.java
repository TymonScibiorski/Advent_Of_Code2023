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
//        if (isPossible(line)){
//            return getID(line);
//        }
        return 0;
    }

    public static boolean isPossible(String SingleSet){
        String[] data = SingleSet.split(", ");
        for (int i = 0; i<data.length; i++){
            if (data[i].matches("red")){
                int amountOfRedCubes = Integer.valueOf(String.valueOf(data[i].matches("\\d")));
            }
            if (data[i].matches("")){

            }
            if (data[i].matches("")){

            }
        }

    }

    public static String[] extractData(String line){
        return new String[]{ExtractGameNumber(splitAtColons(line)[0]), }
    }

    public static String[] splitAtSemicolons(String line){
        return line.split("; ");
    }

    public static String[] splitAtColons(String line){
        return line.split(": ");
    }

    public static int ExtractGameNumber(String GameInt){
        return Integer.parseInt(GameInt.substring(GameInt.length()-1));
    }
}
