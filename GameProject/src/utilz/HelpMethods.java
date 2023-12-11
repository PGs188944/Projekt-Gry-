package utilz;

import Game.Game;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class HelpMethods {
    public static boolean CanMoveHere(float x, float y, float width, float height, int[][] lvlDeta) {
        if (!IsSolid(x, y, lvlDeta))
            if (!IsSolid(x + width, y + height, lvlDeta)) //prawy dół
                if (!IsSolid(x + width, y, lvlDeta)) //prawa góra
                    if (!IsSolid(x, y + height, lvlDeta)) // lewy dół
                        return true;
        return false;
    }

    private static boolean IsSolid(float x, float y, int[][] lvlData) {
        if (x < 0 || x >= Game.GAME_WIDTH)
            return true;
        if (y < 0 || y >= Game.GAME_HEIGHT)
            return true;
        float xIndex = x / Game.TITLES_SIZE;
        float yIndex = y / Game.TITLES_SIZE;

        int value = lvlData[(int) yIndex][(int) xIndex];

        if (value != 11)
            return true;
        return false;
    }

    public static float GetEntityXPosNextToWall(Rectangle2D.Float hitbox, float xSpeed, int[][] lvlData) {
        int currentTile = (int) (hitbox.x / Game.TITLES_SIZE);
        int currentHalfTile = (int) (2 * hitbox.x / Game.TITLES_SIZE);
        if (xSpeed > 0) {
            // Prawo
            int tileXpos = currentTile * Game.TITLES_SIZE;
            int xOffset = (int) (Game.TITLES_SIZE - hitbox.width);
            return tileXpos + xOffset - 1;
        } else {
            // Lewo
            return currentTile * Game.TITLES_SIZE;
        }
    }

    public static float GetEntityYPosOustideMap(Rectangle2D.Float hitbox, float airSpeed, int[][] lvlData) {
        int currentTile = (int) (hitbox.y / Game.TITLES_SIZE);
        if (airSpeed > 0) {
            // Upadanie
            int tileYpos = currentTile * Game.TITLES_SIZE;
            int yOffset = (int) (Game.TITLES_SIZE - hitbox.height);
            return tileYpos + yOffset +47;
        } else {
            // Skok
            return currentTile * Game.TITLES_SIZE;
        }
    }

    public static boolean IsEntityOnFloor(Rectangle2D.Float hitbox, int[][] lvlData) {
        // Dolne rogi
        if (!IsSolid(hitbox.x, hitbox.y + hitbox.height + 1, lvlData)){
            if (!IsSolid(hitbox.x + hitbox.width, hitbox.y + hitbox.height + 1, lvlData))
                return false;
        }
        return true;

    }
}
