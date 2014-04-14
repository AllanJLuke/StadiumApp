import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


//ONE CHANGE LINE 47 (AESTHETIC)
public class PurchasePanel extends JPanel {
 private JTextField nameTextField;
 private JTextField addressTextField;
 private JTextField cityTextField;
 private JTextField provinceTextField;
 private JTextField postalCodeTextField;
 private JTextField costTextField;
 private JTextField expiryDateTextField;
 private JTextField creditCardTextField;
 private String     creditCardType;

 // Make a get method so that the textfields can be accessed externally
 public JTextField getNameTextField() { return nameTextField; }
 public JTextField getAddressTextField() { return addressTextField; }
 public JTextField getCityTextField() { return cityTextField; }
 public JTextField getProvinceTextField() { return provinceTextField; }
 public JTextField getPostalCodeTextField() { return postalCodeTextField; }
 public JTextField getExpiryDateTextField() { return expiryDateTextField; }
 public JTextField getCreditCardTextField() { return creditCardTextField; }
 public JTextField getCostTextField() { return costTextField; }
 public String    getCreditCardType() { return creditCardType; }

 // Add a constructor that takes the price of the seat(s)
 public PurchasePanel (String cost) {
  // Make a nice border
  setBorder(BorderFactory.createTitledBorder("Customer Information"));

  // Create text fields
  nameTextField = new JTextField("");
  addressTextField = new JTextField("");
  cityTextField = new JTextField("");
  provinceTextField = new JTextField("");
  postalCodeTextField = new JTextField("");
  expiryDateTextField = new JTextField("");
  creditCardTextField = new JTextField("");

  // populate the costTextField with the price of the seat(s)
  costTextField = new JTextField(cost);

  // Disallow changing of price of the seat(s)
  costTextField.setEditable(false); //CHANGED FROM .setEnabled(false) to .setEditable (looks better...)

  // Set the layoutManager and add the components
  setLayout(new GridLayout(13,2,5,5));

  JLabel aLabel = new JLabel("Name :");
  aLabel.setHorizontalAlignment(JLabel.RIGHT);
  add(aLabel);
  add(nameTextField);

  aLabel = new JLabel("Address :");
  aLabel.setHorizontalAlignment(JLabel.RIGHT);
  add(aLabel);
  add(addressTextField);

  aLabel = new JLabel("City :");
  aLabel.setHorizontalAlignment(JLabel.RIGHT);
  add(aLabel);
  add(cityTextField);

  aLabel = new JLabel("Province :");
  aLabel.setHorizontalAlignment(JLabel.RIGHT);
  add(aLabel);
  add(provinceTextField);

  aLabel = new JLabel("Postal Code :");
  aLabel.setHorizontalAlignment(JLabel.RIGHT);
  add(aLabel);
  add(postalCodeTextField);

  add(new JLabel(""));
  add(new JLabel(""));

  aLabel = new JLabel("CreditCard :");
  aLabel.setHorizontalAlignment(JLabel.RIGHT);
  add(aLabel);

  ButtonGroup aButtonGroup = new ButtonGroup();
  JRadioButton aButton;
  aButton = new JRadioButton("MasterCard");
  aButtonGroup.add(aButton);
  add(aButton);
  aButton.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
        creditCardType = e.getActionCommand();
       }});

  add(new JLabel(""));
  aButton = new JRadioButton("Visa");
  aButtonGroup.add(aButton);
  add(aButton);
  aButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
       creditCardType = e.getActionCommand();
      }});
  add(new JLabel(""));
  aButton = new JRadioButton("American Express");
  aButtonGroup.add(aButton);
  add(aButton);
  aButton.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
        creditCardType = e.getActionCommand();
       }});

  aLabel = new JLabel("Expiry Date :");
  aLabel.setHorizontalAlignment(JLabel.RIGHT);
  add(aLabel);
  add(expiryDateTextField);

  aLabel = new JLabel("Credit Card Number :");
  aLabel.setHorizontalAlignment(JLabel.RIGHT);
  add(aLabel);
  add(creditCardTextField);

  add(new JLabel(""));
  add(new JLabel(""));

  aLabel = new JLabel("Seat(s) Price :");
  aLabel.setHorizontalAlignment(JLabel.RIGHT);
  add(aLabel);
  add(costTextField);
 }
}
