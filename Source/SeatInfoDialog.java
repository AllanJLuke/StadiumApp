import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class SeatInfoDialog extends JDialog {
  private JButton   okButton;
  private JTextField   userTextField;
  private JPasswordField  passwordField;
  private DecimalFormat df = new DecimalFormat ("##.##");
  public SeatInfoDialog(Stadium stadium){
    super((JDialog)null,"Administrator Sales Report",true);
    
    // Add the components
    setLayout(new GridLayout(8,3));
    JLabel aLabel = new JLabel("GAME");
    aLabel.setHorizontalAlignment(JLabel.CENTER);
    add(aLabel);
    aLabel = new JLabel("SEATS SOLD");
    aLabel.setHorizontalAlignment(JLabel.CENTER);
    add(aLabel);
    aLabel = new JLabel("SALES");
    aLabel.setHorizontalAlignment(JLabel.CENTER);
    add(aLabel);
    
    

    //CALCULATE SALES AND SEATS SOLD FOR EACH GAME.
    double [] moneyMade = new double [4];
    int [] seatsSold = new int [4];
    for (int i = 0; i < 4; i++)
    {
      int count = 0; //Number of seats sold for (i+1)th game
      double price = 0; //Total sales for (i+1)th game
      for (int r = 0; r < Stadium.ROWS; r++)
      {
        for(int c = 0; c < Stadium.COLUMNS; c++)
        {
          if (stadium.getSeat(r,c) != null)
          {
            if (stadium.getSeat(r,c).sold[i])
            {
              count++; 
              price += stadium.getSeat (r,c).getPrice() * 1.13; 
            }
          }
        }
      }
      seatsSold [i] = count;
     moneyMade [i] = price;
    }
    for (int temp=0; temp<12; temp++) 
    {
      
      if (temp == 1 || temp == 4 || temp == 7 || temp == 10)
        aLabel = new JLabel(Integer.toString(seatsSold[temp/3]));  //Seats sold label
      else if (temp == 0 || temp == 3 || temp == 6 || temp == 9)
        aLabel = new JLabel (Integer.toString ((temp/3) + 1)); //Game number label
      else
        aLabel = new JLabel ("$"+df.format(moneyMade[temp/3]));//Sales label
      aLabel.setHorizontalAlignment(JLabel.CENTER);
      add(aLabel); 
    }
    
    aLabel = new JLabel("-------------------");
    aLabel.setHorizontalAlignment(JLabel.CENTER);
    add(aLabel);
    aLabel = new JLabel("-------------------");
    aLabel.setHorizontalAlignment(JLabel.CENTER);
    add(aLabel);
    aLabel = new JLabel("-------------------");
    aLabel.setHorizontalAlignment(JLabel.CENTER);
    add(aLabel);
    
    aLabel = new JLabel("TOTAL");
    aLabel.setHorizontalAlignment(JLabel.CENTER);
    add(aLabel);
    double sum = 0;
    for (int i = 0; i < 4; i++)
      sum+= seatsSold[i]; //Sums up total seats sold
    aLabel = new JLabel(Integer.toString((int)sum));
    aLabel.setHorizontalAlignment(JLabel.CENTER);
    add(aLabel);
    sum = 0;
    for (int i = 0; i < 4; i++)
      sum+= moneyMade[i]; //Sums up total sales
    aLabel = new JLabel("$"+df.format(sum));
    aLabel.setHorizontalAlignment(JLabel.CENTER);
    add(aLabel);
    
    aLabel = new JLabel(""); // Leave a blank
    add(aLabel);
    aLabel = new JLabel(""); // Leave a blank
    add(aLabel);
    add(okButton = new JButton("OK"));
    okButton.addActionListener(new ActionListener (){
      public void actionPerformed (ActionEvent e)
      {
        dispose();
      }
    });
    
    // Prevent the window from being resized
    setSize(300, 240);
    setResizable(false);
  }
}

