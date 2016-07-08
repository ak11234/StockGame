/**
 * Created by Adam on 7/8/2016. Graphics
 */
import acm.program.Program;

import javax.swing.*;
import java.util.ArrayList;

public class Window extends Program {
    private String rawStockChart;
    private JLabel stockChart;


    public void init(){
        stockChart = new JLabel("");
        rawStockChart="";
        for(Stock k : Game.TheStocks){
            rawStockChart+=k.toString();
        }
        stockChart.setText(rawStockChart);
        add(stockChart);
    }
    public void run(){

    }
}
