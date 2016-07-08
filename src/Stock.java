import org.apache.commons.math3.distribution.NormalDistribution;

/**
 * Created by Adam on 7/8/2016. Stock object
 */
public class Stock {
    private int index;
    private String symbol;
    private double sd, meanReturn;
    private double quantity=0.0;
    private double startPrice, changePrice, changePercent, currentPrice;
    
    //constructor
    public Stock(int newIndex, String newSymbol, double newStartPrice, double newSd, double newMeanReturn){
        symbol=newSymbol;
        currentPrice=newStartPrice;
        index= newIndex ;
        sd= newSd;
        meanReturn= newMeanReturn;
    }
    
    //changes the price of an individual stock object
    public void changePrice(){
        NormalDistribution distMarket= new NormalDistribution(0.1/230, 0.2/(Math.sqrt(230)));
        NormalDistribution distMe=new NormalDistribution(0.1*meanReturn/230, 0.2*sd/(Math.sqrt(230)));
        double market = Double.parseDouble(distMarket.toString());
        double me = Double.parseDouble(distMarket.toString());
        double newPrice = currentPrice*(1+market)*(1+me);
        currentPrice=newPrice;
    }
    
    public double getPrice(){
        return currentPrice;
    }
    
    public String getSymbol(){
        return symbol;
    }
    
    public String toString(){
        return ("Symbol: " + symbol + "\t Current Price: " + currentPrice);
    }
    public int getIndex(){
        return index;
    }
}
