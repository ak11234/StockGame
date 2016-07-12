import acm.graphics.GLabel;

import javax.swing.*;
import java.text.DecimalFormat;

/**
 * Write a description of class Holdings here.
 * 
 * @Josh and Adam
 */
public class Holding extends GLabel implements Runnable
{
    private int myQuantity;
    private Stock myStock;
    private Game myGame;
    private double buyPrice;
    //a holding is initialized with a stock and the initial buy quantity
    public Holding(int Q, Stock S, Game game)
    {
        super("",0,0);
        myQuantity= Q;
        myStock= S;
        myGame=game;
        buyPrice=myStock.getPrice();
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
            pause(500);
        }

    }
    
    public String toString(){
        return ("You own: " + myQuantity + " of: " + myStock.getSymbol() + " which is worth " +new DecimalFormat("#.##").format(myStock.getPrice()*myQuantity) + " It was purchased at:  " + new DecimalFormat("#.##").format(buyPrice));
    }

}
