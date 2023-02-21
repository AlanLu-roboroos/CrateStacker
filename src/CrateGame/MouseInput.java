package CrateGame;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import CrateGame.Crate.Crate;

import javax.swing.event.MouseInputListener;

public class MouseInput implements MouseInputListener {
  public boolean leftPressed = false;
  public ArrayList<ArrayList<Crate>> crates;
  public Grabber grabber;
  public int count;

  public Crate heldCrate;

  public MouseInput(ArrayList<ArrayList<Crate>> crates, Grabber grabber) {
    super();
    this.crates = crates;
    this.grabber = grabber;
  }

  @Override
  public void mouseClicked(MouseEvent arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseEntered(MouseEvent arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseExited(MouseEvent arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mousePressed(MouseEvent arg0) {
    if (arg0.getButton() == MouseEvent.BUTTON1) {
      count = 0;
      count = (int) Math.floor(arg0.getX() / (Constants.WIDTH / (Constants.MAX_NUM_LINE)));

      grabber.goTo(count);

      // if (crates.get(count).size() > 0) {
      // if (grabber.heldCrate == null) {
      // crates.get(count).remove(crates.get(count).size()-1);
      // } else {
      // temp = grabber.goTo(count);
      // }
      // } else {
      // temp = grabber.goTo(count);

      // }
      // if (temp != null) {
      // crates.get(count).add(temp);
      // }
    }
  }

  @Override
  public void mouseReleased(MouseEvent arg0) {

  }

  @Override
  public void mouseDragged(MouseEvent arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseMoved(MouseEvent arg0) {
    // TODO Auto-generated method stub

  }
}
