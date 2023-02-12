package CrateGame.Crate;

import java.awt.Image;
import java.awt.Graphics;
import CrateGame.Constants;

public class OrangeCrate extends BaseCrate implements Crate {
  private int line;
  private int height;
  private int x;
  private int y;
  private boolean infected;
  private boolean explosionResistence;
  private Image image = Constants.Images.ORANGE_IMG;

  private long fallStartTime;

  private int[] pos;

  public OrangeCrate(int line, int height, double startPos) {
    super(line, height, startPos);
  }

  @Override
  public Image getImage() {
    return image;
  }

  public Crate nextCrate(int line, int height) {
    return (new RedCrate(line, height, height + 1));
  }

  @Override
  public int getCrateID() {
    return 4;
  }
}
