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


}
