package CrateGame;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

public final class Constants {
  public static final int WIDTH = 1000;
  public static final int HEIGHT = 700;

  public static final int[][] SPAWN_POS = { { 93, 100 }, { 193, 100 }, { 293, 100 }, { 393, 100 }, { 493, 100 },
      { 593, 100 }, { 693, 100 }, { 793, 100 }, { 893, 100 } };

  public static final int[][] PLATFORM_POS = { { 93, 600 }, { 193, 600 }, { 293, 600 }, { 393, 600 }, { 493, 600 },
      { 593, 600 }, { 693, 600 }, { 793, 600 }, { 893, 600 } };

  public static final Image PLATFORM_IMG = loadImage("./Textures/objects/platform.png")
      .getScaledInstance(80, 80,
          Image.SCALE_DEFAULT);
  public static final Image SPAWN_IMG = loadImage("./Textures/objects/spawn.png")
      .getScaledInstance(80, 80, Image.SCALE_DEFAULT);

  public static final Image GRABBER_HORIZONTAL_IMG = loadImage("./Textures/grabber/grabberHori.png")
      .getScaledInstance(80, 80, Image.SCALE_DEFAULT);
  public static final Image GRABBER_VERTICAL_IMG = loadImage("./Textures/grabber/grabberVert.png")
      .getScaledInstance(80, 80, Image.SCALE_DEFAULT);
  public static final Image GRABBER_LEFT_IMG = loadImage("./Textures/grabber/grabberLeft.png")
      .getScaledInstance(80, 80, Image.SCALE_DEFAULT);
  public static final Image GRABBER_RIGHT_IMG = loadImage("./Textures/grabber/grabberRigh.png")
      .getScaledInstance(80, 80, Image.SCALE_DEFAULT);

  public static final Image PURPLE_IMG = loadImage("./Textures/crates/purple.png")
      .getScaledInstance(80, 80, Image.SCALE_DEFAULT);
  public static final Image BLUE_IMG = loadImage("./Textures/crates/blue.png")
      .getScaledInstance(80, 80, Image.SCALE_DEFAULT);
  public static final Image GREEN_IMG = loadImage("./Textures/crates/green.png")
      .getScaledInstance(80, 80, Image.SCALE_DEFAULT);
  public static final Image YELLOW_IMG = loadImage("./Textures/crates/yellow.png")
      .getScaledInstance(80, 80, Image.SCALE_DEFAULT);
  public static final Image ORANGE_IMG = loadImage("./Textures/crates/orange.png")
      .getScaledInstance(80, 80, Image.SCALE_DEFAULT);
  public static final Image RED_IMG = loadImage("./Textures/crates/red.png")
      .getScaledInstance(80, 80, Image.SCALE_DEFAULT);
  public static final Image PINK_IMG = loadImage("./Textures/crates/pink.png")
      .getScaledInstance(80, 80, Image.SCALE_DEFAULT);
  public static final Image GOLD_IMG = loadImage("./Textures/crates/gold.png")
      .getScaledInstance(80, 80, Image.SCALE_DEFAULT);

  public static final Image BOMB_IMG = loadImage("./Textures/crates/bomb.png")
      .getScaledInstance(80, 80, Image.SCALE_DEFAULT);
  public static final Image BOMB_FLASH_IMG = loadImage("./Textures/crates/bomb-flash.png")
      .getScaledInstance(80, 80, Image.SCALE_DEFAULT);

  public static final Image MEGABOMB_IMG = loadImage("./Textures/crates/megabomb.png")
      .getScaledInstance(80, 80, Image.SCALE_DEFAULT);
  public static final Image MEGABOMB_FLASH_IMG = loadImage("./Textures/crates/megabomb-flash.png")
      .getScaledInstance(80, 80, Image.SCALE_DEFAULT);

  public static final Image HYPERBOMB_IMG = loadImage("./Textures/crates/hyperbomb.png")
      .getScaledInstance(80, 80, Image.SCALE_DEFAULT);
  public static final Image HYPERBOMB_FLASH_IMG = loadImage("./Textures/crates/hyperbomb-flash.png")
      .getScaledInstance(80, 80, Image.SCALE_DEFAULT);

  public static final Image HEAVY_IMG = loadImage("./Textures/crates/heavy.png")
      .getScaledInstance(80, 80, Image.SCALE_DEFAULT);
  public static final Image UNBREAKABLE_IMG = loadImage("./Textures/crates/unbreakable.png")
      .getScaledInstance(80, 80, Image.SCALE_DEFAULT);

  public static final Image MULTICOLOR_IMG = loadImage("./Textures/crates/multicolor.png")
      .getScaledInstance(80, 80, Image.SCALE_DEFAULT);

  public static final Image VIRUS_IMG = loadImage("./Textures/crates/virus.png")
      .getScaledInstance(80, 80, Image.SCALE_DEFAULT);

  public static final Image ITEM0_IMG = loadImage("./Textures/items/item0.png")
      .getScaledInstance(80, 80, Image.SCALE_DEFAULT);
  public static final Image ITEM1_IMG = loadImage("./Textures/items/item1.png")
      .getScaledInstance(80, 80, Image.SCALE_DEFAULT);
  public static final Image ITEM2_IMG = loadImage("./Textures/items/item2.png")
      .getScaledInstance(80, 80, Image.SCALE_DEFAULT);

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
