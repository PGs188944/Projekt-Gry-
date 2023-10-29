
//package Imputs;
//
//import Game.GamePanel;
//
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import static utilz.constants.Directions.*;
//
//public class Keyboardinputs implements KeyListener {
//    final GamePanel gamePanel;
//    public Keyboardinputs(GamePanel gamePanel){
//        this.gamePanel=gamePanel;
//    }
//    @Override
//    public void keyTyped(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//        System.out.println("presed");
//        switch (e.getKeyCode()){
//            case KeyEvent.VK_W:
//                gamePanel.setDirection(UP);
//                System.out.println("W");
//                break;
//            case KeyEvent.VK_A:
//                gamePanel.setDirection(LEFT);
//                System.out.println("A");
//                break;
//            case KeyEvent.VK_S:
//                gamePanel.setDirection(DOWN);
//                System.out.println("S");
//                break;
//            case KeyEvent.VK_D:
//                gamePanel.setDirection(RIGHT);
//                System.out.println("D");
//                break;
//        }
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//        switch (e.getKeyCode()){
//            case KeyEvent.VK_W:
//            case KeyEvent.VK_A:
//            case KeyEvent.VK_S:
//            case KeyEvent.VK_D:
//                gamePanel.setMoving(false);
//                break;
//        }
//    }
//}
