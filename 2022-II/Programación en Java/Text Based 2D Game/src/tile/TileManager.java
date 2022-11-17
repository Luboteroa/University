package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager
{
    GamePanel gamePanel;
    Tile[] tile;
    int mapTileNum[][];

    public TileManager(GamePanel gamePanel)
    {
        this.gamePanel = gamePanel;

        tile = new Tile[10];
        mapTileNum = new int[gamePanel.maxScreenCol][gamePanel.maxScreenRow];

        getTileImage();
        loadMap("/Sprites/Maps/map01.txt");
    }

    public void getTileImage()
    {
        try
        {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Sprites/Tiles/Old version/grass.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Sprites/Tiles/Old version/wall.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Sprites/Tiles/Old version/water.png"));

        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath)
    {
        try
        {
            InputStream inputStream = getClass().getResourceAsStream(filePath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            int col = 0;
            int row = 0;

            while(col<gamePanel.maxScreenCol && row<gamePanel.maxScreenRow)
            {
                String line = bufferedReader.readLine();

                while(col < gamePanel.maxScreenCol)
                {
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gamePanel.maxScreenCol)
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
    public void Draw(Graphics2D g2)
    {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col < gamePanel.maxScreenCol && row < gamePanel.maxScreenRow)
        {
            int tileNum = mapTileNum[col][row];
            g2.drawImage(tile[tileNum].image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
            col++;
            x+=gamePanel.tileSize;

            if(col==gamePanel.maxScreenCol)
            {
                col = 0;
                x = 0;
                row++;
                y += gamePanel.tileSize;
            }
        }

        /*
        //Draw the matrix tile
        g2.drawImage(tile[1].image, 0, 0, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[1].image, 48, 0, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[1].image, 96, 0, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[1].image, 144, 0, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[1].image, 192, 0, gamePanel.tileSize, gamePanel.tileSize, null);

        g2.drawImage(tile[1].image, 0, 48, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[0].image, 48, 48, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[0].image, 96, 48, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[0].image, 144, 48, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[1].image, 192, 48, gamePanel.tileSize, gamePanel.tileSize, null);

        g2.drawImage(tile[1].image, 0, 96, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[0].image, 48, 96, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[0].image, 96, 96, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[0].image, 144, 96, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[0].image, 192, 96, gamePanel.tileSize, gamePanel.tileSize, null);

        g2.drawImage(tile[1].image, 0, 144, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[0].image, 48, 144, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[0].image, 96, 144, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[0].image, 144, 144, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[1].image, 192, 144, gamePanel.tileSize, gamePanel.tileSize, null);

        g2.drawImage(tile[1].image, 0, 192, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[2].image, 48, 192, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[2].image, 96, 192, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[2].image, 144, 192, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[1].image, 192, 192, gamePanel.tileSize, gamePanel.tileSize, null);
        //TOO MUCH TYPING...
        */
    }
}
