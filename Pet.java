import java.util.Locale;

public abstract class Pet {
    private String name;
    private double health;
    private int painLevel;

    public Pet(String name, double health, int painLevel) {
        this.name = name;
        this.health = Math.max(0.0, Math.min(health, 1.0));
        this.painLevel = Math.max(1, Math.min(painLevel, 10));
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public int getPainLevel() {
        return painLevel;
    }

    public abstract int treat();

    public void speak() {
        String message = "Hello! My name is " + name;
        if (painLevel > 5) {
            System.out.println(message.toUpperCase(Locale.ROOT));
        } else {
            System.out.println(message);
        }
    }

    protected void heal() {
        this.health = 1.0;
        this.painLevel = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return name.equals(pet.name);
    }
}