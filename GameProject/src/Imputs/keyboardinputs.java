package Imputs;

import Game.GamePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import static utilz.constants.Directions.*;

public class keyboardinputs {
    final GamePanel gamePanel;
    Action upAction, downAction,leftAction,rightAction;
    Action standUp,standDown,standLeft,standRight;
    Action jump, fall;
    public keyboardinputs(GamePanel gamePanel){
        this.gamePanel=gamePanel;
        upAction = new UpAction();
        downAction = new DownAction();
        leftAction = new LeftAction();
        rightAction = new RightAction();
        standUp = new StandUp();
        standDown = new StandDown();
        standLeft = new StandLeft();
        standRight = new StandRight();
        jump = new Jumping();
        fall = new Falling();

        gamePanel.getInputMap().put(KeyStroke.getKeyStroke('w'),"upAction");
        gamePanel.getActionMap().put("upAction",upAction);
        gamePanel.getInputMap().put(KeyStroke.getKeyStroke('s'),"downAction");
        gamePanel.getActionMap().put("downAction",downAction);
        gamePanel.getInputMap().put(KeyStroke.getKeyStroke('a'),"leftAction");
        gamePanel.getActionMap().put("leftAction",leftAction);
        gamePanel.getInputMap().put(KeyStroke.getKeyStroke('d'),"rightAction");
        gamePanel.getActionMap().put("rightAction",rightAction);

        gamePanel.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_W,0,true),"standUp");
        gamePanel.getActionMap().put("standUp",standUp);
        gamePanel.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_S,0,true),"standDown");
        gamePanel.getActionMap().put("standDown",standDown);
        gamePanel.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_A,0,true),"standLeft");
        gamePanel.getActionMap().put("standLeft",standLeft);
        gamePanel.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_D,0,true),"standRight");
        gamePanel.getActionMap().put("standRight",standRight);

        gamePanel.getInputMap().put(KeyStroke.getKeyStroke("SPACE"),"jump");
        gamePanel.getActionMap().put("jump",jump);
        gamePanel.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE,0,true),"fall");
        gamePanel.getActionMap().put("fall",fall);
    }
    // walking
    public class UpAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            gamePanel.getGame().getPlayer().setUp(true);
               //System.out.println("W");
        }
    }
    public class DownAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            gamePanel.getGame().getPlayer().setDown(true);
                //System.out.println("S");
        }
    }
    public class LeftAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            gamePanel.getGame().getPlayer().setLeft(true);
                //System.out.println("A");
        }
    }
    public class RightAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            gamePanel.getGame().getPlayer().setRight(true);
                //System.out.println("D");
        }

    }
    private class Jumping extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            gamePanel.getGame().getPlayer().setJump(true);
            System.out.println("Spacja");
        }
    }

    // standing
    public class StandUp extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            gamePanel.getGame().getPlayer().setUp(false);
        }
    }
    public class StandDown extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            gamePanel.getGame().getPlayer().setDown(false);
        }
    }
    public class StandLeft extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            gamePanel.getGame().getPlayer().setLeft(false);
        }
    }
    public class StandRight extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            gamePanel.getGame().getPlayer().setRight(false);
        }
    }
    public class Falling extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            gamePanel.getGame().getPlayer().setJump(false);
        }
    }

}
