package entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utilz.constants.Directions.*;
import static utilz.constants.Directions.RIGHT;
import static utilz.constants.PlayerConstants.*;

public class Player extends Entity {
    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 20;
    private int playerAction = stand_R;
    private int playerDir;
    private boolean moving = false, attacking = false;
    private boolean up, down, left, right;
    private float playerSpeed = 2.0f;

    public Player(float x, float y) {
        super(x, y);
        loadAnimations();
    }

    public void update() {

        updateAnimationTick();
        setAction();
        updatePos();
    }

    public void render(Graphics g) {
        g.drawImage(animations[playerAction][aniIndex], (int) x, (int) y, 128, 128, null);
    }


    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= GetSpriteAmount(playerAction)) {
                aniIndex = 0;
                attacking = false;
            }
        }
    }

    private void setAction() {
        int startAni = playerAction;
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
        } else {
            switch (playerDir) {
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
        if (attacking)
            switch (playerDir) {
                case 0:
                    playerAction = attack_U;
                    break;
                case 1:
                    playerAction = attack_D;
                    break;
                case 2:
                    playerAction = attack_L;
                    break;
                case 3:
                    playerAction = attack_R;
                    break;
            }
        if(startAni != playerAction)
            resetAniTIck();
    }

    private void resetAniTIck() {
        aniTick=0;
        aniIndex=0;
    }

    private void updatePos() {
        moving=false;

        if (left && !right) {
            x -= playerSpeed;
            moving=true;
            playerDir = 2;
        } else if (right && !left) {
            x += playerSpeed;
            moving=true;
            playerDir = 3;
        }

        if (up && !down) {
            y -= playerSpeed;
            moving=true;
            playerDir = 0;
        } else if (down && !up) {
            y += playerSpeed;
            moving=true;
            playerDir = 1;
        }
    }

    public void updateGame() {
        updatePos();
        updateAnimationTick();
        setAction();

    }

    private void loadAnimations() {

        InputStream input = getClass().getResourceAsStream("/viking.png"); // "/" mowi ze obraz jest w jednym z folderow

        try {
            BufferedImage img = ImageIO.read(input);
            animations = new BufferedImage[21][13];
            for (int j = 0; j < animations.length; j++) {
                for (int i = 0; i < animations[j].length; i++) {
                    animations[j][i] = img.getSubimage(i * 64, j * 64, 64, 64);
                }
            }

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

    public void resetDirBooleans() {
        up = false;
        down = false;
        left = false;
        right = false;
    }
    public void setAttacking(boolean attacking){
        this.attacking=attacking;
    }
    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }


}
