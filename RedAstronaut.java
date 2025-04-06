public class RedAstronaut extends Player implements Impostor{
    String skill;

    // constructors
    public RedAstronaut(String name, int susLevel, String skill){
        super(name, susLevel);
        this.skill = skill;
    }


    public RedAstronaut(String name){
        this(name, 15, "experienced)");
    }


    // methods
    public void emergencyMeeting(){
        if (this.isFrozen()) return;

        Player mostSus = null;

        for (Player p : getPlayers()){
            if (!p.isFrozen() && !p.equals(this)){
                if (mostSus == null || p.getSusLevel() > mostSus.getSusLevel()){
                    mostSus = p;
                }
            }
        }

        boolean tie = false;
        for (Player p : getPlayers()){
            if (!p.equals(this) && !p.isFrozen() && !p.equals(mostSus) && p.getSusLevel() == mostSus.getSusLevel()){
              tie = true;
              break;  
            }
        }

        if (!tie && mostSus != null){
            mostSus.setFrozen(true);
        }
    }


    public void freeze(Player p){
        if (this.isFrozen() || p.isFrozen() || p instanceof Impostor) return;

        if (this.getSusLevel() < p.getSusLevel()){
            p.setFrozen(true);
        } else{
            this.setSusLevel(this.getSusLevel() * 2);
        }
    }


    public void sabotage(Player p){
        if (this.isFrozen() || p.isFrozen() || p instanceof Impostor) return;

        int increase = this.getSusLevel() < 20 ? 2 : 1;
        p.setSusLevel(p.getSusLevel() + p.getSusLevel() / increase);
    }


    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        RedAstronaut other = (RedAstronaut) o;

        return this.getSusLevel() == other.getSusLevel()
        && this.isFrozen() == other.isFrozen()
        && this.getName().equals(other.getName())
        && this.skill.equals(other.skill);
    }


    public String toString(){
        String base = super.toString();
        return base + " I am an " + this.skill + " player!";
    }
}
