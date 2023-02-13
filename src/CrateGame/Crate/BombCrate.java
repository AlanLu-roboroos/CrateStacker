package CrateGame.Crate;

import java.awt.Image;
import java.util.ArrayList;
import java.awt.Graphics;
import CrateGame.Constants;

public class BombCrate extends BaseCrate implements Crate {
  private int line;
  private int height;
  private int x;
  private int y;
  private boolean infected;
  private boolean explosionResistence;
  private Image image1 = Constants.Images.BOMB_IMG;
  private Image image2 = Constants.Images.BOMB_FLASH_IMG;

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
