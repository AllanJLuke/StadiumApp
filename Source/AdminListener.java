import java.awt.event.*;
import javax.swing.*;

//Class AdminListener
//Methods: Constructor, actionPerformed
//An action listener for the admin button in StadiumApp
public class AdminListener implements ActionListener
{
   StadiumApp app;
   Stadium stadium;
   
   //AdminListener constructor
   //Arguments: app (StadiumApp), stadium (Stadium)
   //Return value: none
   //Sets fields to the arguments respectively
   public AdminListener(StadiumApp app, Stadium stadium) 
   {
     this.app = app;
     this.stadium = stadium;
   }
  
   //Procedure actionPerformed
   //Arguments: e (ActionEvent)
   //Return value: none
   //Displays AdminLoginDialog
   public void actionPerformed(ActionEvent e)
   {
    AdminLoginDialog dialog = new AdminLoginDialog((JFrame)app,(DialogClientInterface)app,stadium);
    dialog.setVisible(true);
   }
}
