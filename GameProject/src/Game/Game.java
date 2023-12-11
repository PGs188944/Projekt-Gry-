package Game;

import gamestates.Gamestate;
import gamestates.Menu;
import gamestates.Playing;


import java.awt.*;

public class Game implements Runnable {
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS_set = 120; //wartosc nie może być zmieniona
    private final int UPS_set=150;

    private Playing playing;
    private Menu menu;

    public final static int  TILES_DEFAULT_SIZE = 32;
    public final static float SCALE = 1.5f;
    public final static int TILES_IN_WIDTH = 26;
    public final static int TILES_IN_HEIGHT = 14;
    public final static int TITLES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);
    public  final static int GAME_WIDTH = TITLES_SIZE * TILES_IN_WIDTH;
    public  final static int GAME_HEIGHT = TITLES_SIZE * TILES_IN_HEIGHT;



    public Game() {
        initClasses();
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();

        startGameloop();
    }

    private void initClasses() {
        menu = new Menu(this);
        playing = new Playing(this);
    }

    private void startGameloop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update() {

        switch (Gamestate.state){

            case PLAYING:
                playing.update();
                break;
            case MENU:
                menu.update();
                break;
            case OPTIONS:
                menu.update();
                break;
            case QUIT:
                System.exit(0);
                break;

        }
    }

    public void render(Graphics g){

        switch (Gamestate.state){

            case PLAYING:
                playing.draw(g);
                break;
            case MENU:
                menu.draw(g);
                break;
        }
    }

    @Override
    //game loop
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_set; //sprawdza ile trwa każdy frame, w nano sec
        double timePerUpdate = 1000000000.0 / UPS_set;
        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        while (true) {

            long currentTime = System.nanoTime();

            deltaU += (currentTime- previousTime)/timePerUpdate;
            deltaF += (currentTime- previousTime)/timePerFrame;
            previousTime = currentTime;

            if(deltaU >= 1){
                update();
                updates++;
                deltaU--;
            }
            if(deltaF >= 1){
                gamePanel.repaint();
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }

    public void windowFocusLost() {
        if(Gamestate.state == Gamestate.PLAYING)
            playing.getPlayer().resetDirBooleans();
    }

    public Menu getMenu() {
        return menu;
    }

    public Playing getPlaying() {
        return playing;
    }
}
