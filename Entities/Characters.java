package Entities;

public abstract class Characters {

    // attributes
    String name;
    protected int HP, ATK, DEF, SPD;
    protected int maxHP, maxATK, maxDEF, maxSPD;
    Skills skill;
    boolean isDead = false, canAct = false;

    // getter-setter
    public String getName() {
        return this.name;
    }

    public int getHP() {
        return this.HP;
    }

    public int getATK() {
        return this.ATK;
    }

    public int getDEF() {
        return this.DEF;
    }

    public int getSPD() {
        return this.SPD;
    }

    public int getMaxHP() {
        return this.maxHP;
    }

    public int getMaxATK() {
        return this.maxATK;
    }

    public int getMaxDEF() {
        return this.maxDEF;
    }

    public int getMaxSPD() {
        return this.maxSPD;
    }

    public Skills getSkill() {
        return this.skill;
    }

    public void setSkill(Skills skill) {
        this.skill = skill;
    }

    public boolean isDead() {
        return this.isDead;
    }

    public void died() {
        this.isDead = true;
    }

    public boolean canAct() {
        return this.canAct;
    }

    // methods
    public abstract void act();

    public int takeDMG(int dmgDealt) {

        int dmgTaken = dmgDealt - (this.DEF / 4);
        if (dmgTaken <= 0) {
            dmgTaken = 0;
        }

        this.HP -= dmgTaken;
        if (this.HP <= 0) {
            this.HP = 0;
            this.died();
        }
        return dmgTaken;
    }
}
