import java.util.*;
/**
 * class SafeHaven to put koala list in safe
 *
 * @author Chang Su
 * @version 3
 */
public class SafeHaven
{
    // instance variables - replace the example below with your own
    private ArrayList<Koala> healthyKoalas;
    private ArrayList<Koala> injuredKoalas;
    int index;

    /**
     * Constructor for objects of class SafeHaven
     */
    public SafeHaven()
    {
        healthyKoalas = new ArrayList<Koala>();
        injuredKoalas = new ArrayList<Koala>();
        index = 0;
    }

    /**
     * to avoid empty remove
     */
    public boolean checkHealthySize()
    {
        if (healthyKoalas.size() != 0)
            return true;
        else
            return false;
    }

    /**
     * to get Healthy koala Number in safe haven
     */
    public int getHealthyNumber()
    {
        return healthyKoalas.size();
    }

    /**
     * to get Injured koala Number in safe haven
     */
    public int getInjuredNumber()
    {
        return injuredKoalas.size();
    }

    /**
     * to get Max Age of Healthy koala in safe haven
     */
    public int getMaxAge()
    {
        int maxAge = 0;
        for (Koala koala : healthyKoalas)
        {
            if (koala.getKoalaAge() > maxAge)
                maxAge = koala.getKoalaAge();
        }
        return maxAge;
    }

    /**
     * to add Healthy Koalas to arraylist
     */
    public void addHealthyKoalas(int age)
    {
        Koala koala = new Koala(age, true);
        healthyKoalas.add(koala);        
    }

    /**
     * to add Injured Koalas to arraylist
     */
    public void addInjuredKoalas(int age)
    {
        Koala koala = new Koala(age, false);
        injuredKoalas.add(koala);
    }

    /**
     * to relocate Healthy koala to observation point
     */
    public void relocateHealth()
    {
        int maxAge = getMaxAge();
        int koalaAge = 0;
        index = 0;
        while (koalaAge != maxAge)
        {
            koalaAge = healthyKoalas.get(index).getKoalaAge();
            index++;
        }
        healthyKoalas.remove(index-1);
    }
}
