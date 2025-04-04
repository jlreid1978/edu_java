public class BlueAstronaut{
    private int numTasks;
    private int taskSpeed;

    // constructors
    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed){
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }


    // methods
    public void emergencyMeeting(){
        if (this.isFrozen()) return;

        Player mostSus = null;

        for (Player p : players){
            if (!p.isFrozen() && !p.equals(this)){
                if (mostSus == null || p.getSusLevel() > mostSus.getSusLevel()){
                    mostSus = p;
                }
            }
        }

        boolean tie = false;
        for (Player p : players){
            if (!p.equals(this) && !p.isFrozen() && !p.equals(mostSus) && p.getSusLevel() == mostSus.getSusLevel()){
                tie = true;
                break;
            }
        }

        if (!tie){
            mostSus.freeze();
        }
    }


    public void completeTask(){
        if (this.isFrozen() || numTasks == 0) return;

        if (taskSpeed > 20){
            numTasks -= 2;
        } else{
            numTasks -= 1;
        }

        if (numTasks < 0) numTasks = 0;

        if (numTasks == 0){
            this.setSusLevel(this.getSusLevel() /2);
        }
    }


    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        BlueAstronaut other = (BlueAstronaut) o;

        return this.getSusLevel() == other.getSusLevel() 
            && this.isFrozen() == other.isFrozen()
            && this.getName().equals(other.getName())
            && this.numTasks == other.numTasks
            && this.taskSpeed == other.taskSpeed;
    }


    public String toString(){
        String status = this.isFrozen() ? "frozen" : "not frozen";
        return super.toString() + String.format(" I have %d tasks left and %d task speed.", numTasks, taskSpeed);
    }
}
