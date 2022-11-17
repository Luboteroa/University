package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity
{
    GamePanel gamePanel;
    KeyHandler keyHandler;

    public Player(GamePanel gamePanel, KeyHandler keyHandler)
    {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        setDefaulValues();
        getPlayerImage();
    }

    public void setDefaulValues()
    {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage()
    {
        try
        {
            //Set sprites for animating
            up1 =    ImageIO.read(getClass().getResourceAsStream("/Sprites/Player/Walking sprites/boy_up_1.png"));
            up2 =    ImageIO.read(getClass().getResourceAsStream("/Sprites/Player/Walking sprites/boy_up_2.png"));
            down1 =  ImageIO.read(getClass().getResourceAsStream("/Sprites/Player/Walking sprites/boy_down_1.png"));
            down2 =  ImageIO.read(getClass().getResourceAsStream("/Sprites/Player/Walking sprites/boy_down_2.png"));
            left1 =  ImageIO.read(getClass().getResourceAsStream("/Sprites/Player/Walking sprites/boy_left_1.png"));
            left2 =  ImageIO.read(getClass().getResourceAsStream("/Sprites/Player/Walking sprites/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Player/Walking sprites/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Player/Walking sprites/boy_right_2.png"));

        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void Update()
    {
        //Change player values inside the game
        if(keyHandler.upPressed == true || keyHandler.downPressed == true
                || keyHandler.leftPressed == true || keyHandler.rightPressed)
        {
            //Modify current position and current animation sprites
            if(keyHandler.upPressed == true)
            {
                direction = "up";
                y -= speed;
            }
            if(keyHandler.downPressed == true)
            {
                direction = "down";
                y += speed;
            }
            if(keyHandler.leftPressed == true)
            {
                direction = "left";
                x -= speed;
            }
            if(keyHandler.rightPressed == true)
            {
                direction = "right";
                x += speed;
            }

            //Able images iterations
            spriteCounter ++;
            if(spriteCounter > 12)
            {
                if(spriteNum == 1)
                {
                    spriteNum = 2;
                }
                else if(spriteNum == 2)
                {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void Draw(Graphics2D g2)
    {
        //g2.setColor(Color.white);
        //g2.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);            //Draw a rectangle

        //Just make an iteration between two images for create an animation
        BufferedImage image = null;

        switch (direction)
        {
            case "up":
                if(spriteNum == 1)
                {
                    image = up1;
                }
                if(spriteNum == 2)
                {
                    image = up2;
                }
                break;

            case "down":
                if(spriteNum == 1)
                {
                    image = down1;
                }
                if(spriteNum == 2)
                {
                    image = down2;
                }
                break;

            case "left":
                if(spriteNum == 1)
                {
                    image = left1;
                }
                if(spriteNum == 2)
                {
                    image = left2;
                }
                break;

            case "right":
                if(spriteNum == 1)
                {
                    image = right1;
                }
                if(spriteNum == 2)
                {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}
