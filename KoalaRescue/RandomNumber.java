import java.util.Random;
/**
 * The RandomNumber class generate a random number form 1 to a
 * input maximum number.
 *
 * @author Chang Su
 * @version 1
 */

public class RandomNumber
{
    /**
     * generate a random number between 1 and input number.
     */
    public int generateRandomNumber(int maximumNumber)
    {
        return 1 + (int)(Math.random() * maximumNumber);
    }

}
