package com;

import java.awt.*;

public class Enemy {
    Image img;
    int x,y,width,height;
    int speed;
    //方向
    int dir = 1;
    int type;
    int count;
    //绘制自身方法
    public void paintSelf(Graphics g){
        g.drawImage(img,x,y,width,height,null);
    }
    //碰撞检测
    public Rectangle getRec(){
        return new Rectangle(x,y,width,height);
    }
}

class Enemy_Ltype1 extends Enemy{
    Enemy_Ltype1(){
        this.x = -15;
        this.y = (int)(Math.random()*700+100);
        this.width = 40;
        this.height = 24;
        this.speed = 10;
        this.count = 1;
        this.type = 1;
        this.img = Utils.enemyl1_img;
    }
}

class Enemy_Rtype1 extends Enemy_Ltype1{
    Enemy_Rtype1(){
        this.x = 960;
        dir = -1;
        this.img =Utils.enemyr1_img;
    }
}

class Enemy_Ltype2 extends Enemy{
    Enemy_Ltype2(){
        this.x = -70;
        this.y = (int)(Math.random()*700+100);
        this.width = 70;
        this.height = 70;
        this.speed = 9;
        this.count = 4;
        this.type = 2;
        this.img = Utils.enemyl2_img;
    }
}
class Enemy_Rtype2 extends Enemy_Ltype2{
    Enemy_Rtype2(){
        this.x = 960;
        dir = -1;
        this.img =Utils.enemyr2_img;
    }
}
class Enemy_Ltype3 extends Enemy{
    Enemy_Ltype3(){
        this.x = -150;
        this.y = (int)(Math.random()*700+100);
        this.width = 150;
        this.height = 75;
        this.speed = 15;
        this.count = 11;
        this.type = 3;
        this.img = Utils.enemyl3_img;
    }
    @Override
    public Rectangle getRec(){
        return  new Rectangle(x+40,y+30,width-80,height-60);
    }
}
class Enemy_Rtype3 extends Enemy_Ltype3{
    Enemy_Rtype3(){
        this.x = 960;
        dir = -1;
        this.img =Utils.enemyr3_img;
    }
}

class Enemy_Rubbish1 extends Enemy{
    Enemy_Rubbish1(){
        this.x = (int)(Math.random()*700+150);
        this.y = -1000;
        this.width = 100;
        this.height = 125;
        this.speed = 15;
        this.count = 0;
        this.type = 10;
        this.img = Utils.rubbish1_img;
    }
}
class Enemy_Rubbish2 extends Enemy{
    Enemy_Rubbish2(){
        this.x = (int)(Math.random()*700+100);
        this.y = -1000;
        this.width = 60;
        this.height = 100;
        this.speed = 20;
        this.count = 0;
        this.type = 10;
        this.img = Utils.rubbish2_img;
    }
}

