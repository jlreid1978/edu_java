public class Frog {
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    private static String species = "Rare Pepe";

    // Constructors
    public Frog(String name, int ageInMonths, double tongueSpeed){
        this.name = name;
        this.age = ageInMonths;
        this.tongueSpeed = tongueSpeed;
        updateFrogletStatus();
    }


    public Frog(String name, double ageInYears, double tongueSpeed){
        this(name, (int)(ageInYears * 12), tongueSpeed);
    }


    public Frog(String name){
        this(name, 5, 5.0);
    }


    private void updateFrogletStatus() {
        if (age >= 1 && age <= 7) {
            isFroglet = true;
        } else {
            isFroglet = false;
        }
    }


    // getters and setters
    public static String getSpecies(){
        return species;
    }


    public static void setSpecies(String newSpecies){
        species = newSpecies;
    }

    
    // Method to make the frog grow
    public void grow() {
        age += 1;
        if (age <= 12) {
            tongueSpeed += 1;
        } else if (age >= 30 && tongueSpeed > 5){
            tongueSpeed -= 1;
        }
        updateFrogletStatus();
    }
    
    
    public void grow(int months) {
        for (int i = 0; i < months; i++) {
            grow();
        }
    }
    

    // Method for the frog to eat
    public void eat(Fly fly){
        if (fly.isDead()){
            return;
        }

        if (tongueSpeed > fly.getSpeed()){
            if (fly.getMass() >= 0.5 * age){
            grow(1);
        }
        fly.setMass(0);

        } else{
            fly.grow(1);
        }

    }


    // Method to describe the status of the frog
    public String toString(){
        if (isFroglet){
            return String.format("My name is %s and I'm a rare froglet! I'm %d months old and my tongue has a speed of %.2f.", name, age, tongueSpeed);
        } else{
            return String.format("My name is %s and I'm a rare frog. I'm %d months old and my tongue has a speed of %.2f.", name, age, tongueSpeed);
        }
    }   
}
