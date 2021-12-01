import java.util.*;
/**
 * this class is designed to prepare simulation, allow user to input and get output
 *
 * @author Chang
 * @version 3
 */
public class KoalaRescue
{
    // name of leader, select choice, how many run time, budget and cost
    private String choice;
    private int gameTime;
    private int budgetAmount;
    private int cost;
    private Scanner console;
    private Reserve reserve;

    /**
     * Constructor for objects of class KoalaRescue. Create attribute
     */
    public KoalaRescue()
    {
        choice = "";
        gameTime = 0;
        budgetAmount = 0;
        cost = 0;
        console = new Scanner(System.in);
        reserve = new Reserve();     
    }

    /**
     * to check budget Enough
     */
    public boolean haveEnoughBudget(int cost)
    {
        if (cost <= budgetAmount)
            return true;
        else
            return false;
    }

    /**
     * to check Food amount
     */
    public boolean haveEnoughFood()
    {
        double foodNeeded = reserve.getHealthyNumber() * 1.00 + reserve.getInjuredNumber() * 1.00;
        double foodProvided = reserve.getEdibleLeave();
        if (foodNeeded <= foodProvided)
            return true;
        else
            return false;
    }

    /**
     * to check Shelter amount
     */
    public boolean haveEnoughShelter()
    {
        int shelter = reserve.getShelterTreeNumber();
        int koalaN = reserve.getHealthyNumber() + reserve.getInjuredNumber();
        if (koalaN <= shelter)
            return true;
        else
            return false;
    }

    /**
     * to check safe
     */
    public boolean safeEnvironment()
    {
        if (haveEnoughShelter() && haveEnoughFood() && reserve.getPredatorNumber() < 3)
            return true;
        else
            return false;
    }

    /**
     * to valid the enter
     */
    public boolean validBudget(String budget)
    {
        if (budget.length() == 0)
        {
            System.out.println("Should not be blank");
            return false;
        }
        boolean isDigit = false;
        for (int i = 0; i < budget.length(); i++)
        {
            isDigit = Character.isDigit(budget.charAt(i));
            if (isDigit == false)
            {
                System.out.println("Should only contain numerical characters");
                return false;
            }
        }
        int budgetAmount = Integer.valueOf(budget);
        if (budgetAmount < 100 || budgetAmount > 200)
        {
            System.out.println("Should between 100 and 200, inclusively");
            return false;
        }
        return true;
    }

    /**
     * to enter valid Choice enter
     */
    public boolean validChoice(String choice)
    {
        if (choice.length() == 1 && (choice.charAt(0)== 'A'|| choice.charAt(0)== 'B'
            || choice.charAt(0)== 'C'|| choice.charAt(0)== 'D' ))
            return true;
        else
        {
            if (choice.length() == 0)
            {
                System.out.println("Should not be blank.");
                return false;
            }
            else
            {
                System.out.println("Please enter a character between A, B, C, D.");
                return false;
            }
        }

    }     

    /**
     * to valid choice
     */
    public boolean validChoose(char choose)
    {
        if (choose == 'A' && !haveEnoughBudget(20)) 
        {
            System.out.println("Lack of fund.Choose other."); 
            return false;
        }
        if (choose == 'A' && !reserve.checkInjuredSize()) 
        {
            System.out.println("No injured koala in reserve now.Choose other."); 
            return false;
        }
        if (choose == 'B' && !haveEnoughBudget(10)) 
        {
            System.out.println("Lack of fund. Choose other."); 
            return false;
        }
        if (choose == 'B' && !reserve.checkHealthySize()) 
        {
            System.out.println("No healthy koala in reserve now.Choose other."); 
            return false;
        }
        if (choose == 'C' && !safeEnvironment())
        {
            System.out.println("Unable to relocate due to unsafe environment. Choose other."); 
            return false;
        }
        if 
        (choose == 'C' && !reserve.checkRelocateSize())
        {
            System.out.println("No healthy koala in safe haven. Choose other."); 
            return false;
        }
        return true;
    }

    /**
     * to valid name
     */
    public boolean validName(String name)
    {
        if (name.isEmpty() )//name.length() == 0)
        {
            System.out.println("Should not be blank");
            return false;
        }
        if (name.length() >= 16)
        {
            System.out.println("Should less than 16 character");
            return false;
        }
        boolean isAlpha = false;
        for (int i = 0; i < name.length(); i++)
        {
            isAlpha = Character.isLetter(name.charAt(i));
            if (isAlpha == false)
            {
                System.out.println("Should only contain alphabetic characters");
                return false;
            }
        }
        return true;
    }  


    /**
     * to get Budget Amount
     */
    public int getBudget()
    {
        return budgetAmount;
    }

    /**
     * to enter budget amount
     */
    public void enterBudget()
    {
        String budget;    
        do
        {
            System.out.println("Please enter budget amount (a integer between 100-200 (inclusive, omit$):");
            budget = console.nextLine();
        }while (!validBudget(budget));
        System.out.println("Your budget is: $" + budget);
    }

