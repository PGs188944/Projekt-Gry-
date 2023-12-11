package Game;

//import Imputs.Keyboardinputs;
import Imputs.keyboardinputs;
import Imputs.MouseInputs;

import java.awt.*;
import javax.swing.*;

import static Game.Game.*;



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
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
        setPreferredSize(size);
        System.out.println("size : "+ GAME_WIDTH + " " + GAME_HEIGHT);
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


