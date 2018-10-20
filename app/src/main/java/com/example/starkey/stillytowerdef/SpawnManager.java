package com.example.starkey.stillytowerdef;

import android.graphics.Canvas;
import android.graphics.Color;
import android.os.SystemClock;

import java.util.ArrayList;
import java.util.Random;

public class SpawnManager {

    private ArrayList<Zombie> zombies;
    private Zombie zombie;
    private long startTime;

    //will have parameters of level and maybe other things later
    public SpawnManager()
    {

            startTime = System.currentTimeMillis();
            zombies = new ArrayList<>();
        //Thread thread1 = new Thread();
            //thread1(
                    spawnThings(5);

    }
    //params will be the number of things to be spawned later
    public void spawnThings(int zombieNum)
    {
        //Thread.sleep(mili);
        Random r = new Random();
        int max = Constants.SCREEN_WIDTH -200;
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
            zomb.zombieMove();
        }
    }
    public void draw(Canvas canvas)
    {
        for(Zombie zomb: zombies)
        {
            zomb.draw(canvas);
        }
    }
}
