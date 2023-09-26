package CrateGame.Crate;

import java.awt.Image;
import java.util.ArrayList;
import java.awt.Graphics;
import CrateGame.Constants;

import java.util.Arrays;
import java.util.function.Predicate;

import javax.swing.event.SwingPropertyChangeSupport;

public class BombCrate extends BaseCrate implements Crate, ExplodableCrate {
  public Image image1 = Constants.Images.BOMB_IMG;
  public Image image2 = Constants.Images.BOMB_FLASH_IMG;
  public boolean exploded = false;

  private long bombInitTime;

  public BombCrate(int line, int height, double crateSpawnHeight) {
    super(line, height, crateSpawnHeight);

    bombInitTime = System.currentTimeMillis();
  }

  @Override
  public Image getImage() {
    return ((System.currentTimeMillis() - bombInitTime) % 600 > 300) ? image1 : image2;
  }

  @Override
  public Crate nextCrate(int line, int height) {
    return null;
  }

  @Override
  public void paint(Graphics g, int isHeld) {
    super.paint(g, 0);
  }

  public void explode(ArrayList<ArrayList<Crate>> crates) {
    if (!exploded && System.currentTimeMillis() - bombInitTime > 5000) {
      exploded = true;
      crates.get(line).removeIf(new Predicate<Crate>() {
        @Override
        public boolean test(Crate arg0) {
          int idx = crates.get(line).indexOf(arg0);
          if (idx == height + 1 || idx == height - 1 || idx == height) {
            if (arg0.getY() == Constants.PLATFORM_POS[0][1] - getImage().getHeight(null) * idx && arg0.explodable())
              return true;
          }
          return false;
        }

      });
    }
  }

  @Override
  public int getCrateID() {
    return 8;
  }
}
