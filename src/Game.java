import acm.graphics.*;
import acm.gui.TableLayout;
import acm.program.GraphicsProgram;
import org.apache.commons.math3.distribution.NormalDistribution;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


/**
 * Created by Adam on 7/8/2016. Stock game
 */
public class Game extends GraphicsProgram implements Runnable{ 
    public static Stock[] TheStocks;
    JTextField symbolEntered = new JTextField(9);
    JTextField quantityEntered = new JTextField(9);
    User user;
    ArrayList<GLabel> stockLabels;
    NormalDistribution distMarket;

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
        user= new User(this);
        new Thread(user).start();
        distMarket= new NormalDistribution(0.1/230, 0.2/(Math.sqrt(230)));
        TheStocks = new Stock[30];
        // requirements (int newIndex, String newSymbol, double newStartPrice, double newSd, double newMeanReturn)
        TheStocks[0] = new Stock (0, "MMM", 176.71, 1, 1, this); //3M
        TheStocks[1] = new Stock (1, "AXP", 61.35, 1, 1, this);  //American Express
        TheStocks[2] = new Stock (2, "AAPL", 96.64, 1, 1, this); //Apple
        TheStocks[3] = new Stock (3, "BA", 129.93, 1, 1, this);  //Boeing
        TheStocks[4] = new Stock (4, "CAT", 77.06, 1, 1, this);  //Caterpillar
        TheStocks[5] = new Stock (5, "CVX", 104.45, 1, 1, this); //Chevron
        TheStocks[6] = new Stock (6, "CSCO", 29.3, 1, 1, this);  //Cisco
        TheStocks[7] = new Stock (7, "KO", 45.33, 1, 1, this);   //Coca-Cola
        TheStocks[8] = new Stock (8, "DIS", 99.52, 1, 1, this);  //Disney
        TheStocks[9] = new Stock (9, "DD", 63.52, 1, 1, this);   //E I du Pont de Nemours and Co
        TheStocks[10]= new Stock (10, "XOM", 93.47, 1, 1, this); //Exxon Mobil
        TheStocks[11]= new Stock (11, "GE", 32.19, 1, 1, this);  //General Electric
        TheStocks[12]= new Stock (12, "GS", 150.66, 1, 1, this); //Goldman Sachs
        TheStocks[13]= new Stock (13, "HD", 133.76, 1, 1, this); //Home Depot
        TheStocks[14]= new Stock (14, "IBM", 154.22, 1, 1, this);//IBM
        TheStocks[15]= new Stock (15, "INTC", 33.93, 1, 1, this);//Intel
        TheStocks[16]= new Stock (16, "JNJ", 122.55, 1, 1, this);//Johnson & Johnson
        TheStocks[17]= new Stock (17, "JPM", 61.85, 1, 1, this); //JPMorgan Chase
        TheStocks[18]= new Stock (18, "MCD", 121.40, 1, 1, this);//McDonald's
        TheStocks[19]= new Stock (19, "MRK", 59.23, 1, 1, this); //Merck
        TheStocks[20]= new Stock (20, "MSFT", 52.23, 1, 1, this);//Microsoft
        TheStocks[21]= new Stock (21, "NKE", 56.61, 1, 1, this); //Nike
        TheStocks[22]= new Stock (22, "PFE", 35.99, 1, 1, this); //Phizer
        TheStocks[23]= new Stock (23, "PG", 85.72, 1, 1, this);  //Procter & Gamble
        TheStocks[24]= new Stock (24, "TRV", 117.90, 1, 1, this);//Travelers Companies Inc
        TheStocks[25]= new Stock (25, "UTX", 103.38, 1, 1, this);//United Technologies 
        TheStocks[26]= new Stock (26, "UNH", 141.18, 1, 1, this);//UnitedHealth
        TheStocks[27]= new Stock (27, "VZ", 55.90, 1, 1, this);  //Verizon
        TheStocks[28]= new Stock (28, "V", 76.13, 1, 1, this);   //Visa
        TheStocks[29]= new Stock (29, "WMT", 73.56, 1, 1, this); //Walmart

        for (Stock stock : TheStocks){
            new Thread(stock).start();
        }
    }
    
    public void run(){
        /*        for (Stock k : Game.TheStocks){
            GLabel stock = new GLabel(k.toString(), 15, 35+(k.getIndex()*20));
            add(stock);
        }*/

        add(new JLabel("Stock Symbol: "), SOUTH);
        add(symbolEntered, SOUTH);
        add(new JLabel("Amount: "), SOUTH);
        add(quantityEntered, SOUTH);
        add(new JButton("Buy") ,SOUTH);
        add(new JButton("Sell"), SOUTH);
        addActionListeners();

        User user = new User(this);
        System.out.println(user.getMyHoldings());
        int x=0;
        
        while(true){
            pause(6000);
            distMarket= new NormalDistribution(0.1/230, 0.2/(Math.sqrt(230)));
        }
    }
    
    public NormalDistribution getDistMarket()
    {
        return distMarket;
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

        }
    }
}
