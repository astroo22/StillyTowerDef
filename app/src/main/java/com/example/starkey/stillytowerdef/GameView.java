package com.example.starkey.stillytowerdef;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.view.MotionEvent;

import java.util.EventListener;


public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;

    private Zombie zombie;
    private Point zombiePoint;
    private SpawnManager sm;

   /* public void spawnZombie() {
        zombie = new Zombie(new Rect(100, 100, 200, 200), Color.rgb(255, 0, 0));
        zombiePoint = new Point(150, 150);
        //update();
        //return zombie;
    }*/


    public GameView(Context context) {
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
       // spawnZombie();
        sm = new SpawnManager();
        sm.giveThread(thread);
        setFocusable(true);
    }


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new MainThread(getHolder(), this);
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();

            } catch (Exception e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }
    //this is the code to grab a thing and move it
   /* @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                zombiePoint.set((int)event.getX(), (int)event.getY());
               // System.out.println("dis working?");
        }
        return true;
    }*/


    public void update()
    {
      //  zombie.update(zombiePoint);
        sm.update();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawColor(Color.WHITE);
       // zombie.draw(canvas);
        sm.draw(canvas);
    }
}