package gamestates;

import Game.Game;
import entities.Player;
import levels.LevelManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Playing extends State implements Statemethods{
    private Player player;
    private LevelManager levelManager;

    public Playing(Game game) {
        super(game);
        initClasses();
    }

    private void initClasses() {
        levelManager = new LevelManager(game);
        player = new Player(200,200, (int) (64*Game.SCALE),(int) (64*Game.SCALE));
        player.loadLvlData(levelManager.getCurrentLevel().getLvlData());
    }


    @Override
    public void update() {
        levelManager.update();
        player.update();
    }

    @Override
    public void draw(Graphics g) {
        levelManager.draw(g);
        player.render(g);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            player.setAttacking(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

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
               Gamestate.state = Gamestate.MENU;

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

    public Player getPlayer(){
        return player;
    }

    public void windowFocusLost() {
        player.resetDirBooleans();
    }
}
