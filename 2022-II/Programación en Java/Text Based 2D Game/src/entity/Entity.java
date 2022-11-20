package entity;

import java.awt.image.BufferedImage;

public class Entity
{
    //This class gets all the entity information and send it to the derivated classes
    public int worldX, worldY;
    public int speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public  String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
}
