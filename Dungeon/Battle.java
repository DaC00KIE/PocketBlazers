package Dungeon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

import Entities.*;
import Entities.Enemies.*;
import Entities.Playable.*;

public class Battle {
    Random r = new Random();
    Scanner s = new Scanner(System.in);

    private ArrayList<Characters> playerTeam = new ArrayList<Characters>();
    private ArrayList<Characters> enemyTeam = new ArrayList<Characters>();
    private ArrayList<Characters> allInCombat = new ArrayList<Characters>();
    private int skillPoints = 3;
    private boolean battleEnd = false;

    public static void main(String[] args) {
        Battle battle = new Battle();
        battle.test();
    }

    public void test() {
        playerTeam.add(new Warrior());
        playerTeam.add(new Tank());
        playerTeam.add(new Cleric());

        start("normal");
    }

    public void start(String whatFor) {

        enemyTeam = generateEnemyTeam(whatFor);

        allInCombat.addAll(playerTeam);
        allInCombat.addAll(enemyTeam);

        displayInfo(skillPoints);

        while (!battleEnd) {
            for (int i = 0; i < allInCombat.size(); i++) {
                Characters chara = allInCombat.get(i);
                if (chara.isDead()) {
                    continue;
                }

                chara.traverseTurn();

                if (chara.canAct()) {
                    chara.act(allInCombat);
                    displayInfo(skillPoints);
                }

                if (teamAllDead(playerTeam) || teamAllDead(enemyTeam)) {
                    System.out.println("battle has ended");
                    battleEnd = true;
                    break;
                }
            }
        }

    }

    public ArrayList<Characters> generateEnemyTeam(String whatFor) {
        ArrayList<Characters> temp = new ArrayList<Characters>();

        switch (whatFor) {
            case "elite": // elites
                System.out.println("generating ELITE enemies");

                break;
            case "boss": // bosses
                System.out.println("generating BOSS enemies");

                break;
            default: // normal
                System.out.println("generating NORMAL enemies");
                for (int i = 1; i <= r.nextInt(1, 4); i++) {
                    temp.add(new Enemies(i));
                }
                break;
        }

        return temp;
    }

    public void displayTurnOrder() {
        // creates new arrayList made up of alive peoples
        ArrayList<Characters> listTurnOrder = new ArrayList<Characters>();
        for (Characters chara : allInCombat) {
            if (!chara.isDead()) {
                listTurnOrder.add(chara);
            }
        }

        // sorts the arraylist by lowest action value
        Collections.sort(listTurnOrder, new Comparator<Characters>() {
            @Override
            public int compare(Characters chara1, Characters chara2) {
                return Integer.compare(chara1.getActionValue(), chara2.getActionValue());
            }
        });

        System.out.print("\nNext to Act: ");

        int limit = 4;
        if (listTurnOrder.size() < limit) {
            limit = listTurnOrder.size();
        }

        for (int i = 0; i < limit; i++) {
            Characters chara = listTurnOrder.get(i);
            System.out.printf("[%d] %s ", i + 1, chara.getName());
        }
    }

    public void displayInfo(int skillPoints) {
        System.out.println("\n===== ENEMY TEAM =====");
        for (Characters chara : enemyTeam) {
            if (chara.isDead()) {
                System.out.printf("%-12s DEAD\t| ", chara.getName());
            } else {
                System.out.printf("%-18s | ", chara.getName());
            }

            System.out.printf("HP: %-3d/%-3d | Act. Val: %d\n", chara.getHP(), chara.getInitialHP(),
                    chara.getActionValue());
        }

        System.out.printf("===== PLAYER TEAM ===== Skill Points: (%d/5)\n", skillPoints);
        for (Characters chara : playerTeam) {
            System.out.printf("%-18s | HP: %-3d/%-3d | Act. Val: %d\n", chara.getName(), chara.getHP(),
                    chara.getInitialHP(), chara.getActionValue());
        }

        displayTurnOrder();

        System.out.print("... Press [Enter] to continue...");
        s.nextLine();
    }

    public boolean teamAllDead(ArrayList<Characters> team) {
        int totalTeam = team.size();

        int totalDead = 0;

        for (Characters chara : team) {
            if (chara.isDead()) {
                totalDead += 1;
            }
        }
        if (totalDead == totalTeam) {
            return true;
        } else
            return false;
    }

}
