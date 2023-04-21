package com;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    static boolean UP =false;
    static boolean DOWN =false;
    static boolean LEFT =false;
    static boolean RIGHT =false;

    static int count = 0;
    static int level = 0;

    public static Image bgimg = Toolkit.getDefaultToolkit().createImage("images/bg.jpg");

    public static List<Enemy>EnemyList = new ArrayList<>();
    public static List<Enemy>RubbishList = new ArrayList<>();

    
    public static Image MyFish_L = Toolkit.getDefaultToolkit().createImage("images/myFish/myfish_left.png");
    public static Image MyFish_R = Toolkit.getDefaultToolkit().createImage("images/myFish/myfish_right.png");

    
    public static Image enemyl1_img = Toolkit.getDefaultToolkit().createImage("images/enemyFish/fish1_r.png");
    public static Image enemyr1_img = Toolkit.getDefaultToolkit().createImage("images/enemyFish/fish1_l.png");
    public static Image enemyl2_img = Toolkit.getDefaultToolkit().createImage("images/enemyFish/fish2_r.png");
    public static Image enemyr2_img = Toolkit.getDefaultToolkit().createImage("images/enemyFish/fish2_l.png");
    public static Image enemyl3_img = Toolkit.getDefaultToolkit().createImage("images/enemyFish/fish3_r.png");
    public static Image enemyr3_img = Toolkit.getDefaultToolkit().createImage("images/enemyFish/fish3_l.png");
    public static Image rubbish1_img = Toolkit.getDefaultToolkit().createImage("images/enemyFish/rubbish1.png");
    public static Image rubbish2_img = Toolkit.getDefaultToolkit().createImage("images/enemyFish/rubbish2.png");
    

    public static void drawWord(Graphics g,String str ,Color color,int size,int x, int y){
        g.setColor(color);
        g.setFont(new Font("Times",Font.BOLD,size));
        g.drawString(str, x, y);
    }

    
}
