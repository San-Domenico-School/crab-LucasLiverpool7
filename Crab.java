import greenfoot.*;

/**
 * This class defines a crab. Crabs live on the beach.
 * @author LWillcuts
 * @version (10/2/2024) 12:12PM
 */
public class Crab extends Actor
{
    private String currentKeyPress; 
    private boolean hasLost; //true or false if player has lost

    public void act() 
    {
        checkKeyPress();  //checks if key pressed then moves
        turnAtEdge();     //checks if at edge then turns
        checkCollision(); //check if colliding
    }
    
    private void checkKeyPress() 
    {
        if (Greenfoot.isKeyDown("left")) 
        {
            move(-3); //moves three to the left
        }
        if (Greenfoot.isKeyDown("right")) 
        {
            move(3); //moves 3 to the right
        }
        if (Greenfoot.isKeyDown("up")) 
        {
            turn(1); 
        }
        if (Greenfoot.isKeyDown("down")) 
        {
            turn(-1); 
        }
    }

    private void turnAtEdge() 
    {
        if (isAtEdge()) 
        {
            turn(90); //turn the crab by 90 degrees
        }
    }

    private void checkCollision() 
    {
        if (isTouching(Lobster.class)) 
        {
            hasLost = true;
            soundEffects();
            Greenfoot.stop();
            getWorld().showText("You Lose", getWorld().getWidth() / 2, 
                                    getWorld().getHeight() / 2);
        }
        
        if (isTouching(Worm.class)) 
        {
            removeTouching(Worm.class); //removes worm if touched
            Greenfoot.playSound("chime.wav");
            soundEffects();
        }
        
        if (getWorld().getObjects(Worm.class).isEmpty()) 
        {
            getWorld().showText("You Win", getWorld().getWidth() / 2,
                                               getWorld().getHeight() / 2);
            Greenfoot.stop();
        }
    }

    private void soundEffects() 
    {
        // Win game FX
        if (getWorld().getObjects(Worm.class).isEmpty()) 
        {
            Greenfoot.playSound("fanfare.wav");
        }
        
        if (isTouching(Worm.class)) 
        {
            Greenfoot.playSound("chime.wav");
        }
        
        // Lose game FX
        if (hasLost) 
        {
            Greenfoot.playSound("au.wav");
        }
    }
}
    