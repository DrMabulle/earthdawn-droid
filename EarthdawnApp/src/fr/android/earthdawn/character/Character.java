/**
 * 
 */
package fr.android.earthdawn.character;

import fr.android.earthdawn.character.enums.Attributs;

/**
 * @author DrMabulle
 *
 */
public class Character
{

    private final String name;
    private final String sex;
    private final int age;
    private final int height;
    private final int weight;

    private final Races race;

    private final Attribut[] attributs = new Attribut[6];

    public Character(final String name, final String sex, final int age, final int height, final int weight, final Races race,
            final int dexInd, final int dexEvol, final int strInd, final int strEvol,
            final int endInd, final int endEvol, final int perInd, final int perEvol,
            final int volInd, final int volEvol, final int chaInd, final int chaEvol)
    {
        super();
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.race = race;

        // TODO Gérer les bonus raciaux
        // Dextérité
        attributs[Attributs.dex.getId()] = new Attribut(dexInd + race.getBonusDex(), dexEvol);
        // Force
        attributs[Attributs.str.getId()] = new Attribut(strInd + race.getBonusStr(), strEvol);
        // Endurance
        attributs[Attributs.end.getId()] = new Attribut(endInd + race.getBonusEnd(), endEvol);
        // Perception
        attributs[Attributs.per.getId()] = new Attribut(perInd + race.getBonusPer(), perEvol);
        // Velonté
        attributs[Attributs.vol.getId()] = new Attribut(volInd + race.getBonusVol(), volEvol);
        // Charisme
        attributs[Attributs.cha.getId()] = new Attribut(chaInd + race.getBonusCha(), chaEvol);
    }


    public int getPhysicalDefense()
    {
        return race.getBonusPhyDef() + computeIndiceDefense(attributs[Attributs.dex.getId()]);
    }

    public int getDeathCeil()
    {
        return computeDeathCeil(attributs[Attributs.end.getId()].getResultingIndice());
    }

    protected int computeDeathCeil(final int indice)
    {
        return (int) (indice + 18 + Math.floor(indice / 3));
    }

    protected int computeUncounciousnessCeil(final int indice)
    {
        return (int) (indice + 9 + Math.floor(indice / 3) + Math.floor((indice - 1) / 10));
    }

    protected int computeWoundCeil(final int indice)
    {
        return (int) (Math.ceil(indice  / 2) + 3 - Math.floor(indice / 22) - Math.floor(indice / 27));
    }


    protected int computeIndiceDefense(final Attribut attribut)
    {
        attribut.getResultingIndice();
        return 0;
    }


}
