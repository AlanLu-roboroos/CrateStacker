package CrateGame.Crate;

import java.awt.Image;
import java.util.ArrayList;
import java.awt.Graphics;
import CrateGame.Constants;

public class PurpleCrate extends BaseCrate implements Crate {
  private int line;
  private int height;
  private int x;
  private int y;
  private boolean infected;
  private boolean explosionResistence;
  private Image image = Constants.Images.PURPLE_IMG;

  private long fallStartTime;

  private int[] pos;

  public PurpleCrate(int line, int height, double crateSpawnHeight) {
    super(line, height, crateSpawnHeight);
  }

  @Override
  public Image getImage() {
    return image;
  }

  @Override
  public Crate nextCrate(int line, int height) {
    return (new BlueCrate(line, height, height + 1));
  }

  @Override
  public int getCrateID() {
    return 0;
  }
}
