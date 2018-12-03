package com.example.starkey.stillytowerdef;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.SystemClock;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.math.*;
import static java.lang.Math.abs;

public class SpawnManager {
    //ArrayAdapter ad ~~~~~~~~~~~~~~~~~~~~~do this look at to do
    public ArrayList<Zombie> zombies;
    private TextView tv;
    private ArrayAdapter<Zombie> adapZomb;
    private Zombie zombie;
    private ArrayList<Brute> brutes;
    private Brute brute;
    private ArrayList<grunt> grunts;
    private grunt grunt;
    public ArrayList<wall> walls;
    private grunt wall;
    public ArrayList<WayPoint> wps;
    public ArrayAdapter<WayPoint> wpa;
    public WayPoint wp;
    private long startTime;
    public int enemyCounter;
    public ArrayList<Tower> towers;
    public boolean levelComplete;
    int levelCounter;
    int zombieNum;
    int bruteNum;
    int gruntNum;
    public boolean lostgame;
    private final long PERIOD = 1000L;
    int numberSpawned;
    public boolean spawnfinished;
    public int max = Constants.SCREEN_WIDTH-10;
    public int i1;
    public Random r;


    //will have parameters of level and maybe other things later
    public SpawnManager(int zombieNum, int bruteNum, int gruntNum)
    {

        startTime = System.currentTimeMillis();
        zombies = new ArrayList<>();
        brutes = new ArrayList<>();
        grunts = new ArrayList<>();
        walls = new ArrayList<>();
        wps = new ArrayList<>();
        towers = new ArrayList<>();
        spawnwalls(6);
        //spawnZombies(zombieNum);
        //spawnBrutes(bruteNum);
        //spawnGrunts(gruntNum);
        spawnTower();
        levelComplete = false;
        levelCounter++;
        this.zombieNum = zombieNum;
        this.bruteNum = bruteNum;
        this.gruntNum = gruntNum;
        this.enemyCounter = zombieNum+bruteNum+gruntNum-1;
        lostgame = false;
        spawnfinished = false;
        //int max = Constants.SCREEN_WIDTH -10;
        this.r = new Random();
        this.i1 = r.nextInt(max -1)+1;

        //enemyCounter = zombieNum + bruteNum + gruntNum;
    }
    public WayPoint findWayPoint(int startLocation)
    {
        Iterator<WayPoint> wpi = wps.iterator();
        WayPoint closestWP = wpi.next();
        //System.out.println(closestWP.getWayPointY());
        WayPoint tempWP;
        //int temp = 20000;
        int holder;
        tempWP = closestWP;
        int temp =  tempWP.getWayPointX();
        System.out.println("xWP: " + temp+ " StartL: " +startLocation);
        int helper = abs(temp-startLocation);
        holder = helper;
        while(wpi.hasNext())
        {
            tempWP = wpi.next();
            temp = tempWP.getWayPointX();
            helper = abs(temp-startLocation);
            System.out.println("start: " +startLocation + "helper ="+helper + " x waypoint =" + temp + " Holder = " + holder);
            if(helper<=holder)
            {
                // System.out.println("waypoint being attached = " +temp);
                closestWP = tempWP;
                holder = helper;
            }
        }
        return closestWP;
    }
    public void onTick(int temp)
    {
        long thisTime = System.currentTimeMillis();
        Random rr = new Random();
       // int test = rr.nextInt(3-1)+1;
        int test =1;
        int i1 = temp;
        if((thisTime-startTime) >= PERIOD)
        {
            startTime = thisTime;
            if(numberSpawned < enemyCounter)
            {
                if(test ==1);
                {
                    spawnZombies(i1);
                    numberSpawned++;
                }
            }
            else
            {
                spawnfinished=true;
            }
        }
    }
    //params will be the number of things to be spawned later
    public void spawnZombies(int zombieNum)
    {
        //Thread.sleep(mili);
       // Random r = new Random();
        Zombie tempZombie;

        int i1 = zombieNum;
       // for(int i=0;i<zombieNum;i++)
        //{
           // i1 = r.nextInt(max -1)+1;
            //~~~~~~~~~~~~~~~~~~~~ THIS IS A SINGLE EVENT FOR 1 ZOMBIE WE WILL DO THIS IN A LOOP LATER ~~~~~~~~~~~~~~~~
            WayPoint somethingStupid; //= new WayPoint(500, 1350);
            tempZombie = new Zombie(Color.GREEN, i1, 20, i1+ 100, 120);
            somethingStupid =  findWayPoint(i1+50);
            tempZombie.setWayPointTarget(somethingStupid);
            zombies.add(tempZombie);

        //}
    }
    public void newLevel(int zombieNum, int bruteNum, int gruntNum)
    {
        spawnwalls(6);
        spawnZombies(zombieNum);
        spawnBrutes(bruteNum);
        spawnGrunts(gruntNum);
        spawnTower();
        levelComplete = false;
        levelCounter++;
        this.zombieNum = zombieNum;
        this.bruteNum = bruteNum;
        this.gruntNum = gruntNum;
        this.enemyCounter = zombieNum+bruteNum+gruntNum-1;
        numberSpawned = 0;
        spawnfinished = false;
    }

