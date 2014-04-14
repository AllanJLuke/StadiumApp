import javax.swing.*;
import java.text.DecimalFormat;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//Class PurchaseDialog
//Methods: Constructor, showPurchaseDialog, reciept, getThis
//Displays the Purchase Information dialog box for the user to complete purchase, if purchase is made, reciept is shown in console
public class PurchaseDialog extends JDialog
{
  DecimalFormat df = new DecimalFormat ("##.##");
  PurchasePanel panel;
  Stadium stadium;
  JFrame owner;
  
  //PurchaseDialog constructor
  //Arguments: owner (JFrame), cost (double), stadium (Stadium)
  //Return value: none
  //Sets fields, and shows the dialog
  public PurchaseDialog(JFrame owner,double cost,Stadium stadium)
  {
    super(owner,"Purchase Information",true);
    showPurchaseDialog(cost);
    setLocationRelativeTo(owner);
    this.stadium = stadium;
    this.owner = owner;
  }
  
  //Procedure showPurchaseDialog
  //Arguments: cost(double)
  //Return value: none
  //Draws the dialog box, adds appropriate components, listeners and handles the events caused by the box
  //Uses FlowLayout
  private void showPurchaseDialog(double cost)
  {
    FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 5);
    setLayout(layout);
    panel = new PurchasePanel(df.format(cost));
    add (panel);
    setSize(300,470);
    JButton accept = new JButton ("ACCEPT");
    JButton cancel = new JButton ("CANCEL");
    accept.addActionListener (new ActionListener() {
      
      //Procedure actionPerformed in accept ActionListener
      //Arguments: e (ActionEvent)
      //Return value: none
      //Invokes the StadiumApp's dialogFinished method, prints reciept, and closes dialog
      public void actionPerformed (ActionEvent e)
      {
        ((DialogClientInterface)getOwner()).dialogFinished();
        reciept();
        dispose();
      }
    });
    
    cancel.addActionListener (new ActionListener() {
      
      //Procedure actionPerformed in cancel ActionListener
      //Arguments: e (ActionEvent)
      //Return value: none
      //Displays an option pane to confirm user's decision to cancel purchase
      //If user wants to cancel StadiumApp's dialogCancelled is invoked
      public void actionPerformed (ActionEvent e)
      {
        int choice = JOptionPane.showConfirmDialog (getThis(),"Are you sure you want to cancel your purchase? ", "Cancellation Confirmation", JOptionPane.YES_NO_OPTION); 
        if (choice == 0)
        {
        ((DialogClientInterface)getOwner()).dialogCancelled();
        dispose();
        }
      }
    });
    add (accept);
    add (cancel);
    setResizable(false);
  }
  
  
  //Procedure reciept
  //Arguments: none
  //Return value: none
  //Dumps all information about the purchase to console
  private void reciept()
  {
    double price = 0;
    System.out.println ("Confirmation of Purchase:");
    System.out.println ("Name: " + panel.getNameTextField().getText());
    System.out.println ("Address: " + panel.getAddressTextField().getText());
    System.out.println ("City: " + panel.getCityTextField().getText());
    System.out.println ("Province: " + panel.getProvinceTextField().getText());
    System.out.println ("Postal Code: " + panel.getPostalCodeTextField().getText());
    System.out.println ("Credit Card Type: " +( panel.getCreditCardType() == null ? "" :panel.getCreditCardType()));
    System.out.println ("Expiry Date: " + panel.getExpiryDateTextField().getText());
    System.out.println ("Credit Card Number: " + panel.getCreditCardTextField().getText());
    System.out.println (((StadiumApp)owner).getGame() == 5?"Seat Description for all 4 games :":"Seat(s) Description for Game Number " +( ((StadiumApp)owner).getGame()) + ":");
    for (int r = 0; r < Stadium.ROWS; r++)
    {
      for(int c = 0; c < Stadium.COLUMNS; c++)
      {
        if (stadium.getSeat(r,c) != null)
        {
          if (stadium.getSeat(r,c).isSelected())
          {
            Seat seat = stadium.getSeat(r,c);
            System.out.println ("     Section: " +seat.getSection() + "     Row: " + (seat.getRow())
                                      + "     Number: " + seat.getNumber() + "    Price: $" + seat.getPrice()+".00");     
            price+=seat.getPrice();
          }
        }
      }
    }
    System.out.println ( ((StadiumApp)owner).getGame() == 5 ? "10% discount applied before taxes, seats price shown for 4 games" : ""); 
    if (((StadiumApp)owner).getGame() == 5) 
    {
      price *= 4;
      price *= 0.9;
    }
    System.out.println ("Seat (s) Price: $" + df.format(price) + "     HST: $" + df.format(price *0.13) + "     Total: $" + df.format(price*1.13)) ;
   ((StadiumApp)owner).clearSelections();
   ((StadiumApp)owner).setSelectedCount(0);
   ((StadiumApp)owner).update();
  }   
  
  
  //Procedure getThis
  //Arguments: none
  //Return value: PurchaseDialog
  //Returns this object for use in listeners
  private PurchaseDialog getThis()
  {
    return this;
  }
}

