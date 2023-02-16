package Units;

import ConsoleFormatters.ConsoleFormatting;
import Parent_Classes.Unit;

public class Footman extends Unit {
    private boolean waitedLastTurn;
    public Footman(int team){
        super(team);
        waitedLastTurn = false;
    }

    public boolean isWaitedLastTurn() {
        return waitedLastTurn;
    }

    public void setWaitedLastTurn(boolean waitedLastTurn) {
        this.waitedLastTurn = waitedLastTurn;
    }

    @Override
    public void takeDamage(int damage) {
        if (!this.isFallen()) {
            //System.out.println(getName() + " is now taking dmg:");

            int currentUnitAmount = getUnitCount();
            int currentAllHealth;
            if (getUnitCount() > 0){
                currentAllHealth = (getHealth() * (getUnitCount() - 1) + getRemainingHealth());
            }
            else{
                currentAllHealth = getRemainingHealth();
            }

            int allHealt;
            if (getUnitCount() > 0){
                allHealt = (getHealth() * (getUnitCount() - 1) + getRemainingHealth());
            }
            else{
                allHealt = getRemainingHealth();
            }
            //System.out.println("all health before the dmg take: " + allHealt);
            allHealt -= damage * (isWaitedLastTurn()? 0.7f:1f);
            //System.out.println("all health after the dmg take: " + allHealt);
            allHealt = Math.max(allHealt, 0);
            //System.out.println("all health after correction: " + allHealt);
            //System.out.println("Unit count before dmg: " + unitCount);
            setUnitCount((int)Math.ceil((double)allHealt / getHealth()));
            //System.out.println("Unit count after dmg: " + unitCount);
            //System.out.println("Remaining health before dmg:" + remainingHealth);
            setRemainingHealth(allHealt - (getHealth() * (getUnitCount() - 1)));
            //System.out.println("Remaining health after dmg:" + remainingHealth);

            System.out.println((getTeam() == 1? ConsoleFormatting.BLUE + " ":ConsoleFormatting.RED + " ") + getName() + ConsoleFormatting.RESET  + " took " + (currentAllHealth - allHealt) + " damage, " + (currentUnitAmount - getUnitCount()) + " has died");

            if (getRemainingHealth() * getUnitCount() == 0) {
                setFallen(true);
                setUnitCount(0);
                setRemainingHealth(0);
                //allUnits.remove(unit);
                System.out.println((getTeam() == 1? ConsoleFormatting.BLUE + " ":ConsoleFormatting.RED + " ") + getName() + ConsoleFormatting.RESET  + " has fallen!");
            }

            setWaitedLastTurn(false);
        }
    }
}
