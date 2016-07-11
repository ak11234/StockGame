
/**
 * Write a description of class Holdings here.
 * 
 * @Josh 
 */
public class Holding
{
    private int myQuantity;
    private Stock myStock;
    
    //a holding is initialized with a stock and the initial buy quantity
    public Holding(int Q, Stock S)
    {
        myQuantity= Q;
        myStock= S;
    }
    
    public Holding changeQuantity(int x)
    {
       Holding update;
       update= new Holding(myQuantity+x, myStock);
       return update;
    }
    
    public Stock getMyStock()
    {
        return myStock;
    }
    
    public int getQuantity()
    {
        return myQuantity;
    }
}
