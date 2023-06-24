package Entities.Playable;

import Entities.*;

public class Cleric extends Characters {

    public Cleric() {
        this.name = "Cleric";
        this.level = 1;

        this.initialHP = 120;
        this.HP = this.initialHP;

        this.initialATK = 10;
        this.ATK = this.initialATK;

        this.initialDEF = 5;
        this.DEF = this.initialDEF;

        this.initialSPD = 100;
        this.SPD = this.initialSPD;

        calculateActionValue();
    }

    @Override
    public void useSkill() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'useSkill'");
    }

    @Override
    public String skillName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'skillName'");
    }

}
