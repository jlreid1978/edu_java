public abstract class Pet {
    private String name;
    private double health;
    private int painLevel;

    // Constructor
    public Pet(String name, double health, int painLevel) {
        this.name = name;


        // Health between 0.0 and 1.0
        if (health > 1.0) {
            this.health = 1.0;
        } else if (health < 0.0) {
            this.health = 0.0;
        } else {
            this.health = health;
        }


        // PainLevel between 1 and 10
        if (painLevel > 10) {
            this.painLevel = 10;
        } else if (painLevel < 1) {
            this.painLevel = 1;
        } else {
            this.painLevel = painLevel;
        }
    }


    // Getters
    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public int getPainLevel() {
        return painLevel;
    }


    // Abstract method
    public abstract int treat();

    // Speak method
    public void speak() {
        String message = "Hello! My name is " + name;
        if (painLevel > 5) {
            System.out.println(message.toUpperCase());
        } else {
            System.out.println(message);
        }
    }


    public boolean equals(Object o) {
        if (o instanceof Pet) {
            Pet other = (Pet) o;
            return this.name.equals(other.name);
        }
        return false;
    }

    // Heal method - protected
    protected void heal() {
        this.health = 1.0;
        this.painLevel = 1;
    }
}
