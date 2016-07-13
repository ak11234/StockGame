
/**
 * Write a description of class NewsStory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewsStory
{
    
     private String[] position, company, effect;

    /**
     * Constructor for objects of class NewsStory
     */
    public NewsStory()
    {
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
        company[16]="J&J";
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

        effect[0]="committed armed robbery.";
        effect[1]="committed first degree murder.";
        effect[2]="been accused of the kidnap of Santa Claus.";
        effect[3]="released a new hit single.";
        effect[4]="been stealing recources in Settlers of Catan.";
        effect[5]="downloaded free RAM from 4Chan.";
        effect[6]="joined the church of Scientology.";
        effect[7]="begun research into cookie production.";
        effect[8]="died in a tragic golfing accident.";
        effect[9]="gone missing in Kazakhstan.";
    }

    public String newNewsStory()
    {
        return "The "+position[(int)(Math.random()*10)]+" of "+company[(int)(Math.random()*30)]+
               " has "+effect[(int)(Math.random()*10)];
    }
}
