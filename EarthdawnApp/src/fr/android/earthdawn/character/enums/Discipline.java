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
    private final int[] ranks;

    /**
     * @param discipline
     * @param circle
     */
    public Discipline(final Disciplines discipline, final int circle)
    {
        super();
        this.discipline = discipline;
        this.circle = circle;
        this.ranks = new int[discipline.getTalents().size()];
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

    public int getTalentRank(final Talent talent)
    {
        return ranks[discipline.getTalents().indexOf(talent)];
    }

    public void setTalentRank(final Talent talent, final int rank)
    {
        ranks[discipline.getTalents().indexOf(talent)] = rank;
    }
    public void incrementTalentRank(final Talent talent)
    {
        ranks[discipline.getTalents().indexOf(talent)] += 1;
    }

    public Talent findTalent(final Talents talent)
    {
        for (final Talent tmp : discipline.getTalents())
        {
            if (tmp.isSameTalentAs(talent))
            {
                return tmp;
            }
        }
        return null;
    }

}
