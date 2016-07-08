/**
 * Created by Adam on 7/8/2016. Stock game
 */
public class Game {

    public static void main(String args){
        Update update = new Update(Stocks);
        new Thread(update).start();
    }

    public static void init()
    {
        Stock [] myStocks = new Stock[30];
        // requirements (String newSymbol, double newStartPrice, double newSd, double newMeanReturn)
        Stock ThreeM = new Stock ("MMM", 176.71, 1, 1);

    }
}
