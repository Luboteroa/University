package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    //LISTEN EVERYTHING IN THE KEYBOARD
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    //This method just send me the info of the KeyCode that was Typed
    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    //This method just send me the info of the KeyCode that is currently pressed
    @Override
    public void keyPressed(KeyEvent e)
    {
        int code = e.getKeyCode();

        switch (code)
        {
            case KeyEvent.VK_W:
                upPressed = true;
                break;

            case KeyEvent.VK_S:
                downPressed = true;
                break;

            case KeyEvent.VK_A:
                leftPressed = true;
                break;

            case KeyEvent.VK_D:
                rightPressed = true;
                break;
        }
    }

    //This method just send me the info of the KeyCode that was released
    @Override
    public void keyReleased(KeyEvent e)
    {
        int code = e.getKeyCode();

        switch (code)
        {
            case KeyEvent.VK_W:
                upPressed = false;
                break;

            case KeyEvent.VK_S:
                downPressed = false;
                break;

            case KeyEvent.VK_A:
                leftPressed = false;
                break;

            case KeyEvent.VK_D:
                rightPressed = false;
                break;
        }
    }
}
