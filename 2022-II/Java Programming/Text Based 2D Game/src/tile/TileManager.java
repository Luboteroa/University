package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Clase principal de creación de mundos dentro del panel de juego (entorno)
 */
public class TileManager
{
    GamePanel gamePanel;
    /**
     * Tiles que se utilizarán
     */
    public Tile[] tile;
    /**
     * Matriz del mundo
     */
    public int mapTileNum[][];

    /**
     * Generador de TileManager que provee el número de tiles totales, junto con su tamaño de mundo
     * @param gamePanel panel de ventana emergente del programa
     */
    public TileManager(GamePanel gamePanel)
    {
        this.gamePanel = gamePanel;

        tile = new Tile[10];
        mapTileNum = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];

        getTileImage();
        loadMap("/Sprites/Maps/world01.txt");
    }

    /**
     * Realiza una abstracción de todas las imágenes del entorno, convirtiéndolas en archivos leíbles por java
     */
    public void getTileImage()
    {
        //Get all the images from the folder and convert it to a Tile
        try
        {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Sprites/Tiles/Old version/grass.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Sprites/Tiles/Old version/wall.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Sprites/Tiles/Old version/water.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/Sprites/Tiles/Old version/earth.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/Sprites/Tiles/Old version/tree.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/Sprites/Tiles/Old version/sand.png"));

        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Carga el mapa generado en archivo .txt
     * @param filePath ruta del mapa específico
     */
    public void loadMap(String filePath)
    {
        try
        {
            //Convert from .txt format to matrix
            InputStream inputStream = getClass().getResourceAsStream(filePath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            int col = 0;
            int row = 0;

            while(col<gamePanel.maxWorldCol && row<gamePanel.maxWorldRow)
            {
                String line = bufferedReader.readLine();

                while(col < gamePanel.maxWorldCol)
                {
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gamePanel.maxWorldCol)
                {
                    col = 0;
                    row++;
                }
            }
            bufferedReader.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    /**
     * Dibuja el mapa en tiempo real, no dibuja todo el mapa sino la zona donde está situada la cámara del jugador
     * @param g2 Graphics2D, extensión que ayuda a la facilitación de dibujos en 2 dimensiones
     */
    public void Draw(Graphics2D g2)
    {
        //Draw the matrix into the specific tile
        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < gamePanel.maxWorldCol && worldRow< gamePanel.maxWorldRow) {
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gamePanel.tileSize;
            int worldY = worldRow * gamePanel.tileSize;
            int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
            int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;

            //Draw the matrix into the world screen camera
            if(worldX + gamePanel.tileSize > gamePanel.player.worldX - gamePanel.player.screenX
                && worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX
                && worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY
                && worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY)
            {
                g2.drawImage(tile[tileNum].image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
            }
            worldCol++;

            if (worldCol == gamePanel.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
