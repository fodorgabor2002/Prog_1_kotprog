package Spells;

import ConsoleFormatters.ConsoleFormatting;
import Parent_Classes.Hero;
import Parent_Classes.Spell;
import Parent_Classes.Unit;

public class Resurrection extends Spell {
    public Resurrection(){
        super();
    }

    @Override
    public void castToUnit(Hero player, Unit unit) {
        unit.setFallen(false);

        int currentUnitAmount = unit.getUnitCount();
        int currentAllHealthForPrinting;
        if (unit.getUnitCount() > 0){
            currentAllHealthForPrinting = (unit.getHealth() * (unit.getUnitCount() - 1) + unit.getRemainingHealth());
        }
        else{
            currentAllHealthForPrinting = unit.getRemainingHealth();
        }

        int heal = player.getSpellPower() * 50;
        int maximumHealth = unit.getInitialUnitCount() * unit.getHealth();
        int currentAllHealth;
        if (unit.getUnitCount() > 0){
            currentAllHealth = (unit.getHealth() * (unit.getUnitCount() - 1) + unit.getRemainingHealth());
        }
        else{
            currentAllHealth = unit.getRemainingHealth();
        }
        currentAllHealth += heal;
        currentAllHealth = Math.min(maximumHealth, currentAllHealth);
        unit.setUnitCount((int)Math.ceil(currentAllHealth / (double)unit.getHealth()));
        unit.setRemainingHealth(currentAllHealth - unit.getHealth() * (unit.getUnitCount() - 1));

        //System.out.println(unit.getName() + " health: " + unit.getRemainingHealth());

        System.out.println((unit.getTeam() == 1? ConsoleFormatting.BLUE + " ": ConsoleFormatting.RED + " ") + getName() + ConsoleFormatting.RESET  + " healed " + Math.min(50 * player.getSpellPower(), unit.getHealth() * unit.getInitialUnitCount() - currentAllHealthForPrinting) + " health, " + (unit.getUnitCount() - currentUnitAmount) + " has resurrected!");
    }
}
