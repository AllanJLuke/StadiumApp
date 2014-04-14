import javax.swing.*;
import java.awt.*;
import java.awt.Component;

//Class StadiumApp
//extends JFrame
//Methods: constructor, main, getSeating, update
//Main StadiumApp class. RUN THIS CLASS ONLY.
public class StadiumApp extends JFrame implements DialogClientInterface
{
  private PriceInfo priceInfo;
  private SeatingInfo seating;
  private StadiumPanel panel;
  private Stadium stadium;
  private int game;
  private JButton purchase;
  private JButton admin;
  private int selectCount = 0;
  private double totalCost = 0;
  
  //StadiumApp constructor
  //Arguments: none
  //Return value: none
  //Organizes an instance of SeatingInfo, StadiumPanel,
  //and PriceInfo. Also adds a purchase button, and admin button
  public StadiumApp()
  {
    super("Seat Purchasing System");
    GridBagLayout layout = new GridBagLayout();
    setLayout(layout);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    GridBagConstraints gbc = new GridBagConstraints();
    
    //panels
    seating = new SeatingInfo();
    priceInfo = new PriceInfo();
    stadium = new Stadium();
    panel = new StadiumPanel (stadium,this);
    
    
    
    //ADDING SEAT PANEL
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.WEST;
    layout.setConstraints(panel,gbc);
    add (panel,gbc);
    
    
    //ADDING SEATINGINFO PANEL
    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.NORTH;
    layout.setConstraints(seating,gbc);
    add (seating,gbc);
    
    //ADDING SEAT PRICING PANEL
    gbc.gridy = 1;
    gbc.gridx= 1;
    gbc.anchor = GridBagConstraints.NORTH;   
    layout.setConstraints(priceInfo,gbc);
    add(priceInfo,gbc);
    
    
    //Adding Purchase button
    purchase = new JButton ("Purchase");
    gbc.gridy = 2;
    layout.setConstraints(purchase,gbc);
    purchase.addActionListener(new PurchaseButtonListener(this,stadium));
    add(purchase);
    
    //Adding Administrator button
    admin = new JButton ("Administrator");
    gbc.gridy = 3;   
    layout.setConstraints(admin,gbc);
    admin.addActionListener(new AdminListener(this,stadium));
    add(admin);
    
    //Adding menu bar
    JMenuBar menu = new JMenuBar ();
    this.setJMenuBar(menu);
    
    //Adding game menu
    JMenu gameMenu = new JMenu ("Game");
    menu.add(gameMenu);
    
    //Adding the game choices
    ButtonGroup choices = new ButtonGroup();
    JRadioButtonMenuItem gameOne = new JRadioButtonMenuItem("Game 1");
    gameOne.addActionListener (new RadioListener(this,1));
    JRadioButtonMenuItem gameTwo = new JRadioButtonMenuItem("Game 2");
    gameTwo.addActionListener(new RadioListener(this,2));
    JRadioButtonMenuItem gameThree = new JRadioButtonMenuItem("Game 3");
    gameThree.addActionListener(new RadioListener(this,3));
    JRadioButtonMenuItem gameFour = new JRadioButtonMenuItem("Game 4");
    gameFour.addActionListener(new RadioListener(this,4));
    JRadioButtonMenuItem allGame = new JRadioButtonMenuItem("All 4 Games");
    allGame.addActionListener(new RadioListener(this,5));
    choices.add(gameOne);
    choices.add(gameTwo);
    choices.add(gameThree);
    choices.add(gameFour);
    choices.add(allGame);
    gameMenu.add(gameOne);
    gameMenu.add(gameTwo);
    gameMenu.add(gameThree);
    gameMenu.add(gameFour);
    gameMenu.add(allGame);
    
    //end components
    pack();
    setResizable(false);
    setVisible(true);
    update();
    
    
  }
  
  //Procedure main
  //Arguments: args (String [])
  //Return value: none
  public static void main (String args[])
  {
    StadiumApp app = new StadiumApp();
  }
  
  //Procedure getSeating
  //Arguments: none
  //Return value: SeatingInfo object
  //Returns a SeatingInfo object for use in other panels
  public SeatingInfo getSeating()
  {
    return seating;
  }
  
