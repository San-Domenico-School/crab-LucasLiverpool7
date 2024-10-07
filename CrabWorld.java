import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)

public class CrabWorld extends World
{

    /**
     * Create the crab world (the beach). Our world has a size 
     * of 560x560 cells, where every cell is just 1 pixel.
     */
    
    public CrabWorld() 
    {
        super(560, 560, 1);
        prepareScene();
    }
    
    private void prepareScene()
    {
        // instantiate new objects
        Crab crab = new Crab();
    
        // add them to the world
        addObject(crab, 470, 100);
        
        Lobster lobster = new Lobster();
        
        addObject(lobster, 120, 200);
        
        for(int i = 0; i < 8; i++)
        {
            int x =100 + i * 50 - 89;
            int y = 100 + i * 66 + 36;

            if(y > 400) 
            {
                y -= 400;
            }
            
            addObject(new Worm(), x, y);       
        }
    
        
        
    } 
    
}    
