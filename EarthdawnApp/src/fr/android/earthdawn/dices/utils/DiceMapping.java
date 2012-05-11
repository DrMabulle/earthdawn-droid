/**
 *
 */
package fr.android.earthdawn.dices.utils;


/**
 * @author DrMabulle
 *
 */
public final class DiceMapping
{
    private DiceMapping() {}

	public static String getDicesToThrow(final int rank)
    {
        switch (rank)
        {
            case 1: return "1D4 - 2";
            case 2: return "1D4 - 1";
            case 3: return "1D4";
            case 4: return "1D6";
            case 5: return "1D8";
            case 6: return "1D10";
            case 7: return "1D12";
            case 8: return "2D6";
            case 9: return "1D8 1D6";
            case 10: return "1D10 1D6";
            case 11: return "1D10 1D8";
            case 12: return "2D10";
            case 13: return "1D12 1D10";
            case 14: return "1D20 1D4";
            case 15: return "1D20 1D6";
            case 16: return "1D20 1D8";
            case 17: return "1D20 1D10";
            case 18: return "1D20 1D12";
            case 19: return "1D20 2D6";
            case 20: return "1D20 1D8 1D6";
            case 21: return "1D20 1D10 1D6";
            case 22: return "1D20 1D10 1D8";
            case 23: return "1D20 2D10";
            case 24: return "1D20 1D12 1D10";
            case 25: return "1D20 1D10 1D8 1D4";
            case 26: return "1D20 1D10 1D8 1D6";
            case 27: return "1D20 1D10 2D8";
            case 28: return "1D20 2D10 1D8";
            case 29: return "1D20 1D12 1D10 1D8";
            case 30: return "1D20 1D10 2D6";
            case 31: return "1D20 1D10 2D8 1D6";
            case 32: return "1D20 2D10 1D8 1D6";
            case 33: return "1D20 2D10 2D8";
            case 34: return "1D20 3D10 2D8";
            case 35: return "1D20 1D12 2D10 1D8";
            case 36: return "2D20 1D10 1D8 1D4";
            case 37: return "2D20 1D10 1D8 1D6";
            case 38: return "2D20 1D10 2D8";
            case 39: return "2D20 2D10 1D8";
            case 40: return "2D20 1D12 1D10 1D8";
        }
        return "";
    }
}
