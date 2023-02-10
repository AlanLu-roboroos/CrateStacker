package Crate;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;

public abstract class Crate extends Canvas {
  private int line;
  private int height;
  private boolean infected;
  private boolean explosionResistence;
  private Image image;

  public Crate(int line, int height) {
    this.line = line;
    this.height = height;
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
  }
}
