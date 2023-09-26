package CrateGame;

import javax.imageio.ImageIO;

import java.awt.Image;
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
  public static final long GRABBER_SPEED = 10000;// 10000;

  public static class Images {
    public static int CRATE_HEIGHT = 70;
    public static int CRATE_WIDTH = 70;

    public static Image PLATFORM_IMG = loadImage("CrateGame/Textures/objects/platform.png")
        .getScaledInstance(80, 80, Image.SCALE_DEFAULT);
    public static Image SPAWN_IMG = loadImage("CrateGame/Textures/objects/spawn.png")
        .getScaledInstance(100, 100, Image.SCALE_DEFAULT);

    public static Image GRABBER_HORIZONTAL_IMG = loadImage(
        "CrateGame/Textures/grabber/grabberHori.png")
            .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
    public static Image GRABBER_VERTICAL_IMG = loadImage("CrateGame/Textures/grabber/grabberVert.png")
        .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
    public static Image GRABBER_LEFT_IMG = loadImage("CrateGame/Textures/grabber/grabberLeft.png")
        .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
    public static Image GRABBER_RIGHT_IMG = loadImage("CrateGame/Textures/grabber/grabberRigh.png")
        .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);

    public static Image PURPLE_IMG = loadImage("CrateGame/Textures/crates/purple.png")
        .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
    public static Image BLUE_IMG = loadImage("CrateGame/Textures/crates/blue.png")
        .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
    public static Image GREEN_IMG = loadImage("CrateGame/Textures/crates/green.png")
        .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
    public static Image YELLOW_IMG = loadImage("CrateGame/Textures/crates/yellow.png")
        .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
    public static Image ORANGE_IMG = loadImage("CrateGame/Textures/crates/orange.png")
        .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
    public static Image RED_IMG = loadImage("CrateGame/Textures/crates/red.png")
        .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
    public static Image PINK_IMG = loadImage("CrateGame/Textures/crates/pink.png")
        .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
    public static Image GOLD_IMG = loadImage("CrateGame/Textures/crates/gold.png")
        .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);

    public static Image BOMB_IMG = loadImage("CrateGame/Textures/crates/bomb.png")
        .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
    public static Image BOMB_FLASH_IMG = loadImage("CrateGame/Textures/crates/bomb-flash.png")
        .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);

    public static Image MEGABOMB_IMG = loadImage("CrateGame/Textures/crates/megabomb.png")
        .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
    public static Image MEGABOMB_FLASH_IMG = loadImage("CrateGame/Textures/crates/megabomb-flash.png")
        .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);

    public static Image HYPERBOMB_IMG = loadImage("CrateGame/Textures/crates/hyperbomb.png")
        .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
    public static Image HYPERBOMB_FLASH_IMG = loadImage(
        "CrateGame/Textures/crates/hyperbomb-flash.png")
            .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);

    public static Image HEAVY_IMG = loadImage("CrateGame/Textures/crates/heavy.png")
        .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
    public static Image UNBREAKABLE_IMG = loadImage("CrateGame/Textures/crates/unbreakable.png")
        .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);

    public static Image MULTICOLOR_IMG = loadImage("CrateGame/Textures/crates/multicolor.png")
        .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);

    public static Image VIRUS_IMG = loadImage("CrateGame/Textures/crates/virus.png")
        .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);

    public static Image ITEM0_IMG = loadImage("CrateGame/Textures/items/item0.png")
        .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
    public static Image ITEM1_IMG = loadImage("CrateGame/Textures/items/item1.png")
        .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);
    public static Image ITEM2_IMG = loadImage("CrateGame/Textures/items/item2.png")
        .getScaledInstance(CRATE_HEIGHT, CRATE_WIDTH, Image.SCALE_DEFAULT);

    public static Image loadImage(String path) {
      try {
        // return ImageIO.read(new File(path));
        return ImageIO.read(Constants.class.getClassLoader().getResource(path));
      } catch (IOException e) {
        e.printStackTrace();
        return null;
      }
    }
  }
}
