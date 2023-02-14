package CrateGame.Crate;

import java.awt.Image;
import java.util.ArrayList;
import java.awt.Graphics;
import CrateGame.Constants;

public class BombCrate extends BaseCrate implements Crate {
  public int line;
  public int height;
  public int x;
  public int y;
  public boolean infected;
  public boolean explosionResistence;
  public Image image1 = Constants.Images.BOMB_IMG;
  public Image image2 = Constants.Images.BOMB_FLASH_IMG;

  private long fallStartTime;
  private long bombInitTime;

  private int[] pos;

  public BombCrate(int line, int height, double crateSpawnHeight) {
    super(line, height, crateSpawnHeight);
    
    bombInitTime = System.currentTimeMillis();
  }

  @Override
  public Image getImage() {
    return ((System.currentTimeMillis() - bombInitTime) % 1000 > 500) ? image1 : image2;
  }

  @Override
  public Crate nextCrate(int line, int height) {
    return null;
  }

  @Override
  public int getCrateID() {
    return 8;
  }
}
