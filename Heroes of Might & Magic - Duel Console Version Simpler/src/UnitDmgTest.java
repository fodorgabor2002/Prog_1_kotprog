import Parent_Classes.Hero;
import Parent_Classes.Unit;
import Spells.LightningBolt;
import Spells.Resurrection;
import Units.Footman;
import Units.Seraph;

public class UnitDmgTest {
    public static void main(String[] args) {
        /*Unit footman = new Footman(3);
        footman.setInitialUnitCount(100);
        //System.out.println(footman);
        System.out.println(footman.getRemainingHealth());
        System.out.println(footman.getUnitCount());
        System.out.println();

        //System.out.println("Miután sebződött");
        footman.takeDamage(26 * 99 - 3);
        System.out.println(footman.getRemainingHealth());
        System.out.println(footman.getUnitCount());
        System.out.println();

        System.out.println("Alap létszám: " + footman.getInitialUnitCount());

        LightningBolt lightningBolt = new LightningBolt();

        Hero h = new Hero(0, 3);
        Unit[][] units = new Unit[12][10];
        Resurrection resurrection = new Resurrection();

        resurrection.castToUnit(h, footman);
        System.out.println(footman.getRemainingHealth());
        System.out.println(footman.getUnitCount());
        System.out.println();

        lightningBolt.castToUnit(h, footman);
        System.out.println(footman.getRemainingHealth());
        System.out.println(footman.getUnitCount());
        System.out.println();*/

        Unit seraph = new Seraph(3);
        seraph.setInitialUnitCount(1);
        //System.out.println(footman);
        System.out.println(seraph.getRemainingHealth());
        System.out.println(seraph.getUnitCount());
        System.out.println();

        //System.out.println("Miután sebződött");
        seraph.takeDamage(30);
        System.out.println(seraph.getRemainingHealth());
        System.out.println(seraph.getUnitCount());
        System.out.println();

        System.out.println("Alap létszám: " + seraph.getInitialUnitCount());

        LightningBolt lightningBolt = new LightningBolt();

        Hero h = new Hero(0, 3);
        Unit[][] units = new Unit[12][10];
        Resurrection resurrection = new Resurrection();

        resurrection.castToUnit(h, seraph);
        System.out.println(seraph.getRemainingHealth());
        System.out.println(seraph.getUnitCount());
        System.out.println();

        lightningBolt.castToUnit(h, seraph);
        System.out.println(seraph.getRemainingHealth());
        System.out.println(seraph.getUnitCount());
        System.out.println();
    }
}
