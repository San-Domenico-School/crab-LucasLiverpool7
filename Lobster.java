import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class defines a Lobster. Lobsters are red
 * 
 * @author LWillcuts
 * @version 10/2/2024 12:11PM
 */
public class Lobster extends Actor
{
    /**
     * Act - do whatever the Lobster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (isAtEdge())
        {
            turn(180);
        }//turns crab at the edge
        move(5);
        //randomly turn crab
        if (Greenfoot.getRandomNumber(120) < 60)
        {
            turn(Greenfoot.getRandomNumber(90) - 45);
        }
    }

}
