package main;

import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

/**
 * GamePanel es la clase que controla todos los factores de la ventana emergente generada por Java.
 * Es el generador del método 'Update' y 'Drawing' que será llamado por el resto de clases del juego
 * @author Luis Carlos Botero Agudelo (Kbozz)
 */
public class GamePanel extends JPanel implements Runnable {
    //SCREEN COMPONENTS MAIN GAME LOOP
    //Screen Settings Variables
    /**
     * Tamaño de cada uno de los Tiles en pixeles
     */
    final int originalTileSize = 16;                    //16x16 Tile
    /**
     * Escala a multiplicar el tamaño de los pixeles. Esto debido a que en formatos de pantallas actuales
     * (Como 1920 x 1080) Un Tile 16x16 sería muy pequeño. Así que este factor se multiplica por una escala.
     */
    final int scale = 3;
    /**
     * Multiplicación para hallar el tamaño final del Tile
     */
    public final int tileSize = originalTileSize * scale;      //Final Tile Scale for current screen resolution (1920x1080)
                                                               //48x48 Tile
    /**
     * Tamaño horizontal de la pantalla en píxeles
     */
    public int maxScreenCol = 16;
    /**
     * Tamaño vertical de la pantalla en píxeles
     */
    public int maxScreenRow = 12; //Screen ratio
    /**
     * Tamaño horizontal total de la pantalla
     */
    public int screenWidth = tileSize * maxScreenCol;    //768 pixels
    /**
     * Tamaño vertical total de la pantalla
     */
    public   int screenHeight = tileSize * maxScreenRow;  //576 pixels

    /**
     * Variable que controla la entrada del teclado, mouse, entre otros
     */
    KeyHandler keyHandler = new KeyHandler();           //KeyHandler for current buttons information
    /**
     * Variable que controla el estado de la ventana del juego
     */
    Thread gameThread;
    /**
     * Variable del jugador, el cual se moverá por el mapa e interactuará con el entorno
     */
    public Player player = new Player(this, keyHandler);
    /**
     * Variable del entorno, la cual generará el mundo y sus colisiones
     */
    TileManager tileManager = new TileManager(this);
    /**
     * Detector de colisiones
     */
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    /**
     * FrameRate
     */
    int FPS = 60;

    //WORLD SETTINGS
    /**
     * Tamaño máximo del mapa horizontal
     */
    public final int maxWorldCol = 50;
    /**
     * Tamaño máximo del mapa vertical
     */
    public final int maxWorldRow = 50;

    /**
     * Generador del GamePanel al ser invocado, se genera a partir de su tamaño, el color de fondo, la cualidad de poder
     * renderizar imágenes, detectar las acciones entrada del teclado, entre otros.
     */
    public GamePanel()
    {
        //Set the previous settings to the current panel
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);                   //All the drawing will be done in an offscreen painting buffer
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    /**
     * Inicializa el juego, generando el hilo del programa
     */
    public void startGameThread()
    {
        //Start Game Thread
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * Realiza una acción de llamada de las funciones 'Update()' y 'Draw()' 60 veces por segundo (60 FPS)
     */
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

    /**
     * Función llamada en cada frame, debe llamarse antes de la función draw, ya que esta función realizará todo el
     * background dentro de la ejecución
     */
    public void update()
    {
        player.Update();
    }

    /**
     * Función que permite renderizar en el panel de salida
     * @param g the <code>Graphics</code> Graphis, que permitirá realizar ciertas acciones de renderización
     */
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
