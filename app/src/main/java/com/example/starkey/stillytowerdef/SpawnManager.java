package com.example.starkey.stillytowerdef;

import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;

import com.example.starkey.stillytowerdef.Brute;
import com.example.starkey.stillytowerdef.Constants;
import com.example.starkey.stillytowerdef.Zombie;

import java.util.ArrayList;
import java.util.Random;
import java.math.*;

import static java.lang.Math.abs;

public class SpawnManager {
    //ArrayAdapter ad ~~~~~~~~~~~~~~~~~~~~~do this look at to do
    public ArrayList<Zombie> zombies;
    public Zombie zombie;
    public int enemyCounter;
    private ArrayList<Brute> brutes;
    private Brute brute;
    private ArrayList<grunt> grunts;
    private grunt grunt;
    public ArrayList<wall> walls;
    public grunt wall;
    public ArrayList<WayPoint> wps;
    public WayPoint wp;
    private long startTime;


    //will have parameters of level and maybe other things later
    public SpawnManager()
    {

        startTime = System.currentTimeMillis();
        zombies = new ArrayList<>();
        brutes = new ArrayList<>();
        grunts = new ArrayList<>();
        walls = new ArrayList<>();
        wps = new ArrayList<>();
        spawnZombies(1);
        spawnBrutes(0);
        spawnGrunts(0);
        spawnwalls(6);

    }
    /* ~~~~~~~~~~~~~~~~~~~~~~this will be used DO NOT DELETE ~~~~~~~~~~~~~~~~~~~~~~
    public WayPoint findWayPoint(int startLocation)
    {
        WayPoint tempPoint;
        tempPoint = wps[0];
        for(int i = 0;i<wps.size();i++)
        {
            if((abs(startLocation - wps[i].getX)) < (abs(startLocation - tempPoint.getWayPointX())))
            {
                tempPoint = wps[i];
            }
        }
    }*/
    //params will be the number of things to be spawned later





    public void spawnZombies(int zombieNum)
    {
        //Thread.sleep(mili);
        Random r = new Random();
        Zombie tempZombie;
        int max = Constants.SCREEN_WIDTH -10;
        int i1 = r.nextInt(max -1)+1;
        for(int i=0;i<zombieNum;i++)
        {
            i1 = r.nextInt(max -1)+1;
            //~~~~~~~~~~~~~~~~~~~~ THIS IS A SINGLE EVENT FOR 1 ZOMBIE WE WILL DO THIS IN A LOOP LATER ~~~~~~~~~~~~~~~~
            WayPoint somethingStupid = new WayPoint(700, 700);
            tempZombie = new Zombie(Color.GREEN, i1, 20, i1+ 100, 120);
            tempZombie.setWayPointTarget(somethingStupid);
            zombies.add(tempZombie);



        }
    }

    public void update()
    {
        for(Zombie zomb : zombies)
        {

            zomb.zombieMove();
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

        }
    }
    public void spawnwalls(int wallNum) {
        //Thread.sleep(mili);
        Random r = new Random();
        //int max = Constants.SCREEN_WIDTH - 10;
        int leftSide = 0;
        double bottom = Constants.SCREEN_HEIGHT - (Constants.SCREEN_HEIGHT*.25);
        double location = Constants.SCREEN_HEIGHT*.07;
        wall tempWall;
        WayPoint tempWayPoint;
        for (int i = 0; i < wallNum; i++)
        {
            tempWall = new wall(Color.BLACK, leftSide, (int)bottom,  leftSide+250,  (int)(bottom + location), i);
            if(i % 2 == 1)
            {
                tempWayPoint = new WayPoint(leftSide, (int)bottom, tempWall);
                wps.add(tempWayPoint);
            }
            walls.add(tempWall);
            leftSide += 250;

        }
    }

}





