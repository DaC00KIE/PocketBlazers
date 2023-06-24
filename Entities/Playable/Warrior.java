package Entities.Playable;

import Entities.*;

public class Warrior extends Characters {

    public Warrior() {
        this.name = "Warrior";
        this.level = 1;

        this.initialHP = 90;
        this.HP = this.initialHP;

        this.initialATK = 20;
        this.ATK = this.initialATK;

        this.initialDEF = 10;
        this.DEF = this.initialDEF;

        this.initialSPD = 120;
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
