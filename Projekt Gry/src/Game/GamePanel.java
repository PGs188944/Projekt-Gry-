package Game;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    float xDelta = 100, yDelta = 100;
    private BufferedImage img;

    public GamePanel() {
        mouseInputs = new MouseInputs(this);

        importImg();
        addKeyListener(new KeyboardInputs(this));
        setPanelSize();
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }

    private void importImg() {
        InputStream input = getClass().getResourceAsStream("/viking.png"); // "/" mowi ze obraz jest w jednym z folderow

        try {
            img = ImageIO.read(input);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 1024);
        setMaximumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);

    }

    public void changeXDelta(int value) {
        this.xDelta += value;
    }

    public void changeYDelta(int value) {
        this.yDelta += value;
    }

    public void setRectPOs(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(img.getSubimage(0, 11 * 64, 64, 64), (int) xDelta, (int) yDelta, 128, 128, null);

    }
}