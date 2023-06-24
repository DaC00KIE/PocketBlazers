package Entities.Playable;

import Entities.*;

public class Tank extends Characters {

    public Tank() {
        this.name = "Tank";
        this.level = 1;

        this.initialHP = 100;
        this.HP = this.initialHP;

        this.initialATK = 10;
        this.ATK = this.initialATK;

        this.initialDEF = 20;
        this.DEF = this.initialDEF;

        this.initialSPD = 95;
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
