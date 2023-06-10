package EquipAndWeap;

public class Equipment {
    // boots = spd; helmet = hp; gloves = atk; cpiece = def.
    // maybe have another piece for random stats between those?

    protected int hp, atk, def, spd, rarity;
    protected EquipType type;

    public Equipment(EquipType type, int rarity) {
        this.rarity = rarity;

        switch (this.rarity) {
            case 1:
            case 2:
            case 3:
        }

        switch (type) {
            case BOOTS:
                break;
            case CHESTPLATE:
                break;
            case GLOVES:
                break;
            case HELMET:
                break;

        }
    }
}
