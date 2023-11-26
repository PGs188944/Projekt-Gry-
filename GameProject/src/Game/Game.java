package Game;

import entities.Player;
import levels.LevelManager;

import java.awt.*;

public class Game implements Runnable {
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS_set = 120; //wartosc nie może być zmieniona
    private final int UPS_set=200;
    private Player player;
    public final static int  TILES_DEFAULT_SIZE = 32;
    public final static float SCALE = 1.5f;
    public final static int TILES_IN_WIDTH = 26;
    public final static int TILES_IN_HEIGHT = 14;
    public final static int TITLES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);
    public  final static int GAME_WIDTH = TITLES_SIZE * TILES_IN_WIDTH;
    public  final static int GAME_HEIGHT = TITLES_SIZE * TILES_IN_HEIGHT;
    private LevelManager levelManager;


    public Game() {
        initClasses();
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();

        startGameloop();
    }

    private void initClasses() {
        levelManager = new LevelManager(this);
        player = new Player(200,200, (int) (64*SCALE),(int) (64*SCALE));
        player.loadLvlData(levelManager.getCurrentLevel().getLvlData());
    }

    private void startGameloop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update() {
        player.update();
        levelManager.update();
    }

    public void render(Graphics g){
        levelManager.draw(g);
        player.render(g);
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
    public Player getPlayer(){
        return player;
    }

    public void windowFocusLost() {
        player.resetDirBooleans();
    }
}
