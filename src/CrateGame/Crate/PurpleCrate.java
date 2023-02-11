package CrateGame.Crate;

import java.awt.Image;
import java.awt.Graphics;
import CrateGame.Constants;

public class PurpleCrate implements Crate {
  private int line;
  private int height;
  private int x;
  private int y;
  private boolean infected;
  private boolean explosionResistence;
  private Image image = Constants.PURPLE_IMG;

  private long fallStartTime;

  private int[] pos;

  public PurpleCrate(int line, int height) {
    this.line = line;
    this.height = height;

    fallStartTime = System.currentTimeMillis();

    this.x = 93 + (line * 100);
    this.y = 100;
  }

  public void paint(Graphics g) {
    g.drawImage(image, x - image.getWidth(null) / 2, y - image.getHeight(null) / 2, null);
    y += Math.pow(System.currentTimeMillis() - fallStartTime, 2) / 10000;
    y = Math.min(y, 600 - image.getHeight(null) * height);
  }

}
