package main;

import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
public class GamePanel extends JPanel implements Runnable {
    //SCREEN COMPONENTS MAIN GAME LOOP
    //Screen Settings Variables
    final int originalTileSize = 16;                    //16x16 Tile
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;      //Final Tile Scale for current screen resolution (1920x1080)
                                                        //48x48 Tile
    public int maxScreenCol = 16;
    public int maxScreenRow = 12; //Screen ratio
    public int screenWidth = tileSize * maxScreenCol;    //768 pixels
    public   int screenHeight = tileSize * maxScreenRow;  //576 pixels

    KeyHandler keyHandler = new KeyHandler();           //KeyHandler for current buttons information
    Thread gameThread;
    Player player = new Player(this, keyHandler);
    TileManager tileManager = new TileManager(this);

    int FPS = 60;

    //WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize*maxScreenCol;
    public final int worldHeight = tileSize*maxScreenRow;
    public GamePanel()
    {
        //Set the previous settings to the current panel
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);                   //All the drawing will be done in an offscreen painting buffer
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread()
    {
        //Start Game Thread
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run()
    {
        //Use the gameThread to visualize the Update and RePaint method every single frame
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null)                               //While the window is open
        {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime)/drawInterval;
            lastTime = currentTime;

            if(delta >= 1)
            {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update()
    {
        player.Update();
    }

    public void paintComponent(Graphics g)
    {
        //Repaint all that player components inside the visualized game
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;                       //Change graphics to graphics 2D

        //We draw using partition of code
        tileManager.Draw(g2);                                //First draw tiles
        player.Draw(g2);                                     //After that draw the player above it

        g2.dispose();
    }
}
