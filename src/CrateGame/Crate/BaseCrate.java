package CrateGame.Crate;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.lang.Math;

import java.util.ArrayList;

import CrateGame.Constants;

public abstract class BaseCrate implements Crate {
  public int line;
  public int height;
  public int x;
  public int y;
  public boolean infected;
  public boolean explosionResistence;

  private long fallStartTime;

  private int[] pos;

  public BaseCrate(int line, int height, double startPos) {
    this.line = line;
    this.height = height;

    fallStartTime = System.currentTimeMillis();

    this.x = Constants.SPAWN_POS[line][0];
    this.y = (int) Math.round(Constants.PLATFORM_POS[0][1] - Constants.Images.CRATE_HEIGHT * startPos);
  }

  public abstract Image getImage();

  public void setColumn(int column) {
    this.x = Constants.SPAWN_POS[column][0];
  }

  public void setHeight(int pheight, int height) {
    this.y = pheight;
    this.height = height;
  }

  public void paint(Graphics g, int isHeld) {
    g.drawImage(getImage(), x - getImage().getWidth(null) / 2, y - getImage().getHeight(null) / 2, null);
    if (isHeld == 0)
      y += Math.pow(System.currentTimeMillis() - fallStartTime, 2) / 60000;
    else
      y += Constants.GRABBER_SPEED * isHeld;
    y = Math.max(Math.min(y, Constants.PLATFORM_POS[0][1] - getImage().getHeight(null) * height), 160);
  }

  public boolean isMergeable(ArrayList<Crate> crates) {
    if (infected || y != Constants.PLATFORM_POS[0][1] - getImage().getHeight(null) * height) {
      return false;
    }
    return true;
  }

  public abstract Crate nextCrate(int line, int height);

  public abstract int getCrateID();

  @Override
  public void updatePos(int pos) {
    if (height != pos) {
      fallStartTime = System.currentTimeMillis();
      height = pos;
    }
  }

  @Override
  public boolean lineSpawnable() {
    if (this.y > 600 - Constants.CRATE_POS_SPAWNABLE * Constants.Images.CRATE_HEIGHT) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean spawnable() {
    return true;
  }

  @Override
  public boolean isLiftable() {
    return true;
  }

  @Override
  public int getX() {
    return x;
  }

  @Override
  public int getY() {
    return y;
  }
}
