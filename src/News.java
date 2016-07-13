import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

import java.util.ArrayList;

/**
 * Created by Adam on 7/13/2016. For final project
 */
public class News {
    private ArrayList<GLabel> myLabels;
    private int myX, myY, myAmt;
    private Game myGame;
    private String[] position, company, effect; 

    public News(int xstart, int ystart, int amt, Game game) {
        myX = xstart;
        myY = ystart;
        myAmt = amt;
        myGame=game;
        myLabels = new ArrayList<GLabel>();
        for (int k=0; k<myAmt; k++){
            myLabels.add(new GLabel("", myX, myY+20*k));
            myGame.add(myLabels.get(k));
        }
        
        position = new String[10];
        company = new String[30];
        effect = new String[10];

        position[0]="Communications Department";
        position[1]="CEO";
        position[2]="CFO";
        position[3]="HR Department";
        position[4]="Research Department";
        position[5]="Sales Manager";
        position[6]="Chief Sales Advisor";
        position[7]="President";
        position[8]="Board of Directors";
        position[9]="Vice President";

        company[0]="Apple";
        company[1]="American Express";
        company[2]="Boeing";
        company[3]="Caterpillar";
        company[4]="Merck";
        company[5]="Microsoft";
        company[6]="Nike";
        company[7]="Pfizer";
        company[8]="Cisco ";
        company[9]="Chevron";
        company[10]="Coca-Cola";
        company[12]="3M Company ";
        company[13]="IBM";
        company[14]="Intel ";
        company[15]="McDonald's";
        company[16]="Johnson & Johnson";
        company[17]="JPMorgan Chase";
        company[18]="Disney";
        company[19]="Wal-Mart";
        company[20]="Travelers";
        company[21]="UnitedHealth";
        company[22]="ExxonMobil";
        company[23]="Verizon";
        company[24]="Visa";
        company[25]="United Technologies";
        company[26]="General Electric";
        company[27]="Home Depot";
        company[28]="Goldman Sachs";
        company[29]="Procter & Gamble";
    }

    public void add(String text){
        for (int k = myAmt-1 ; k>0 ; k--){
            GLabel temp1 =myLabels.get(k);
            GLabel temp2 = myLabels.get(k-1);
            temp1.setLabel(temp2.getLabel());
        }
        myLabels.get(0).setLabel(text);
       

        
    }
}
