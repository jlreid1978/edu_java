
public class Fly {
    private double mass = 5.0;
    private double speed = 10.0;


    // Method returns status string of fly's condition
    public String toString(){
        String status;
        if (mass > 0){
            status = "I'm a speedy fly with " + speed + " speed and " + mass + " mass.";
        }
        else{
            status = "I'm dead, but I used to be a fly with a speed of " + speed + ".";
        }

        return status;
    }


    // Method to allow growth and speed increments for fly
    public void grow(int increase){
        mass = mass + increase;

        if (mass < 20){
            speed = speed + increase;
        }
        else if (mass >= 20){
            speed = (mass - 20) * 0.5;
        }
    }


    // Method to check to see if fly is alive
    public boolean isDead(){
        boolean dead = false;

        if (mass <= 0){
            dead = true;
        }

        return dead;
    }


    // Main method
    public static void main(String[] args){

    }
      
}
