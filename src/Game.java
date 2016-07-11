import acm.graphics.*;
import acm.gui.TableLayout;
import acm.program.GraphicsProgram;

import javax.swing.*;
import java.awt.event.ActionEvent;


/**
 * Created by Adam on 7/8/2016. Stock game
 */
public class Game extends GraphicsProgram {
    public static Stock[] TheStocks;
    private String rawStockChart;
    JTextField symbolEntered = new JTextField(9);
    JTextField quantityEntered = new JTextField(9);
    User user;

    public static void main(String[] args){
        
        Game myGame = new Game();
        myGame.start();
    }
    
    public Stock[] getTheStocks()
    {
        return TheStocks;
    }
    
    public void init()
    {
        Stock [] myStocks = new Stock[30];
        user = new User(this);
        
        TheStocks = new Stock[30];
        // requirements (int newIndex, String newSymbol, double newStartPrice, double newSd, double newMeanReturn)
        TheStocks[0] = new Stock (0, "MMM", 176.71, 1, 1); //3M
        TheStocks[1] = new Stock (1, "AXP", 61.35, 1, 1);  //American Express
        TheStocks[2] = new Stock (2, "AAPL", 96.64, 1, 1); //Apple
        TheStocks[3] = new Stock (3, "BA", 129.93, 1, 1);  //Boeing
        TheStocks[4] = new Stock (4, "CAT", 77.06, 1, 1);  //Caterpillar
        TheStocks[5] = new Stock (5, "CVX", 104.45, 1, 1); //Chevron
        TheStocks[6] = new Stock (6, "CSCO", 29.3, 1, 1);  //Cisco
        TheStocks[7] = new Stock (7, "KO", 45.33, 1, 1);   //Coca-Cola
        TheStocks[8] = new Stock (8, "DIS", 99.52, 1, 1);  //Disney
        TheStocks[9] = new Stock (9, "DD", 63.52, 1, 1);   //E I du Pont de Nemours and Co
        TheStocks[10]= new Stock (10, "XOM", 93.47, 1, 1); //Exxon Mobil
        TheStocks[11]= new Stock (11, "GE", 32.19, 1, 1);  //General Electric
        TheStocks[12]= new Stock (12, "GS", 150.66, 1, 1); //Goldman Sachs
        TheStocks[13]= new Stock (13, "HD", 133.76, 1, 1); //Home Depot
        TheStocks[14]= new Stock (14, "IBM", 154.22, 1, 1);//IBM
        TheStocks[15]= new Stock (15, "INTC", 33.93, 1, 1);//Intel
        TheStocks[16]= new Stock (16, "JNJ", 122.55, 1, 1);//Johnson & Johnson
        TheStocks[17]= new Stock (17, "JPM", 61.85, 1, 1); //JPMorgan Chase
        TheStocks[18]= new Stock (18, "MCD", 121.40, 1, 1);//McDonald's
        TheStocks[19]= new Stock (19, "MRK", 59.23, 1, 1); //Merck
        TheStocks[20]= new Stock (20, "MSFT", 52.23, 1, 1);//Microsoft
        TheStocks[21]= new Stock (21, "NKE", 56.61, 1, 1); //Nike
        TheStocks[22]= new Stock (22, "PFE", 35.99, 1, 1); //Phizer
        TheStocks[23]= new Stock (23, "PG", 85.72, 1, 1);  //Procter & Gamble
        TheStocks[24]= new Stock (24, "TRV", 117.90, 1, 1);//Travelers Companies Inc
        TheStocks[25]= new Stock (25, "UTX", 103.38, 1, 1);//United Technologies 
        TheStocks[26]= new Stock (26, "UNH", 141.18, 1, 1);//UnitedHealth
        TheStocks[27]= new Stock (27, "VZ", 55.90, 1, 1);  //Verizon
        TheStocks[28]= new Stock (28, "V", 76.13, 1, 1);   //Visa
        TheStocks[29]= new Stock (29, "WMT", 73.56, 1, 1); //Walmart

        /* rawStockChart="<html>";
        for(Stock k : Game.TheStocks){
            rawStockChart+=k.toString();
            rawStockChart+="<br><br>";
        }
        rawStockChart+="</html>";
        System.out.println(rawStockChart);
        stockChart.setText(rawStockChart);
        add(stockChart);*/

    }
    
    public void run(){
        for (Stock k : Game.TheStocks){
            GLabel stock = new GLabel(k.toString(), 15, 35+(k.getIndex()*20));
            add(stock);
        }

        add(new JLabel("Stock Symbol: "), SOUTH);
        add(symbolEntered, SOUTH);
        add(new JLabel("Amount: "), SOUTH);
        add(quantityEntered, SOUTH);
        add(new JButton("Buy") ,SOUTH);
        add(new JButton("Sell"), SOUTH);
        addActionListeners();

        Update update = new Update(TheStocks);
        new Thread(update).start();
        User user = new User(this);
        System.out.println(user.getMyHoldings());
    }
    
    public void actionPerformed(ActionEvent e){
        String key;
        key = e.getActionCommand();
        System.out.println(key);
        System.out.println(symbolEntered.getText());
        System.out.println(quantityEntered.getText());
        if (key.equals("Buy") || key.equals("Sell")){ //If we are buying/selling
            boolean validSymbol = false;
            boolean validQuantity = false;
            int qualifiedQuantity=Integer.parseInt(quantityEntered.getText());
            for (Stock stock : TheStocks){ //Make sure they entered a valid stock symbol
                if (stock.getSymbol().equals(symbolEntered.getText())){ //If its found, mark valid
                    validSymbol=true;
                }
            }
            if (qualifiedQuantity>0){ //Quantity must be bigger than 0 (positive)
                validQuantity=true;
                if (key.equals("Sell")){
                    qualifiedQuantity= -qualifiedQuantity; //Reverse the number if the order is to sell
                }
            }
            if (validSymbol&&validQuantity){
                //Do the trade in question
                user.updateHoldings(symbolEntered.getText(), qualifiedQuantity);
            } else {
                System.out.println("Invalid Entry");
            }
            System.out.println("----------");
            System.out.println(key);
            System.out.println(symbolEntered.getText());
            System.out.println(qualifiedQuantity);
            System.out.println(user);

        }
    }
}
