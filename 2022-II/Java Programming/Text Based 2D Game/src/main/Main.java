package main;
import javax.swing.*;

/**
 * Objeto principal de ejecución de todos los paquetes y clases del juego
 * @author Luis Carlos Botero Agudelo (Kbozz)
 */
public class Main
{
    /**
     * Método de ejecución directa del archivo
     * @param args Argumentos a ser enviados
     */
    public static  void main(String[] args)
    {
        //Create new window
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Adventura");

        //Add GamePanel script
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();

        //Add panel information to window
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        //Initialize thread
        gamePanel.startGameThread();
    }
}
