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
    private float xDelta=200, yDelta=200;
    private BufferedImage img;
    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 20;
    private int playerAction = stand_R;
    private int playerDir=-1;
    private int preDir=playerDir;
    private boolean moving = false;
    public GamePanel() {

        mouseInputs=new MouseInputs(this);
        
        importImg();
        loadAnimations();
        
        setPanelSize();
        new keyboardinputs(this);
        //addKeyListener(new Keyboardinputs(this));   //przekazanie gamePanel do KeyboardInputs
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }

    private void loadAnimations() {

        animations = new BufferedImage[21][13];
        for(int j=0;j<animations.length;j++) {
            for (int i = 0; i < animations[j].length; i++) {
                animations[j][i] = img.getSubimage(i * 64, j * 64, 64, 64);
            }
        }
    }

    private void importImg() {
        InputStream input  = getClass().getResourceAsStream("/viking.png"); // "/" mowi ze obraz jest w jednym z folderow

        try {
            img= ImageIO.read(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280,1024);
        setMaximumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);

    }

   public void setDirection(int direction){
        this.playerDir=direction;
        moving=true;
   }
   public void setMoving(boolean moving){
        this.moving=moving;
   }

    private void updateAnimationTick() {
        aniTick++;
        if(aniTick >= aniSpeed){
            aniTick = 0;
            aniIndex++;
            if(aniIndex >= GetSpriteAmount(playerAction))
                aniIndex = 0;
        }
    }
    private void setAction() {
        if (moving) {
            switch (playerDir) {
                case 0:
                    playerAction = walking_U;
                    break;
                case 1:
                    playerAction = walking_D;
                    break;
                case 2:
                    playerAction = walking_L;
                    break;
                case 3:
                    playerAction = walking_R;
                    break;
            }
        }
        else {
            switch (playerDir){
                case 0:
                    playerAction = stand_U;
                    break;
                case 1:
                    playerAction = stand_D;
                    break;
                case 2:
                    playerAction = stand_L;
                    break;
                case 3:
                    playerAction = stand_R;
                    break;
            }
        }
    }
    private void updatePos() {
        if(moving){
            switch (playerDir){
                case UP:
                    yDelta-=5;
                    break;
                case DOWN:
                    yDelta+=5;
                    break;
                case LEFT:
                    xDelta-=5;
                    break;
                case RIGHT:
                    xDelta+=5;
                    break;
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateAnimationTick();

        setAction();
        updatePos();
        g.drawImage(animations[playerAction][aniIndex],(int)xDelta,(int)yDelta,128,128,null);

    }



}


