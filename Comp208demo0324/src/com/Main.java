package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Main extends JFrame{

    static int state = 0;
    int width = 1000;
    int height = 750;

    double random;
    int temp = 0;
    Background bg = new Background();

    Enemy enemy;

    Enemy rubbish;

    boolean isboss = false;

    Image offImage;

    Player myFish = new Player();

    public void launch(){
        this.setVisible(true);
        this.setSize(width,height);
        this.setLocationRelativeTo(null);
        this.setTitle("Feeding Frenzy");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton()==1&&state==0){
                    state=1;
                    repaint();
                }
                if (e.getButton()==1&&(state==2||state==3)){
                    
                    state=1;
                }
            }
        });

        this.addKeyListener(new KeyAdapter() {
            @Override//按压
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                //WASD
                if (e.getKeyCode()==87){
                    Utils.UP = true;
                }
                if (e.getKeyCode()==83){
                    Utils.DOWN = true;
                }
                if (e.getKeyCode()==65){
                    Utils.LEFT = true;
                }
                if (e.getKeyCode()==68){
                    Utils.RIGHT = true;
                }
                if (e.getKeyCode()==32){
                    switch (state){
                        case 1:
                            state = 4;
                            Utils.drawWord(getGraphics(),"Game Pause",Color.red,50,370,350);
                            break;
                        case 4:
                            state = 1;
                            break;
                    }
                }
            }

            @Override//抬起
            public void keyReleased(KeyEvent e){
                super.keyReleased(e);
                if (e.getKeyCode()==87){
                    Utils.UP = false;
                }
                if (e.getKeyCode()==83){
                    Utils.DOWN = false;
                }
                if (e.getKeyCode()==65){
                    Utils.LEFT = false;
                }
                if (e.getKeyCode()==68){
                    Utils.RIGHT = false;
                }
            }
        });

        while (true){
            repaint();
            temp++;
            try {
                Thread.sleep(40);
            }   catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g){

        offImage = createImage(width,height);
        Graphics gImage = offImage.getGraphics();
        bg.paintSelf(gImage , myFish.level);

        switch (state){
            case 0:
                //gImage.setColor(Color.cyan);
                //gImage.setFont(new Font("temps",Font.BOLD,80));
                //gImage.drawString("Start",420,300);
                break;
            case 1:
                Core();
                bg.paintSelf(gImage,myFish.level);
                myFish.paintSelf(gImage);
                //gImage.setColor(Color.PINK);
                //gImage.setFont(new Font("temps",Font.BOLD,50));
                //gImage.drawString("Points"+Utils.count,100,80);
                if (isboss){
                    for (Enemy Rubbish:Utils.RubbishList)
                    {
                        Rubbish.y = Rubbish.y + Rubbish.dir * Rubbish.speed;
                        Rubbish.paintSelf(gImage);
                    }
                }
                for (Enemy enemy:Utils.EnemyList){
                    enemy.paintSelf(gImage);
                }
                break;
            case 2:
                if (isboss){
                    for (Enemy Rubbish:Utils.RubbishList){
                        Rubbish.paintSelf(gImage);
                    }
                    break;
                }
                for (Enemy enemy:Utils.EnemyList){
                    enemy.paintSelf(gImage);
                }
                break;
            case 3:
                myFish.paintSelf(gImage);
                //gImage.setColor(Color.RED);
                //gImage.setFont(new Font("temps",Font.BOLD,50));
                //gImage.drawString("Points"+Utils.count,100,80);
                //gImage.drawString("You Win!",420,300);
                break;
            case 4:
                return;
                default:
        }
        g.drawImage(offImage,0,0,null);
    }

    void Core(){
        //关卡等级
        if (Utils.count<5){
            Utils.level = 0;
            myFish.level = 1;
        }else if (Utils.count<=15){
            Utils.level = 1;
        }else if (Utils.count<=50){
            Utils.level = 2;
            myFish.level = 2;
        }else if (Utils.count<=150){
            Utils.level = 3;
            myFish.level = 3;
            //更强的敌人鱼


        }else if (Utils.count<=200){
            Utils.level = 4;
            //四级为奖励关，鱼潮来临
            myFish.level = 3;
        }else if (Utils.count<=400){
            Utils.level = 5;
            //五级为垃圾倾倒状态，最终关卡
        }
        else if (Utils.count>400){
            state = 3;
            //400分胜利
        }
        
        random = Math.random(); //控制移动方向

        switch (Utils.level) {
            case 5:
                if (temp%25==0){
                    if (random>0.5){
                        rubbish = new Enemy_Rubbish1();
                        isboss = true;
                    }else {
                        rubbish = new Enemy_Rubbish2();
                        isboss = true;
                    }
                    Utils.RubbishList.add(rubbish);
                }
            case 4:
            case 3:
                if (temp%21==0){
                    if (random>0.5){
                        enemy = new Enemy_Ltype3();
                    }else {
                        enemy = new Enemy_Rtype3();
                    }
                    Utils.EnemyList.add(enemy);
                }
            case 2:
                if (temp%29==0){
                    if (random>0.5){
                        enemy = new Enemy_Ltype3();
                    }else {
                        enemy = new Enemy_Rtype3();
                    }
                    Utils.EnemyList.add(enemy);
                }
            case 1:
                if (temp%15==0){
                    if (random>0.5){
                        enemy = new Enemy_Ltype2();
                    }else {
                        enemy = new Enemy_Rtype2();
                    }
                    Utils.EnemyList.add(enemy);
                }
            case 0:
            if (temp % 5 == 0) {
                if (random > 0.5) {
                    enemy = new Enemy_Ltype1();
                } else {
                    enemy = new Enemy_Rtype1();
                }
                Utils.EnemyList.add(enemy);
            }
            break;
            default:
        }
        

        for (Enemy Enemy:Utils.EnemyList) {
            Enemy.x = Enemy.x + Enemy.dir * Enemy.speed;          
            if (isboss){
                for (Enemy Rubbish:Utils.RubbishList) {
                    if (Rubbish.getRec().intersects(Enemy.getRec())){
                        Enemy.x = -200;
                        Enemy.y = -200;
                    }
                    if (Rubbish.getRec().intersects(myFish.getRec())){
                        state = 2;
                    }
                }
            }
                //我方鱼与敌方鱼碰撞检测
                if (myFish.getRec().intersects(Enemy.getRec())) {
                    if (myFish.level >= Enemy.type) {

                        Enemy.x = -300;
                        Enemy.y = -300;
                        Utils.count = Utils.count + Enemy.count;
                    } else {
                        state = 2;
                    }
                }

        }
    }
    //重新开始
    void reStart(){
        Utils.EnemyList.clear();
        myFish.level = 1;
        Utils.count = 0;
        myFish.x = 700;
        myFish.y = 500;
        myFish.width = 50;
        myFish.height = 50;
    }

    public static void main(String[] args) throws Exception {
        Main gameMain = new Main();
        gameMain.launch();
    }
}
