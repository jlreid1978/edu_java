import java.util.Arrays;

public class Gameplay {
    public static void main(String[] args) {



    //     // Create BlueAstronauts
        BlueAstronaut bob = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut heath = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut albert = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut angel = new BlueAstronaut("Angel", 0, 1, 0);

        // Create RedAstronauts
        RedAstronaut liam = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut sus = new RedAstronaut("Suspicious Person", 100, "expert");


    
        // Step-by-step simulation
        System.out.println("=== Liam sabotages Bob ===");
        liam.sabotage(bob); 
        System.out.println(bob);

        System.out.println("\n=== Liam tries to freeze Suspicious Person (should do nothing) ===");
        liam.freeze(sus);
        System.out.println(sus);

        System.out.println("\n=== Liam freezes Albert ===");
        liam.freeze(albert);
        System.out.println("Albert: " + albert);
        System.out.println("Liam: " + liam);

        System.out.println("\n=== Albert tries to call emergency meeting (should do nothing) ===");
        albert.emergencyMeeting();

        System.out.println("\n=== Suspicious Person calls emergency meeting (tie between Bob & Heath) ===");
        sus.emergencyMeeting();

        System.out.println("\n=== Bob calls emergency meeting (Suspicious Person frozen) ===");
        bob.emergencyMeeting();
        System.out.println(sus);

        System.out.println("\n=== Heath completes tasks (2 times) ===");
        heath.completeTask();
        System.out.println(heath);
        heath.completeTask(); 
        System.out.println(heath);
        heath.completeTask(); 

        System.out.println("\n=== Liam tries to freeze Angel (fails, Liam's susLevel doubles) ===");
        liam.freeze(angel);
        System.out.println("Liam: " + liam);
        System.out.println("Angel: " + angel);

        System.out.println("\n=== Liam sabotages Bob twice ===");
        liam.sabotage(bob); 
        liam.sabotage(bob); 
        System.out.println(bob);

        System.out.println("\n=== Liam freezes Bob ===");
        liam.freeze(bob);
        System.out.println(bob);

        System.out.println("\n=== Angel calls emergency meeting (Liam should be frozen, crewmates win) ===");
        angel.emergencyMeeting();
        // The "Crewmates win!" 


        
        // Imposter path:

        // System.out.println("\n=== Liam sabotages Heath 5 times ===");
        // liam.sabotage(heath); // 15 -> 18
        // liam.sabotage(heath); // 18 -> 22
        // liam.sabotage(heath); // 22 -> 27
        // liam.sabotage(heath); // 27 -> 33
        // liam.sabotage(heath); // 33 -> 41
        // System.out.println(heath);

        // System.out.println("\n=== Liam freezes Heath ===");
        // liam.freeze(heath);
        // System.out.println("Heath: " + heath);

        // if (heath.isFrozen() && liam.isFrozen()){
        //     System.out.println("Imposters win!");
        // }
        // "Impostors win!" 
        
    }
}
