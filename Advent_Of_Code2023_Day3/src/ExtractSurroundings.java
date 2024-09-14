import java.util.Stack;

public class ExtractSurroundings {
    public static Stack<String> ExtractSurroundings(String[][] matrix, int lineNumber, int placeInLineIndex){
        //This function extracts strings surrounding a provided coordinate in a matrix
        //Example:
        // matrix = {
        //      {"$", "#", "@"},
        //      {"*", "1", "%"},
        //      {"-", "=", "+"}
        //        };
        // A stack containing the following strings would be returned: "$", "#", "@", "*", "%", "-", "=", "+"

        Stack<String> out = new Stack<>();
        
        int targetsLength = matrix[lineNumber][placeInLineIndex].length();

        //Adding all stacks to the outStack
        Stack<String> LineAbove = ExtractLineAboveInMatrix(matrix, lineNumber, placeInLineIndex);
        for (String currentStringInStackLineAbove : LineAbove) {
            out.push(currentStringInStackLineAbove);
        }

        out.push(ExtractIndexOnTheLeftInMatrix(matrix, lineNumber, placeInLineIndex));
        out.push(ExtractIndexOnTheRightInMatrix(matrix, lineNumber, placeInLineIndex));

        Stack<String> LineBelow = ExtractLineBelowInMatrix(matrix, lineNumber, placeInLineIndex, targetsLength);
        for (String currentStringInStackLineBelow : LineBelow) {
            out.push(currentStringInStackLineBelow);
        }


        return out;
    }

    public static Stack<String> ExtractLineAboveInMatrix(String[][] matrix, int lineNumber, int placeInLineIndex){
        // Extracts contents that are directly above and diagonally to the top-right and top-left to a certain target.
        // Example:
//        String[][] matrix1 = {
//                {"$", "46", "1"},
//                {"*", ".", "@", "5"},
//                {"-", "=", "+", "."}
//        };
        // Returns a stack containing: 1, 46, $
        Stack<String> out = new Stack<>();
        if(isLineOnTopEdgeOfMatrix(lineNumber)){
            return out;
        }

        // Top-left diagonal, if it exists
        out.push(ExtractTopLeftDiagonalInMatrix(matrix, lineNumber, placeInLineIndex));

        // Directly above
        Stack<String> directlyAbove = ExtractDirectlyOnTopInMatrix(matrix, lineNumber, placeInLineIndex);
        for (int i = 0; i < directlyAbove.size(); i++) {
            out.push(directlyAbove.pop());
        }

        // Top-right diagonal, if it exists
        out.push(ExtractTopRightDiagonalInMatrix(matrix, lineNumber, placeInLineIndex));

        return out;
    }

    public static String ExtractTopLeftDiagonalInMatrix(String[][] matrix, int lineNumber, int placeInLineIndex){
        if(isIndexOnLeftEdgeOfMatrix(placeInLineIndex-1)){
            return null;
        }
        return matrix[lineNumber-1][placeInLineIndex-1];
    }

    public static Stack<String> ExtractDirectlyOnTopInMatrix(String[][] matrix, int lineNumber, int placeInLineIndex){
        Stack<String> out = new Stack<>();
        int targetsLength = matrix[lineNumber][placeInLineIndex].length();

        for (int i = placeInLineIndex; i < placeInLineIndex+targetsLength; i++) {
            if(isIndexOnLeftEdgeOfMatrix(i) || isIndexOnRightEdgeOfMatrix(matrix, lineNumber-1, i)){
                continue;
            }
            String currentString = matrix[lineNumber-1][i];

            if(isANumber(currentString)){ // If the string under inspection is a number,
                i += currentString.length();
            }

            out.push(currentString);
        }

        return out;
    }

    public static String ExtractTopRightDiagonalInMatrix(String[][] matrix, int lineNumber, int placeInLineIndex){
        if(isIndexOnRightEdgeOfMatrix(matrix, lineNumber-1, placeInLineIndex)){
            return null;
        }
        return matrix[lineNumber-1][placeInLineIndex+1];
    }



    public static String ExtractIndexOnTheLeftInMatrix(String[][] matrix, int lineNumber, int placeInLineIndex){
        if(isIndexOnLeftEdgeOfMatrix(placeInLineIndex)){
            return matrix[lineNumber][placeInLineIndex-1];
        }
        return null;
    }

