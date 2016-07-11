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
    private Game myGame; 
    public User(Game g)
    {
        // initialise instance variables
        myCash= 1000000;
        myNetworth=myCash;
        myHoldings=null;
        myGame=g;
    }

    public void updateHoldings(String s, int q)
    {
        for(int k=0; k<=myHoldings.size(); k++)
        {
            if(myHoldings.get(k).getMyStock().getSymbol().equals(s)) 
            //checks all of my holdings to see if the symbol given is the same as one of my holdings
            {
                myHoldings.get(k).changeQuantity(q);
                return; //ends the function  
            }//the holding exists, change its quantity using the method changeQuantity
        }    
        
        for(int j=0; j<myGame.getTheStocks().length; j++)
        {  //holding does not exist, creates a new one with a stock from the game's array 
            if(myGame.getTheStocks()[j].getSymbol().equals(s))
            {
                Holding h;
                h = new Holding(q, myGame.getTheStocks()[j]);
                myHoldings.add(h);
                return;
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
