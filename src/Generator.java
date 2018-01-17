/*
*   Created on 2018/01/17
*   Written by Sanyuan
*   Used to auto generator a specific texture by some input parameters
*
*/

import java.awt.*;
import javax.swing.*;

public class Generator extends JFrame{

    private static int x;
    private static int y;
    private static int xDisplacement = 5;
    private static int yDisplacement = 30;
    private static int xSpace = 10;
    private static int ySpace = 10;
    private static String MainTitle = "DrAW";
    private static int yFactor = 2;

    public Generator(int xSize, int ySize){
        setTitle(MainTitle);
        setSize(xSize, ySize);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);
        x = xSize - xSpace;
        y = ySize - ySpace;
    }

    @Override
    public void paint(Graphics g){
        int[] suitableMaxSize = new int[]{};
        suitableMaxSize = getSuitableSizeMaxRect();
        g.setColor(Color.red);




        g.drawRect(xDisplacement,yDisplacement,suitableMaxSize[0],suitableMaxSize[1]);

        //Logs
        System.out.println(suitableMaxSize.length);
        System.out.println(suitableMaxSize[0]);
        System.out.println(suitableMaxSize[1]);
    }

    private static int[] getSuitableSizeMaxRect(){
        int[] result = null;
        if (x == y * yFactor){
            result = new int[]{x,y};
        }
        else if(x > y * yFactor){
            result = new int[]{yFactor*y,y};
        }
        else if(x < yFactor * 2){
            result = new int[]{x,(int)(x/yFactor)};
        }
        return result;
    }


    public static void main(String[] args) {
        new Generator(1200 + xSpace,600 + ySpace + yDisplacement).setVisible(true);
    }

}
