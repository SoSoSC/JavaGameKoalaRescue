
/**
 * class Koala to provide background of simulation with age and condition(healthy or injured).
 *
 * @author Chang Su
 * @version 3
 */

public class Koala
{
    // instance variables - replace the example below with your own
    private int age;
    private boolean condition;

    /**
     * Constructor for objects of class Koala
     */
    public Koala()
    {
        age = 0;
        condition = false;
    }

    /**
     * to create non-default koala
     */
    public Koala(int koalaAge, boolean koalaCondition)
    {
        // initialise instance variables  
        age = koalaAge;
        condition = koalaCondition;
    } 

    /**
     * to get Koala Condition
     */
    public boolean getKoalaCondition()
    {
        return condition;
    }

    /**
     * to get koala age
     */
    public int getKoalaAge()
    {
        return age;
    }

    /**
     * to set Koala Age
     */
    public void setKoalaAge(int koalaAge)
    {
        age = koalaAge;
    }    

    /**
     * to set Koala Condition
     */
    public void setKoalaCondition(boolean koalaCondition)
    {
        condition = koalaCondition;
    }      

}