    /**
     * to enter choice
     */
    public void enterChoice()
    {
        do
        {
            System.out.println("Please enter your choice (choose between A, B, C, D):");
            choice = console.nextLine();
        }while (!validChoice(choice) || !validChoose(choice.charAt(0)));
        System.out.print("Your choice is: " + choice);
        switch (choice.charAt(0))
        {
            case 'A': System.out.println(" Move an injured koala to the safe haven"); budgetAmount -= 20; cost += 20; break;
            case 'B': System.out.println(" Move a healthy koala to the safe haven"); budgetAmount -= 10; cost += 10; break;
            case 'C': System.out.println(" Relocate a koala to this location");budgetAmount += 5; break;
            case 'D': System.out.println(" Take no further action"); break;
        } 
    }

    /**
     * to enter name
     */
    public void enterName()
    {
        String name;
        do
        {
            System.out.println("Please enter your name (alphabetic, should less than 16 characters, cannot be blank, ):");
            name = console.nextLine();
        }while (!validName(name));
        System.out.println("Your name is: " + name);
    }

    /**
     * get simulation result
     *
     */
    public void getResult()
    {
        System.out.println("Simulation ends. Result:");
        System.out.println(reserve.getDamagedTree()+ " tree(s) lost.");
        System.out.println(reserve.getTotalHealthyKoala()+ " healthy koalas (both in the reserve and safe haven).");
        System.out.println(reserve.getSafeInjuredNumber()+ " injured koalas taken to the safe haven.");
        System.out.println(reserve.getRelocateNumber() + " koalas being relocated.");
        System.out.println("$" + cost + " spent on the rescue.");
        if (reserve.getDeadNumber() == 0)
            System.out.println("Rescue was successful, with no koala deaths.");
        else
            System.out.println("Rescue completed with " + reserve.getDeadNumber() + " koalas deaths");
    }

    /**
     * to make simulation
     */
    public void newRescue()
    {
        if (gameTime == 0)
        {
            System.out.println("Welcome to Koala Rescue Team simulation!");
            System.out.println("In this game, you will play a role as team leader of a Koala Rescue Team to rescue koala.");
            System.out.println("You will visit 10 observation points in turn and make choice to try to as many koalas with limited budget.");
            reserve.readFile();
            enterName();
            gameTime++;
        }
        enterBudget();
        for (int point =1; point < 11; point++)
        {
            provideBackground(point);
            do
            {
                provideChoice();
                enterChoice();
                runChoice(choice.charAt(0));
            }while (choice.charAt(0) != 'D');
        }
        getResult();
        reserve.writeFile();
    }

    /**
     * to provide simulation background of each observation point
     */
    public void provideBackground(int point)
    {
        reserve.prepareBackground(point);
        reserve.damageTree();
        System.out.println();
        System.out.println("You are now in the observation point " + point);
    }

    /**
     * to provide Choice
     */
    public void provideChoice()
    {
        System.out.println("The point now has:");
        System.out.println(reserve.getInjuredNumber() + " Injured koalas (cannot survive if not in safe haven)");
        System.out.println(reserve.getHealthyNumber() + " Healthy koalas");
        System.out.print(reserve.getEdibleLeave() + "kg edible leaves,");   
        System.out.println("(while current amount of koalas on point need "+ reserve.getFoodNeeded() + "kg edible leaves).");
        System.out.println(reserve.getShelterTreeNumber() + " Shelter Trees (where koalas live, each can accomodate only one koala, no shelter can lead to death of koala)");
        System.out.println(reserve.getPredatorNumber() + " Predator(s) of koalas (more than 3 can cause a koala died)");
        System.out.println();
        System.out.println("The safe haven has:");
        System.out.println(reserve.getSafeHealthyNumber() + " healthy koala");
        System.out.println(reserve.getSafeInjuredNumber() + " injured koala");
        System.out.println();
        System.out.println("Now koalas in point are:");
        System.out.println((haveEnoughFood() ? "with enough food." : "lack of food."));
        System.out.println((haveEnoughShelter() ? "with enough shelter." : "lack of shelter."));
        System.out.println("The environment is " +((safeEnvironment()) ? "safe" : "unsafe") + " for relocate healthy koala from safe haven.");
        System.out.println(((reserve.getPredatorNumber() > 3) ? "Too many predators." : "Not too many predators."));
        System.out.println();
        System.out.println("You now have $"+ getBudget() + " budget leaved. So you can choose from:");
        if (haveEnoughBudget(20) && reserve.checkInjuredSize())
            System.out.println("A. Move an injured koala to the safe haven, cost $20.(Injured koala cannot survive outside safe haven)");
        if (haveEnoughBudget(10) && reserve.checkHealthySize())
            System.out.println("B. Move a healthy koala to the safe haven, cost $10.(choose due to shortage of food or shelter, or predators >3, which can cause death of koala, can be relocated through C)");
        if (safeEnvironment() && reserve.checkRelocateSize())
            System.out.println("C. Relocate a koala to this location (add $5 to budget, should be in safe environment.)");
        System.out.println("D. Take no further action");
    }

    /**
     * to run choice
     */
    public void runChoice(char choose)
    {
        if (choose == 'A')
            reserve.moveInjureToSafe();
        if (choose == 'B')
            reserve.moveHealthToSafe();
        if (choose == 'C')  
            reserve.relocateHealth();
        if (choose == 'D')  
            updateSurvival();            
    }

    /**
     * to update survival after choose D
     */
    public void updateSurvival()
    {
        reserve.updateSurvival();
        System.out.println("Until now there are " + reserve.getDeadNumber() + " koala(s) dead.");
    }
}
