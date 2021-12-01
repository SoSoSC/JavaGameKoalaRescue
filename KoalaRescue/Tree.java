
/**
 * to provide Tree for koala environment
 *
 * @author Chang Su
 * @version 3
 */
public class Tree
{
    // instance variables - replace the example below with your own
    private String usage;
    private String type;

    /**
     * Constructor for objects of class Tree
     */
    public Tree()
    {
        // initialise instance variables
        usage = "";
        type = "";
    }

    /**
     * to create non-default tree
     */
    public Tree(String newUsage, String newType)
    {
        usage = newUsage;
        type = newType;
    }

    /**
     * to get tree type
     */
    public String getType()
    {
        return type;
    }

    /**
     * to get tree usage
     */
    public String getUsage()
    {
        return usage;
    }

    /**
     * to set tree type
     */
    public void setType(String newType)
    {
        type = newType;
    }

    /**
     * to set tree usage
     */
    public void setUsage(String newUsage)
    {
        usage = newUsage;
    }
}
