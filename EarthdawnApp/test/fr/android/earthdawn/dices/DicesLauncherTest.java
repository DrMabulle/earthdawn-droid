package fr.android.earthdawn.dices;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import fr.android.earthdawn.dices.impl.Dice;
import fr.android.earthdawn.dices.impl.FixedValueDice;

public class DicesLauncherTest
{
    @Test
    public void testTestInputDicesInfos()
    {
        Assert.assertTrue(DicesLauncher.testInputDicesInfos("1D20"));
        Assert.assertTrue(DicesLauncher.testInputDicesInfos("1d20"));
        Assert.assertTrue(DicesLauncher.testInputDicesInfos("1D20 2D10 -2"));

        Assert.assertFalse(DicesLauncher.testInputDicesInfos("-1D20"));
        Assert.assertFalse(DicesLauncher.testInputDicesInfos("1D20 +3"));
        Assert.assertFalse(DicesLauncher.testInputDicesInfos("1D20 + 2D10"));
    }

    @Test
    public void testRollDicesRank()
    {
        int tmp;
        for (int i = 0; i < 100; i++)
        {
            tmp = DicesLauncher.rollDices(7, false, false);
            Assert.assertTrue(tmp > 0 && tmp < 13);
        }
    }

    @Test
    public void testRollDicesRank2()
    {
        DicesLauncher.logs.setLength(0);
        final int result = DicesLauncher.rollDices(100, true, true);
        System.out.println("#### Test RollDices(Rank) ####");
        System.out.println(DicesLauncher.getRollLogs());
        System.out.println(result);
    }

    @Test
    public void testRollDicesInfos()
    {
        int tmp;
        for (int i = 0; i < 100; i++)
        {
            tmp = DicesLauncher.rollDices("1D12", false, false);
            Assert.assertTrue(tmp > 0 && tmp < 13);
        }
    }

    @Test
    public void testRollDicesInfos2()
    {
        DicesLauncher.logs.setLength(0);
        final int result = DicesLauncher.rollDices("8D3", true, true);
        System.out.println("#### Test RollDices(DicesInfos) ####");
        System.out.println(DicesLauncher.getRollLogs());
        System.out.println(result);
    }

    @Test
    public void testParseDicesInfos()
    {
        // Test 1
        List<Rollable> dices = DicesLauncher.parseDicesInfos("1D20 + 2D10 + 6D6 -2");
        Assert.assertTrue(dices != null && dices.size() == 10);
        Assert.assertEquals("D20", dices.get(0).toString());
        Assert.assertEquals("D10", dices.get(1).toString());
        Assert.assertEquals("D6", dices.get(8).toString());
        Assert.assertTrue(dices.get(9).compareTo(new FixedValueDice(-2)) == 0);

        // Test 2
        dices = DicesLauncher.parseDicesInfos("1D20 + 5 + 1D6 -2 + 1D4");
        Assert.assertTrue(dices != null && dices.size() == 5);
        Assert.assertEquals("D20", dices.get(0).toString());
        Assert.assertTrue(dices.get(1).compareTo(new FixedValueDice(5)) == 0);
        Assert.assertEquals("D6", dices.get(2).toString());
        Assert.assertTrue(dices.get(3).compareTo(new FixedValueDice(-2)) == 0);
        Assert.assertEquals("D4", dices.get(4).toString());
    }

    @Test
    public void testRollDicesDices()
    {
        final List<Rollable> dices = DicesLauncher.parseDicesInfos("1D20");
        int tmp;
        for (int i = 0; i < 100; i++)
        {
            tmp = DicesLauncher.rollDices(dices, false, false);
            Assert.assertTrue(tmp > 0 && tmp < 21);
        }
    }

    @Test
    public void testSimpleRoll()
    {
        final List<Rollable> dices = DicesLauncher.parseDicesInfos("5D20");
        int tmp;
        for (int i = 0; i < 100; i++)
        {
            tmp = DicesLauncher.simpleRoll(dices);
            Assert.assertTrue(tmp > 0 && tmp < 101);
        }
    }

    @Test
    public void testManageRerolls()
    {
        final List<Rollable> dices = DicesLauncher.parseDicesInfos("5D20");
        int tmp;
        for (int i = 0; i < 100; i++)
        {
            tmp = DicesLauncher.manageRerolls(dices, false, false);
            Assert.assertTrue(tmp == 0);
        }
    }

    @Test
    public void testRemoveCancelledDices1()
    {
        final List<Rollable> dicesMax = new ArrayList<Rollable>();
        final List<Rollable> dicesMin = new ArrayList<Rollable>();

        dicesMax.add(initDiceToValue(20, 20));
        dicesMax.add(initDiceToValue(10, 10));
        dicesMax.add(initDiceToValue(6, 6));

        dicesMin.add(initDiceToValue(20, 1));
        dicesMin.add(initDiceToValue(6, 1));

        // Test
        DicesLauncher.removeCancelledDices(dicesMax, dicesMin);

        // assert
        Assert.assertTrue(dicesMax.size() == 1);
        Assert.assertTrue(dicesMin.size() == 0);
        Assert.assertEquals(new Dice(6), dicesMax.get(0));
    }

