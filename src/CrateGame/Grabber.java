package CrateGame;

import java.awt.Image;
import java.util.ArrayList;

import CrateGame.Crate.Crate;

import java.awt.Graphics;

public class Grabber {
  public int x, y;
  public Image Left, Right, Horizontal, Vertical;

  public long startTime;

  public Crate heldCrate = null;

  public ArrayList<ArrayList<Crate>> crates;

  public enum State {
    STANDBY,
    RAISING,
    LOWERING
  }

  public State state = State.STANDBY;

  public double currColumn = 3.5;
  public int currHeight = -1;

  public Grabber(ArrayList<ArrayList<Crate>> crates) {
    x = Constants.WIDTH / 2;
    y = Constants.BORDER_HEIGHT;

    this.crates = crates;

    Left = Constants.Images.GRABBER_LEFT_IMG;
    Right = Constants.Images.GRABBER_RIGHT_IMG;
    Horizontal = Constants.Images.GRABBER_HORIZONTAL_IMG;
    Vertical = Constants.Images.GRABBER_VERTICAL_IMG;

    startTime = 0;
  }

  public void goTo(int column) {
    if (state == State.STANDBY) {
        currColumn = column;
        currHeight = crates.get(column).size();
        state = State.LOWERING;
    }
  }

  public void paint(Graphics g) {
    if (state == State.STANDBY) {
        y = Constants.BORDER_HEIGHT;
    } else if (state == State.RAISING) {
        if (y < Constants.BORDER_HEIGHT) {
            state = State.STANDBY;
        } else {
            y -= Constants.GRABBER_SPEED;
        }
    } else if (state == State.LOWERING) {
        if (heldCrate == null && y > currHeight || heldCrate != null && y > heldCrate.getY()) {
            state = State.RAISING;
            int crateHeight = crates.get((int)currColumn).size() - 1;
            if (heldCrate == null) {
                if (crateHeight >= 0) {
                    if (heldCrate == null) {
                        heldCrate = crates.get((int)currColumn).get(crateHeight);
                        crates.get((int)currColumn).remove(crateHeight);
                    }
                }
            } else {
                if (crates.get((int)currColumn).size() < 6) {
                    heldCrate.setColumn((int)currColumn);
                    heldCrate.setHeight(currHeight);
                    crates.get((int)currColumn).add(heldCrate);
                    heldCrate = null;
                }
            }
        } else {
            y += Constants.GRABBER_SPEED;
        }
    }


    x = (int) (currColumn * 143 + 100);
    g.drawImage(Vertical.getScaledInstance(80, Math.max(y - Constants.BORDER_HEIGHT + 30, 30), Image.SCALE_DEFAULT), x - 40, y, null);
    if (heldCrate == null) {
        g.drawImage(Horizontal.getScaledInstance(100, 80, Image.SCALE_DEFAULT), x - 50, y + 30, null);
        g.drawImage(Left, x - Constants.Images.CRATE_WIDTH / 2 - 85, y + 21, null);
        g.drawImage(Right, x - Constants.Images.CRATE_WIDTH / 2 + 85, y + 21, null);
    } else {
        g.drawImage(Horizontal, x - 35, y + 30, null);
        g.drawImage(Left, x - Constants.Images.CRATE_WIDTH / 2 - 70, y + 21, null);
        g.drawImage(Right, x - Constants.Images.CRATE_WIDTH / 2 + 70, y + 21, null);
    }
    if (heldCrate != null) {
        g.drawImage(heldCrate.getImage(), x- Constants.Images.CRATE_WIDTH / 2, y + 45, null);
    }
  }

}
