package Game;

import Imputs.keyboardinputs;
import Imputs.MouseInputs;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.*;

import static utilz.constants.PlayerConstants.*;
import static utilz.constants.Directions.*;


public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private Game game;

    public GamePanel(Game game) {

        this.game = game;
        mouseInputs = new MouseInputs(this);

        setPanelSize();
        new keyboardinputs(this);
        //addKeyListener(new Keyboardinputs(this));   //przekazanie gamePanel do KeyboardInputs
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }


    private void setPanelSize() {
        Dimension size = new Dimension(1280, 1024);
        setMaximumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);

    }

    public void updateGame() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.render(g);

    }

    public Game getGame(){
        return game;
    }
}


