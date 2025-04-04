public class Pond {
    public static void main(String[] args) {
        // Create 4 Frog objects
        Frog peepo = new Frog("Peepo");
        Frog pepe = new Frog("Pepe", 10, 15.0);
        Frog peepaw = new Frog("Peepaw", 4.6, 5.0);
        Frog kermet = new Frog("Kermet", 3, 10.0);

        // Create 3 Fly objects
        Fly fly1 = new Fly(1, 3);      // mass 1, speed 3
        Fly fly2 = new Fly(6);         // mass 6, default speed
        Fly fly3 = new Fly(0.5, 5);    // custom Fly

        // Set species to "1331 Frogs"
        Frog.setSpecies("1331 Frogs");

        // Print description of Peepo
        System.out.println(peepo);

        // Peepo attempts to eat fly2 (mass 6)
        peepo.eat(fly2);

        // Print description of fly2
        System.out.println(fly2);

        // Peepo grows by 8 months
        peepo.grow(8);

        // Peepo attempts to eat fly2 again
        peepo.eat(fly2);

        // Print description of fly2 again
        System.out.println(fly2);

        // Print updated description of Peepo
        System.out.println(peepo);

        // Print description of your custom frog
        System.out.println(kermet);

        // Peepaw grows by 4 months
        peepaw.grow(4);

        // Print description of Peepaw
        System.out.println(peepaw);

        // Print description of Pepe
        System.out.println(pepe);
    }
}
