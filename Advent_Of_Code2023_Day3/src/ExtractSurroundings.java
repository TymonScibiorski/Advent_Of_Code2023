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
        int lineAboveSize = LineAbove.size(); // This variable has to be declared, because if the "LineAbove.size()" was put raw into the for loop then the value, size, would change dynamically
        for (int i = 0; i < lineAboveSize; i++) {
            out.push(LineAbove.pop());
        }

        out.push(ExtractIndexOnTheLeftInMatrix(matrix, lineNumber, placeInLineIndex));
        out.push(ExtractIndexOnTheRightInMatrix(matrix, lineNumber, placeInLineIndex));

        Stack<String> LineBelow = ExtractLineBelowInMatrix(matrix, lineNumber, placeInLineIndex, targetsLength);
        int lineBelowSize = LineBelow.size(); // This variable has to be declared, because if the "LineBelow.size()" was put raw into the for loop then the value, size, would change dynamically
        for (int i = 0 ; i < lineBelowSize; i++) {
            out.push(LineBelow.pop());
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

        if(ExtractTopRightDiagonalInMatrix(matrix, lineNumber, placeInLineIndex) != null){
            out.push(ExtractTopRightDiagonalInMatrix(matrix, lineNumber, placeInLineIndex));
        }

        return out;
    }

    public static String ExtractTopLeftDiagonalInMatrix(String[][] matrix, int lineNumber, int placeInLineIndex){
        if(!isIndexInBoundsOfMatrix(matrix, lineNumber-1, placeInLineIndex-1)){
            return null;
        }
        return matrix[lineNumber-1][placeInLineIndex-1];
    }

    public static Stack<String> ExtractDirectlyOnTopInMatrix(String[][] matrix, int lineNumber, int placeInLineIndex){
        // Extracts directly above the target string.
        // Example:
//        String[][] matrix = {
//                {"$", ".", "1"},
//                {"*", ".", "@"},
//                {"-", "=", "+"}
//        };
        // For index 1, 1 the output Stack will contain ".". For index 0,2 the output Stack will contain null
        Stack<String> out = new Stack<>();
        int targetsLength = matrix[lineNumber][placeInLineIndex].length();

        for (int i = placeInLineIndex; i < placeInLineIndex+targetsLength; i++) {
            if(!isIndexInBoundsOfMatrix(matrix, lineNumber-1, i)){
                out.push(null);
                continue;
            }
            String currentString = matrix[lineNumber-1][i];

            if(isANumber(currentString)){ // If the string under inspection is a number, then the code should skip ahead the number's length
                i += currentString.length();
            }

            out.push(currentString);
        }

        return out;
    }

    public static boolean executeExtractTopRightDiagonalInMatrix(String[][] matrix, int lineNumber, int placeInLineIndex){
        int targetsLength = matrix[lineNumber][placeInLineIndex].length();

        for (int i = placeInLineIndex; i < placeInLineIndex+targetsLength; i++) {
            if(!isIndexInBoundsOfMatrix(matrix, lineNumber-1, i)){
                continue;
            }
            String currentString = matrix[lineNumber-1][i];

            if(isANumber(currentString)){ // If the string under inspection is a number, then the code should skip ahead the number's length
                i += currentString.length();
            }

            if(i == (placeInLineIndex+targetsLength+1)){
                return false;
            }
        }

        return true;
    }

    public static String ExtractTopRightDiagonalInMatrix(String[][] matrix, int lineNumber, int placeInLineIndex){
        boolean shouldBeExecuted = executeExtractTopRightDiagonalInMatrix(matrix, lineNumber, placeInLineIndex);
        boolean isInBounds = isIndexInBoundsOfMatrix(matrix, lineNumber - 1, placeInLineIndex + 1);
        if(!isInBounds || !shouldBeExecuted){
            return null;
        }
        return matrix[lineNumber-1][placeInLineIndex+1];
    }



    public static String ExtractIndexOnTheLeftInMatrix(String[][] matrix, int lineNumber, int placeInLineIndex){
        if(!isIndexOnLeftEdgeOfMatrix(placeInLineIndex)){
            return matrix[lineNumber][placeInLineIndex-1];
        }
        return null;
    }

    public static String ExtractIndexOnTheRightInMatrix(String[][] matrix, int lineNumber, int placeInLineIndex){
        if(!isIndexOnRightEdgeOfMatrix(matrix, lineNumber, placeInLineIndex)){
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

        // Bottom-left diagonal, if it exists
        out.push(ExtractBottomLeftDiagonalInMatrix(matrix, lineNumber, placeInLineIndex));

        // Directly below
        Stack<String> directlyBelow = ExtractDirectlyBelowInMatrix(matrix, lineNumber, placeInLineIndex);
        for (int i = 0; i < directlyBelow.size(); i++) {
            out.push(directlyBelow.pop());
        }

        // Bottom-right diagonal, if it exists
        if(ExtractBottomRightDiagonalInMatrix(matrix, lineNumber, placeInLineIndex) != null){
            out.push(ExtractBottomRightDiagonalInMatrix(matrix, lineNumber, placeInLineIndex));
        }

        return out;
    }


    public static String ExtractBottomLeftDiagonalInMatrix(String[][] matrix, int lineNumber, int placeInLineIndex){
        if(!isIndexInBoundsOfMatrix(matrix, lineNumber+1, placeInLineIndex-1)){
            return null;
        }
        return matrix[lineNumber+1][placeInLineIndex-1];
    }

    public static Stack<String> ExtractDirectlyBelowInMatrix(String[][] matrix, int lineNumber, int placeInLineIndex){
        Stack<String> out = new Stack<>();
        int targetsLength = matrix[lineNumber][placeInLineIndex].length();

        for (int i = placeInLineIndex; i < placeInLineIndex+targetsLength; i++) {
            if(!isIndexInBoundsOfMatrix(matrix, lineNumber+1, i)){
                out.push(null);
                continue;
            }
            String currentString = matrix[lineNumber+1][i];

            if(isANumber(currentString)){ // If the string under inspection is a number, then the code should skip ahead the number's length
                i += currentString.length();
            }

            out.push(currentString);
        }

        return out;
    }

    public static boolean executeExtractBottomRightDiagonalInMatrix(String[][] matrix, int lineNumber, int placeInLineIndex){
        int targetsLength = matrix[lineNumber][placeInLineIndex].length();

        for (int i = placeInLineIndex; i < placeInLineIndex+targetsLength; i++) {
            if(!isIndexInBoundsOfMatrix(matrix, lineNumber+1, i)){
                continue;
            }
            String currentString = matrix[lineNumber+1][i];

            if(isANumber(currentString)){ // If the string under inspection is a number, then the code should skip ahead the number's length
                i += currentString.length();
            }

            if(i == (placeInLineIndex+targetsLength+1)){ //if i is equal to placeInLineIndex+targetsLength+1 it must've done the ExtractBottomRight's job
                return false;
            }
        }

        return true;
    }

    public static String ExtractBottomRightDiagonalInMatrix(String[][] matrix, int lineNumber, int placeInLineIndex){
        if(!isIndexInBoundsOfMatrix(matrix, lineNumber+1, placeInLineIndex+1) || !executeExtractBottomRightDiagonalInMatrix(matrix, lineNumber, placeInLineIndex)){
            return null;
        }
        return matrix[lineNumber+1][placeInLineIndex+1];
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

        return placeInLine <= 0;
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

        return (placeInLine >= matrix[lineNumber].length - 1);
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

    public static boolean isIndexInBoundsOfMatrix(String[][] matrix, int lineNumber, int placeInLineIndex){
        return (placeInLineIndex >= 0 && lineNumber >= 0 && lineNumber < matrix.length && placeInLineIndex < matrix[lineNumber].length);
    }
}