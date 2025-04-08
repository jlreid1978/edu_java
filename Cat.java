public class Cat extends Pet {
    private int miceCaught;

    // Constructor with miceCaught
    public Cat(String name, double health, int painLevel, int miceCaught) {
        super(name, health, painLevel);
        if (miceCaught < 0) {
            this.miceCaught = 0;
        } else {
            this.miceCaught = miceCaught;
        }
    }

    // Default miceCaught 0
    public Cat(String name, double health, int painLevel) {
        this(name, health, painLevel, 0);
    }

    // Getter
    public int getMiceCaught() {
        return miceCaught;
    }


    public int treat() {
        heal(); // from Pet

        double minutes;
        if (miceCaught < 4) {
            minutes = (getPainLevel() * 2) / getHealth();
        } else if (miceCaught <= 7) {
            minutes = getPainLevel() / getHealth();
        } else {
            minutes = getPainLevel() / (getHealth() * 2);
        }

        return (int) Math.ceil(minutes);
    }


    public void speak() {
        super.speak();

        String meow = "meow";
        String result = meow;

        for (int i = 1; i < miceCaught; i++) {
            result += " " + meow;
        }

        if (getPainLevel() > 5) {
            result = result.toUpperCase();
        }

        System.out.println(result);
    }


    public boolean equals(Object o) {
        if (o instanceof Cat) {
            Cat other = (Cat) o;
            return super.equals(o) && this.miceCaught == other.miceCaught;
        }
        return false;
    }
}
