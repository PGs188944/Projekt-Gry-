package Imputs;

import Game.GamePanel;
import gamestates.Gamestate;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import static utilz.constants.Directions.*;

public class keyboardinputs {
    final GamePanel gamePanel;
    Action leftAction,rightAction;
    Action standLeft,standRight;
    Action jump, fall;
    Action pause, resume;
    public keyboardinputs(GamePanel gamePanel){
        this.gamePanel=gamePanel;

        leftAction = new LeftAction();
        rightAction = new RightAction();
        standLeft = new StandLeft();
        standRight = new StandRight();
        jump = new Jumping();
        fall = new Falling();
        fall = new Falling();
        pause = new Pause();
        resume = new Resume();

        gamePanel.getInputMap().put(KeyStroke.getKeyStroke('a'),"leftAction");
        gamePanel.getActionMap().put("leftAction",leftAction);
        gamePanel.getInputMap().put(KeyStroke.getKeyStroke('d'),"rightAction");
        gamePanel.getActionMap().put("rightAction",rightAction);

        gamePanel.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_A,0,true),"standLeft");
        gamePanel.getActionMap().put("standLeft",standLeft);
        gamePanel.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_D,0,true),"standRight");
        gamePanel.getActionMap().put("standRight",standRight);

        gamePanel.getInputMap().put(KeyStroke.getKeyStroke("SPACE"),"jump");
        gamePanel.getActionMap().put("jump",jump);
        gamePanel.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE,0,true),"fall");
        gamePanel.getActionMap().put("fall",fall);

        gamePanel.getInputMap().put(KeyStroke.getKeyStroke("ENTER"),"pauze");
        gamePanel.getActionMap().put("pauze",pause);

        gamePanel.getInputMap().put(KeyStroke.getKeyStroke("BACK_SPACE"),"resume");
        gamePanel.getActionMap().put("resume",resume);

    }
    // walking
    private class Jumping extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (Gamestate.state) {

                //System.out.println("A");
                case PLAYING:
                    gamePanel.getGame().getPlaying().keyPressed(0);
                    break;
                case MENU:
                    gamePanel.getGame().getMenu().keyPressed(0);
                    break;
            }
        }
    }

    public class LeftAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (Gamestate.state) {

                //System.out.println("A");
                case PLAYING:
                    gamePanel.getGame().getPlaying().keyPressed(1);
                    break;
                case MENU:
                    gamePanel.getGame().getMenu().keyPressed(1);
                    break;
            }
        }
    }
    public class RightAction extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (Gamestate.state) {

                //System.out.println("A");
                case PLAYING:
                    gamePanel.getGame().getPlaying().keyPressed(2);
                    break;
                case MENU:
                    gamePanel.getGame().getMenu().keyPressed(2);
                    break;
            }
        }

    }


    // standing
    public class Falling extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (Gamestate.state) {


                case PLAYING:
                    gamePanel.getGame().getPlaying().keyReleased(0);
                    break;
                case MENU:
                    gamePanel.getGame().getMenu().keyReleased(0);
                    break;
            }
        }
    }
    public class StandLeft extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (Gamestate.state) {

                //System.out.println("A");
                case PLAYING:
                    gamePanel.getGame().getPlaying().keyReleased(1);
                    break;
                case MENU:
                    gamePanel.getGame().getMenu().keyReleased(1);
                    break;
            }
        }
    }
    public class StandRight extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (Gamestate.state) {

                //System.out.println("A");
                case PLAYING:
                    gamePanel.getGame().getPlaying().keyReleased(2);
                    break;
                case MENU:
                    gamePanel.getGame().getMenu().keyReleased(2);
                    break;
            }
        }
    }

    // menu

    private class Resume extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (Gamestate.state) {

                //System.out.println("A");
                case PLAYING:
                    gamePanel.getGame().getPlaying().keyPressed(3);
                    break;
                case MENU:
                    gamePanel.getGame().getMenu().keyPressed(3);
                    break;
            }
        }
    }
    private class Pause extends AbstractAction {


        @Override
        public void actionPerformed(ActionEvent e) {
            switch (Gamestate.state) {

                //System.out.println("A");
                case PLAYING:
                    gamePanel.getGame().getPlaying().keyPressed(4);
                    break;
                case MENU:
                    gamePanel.getGame().getMenu().keyPressed(4);
                    break;
            }
        }
    }




}
