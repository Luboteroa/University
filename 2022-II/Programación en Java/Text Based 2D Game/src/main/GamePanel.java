package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable
{
    //SCREEN SETTINGS!!
    final int originalTileSize = 16;                    //16x16 Tile
    final int scale = 3;

    final int tileSize = originalTileSize * scale;      //FINAL TILE SCALE FOR NEW SCREENS RESOLUTION!
                                                        //48x48 Tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12; //Screen ratio
    final int screenWidth = tileSize * maxScreenCol;    //768 pixels
    final  int screenHeight = tileSize * maxScreenRow;  //576 pixels

    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    int FPS = 60;
    public GamePanel()
    {
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

    /*
    @Override
    public void run() {
        //int i = 0;
        //GameLoop -- UPDATE
        double drawInterval = 1000000000/FPS;                   //0.01666 seconds
        double nextDrawTime = System.nanoTime() + drawInterval;

       while (gameThread != null)
        {
            //As long as the gamePanel is open, it make a loop every frame
            //System.out.println("Game Loop! " + i);
            //i++;

            long currentTime = System.nanoTime();               //Catch the time in nano seconds 1.000.000.000 Sec = 1 nSec
            System.out.println("CurrentTime " + currentTime);

            //1. Update Information such as character position
            update();

            //2. Redraw the screen with the updated information
            repaint();


            try
            {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0)
                    remainingTime = 0;

                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;

            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
    */

    public void run()
    {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null)
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

    public void update() {
        if(keyHandler.upPressed == true)
        {
            playerY -= playerSpeed;
        }
        if(keyHandler.downPressed == true)
        {
            playerY += playerSpeed;
        }
        if(keyHandler.leftPressed == true)
        {
            playerX -= playerSpeed;
        }
        if(keyHandler.rightPressed == true)
        {
            playerX += playerSpeed;
        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;                       //Change graphics to graphics 2D

        g2.setColor(Color.white);

        g2.fillRect(playerX, playerY, tileSize, tileSize);            //Draw a rectangle
        g2.dispose();
    }
}
