import java.awt.event.*;

//Class seatMouseListener
//methods: constructor, mouseClicked, mouseExited, mousePressed,
//mouseReleased, mouseEntered
public class seatMouseListener implements MouseListener
{
  Seat seat;
  StadiumApp app;
  
  //seatMouseListener constructor
  //Arguments: seat (Seat), app (StadiumApp)
  //Return value: none
  //sets the fields to the arguments provided
  public seatMouseListener(Seat seat, StadiumApp app)
  {
   this.seat = seat;
   this.app = app;
  }
  
  //defined for MouseListener implementation
  public void mouseClicked(MouseEvent e){}

  
  //Procedure mouseExited
  //Arguments: e (MouseEvent)
  //Return value: none
  //is invoked when the mouse leaves the button this is a listener for.
  //clears the labels in SeatingInfo panel
  public void mouseExited(MouseEvent e)
  {
   app.getSeating().clearAll();
  }
  
  //defined for MouseListener implementation
  public void mousePressed(MouseEvent e){}
  public void mouseReleased(MouseEvent e) {}
  
  //Procedure mouseEntered
  //Arguments e (MouseEvent)
  //Return value: none
  //is invoked when mouse enters the button this is a listener for.
  //Sets the SeatingInfo panel textfields to the respective values
  //of the Seat object field.
  public void mouseEntered(MouseEvent e)
  {
    app.getSeating().setPrice(seat.getPrice());
    app.getSeating().setSection(seat.getSection());
    app.getSeating().setRow(seat.getRow());
    app.getSeating().setNumber(seat.getNumber());
  }
}