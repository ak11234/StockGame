import org.apache.commons.math3.distribution.NormalDistribution;

/**
 * Created by Adam on 7/8/2016. Stock object
 */
public class Stock {
    private int index;
    private String symbol;
    private double std, meanReturn;
    private double startPrice, currentPrice, changePrice, changePercent;

    public Stock(String newSymbol, double newStartPrice){

        symbol=newSymbol;
        startPrice=newStartPrice;
    }
    
    public double getPrice(){
        return currentPrice;
    }
    
    public void changePrice(){
        NormalDistribution distMarket= new NormalDistribution(0.1/230, 0.2/(Math.sqrt(230)));
        NormalDistribution distMe=new NormalDistribution(0.1*meanReturn/230, 0.2*std/(Math.sqrt(230)));
        double market = Double.parseDouble(distMarket.toString());
        double me = Double.parseDouble(distMarket.toString());
        double newPrice = currentPrice*(1+market)*(1+me);
        currentPrice=newPrice;
    }
}
