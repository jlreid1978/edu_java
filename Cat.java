public class Cat {
    private int miceCaught;

    // Constructors
    public Cat(String name, double health, int painLevel, int miceCaught){
        if (miceCaught < 0){
            miceCaught = 0;
        }
    }

    public Cat(String name, double health, int painLevel){}

    // Methods
    public int treat(){
        return tasty;
    }


    public void speak(){}


    public boolean equals(Object o){
        return true;
    }

}
