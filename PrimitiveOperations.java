// Jesse Reid HW01 Primitive Operations assignment

public class PrimitiveOperations {

    public static void main(String[] args) {
        // Declare two variables, and int and a double
        int varNum;
        double floatingPoint;

        // Initialize the variables
        varNum = 46;
        floatingPoint = 23.99;

        // Print the variables
        System.out.println(varNum);
        System.out.println(floatingPoint);

        // Multiply the two original variables and save as a new variable
        double dubADub = varNum * floatingPoint;
        // Print new variable
        System.out.println(dubADub);

        // Cast int to a float and store as a new variable
        float newFloat = (float) varNum;
        // Print new variable
        System.out.println(newFloat);

        // Cast original double to an int and store as a new variable
        int newInt = (int) floatingPoint;
        // Print new variable
        System.out.println(newInt);

        // Declare a char and assign an uppercase letter to it
        char varLetter;
        varLetter = 'J';
        // Print the letter
        System.out.println(varLetter);

        // Using numerical operation, change the letter to the same letter in lowercase
        char newLetter = (char) (varLetter + 32);
        // Print the new letter
        System.out.println(newLetter);

    }
    
    
}
