import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

//class StadiumPanel
//extends BoardPanel
//methods: constructor, main
//Adds all the seats and forms a 2D array of JButtons
//with 27 rows and 35 columns. Buttons are place where there
//are seats.
public class StadiumPanel extends BoardPanel 
{
  
  //StadiumPanel class
  //Arguments: stadium(Stadium), app (StadiumApp)
  //Return value: none
  //Creates a 27x35 array of JButtons.
  //All buttons are colored depending on section
  //Buttons are placed where there is a seat in stadium.
  //All buttons contain a MouseListener, and an
  //ActionListener.
  public StadiumPanel(Stadium stadium,StadiumApp app)
  {
   super();
   setLayout(new GridLayout (27,35));
   for (int r = 0; r < stadium.ROWS; r++)
   {
     for (int c = 0; c < stadium.COLUMNS; c++)
     {
       Seat seat = stadium.getSeat(r,c);
       if (seat!=null)
       {
        JButton button = new JButton ();
          button.setBackground(seat.getSection() == 1 ? Color.red :
                                 ( seat.getSection() == 2 ? Color.green :
                                    seat.getSection() == 3 ? Color.blue: 
                                    Color.yellow));
          button.addMouseListener(new seatMouseListener (seat,app));
          button.addActionListener (new ButtonListener (seat,app));
                                    
        add(button);
       }
       else add(new JLabel());
     }
   }
   setVisible(true);
  }
  
  //TESTING ONLY, RUN StadiumApp for full app
  public static void main (String args[])
  {
    JFrame f = new JFrame ("Stadium Panel Test");
    f.getContentPane().add (new StadiumPanel (new Stadium(),null));
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(649,500);
    f.setVisible (true);
  }
}