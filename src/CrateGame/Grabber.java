package CrateGame;

import java.awt.Image;
import java.awt.Graphics;

public class Grabber {
  public int x, y;
  public Image Left, Right, Horizontal, Vertical;

  public State state = State.STANDBY;

  public enum State {
    STANDBY,
    RAISING,
    LOWERING
  }

  public Grabber() {
    x = Constants.WIDTH / 2;
    y = 0;

    Left = Constants.Images.GRABBER_LEFT_IMG;
    Right = Constants.Images.GRABBER_RIGHT_IMG;
    Horizontal = Constants.Images.GRABBER_HORIZONTAL_IMG;
    Vertical = Constants.Images.GRABBER_VERTICAL_IMG;
  }

  public void paint(Graphics g) {
    g.drawImage(Left, x - 70, y + 70, null);
    g.drawImage(Right, x + 70, y + 70, null);
    g.drawImage(Horizontal, x, y + 70, null);
    g.drawImage(Vertical, x, y, null);
  }

}
