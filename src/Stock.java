import acm.graphics.GLabel;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.util.DoubleArray;

import java.text.DecimalFormat;

/**
 * Created by Josh and Adam on 7/8/2016. Stock object
 */
public class Stock extends GLabel implements Runnable {
    private int index;
    private String symbol;
    private double sd, meanReturn;
    private double quantity=0.0;
    private double startPrice, changePrice, changePercent, currentPrice;
    private Game myGame;
    private int x, y;

    //constructor
    public Stock(int newIndex, String newSymbol, double newStartPrice, double newSd, double newMeanReturn, Game g){
        super("", 0, 0);
        symbol=newSymbol;
        currentPrice=newStartPrice;
        index= newIndex ;
        sd= newSd;
        meanReturn= newMeanReturn;
        myGame = g;
    }

    public double getPrice(){
        return currentPrice;
    }

    public String getSymbol(){
        return symbol;
    }

    public String toString(){
        return ("Symbol: " + symbol + "\t   Current Price: " + currentPrice);
    }

    public int getIndex(){
        return index;
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
            pause(1000);
            

            //change for individual stock
            double market = myGame.getDistMarket().sample();
            if (Double.isNaN(market)){
                while (Double.isNaN(market)){
                    market = myGame.getDistMarket().sample();
                }
            }
            System.out.println(symbol + "market: " + market);
            double me = distMe.sample();
            System.out.println(symbol+ "me: " + me);
            double newPrice = currentPrice*(1+market)*(1+me);
            System.out.println(symbol + newPrice);
            setPrice(newPrice);
        }
    }
}
