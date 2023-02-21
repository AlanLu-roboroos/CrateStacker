package CrateGame;

import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import CrateGame.Crate.Crate;
import CrateGame.Crate.ExplodableCrate;
import CrateGame.Crate.GoldCrate;
import CrateGame.Crate.GreenCrate;
import CrateGame.Crate.OrangeCrate;
import CrateGame.Crate.PinkCrate;
import CrateGame.Crate.PurpleCrate;
import CrateGame.Crate.RedCrate;
import CrateGame.Crate.YellowCrate;
import CrateGame.Grabber.State;
import CrateGame.Crate.BlueCrate;
import CrateGame.Crate.BombCrate;

public class Game extends JPanel {
  public Image platformImage, spawnImage;
  public Point mousePos;
  public Point lastPoint = new Point(0, 0);

  public ArrayList<ArrayList<Crate>> crates = new ArrayList<>();
  public ArrayList<Integer> spawnCrates = new ArrayList<Integer>();
  public ArrayList<ExplodableCrate> bombCrates = new ArrayList<ExplodableCrate>();

  public Grabber grabber = new Grabber(crates);
  public MouseInput mouseInput = new MouseInput(crates, grabber);

  public Random random = new Random();

  public int mergeCounter;
  public int currMergeId;
  public Crate tempMergeCrate;

  Game() {
    setSize(Constants.WIDTH, Constants.HEIGHT);
    loadImages();

    for (int i = 0; i < Constants.MAX_NUM_LINE; i++) {
      crates.add(new ArrayList<Crate>());
    }
    addMouseListener(mouseInput);

    spawnCrates.add(0);
    spawnCrates.add(8);

    setVisible(true);
  }

  public void loadImages() {
    platformImage = Constants.Images.PLATFORM_IMG;
    spawnImage = Constants.Images.SPAWN_IMG;
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);

    g.setColor(new Color(100, 100, 100));
    g.fillRect(0, Constants.BORDER_HEIGHT, 1200, 900 - Constants.BORDER_HEIGHT);
    g.setColor(new Color(80, 80, 80));
    g.fillRect(0, 0, 1200, Constants.BORDER_HEIGHT);

    if (this.getMousePosition() != null)

    {
      mousePos = this.getMousePosition();
    } else {
      mousePos = lastPoint;
    }

    lastPoint = mousePos;
    // System.out.println("x: " + mousePos.getLocation().getX() + " y: " +
    // mousePos.getLocation().getY());

    g.setColor(new Color(64, 64, 64));
    g.fillRect(0, Constants.BORDER_HEIGHT, 1200, 5);

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

    for (ExplodableCrate crate : bombCrates) {
      crate.explode(crates);
    }

    // System.out.println(bombCrates.toString());

    for (ArrayList<Crate> crate : crates) {
      for (Crate c : crate) {
        c.paint(g, 0, crates);
      }
    }

    mergeAll();

    updateCratePos();
    grabber.paint(g);

  }

  public boolean spawnCrate(int column) {
    if (crates.get(column).size() < Constants.CRATES_PER_LINE) {
      Crate temp = getCrate(spawnCrates.get(random.nextInt(spawnCrates.size())), column, crates.get(column).size(),
          Constants.CRATE_SPAWN_HEIGHT);
      // crates.get(column).add(new BombCrate(column, crates.get(column).size(),
      // Constants.CRATE_SPAWN_HEIGHT));
      crates.get(column).add(temp);
      return true;
    } else {
      return false;
    }
  }

  public void mergeAll() {
    for (int j = 0; j < crates.size(); j++) {
      mergeCounter = 0;
      for (int i = 0; i < crates.get(j).size(); i++) {
        if (crates.get(j).get(i).isMergeable(crates.get(j))) {
          if (mergeCounter == 0) {
            currMergeId = crates.get(j).get(i).getCrateID();
          } else if (currMergeId != crates.get(j).get(i).getCrateID()) {
            mergeCounter = 0;
            i--;
            continue;
          }
          mergeCounter++;
        } else {
          mergeCounter = 0;
        }
        if (mergeCounter >= 3) {
          mergeCounter = 0;
          tempMergeCrate = crates.get(j).get(i).nextCrate(j, i - 2);
          // Crate tempCrate = crates.get(j).get(i);
          // bombCrates.removeIf((ExplodableCrate x) -> x.hashCode() ==
          // tempCrate.hashCode());
          // tempCrate = crates.get(j).get(i - 1);
          // bombCrates.removeIf((ExplodableCrate x) -> x.hashCode() ==
          // tempCrate.hashCode());
          // tempCrate = crates.get(j).get(i - 2);
          // bombCrates.removeIf((ExplodableCrate x) -> x.hashCode() ==
          // tempCrate.hashCode());
          crates.get(j).remove(i);
          crates.get(j).remove(i - 1);
          crates.get(j).remove(i - 2);

          if (tempMergeCrate != null) {
            if (tempMergeCrate.spawnable() && !spawnCrates.contains(tempMergeCrate.getCrateID())) {
              spawnCrates.add(tempMergeCrate.getCrateID());
            }

            crates.get(j).add(i - 2, tempMergeCrate);
          }
        }
      }
    }
  }

  public void updateCratePos() {
    for (ArrayList<Crate> cratePile : crates) {
      for (Crate crate : cratePile) {
        crate.updatePos(cratePile.indexOf(crate));
      }
    }
  }

  public boolean spawnable() {
    for (ArrayList<Crate> cratePile : crates) {
      if (cratePile.size() < Constants.CRATES_PER_LINE) {
        return true;
      }
    }
    return false;
  }

  public Crate getCrate(int id, int column, int row, double height) {
    switch (id) {
      case 0:
        return new PurpleCrate(column, row, height);
      case 1:
        return new BlueCrate(column, row, height);
      case 2:
        return new GreenCrate(column, row, height);
      case 3:
        return new YellowCrate(column, row, height);
      case 4:
        return new OrangeCrate(column, row, height);
      case 5:
        return new RedCrate(column, row, height);
      case 6:
        return new PinkCrate(column, row, height);
      case 7:
        return new GoldCrate(column, row, height);
      case 8:
        Crate tempCrate = new BombCrate(column, row, height);
        bombCrates.add((ExplodableCrate) tempCrate);
        return tempCrate;
      default:
        return null;
    }
  }
}
