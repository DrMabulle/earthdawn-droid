/**
 *
 */
package fr.android.earthdawn.character.enums;

import java.io.Serializable;
import java.util.ArrayList;
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
     * @param aDiscipline
     * @param aCircle
     */
    public Discipline(final Disciplines aDiscipline, final int aCircle)
    {
        super();
        this.discipline = aDiscipline;
        this.circle = aCircle;
        this.ranks = new int[aDiscipline.getTalents().size()];
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

    public List<Talent> getTalentsUpTo(final int aCircle)
    {
        final Iterator<Talent> iter = discipline.getTalents().iterator();
        int index = 0;
        while(iter.hasNext() && iter.next().getCircle() <= aCircle)
        {
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
        if (discipline.getTalents().indexOf(talent) < 0)
        {
            return 0;
        }
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

    public List<Mod> getPerks()
    {
        final List<Mod> result = new ArrayList<Mod>(4);
        final Iterator<Perks> iter = discipline.getBonuses().iterator();
        Perks tmp;
        while(iter.hasNext() && (tmp = iter.next()).getRank() <= circle)
        {
            result.add(tmp.getMod());
        }
        return result;
    }
}
