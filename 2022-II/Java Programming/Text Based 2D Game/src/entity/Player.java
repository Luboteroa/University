package entity;

import entity.Entity;
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Clase principal de control del jugador
 */
public class Player extends Entity
{
    GamePanel gamePanel;
    KeyHandler keyHandler;

    /**
     * Posición horizontal en la pantalla
     */
    public final int screenX;
    /**
     * Posición vertical en la pantalla
     */
    public final int screenY;

    /**
     * Instancia el jugador en el centro de la pantalla, con un área de colisión de 8x16 pixeles
     * @param gamePanel Panel de ejecución del programa
     * @param keyHandler Clase de interacción con el teclado
     */
    public Player(GamePanel gamePanel, KeyHandler keyHandler)
    {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        screenX = gamePanel.screenWidth/2 - (gamePanel.tileSize/2);
        screenY = gamePanel.screenHeight/2 - (gamePanel.tileSize/2);

        collisionArea = new Rectangle();
        collisionArea.x = 8;
        collisionArea.y = 16;
        collisionArea.width = 32;
        collisionArea.height = 32;

        setDefaultValues();
        getPlayerImage();
    }

    /**
     * Sitea el jugador en la posición del mundo 23 x 21 (En el mundo generado en texto), con una velocidad de 4 y una dirección inicial de "Down!
     */
    public void setDefaultValues()
    {
        worldX = gamePanel.tileSize * 23;
        worldY = gamePanel.tileSize * 21;
        speed = 4;
        direction = "down";
    }

    /**
     * Adquisición de todas las imágenes necesarias para realizar la animación del personaje
     */
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

    /**
     * Cambia los valores del jugador en cada frame de juego según sea requerido
     */
    public void Update()
    {
        //Change player values inside the game
        if(keyHandler.upPressed == true || keyHandler.downPressed == true
                || keyHandler.leftPressed == true || keyHandler.rightPressed)
        {
            //modify current position and current animation sprites
            if(keyHandler.upPressed == true)
            {
                direction = "up";
                CheckCurrentCollision();
            }

            if(keyHandler.downPressed == true)
            {
                direction = "down";
                CheckCurrentCollision();
            }

            if(keyHandler.leftPressed == true)
            {
                direction = "left";
                CheckCurrentCollision();
            }

            if(keyHandler.rightPressed == true)
            {
                direction = "right";
                CheckCurrentCollision();
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

    /**
     * Realiza un análisis de la colisión del jugador con el entorno, en caso de colisionar, no avanza en dicha dirección
     */
    public void CheckCurrentCollision()
    {
        //Check Tile collision!
        collisionOn = false;
        gamePanel.collisionChecker.CheckTile(this);

        //If collision is false, player can move
        if(collisionOn == false)
        {
            switch (direction)
            {
                case "up": worldY -= speed; break;

                case "down": worldY += speed; break;

                case "left": worldX -= speed; break;

                case "right": worldX += speed; break;
            }
        }
    }

    /**
     * Dibuja el modelo haciendo las iteraciones de la animación
     * @param g2 graphics2D ayuda a realizar mejores nociones del sistema en 2 dimensiones
     */
    public void Draw(Graphics2D g2)
    {
        //g2.setColor(Color.white);
        //g2.fillRect(worldX, worldY, gamePanel.tileSize, gamePanel.tileSize);            //Draw a rectangle

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
        g2.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}
