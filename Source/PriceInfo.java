import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

//Class PriceInfo
//extends JPanel
//Methods: constructor, main, updatePrice, updateHST,
//updateCost, clearAll
public class PriceInfo extends JPanel
{
  JTextField seatPrice,hst,cost;
  
  //PriceInfo constructor
  //Arguments: none
  //Return value: none
  //Adds a seat label, price label, hst label, and cost label
  //Also adds a textfield for each label
   DecimalFormat df = new DecimalFormat ("#.##");
  public PriceInfo ()
  {
    super();
    setBorder(BorderFactory.createTitledBorder("SELECTED SEAT PRICING"));
    setLayout (new GridLayout(3,2));
    
    //Seat price label
    JLabel label = new JLabel ("Seat(s) Price:");
    add(label);
    
    //Seat price text field
    seatPrice = new JTextField ();
    add (seatPrice);
    
    //HST label
    label = new JLabel ("HST:");
    add (label);
    
    //HST text field
    hst = new JTextField();
    add (hst);
    
    //Total cost label
    label = new JLabel ("Total Cost:");
    add (label);
    
    //Total cost field
    cost = new JTextField();
    add (cost);  
    
  }
  //Procedure main
  //Arguments: args (String [])
  //Return value: none
  //Used for testing only. 
  public static void main (String args[])
  {
    JFrame f = new JFrame ("Stadium Panel Test");
    f.getContentPane().add (new PriceInfo());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(649,500);
    f.setVisible (true);
  }
  
  public void updatePrice(double val)
  {
    seatPrice.setText("$"+df.format(val));
  }
  
  public void updateHST (double val)
  {
    hst.setText ("$" +df.format(val));
  }
  
  public void updateCost (double val)
  {
    cost.setText ("$" + df.format(val));
  }
  
  public void clearAll ()
  {
    hst.setText("");
    cost.setText("");
    seatPrice.setText("");
  }
  
}