package CrateGame.Crate;

import java.awt.Image;
import java.awt.Graphics;
import CrateGame.Constants;

public class BlueCrate extends BaseCrate implements Crate {
  private int line;
  private int height;
  private int x;
  private int y;
  private boolean infected;
  private boolean explosionResistence;
  private Image image = Constants.Images.BLUE_IMG;

  private long fallStartTime;

  private int[] pos;

  public BlueCrate(int line, int height, int startPos) {
    super(line, height, startPos);
  }

  @Override
  public Image getImage() {
    return image;
  }

  public Crate nextCrate(int line, int height) {
    System.out.println("BlueCrate.nextCrate");
    return null;
  }

  @Override
  public int getCrateID() {
    return 1;
  }
}
