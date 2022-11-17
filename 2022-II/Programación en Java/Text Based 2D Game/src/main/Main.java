package main;

import javax.swing.*;

public class Main
{
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
