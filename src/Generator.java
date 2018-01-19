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
        int recoedx1;
        int recoedy1;


        g.setColor(Color.red);
        g.drawRect(xDisplacement,yDisplacement,suitableMaxSize[0],suitableMaxSize[1]);

        for (int i = 0; i < 4; i ++){
            g.drawLine(importantPointsX[i],importantPointsY[i],importantPointsX[4],importantPointsY[4]);
        }

        g.drawLine(importantPointsX[0],importantPointsY[0],50,getY(importantPointsX[4],importantPointsY[4],importantPointsX[3],importantPointsY[3],50));
        recoedx1 = 50;
        recoedy1 = getY(importantPointsX[4],importantPointsY[4],importantPointsX[3],importantPointsY[3],recoedx1);

        g.drawLine(recoedx1,recoedy1,getX(importantPointsX[0],importantPointsY[0],importantPointsX[4],importantPointsY[4],280),280);




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

    public int getY(int x1, int y1, int x2, int y2, int x){
        int a = x-x1;
        int b = y2-y1;
        int c = x2- x1;

        System.out.println("x - x1: " + a  + ", y2 - y1: " + b + ", x2 - x1: " + c + ", y1: " + y1 + ", Y: " + (a*b/c + y1));
        return (a*b/c + y1);
    }

    public int getX(int x1, int y1, int x2, int y2, int y){
        int a = y - y1;
        int b = x2 - x1;
        int c = y2 - y1;

        System.out.println("y - y1: " + a  + ", x2 - x1: " + b + ", y2 - y1: " + c + ", x1: " + y1 + ", X: " + (a*b/c + x1));
        return (a*b/c + x1);
    }

    public int getDistanceFromTwoPoints(int x1, int y1, int x2, int y2){
        int a = (x1 - x2) * (x1 - x2);
        int b = (y1 - y2) * (y1 - y2);

        System.out.println("x1 - x2 power of 2: " + a + ", y1 - y2 power of 2: " + b + ", result: " + (int)Math.sqrt(a+b));
        return (int)Math.sqrt(a+b);
    }

    public static void main(String[] args) {
        new Generator(1200 + xSpace,600 + ySpace + yDisplacement).setVisible(true);
    }

}
