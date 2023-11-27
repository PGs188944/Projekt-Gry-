package utilz;

public class constants {

    public static class Directions{
        public static final int UP = 0;
        public static final int DOWN = 1;
        public static final int LEFT = 2;
        public static final int RIGHT = 3;

    }

    public static class PlayerConstants {
        public static final int stand_R = 3;
        public static final int stand_D = 2;
        public static final int stand_L = 1;
        public static final int stand_U = 0;
        public static final int attack_U = 12;
        public static final int attack_L = 13;
        public static final int attack_D = 14;
        public static final int attack_R = 15;
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
                    return 10;
                case attack_U:
                case attack_L:
                case attack_R:
                case attack_D:
                    return 6;
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