    @Test
    public void testRemoveCancelledDices2()
    {
        final List<Rollable> dicesMax = new ArrayList<Rollable>();
        final List<Rollable> dicesMin = new ArrayList<Rollable>();

        dicesMax.add(initDiceToValue(20, 20));
        dicesMax.add(initDiceToValue(10, 10));
        dicesMax.add(initDiceToValue(6, 6));

        dicesMin.add(initDiceToValue(20, 1));
        dicesMin.add(initDiceToValue(12, 1));
        dicesMin.add(initDiceToValue(10, 1));
        dicesMin.add(initDiceToValue(6, 1));

        // Test
        DicesLauncher.removeCancelledDices(dicesMax, dicesMin);

        // assert
        Assert.assertTrue(dicesMax.size() == 0);
        Assert.assertTrue(dicesMin.size() == 1);
        Assert.assertEquals(new Dice(6), dicesMin.get(0));
    }

    private static Rollable initDiceToValue(final int maxValue, final int desiredValue)
    {
        final Rollable dice = new Dice(maxValue);
        final int i = 0;
        dice.roll();
        while (dice.getPreviousResult() != desiredValue && i < 1000) // security
        {
            dice.roll();
        }
        return dice;
    }

    @Test
    public void testRerollMaxs()
    {
        DicesLauncher.logs.setLength(0);
        final List<Rollable> dicesMax = new ArrayList<Rollable>();

        dicesMax.add(initDiceToValue(20, 20));
        dicesMax.add(initDiceToValue(12, 12));
        dicesMax.add(initDiceToValue(10, 10));
        dicesMax.add(initDiceToValue(8, 8));
        dicesMax.add(initDiceToValue(6, 6));
        dicesMax.add(initDiceToValue(4, 4));

        final int result = DicesLauncher.rerollMaxs(dicesMax);
        Assert.assertTrue(result > 6);
    }

    @Test
    public void testRerollMaxs2()
    {
        DicesLauncher.logs.setLength(0);
        final List<Rollable> dicesMax = new ArrayList<Rollable>();

        dicesMax.add(initDiceToValue(4, 4));
        dicesMax.add(initDiceToValue(4, 4));
        dicesMax.add(initDiceToValue(4, 4));
        dicesMax.add(initDiceToValue(4, 4));
        dicesMax.add(initDiceToValue(4, 4));
        dicesMax.add(initDiceToValue(4, 4));
        dicesMax.add(initDiceToValue(4, 4));
        dicesMax.add(initDiceToValue(4, 4));

        final int result = DicesLauncher.rerollMaxs(dicesMax);
        Assert.assertTrue(result > 6);

        System.out.println("#### Test Reroll Max ####");
        System.out.println(DicesLauncher.getRollLogs());
        System.out.println(result);
    }

    @Test
    public void testRerollMins()
    {
        DicesLauncher.logs.setLength(0);
        final List<Rollable> dicesMin = new ArrayList<Rollable>();

        dicesMin.add(initDiceToValue(20, 1));
        dicesMin.add(initDiceToValue(12, 1));
        dicesMin.add(initDiceToValue(10, 1));
        dicesMin.add(initDiceToValue(8, 1));
        dicesMin.add(initDiceToValue(6, 1));
        dicesMin.add(initDiceToValue(4, 1));

        final int result = DicesLauncher.rerollMins(dicesMin);
        Assert.assertTrue(result < -6);
    }

    @Test
    public void testRerollMins2()
    {
        DicesLauncher.logs.setLength(0);
        final List<Rollable> dicesMin = new ArrayList<Rollable>();

        dicesMin.add(initDiceToValue(4, 1));
        dicesMin.add(initDiceToValue(4, 1));
        dicesMin.add(initDiceToValue(4, 1));
        dicesMin.add(initDiceToValue(4, 1));
        dicesMin.add(initDiceToValue(4, 1));
        dicesMin.add(initDiceToValue(4, 1));
        dicesMin.add(initDiceToValue(4, 1));
        dicesMin.add(initDiceToValue(4, 1));

        final int result = DicesLauncher.rerollMins(dicesMin);
        Assert.assertTrue(result < -6);

        System.out.println("#### Test Reroll Min ####");
        System.out.println(DicesLauncher.getRollLogs());
        System.out.println(result);
    }

    @Test
    public void testStatistiques()
    {
        runLotsOfRolls(6);
        runLotsOfRolls(8);
        runLotsOfRolls(10);
        runLotsOfRolls(12);
        runLotsOfRolls(14);
        runLotsOfRolls(16);
        runLotsOfRolls(18);
        runLotsOfRolls(20);
    }

    private static void runLotsOfRolls(final int rank)
    {
        final double nbTests = 100000;
        int sum = 0;
        for (int i = 0; i < nbTests; i++)
        {
            sum += DicesLauncher.rollDices(rank, true, true);
        }
        final BigDecimal bd = new BigDecimal(sum);
        final BigDecimal average = bd.divide(new BigDecimal(nbTests));
        System.out.println("Moyenne pour rang " + rank + " : " + average.toString());
    }
}
