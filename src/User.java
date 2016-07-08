import java.util.ArrayList;
/**
 * The user class
 * 
 * @author (Josh Gross) 
 */
public class User
{
    private double myNetworth;
    private double myCash;
    private ArrayList<Holding> myHoldings;
    
    public User()
    {
        // initialise instance variables
        myCash= 1000000;
        myNetworth=myCash;
        myHoldings=null;
    }

}
