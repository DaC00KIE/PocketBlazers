package Entities.Enemies;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Entities.Characters;
import Entities.TeamOf;

public class Enemies extends Characters {
    Scanner s = new Scanner(System.in);
    Random r = new Random();

    public Enemies(int number) {
        this.name = "Basic Mob " + number;

        this.initialHP = 50;
        this.HP = this.initialHP;

        this.initialATK = 10;
        this.ATK = this.initialATK;

        this.initialDEF = 5;
        this.DEF = this.initialDEF;

        this.initialSPD = 80;
        this.SPD = this.initialSPD;

        this.teamOf = TeamOf.ENEMY;

        calculateActionValue();
    }

    @Override
    public void act(ArrayList<Characters> playerTeam) {
        while (canAct == true) {

            System.out.printf("===== %s's turn to act =====\n", this.name);
            attack(playerTeam);

            this.actionValue = this.initialActionValue;
            canAct = false;
        }
    }

    @Override
    public void attack(ArrayList<Characters> allInCombat) {
        Characters selectedTarget = selectTarget(allInCombat, "none");
        int dmgTaken = selectedTarget.takeDMG(this.getATK());
        System.out.printf("%s attacked %s for %d dmg...", this.name, selectedTarget.getName(), dmgTaken);
        s.nextLine();
    }

    @Override
    public Characters selectTarget(ArrayList<Characters> allInCombat, String whatFor) {
        ArrayList<Characters> availableTargets = new ArrayList<Characters>();

        for (Characters chara : allInCombat) {
            if (chara.isDead()) {
                continue;
            }
            if (chara.getTeam() == TeamOf.ENEMY) {
                continue;
            }
            availableTargets.add(chara);
        }

        int chosenTarget = r.nextInt(availableTargets.size());

        return availableTargets.get(chosenTarget);
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
