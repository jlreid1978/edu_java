public class Cat extends Pet {
    private int miceCaught;

    public Cat(String name, double health, int painLevel, int miceCaught) {
        super(name, health, painLevel);
        this.miceCaught = (miceCaught < 0) ? 0 : miceCaught;
    }

    public Cat(String name, double health, int painLevel) {
        this(name, health, painLevel, 0);
    }

    public int getMiceCaught() {
        return miceCaught;
    }

    @Override
    public int treat() {
        double currentHealth = getHealth();
        int currentPainLevel = getPainLevel();
        int treatmentTime;
        if (miceCaught < 4) {
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
        for (int i = 0; i < getMiceCaught(); i++) {
            System.out.print("meow");
            if (i < getMiceCaught() - 1) {
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
        Cat cat = (Cat) o;
        return miceCaught == cat.miceCaught;
    }


    @Override
    public String toString() {
        return super.toString() + String.format(" I caught %d %s today!", 
            miceCaught, (miceCaught == 1 ? "mouse" : "mice"));
    }
    

}