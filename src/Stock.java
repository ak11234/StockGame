import acm.graphics.GLabel;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.util.DoubleArray;

import java.text.DecimalFormat;

/**
 * Created by Josh and Adam on 7/8/2016. Stock object
 */
public class Stock extends GLabel implements Runnable {
    private String name;
    private String symbol;
    private double sd, meanReturn;
    private double quantity=0.0;
    private double startPrice, changePrice, changePercent, currentPrice;
    private Game myGame;
    private int x, y;
    private String didGrow="^";
    private int index;
    //constructor
    public Stock(String newName, String newSymbol, double newStartPrice, double newSd, double newMeanReturn, Game g, int newindex){
        super("", 0, 0);
        symbol=newSymbol;
        currentPrice=newStartPrice;
        name=newName ;
        sd= newSd;
        meanReturn= newMeanReturn;
        myGame = g;
        index = newindex; 
    }

    public double getPrice(){
        return currentPrice;
    }

    public String getSymbol(){
        return symbol;
    }
    
    public int getIndex(){
        return index;
    }

    public String toString(){
        return (name+":" + symbol + "\t   Current Price: " + new DecimalFormat("#.##").format(currentPrice)) +"   "+didGrow;
    }

    public String getName(){
        return name;
    }

    public void updateLabel(){
        setLabel(toString());
    }

    public void setPrice(double newPrice)
    {
        currentPrice=newPrice;
        updateLabel();
    }

    public void init(){

    }

    //changes the price of the stocks
    public void run() {
        //practical init meathod
        move(15, 35+(index*20));
        setLabel(toString());
        myGame.add(this);
        NormalDistribution distMe= new NormalDistribution(0.1*meanReturn/230, 0.2*sd/(Math.sqrt(230)));
        while(true){
            pause(myGame.speed);
            

            //change for individual stock
            double market = myGame.getDistMarket().sample();
            if (Double.isNaN(market)){
                while (Double.isNaN(market)){
                    market = myGame.getDistMarket().sample();
                }
            }
            double me = distMe.sample();
            double newPrice = currentPrice*(1+market)*(1+me);
            if(newPrice-currentPrice>=0){
                didGrow="^";
            }
            else{
                didGrow="V";
            }
            setPrice(newPrice);
        }
    }
}
