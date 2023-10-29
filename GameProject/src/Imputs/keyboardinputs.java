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
    }
    // walking
    public class UpAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            gamePanel.setDirection(UP);
                System.out.println("W");
        }
    }
    public class DownAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            gamePanel.setDirection(DOWN);
                System.out.println("S");
        }
    }
    public class LeftAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            gamePanel.setDirection(LEFT);
                System.out.println("A");
        }
    }
    public class RightAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            gamePanel.setDirection(RIGHT);
                System.out.println("D");
        }

    }
    // standing
    public class StandUp extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            gamePanel.setMoving(false);
        }
    }
    public class StandDown extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            gamePanel.setMoving(false);
        }
    }
    public class StandLeft extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            gamePanel.setMoving(false);
        }
    }
    public class StandRight extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            gamePanel.setMoving(false);
        }
    }
}
