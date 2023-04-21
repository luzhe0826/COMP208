package com;

import java.awt.*;

public class Background {
    void paintSelf(Graphics g,int fishLevel){
        g.drawImage(Utils.bgimg,0,0,null);
        switch (Main.state){
            case 0:
                Utils.drawWord(g,"Click to Start",Color.ORANGE,80,245,300);
                break;
            case 1:
                Utils.drawWord(g,"Points:"+Utils.count,Color.ORANGE,50,200,120);
                Utils.drawWord(g,"Level:"+Utils.level,Color.ORANGE,50,600,120);
                Utils.drawWord(g,"space to pause",Color.cyan,20,441,650);
                break;
            case 2:
                Utils.drawWord(g,"Points:"+Utils.count,Color.ORANGE,50,200,120);
                Utils.drawWord(g,"Level:"+Utils.level,Color.ORANGE,50,600,120);
                Utils.drawWord(g,"Fail...",Color.red,80,700,500);
                break;
            case 3:
                Utils.drawWord(g,"Points:"+Utils.count,Color.ORANGE,50,200,120);
                Utils.drawWord(g,"Level:"+Utils.level,Color.ORANGE,50,600,120);
                Utils.drawWord(g ,"Victory",Color.red,80,700,500);
                break;
            case 4:
                Utils.drawWord(g,"Points:"+Utils.count,Color.ORANGE,50,200,120);
                Utils.drawWord(g,"Level:"+Utils.level,Color.ORANGE,50,600,120);
                default:
        }
    }
}

