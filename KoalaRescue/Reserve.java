import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner;
/**
 * class Reserve is created to connect observation point and rescue
 *
 * @author Chang Su
 * @version 3
 */
public class Reserve
{
    // instance variables - replace the example below with your own
    private RandomNumber numberR;
    private ObservationPoint obserPoint;
    private SafeHaven haven;
    private int damagedTrees;
    private int deadNumber;
    private int survivalNumber;
    private int predatorNumber;
    private int relocateNumber;

    /**
     * Constructor for objects of class Reserve
     */
    public Reserve()
    {
        // initialise instance variables
        numberR = new RandomNumber();
        obserPoint = new ObservationPoint();
        haven = new SafeHaven(); 
        damagedTrees = 0;
        deadNumber = 0;
        survivalNumber = 0;
        predatorNumber = 0;
        relocateNumber = 0;
    }

    /**
     * to avoid empty remove
     */
    public boolean checkHealthySize()
    {
        return obserPoint.checkHealthySize();
    }

    /**
     * to avoid empty remove
     */
    public boolean checkInjuredSize()
    {
        return obserPoint.checkInjuredSize();
    }

    /**
     * to avoid empty remove
     */
    public boolean checkRelocateSize()
    {
        return haven.checkHealthySize();
    }

    /**
     * to calculate the possible of tree damage 
     */
    public boolean possibleDamage()
    {
        int possible = numberR.generateRandomNumber(20);
        if (possible == 20)
            return true;
        else
            return false;
    }

    /**
     * to get Edible Leave amount
     */
    public double getEdibleLeave()
    {
        return obserPoint.getEdibleLeave();
    }

    /**
     * to get Food Needed
     */
    public double getFoodNeeded()
    {
        return obserPoint.getFoodNeeded();
    }

    /**
     * to get Damaged Tree number
     */
    public int getDamagedTree()
    {
        return damagedTrees;
    }

    /**
     * to get total Dead Number of koala
     */
    public int getDeadNumber()
    {
        return deadNumber;
    }

    /**
     * to get Healthy koala Number
     */
    public int getHealthyNumber()
    {
        return obserPoint.getHealthyNumber();
    }

    /**
     * to get Injured koala Number
     */
    public int getInjuredNumber()
    {
        return obserPoint.getInjuredNumber();
    }    

    /**
     * to get Predator for each observation point
     */
    public int getPredatorNumber()
    {
        return predatorNumber;
    }

    /**
     * to get total Relocate Number
     */
    public int getRelocateNumber()
    {
        return relocateNumber;
    }

    /**
     * to get Healthy koala Number in safe haven
     */
    public int getSafeHealthyNumber()
    {
        return haven.getHealthyNumber();
    }

    /**
     * to get Injured koala Number in safe haven
     */
    public int getSafeInjuredNumber()
    {
        return haven.getInjuredNumber();
    }

    /**
     * to get Shelter Number
     */
    public int getShelterTreeNumber()
    {
        return obserPoint.getWattleNumber();
    }

    /**
     * to get total Healthy Number of koala
     */
    public int getTotalHealthyKoala()
    {
        int number = survivalNumber + getSafeHealthyNumber();
        return number;
    }

    /**
     * to record the possible damage of tree
     */
    public void damageBlue()
    {
        if (possibleDamage() && obserPoint.haveBlue())
        {
            obserPoint.damageBlue();
            damagedTrees++;
        }
    }

    /**
     * to record the possible damage of tree
     */
    public void damageManna()
    {
        if (possibleDamage() && obserPoint.haveManna())
        {
            obserPoint.damageManna();
            damagedTrees++;
        }
    }

    /**
     * to record the possible damage of tree
     */
    public void damageRiver()
    {
        if (possibleDamage() && obserPoint.haveRiver())
        {
            obserPoint.damageRiver();
            damagedTrees++;
        }
    }

    /**
     * to record the possible damage of tree
     */
    public void damageSwamp()
    {
        if (possibleDamage() && obserPoint.haveSwamp())
        {
            obserPoint.damageSwamp();
            damagedTrees++;
        }

    }

    /**
     * to record the possible damage of tree
     */
    public void damageTree()
    {
        damageManna();
        damageSwamp();
        damageBlue();
        damageRiver();
        damageWattle();
        obserPoint.updateTrees();
    }

