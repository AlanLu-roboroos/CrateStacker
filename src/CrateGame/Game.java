package CrateGame;

import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import CrateGame.Crate.Crate;
import CrateGame.Crate.PurpleCrate;

public class Game extends JPanel {
  public Image platformImage, spawnImage;
  public Point mousePos;
  public Point lastPoint = new Point(0, 0);

  public Grabber grabber = new Grabber();

  public ArrayList<ArrayList<Crate>> crates = new ArrayList<>();
  public int foundCrates = 1;

  public Random random = new Random();

  Game() {
    setSize(Constants.WIDTH, Constants.HEIGHT);
    setBackground(new Color(48, 48, 48));
    loadImages();

    for (int i = 0; i < 9; i++) {
      crates.add(new ArrayList<Crate>());
    }

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
    // System.out.println("x: " + mousePos.getLocation().getX() + " y: " +
    // mousePos.getLocation().getY());

    for (int[] pos : Constants.PLATFORM_POS) {
      g.drawImage(platformImage, pos[0] - platformImage.getWidth(null) / 2,
          pos[1] - platformImage.getHeight(null) / 2 + 8,
          null);
      // g.drawRect(pos[0], pos[1], 2, 2); // For Testing
    }

    for (int[] pos : Constants.SPAWN_POS) {
      g.drawImage(spawnImage, pos[0] - spawnImage.getWidth(null) / 2, pos[1] - spawnImage.getHeight(null) / 2, null);
      // g.drawRect(pos[0], pos[1], 2, 2); // For Testing
    }

    for (ArrayList<Crate> crate : crates) {
      for (Crate c : crate) {
        c.paint(g);
      }
    }

    grabber.paint(g);
  }

  public boolean spawnCrate(int column) {
    if (crates.get(column).size() < 7) {
      Crate temp;

      switch (random.nextInt() % foundCrates) {
        case 1:
          temp = new PurpleCrate(column, crates.get(column).size());
          break;
        default:
          temp = new PurpleCrate(column, crates.get(column).size());
          break;
      }
      crates.get(column).add(temp);
      return true;
    } else {
      return false;
    }
  }

}
