// Jesse Reid HW01 String Operations assignment

public class StringOperations {

    public static void main(String[] args) {
        // Create a new String object, assign my name to it, then print it
        String varName = "Jesse";
        System.out.println(varName);


        // Replace the first letter of my name with an A, then the last letter with a Z, then print the result
        String replacedFirst = "A" + varName.substring(1);
        String replacedLast = replacedFirst.substring(0, replacedFirst.length() - 1) + "Z";
        System.out.println(replacedLast);

        // Declare a new String, give it the value of a web address, then print the new variable
        String varAddress = "www.github.com";
        System.out.println(varAddress);

        // Strip the name from the variable and concatenate "1331" to the end, then print the result.
        String replacedAddress = varAddress.substring(4, varAddress.lastIndexOf('.')) + "1331";
        System.out.println(replacedAddress);

    }
    
    
}
