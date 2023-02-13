package CrateGame;

import java.awt.Image;
import java.util.ArrayList;

import CrateGame.Crate.Crate;

import java.awt.Graphics;

public class Grabber {
  public int x, y;
  public Image Left, Right, Horizontal, Vertical;

  public long startTime;

  public enum State {
    STANDBY_EMPTY,
    STANDBY,
    RAISING_EMPTY,
    RAISING,
    LOWERING_EMPTY,
    LOWERING
  }

  public State state = State.STANDBY_EMPTY;
  public double currColumn = 4.5;

  public int currHeight = -1;
  public boolean succesfull;

  public Grabber() {
    x = Constants.WIDTH / 2;
    y = Constants.BORDER_HEIGHT;

    Left = Constants.Images.GRABBER_LEFT_IMG;
    Right = Constants.Images.GRABBER_RIGHT_IMG;
    Horizontal = Constants.Images.GRABBER_HORIZONTAL_IMG;
    Vertical = Constants.Images.GRABBER_VERTICAL_IMG;

    startTime = 0;
  }

  public boolean goTo(int column, int height, boolean succesfull) {
    if (state == State.STANDBY_EMPTY || state == State.STANDBY) {
      currColumn = column;
      currHeight = height;
      y = Constants.BORDER_HEIGHT;
      startTime = System.currentTimeMillis();
      this.succesfull = succesfull;
      if (state == State.STANDBY_EMPTY) {
        state = State.LOWERING_EMPTY;
      } else {
        state = State.LOWERING;
      }
      return true;
    } else {
      return false;
    }
  }

