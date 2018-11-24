package com.example.starkey.stillytowerdef;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.Image;

public class Zombie implements GameObject
{
   private Rect zombie;
   private int currentPos;
   private int currentPosy;
   private WayPoint wp;
   private int damage;
   private int health;
   private int speed;
   private int color;
   private boolean alive;
   public int left;
   public int right;

    public Zombie(int color, int left, int top, int right, int bottom)
    {
        //rect = left top right bottom
        this.currentPos = (right -50);
        this.currentPosy = bottom;
        this.zombie = new Rect(left,top,right,bottom);
        this.damage = 15;
        this.health = 500;
        this.speed = 5;
        this.color = color;
        this.left = left;
        this.right = right;
    }


    @Override
    public void draw(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(zombie,paint);

    }
    public int getSpeed()
    {
        return speed;
    }

    public void zombieMove()
    {
        walk();

    }
    public void setWayPointTarget(WayPoint wp)
    {
        this.wp = wp;
    }
    public void walk()
    {
        if (wp.getWayPointX() != currentPos )
        {
            if(currentPos<wp.getWayPointX())
            {
                walkRight();
            }
            if(currentPos>wp.getWayPointX())
            {
                walkLeft();
            }
        }
        if(currentPosy<wp.getWayPointY())
        {
            //System.out.println(wp.getWayPointY());
            //currentPos += speed;
            zombie.top += speed;
            zombie.bottom += speed;
            currentPosy += speed;
            //System.out.println(currentPosy);
        }
    }
    public void walkRight()
    {
        zombie.left += speed - (speed/2);
        zombie.right += speed- (speed/2);
        //zombie.top += speed-(speed/2);
        //zombie.bottom +=speed -(speed/2);
        currentPosy = zombie.bottom;
        currentPos = zombie.right -(zombie.right-zombie.left);
       // left = zombie.left;
       // right = zombie.right;

    }
    public void walkLeft()
    {
        zombie.left -= speed - (speed/2);
        zombie.right -= speed - (speed/2);
        //zombie.top += speed-(speed/2);
        //zombie.bottom +=speed-(speed/2);
        currentPosy = zombie.bottom;
        currentPos = zombie.right -(zombie.right-zombie.left);
    }


    public void attack(wall thing)
    {
        //thing.hit(damage);
    }
  /*  public boolean closeToWall()
    {
        //for(int i = 0; i<sm.walls.size();i++) {

           /* if (zombie.bottom == sm.walls[i])
            {
            }*/ // cant seem to pull the wall info from the array list hmmm
//        }



    @Override
    public void update()
    {

    }
    public void update(Point point)
    {
        //helper function for defining box and and moving it around with mouse.
        //left, top, right, bottom
        //zombie.set(point.x - zombie.width()/2, point.y - zombie.height()/2, point.x + zombie.width()/2, point.y + zombie.height()/2);

    }

}
