package CrateGame;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

public final class Constants {
        public static final int WIDTH = 1200;
        public static final int HEIGHT = 800;

        public static final int BORDER_HEIGHT = 80;

        public static final int[][] SPAWN_POS = { { 100, 240 }, { 242, 240 }, { 385, 240 }, { 528, 240 }, { 671, 240 },
                        { 814, 240 }, { 957, 240 }, { 1100, 240 } };

        public static final int[][] PLATFORM_POS = { { 100, 700 }, { 242, 700 }, { 385, 700 }, { 528, 700 },
                        { 671, 700 },
                        { 814, 700 }, { 957, 700 }, { 1100, 700 } };

        public static final double CRATE_SPAWN_HEIGHT = 6.6;
        public static final int MAX_NUM_LINE = 8;
        public static final int CRATES_PER_LINE = 6;
        public static final double CRATE_POS_SPAWNABLE = 6.5;

        public static class Images {
                public static final int CRATE_HEIGHT = 70;
                public static final int CRATE_WIDTH = 70;

                public static final Image PLATFORM_IMG = loadImage("./Textures/objects/platform.png")
                                .getScaledInstance(80, 80, Image.SCALE_DEFAULT);
                public static final Image SPAWN_IMG = loadImage("./Textures/objects/spawn.png")
                                .getScaledInstance(80, 80, Image.SCALE_DEFAULT);

                public static final Image GRABBER_HORIZONTAL_IMG = loadImage("./Textures/grabber/grabberHori.png")
                                .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
                public static final Image GRABBER_VERTICAL_IMG = loadImage("./Textures/grabber/grabberVert.png")
                                .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
                public static final Image GRABBER_LEFT_IMG = loadImage("./Textures/grabber/grabberLeft.png")
                                .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
                public static final Image GRABBER_RIGHT_IMG = loadImage("./Textures/grabber/grabberRigh.png")
                                .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);

                public static final Image PURPLE_IMG = loadImage("./Textures/crates/purple.png")
                                .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
                public static final Image BLUE_IMG = loadImage("./Textures/crates/blue.png")
                                .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
                public static final Image GREEN_IMG = loadImage("./Textures/crates/green.png")
                                .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
                public static final Image YELLOW_IMG = loadImage("./Textures/crates/yellow.png")
                                .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
                public static final Image ORANGE_IMG = loadImage("./Textures/crates/orange.png")
                                .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
                public static final Image RED_IMG = loadImage("./Textures/crates/red.png")
                                .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
                public static final Image PINK_IMG = loadImage("./Textures/crates/pink.png")
                                .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
                public static final Image GOLD_IMG = loadImage("./Textures/crates/gold.png")
                                .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);

                public static final Image BOMB_IMG = loadImage("./Textures/crates/bomb.png")
                                .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
                public static final Image BOMB_FLASH_IMG = loadImage("./Textures/crates/bomb-flash.png")
                                .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);

                public static final Image MEGABOMB_IMG = loadImage("./Textures/crates/megabomb.png")
                                .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
                public static final Image MEGABOMB_FLASH_IMG = loadImage("./Textures/crates/megabomb-flash.png")
                                .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);

                public static final Image HYPERBOMB_IMG = loadImage("./Textures/crates/hyperbomb.png")
                                .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
                public static final Image HYPERBOMB_FLASH_IMG = loadImage("./Textures/crates/hyperbomb-flash.png")
                                .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);

                public static final Image HEAVY_IMG = loadImage("./Textures/crates/heavy.png")
                                .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
                public static final Image UNBREAKABLE_IMG = loadImage("./Textures/crates/unbreakable.png")
                                .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);

                public static final Image MULTICOLOR_IMG = loadImage("./Textures/crates/multicolor.png")
                                .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);

                public static final Image VIRUS_IMG = loadImage("./Textures/crates/virus.png")
                                .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);

                public static final Image ITEM0_IMG = loadImage("./Textures/items/item0.png")
                                .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
                public static final Image ITEM1_IMG = loadImage("./Textures/items/item1.png")
                                .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
                public static final Image ITEM2_IMG = loadImage("./Textures/items/item2.png")
                                .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
        }

        public static Image loadImage(String path) {
                try {
                        return ImageIO.read(new File(path));
                } catch (IOException e) {
                        e.printStackTrace();
                        System.exit(0);
                        return null;
                }
        }
}