  //Procedure update
  //Arguments: none
  //Return value: none
  //Sets all selected seats to gray,sold seats to white, and adds up price of 
  //selected seats, calculates HST, and total cost
  public void update()
  {
    int multiplier = 1;
    if (game == 5)
      multiplier = 4;
    if (game == 0)
    {
      panel.setVisible(false);
      priceInfo.setVisible(false);
      seating.setVisible(false);
      purchase.setVisible(false);
    }
    else
    {
      panel.setVisible(true);
      priceInfo.setVisible(true);
      seating.setVisible(true);
      purchase.setVisible(true);
      admin.setVisible(true);
      
    }
    
    if (selectCount == 0)
      purchase.setEnabled(false);
    else
      purchase.setEnabled(true);
    if (panel.isVisible())
    {
      double price = 0;
      Component [] seats = panel.getComponents();
      for (int r = 0; r < Stadium.ROWS; r++)
      {
        for(int c = 0; c < Stadium.COLUMNS; c++)
        {
          if (stadium.getSeat(r,c) != null)
          {
            if (stadium.getSeat(r,c).isSelected())
            {
              if (game != 5)
              {
                price += stadium.getSeat(r,c).getPrice() * multiplier;
                seats [r*35+c].setBackground(Color.gray);
              }
              else
              {
                boolean isSold = false;
                for (int i = 0; i < 4; i++)
                  if (stadium.getSeat(r,c).sold[i])
                  isSold = true;
                if (isSold)
                  seats[r*35+c].setBackground(Color.white);
                else
                {
                  price += stadium.getSeat(r,c).getPrice() * multiplier;
                  seats [r*35+c].setBackground(Color.gray);
                }
                
              }
            }
            else 
            {
              Seat seat = stadium.getSeat(r,c);
              if (game == 5)
              {
                boolean isSold = false;
                for (int i = 0; i < 4; i++)
                  if (seat.sold[i])
                  isSold = true;
                if (isSold)
                  seats[r*35+c].setBackground(Color.white);
                else
                  seats[r*35+c].setBackground(seat.getSection() == 1 ? Color.red :
                                                ( seat.getSection() == 2 ? Color.green :
                                                   seat.getSection() == 3 ? Color.blue: 
                                                   Color.yellow));
              }
              else if (seat.sold[game-1] == true)
                seats[r*35+c].setBackground(Color.white);
              else
                seats[r*35+c].setBackground(seat.getSection() == 1 ? Color.red :
                                              ( seat.getSection() == 2 ? Color.green :
                                                 seat.getSection() == 3 ? Color.blue: 
                                                 Color.yellow));
            }
          }
        }
      }
      if (price == 0)
        priceInfo.clearAll();
      else
      {
        if (game == 5)
          price = 0.9 * price;
        priceInfo.updatePrice(price);
        priceInfo.updateHST (((double)price*0.13));
        totalCost = price + (double)price*0.13;
        priceInfo.updateCost (totalCost);
      }
    }
  }
  
  //Procedure setGame
  //Arguments: game (int)
  //Return value: none
  //Sets the game field to value (game) provided
  public void setGame(int game)
  {
    this.game = game;
  }
  
  //Procedure getGame
  //Arguments: none
  //Return value: int 
  //Returns the game field
  public int getGame()
  {
    return game;
  }
  
  //Procedure getSelectCount
  //Arguments: none
  //Return value: int
  //Returns the selectCount field
  public int getSelectCount()
  {
    return selectCount;
  }
  
  //Procedure setSelectedCount
  //Arguments: val (int)
  //Return value: none
  //Sets the selectCount field to val
  public void setSelectedCount(int val)
  {
    selectCount = val;
  }
  
  //Procedure clearSelections
  //Arguments: none
  //Return value: none
  //Sets all selected seats to not selected
  public void clearSelections()
  {
    for (int r = 0; r < Stadium.ROWS; r++)
    {
      for(int c = 0; c < Stadium.COLUMNS; c++)
      {
        if(stadium.getSeat(r,c)!=null)
        {
          if(stadium.getSeat(r,c).isSelected())
            stadium.getSeat(r,c).setSelected();
        }
      }
      update();
    }
  }
  
  
  //Procedure getTotalCost
  //Arguments: none
  //Return value: double
  //Returns the totalCost field
  public double getTotalCost()
  {
    return totalCost;
  }
  
  //Procedure dialogFinished (DialogClientInterface)
  //Arguments: none
  //Return value: none
  //Implementation of the abstract dialogFinished method provided in DialogClientInterface
  //Invoked from Purchase Information dialog box, marks all purchased seats as sold
  public void dialogFinished()
  {
    for (int r = 0; r < Stadium.ROWS; r++)
    {
      for(int c = 0; c < Stadium.COLUMNS; c++)
      {
       if(stadium.getSeat(r,c) !=null)
       {
        if (stadium.getSeat(r,c).isSelected())
        {
          if (game != 5)
          stadium.getSeat(r,c).sold[game-1] = true;
          else
          {
            for (int i = 0; i < 4; i++)
              stadium.getSeat(r,c).sold[i] = true;
          }
        }
       }
      }
    }
  }
  
  //Procedure dialogCancelled (DialogClientInterface)
  //Arguments: none
  //Return value: none
  //Implementation of the abstract dialogCancelled provided in DialogClientInterface
  //Invoked from Purchase Information dialog box, clears all selections
  public void dialogCancelled()
  {
    clearSelections();
    setSelectedCount(0);
    update();
  }
}