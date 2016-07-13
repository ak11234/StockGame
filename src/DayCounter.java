import acm.graphics.GLabel;
/**
 * Write a description of class DayCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DayCounter extends GLabel implements Runnable 
{
    public int Days;
    private Game myGame;
    public DayCounter(Game g)
    {
        super("", 0, 0);
        myGame = g;
        Days = 0;
    }

    public String toString(){
        return "Days so far: "+Days;
    }

    public void run(){
        {
            myGame.add(this);
            move(800, 30);
            setLabel(toString());
            while(true){
                pause(myGame.speed);
                Days++;
                setLabel(toString());
            }
        }
    }
}
