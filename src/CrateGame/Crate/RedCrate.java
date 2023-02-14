package CrateGame.Crate;

import java.awt.Image;
import java.awt.Graphics;
import CrateGame.Constants;

public class RedCrate extends BaseCrate implements Crate {
  public int line;
  public int height;
  public int x;
  public int y;
  public boolean infected;
  public boolean explosionResistence;
  public Image image = Constants.Images.RED_IMG;

  private long fallStartTime;

  private int[] pos;

  public RedCrate(int line, int height, double startPos) {
    super(line, height, startPos);
  }

  @Override
  public Image getImage() {
    return image;
  }

  public Crate nextCrate(int line, int height) {
    return (new PinkCrate(line, height, height + 1));
  }

  @Override
  public int getCrateID() {
    return 5;
  }
}
