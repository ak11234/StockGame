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
    
    public double changePrice(){
        return currentPrice*(1+NormalDistribution(0.1/230, 0.2/(Math.sqrt(230))
        *(1+NormalDistribution(0.1*meanReturn/230, 0.2*std/(Math.sqrt(230))))));
    }
}
