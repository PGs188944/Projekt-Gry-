package gamestates;

import Game.Game;
import entities.Player;
import levels.LevelManager;
import ui.PauseOverlay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Playing extends State implements Statemethods{
    private Player player;
    private LevelManager levelManager;
    private PauseOverlay pauseOverlay;
    private boolean paused = false;

    public Playing(Game game) {
        super(game);
        initClasses();
    }

    private void initClasses() {
        levelManager = new LevelManager(game);
        player = new Player(200,200, (int) (64*Game.SCALE),(int) (64*Game.SCALE));
        player.loadLvlData(levelManager.getCurrentLevel().getLvlData());
        pauseOverlay = new PauseOverlay(this);
    }


    @Override
    public void update() {
        if(!paused) {
            levelManager.update();
            player.update();
        }else {
            pauseOverlay.update();
        }
    }

    @Override
    public void draw(Graphics g) {
        levelManager.draw(g);
        player.render(g);

        if(paused)
        pauseOverlay.draw(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            player.setAttacking(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (paused)
            pauseOverlay.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (paused)
            pauseOverlay.mouseReleased(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (paused)
            pauseOverlay.mouseMoved(e);
    }

    @Override
    public void keyPressed(int e) {
       switch (e){
           case 0:
               player.setJump(true);
               break;
           case  1:
               player.setLeft(true);
               break;
           case  2:
               player.setRight(true);
               break;
           case 3:
               paused = !paused;

       }
    }

    @Override
    public void keyReleased(int e) {
        switch (e){
            case 0:
                player.setJump(false);
                break;
            case  1:
                player.setLeft(false);
                break;
            case  2:
                player.setRight(false);
                break;

        }
    }
    public void unpauseGame(){
        paused = false;
    }

    public Player getPlayer(){
        return player;
    }

    public void windowFocusLost() {
        player.resetDirBooleans();
    }
}
