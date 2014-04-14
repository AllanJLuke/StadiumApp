import java.awt.event.*;
import javax.swing.*;

//Class ButtonListener
//Implements ActionListener
//Methods: constructor, actionPerformed(ActionListener)
//An ActionListener for the seats (JButtons) in the StadiumPanel
public class ButtonListener implements ActionListener
{
  Seat seat; 
  StadiumApp app;
  
  //ButtonListener constructor
  //Arguments: seat (Seat), app (StadiumApp)
  //Return value: none
  //Sets the fields to the Seat and StadiumApp instances
  //provided
  public ButtonListener (Seat seat,StadiumApp app)
  {
    this.seat = seat;
    this.app = app;
  }
  
  //Procedure actionPerformed
  //Arguments: e (ActionEvent)
  //Return value: none
  //Flips seat field's selected state and updates the app
  public void actionPerformed(ActionEvent e)
  {
    boolean isSold = false;
    for (int i = 0; i < 4; i++)
      if (seat.sold[i])
      isSold = true;
    if (!isSold)
    {
      seat.setSelected(); 
      if (seat.isSelected())
        app.setSelectedCount(app.getSelectCount()+1);
      else
        app.setSelectedCount(app.getSelectCount()-1);
      app.update();
    }
  }
}
