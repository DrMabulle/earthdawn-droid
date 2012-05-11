package fr.android.earthdawn.managers;


public final class RankManager
{
    private RankManager() {}

    public static final int getRank(final int indice)
    {
        return indice <= 0 ? 0 : (int) (Math.ceil(indice / 3.0) + 1);
    }

    public static final String getDicesFromRank(final int rank)
    {
        switch (rank)
        {
            case 1:
                return "1D4 -2";
            case 2:
                return "1D4 -1";
            case 3:
                return "1D4";
            case 4:
                return "1D6";
            case 5:
                return "1D8";
            case 6:
                return "1D10";
            case 7:
                return "1D12";
            case 8:
                return "2D6";
            case 9:
                return "1D8 1D6";
            case 10:
                return "1D10 1D6";
            case 11:
                return "1D10 1D8";
            case 12:
                return "2D10";
            case 13:
                return "1D12 1D10";
            case 14:
                return "1D20 1D4";
            case 15:
                return "1D20 1D6";
            case 16:
                return "1D20 1D8";
            case 17:
                return "1D20 1D10";
            case 18:
                return "1D20 1D12";
            case 19:
                return "1D20 2D6";
            case 20:
                return "1D20 1D8 1D6";
            case 21:
                return "1D20 1D10 1D6";
            case 22:
                return "1D20 1D10 1D8";
            case 23:
                return "1D20 2D10";
            case 24:
                return "1D20 1D12 1D10";
            case 25:
                return "1D20 1D10 1D8 1D4";
            case 26:
                return "1D20 1D10 1D8 1D6";
            case 27:
                return "1D20 1D10 2D8";
            case 28:
                return "1D20 2D10 1D8";
            case 29:
                return "1D20 1D12 1D10 1D8";
            case 30:
                return "1D20 1D10 1D8 2D6";
            case 31:
                return "1D20 1D10 2D8 1D6";
            case 32:
                return "1D20 2D10 1D8 1D6";
            case 33:
                return "1D20 2D10 2D8";
            case 34:
                return "1D20 3D10 1D8";
            case 35:
                return "1D20 1D12 2D10 1D8";
            case 36:
                return "2D20 1D10 1D8 1D4";
            case 37:
                return "2D20 1D10 1D8 1D6";
            case 38:
                return "2D20 1D10 2D8";
            case 39:
                return "2D20 2D10 1D8";
            case 40:
                return "2D20 1D12 1D10 1D8";
            case 41:
                return "2D20 1D10 1D8 2D6";
            case 42:
                return "2D20 1D10 2D8 1D6";
            case 43:
                return "2D20 2D10 1D8 1D6";
            case 44:
                return "2D20 2D10 2D8";
            case 45:
                return "2D20 3D10 1D8";
            case 46:
                return "2D20 1D12 2D10 1D8";
            case 47:
                return "2D20 2D10 2D8 1D4";
            case 48:
                return "2D20 2D10 2D8 1D6";
            case 49:
                return "2D20 2D10 3D8";
            case 50:
                return "2D20 3D10 2D8";
            case 51:
                return "2D20 1D12 2D10 2D8";
            case 52:
                return "2D20 2D10 2D8 2D6";
            case 53:
                return "2D20 2D10 3D8 1D6";
            case 54:
                return "2D20 3D10 2D8 1D6";
            case 55:
                return "2D20 3D10 3D8";
            case 56:
                return "2D20 4D10 2D8";
            case 57:
                return "2D20 1D12 3D10 2D8";
            case 58:
                return "3D20 2D10 2D8 1D4";
            case 59:
                return "3D20 2D10 2D8 1D6";
            case 60:
                return "3D20 2D10 3D8";
            case 61:
                return "3D20 3D10 2D8";
            case 62:
                return "3D20 1D12 2D10 2D8";
            case 63:
                return "3D20 2D10 2D8 2D6";
            case 64:
                return "3D20 2D10 3D8 1D6";
            case 65:
                return "3D20 3D10 2D8 1D6";
            case 66:
                return "3D20 3D10 3D8";
            case 67:
                return "3D20 4D10 2D8";
            case 68:
                return "3D20 1D12 3D10 2D8";
            case 69:
                return "3D20 3D10 3D8 1D4";
            case 70:
                return "3D20 3D10 3D8 1D6";
            case 71:
                return "3D20 3D10 4D8";
            case 72:
                return "3D20 4D10 3D8";
            case 73:
                return "3D20 1D12 3D10 3D8";
            case 74:
                return "3D20 3D10 3D8 2D6";
            case 75:
                return "3D20 3D10 4D8 1D6";
            case 76:
                return "3D20 4D10 3D8 1D6";
            case 77:
                return "3D20 4D10 4D8";
            case 78:
                return "3D20 5D10 3D8";
            case 79:
                return "3D20 1D12 4D10 3D8";
            case 80:
                return "4D20 3D10 3D8 1D4";
            case 81:
                return "4D20 3D10 3D8 1D6";
            case 82:
                return "4D20 3D10 4D8";
            case 83:
                return "4D20 4D10 3D8";
            case 84:
                return "4D20 1D12 3D10 3D8";
            case 85:
                return "4D20 3D10 3D8 2D6";
            case 86:
                return "4D20 3D10 4D8 1D6";
            case 87:
                return "4D20 4D10 3D8 1D6";
            case 88:
                return "4D20 4D10 4D8";
            case 89:
                return "4D20 5D10 3D8";
            case 90:
                return "4D20 1D12 4D10 3D8";
            case 91:
                return "4D20 4D10 4D8 1D4";
            case 92:
                return "4D20 4D10 4D8 1D6";
            case 93:
                return "4D20 4D10 51D8";
            case 94:
                return "4D20 5D10 4D8";
            case 95:
                return "4D20 1D12 4D10 4D8";
            case 96:
                return "4D20 4D10 4D8 2D6";
            case 97:
                return "4D20 4D10 51D8 1D6";
            case 98:
                return "4D20 5D10 4D8 1D6";
            case 99:
                return "4D20 5D10 51D8";
            case 100:
                return "4D20 6D10 4D8";
            default:
                return "0";
        }
    }
}