    /**
     * to record the possible damage of tree
     */
    public void damageWattle()
    {
        if (possibleDamage() && obserPoint.haveWattle())
        {
            obserPoint.damageWattle();
            damagedTrees++;
        }
    }

    /**
     * to create Healthy koala for each observation point
     */
    public void getHealthyKoalas()
    {
        int koalaR = numberR.generateRandomNumber(10)-1;
        int number = 0;
        int ageR;
        while (number < koalaR)
        {
            ageR = numberR.generateRandomNumber(18);    
            obserPoint.addHealthyKoalas(ageR);
            number++;
        }
    }

    /**
     * to create Injured koala for each observation point
     */
    public void getInjuredKoalas()
    {
        int koalaR = numberR.generateRandomNumber(3)-1;
        int number = 0;
        int ageR;
        while (number < koalaR)
        {
            ageR = numberR.generateRandomNumber(18);    
            obserPoint.addInjuredKoalas(ageR);
            number++;
        }
    }

    /**
     * to create Predator for each observation point
     */
    public void makePredatorNumber()
    {
        predatorNumber = numberR.generateRandomNumber(5)-1;
    }

    /**
     * to move Healthy koala To Safe haven
     */
    public void moveHealthToSafe()
    {
        int age = obserPoint.getHealthyKoalaAge();
        haven.addHealthyKoalas(age);
        obserPoint.moveHealthToSafe();
    }

    /**
     * to move Injured koala To Safe haven
     */
    public void moveInjureToSafe()
    {
        int age = obserPoint.getInjuredKoalaAge();
        haven.addInjuredKoalas(age);
        obserPoint.moveInjureToSafe();
    }

    /**
     * to provide simulation background of each observation point
     */
    public void prepareBackground(int point)
    {
        obserPoint.getTree(point);
        obserPoint.getKoalaList();
        getHealthyKoalas();
        getInjuredKoalas();
        makePredatorNumber();
    }

    /**
     * to read txt
     */
    public void readFile()
    {
        obserPoint.readFile();
    }

    /**
     * to record Hungry Death of koala
     */
    public void recordHungryDeath()
    {
        if (getEdibleLeave() < obserPoint.getHealthyNumber() && checkHealthySize())
        {
            int hungryNumber = obserPoint.getHealthyNumber() - (int)getEdibleLeave();
            for (int index = 0; index < hungryNumber; index++)
            {
                int possible = numberR.generateRandomNumber(5);
                if (possible != 5)
                {
                    obserPoint.recordHealthyDeath();   
                    deadNumber++;
                }
            }
        }
    }

    /**
     * to record No Shelter Death of koala
     */
    public void recordNoShelterDeath()
    {
        if (getShelterTreeNumber() < obserPoint.getHealthyNumber() && checkHealthySize())
        {
            int number = obserPoint.getHealthyNumber() - getShelterTreeNumber();
            for (int index = 0; index < number; index++)
            {
                int possible = numberR.generateRandomNumber(5);
                if (possible == 5)
                {
                    obserPoint.recordHealthyDeath();   
                    deadNumber++;
                }
            }
        }      

    }

    /**
     * to record Death of koala due to Predator
     */
    public void recordPredatorDeath()
    {
        if (predatorNumber > 3 && checkHealthySize())
        {            
            int possible = numberR.generateRandomNumber(2);
            if (possible == 2)
            {
                obserPoint.recordHealthyDeath();   
                deadNumber++;
            }
        }
    }  

    /**
     * to relocate Healthy koala to observation point
     */
    public void relocateHealth()
    {
        int age = haven.getMaxAge();
        obserPoint.addHealthyKoalas(age);
        haven.relocateHealth();
        relocateNumber++;
    }

    /**
     * to update Survival or not of koala
     */
    public void updateSurvival()
    {
        deadNumber = deadNumber + getInjuredNumber();
        recordHungryDeath();
        recordNoShelterDeath();
        recordPredatorDeath();
        survivalNumber = survivalNumber + getHealthyNumber();
    }

    /**
     * to record the possible damage of tree
     */
    public void writeFile()
    {
        obserPoint.writeFile();
    }

}
