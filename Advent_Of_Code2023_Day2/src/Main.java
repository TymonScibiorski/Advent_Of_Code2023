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

    public static String[] splitToSubsets(String line){
        String[] subsets = line.split("; ");
        return subsets;
    }

}
