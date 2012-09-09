/**
 *
 */
package fr.android.earthdawn.dices;

import junit.framework.TestCase;
import fr.android.earthdawn.dices.impl.Dice;

/**
 * @author DrMabulle
 *
 */
public class DiceTest extends TestCase
{
    public void testRoll()
    {
        final Dice dice = new Dice(20);

        int result = dice.roll();
        assertTrue(result > 0 && result <= 20);
        System.out.println(dice.toString() + " rolled " + result);

        result = dice.roll();
        assertTrue(result > 0 && result <= 20);
        System.out.println(dice.toString() + " rolled " + result);

        result = dice.roll();
        assertTrue(result > 0 && result <= 20);
        System.out.println(dice.toString() + " rolled " + result);

        result = dice.roll();
        assertTrue(result > 0 && result <= 20);
        System.out.println(dice.toString() + " rolled " + result);

        result = dice.roll();
        assertTrue(result > 0 && result <= 20);
        System.out.println(dice.toString() + " rolled " + result);
    }

    public void testGetPreviousResult()
    {
        final Dice dice = new Dice(20);

        int result1 = dice.roll();
        int result2 = dice.getPreviousResult();
        assertEquals(result1, result2);
        assertTrue(result1 > 0 && result1 <= 20);
        System.out.println(dice.toString() + " rolled " + result1);

        result1 = dice.roll();
        result2 = dice.getPreviousResult();
        assertEquals(result1, result2);
        assertTrue(result1 > 0 && result1 <= 20);
        System.out.println(dice.toString() + " rolled " + result1);

        result1 = dice.roll();
        result2 = dice.getPreviousResult();
        assertEquals(result1, result2);
        assertTrue(result1 > 0 && result1 <= 20);
        System.out.println(dice.toString() + " rolled " + result1);

        result1 = dice.roll();
        result2 = dice.getPreviousResult();
        assertEquals(result1, result2);
        assertTrue(result1 > 0 && result1 <= 20);
        System.out.println(dice.toString() + " rolled " + result1);

        result1 = dice.roll();
        result2 = dice.getPreviousResult();
        assertEquals(result1, result2);
        assertTrue(result1 > 0 && result1 <= 20);
        System.out.println(dice.toString() + " rolled " + result1);
    }

    public void testIsMaxValue()
    {
        final Dice dice = new Dice(20);

        int result = dice.roll();
        while (result != 20)
        {
            result = dice.roll();
        }

        assertTrue(dice.getPreviousResult() == 20);
        assertTrue(dice.isMaxValue());
        assertFalse(dice.isMinValue());
    }

    public void testIsMinValue()
    {
        final Dice dice = new Dice(20);

        int result = dice.roll();
        while (result != 1)
        {
            result = dice.roll();
        }

        assertTrue(dice.getPreviousResult() == 1);
        assertFalse(dice.isMaxValue());
        assertTrue(dice.isMinValue());
    }
}
