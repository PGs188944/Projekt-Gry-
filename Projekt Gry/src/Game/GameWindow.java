package Game;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    public JFrame jframe;

    public GameWindow(GamePanel gamePanel) {
        jframe = new JFrame();
        jframe.setSize(400, 400);
        jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jframe.add(gamePanel);
        jframe.setVisible(true);
    }
}