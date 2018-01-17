/*
*   Created on 2018/01/17
*   Written by Sanyuan
*   Used to auto generator a specific texture by some input parameters
*
*/

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

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
        x = xSize - xSpace;
        y = ySize - ySpace - yDisplacement;
        setSize(xSize, ySize);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);
    }

    @Override
    public void paint(Graphics g){
        int[] suitableMaxSize = getSuitableSizeMaxRect();
        int[] importantPointsX = new int[]{xDisplacement, xDisplacement + x, xDisplacement + x, xDisplacement, xDisplacement + (int)(x/2)};
        int[] importantPointsY = new int[]{yDisplacement, yDisplacement, y + yDisplacement, y + yDisplacement, yDisplacement + (int)(y/2)};

        g.setColor(Color.red);
        g.drawRect(xDisplacement,yDisplacement,suitableMaxSize[0],suitableMaxSize[1]);

        for (int i = 0; i < 4; i ++){
            g.drawLine(importantPointsX[i],importantPointsY[i],importantPointsX[4],importantPointsY[4]);
        }






        //Logs
        System.out.println(suitableMaxSize.length);
        System.out.println(suitableMaxSize[0]);
        System.out.println(suitableMaxSize[1]);
    }

    private static int[] getSuitableSizeMaxRect(){
        int[] result = null;
        int yPlus = y * yFactor;
        if (x == yPlus){
            result = new int[]{x,y};
        }
        else if(x > yPlus){
            result = new int[]{yPlus,y};
        }
        else if(x < yPlus){
            result = new int[]{x,(int)(x/yFactor)};
        }
        return result;
    }

    public static void main(String[] args) {
        new Generator(1200 + xSpace,600 + ySpace + yDisplacement).setVisible(true);
    }

}
