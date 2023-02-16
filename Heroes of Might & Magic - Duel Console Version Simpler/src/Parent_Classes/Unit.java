package Parent_Classes;

import ConsoleFormatters.ConsoleFormatting;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Unit {
    //Minden egysékre vonatkozó adatok
    private String name;
    private int cost;
    private int[] damageThresholds = new int[2];
    private int health;
    private int remainingHealth;
    private float speed;
    private int initiative;
    private String[] specialAbilities;
    private int tier;
    private int team;
    private int unitCount = 0;
    private boolean fallen = false;
    private Point position;
    private int initialUnitCount;
    private boolean retailed = false;


    //Speckó egységek adatai
    //protected String[][] additionalData;


    //Fájlbeolvasós konstruktor
    public Unit(int team)
    {
        String[][] s = readTheData();

        //Mindegyik egységre vonatkozó adatok
        for (String[] strings : s) {
            switch (strings[0]) {
                case "name" -> this.name = strings[1];
                case "cost" -> this.cost = Integer.parseInt(strings[1]);
                case "damage_Thresholds" -> {
                    String[] dmgThresholdHelp = strings[1].split("-");
                    this.damageThresholds[0] = Integer.parseInt(dmgThresholdHelp[0]);
                    this.damageThresholds[1] = Integer.parseInt(dmgThresholdHelp[1]);
                }
                case "health" -> this.health = Integer.parseInt(strings[1]);
                case "speed" -> this.speed = Float.parseFloat(strings[1]);
                case "initiative" -> this.initiative = Integer.parseInt(strings[1]);
                case "special_Ability" -> this.specialAbilities = strings[1].split(", ");
                case "tier" -> this.tier = Integer.parseInt(strings[1]);
            }
        }
        this.remainingHealth = this.health;
        this.team = team;

        //Csak specifikus egységekre vonatkozó adatok
        /*additionalData = new String[s.length - 8][];
        System.arraycopy(s, 8, additionalData, 0, additionalData.length);*/
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int[] getDamageThresholds() {
        return damageThresholds;
    }

    public void setDamageThresholds(int[] damageThresholds) {
        this.damageThresholds = damageThresholds;
    }

    public int getHealth() {
        return health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public String[] getSpecialAbilities() {
        return specialAbilities;
    }

    public void setSpecialAbilities(String[] specialAbilities) {
        this.specialAbilities = specialAbilities;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public int getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(int unitCount) {
        this.unitCount = unitCount;
    }

    public boolean isFallen() {
        return fallen;
    }

    public void setFallen(boolean fallen) {
        this.fallen = fallen;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public int getRemainingHealth() {
        return remainingHealth;
    }

    public void setRemainingHealth(int remainingHealth) {
        this.remainingHealth = remainingHealth;
    }

    public int getInitialUnitCount() {
        return initialUnitCount;
    }

    public boolean isRetailed() {
        return retailed;
    }

    public void setRetailed(boolean retailed) {
        this.retailed = retailed;
    }

    private String[][] readTheData() {
        File whereToSearch = new File("src/Data_Folder/Unit_Data_Folders");
        File dataFile = findFile(whereToSearch, this.getClass().getSimpleName());

        int i = 0;
        try (Scanner scanner = new Scanner(dataFile)) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String[][] s = new String[i][2];
        i = 0;
        try (Scanner scanner = new Scanner(dataFile)) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(": ", 2);

                s[i][0] = data[0];
                s[i][1] = data[1];
                //System.out.println(s[i][0] + " " + s[i][1]);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return s;
    }


    public void setInitialUnitCount(int initialUnitCount) {
        this.initialUnitCount = initialUnitCount;
        this.unitCount = initialUnitCount;
    }


    public void takeDamage(int damage){
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
            allHealt -= damage;
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
        }
    }


    public void move(Unit[][] battlefield, Point from, Point to) {
        battlefield[to.x][to.y] = battlefield[from.x][from.y];
        battlefield[from.x][from.y] = null;
        //System.out.println(battlefield[from.y][from.x]);
        setPosition(to);
        //System.out.println("From: " + from);
        //System.out.println(battlefield[to.x][to.y]);
        //System.out.println(to);
    }


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
        enemy.takeDamage((int)((basicDamage * critModifier) * (1 + 0.1f * (allyHero.getAttack() - enemyHero.getDefense()))));

        if (!enemy.isRetailed()) {
            enemy.retaliate(battlefield, enemyHero, allyHero, this);
        }
    }


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
            enemy.takeDamage((int)((this.getUnitCount() * basicDamage) * (1 + 0.1f * (allyHero.getAttack() - enemyHero.getDefense())) * 0.5f));
            this.setRetailed(true);
        }
    }


    //Rekurzívan megkeressük a megfelelő txt fájlt - mappákba mászunk bele, ezért kell így
    private static File findFile(File dir, String name) {
        File result = null;
        File[] dirlist  = dir.listFiles();

        for (File file : dirlist) {
            if (file.isDirectory()) {
                result = findFile(file, name);
                if (result != null) break; // Rekurzív keresés sikeres, kiugrunk a ciklusból
            } else if (file.getName().matches(name)) {
                return file; // Visszaadjuk a fájlt
            }
        }
        return result; // Ha semmit nem találtunk, akkor nullt ad vissza - nem kellene h megtörténjen
    }


    @Override
    public String toString() {
        StringBuilder classString = new StringBuilder("Name: " + this.name + "\n" +
                "Cost: " + this.cost + "\n" +
                "Damage: " + this.damageThresholds[0] + " - " + damageThresholds[1] + "\n" +
                "Health: " + this.health + "\n" +
                "Speed: " + (int)this.speed + "\n" +
                "Initiative: " + this.initiative + "\n" +
                "Special Abilities: ");
        for (int i = 0; i < this.specialAbilities.length - 1; i++) {
            classString.append(this.specialAbilities[i]).append(", ");
        }
        classString.append(this.specialAbilities[this.specialAbilities.length - 1]);
        classString.append("\n").append("Tier: ").append(this.tier);
        return classString.toString();
    }


    public void possibleMoves(Unit[][] battlefield, ArrayList<Point> possibleMovesList, ArrayList<Point> possibleAttackFieldsList, Point currentPosition, float speed){
        for (int i = Math.max(0, currentPosition.x - 1); i <= Math.min(currentPosition.x + 1, 11); i++) {
            for (int j = Math.max(0, currentPosition.y - 1); j <= Math.min(currentPosition.y + 1, 9); j++) {
                if (battlefield[i][j] != null && battlefield[i][j].getTeam() != this.getTeam() && !battlefield[i][j].isFallen()){
                    /*System.out.println(this.getName() + " and team: " + this.getTeam());
                    System.out.println(currentPosition);
                    Scanner scanner = new Scanner(System.in);
                    scanner.nextLine();*/

                    possibleAttackFieldsList.add(currentPosition);
                }

                //System.out.println(getName() + " zone: " + (char)(j + 'A') + " " + i);
            }
        }
        possibleMovesList.add(currentPosition);
        if (speed >= 1.42f) {
            //Jobbra Fel
            if (currentPosition.x + 1 <= 11 && currentPosition.y - 1 >= 0){
                if (battlefield[currentPosition.x + 1][currentPosition.y - 1] == null || battlefield[currentPosition.x + 1][currentPosition.y - 1].isFallen()){
                    possibleMoves(battlefield, possibleMovesList, possibleAttackFieldsList, new Point(currentPosition.x + 1, currentPosition.y - 1), speed - 1.42f);
                }
            }
            //Balra Fel
            if (currentPosition.x - 1 >= 0 && currentPosition.y - 1 >= 0){
                if (battlefield[currentPosition.x - 1][currentPosition.y - 1] == null || battlefield[currentPosition.x - 1][currentPosition.y - 1].isFallen()){
                    possibleMoves(battlefield, possibleMovesList, possibleAttackFieldsList, new Point(currentPosition.x - 1, currentPosition.y - 1), speed - 1.42f);
                }
            }
            //Jobbra Le
            if (currentPosition.x + 1 <= 11 && currentPosition.y + 1 <= 9){
                if (battlefield[currentPosition.x + 1][currentPosition.y + 1] == null || battlefield[currentPosition.x + 1][currentPosition.y + 1].isFallen()){
                    possibleMoves(battlefield, possibleMovesList, possibleAttackFieldsList, new Point(currentPosition.x + 1, currentPosition.y + 1), speed - 1.42f);
                }
            }
            //Balra Le
            if (currentPosition.x - 1 >= 0 && currentPosition.y + 1 <= 9){
                if (battlefield[currentPosition.x - 1][currentPosition.y + 1] == null || battlefield[currentPosition.x - 1][currentPosition.y + 1].isFallen()){
                    possibleMoves(battlefield, possibleMovesList, possibleAttackFieldsList, new Point(currentPosition.x - 1, currentPosition.y + 1), speed - 1.42f);
                }
            }
        }
        if (speed >= 1f){
            //Fel
            if (currentPosition.y - 1 >= 0){
                if (battlefield[currentPosition.x][currentPosition.y - 1] == null || battlefield[currentPosition.x][currentPosition.y - 1].isFallen()){
                    possibleMoves(battlefield, possibleMovesList, possibleAttackFieldsList, new Point(currentPosition.x, currentPosition.y - 1), speed - 1f);
                }
            }
            //Jobbra
            if (currentPosition.x + 1 <= 11){
                if (battlefield[currentPosition.x + 1][currentPosition.y] == null || battlefield[currentPosition.x + 1][currentPosition.y].isFallen()){
                    possibleMoves(battlefield, possibleMovesList, possibleAttackFieldsList, new Point(currentPosition.x + 1, currentPosition.y), speed - 1f);
                }
            }
            //Balra
            if (currentPosition.x - 1 >= 0){
                if (battlefield[currentPosition.x - 1][currentPosition.y] == null || battlefield[currentPosition.x - 1][currentPosition.y].isFallen()){
                    possibleMoves(battlefield, possibleMovesList, possibleAttackFieldsList, new Point(currentPosition.x - 1, currentPosition.y), speed - 1f);
                }
            }
            //Le
            if (currentPosition.y + 1 <= 9){
                if (battlefield[currentPosition.x][currentPosition.y + 1] == null || battlefield[currentPosition.x][currentPosition.y + 1].isFallen()){
                    possibleMoves(battlefield, possibleMovesList, possibleAttackFieldsList, new Point(currentPosition.x, currentPosition.y + 1), speed - 1f);
                }
            }
        }
    }
}
