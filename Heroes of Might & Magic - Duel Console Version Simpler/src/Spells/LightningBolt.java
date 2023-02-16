package Spells;

import Parent_Classes.Hero;
import Parent_Classes.Spell;
import Parent_Classes.Unit;

public class LightningBolt extends Spell {
    public LightningBolt() {
        super();
    }

    @Override
    public void castToUnit(Hero player, Unit unit) {
        unit.takeDamage(player.getSpellPower() * 30);
    }
}
