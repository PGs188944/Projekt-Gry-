package Game;

import java.awt.Component;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
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
        this.jframe.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                gamePanel.getGame().windowFocusLost();
            }

            @Override
            public void windowLostFocus(WindowEvent e) {

            }
        });
    }
}
