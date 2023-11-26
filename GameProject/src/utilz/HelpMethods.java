package utilz;

import Game.Game;

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

        if (value >= 48 || value < 0 || value != 11)
            return true;
        return false;
    }
}
