import acm.graphics.*;
import acm.program.GraphicsProgram;
import org.apache.commons.math3.distribution.NormalDistribution;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

import static javax.swing.JOptionPane.YES_OPTION;

/**
 * Created by Adam on 7/8/2016. 
 * This is the main method being run, which manages all other classes.
 */
public class Game extends GraphicsProgram implements Runnable{ 
    public static Stock[] TheStocks;
    JTextField symbolEntered = new JTextField(9);
    JTextField quantityEntered = new JTextField(9);
    User user;
    ArrayList<GLabel> stockLabels;
    NormalDistribution distMarket;
    public int speed=5000;
    private JLabel speedLabel;
    static private int[] code =
            {38, 38, 40, 40, 37, 39, 37, 39, 66, 65};
    static private ArrayList<Integer> codeIn;
    private int currentIndex;
    private boolean colorChange;
    private boolean gameOn=true;
    News theNews;

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
        codeIn=new ArrayList<Integer>();
        TheStocks = new Stock[30];
        currentIndex=0;
        colorChange=false;
        DayCounter daysSoFar;
        daysSoFar = new DayCounter(this);
        new Thread(daysSoFar).start();
        
        TheStocks[0] = new Stock ("3M", "MMM", 176.71, 1, 1, this, 1); //3M
        TheStocks[1] = new Stock ("American Express", "AXP", 61.35, 2, 2, this, 2);  //American Express
        TheStocks[2] = new Stock ("Apple", "AAPL", 96.64, 1.2, 1.2, this, 3); //Apple
        TheStocks[3] = new Stock ("Boeing", "BA", 129.93, 1.6, 1.6, this, 4);  //Boeing
        TheStocks[4] = new Stock ("Caterpillar", "CAT", 77.06, 2, 2, this, 5);  //Caterpillar
        TheStocks[5] = new Stock ("Chevron", "CVX", 104.45, 3, 3, this, 6); //Chevron
        TheStocks[6] = new Stock ("Cisco", "CSCO", 29.3, 1.9, 1.9, this, 7);  //Cisco
        TheStocks[7] = new Stock ("Coca-Cola", "KO", 45.33, .9, .9, this, 8);   //Coca-Cola
        TheStocks[8] = new Stock ("Disney", "DIS", 99.52, 2.3, 2.3, this, 9);  //Disney
        TheStocks[9] = new Stock ("du Pont de Nemours and Co", "DD", 63.52, 1, 1, this, 10);   //E I du Pont de Nemours and Co
        TheStocks[10]= new Stock ("Exxon Mobil", "XOM", 93.47, 2, 2, this, 11); //Exxon Mobil
        TheStocks[11]= new Stock ("General Electric", "GE", 32.19, 2, 2, this, 12);  //General Electric
        TheStocks[12]= new Stock ("Goldman Sachs", "GS", 150.66, .5, .5, this, 13); //Goldman Sachs
        TheStocks[13]= new Stock ("Home Depot", "HD", 133.76, .6, .6, this, 14); //Home Depot
        TheStocks[14]= new Stock ("IBM", "IBM", 154.22, 2.1, 2.1, this, 15);//IBM
        TheStocks[15]= new Stock ("Intel", "INTC", 33.93, .8, .8, this, 16);//Intel
        TheStocks[16]= new Stock ("Johnson & Johnson", "JNJ", 122.55, 2, 2, this, 17);//Johnson & Johnson
        TheStocks[17]= new Stock ("JPMorgan Chase", "JPM", 61.85, 2, 2, this, 18); //JPMorgan Chase
        TheStocks[18]= new Stock ("McDonald's", "MCD", 121.40, 1.3, 1.3, this, 19);//McDonald's
        TheStocks[19]= new Stock ("Merck", "MRK", 59.23, 3, 3, this, 20); //Merck
        TheStocks[20]= new Stock ("Microsoft", "MSFT", 52.23, 1.6, 1.6, this, 21);//Microsoft
        TheStocks[21]= new Stock ("Nike", "NKE", 56.61, 2.3, 2.3, this, 22); //Nike
        TheStocks[22]= new Stock ("Phizer", "PFE", 35.99, 2.1, 2.1, this, 23); //Phizer
        TheStocks[23]= new Stock ("Procter & Gamble", "PG", 85.72, .6, .6, this, 24);  //Procter & Gamble
        TheStocks[24]= new Stock ("Travelers Companies Inc", "TRV", 117.90, 1, 1, this, 25);//Travelers Companies Inc
        TheStocks[25]= new Stock ("United Technologies", "UTX", 103.38, 3, 3, this, 26);//United Technologies
        TheStocks[26]= new Stock ("UnitedHealth", "UNH", 141.18, 3, 3, this, 27);//UnitedHealth
        TheStocks[27]= new Stock ("Verizon", "VZ", 55.90, 3, 3, this, 28);  //Verizon
        TheStocks[28]= new Stock ("Visa", "V", 76.13, 3, 3, this, 29);   //Visa
        TheStocks[29]= new Stock ("Walmart", "WMT", 73.56, 3, 3, this, 30); //Walmart
        setBackground(new Color(56, 179, 244));
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
        add(new JButton("Buy Dow x10"), SOUTH);
        add(new JButton("Buy Dow x100"), SOUTH);
        add(new JButton("Sell Dow x10"), SOUTH);

