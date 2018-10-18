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

    public Zombie spawnZombie() {
        Zombie zombie1 = new Zombie(new Rect(100, 100, 100, 100), Color.rgb(155, 155, 155));
        return zombie1;
    }


    public GameView(Context context) {
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);

        this.zombie = spawnZombie();

        zombiePoint = new Point(150, 150);
        zombiePoint.set(150, 150);

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
        while (true) {
            try {
                thread.setRunning(false);
                thread.join();

            } catch (Exception e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }


    public void update()
    {
        zombie.update();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawColor(Color.MAGENTA);
        zombie.draw(canvas);
    }
}