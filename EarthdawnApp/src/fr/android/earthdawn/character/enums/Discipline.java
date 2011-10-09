/**
 *
 */
package fr.android.earthdawn.character.enums;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;


/**
 * @author DrMabulle
 *
 */
public class Discipline implements Serializable
{
    private static final long serialVersionUID = -2384352988631922220L;

    private final Disciplines discipline;
    private int circle;

    /**
     * @param discipline
     * @param circle
     */
    public Discipline(final Disciplines discipline, final int circle)
    {
        super();
        this.discipline = discipline;
        this.circle = circle;
    }

    public int getCircle()
    {
        return circle;
    }

    public void incrementCircle()
    {
        circle++;
    }

    public String getName()
    {
        return discipline.getLabel();
    }

    public List<Talent> getTalentsUpTo(final int circle)
    {
        final Iterator<Talent> iter = discipline.getTalents().iterator();
        int index = 0;
        while(iter.hasNext() && iter.next().getCircle() <= circle) {
            index++;
        }
        return discipline.getTalents().subList(0, index);
    }
    public List<Talent> getKnownTalents()
    {
        return getTalentsUpTo(circle);
    }
}
