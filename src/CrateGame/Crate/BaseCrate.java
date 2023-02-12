package CrateGame.Crate;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.lang.Math;

import java.util.ArrayList;

import CrateGame.Constants;

public abstract class BaseCrate {
  private int line;
  private int height;
  private int x;
  private int y;
  private boolean infected;
  private boolean explosionResistence;

  private long fallStartTime;

  private int[] pos;

  public BaseCrate(int line, int height, double startPos) {
    this.line = line;
    this.height = height;

    fallStartTime = System.currentTimeMillis();

    this.x = 93 + (line * 100);
    this.y = (int) Math.round(600 - Constants.Images.CRATE_HEIGHT * startPos);
  }

  public abstract Image getImage();

  public void paint(Graphics g) {
    g.drawImage(getImage(), x - getImage().getWidth(null) / 2, y - getImage().getHeight(null) / 2, null);
    y += Math.pow(System.currentTimeMillis() - fallStartTime, 2) / 10000;
    y = Math.min(y, 600 - getImage().getHeight(null) * height);
  }

  public boolean isMergeable(ArrayList<Crate> crates) {
    if (infected || y != 600 - getImage().getHeight(null) * height) {
      return false;
    }
    return true;
  }

  public abstract Crate nextCrate(int line, int height);

  public abstract int getCrateID();

  public void updatePos(int pos) {
    if (height != pos) {
      fallStartTime = System.currentTimeMillis();
      height = pos;
    }
  }
}
