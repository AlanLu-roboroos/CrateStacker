package CrateGame.Crate;

import java.awt.Graphics;
import java.util.ArrayList;

public interface Crate {

  public void paint(Graphics g);

  public boolean isMergeable(ArrayList<Crate> crates);

  public Crate nextCrate(int line, int height);

  public int getCrateID();
}