  public void paint(Graphics g, ArrayList<ArrayList<Crate>> crates) {
    switch (state) {
      case STANDBY_EMPTY:
        g.drawImage(
            Horizontal.getScaledInstance(Constants.Images.CRATE_WIDTH + 30, Constants.Images.CRATE_WIDTH,
                Image.SCALE_DEFAULT),
            (int) (100 + 143 * (currColumn - 1) - (Constants.Images.CRATE_WIDTH + 30) / 2),
            Constants.BORDER_HEIGHT + 30,
            null);
        g.drawImage(
            Vertical.getScaledInstance(Constants.Images.CRATE_WIDTH, Math.max(y - Constants.BORDER_HEIGHT + 30, 30),
                Image.SCALE_DEFAULT),
            (int) (100 + 143 * (currColumn - 1) - Constants.Images.CRATE_WIDTH / 2), Constants.BORDER_HEIGHT, null);
        g.drawImage(Left, (int) (100 + 143 * (currColumn - 1) - 80 - Constants.Images.CRATE_WIDTH / 2),
            Constants.BORDER_HEIGHT + 21, null);
        g.drawImage(Right, (int) (100 + 143 * (currColumn - 1) + 80 - Constants.Images.CRATE_WIDTH / 2),
            Constants.BORDER_HEIGHT + 21, null);
        break;
      case STANDBY:
        g.drawImage(Horizontal, (int) (100 + 143 * (currColumn - 1) - Constants.Images.CRATE_WIDTH / 2),
            Constants.BORDER_HEIGHT + 30,
            null);
        g.drawImage(
            Vertical.getScaledInstance(Constants.Images.CRATE_WIDTH, Math.max(y - Constants.BORDER_HEIGHT + 30, 30),
                Image.SCALE_DEFAULT),
            (int) (100 + 143 * (currColumn - 1) - Constants.Images.CRATE_WIDTH / 2), Constants.BORDER_HEIGHT, null);
        g.drawImage(Left, (int) (100 + 143 * (currColumn - 1) - 70 - Constants.Images.CRATE_WIDTH / 2),
            Constants.BORDER_HEIGHT + 21, null);
        g.drawImage(Right, (int) (100 + 143 * (currColumn - 1) + 70 - Constants.Images.CRATE_WIDTH / 2),
            Constants.BORDER_HEIGHT + 21, null);
        break;
      case RAISING_EMPTY:
        g.drawImage(
            Horizontal.getScaledInstance(Constants.Images.CRATE_WIDTH + 30, Constants.Images.CRATE_WIDTH,
                Image.SCALE_DEFAULT),
            (int) (100 + 143 * (currColumn - 1) - (Constants.Images.CRATE_WIDTH + 30) / 2),
            y + Constants.BORDER_HEIGHT + 30,
            null);
        g.drawImage(
            Vertical.getScaledInstance(Constants.Images.CRATE_WIDTH, Math.max(y - Constants.BORDER_HEIGHT + 30, 30),
                Image.SCALE_DEFAULT),
            (int) (100 + 143 * (currColumn - 1) - Constants.Images.CRATE_WIDTH / 2), Constants.BORDER_HEIGHT, null);
        g.drawImage(Left, (int) (100 + 143 * (currColumn - 1) - 80 - Constants.Images.CRATE_WIDTH / 2),
            y + Constants.BORDER_HEIGHT + 21, null);
        g.drawImage(Right, (int) (100 + 143 * (currColumn - 1) + 80 - Constants.Images.CRATE_WIDTH / 2),
            y + Constants.BORDER_HEIGHT + 21, null);

        y -= (int) (Constants.GRABBER_SPEED);

        if (y <= Constants.BORDER_HEIGHT)
          state = State.STANDBY_EMPTY;
        break;
      case RAISING:
        g.drawImage(
            Horizontal.getScaledInstance(Constants.Images.CRATE_WIDTH + 30, Constants.Images.CRATE_WIDTH,
                Image.SCALE_DEFAULT),
            (int) (100 + 143 * (currColumn - 1) - (Constants.Images.CRATE_WIDTH + 30) / 2),
            y + Constants.BORDER_HEIGHT + 30,
            null);
        g.drawImage(
            Vertical.getScaledInstance(Constants.Images.CRATE_WIDTH, Math.max(y - Constants.BORDER_HEIGHT + 30, 30),
                Image.SCALE_DEFAULT),
            (int) (100 + 143 * (currColumn - 1) - Constants.Images.CRATE_WIDTH / 2), Constants.BORDER_HEIGHT, null);
        g.drawImage(Left, (int) (100 + 143 * (currColumn - 1) - 70 - Constants.Images.CRATE_WIDTH / 2),
            y + Constants.BORDER_HEIGHT + 21, null);
        g.drawImage(Right, (int) (100 + 143 * (currColumn - 1) + 70 - Constants.Images.CRATE_WIDTH / 2),
            y + Constants.BORDER_HEIGHT + 21, null);

        y -= (int) (Constants.GRABBER_SPEED);

        if (y <= Constants.BORDER_HEIGHT)
          state = State.STANDBY;
        break;
      case LOWERING_EMPTY:
        g.drawImage(
            Horizontal.getScaledInstance(Constants.Images.CRATE_WIDTH + 30, Constants.Images.CRATE_WIDTH,
                Image.SCALE_DEFAULT),
            (int) (100 + 143 * (currColumn - 1) - (Constants.Images.CRATE_WIDTH + 30) / 2),
            y + Constants.BORDER_HEIGHT + 30,
            null);
        g.drawImage(
            Vertical.getScaledInstance(Constants.Images.CRATE_WIDTH, Math.max(y - Constants.BORDER_HEIGHT + 30, 30),
                Image.SCALE_DEFAULT),
            (int) (100 + 143 * (currColumn - 1) - Constants.Images.CRATE_WIDTH / 2), Constants.BORDER_HEIGHT, null);
        g.drawImage(Left, (int) (100 + 143 * (currColumn - 1) - 80 - Constants.Images.CRATE_WIDTH / 2),
            y + Constants.BORDER_HEIGHT + 21, null);
        g.drawImage(Right, (int) (100 + 143 * (currColumn - 1) + 80 - Constants.Images.CRATE_WIDTH / 2),
            y + Constants.BORDER_HEIGHT + 21, null);

        y += (int) (Constants.GRABBER_SPEED);

        if (y + Constants.BORDER_HEIGHT + 41 >= Constants.PLATFORM_POS[0][1]
            - currHeight * Constants.Images.CRATE_HEIGHT) {
          state = (succesfull) ? State.RAISING : State.RAISING_EMPTY;
        }
        break;
      case LOWERING:
        g.drawImage(
            Horizontal.getScaledInstance(Constants.Images.CRATE_WIDTH + 30, Constants.Images.CRATE_WIDTH,
                Image.SCALE_DEFAULT),
            (int) (100 + 143 * (currColumn - 1) - (Constants.Images.CRATE_WIDTH + 30) / 2),
            y + Constants.BORDER_HEIGHT + 30,
            null);
        g.drawImage(
            Vertical.getScaledInstance(Constants.Images.CRATE_WIDTH, Math.max(y - Constants.BORDER_HEIGHT + 30, 30),
                Image.SCALE_DEFAULT),
            (int) (100 + 143 * (currColumn - 1) - Constants.Images.CRATE_WIDTH / 2), Constants.BORDER_HEIGHT, null);
        g.drawImage(Left, (int) (100 + 143 * (currColumn - 1) - 80 - Constants.Images.CRATE_WIDTH / 2),
            y + Constants.BORDER_HEIGHT + 21, null);
        g.drawImage(Right, (int) (100 + 143 * (currColumn - 1) + 80 - Constants.Images.CRATE_WIDTH / 2),
            y + Constants.BORDER_HEIGHT + 21, null);

        y += (int) (Constants.GRABBER_SPEED);

        if (y + Constants.BORDER_HEIGHT + 41 >= Constants.PLATFORM_POS[0][1]
            - currHeight * Constants.Images.CRATE_HEIGHT) {
          state = State.RAISING_EMPTY;
        }
        break;
    }
  }

}
