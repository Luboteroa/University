package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Clase que controlará todas las entidades dentro del juego (jugador, IA, NPC)
 */
public class Entity
{
    //This class gets all the entity information and send it to the derivated classes
    /**
     * Posición actual en el mundo
     */
    public int worldX, worldY;
    /**
     * Velocidad de la entidad
     */
    public int speed;

    /**
     * Imágenes para sus animaciones
     */
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    /**
     * Dirección en la que se está moviendo actualmente
     */
    public  String direction;

    /**
     * Contador, que permitirá hacer las iteraciones entre las animaciones
     */
    public int spriteCounter = 0;
    /**
     * Contador de sprites, con esta variable se podrá definir a qué imagen cambiar para realizar las animaciones
     */
    public int spriteNum = 1;

    /**
     * Área de colisión de la entidad
     */
    public Rectangle collisionArea;
    /**
     * Permite saber si está colisionando o no la entidad en una dirección específica
     */
    public boolean collisionOn = false;
}
