import acm.graphics.GLabel;

import java.util.ArrayList;

/**
 * Created by Adam on 7/13/2016. For final project
 */
public class News {
    private ArrayList<GLabel> myLabels;
    private int myX, myY, myAmt;

    public News(int xstart, int ystart, int amt) {
        myX = xstart;
        myY = ystart;
        myAmt = amt;
        myLabels = new ArrayList<GLabel>();

    }
}
