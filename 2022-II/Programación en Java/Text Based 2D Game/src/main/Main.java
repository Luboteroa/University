/**
 * @file Main.java
 * @version 1.0
 * @date 17/11/2022
 * @author Luis Carlos Botero Agudelo (Kbozz)
 * @title Archivo main proyecto Text Based 2D Game
 * @brief Archivo que se ejecutará para realizar la compilación del juego basado en texto, raiz de todo
 */

package main;

import javax.swing.*;

public class Main
{
    public static  void main(String[] args)
    {
        //Create new window
        JFrame window = new JFrame();
        /**
         * @brief JFrame.setDefaultCloseOperation Indica que mi programa finaliza cuando se cierra la ventana
         * @param JFrame.EXIT_ON_CLOSE Parámetro general de la ventana
         * @return NULL
         */
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * @brief JFrame.setResizable Función para reescalar la ventana
         * @param bool=false Boleano para definir si se puede o no escalar
         * @return NULL
         */
        window.setResizable(false);

        /**
         * @brief JFrame.
         */
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
