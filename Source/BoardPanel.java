import java.awt.*;
import javax.swing.*; 
//UNCHANGED, USED AS PROVIDED
public class BoardPanel extends JPanel {
  
  static int WIDTH = 633, HEIGHT = 462;
  
  public int getWidth() { return WIDTH; }
  
  public int getHeight() { return HEIGHT; }
  
  public Dimension getSize() { return new Dimension(WIDTH, HEIGHT); }
  
  public Dimension getSize(Dimension rv) {   
   rv.width = WIDTH; rv.height = HEIGHT; return rv;
  }
  public void setBounds(Rectangle r) { 
    super.setBounds(new Rectangle(r.x, r.y, WIDTH, HEIGHT));
  }
  public void setBounds(int x, int y, int w, int h) {
    
    super.setBounds(x,y,WIDTH,HEIGHT);
  }
  public Dimension getMaximumSize() { return new Dimension(WIDTH, HEIGHT); }
  
  public Dimension getMinimumSize() { return new Dimension(WIDTH, HEIGHT); }
  
  public Dimension getPreferredSize() { return new Dimension(WIDTH, HEIGHT); }
  
  public void setSize(Dimension d) { }
  
  public void setSize(int x, int y) { }
  
} 