        add(new JButton("U.S. Postal Service"), NORTH);
        add(new JButton("Dial-up Internet"), NORTH);
        add(new JButton("BubbleSort"), NORTH);
        add(new JButton("Light Speed"), NORTH);
        add(new JButton("Ridiculous Speed"), NORTH);
        add(new JButton("Ludicrous Speed"), NORTH);

        add(new JLabel("  Current Speed: "), NORTH);
        speedLabel = new JLabel("Light Speed");
        add(speedLabel, NORTH);

        theNews = new News(370, 150, 20, this);
        NewsStory newsStory = new NewsStory();
        NewsLoop newsLoop = new NewsLoop(theNews, newsStory, this);
        new Thread(newsLoop).start();

        addActionListeners();
        addKeyListeners();

        User user = new User(this);
        System.out.println(user.getMyHoldings());
        int x=0;
        distMarket= new NormalDistribution(0.11/230, 0.2/(Math.sqrt(230)));

        while (gameOn) {
            while (colorChange){
                setBackground(new Color( (int) (Math.random()*255+1), (int) (Math.random()*255+1), (int) (Math.random()*255+1)));
                pause(500);
            }
            pause(500);
        }

    }

    public NormalDistribution getDistMarket()
    {
        return distMarket;
    }

    public boolean getGameOn(){
        return gameOn;
    }
    
    public void setGameOver(){
        gameOn=false;
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
                int n = JOptionPane.showConfirmDialog(
                        null,
                        "Place Order For: \n" + qualifiedQuantity + " of: " + symbolEntered.getText() + "?"
                        + "\n This will cost:  $" + new DecimalFormat("#.##").format(getStockMatch(symbolEntered.getText()).getPrice()*qualifiedQuantity)
                        +" \n and will bring you cash to: $" + new DecimalFormat("#.##").format(((int)(user.getMyCash())-getStockMatch(symbolEntered.getText()).getPrice()*qualifiedQuantity)),
                        "Order Confirmation",
                        JOptionPane.YES_NO_OPTION);
                if (n==YES_OPTION){
                    user.updateHoldings(symbolEntered.getText(), qualifiedQuantity);
                }
            } else {
                System.out.println("Invalid Entry");
            }

        }
        if (key.equals("U.S. Postal Service")){
            speed=20000;
            speedLabel.setText(key);
        }
        if (key.equals("Dial-up Internet")){
            speed=10000;
            speedLabel.setText(key);
        }
        if (key.equals("BubbleSort")){
            speed=8000;
            speedLabel.setText(key);
        }
        if (key.equals("Light Speed")){
            speed=5000;
            speedLabel.setText(key);
        }
        if (key.equals("Ridiculous Speed")){
            speed=2000;
            speedLabel.setText(key);
        }
        if (key.equals("Ludicrous Speed")){
            speed=500;
            speedLabel.setText(key);
        }
        if (key.equals("Buy Dow x10")){
            int n = JOptionPane.showConfirmDialog(
                    null,
                    "Place order to BUY 10 of all securities in the Dow Jones Index?",
                    "Order Confirmation",
                    JOptionPane.YES_NO_OPTION);
            if (n==YES_OPTION){
                user.buyDow();
            }
        }
        if (key.equals("Sell Dow x10")){
            int n = JOptionPane.showConfirmDialog(
                    null,
                    "Place order to SELL 10 of all securities in the Dow Jones Index?",
                    "Order Confirmation",
                    JOptionPane.YES_NO_OPTION);
            if (n==YES_OPTION){
                user.sellDow();
            }
        }
        if (key.equals("Buy Dow x100")){
            int n = JOptionPane.showConfirmDialog(
                    null,
                    "Place order to BUY 100 of all securities in the Dow Jones Index?",
                    "Order Confirmation",
                    JOptionPane.YES_NO_OPTION);
            if (n==YES_OPTION) {
                for (int j = 0; j < 10; j++) {
                    user.buyDow();
                }
            }
        }
    }

    public void keyPressed(KeyEvent e){
        System.out.println(e);
        System.out.println(e.getKeyCode());
        if (e.getKeyCode()==10) {
            boolean start=true;
            for (int key : code){
                if (!codeIn.contains(key)){
                    start=false;
                }
            }
            if (start) {
                colorChange=true;
                new EasyVisuals().quickStart();

            }
        } else {
            codeIn.add(e.getKeyCode());
        }
        if (e.getKeyCode()==27){
            colorChange=false;

        }

    }
    public Stock getStockMatch(String symbolMatch){
        for (Stock s : TheStocks){
            if (s.getSymbol().equals(symbolMatch)){
                return s;
            }
        }
        return null;
    }
   }