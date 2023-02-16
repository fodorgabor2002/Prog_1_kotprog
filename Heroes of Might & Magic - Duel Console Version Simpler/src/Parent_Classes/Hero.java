package Parent_Classes;

import java.util.ArrayList;

public class Hero {
    private int attack;
    private int defense;
    private int spellPower;
    private int knowledge;
    private int morale;
    private int luck;
    private int mana;
    private int team;

    private boolean attacked;
    private boolean castedASpell;
    private int gold;

    private ArrayList<Spell> spells = new ArrayList<>();
    private ArrayList<Unit> units = new ArrayList<>();

    public Hero(int gold, int team) {
        this.attack = 1;
        this.defense = 1;
        this.spellPower = 1;
        this.knowledge = 1;
        this.morale = 1;
        this.luck = 1;
        this.mana = 10;
        attacked = false;
        this.castedASpell = false;
        this.team = team;
        this.gold = gold;
    }

    public Hero(int attack, int defense, int spellPower, int knowledge, int morale, int luck, int mana, int team, boolean castedASpell, int gold) {
        this.attack = attack;
        this.defense = defense;
        this.spellPower = spellPower;
        this.knowledge = knowledge;
        this.morale = morale;
        this.luck = luck;
        this.mana = mana;
        this.team = team;
        this.castedASpell = castedASpell;
        this.gold = gold;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpellPower() {
        return spellPower;
    }

    public void setSpellPower(int spellPower) {
        this.spellPower = spellPower;
    }

    public int getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(int knowledge) {
        this.knowledge = knowledge;
    }

    public int getMorale() {
        return morale;
    }

    public void setMorale(int morale) {
        this.morale = morale;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public boolean isAttacked() {
        return attacked;
    }

    public void setAttacked(boolean attacked) {
        this.attacked = attacked;
    }

    public boolean isCastedASpell() {
        return castedASpell;
    }

    public void setCastedASpell(boolean hasCastASpell) {
        this.castedASpell = hasCastASpell;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public void setSpells(ArrayList<Spell> spells) {
        this.spells = spells;
    }

    public void addSpell(Spell spell) {
        this.spells.add(spell);
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public void setUnits(ArrayList<Unit> units) {
        this.units = units;
    }

    public void addUnit(Unit unit){
        //unit.setInitiative(unit.getInitiative() + this.morale);
        this.units.add(unit);
    }

    public void printSpellNames(){
        for (Spell spell:this.spells) {
            System.out.println(spell.getName());
        }
    }

    public void printUnitNamesAndQuantity(){
        for (Unit unit:this.units) {
            System.out.println(unit.getName() + ": " + unit.getInitialUnitCount());
        }
    }

    public void printUnitNamesAndQuantityAndTeam(){
        for (Unit unit:this.units) {
            System.out.println(unit.getName() + ": " + unit.getInitialUnitCount() + ", " + unit.getTeam());
        }
    }

    @Override
    public String toString() {
        return "Attack: " + this.attack +
                "\nDefense: " + this.defense +
                "\nSpell Power: " + this.spellPower +
                "\nKnowledge: " + this.knowledge +
                "\nMorale: " + this.morale +
                "\nLuck: " + this.luck +
                "\nGold: " + this.gold;
    }
}
