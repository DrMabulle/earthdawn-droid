/**
 * 
 */
package fr.android.earthdawn.dices;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author DrMabulle
 *
 */
public class DiceTest
{

    /**
     * Test method for {@link fr.android.earthdawn.dices.Dice#roll()}.
     */
    @Test
    public void testRoll()
    {
        final Dice dice = new Dice(20);

        int result = dice.roll();
        Assert.assertTrue(result > 0 && result <= 20);
        System.out.println(dice.toString() + " rolled " + result);

        result = dice.roll();
        Assert.assertTrue(result > 0 && result <= 20);
        System.out.println(dice.toString() + " rolled " + result);

        result = dice.roll();
        Assert.assertTrue(result > 0 && result <= 20);
        System.out.println(dice.toString() + " rolled " + result);

        result = dice.roll();
        Assert.assertTrue(result > 0 && result <= 20);
        System.out.println(dice.toString() + " rolled " + result);

        result = dice.roll();
        Assert.assertTrue(result > 0 && result <= 20);
        System.out.println(dice.toString() + " rolled " + result);
    }

    /**
     * Test method for {@link fr.android.earthdawn.dices.Dice#getPreviousResult()}.
     */
    @Test
    public void testGetPreviousResult()
    {
        final Dice dice = new Dice(20);

        int result1 = dice.roll();
        int result2 = dice.getPreviousResult();
        Assert.assertEquals(result1, result2);
        Assert.assertTrue(result1 > 0 && result1 <= 20);
        System.out.println(dice.toString() + " rolled " + result1);

        result1 = dice.roll();
        result2 = dice.getPreviousResult();
        Assert.assertEquals(result1, result2);
        Assert.assertTrue(result1 > 0 && result1 <= 20);
        System.out.println(dice.toString() + " rolled " + result1);

        result1 = dice.roll();
        result2 = dice.getPreviousResult();
        Assert.assertEquals(result1, result2);
        Assert.assertTrue(result1 > 0 && result1 <= 20);
        System.out.println(dice.toString() + " rolled " + result1);

        result1 = dice.roll();
        result2 = dice.getPreviousResult();
        Assert.assertEquals(result1, result2);
        Assert.assertTrue(result1 > 0 && result1 <= 20);
        System.out.println(dice.toString() + " rolled " + result1);

        result1 = dice.roll();
        result2 = dice.getPreviousResult();
        Assert.assertEquals(result1, result2);
        Assert.assertTrue(result1 > 0 && result1 <= 20);
        System.out.println(dice.toString() + " rolled " + result1);
    }

    /**
     * Test method for {@link fr.android.earthdawn.dices.Dice#isMaxValue()}.
     */
    @Test
    public void testIsMaxValue()
    {
        final Dice dice = new Dice(20);

        int result = dice.roll();
        while (result != 20)
        {
            result = dice.roll();
        }

        Assert.assertTrue(dice.getPreviousResult() == 20);
        Assert.assertTrue(dice.isMaxValue());
        Assert.assertFalse(dice.isMinValue());
    }

    /**
     * Test method for {@link fr.android.earthdawn.dices.Dice#isMinValue()}.
     */
    @Test
    public void testIsMinValue()
    {
        final Dice dice = new Dice(20);

        int result = dice.roll();
        while (result != 1)
        {
            result = dice.roll();
        }

        Assert.assertTrue(dice.getPreviousResult() == 1);
        Assert.assertFalse(dice.isMaxValue());
        Assert.assertTrue(dice.isMinValue());
    }

}
