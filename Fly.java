public class Fly{
    private double mass;
    private double speed;

    // Constructors
    public Fly(double mass, double speed){
        this.mass = mass;
        this.speed = speed;
    }


    public Fly(double mass){
        this(mass, 10.0);
    }


    public Fly(){
        this(5.0, 10.0);
    }


    // Getters and setters
    public double getMass(){
        return mass;
    }


    public void setMass(double mass){
        this.mass = mass;
    }


    public double getSpeed(){
        return speed;
    }


    public void setSpeed(double speed){
        this.speed = speed;
    }
      

    // Method returns status string of fly's condition
    public String toString(){
        String status;
        if (mass > 0){
            status = String.format("I'm a speedy fly with %.2f speed and %.2f mass.", speed, mass);
        }
        else{
            status = String.format("I'm dead, but I used to be a fly with a speed of %.2f.", speed);
        }

        return status;
    }


    // Method to allow growth and speed increments for fly
    public void grow(int increase){
        mass = mass + increase;

        if (mass < 20){
            speed += increase;
        } else if (mass == 20){
            speed = 10;
        } else{
            speed = Math.max(0.0, (mass - 20) * 0.5);
        }
    }


    // Method to check to see if fly is alive
    public boolean isDead(){
        return mass <= 0;
    }      
}
