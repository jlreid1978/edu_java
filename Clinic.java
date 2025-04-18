import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Clinic {
    private File patientFile;
    private int day;
    private List<Pet> currentPatients = new ArrayList<>();

    public Clinic(File file) {
        this.patientFile = file;
        this.day = 1;
        loadCurrentPatients();
    }

    public Clinic(String fileName) {
        this(new File(fileName));
    }

    private void loadCurrentPatients() {
        try (Scanner scanner = new Scanner(patientFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length >= 8) {
                    String name = parts[0];
                    String species = parts[1];
                    try {
                        double health = Double.parseDouble(parts[6]);
                        int painLevel = Integer.parseInt(parts[7]);
                        if (species.equalsIgnoreCase("Dog") && parts.length >= 3) {
                            double droolRate = Double.parseDouble(parts[2]);
                            currentPatients.add(new Dog(name, health, painLevel, droolRate));
                        } else if (species.equalsIgnoreCase("Cat") && parts.length >= 3) {
                            int miceCaught = Integer.parseInt(parts[2]);
                            currentPatients.add(new Cat(name, health, painLevel, miceCaught));
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing patient data in Patients.csv: " + line + " - " + e.getMessage());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Patient file not found: " + patientFile.getName());
        }
    }

    public String nextDay(File f) throws FileNotFoundException {
        StringBuilder dailyReport = new StringBuilder();
        Scanner appointmentScanner = null;
        Scanner inputScanner = new Scanner(System.in);
        try {
            appointmentScanner = new Scanner(f);
            day++;

            while (appointmentScanner.hasNextLine()) {
                String line = appointmentScanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0].trim();
                    String typeOfPet = parts[1].trim();
                    String specialAttributeStr = parts[2].trim();
                    String timeIn = parts[3].trim();

                    System.out.printf("Consultation for %s the %s at %s.\n", name, typeOfPet, timeIn);

                    try {
                        if (!typeOfPet.equals("Dog") && !typeOfPet.equals("Cat")) {
                            throw new InvalidPetException();
                        }

                        double health = -1;
                        while (health < 0.0 || health > 1.0) {
                            System.out.printf("What is the health of %s?\n", name);
                            String healthInput = inputScanner.nextLine();
                            try {
                                health = Double.parseDouble(healthInput);
                            } catch (NumberFormatException e) {
                                System.out.println("Please enter a number for health.");
                            }
                        }

                        int painLevel = -1;
                        while (painLevel < 1 || painLevel > 10) {
                            System.out.printf("On a scale of 1 to 10, how much pain is %s in right now?\n", name);
                            String painInput = inputScanner.nextLine();
                            try {
                                painLevel = Integer.parseInt(painInput);
                            } catch (NumberFormatException e) {
                                System.out.println("Please enter a number for pain level.");
                            }
                        }

                        double initialHealth = health;
                        int initialPainLevel = painLevel;

                        Pet pet = null;
                        if (typeOfPet.equals("Dog")) {
                            pet = new Dog(name, health, painLevel, Double.parseDouble(specialAttributeStr));
                        } else if (typeOfPet.equals("Cat")) {
                            pet = new Cat(name, health, painLevel, Integer.parseInt(specialAttributeStr));
                        }

                        pet.speak();
                        int treatmentTime = pet.treat();
                        String timeOut = addTime(timeIn, treatmentTime);

                        String patientInfo;
                        if (pet instanceof Dog) {
                            patientInfo = String.format("%s,%s,%.1f,Day %d,%s,%s,%.1f,%d",
                                    name, typeOfPet, ((Dog) pet).getDroolRate(), day, timeIn, timeOut, initialHealth, initialPainLevel);
                        } else if (pet instanceof Cat) {
                            patientInfo = String.format("%s,%s,%d,Day %d,%s,%s,%.1f,%d",
                                    name, typeOfPet, ((Cat) pet).getMiceCaught(), day, timeIn, timeOut, initialHealth, initialPainLevel);
                        } else {
                            patientInfo = ""; // Should not happen
                        }
                        dailyReport.append(patientInfo).append("\n");

                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing special attribute for " + name + ": " + specialAttributeStr);
                        continue;
                    } catch (InvalidPetException e) {
                        System.err.println(e.getMessage());
                        // Handle the exception for the test - maybe return a specific string
                        dailyReport.append("Invalid Pet Type: ").append(typeOfPet).append("\n");
                    }
                }
            }
        } finally {
            if (appointmentScanner != null) {
                appointmentScanner.close();
            }
            if (inputScanner != null) {
                inputScanner.close();
            }
        }
        return dailyReport.toString().trim();
    }




    public String nextDay(String fileName) throws FileNotFoundException {
        return nextDay(new File(fileName));
    }





public boolean addToFile(String patientInfo) {
        File tempFile = new File("temp.csv");
        List<String> updatedLines = new ArrayList<>();
        String nameToAdd = patientInfo.split(",")[0];
        boolean found = false;
        String[] newParts = patientInfo.split(",");

        try (Scanner fileScanner = new Scanner(patientFile);
             PrintWriter tempWriter = new PrintWriter(tempFile)) {

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] existingParts = line.split(",");
                if (existingParts[0].equals(nameToAdd)) {
                    found = true;
                    StringBuilder updatedLine = new StringBuilder();
                    if (newParts.length >= 8) {
                        updatedLine.append(newParts[0]).append(","); // name
                        updatedLine.append(newParts[1]).append(","); // species
                        updatedLine.append(newParts[2]).append(","); // special attribute (NEW: using new value)
                        updatedLine.append("Day ").append(day).append(","); // day
                        updatedLine.append(newParts[4]).append(","); // timeIn
                        updatedLine.append(newParts[5]).append(","); // timeOut
                        updatedLine.append(newParts[6]).append(","); // health
                        updatedLine.append(newParts[7]);             // painLevel
                        updatedLines.add(updatedLine.toString());
                    } else {
                        updatedLines.add(line); // If new data is incomplete, keep the old line
                    }
                } else {
                    updatedLines.add(line);
                }
                tempWriter.println(updatedLines.get(updatedLines.size() - 1));
            }

            if (!found && newParts.length >= 8) {
                tempWriter.println(patientInfo);
            } else if (!found) {
                // Handle case where new patient info is incomplete? (Currently does nothing)
            }

        } catch (IOException e) {
            System.err.println("Error processing patient file: " + e.getMessage());
            return false;
        }

        patientFile.delete();
        return tempFile.renameTo(patientFile);
    }








    private String addTime(String timeIn, int treatmentTime) {
        int hours = Integer.parseInt(timeIn.substring(0, 2));
        int minutes = Integer.parseInt(timeIn.substring(2));
        minutes += treatmentTime;
        hours += minutes / 60;
        minutes %= 60;
        hours %= 24;

        return String.format("%02d%02d", hours, minutes);
    }

    public static class InvalidPetException extends RuntimeException {
        public InvalidPetException() {
            super("Your pet is invalid!");
        }

        public InvalidPetException(String s) {
            super(s);
        }
    }
}