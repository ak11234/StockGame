import acm.graphics.GLabel;

import java.util.ArrayList;

import static acm.util.JTFTools.pause;

/**
 * Created by Adam on 7/8/2016. This class updates the Array list of stock labels. 
 */
public class Update implements Runnable {
    private Game myGame;
    public Update(Game game){
        myGame=game;
    }
    public void init(){
        System.out.println("hello");
    }
    
    public void run(){
        myGame.stockLabels = new ArrayList<GLabel>();
        for (int k = 0; k<Game.TheStocks.length; k++){
            myGame.stockLabels.add(k, (new GLabel(Game.TheStocks[k].toString(), 15, 35+(Game.TheStocks[k].getIndex()*20))));
            myGame.add(myGame.stockLabels.get(k));
        }
        int temp=5;
        while (true){
            temp++;
            for (Stock k : Game.TheStocks){
               myGame.stockLabels.set(k.getIndex(), (new GLabel(k.toString(), 15, 35+(k.getIndex()*20))));
            }

            pause(1000);
            System.out.println("loop");
        }
    }
}
