import acm.graphics.GLabel;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

import static javax.swing.SwingConstants.SOUTH;
/**
 * The user class
 * 
 * @author (Josh Gross) 
 */
public class User extends GLabel implements Runnable {
    private double myNetworth;
    private double myCash;
    private ArrayList<Holding> myHoldings;
    private Game myGame;
    public boolean gameOver=false;

    public User(Game g)
    {
        super("", 0, 0);
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

                myHoldings.get(k).setQuantity(q);

                //sets that holding to be the result of change quantity

                myCash = myCash- myGame.getTheStocks()[k].getPrice() * q;

                //subtracts cash

                return; //ends the function  
            }//the holding exists, change its quantity using the method changeQuantity
        }    

        for(int j=0; j<myGame.getTheStocks().length; j++)
        {  //holding does not exist, creates a new one with a stock from the game's array 
            if(myGame.getTheStocks()[j].getSymbol().equals(s))
            {
                Holding h;
                h = new Holding(q, myGame.getTheStocks()[j], myGame);
                myHoldings.add(h);
                new Thread(h).start();

                //creates new holding

                myCash = myCash- myGame.getTheStocks()[j].getPrice() * q;

                //subtracts cash

                return;
            }
        }
    }

    public void buyDow(){
        for(int s=0; s<myGame.getTheStocks().length; s++){
            updateHoldings(myGame.getTheStocks()[s].getSymbol(), 10) ;
        }
    }

    public void sellDow(){
        for(int s=0; s<myGame.getTheStocks().length; s++){
            updateHoldings(myGame.getTheStocks()[s].getSymbol(), -10) ;
        }
    }

    public double getMyNetworth()
    {
        myNetworth = myCash;
        for(int k=0; k<myHoldings.size(); k++)
        {
            myNetworth = myNetworth+
            (myHoldings.get(k).getMyStock().getPrice() * myHoldings.get(k).getQuantity());

        }//sets networth

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
        String result = "";
      
        result+="Your cash: "+ new DecimalFormat("#.##").format(myCash) + "\t    ";
            result+="Your Net Worth: "+ new DecimalFormat("#.##").format(getMyNetworth());
        
        return result;
    }

    public void run(){
        move(800, 50);
        setLabel(toString());
        myGame.add(this);
        while (true){
            for (int k=0; k<myHoldings.size(); k++){
                if (myHoldings.get(k).getQuantity()<1){
                    myHoldings.get(k).setVisible(false);
                    myHoldings.get(k).setLabel(null);
                    myHoldings.remove(k);
                    break;
                }
                myHoldings.get(k).setLocation(800, 75+(k*20));
            }
            setLabel(toString());
            pause(500);
            if(myCash<=0){
                gameOver=true;
            }
        }
    }
}
