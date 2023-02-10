package CrateGame;

import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

public class Game extends JPanel {
  public Image platformImage, spawnImage;
  public Point mousePos;
  public Point lastPoint = new Point(0, 0);

  Game() {
    setSize(Constants.WIDTH, Constants.HEIGHT);
    setBackground(new Color(24, 24, 24));
    loadImages();

    setVisible(true);
  }

  public void loadImages() {
    platformImage = Constants.PLATFORM_IMG;
    spawnImage = Constants.SPAWN_IMG;
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);

    if (this.getMousePosition() != null) {
      mousePos = this.getMousePosition();
    } else {
      mousePos = lastPoint;
    }

    lastPoint = mousePos;
    System.out.println("x: " + mousePos.getLocation().getX() + " y: " + mousePos.getLocation().getY());

    for (int[] pos : Constants.PLATFORM_POS) {
      g.drawImage(platformImage, pos[0] - platformImage.getWidth(null) / 2, pos[1] - platformImage.getHeight(null) / 2,
          null);
      // g.drawRect(pos[0], pos[1], 2, 2); // For Testing
    }

    for (int[] pos : Constants.SPAWN_POS) {
      g.drawImage(spawnImage, pos[0] - spawnImage.getWidth(null) / 2, pos[1] - spawnImage.getHeight(null) / 2, null);
      // g.drawRect(pos[0], pos[1], 2, 2); // For Testing
    }
  }

}
