package Units;

import ConsoleFormatters.ConsoleFormatting;
import Interfaces.Shooter;
import Parent_Classes.Hero;
import Parent_Classes.Unit;

import java.util.Random;

public class Marksman extends Unit implements Shooter {
    public Marksman(int team) {
        super(team);
    }

    @Override
    public void attackRanged(Unit[][] battlefield, Hero allyHero, Hero enemyHero, Unit enemy) {
        //meg kell még nézni h körülötte van-e ellenséges egység - bár ezt lehet nem itt, sőt

        Random rnd = new Random();
        int basicDamage;
        if (this.getDamageThresholds()[0] == this.getDamageThresholds()[1]) {
            basicDamage = this.getUnitCount() * this.getDamageThresholds()[0];
        }
        else {
            basicDamage = rnd.nextInt(this.getUnitCount() * this.getDamageThresholds()[0], this.getUnitCount() * this.getDamageThresholds()[1]);
        }
        int critPercent = rnd.nextInt(100) + 1;
        float critModifier = (critPercent >= allyHero.getLuck() * 5? 1.5f:1f);
        System.out.println((critModifier == 1.5f? ConsoleFormatting.YELLOW_BOLD_BRIGHT + "A critical strike!" + ConsoleFormatting.RESET:""));
        System.out.println((this.getTeam() == 1? ConsoleFormatting.BLUE + " ":ConsoleFormatting.RED + " ") + getName() + ConsoleFormatting.RESET  + " has attacked " + (enemy.getTeam() == 1? ConsoleFormatting.BLUE:ConsoleFormatting.RED) + enemy.getName() + ConsoleFormatting.RESET);
        enemy.takeDamage((int)((this.getUnitCount() * basicDamage * critModifier) * (1 + 0.1f * (allyHero.getAttack() - enemyHero.getDefense()))));

    }

    @Override
    public void attack(Unit[][] battlefield, Hero allyHero, Hero enemyHero, Unit enemy) {
        Random rnd = new Random();
        int basicDamage;
        if (this.getDamageThresholds()[0] == this.getDamageThresholds()[1]) {
            basicDamage = this.getUnitCount() * this.getDamageThresholds()[0];
        }
        else {
            basicDamage = rnd.nextInt(this.getUnitCount() * this.getDamageThresholds()[0], this.getUnitCount() * this.getDamageThresholds()[1]);
        }
        int critPercent = rnd.nextInt(100) + 1;
        float critModifier = (critPercent >= allyHero.getLuck() * 5? 1.5f:1f);
        System.out.println((critModifier == 1.5f? ConsoleFormatting.YELLOW_BOLD_BRIGHT + "A critical strike!" + ConsoleFormatting.RESET:""));
        System.out.println((this.getTeam() == 1? ConsoleFormatting.BLUE + " ":ConsoleFormatting.RED + " ") + getName() + ConsoleFormatting.RESET  + " has attacked " + (enemy.getTeam() == 1? ConsoleFormatting.BLUE:ConsoleFormatting.RED) + enemy.getName() + ConsoleFormatting.RESET);
        enemy.takeDamage((int)((this.getUnitCount() * basicDamage * critModifier) * (1 + 0.1f * (allyHero.getAttack() - enemyHero.getDefense())) * 0.5f));

        if (!enemy.isRetailed()) {
            enemy.retaliate(battlefield, enemyHero, allyHero, this);
        }
    }

    @Override
    public void retaliate(Unit[][] battlefield, Hero allyHero, Hero enemyHero, Unit enemy) {
        if (!this.isFallen()) {
            System.out.println((this.getTeam() == 1? ConsoleFormatting.BLUE + " ":ConsoleFormatting.RED + " ") + this.getName() + ConsoleFormatting.RESET + " retalaites!");
            Random rnd = new Random();
            int basicDamage;
            if (this.getDamageThresholds()[0] == this.getDamageThresholds()[1]) {
                basicDamage = this.getUnitCount() * this.getDamageThresholds()[0];
            }
            else {
                basicDamage = rnd.nextInt(this.getUnitCount() * this.getDamageThresholds()[0], this.getUnitCount() * this.getDamageThresholds()[1]);
            }
            enemy.takeDamage((int)((this.getUnitCount() * basicDamage) * (1 + 0.1f * (allyHero.getAttack() - enemyHero.getDefense())) * 0.5f * 0.5f));
            this.setRetailed(true);
        }
    }
}
