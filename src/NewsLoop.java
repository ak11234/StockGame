import static acm.util.JTFTools.pause;

/**
 * Created by Adam Kalman on 7/13/2016. For Final Project
 */
public class NewsLoop implements Runnable {
    private News myNews;
    private NewsStory myNewStory;
    private Game myGame;

    public NewsLoop(News news, NewsStory generator, Game game){
        myNews=news;
        myGame=game;
        myNewStory=generator;
    }
    public void run(){
        while (myGame.getGameOn()){
            myNews.add(myNewStory.newNewsStory());
            pause(500);
        }
    }
}
