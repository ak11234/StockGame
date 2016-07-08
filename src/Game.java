/**
 * Created by Adam on 7/8/2016. Stock game
 */
public class Game {
    public static Stock[] TheStocks;

    public static void main(String[] args){
        Update update = new Update(TheStocks);
        new Thread(update).start();
        init();
        System.out.println(Game.TheStocks[0]);
    }

    public static void init()
    {
        Stock [] myStocks = new Stock[30];
        // requirements (String newSymbol, double newStartPrice, double newSd, double newMeanReturn)
      

       TheStocks = new Stock[30];
        // requirements (int newIndex, String newSymbol, double newStartPrice, double newSd, double newMeanReturn)
        TheStocks[0] = new Stock (0, "MMM", 176.71, 1, 1);  
        TheStocks[1] = new Stock (1, "AXP", 61.35, 1, 1); 
        TheStocks[2] = new Stock (2, "AAPL", 96.64, 1, 1); 
        TheStocks[3] = new Stock (3, "BA", 129.93, 1, 1); 
        TheStocks[4] = new Stock (4, "CAT", 77.06, 1, 1); 
        TheStocks[5] = new Stock (5, "CVX", 104.45, 1, 1);
        TheStocks[6] = new Stock (6, "CSCO", 29.3, 1, 1);
        TheStocks[7] = new Stock (7, "KO", 45.33, 1, 1);
        TheStocks[8] = new Stock (8, "DIS", 99.52, 1, 1);
        TheStocks[9] = new Stock (9, "DD", 63.52, 1, 1);

    }
}
