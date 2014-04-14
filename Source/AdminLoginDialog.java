//ADAPTED: Dr. Mark Lanthier
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminLoginDialog extends JDialog {
  private JButton   okButton;
  private JTextField  userTextField;
  private JPasswordField  passwordField;
  private Stadium stadium; 
  
  // The client (i.e. caller of this dialog box)
  private DialogClientInterface client;
  
  // A constructor that takes the model and client as parameters
  public AdminLoginDialog(Frame owner, DialogClientInterface cli,Stadium stadium){
    super(owner,"Administrator Login",true);
    client = cli;
    this.stadium = stadium;
    // Add the components using a grid layout
    setLayout(new GridLayout(3,3, 5, 5));
    
    JLabel aLabel = new JLabel("User ID:  ");
    aLabel.setHorizontalAlignment(JLabel.RIGHT);
    add(aLabel);
    
    userTextField = new JTextField("");
    add(userTextField);
    
    aLabel = new JLabel("Password:  ");
    aLabel.setHorizontalAlignment(JLabel.RIGHT);
    add(aLabel);
    
    passwordField = new JPasswordField ("");
    add(passwordField);
    
    add(new JLabel("")); // leave a blank
    add(okButton = new JButton("OK"));
    
    // Listen for ok button click
    okButton.addActionListener(
                               new ActionListener() {
      public void actionPerformed(ActionEvent event){
        okButtonClicked();
      }});
    
    // Listen for window closing: treat like cancel button
    addWindowListener(
                      new WindowAdapter() {
      public void windowClosing(WindowEvent event) {
      //  okButtonClicked(); ????
      }});
    
    setSize(220, 120);
    setResizable(false);
  }
  
  private void okButtonClicked(){
    if (userTextField.getText().compareTo("Admin") == 0) //User name check
    {
      boolean pass = true;
      char [] password = passwordField.getPassword();
      for (int i = 0; i < password.length; i++)//Password check
      {
        if (password[i] != "Nimda!".charAt(i))
          pass = false;
      }
      if (pass)
      {
        SeatInfoDialog seatDialog = new SeatInfoDialog(stadium);//If username and password pass, then show SeatInfoDialog
        seatDialog.setVisible(true);
      }
    }
  }
}
