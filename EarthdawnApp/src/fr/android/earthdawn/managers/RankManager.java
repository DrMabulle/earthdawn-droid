package fr.android.earthdawn.managers;


/**
 * @author DrMabulle
 *
 */
public final class RankManager
{
    private RankManager() {}

    /**
     * Calculates rank associated to a given level (indice)
     * @param indice a level to transcribe to rank
     * @return the rank associated to the given level (indice)
     */
    public static final int getRank(final int indice)
    {
        return indice <= 0 ? 0 : (int) (Math.ceil(indice / 3.0) + 1);
    }
    /**
     * Returns the dices informations associated to a given rank and optional bonuses
     * @param rank a rank to transcribe to dices
     * @param bonus a optional modificator to dices
     * @return the dices informations associated to the given rank and optional bonuses
     */
    public static final String getDicesFromRank(final int rank, final int bonus)
    {
        final StringBuilder builder = new StringBuilder(30);
        builder.append(getDicesFromRank(rank));
        if (bonus > 0)
        {
            builder.append(" + ");
            builder.append(bonus);
        }
        else if (bonus < 0)
        {
            builder.append(' ');
            builder.append(bonus);
        }
        return builder.toString();
    }

    /**
     * Returns the dices informations associated to a given rank
     * @param rank a rank to transcribe to dices
     * @return the dices informations associated to the given rank
     */
    public static final String getDicesFromRank(final int rank)
    {
        if (rank < 1 || rank > 100)
        {
            return "0D";
        }
        return RANKS[(rank-1) / 10][(rank-1) % 10];
    }

    private static final String[] ROW1 = {"1D4 -2",
        "1D4 -1",
        "1D4",
        "1D6",
        "1D8",
        "1D10",
        "1D12",
        "2D6",
        "1D8 + 1D6",
        "1D10 + 1D6"};
    private static final String[] ROW2 = {"1D10 + 1D8",
        "2D10",
        "1D12 + 1D10",
        "1D20 + 1D4",
        "1D20 + 1D6",
        "1D20 + 1D8",
        "1D20 + 1D10",
        "1D20 + 1D12",
        "1D20 + 2D6",
        "1D20 + 1D8 + 1D6"};
    private static final String[] ROW3 = {"1D20 + 1D10 + 1D6",
        "1D20 + 1D10 + 1D8",
        "1D20 + 2D10",
        "1D20 + 1D12 + 1D10",
        "1D20 + 1D10 + 1D8 + 1D4",
        "1D20 + 1D10 + 1D8 + 1D6",
        "1D20 + 1D10 + 2D8",
        "1D20 + 2D10 + 1D8",
        "1D20 + 1D12 + 1D10 + 1D8",
        "1D20 + 1D10 + 1D8 + 2D6"};
    private static final String[] ROW4 = {"1D20 + 1D10 + 2D8 + 1D6",
        "1D20 + 2D10 + 1D8 + 1D6",
        "1D20 + 2D10 + 2D8",
        "1D20 + 3D10 + 1D8",
        "1D20 + 1D12 + 2D10 + 1D8",
        "2D20 + 1D10 + 1D8 + 1D4",
        "2D20 + 1D10 + 1D8 + 1D6",
        "2D20 + 1D10 + 2D8",
        "2D20 + 2D10 + 1D8",
        "2D20 + 1D12 + 1D10 + 1D8"};
    private static final String[] ROW5 = {"2D20 + 1D10 + 1D8 + 2D6",
        "2D20 + 1D10 + 2D8 + 1D6",
        "2D20 + 2D10 + 1D8 + 1D6",
        "2D20 + 2D10 + 2D8",
        "2D20 + 3D10 + 1D8",
        "2D20 + 1D12 + 2D10 + 1D8",
        "2D20 + 2D10 + 2D8 + 1D4",
        "2D20 + 2D10 + 2D8 + 1D6",
        "2D20 + 2D10 + 3D8",
        "2D20 + 3D10 + 2D8"};
    private static final String[] ROW6 = {"2D20 + 1D12 + 2D10 + 2D8",
        "2D20 + 2D10 + 2D8 + 2D6",
        "2D20 + 2D10 + 3D8 + 1D6",
        "2D20 + 3D10 + 2D8 + 1D6",
        "2D20 + 3D10 + 3D8",
        "2D20 + 4D10 + 2D8",
        "2D20 + 1D12 + 3D10 + 2D8",
        "3D20 + 2D10 + 2D8 + 1D4",
        "3D20 + 2D10 + 2D8 + 1D6",
        "3D20 + 2D10 + 3D8"};
    private static final String[] ROW7 = {"3D20 + 3D10 + 2D8",
        "3D20 + 1D12 2D10 + 2D8",
        "3D20 + 2D10 + 2D8 + 2D6",
        "3D20 + 2D10 + 3D8 + 1D6",
        "3D20 + 3D10 + 2D8 + 1D6",
        "3D20 + 3D10 + 3D8",
        "3D20 + 4D10 + 2D8",
        "3D20 + 1D12 + 3D10 + 2D8",
        "3D20 + 3D10 + 3D8 + 1D4",
        "3D20 + 3D10 + 3D8 + 1D6"};
    private static final String[] ROW8 = {"3D20 + 3D10 + 4D8",
        "3D20 + 4D10 + 3D8",
        "3D20 + 1D12 + 3D10 + 3D8",
        "3D20 + 3D10 + 3D8 + 2D6",
        "3D20 + 3D10 + 4D8 + 1D6",
        "3D20 + 4D10 + 3D8 + 1D6",
        "3D20 + 4D10 + 4D8",
        "3D20 + 5D10 + 3D8",
        "3D20 + 1D12 + 4D10 + 3D8",
        "4D20 + 3D10 + 3D8 + 1D4"};
    private static final String[] ROW9 = {"4D20 + 3D10 + 3D8 + 1D6",
        "4D20 + 3D10 + 4D8",
        "4D20 + 4D10 + 3D8",
        "4D20 + 1D12 + 3D10 + 3D8",
        "4D20 + 3D10 + 3D8 + 2D6",
        "4D20 + 3D10 + 4D8 + 1D6",
        "4D20 + 4D10 + 3D8 + 1D6",
        "4D20 + 4D10 + 4D8",
        "4D20 + 5D10 + 3D8",
        "4D20 + 1D12 + 4D10 + 3D8"};
    private static final String[] ROW10 = {"4D20 + 4D10 + 4D8 + 1D4",
        "4D20 + 4D10 + 4D8 + 1D6",
        "4D20 + 4D10 + 5D8",
        "4D20 + 5D10 + 4D8",
        "4D20 + 1D12 + 4D10 + 4D8",
        "4D20 + 4D10 + 4D8 + 2D6",
        "4D20 + 4D10 + 5D8 + 1D6",
        "4D20 + 5D10 + 4D8 + 1D6",
        "4D20 + 5D10 + 5D8",
        "4D20 + 6D10 + 4D8"};
    private static final String[][] RANKS = {ROW1, ROW2, ROW3, ROW4, ROW5, ROW6, ROW7, ROW8, ROW9, ROW10};
}
