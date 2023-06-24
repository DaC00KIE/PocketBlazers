package Entities;

import java.util.ArrayList;
import java.util.Scanner;

import Entities.Enemies.Enemies;

public abstract class Characters {
    Scanner s = new Scanner(System.in);

    // attributes
    protected String name;
    protected int level;
    protected int HP, ATK, DEF, SPD;
    protected int initialHP, initialATK, initialDEF, initialSPD;
    protected int actionValue, initialActionValue;
    protected boolean isDead = false, canAct = false;
    protected TeamOf teamOf;

    // getter-setter
    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public TeamOf getTeam() {
        return this.teamOf;
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

    public int getActionValue() {
        return this.actionValue;
    }

    public int getInitialHP() {
        return this.initialHP;
    }

    public int getInitialATK() {
        return this.initialATK;
    }

    public int getInitialDEF() {
        return this.initialDEF;
    }

    public int getInitialSPD() {
        return this.initialSPD;
    }

    public int getInitialActionValue() {
        return this.initialActionValue;
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

    public void canNowAct() {
        this.canAct = true;
    }

    // methods
    public void calculateActionValue() {
        this.initialActionValue = 10000 / this.SPD;
        this.actionValue = this.initialActionValue;
    }

    // battling
    public void traverseTurn() {
        this.actionValue -= 1;

        if (this.actionValue <= 0) {
            this.actionValue = 0;
            canNowAct();
        }
    }

    public void act(ArrayList<Characters> allInCombat) {
        if (canAct) {
            System.out.printf("%s's turn to act...", this.name);
            s.nextLine();
            System.out.println("just attack frfr");
            attack(allInCombat);

            this.actionValue = this.initialActionValue;
            this.canAct = false;
        }
    }

    public void attack(ArrayList<Characters> allInCombat) {
        Characters selectedTarget = selectTarget(allInCombat, "none");
        int dmgTaken = selectedTarget.takeDMG(this.getATK());
        System.out.printf("%s attacked %s for %d dmg...", this.name, selectedTarget.getName(), dmgTaken);
        s.nextLine();
    }

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

    public Characters selectTarget(ArrayList<Characters> allInCombat, String whatFor) {
        ArrayList<Characters> availableTargets = new ArrayList<Characters>();

        System.out.println("\nAvailable Targets:");
        for (Characters chara : allInCombat) {
            if (chara.isDead) {
                continue;
            }

            switch (whatFor) { // can choose between selecting only team8s, enemies, or both
                case "team":
                    if (chara.getTeam() == TeamOf.ENEMY) {
                        continue;
                    }
                    break;

                case "all":
                    break;

                default:
                    if (chara.getTeam() != TeamOf.ENEMY) {
                        continue;
                    }
                    break;
            }

            availableTargets.add(chara);
        }

        for (Characters chara : availableTargets) {
            System.out.printf("[%d] %18s | %3d/%-3d\n", availableTargets.indexOf(chara), chara.getName(), chara.getHP(),
                    chara.getInitialHP());
        }
        System.out.print("Select Target: ");
        int chosenTarget = s.nextInt();
        System.out.println("");
        return availableTargets.get(chosenTarget);
    }

    // skill shit
    public abstract void useSkill();

    public abstract String skillName();
}
