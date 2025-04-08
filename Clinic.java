import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Clinic {
    private File patientFile;
    private int day;

    // Constructors
    public Clinic(File file) {
        this.patientFile = file;
        this.day = 1;
    }

    public Clinic(String fileName) {
        this(new File(fileName));
    }

    // Methods
    public String nextDay(File f) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(f);
        Scanner input = new Scanner(System.in);
        StringBuilder result = new StringBuilder();

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] parts = line.split(",");

            String name = parts[0];
            String type = parts[1];
            String spec = parts[2];
            String timeIn = parts[3];

            System.out.printf("Consultation for %s the %s at %s.\n", name, type, timeIn);
            double health = getValidDouble(input, "What is the health of " + name + "?\n");
            int painLevel = getValidInt(input, "On a scale of 1 to 10, how much pain is " + name + " in right now?\n");

            Pet pet;

            if (type.equals("Dog")) {
                pet = new Dog(name, health, painLevel, Double.parseDouble(spec));
            } else if (type.equals("Cat")) {
                pet = new Cat(name, health, painLevel, Integer.parseInt(spec));
            } else {
                throw new InvalidPetException();
            }

            pet.speak();
            int treatmentTime = pet.treat();
            String timeOut = addTime(timeIn, treatmentTime);

            result.append(String.format("%s,%s,%s,Day %d,%s,%s,%.1f,%d\n", name, type, spec, day, timeIn, timeOut, health, painLevel));
        }

        fileScanner.close();
        day++;
        return result.toString().trim();
    }

    public String nextDay(String fileName) throws FileNotFoundException {
        return nextDay(new File(fileName));
    }

    public boolean addToFile(String patientInfo) {
        try {
            Scanner scanner = new Scanner(patientFile);
            StringBuilder newContent = new StringBuilder();
            boolean patientExists = false;
            String nameToMatch = patientInfo.split(",")[0];

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith(nameToMatch + ",")) {
                    newContent.append(line).append("\n");
                    patientExists = true;
                }
            }
            scanner.close();

            PrintWriter writer = new PrintWriter(patientFile);
            writer.print(newContent.toString());

            if (patientExists) {
                writer.println(patientInfo.split(",", 4)[3]); // Write only appointment info for old patient
            } else {
                writer.println(patientInfo);
            }

            writer.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private String addTime(String timeIn, int treatmentTime) {
        int hour = Integer.parseInt(timeIn.substring(0, 2));
        int minute = Integer.parseInt(timeIn.substring(2));

        minute += treatmentTime;
        hour += minute / 60;
        minute %= 60;

        return String.format("%02d%02d", hour, minute);
    }

    private double getValidDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Please enter a number");
                scanner.next(); // discard invalid input
            }
        }
    }

    private int getValidInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Please enter a number");
                scanner.next(); // discard invalid input
            }
        }
    }
}
