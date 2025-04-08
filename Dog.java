public class Dog extends Pet {
    private double droolRate;

    // Constructor with droolRate
    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        if (droolRate <= 0) {
            this.droolRate = 0.5;
        } else {
            this.droolRate = droolRate;
        }
    }


    // Constructor with default droolRate
    public Dog(String name, double health, int painLevel) {
        this(name, health, painLevel, 5.0);
    }


    // Getter
    public double getDroolRate() {
        return droolRate;
    }


    public int treat() {
        heal(); 

        double minutes;
        if (droolRate < 3.5) {
            minutes = (getPainLevel() * 2) / getHealth();
        } else if (droolRate <= 7.5) {
            minutes = getPainLevel() / getHealth();
        } else {
            minutes = getPainLevel() / (getHealth() * 2);
        }

        return (int) Math.ceil(minutes); 
    }


    public void speak() {
        super.speak(); 

        String bark = "bark";
        String result = bark;

        for (int i = 1; i < getPainLevel(); i++) {
            result += " " + bark;
        }

        if (getPainLevel() > 5) {
            result = result.toUpperCase();
        }

        System.out.println(result);
    }


    public boolean equals(Object o) {
        if (o instanceof Dog) {
            Dog other = (Dog) o;
            return super.equals(o) && this.droolRate == other.droolRate;
        }
        return false;
    }
}
