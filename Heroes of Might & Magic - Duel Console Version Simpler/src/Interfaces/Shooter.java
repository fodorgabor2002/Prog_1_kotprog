package Interfaces;

import Parent_Classes.Hero;
import Parent_Classes.Unit;

public interface Shooter {
    public abstract void attackRanged(Unit[][] battlefield, Hero allyHero, Hero enemyHero, Unit enemy);
}
