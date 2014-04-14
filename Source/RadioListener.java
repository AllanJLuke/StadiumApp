import java.awt.event.*;

//Class RadioListener
//Methods: Constructor, actionPerformed
//An action listener for the StadiumApp menu bar
public class RadioListener implements ActionListener
{
   StadiumApp app;
   int game;
   
   //RadioListener constructor
   //Arguments: app (StadiumApp),game (int)
   //Sets app and game to respective fields
   public RadioListener (StadiumApp app,int game)
   {
    this.app = app;
    this.game = game;
   }
   
   //Procedure actionPerformed
   //Arguments: e (ActionEvent)
   //sets game field in app to this listeners game field, and clears all selections
   public void actionPerformed(ActionEvent e)
   {
    app.setGame (game);
    app.setSelectedCount(0);
    app.clearSelections();
    app.update();    
   }
}