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
    
    public void updateHoldings(String s, int q)
    {
        for(int k=0, k<=myHoldings.size(), k++)
        {
            if(myHoldings.get(k).getMyStock().getSymbol().equals(s)) 
            //checks all of my holdings to see if the symbol given is the same as one of my holdings
            {
                myHoldings.get(k).changeQuantity(q);
            }//the holding exists, change its quantity using the method changeQuantity
            else
            { //the holding does not exist, make a new holding with the given variables 
                Holding s;
                s = new Holding(s, q);
            }
        }
    }
    
    public double getMyNetworth()
    {
        return myNetworth;
    }
    
    public double getMyCash()
    {
        return myCash;
    }
    
    public ArrayList getMyHoldings()
    {
        return myHoldings;
    }
    
}
