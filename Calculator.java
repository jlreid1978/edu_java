// Jesse Reid HW02 Calculator assignment
import java.util.Scanner;

public class Calculator {

    // Menu method
    public static String Menu (Scanner scanner, String options) {
        // Print menu options
        System.out.println(options);
        // Obtain user input
        System.out.print("Enter an operation:\n");
        String result = scanner.nextLine().toLowerCase();

        // Return result from user
        return result;
    }


    // Add method
    public static void Addition(Scanner scanner) {
        // Obtain two integers from the user
        System.out.print("Enter two integers:\n");
        String integers = scanner.nextLine();

        // Split the ints into a list
        String[] values = integers.split(" ");
        
        // Check that there are two values in the list. if so, convert from string to int and print out answer
        if (values.length == 2) {
            try {
                int[] ints = new int[2];
                ints[0] = Integer.parseInt(values[0]);
                ints[1] = Integer.parseInt(values[1]);

                System.out.println("Answer: " + (ints[0] + ints[1]));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input entered. Terminating...");
            }
        } else {
            System.out.println("Invalid input entered. Terminating...");
        }

    }


    // Subtract method
    public static void Subtraction(Scanner scanner) {
        // Obtain two integers from the user
        System.out.print("Enter two integers:\n");
        String integers = scanner.nextLine();

        // Split the ints into a list
        String[] values = integers.split(" ");

        // Check that there are two values in the list. if so, convert from string to int and print out answer
        if (values.length == 2) {
            try {
                int[] ints = new int[2];
                ints[0] = Integer.parseInt(values[0]);
                ints[1] = Integer.parseInt(values[1]);

                System.out.println("Answer: " + (ints[0] - ints[1]));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input entered. Terminating...");
            }
        } else {
            System.out.println("Invalid input entered. Terminating...");
        }

    }


    // Division method
    public static void Division(Scanner scanner) {
        System.out.print("Enter two doubles:\n");
        String integers = scanner.nextLine();

        // Split the ints into a list
        String[] values = integers.split(" ");

        // Check that there are two values in the list. if so, convert from string to int and print out answer
        if (values.length == 2) {
            try {
                double[] dubs = new double[2];
                dubs[0] = Double.parseDouble(values[0]);
                dubs[1] = Double.parseDouble(values[1]);

                if (dubs[1] != 0) {
                    System.out.printf("Answer: %.2f\n", (dubs[0] / dubs[1]));
                } else {
                    System.out.println("Invalid input entered. Terminating...");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input entered. Terminating...");
            }
        } else {
            System.out.println("Invalid input entered. Terminating...");
        }
    }


    // Multiplication method
    public static void Multiplication(Scanner scanner) {
        System.out.print("Enter two doubles:\n");
        String integers = scanner.nextLine();

        // Split the ints into a list
        String[] values = integers.split(" ");

        // Check that there are two values in the list. if so, convert from string to int and print out answer
        if (values.length == 2) {
            try {
                double[] dubs = new double[2];
                dubs[0] = Double.parseDouble(values[0]);
                dubs[1] = Double.parseDouble(values[1]);

                System.out.printf("Answer: %.2f\n", (dubs[0] * dubs[1]));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input entered. Terminating...");
            }
        } else {
            System.out.println("Invalid input entered. Terminating...");
        }
    }


    // Alphebetize method
    public static void Alphebetization(Scanner scanner) {
        System.out.print("Enter two words:\n");
        String integers = scanner.nextLine();

        // Split the ints into a list
        String[] values = integers.split(" ");

        if (values.length == 2) {
            int compResult = values[0].toLowerCase().compareTo(values[1].toLowerCase());

            if (compResult < 0) {
                System.out.printf("Answer: %s comes before %s alphabetically.\n", values[0], values[1]);
            } else if (compResult > 0) {
                System.out.printf("Answer: %s comes before %s alphabetically.\n", values[1], values[0]);
            } else {
                System.out.printf("Chicken or Egg.\n");
            }
        } else {
            System.out.println("Invalid input entered. Terminating...");
        }
    }


    public static void main(String[] args) {
        // Create an instance of scanner
        Scanner scanner = new Scanner(System.in);

        // Set the menu options
        String options = "List of operations: add subtract multiply divide alphabetize";

        // Obtain user options
        String result = Menu(scanner, options);

        switch (result) {
            case "add":
                Addition(scanner);
                break;
            case "subtract":
                Subtraction(scanner);
                break;
            case "multiply":
                Multiplication(scanner);
                break;
            case "divide":
                Division(scanner);
                break;
            case "alphabetize":
                Alphebetization(scanner);
                break;
            default:
                System.out.println("Invalid input entered. Terminating...");
                break;
        }
        
        // Close scanner 
        scanner.close();

    }
    
}