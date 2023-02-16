package Parent_Classes;

import java.util.Comparator;

public class UnitComparator implements Comparator<Unit> {
    @Override
    public int compare(Unit u1, Unit u2)
    {
        return Integer.compare(u2.getInitiative(), u1.getInitiative());
    }
}