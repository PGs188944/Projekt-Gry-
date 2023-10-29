package utilz;

public class constants {

    public static class Directions{
        public static final int UP = 0;
        public static final int DOWN = 1;
        public static final int LEFT = 2;
        public static final int RIGHT = 3;

    }

    public static class PlayerConstants {
        public static final int stand_R = 19;
        public static final int stand_D = 18;
        public static final int stand_L = 17;
        public static final int stand_U = 16;
        public static final int jump_R = 15;
        public static final int jump_L = 13;
        public static final int walking_R = 11;
        public static final int walking_D = 10;
        public static final int walking_L = 9;
        public static final int walking_U = 8;

        public static int GetSpriteAmount(int player_action) {
            switch (player_action) {
                case walking_D:
                case walking_L:
                case walking_R:
                case walking_U:
                    return 11;
                case jump_L:
                case jump_R:
                    return 12;
                case stand_L:
                case stand_R:
                case stand_D:
                case stand_U:

                default:
                    return 1;
            }
        }
    }
}

