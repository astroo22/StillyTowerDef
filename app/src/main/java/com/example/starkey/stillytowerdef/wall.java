package com.example.starkey.stillytowerdef;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.media.Image;

import static com.example.starkey.stillytowerdef.MainThread.canvas;

public class wall implements GameObject {

    public Rect wall;
    private int color;
    public boolean alive;
    public int top;
    public int left;
    public int right;
    public int bottom;
    public int ID;
    public int health;
    SpawnManager sm;


    public wall(int color, int left, int top, int right, int bottom,int id)
    {
        this.top = top;
        this.left = left;
        this.right = right;
        this.bottom = bottom;
        this.wall = new Rect(left,top,right,bottom);
        this.color = color;
        this.ID = id;
        this.alive = true;
        this.health = 300;
    }
    public void wallMove() {
        if (alive)
        {
            if(health<=0)
            {
                this.alive = false;
                System.out.println("Attempting removal of wall");
                sm.walls.remove(this);
                draw(canvas);
            }

        }
    }
    @Override
    public void draw(Canvas canvas)
    {
        if(alive) {
            Paint paint = new Paint();
            paint.setColor(color);
            canvas.drawRect(wall, paint);
        }
        else
        {
           // canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.MULTIPLY);
            Paint paint = new Paint();
            color = Color.TRANSPARENT;
            paint.setColor(Color.TRANSPARENT);
            canvas.drawRect(wall,paint);

        }

    }
    public int getTop()
    {
        return top;
    }
    public void hit(int hitValue)
    {
        this.health = this.health - hitValue;
       // System.out.println("Wall: " + ID + " has been hit for: " + hitValue + " Remaining health= " + health);
    }
    @Override
    public void update()
    {

    }
    public void update(Point point)
    {

    }

}



