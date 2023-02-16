package Parent_Classes;

import java.util.Comparator;

public class SpellComparator implements Comparator<Spell>{
    @Override
    public int compare(Spell u1, Spell u2)
    {
        return Integer.compare(u1.getMana(), u2.getMana());
    }
}
