//Class Seat
//Methods: constructor, getSection, getRow, getNumber, getPrice, isSelected
//setSelected
//A Seat object which contains all info for a seat in the StadiumPanel
public class Seat {
  public static int[] PRICING = {74, 47, 32, 19}; 
  
  
  private byte section;
  private char row;
  private byte number; 
  private boolean selected = false;
  boolean [] sold = new boolean [4];
  //Seat constructor
  //Arguments: s (byte), r(char),n (bye)
  //Return value: none
  //Sets fields section,row,number to s,r,n respectively
  public Seat(byte s, char r, byte n) { 
    section = s; 
    row = r; 
    number = n; 
    for (int i = 0; i < 4; i++)
      sold [i] = false;
  } 
  
  //Getters for the respectable fields
  public byte getSection() { return section; }
  public char getRow() { return row; }
  public byte getNumber() { return number; }
  public int getPrice() { return PRICING[section-1]; }
  public boolean isSelected() { return selected;}
  
  //Flips the selected boolean field
  public void setSelected() { selected = !selected;}
  
} 