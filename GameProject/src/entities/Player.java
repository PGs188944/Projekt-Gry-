package entities;

import Game.Game;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;
import static  utilz.HelpMethods.CanMoveHere;
import static utilz.constants.PlayerConstants.*;

public class Player extends Entity {
    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 20;
    private int playerAction = stand_R;
    private int playerDir;
    private boolean moving = false, attacking = false;
    private boolean up, down, left, right;
    private float playerSpeed = 2.0f;
    private int[][] lvlData;
    private float xDrawOffset = 17 * Game.SCALE;
    private float yDrawOffset = 11 * Game.SCALE;


    public Player(float x, float y, int width, int height) {
        super(x, y, width, height);
        loadAnimations();
        initHitbox(x,y, 30*Game.SCALE, 48 *Game.SCALE);
    }

    public void update() {
        updatePos();
        updateAnimationTick();
        setAction();

    }

    public void render(Graphics g) {
        g.drawImage(animations[playerAction][aniIndex], (int) (hitbox.x - xDrawOffset), (int) (hitbox.y - yDrawOffset), width, height, null);
        //drawHitbox(g);
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
        if(!left && !right && !up && !down)
            return;

        float xSpeed = 0, ySpeed = 0;

        if (left && !right) {
            xSpeed = -playerSpeed;
            playerDir = 2;
        } else if (right && !left) {
            xSpeed = playerSpeed;
            playerDir = 3;
        }

        if (up && !down) {
            ySpeed = -playerSpeed;
            playerDir = 0;
        } else if (down && !up) {
            ySpeed = playerSpeed;
            playerDir = 1;
        }

//        if(CanMoveHere(x+xSpeed, y+ySpeed, width, height, lvlData)){
//            this.x += xSpeed;
//            this.y += ySpeed;
//            moving = true;
//        }

        if (CanMoveHere(hitbox.x + xSpeed, hitbox.y + ySpeed, hitbox.width, hitbox.height, lvlData)) {
            hitbox.x += xSpeed;
            hitbox.y += ySpeed;
            moving = true;
        }

    }


    private void loadAnimations() {

            BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);
            animations = new BufferedImage[21][13];
            for (int j = 0; j < animations.length; j++) {
                for (int i = 0; i < animations[j].length; i++) {
                    animations[j][i] = img.getSubimage(i * 64, j * 64, 64, 64);
                }
            }
    }

    public void loadLvlData(int[][] lvlData){
        this.lvlData = lvlData;
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
