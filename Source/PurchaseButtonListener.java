import java.awt.event.*;


//Class PurchaseButtonListener
//Methods: Constructor, actionPerformed
//A listener for the purchase button in StadiumApp
public class PurchaseButtonListener implements ActionListener
{
  StadiumApp app;
  Stadium stadium;
  
  //PurchaseButtonListener constructor
  //Arguments: app (StadiumApp), stadium (Stadium)
  //Return value: none
  //Sets fields to arguments provided respectively
  public PurchaseButtonListener(StadiumApp app,Stadium stadium)
  {
    this.app = app;
    this.stadium = stadium;
  }
  
  //Proceudre actionPerformed
  //Arguments: e (ActionEvent)
  //Return value: none
  //Displays the purchaseDialog
  public void actionPerformed(ActionEvent e)
  {
    PurchaseDialog dialog;
    dialog = new PurchaseDialog(app,app.getTotalCost(),stadium);
    dialog.setVisible(true);
  }
}