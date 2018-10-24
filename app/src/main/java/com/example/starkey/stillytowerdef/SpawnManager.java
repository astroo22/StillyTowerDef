package com.example.starkey.stillytowerdef;

import android.graphics.Canvas;
import android.graphics.Color;
import android.os.SystemClock;

import java.util.ArrayList;
import java.util.Random;

public class SpawnManager {

    private ArrayList<Zombie> zombies;
    private Zombie zombie;
    private ArrayList<Brute> brutes;
    private Brute brute;
    private ArrayList<grunt> grunts;
    private grunt grunt;
    private ArrayList<wall> walls;
    private grunt wall;
    private long startTime;

    //will have parameters of level and maybe other things later
    public SpawnManager()
    {

            startTime = System.currentTimeMillis();
            zombies = new ArrayList<>();
            brutes = new ArrayList<>();
        grunts = new ArrayList<>();
        walls = new ArrayList<>();
        //Thread thread1 = new Thread();
            //thread1(
                    spawnZombies(5);
                    spawnBrutes(3);
                    spawnGrunts(7);
                    spawnwalls(1);

    }
    //params will be the number of things to be spawned later
    public void spawnZombies(int zombieNum)
    {
        //Thread.sleep(mili);
        Random r = new Random();
        int max = Constants.SCREEN_WIDTH -10;
        int i1 = r.nextInt(max -1)+1;
        for(int i=0;i<zombieNum;i++)
        {
            i1 = r.nextInt(max -1)+1;

            //System.out.println("Random value: " + i1 + " Const SW: " + Constants.SCREEN_WIDTH + " xStart: " + xStart);
            //System.out.print(xStart);
            zombies.add(new Zombie(Color.GREEN, i1, i1, i1+ 100, i1 + 100));

        }
            /*
            Integer ii = 0;
            float timer = System.currentTimeMillis();
            double test = System.currentTimeMillis();
            System.out.println(test);
            //boolean test1 = true;
            while(ii<=zombieNum)
            {
                double temp2 = System.currentTimeMillis();
                if(temp2 > test)
                {*/

                    //test = System.currentTimeMillis()+ 2000;
                    //ii++;
                //}
            //}
    }
    public void update()
    {
        //int elapsedTime = (int)(System.currentTimeMillis() - startTime);
        //startTime = System.currentTimeMillis();
        //float speed = zombie.getSpeed();
        for(Zombie zomb : zombies)
        {
           // if !zombie.istouching()

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
            brutes.add(new Brute(Color.RED, i1, i1, i1 + 100, i1 + 100));

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
            grunts.add(new grunt(Color.BLUE, i1, i1, i1 + 100, i1 + 100));

        }
    }
    public void spawnwalls(int wallNum) {
        //Thread.sleep(mili);
        Random r = new Random();
        int max = Constants.SCREEN_WIDTH - 10;
        int i1 = r.nextInt(max - 1) + 1;
        for (int i = 0; i < wallNum; i++) {
            i1 = r.nextInt(max - 1) + 1;

            //System.out.println("Random value: " + i1 + " Const SW: " + Constants.SCREEN_WIDTH + " xStart: " + xStart);
            //System.out.print(xStart);
            walls.add(new wall(Color.BLACK, 500, 500,  700,  700));

        }
    }

    }






