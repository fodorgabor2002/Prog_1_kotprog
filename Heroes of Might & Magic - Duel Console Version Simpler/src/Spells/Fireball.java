package Spells;

import Parent_Classes.Hero;
import Parent_Classes.Spell;
import Parent_Classes.Unit;

import java.awt.*;

public class Fireball extends Spell {
    public Fireball(){
        super();
    }

    @Override
    public void castToField(Unit[][] battlefield, Hero player, Point centre) {
        /*for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(getName() + " zone: " + i + " " + (char)(j + 'A'));
            }
            System.out.println();
        }*/

        for (int i = Math.max(0, centre.x - 1); i <= Math.min(centre.x + 1, 9); i++) {
            for (int j = Math.max(0, centre.y - 1); j <= Math.min(centre.y + 1, 11); j++) {
                if (battlefield[j][i] != null){
                    battlefield[j][i].takeDamage(player.getSpellPower() * 20);

                    //System.out.println(getName() + " zone: " + (char)(j + 'A') + " " + i);
                }

                //System.out.println(getName() + " zone: " + (char)(j + 'A') + " " + i);
            }
        }
    }
}
