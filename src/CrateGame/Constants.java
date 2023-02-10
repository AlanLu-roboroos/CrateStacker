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
