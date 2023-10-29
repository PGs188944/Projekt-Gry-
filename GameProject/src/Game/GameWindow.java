package Game;

import java.awt.Component;
import javax.swing.JFrame;

public class GameWindow extends JFrame {
    public JFrame jframe = new JFrame();

    public GameWindow(GamePanel gamePanel) {
        //this.jframe.setLocationRelativeTo((Component)null);
        this.jframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.jframe.add(gamePanel);
        this.jframe.setResizable(false);
        this.jframe.pack(); //ustawia rozmiar gamewindow aby pasował do rozmiarów konponentów (gamepanel)
        this.jframe.setVisible(true);
    }
}
