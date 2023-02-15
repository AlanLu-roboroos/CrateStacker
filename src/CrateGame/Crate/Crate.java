package CrateGame.Crate;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public interface Crate {

  public void paint(Graphics g, int isHeld);

  public boolean isMergeable(ArrayList<Crate> crates);

  public Crate nextCrate(int line, int height);

  public int getCrateID();

  public void updatePos(int pos);

  public boolean lineSpawnable();

  public boolean spawnable();

  public boolean isLiftable();

  public void setColumn(int column);

  public void setHeight(int pheight, int height);

  public Image getImage();

  public int getY();

  public int getX();
}

