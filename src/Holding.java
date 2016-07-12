import acm.graphics.GLabel;

import javax.swing.*;

/**
 * Write a description of class Holdings here.
 * 
 * @Josh 
 */
public class Holding extends GLabel implements Runnable
{
    private int myQuantity;
    private Stock myStock;
    private Game myGame;
    //a holding is initialized with a stock and the initial buy quantity
    public Holding(int Q, Stock S, Game game)
    {
        super("",0,0);
        myQuantity= Q;
        myStock= S;
        myGame=game;
    }
    
    public Holding changeQuantity(int x)
    {
       Holding update;
       update= new Holding(myQuantity+x, myStock, myGame);
       return update;
    }
    
    public void  setQuantity(int x){
        myQuantity+=x;
    }
    
    public Stock getMyStock()
    {
        return myStock;
    }
    
    public int getQuantity()
    {
        return myQuantity;
    }
    
    public void run(){
        //practical init meathod
        setLabel(toString());
        myGame.add(this);
        while (true){
            setLabel(toString());
            pause(1000);
        }

    }
    
    public String toString(){
        return ("You own: " + myQuantity + " of: " + myStock.getSymbol());
    }

}