    public void update()
    {
        if(levelComplete)
        {
            System.out.println("level complete");
            System.out.println("Starting new level");
            System.out.println("Starting level: " + levelCounter);
            newLevel(zombieNum*2, bruteNum*2,gruntNum*2);
        }
        if(!spawnfinished)
        {
            this.i1 = r.nextInt(max -1)+1;
            onTick(i1);
        }
        if(!lostgame)
        {
            for(Zombie zomb : zombies)
            {
                if(zomb.getlivingStatus()) {
                    zomb.zombieMove();
                }
                if(!zomb.getlivingStatus())
                {
                    zombies.remove(zomb);
                    enemyCounter--;
                    numberSpawned--;
                    System.out.println(enemyCounter);
                }
                if(zomb.getCurrentPointY()>=Constants.SCREEN_HEIGHT)
                {
                    lostgame=true;
                    System.out.println("Lost game");
                }
            }
            for(Brute bru : brutes)
            {
                // if !zombie.istouching()

                bru.bruteMove();
            }

            for(grunt gru : grunts)
            {
                // if !zombie.istouching()

                gru.gruntMove();
            }
            for(wall w: walls)
            {
                w.wallMove();
            }
            for(Tower t: towers)
            {
                t.towerMove();
            }
            if(enemyCounter == 0)
            {
                levelComplete = true;
            }
        }
    }
    public void draw(Canvas canvas)
    {
        for(Zombie zomb: zombies)
        {
            zomb.draw(canvas);
        }
        for(Brute bru: brutes)
        {
            bru.draw(canvas);
        }
        for(grunt gru: grunts)
        {
            gru.draw(canvas);
        }
        for(wall w1: walls)
        {
            w1.draw(canvas);
        }
        for(Tower t: towers)
        {
            t.draw(canvas);
        }
    }
    public void spawnBrutes(int bruteNum) {
        //Thread.sleep(mili);
        Random r = new Random();
        int max = Constants.SCREEN_WIDTH - 10;
        int i1 = r.nextInt(max - 1) + 1;
        for (int i = 0; i < bruteNum; i++) {
            i1 = r.nextInt(max - 1) + 1;

            //System.out.println("Random value: " + i1 + " Const SW: " + Constants.SCREEN_WIDTH + " xStart: " + xStart);
            //System.out.print(xStart);
            brutes.add(new Brute(Color.RED, i1, 20, i1+ 100, 120));
            enemyCounter++;

        }
    }

    public void spawnGrunts(int gruntNum) {
        //Thread.sleep(mili);
        Random r = new Random();
        int max = Constants.SCREEN_WIDTH - 10;
        int i1 = r.nextInt(max - 1) + 1;
        for (int i = 0; i < gruntNum; i++) {
            i1 = r.nextInt(max - 1) + 1;

            //System.out.println("Random value: " + i1 + " Const SW: " + Constants.SCREEN_WIDTH + " xStart: " + xStart);
            //System.out.print(xStart);
            grunts.add(new grunt(Color.BLUE,i1, 20, i1+ 100, 120));
            enemyCounter++;
        }
    }
    public void spawnwalls(int wallNum) {
        Random r = new Random();
        int leftSide = 0;
        double bottom = Constants.SCREEN_HEIGHT - (Constants.SCREEN_HEIGHT*.25);
        double location = Constants.SCREEN_HEIGHT*.07;
        System.out.println("Screen width: "+Constants.SCREEN_WIDTH);
        wall tempWall;
        WayPoint tempWayPoint;
        for (int i = 0; i < wallNum; i++)
        {
            tempWall = new wall(Color.BLACK, leftSide, (int)bottom,  leftSide+250,  (int)(bottom + location), i);
            //System.out.println("Hit " +i);
            if(i == 1|| i == 3 || i== 2)
            {
                tempWayPoint = new WayPoint(leftSide, (int)bottom, tempWall);
                System.out.println("WP Location ~left side:"+ leftSide + " Bottom:" + (int)bottom);
                wps.add(tempWayPoint);
                // System.out.println("leftside=" + leftSide + " bottom=" + (int)bottom);
            }
            walls.add(tempWall);
            leftSide += 250;
        }
    }

    public void spawnTower ()
    {
        int leftSide = 0;
        double bottom = Constants.SCREEN_WIDTH - (Constants.SCREEN_WIDTH*.2);
        double location = Constants.SCREEN_HEIGHT*.04;
        System.out.println("B" + bottom + "L"+location);
        //public BulletTower(ArrayList<GameObject> enemies, int x, int y, AssetManager manager)
        BulletTower bt = new BulletTower(zombies, (int)location, (int)bottom);
        towers.add(bt);
    }
}





