package com.example.starkey.stillytowerdef;



import android.graphics.Color;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.Image;
import static com.example.starkey.stillytowerdef.MainThread.canvas;

public class Brute implements GameObject
{

    private Rect brute;
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
    public boolean attack;
    SpawnManager sm;
    public final Long period = 3000L;
    public long startTime;


    public Brute(int color, int left, int top, int right, int bottom)
    {
        //rect = left top right bottom
        this.brute = new Rect(left,top,right,bottom);
        this.damage = 25;
        this.health = 500;
        this.speed = 3;
        this.color = color;
        this.left = left;
        this.right = right;
        this.startTime = System.currentTimeMillis()-period;
        this.alive = true;



    }


    @Override
    public void draw(Canvas canvas)
    {
        if(alive)
        {
            Paint paint = new Paint();
            paint.setColor(color);
            canvas.drawRect(brute,paint);
        }
        if(!alive)
        {
            // canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.MULTIPLY);
            Paint paint = new Paint();
            color = Color.TRANSPARENT;
            paint.setColor(Color.TRANSPARENT);
            canvas.drawRect(brute,paint);

        }

    }




    public int getSpeed()
    {
        return speed;
    }
    public boolean getlivingStatus() { return alive; }

    public void bruteMove()
    {
        {
            if(alive) {
                if (!attack) {
                    walk();
                    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~use the below line to test death/removal of object ~~~~~~~~~~~~~~~~~~~
                    //this.health = health-10;
                }
                if(attack)
                {
                    if(wp.getWallStatus())
                    {
                        long thisTime = System.currentTimeMillis();
                        if((thisTime-startTime)>=period)
                        {
                            startTime=thisTime;
                            attack(wp.getWall());
                        }
                    }
                    if(!wp.getWallStatus())
                    {
                        attack = false;
                        setWayPointTarget(new WayPoint(getCurrentPointX(),10000));
                   /* base code 4 after buildings are in game ignore this ~~~~~~~~~~~
                   int temp = (int)Constants.SCREEN_WIDTH/2;
                   if(currentPos>temp)
                   {
                       if(sm.buildingSpot1Right.getStatus())
                       {
                           setWayPointTarget(sm.buildingSpot1Right.getWP());
                       }
                       else if(sm.buildingSpot2Right.getStatus())
                       {
                           setWayPointTarget(sm.buildingSpot2Right.getWP());
                       }
                   }
                   else if(currentPos<temp)
                   {
                       if(sm.buildingSpot1Left.getStatus())
                       {
                           setWayPointTarget(sm.buildingSpot1Left.getWP());
                       }
                       else if(sm.buildingSpot2Left.getStatus())
                       {
                           setWayPointTarget(sm.buildingSpot2Left.getWP());
                       }
                   }
                   if(test)
                   {
                       setWayPointTarget(sm.finalWaypoint.getWP);
                   }

                    */
                    }
                }
            }
            if(health<=0)
            {
                this.alive = false;
                System.out.println("Attempting removal of brute");
                sm.brutes.remove(this);
                sm.enemyCounter--;
                draw(canvas);
            }
        }
    }
    public void setWayPointTarget(WayPoint wp)
    {
        this.wp = wp;
    }
    public int getCurrentPointY()
    {
        return currentPosy;
    }
    public int getCurrentPointX()
    {
        return currentPos;
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
            brute.top += speed;
            brute.bottom += speed;
            currentPosy += speed;
            //System.out.println(currentPosy);
        }
        else
        {
            System.out.println("ATTACK HAS BEEN SET TO TRUE");
            attack = true;
        }
    }
    public void walkRight()
    {
        brute.left += speed - (speed/2);
        brute.right += speed- (speed/2);
        //zombie.top += speed-(speed/2);
        //zombie.bottom +=speed -(speed/2);
        currentPosy = brute.bottom;
        currentPos = brute.right -(brute.right-brute.left);
        // left = zombie.left;
        // right = zombie.right;

    }
    public void walkLeft()
    {
        brute.left -= speed - (speed/2);
        brute.right -= speed - (speed/2);
        //zombie.top += speed-(speed/2);
        //zombie.bottom +=speed-(speed/2);
        currentPosy = brute.bottom;
        currentPos = brute.right -(brute.right-brute.left);
    }


    public void attack(wall thing)
    {
        thing.hit(damage);
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

