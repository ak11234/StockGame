/**
 * Created by Adam on 7/8/2016. Stock game
 */
public class Game {

    public static void main(String args){
        Update update = new Update(stocks);
        new Thread(update).start();
    }
    public static void init(){

    }
}
