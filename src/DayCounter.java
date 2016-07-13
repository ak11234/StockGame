import acm.graphics.GLabel;
/**
 * This class counts the number of trading days (230/year) that have passed so far. 
 * 
 * @Josh
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
        if(myGame.getGameOn()){
            return "Days so far: "+Days;
        }
        else{
            return "GAME OVER!";
        }
    }

    public void run(){
        {
            myGame.add(this);
            move(800, 30);
            setLabel(toString());
            while(myGame.getGameOn()){
                pause(myGame.speed);
                Days++;
                setLabel(toString());
            }
        }
    }
}
