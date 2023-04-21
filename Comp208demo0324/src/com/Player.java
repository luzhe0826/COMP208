package com;

import java.awt.*;

public class Player {

    Image img = Utils.MyFish_L;
    
    int x = 700;
    int y = 500;
    int width = 40;
    int height = 30;
    int speed = 18;
    int level = 1;



    void logic(){
        if (Utils.UP){
            y = y-speed;
        }
        if (Utils.DOWN){
            y = y+speed;
        }
        if (Utils.LEFT){
            x =x-speed;
            img = Utils.MyFish_L;
        }
        if (Utils.RIGHT){
            x = x+speed;
            img = Utils.MyFish_R;
        }
    }

    public void paintSelf(Graphics g){
        logic();
        if( width+Utils.count<=100)
            g.drawImage(img,x,y,width+Utils.count,height+Utils.count,null);
            else g.drawImage(img,x,y,100+Utils.count/20,90+Utils.count/20,null);
    }
    
    
    public Rectangle getRec(){
        if( width+Utils.count<=100)
            return new Rectangle(x,y,width+Utils.count,height+Utils.count);
            else 
            return new Rectangle(x,y,100+Utils.count/20,90+Utils.count/20);

    }
}
