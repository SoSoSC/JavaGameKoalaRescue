import java.util.*;
import java.io.*;
/**
 * class ObservationPoint is to put koala list and tree list, as well as read and write txt
 *
 * @author Chang Su
 * @version 3
 */
public class ObservationPoint
{
    // instance variables - replace the example below with your own
    private String[] treesOfPoint;
    private ArrayList<String> file;
    private ArrayList<Tree> mannas;
    private ArrayList<Tree> swamps;
    private ArrayList<Tree> blues;
    private ArrayList<Tree> rivers;
    private ArrayList<Tree> wattles;
    private ArrayList<Koala> healthyKoalas;
    private ArrayList<Koala> injuredKoalas;

    /**
     * Constructor for objects of class ObservationPoint
     */
    public ObservationPoint()
    {
        // initialise instance variables
        treesOfPoint = new String[10];
        file = new ArrayList<String>();
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
     * to avoid empty remove
     */
    public boolean checkInjuredSize()
    {
        if (injuredKoalas.size() != 0)
            return true;
        else
            return false;
    }

    /**
     * to avoid empty remove
     */
    public boolean haveBlue()
    {
        if (blues.size() != 0)
            return true;
        else
            return false;
    }

    /**
     * to avoid empty remove
     */
    public boolean haveManna()
    {
        if (mannas.size() != 0)
            return true;
        else
            return false;
    }

    /**
     * to avoid empty remove
     */
    public boolean haveRiver()
    {
        if (rivers.size() != 0)
            return true;
        else
            return false;
    }

    /**
     * to avoid empty remove
     */
    public boolean haveSwamp()
    {
        if (swamps.size() != 0)
            return true;
        else
            return false;
    }

    /**
     * to avoid empty remove
     */
    public boolean haveWattle()
    {
        if (wattles.size() != 0)
            return true;
        else
            return false;
    }

    /**
     * to calculate Edible Leave
     */
    public double getEdibleLeave()
    {
        double edibleLeaves = mannas.size() * 1.00 + swamps.size() * 0.34 
            + blues.size() * 0.90 + rivers.size() * 0.40;
        return edibleLeaves;
    }

    /**
     * to get Food Needed
     */
    public double getFoodNeeded()
    {
        double foodNeeded = healthyKoalas.size() * 1.00 + injuredKoalas.size() * 1.00;
        return foodNeeded;
    }

    /**
     * to get Healthy Koala Age
     */
    public int getHealthyKoalaAge()
    {
        return healthyKoalas.get(0).getKoalaAge();
    }  

    /**
     * to get Healthy koala Number
     */
    public int getHealthyNumber()
    {
        return healthyKoalas.size();
    }

    /**
     * to get Injured Koala Age
     */
    public int getInjuredKoalaAge()
    {
        return injuredKoalas.get(0).getKoalaAge();
    }  

    /**
     * to get Injured koala Number
     */
    public int getInjuredNumber()
    {
        return injuredKoalas.size();
    }

    /**
     * to get shelter number
     */
    public int getWattleNumber()
    {
        return wattles.size();
    }

    /**
     * to add Healthy koalas to arraylist
     */
    public void addHealthyKoalas(int age)
    {
        {
            Koala koala = new Koala(age, true);
            healthyKoalas.add(koala);
        }
    }

    /**
     * to add injured koalas to arraylist
     */
    public void addInjuredKoalas(int age)
    {
        {
            Koala koala = new Koala(age, false);
            injuredKoalas.add(koala);
        }
    } 

    /**
     * to remove a damage tree
     */
    public void damageManna()
    {
        mannas.remove(0);
    }

    /**
     * to remove a damage tree
     */
    public void damageSwamp()
    {
        swamps.remove(0);
    }

    /**
     * to remove a damage tree
     */
    public void damageBlue()
    {
        blues.remove(0);
    }

    /**
     * to remove a damage tree
     */
    public void damageRiver()
    {
        rivers.remove(0);
    }

    /**
     * to remove a damage tree
     */
    public void damageWattle()
    {
        wattles.remove(0);
    }

    /**
     * to create koala arraylist
     */
    public void getKoalaList()
    {
        healthyKoalas = new ArrayList<Koala>();
        injuredKoalas = new ArrayList<Koala>();
    }

    /**
     * to provide simulation background of each observation point
     */
    public void getTree(int point)
    {
        mannas = new ArrayList<Tree>();
        swamps = new ArrayList<Tree>();
        blues = new ArrayList<Tree>();
        rivers = new ArrayList<Tree>();
        wattles = new ArrayList<Tree>();
        String[] lineArray = treesOfPoint[point-1].split(",");
        int mannaNumber = Integer.parseInt(lineArray[0]);
        int swampNumber = Integer.parseInt(lineArray[1]);
        int blueNumber = Integer.parseInt(lineArray[2]);
        int riverNumber = Integer.parseInt(lineArray[3]);
        int wattleNumber = Integer.parseInt(lineArray[4]);
        for (int number = 0; number < mannaNumber; number++) 
        {
            Tree tree = new Tree("Food","Manna Gum");
            mannas.add(tree);
        }
        for (int number = 0; number < swampNumber; number++) 
        {
            Tree tree = new Tree("Food","Swamp Gum");
            swamps.add(tree);
        }
        for (int number = 0; number < blueNumber; number++) 
        {
            Tree tree = new Tree("Food","Blue Gum");
            blues.add(tree);
        }
        for (int number = 0; number < riverNumber; number++) 
        {
            Tree tree = new Tree("Food","River Red Gum");
            rivers.add(tree);
        }
        for (int number = 0; number < wattleNumber; number++) 
        {
            Tree tree = new Tree("Shelter","Wattle");
            wattles.add(tree);
        }
    }

    /**
     * to update trees number after damage
     */
    public void updateTrees()
    {
        String newTrees = mannas.size() + "," + swamps.size()  + "," +  blues.size()  + "," + rivers.size() + "," + wattles.size();
        file.add(newTrees);
    }

    /**
     * to move Health koala To Safe haven
     */
    public void moveHealthToSafe()
    {
        if (healthyKoalas.size() != 0)
            healthyKoalas.remove(0);
    }

    /**
     * to move injured koala To Safe haven
     */
    public void moveInjureToSafe()
    {
        if (injuredKoalas.size() != 0)
            injuredKoalas.remove(0);
    }

    /**
     * to record death of healthy koala
     */
    public void recordHealthyDeath()
    {
        healthyKoalas.remove(0);
    }

    /**
     * to read txt
     */
    public void readFile()
    {        
        String fileName = "trees.txt";
        try
        {
            FileReader fileReader= new FileReader(fileName);
            try
            {
                Scanner scanner = new Scanner(fileReader);
                int index = 0;
                while (scanner.hasNextLine())
                {
                    treesOfPoint[index] = scanner.nextLine();
                    index++;
                }
            }
            finally
            {
                fileReader.close();
            }
        }

        catch(FileNotFoundException e)
        {
            System.out.println(fileName + " doesn't exist");
        }
        catch(IOException e)
        {
            System.out.println("Unexpected I/O exception occurs");
        }
    }

    /**
     * to write txt
     */
    public void writeFile()
    {
        try
        {
            PrintWriter printWriter = new PrintWriter("updatedTrees.txt");
            try
            {
                for(String newTrees : file)
                    printWriter.println(newTrees);                
            }
            finally
            {
                printWriter.close();
            }
        }
        catch(IOException e)
        {
            System.out.println("Unexpected I/O exception occurs");
        }
    }
}