    public static String ExtractIndexOnTheRightInMatrix(String[][] matrix, int lineNumber, int placeInLineIndex){
        if(isIndexOnRightEdgeOfMatrix(matrix, lineNumber, placeInLineIndex)){
            return matrix[lineNumber][placeInLineIndex+1];
        }
        return null;
    }


    public static Stack<String> ExtractLineBelowInMatrix(String[][] matrix, int lineNumber, int placeInLineIndex, int targetsLength){
        // Extracts contents that are directly above and diagonally to the top-right and top-left to a certain target.
        // Example:
//        String[][] matrix1 = {
//                {"$", "46", "1"},
//                {"*", ".", "@", "5"},
//                {"-", "=", "+", "."}
//        };
        // Returns a stack containing: 1, 46, $
        Stack<String> out = new Stack<>();

        if(isLineOnBottomEdgeOfMatrix(lineNumber, matrix)){
            return out;
        }

        // Extracts bottom-left diagonal, if it exists
        out.push(ExtractBottomLeftDiagonalInMatrix(matrix, lineNumber, placeInLineIndex));

        // Extracts directly beneath the entire target's length
        for (int i = placeInLineIndex; i < placeInLineIndex+targetsLength; i++) {
            String currentString = matrix[lineNumber+1][i];

            if(isANumber(currentString)){
                i += currentString.length();
            }

            out.push(currentString);
        }

        // Extracts bottom-right diagonal, if it exists
        out.push(ExtractBottomRightDiagonalInMatrix(matrix, lineNumber, placeInLineIndex));

        return out;
    }

    public static String ExtractBottomRightDiagonalInMatrix(String[][] matrix, int lineNumber, int placeInLineIndex){
        if(isIndexOnRightEdgeOfMatrix(matrix, lineNumber+1, placeInLineIndex)){
            return null;
        }
        return matrix[lineNumber+1][placeInLineIndex+1];
    }

    public static String ExtractBottomLeftDiagonalInMatrix(String[][] matrix, int lineNumber, int placeInLineIndex){
        if(isIndexOnLeftEdgeOfMatrix(placeInLineIndex-1)){
            return null;
        }
        return matrix[lineNumber+1][placeInLineIndex-1];
    }


    public static boolean isANumber(String str){
        // Takes in a String and determines if it's a written number.
        if(str.matches("\\d+")){
            return true;
        }
        return false;
    }

    public static boolean isANumber(char ch){
        // Takes in a char and determines if it's a written number.
        if(String.valueOf(ch).matches("\\d")){
            return true;
        }
        return false;
    }

    public static boolean isIndexOnLeftEdgeOfMatrix(int placeInLine){
        // Determines if a specific item is on the left end of a line in a matrix.
        // matrix = {
        //      {"$", "#", "@"},
        //      {"*", "%", "1"},
        //      {"-", "=", "+"}
        //        };
        // If supplied the x coordinate of either "$", "*" or "-" the method would return True,
        // and False for any of the following: "#", "@", "%", "1", "=", "+"

        return placeInLine > 0;
    }
    public static boolean isIndexOnRightEdgeOfMatrix(String[][] matrix, int lineNumber, int placeInLine){
        // Determines if a specific item is on the right end of a line in a matrix.
        // matrix = {
        //      {"$", "#", "@"},
        //      {"*", "%", "1"},
        //      {"-", "=", "+"}
        //        };
        // If supplied with this matrix and the coordinates of either "@", "1" or "+" the method would return True,
        // and False for any of the following: "$", "#", "*", "%", "-", "="

        if(placeInLine >= matrix[lineNumber].length-1){
            return true;
        }
        return false;
    }


    //I figure the code should "for" through the input and convert it into a two-dimensional array.
    //This array would store three types of objects: Periods, Symbols and Numbers
    //Then, the array would be "for'ed" through once again and part numbers would be determined and sorted.

    public static boolean isLineOnTopEdgeOfMatrix(int lineNumber){
        // Returns true if a given line is on the top edge of a matrix, which is true only when it's line zero.
        return lineNumber < 0;
    }

    public static boolean isLineOnBottomEdgeOfMatrix(int lineNumber, String[][] matrix){
        // Returns true if a line is on the bottom edge of a matrix, which is true only when it's matching the matrix's length (- one, because of how it's counted).
        return lineNumber >= (matrix.length - 1);
    }
}
