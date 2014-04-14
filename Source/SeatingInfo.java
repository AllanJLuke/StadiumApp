import javax.swing.*;
import java.awt.*;

//Class SeatingInfo
//extends JPanel
//Methods: constructor, main,setPrice, setSection, setNumber,
//setRow, clearAll
public class SeatingInfo extends JPanel
{
  JTextField section,row,number,price;
  
  //SeatingInfo constructor
  //Arguments: none
  //Return value: none
  //Adds a section,row,number, price JLabels and corresponding
  //JTextFields
  public SeatingInfo()
  {
    super();
    setBorder(BorderFactory.createTitledBorder("SEAT INFORMATION"));
    setLayout (new GridLayout(4,2));
    //Section label
    JLabel label = new JLabel ("Section:");
    add(label);
    
    //Section text field
    section = new JTextField ();
    add (section);
    
    //Row label
    label = new JLabel ("Row:");
    add (label);
    
    //Row text field
    row = new JTextField();
    add (row);
    
    //Number label
    label = new JLabel ("Number:");
    add (label);
    
    //Number text field
    number = new JTextField();
    add (number);
    
    //Price label
    label = new JLabel("Price:");
    add (label);
    
    //Price text field
    price = new JTextField();
    add (price);
  }
  
  
  ///TESTING USE ONLY
  //RUN StadiumApp.java
  public static void main (String args[])
  {
    JFrame f = new JFrame ("Stadium Panel Test");
    f.getContentPane().add (new SeatingInfo());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(649,500);
    f.setVisible (true);
  }
  
  //Procedure setPrice
  //Arguments: val (int)
  //Return value: none
  //Sets the price textfield to argument in dollars
  public void setPrice (int val)
  {
    price.setText("$"+Integer.toString(val)+".00");
  }
  
  //Procedure setSection
  //Arguments: val (int)
  //Return value: none
  //Sets the section textfield to argument
  public void setSection (int val)
  {
    section.setText (Integer.toString(val));
  }
  
  //Procedure setNumber
  //Arguments: val (byte)
  //Return value: none
  //Sets the number textfield to argument
  public void setNumber (byte val)
  {
    number.setText (Integer.toString(val));
  }
  
  //Procedure setRow
  //Arguments: val(char)
  //Return value: none
  //Sets the row textfield to argument
  public void setRow (char val)
  {
    row.setText (Character.toString(val));
  }
  
  
  //Procedure clearAll
  //Arguments: none
  //Return value: none
  //Clears all textfields in this panel
  public void clearAll ()
  {
    price.setText("");
    section.setText("");
    number.setText("");
    row.setText("");
  }
  
}