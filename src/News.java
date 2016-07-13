import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.util.ArrayList;

/**
 * Created by Adam on 7/13/2016. For final project
 */
public class News {
    private ArrayList<GLabel> myLabels;
    private int myX, myY, myAmt;
    private Game myGame;
    private GRect box;

    public News(int xstart, int ystart, int amt, Game game) {
        myX = xstart;
        myY = ystart;
        myAmt = amt;
        myGame=game;
        myLabels = new ArrayList<GLabel>();
        box=new GRect(myX-10,myY-15, 560, 400);
        myGame.add(box);
        for (int k=0; k<myAmt; k++){
            myLabels.add(new GLabel("", myX, myY+20*k));
            myGame.add(myLabels.get(k));
        }


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
