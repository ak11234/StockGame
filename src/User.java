import java.util.ArrayList;
import java.util.Arrays;

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
        myHoldings= new ArrayList<Holding>();
        myGame=g;
    }

    public void updateHoldings(String s, int q)
    {
        for(int k=0; k<myHoldings.size(); k++)
        {
            if(myHoldings.get(k).getMyStock().getSymbol().equals(s)) 
            //checks all of my holdings to see if the symbol given is the same as one of my holdings
            {
                myHoldings.set(k, myHoldings.get(k).changeQuantity(q));
                //sets that holding to be the result of change quantity
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
    
    public String toString(){
        String result = "Your Holdings: \n";
        for (Holding holding : myHoldings){
            result+="You own ";
            result+=holding.getQuantity();
            result+=" shares of ";
            result+=holding.getMyStock().getSymbol();
            result+=" which is worth: $";
            result+=holding.getMyStock().getPrice()*Double.parseDouble(Integer.toString(holding.getQuantity()));
            result+="\n";
        }
        return result;
    }

}
