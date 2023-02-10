import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Game extends JPanel {
  public Image platformImage, spawnImage;
  public PointerInfo mousePos;

  Game() {
    setSize(Constants.WIDTH, Constants.HEIGHT);
    setBackground(new Color(24, 24, 24));
    loadImages();

    setVisible(true);
  }

  public void loadImages() {
    try {
      platformImage = ImageIO.read(new File("./src/Textures/objects/platform.png")).getScaledInstance(80, 80,
          Image.SCALE_DEFAULT);
      spawnImage = ImageIO.read(new File("./src/Textures/objects/spawn.png")).getScaledInstance(80, 80,
          Image.SCALE_DEFAULT);

    } catch (Exception e) {
      e.printStackTrace();
      System.exit(0);
    }
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);

    mousePos = MouseInfo.getPointerInfo();
    System.out.println("x: " + mousePos.getLocation().x + " y: " + mousePos.getLocation().y);

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
