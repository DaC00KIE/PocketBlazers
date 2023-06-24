package EquipAndWeap;

import Entities.*;

public abstract class Weapons {

    // attributes
    protected String name, skillName;
    protected int atk, hp, def, spd, rarity;
    protected CharType type;

    // getter-setter
    public String getName() {
        return this.name;
    }

    public String getSkillName() {
        return this.skillName;
    }

    public int getAtk() {
        return this.atk;
    }

    public int getHp() {
        return this.hp;
    }

    public int getDef() {
        return this.def;
    }

    public int getSpd() {
        return this.spd;
    }

    public int getRarity() {
        return this.rarity;
    }

    public CharType getType() {
        return this.type;
    }

}
