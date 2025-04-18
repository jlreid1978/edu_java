public class Dog extends Pet {
    private double droolRate;

    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        this.droolRate = (droolRate <= 0) ? 0.5 : droolRate;
    }

    public Dog(String name, double health, int painLevel) {
        this(name, health, painLevel, 5.0);
    }

    public double getDroolRate() {
        return droolRate;
    }

    @Override
    public int treat() {
        double currentHealth = getHealth();
        int currentPainLevel = getPainLevel();
        int treatmentTime;
        if (droolRate < 5.0) {
            treatmentTime = (int) Math.ceil((currentPainLevel * 2.0) / currentHealth);
        } else {
            treatmentTime = (int) Math.ceil(currentPainLevel / currentHealth);
        }
        heal(); // Heal after treatment time is calculated
        return treatmentTime;
    }



    @Override
    public void speak() {
        super.speak(); // Call the Pet's speak method
        for (int i = 0; i < getPainLevel(); i++) {
            System.out.print("bark");
            if (i < getPainLevel() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return Double.compare(dog.droolRate, droolRate) == 0;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" I drool at a rate of %.2f liters per hour.", droolRate);
    }

}
