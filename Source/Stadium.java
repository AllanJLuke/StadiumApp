//Class Stadium
//methods: constructor, getSeats,getSeat
public class Stadium {
  public static int ROWS = 27;
  public static int COLUMNS = 35; 
  
  
  private static String[] SEAT_NUMBERS = {
    
    "9 1234567890 123456789 1234567890 1",
    "8 1234567890 123456789 1234567890 2",
    "7 1234567890 123456789 1234567890 3",
    "6                                 4",
    "55   12345678 1234567 12345678   15",
    "44 8  1234567 1234567 1234567  1 26",
    "33 77                         12 37",
    "22 66   1234561234567123456   23 48",
    "11 55 0  12345123456712345  1 34 59",
    "99 44 98  123412345671234  12 45 11",
    "88 33 876 --------------- 123 56 22",
    "77 22 765|               |234 67 33",
    "66 11 654|               |345 78 44",
    "55       |               |       55",
    "44 87 543|               |456 11 66",
    "33 76 432|               |567 22 77",
    "22 65 321 --------------- 678 33 88",
    "11 54 21  432176543214321  89 44 99",
    "95 43 1  54321765432154321  0 55 11",
    "84 32   6543217654321654321   66 22",
    "73 21                         77 33",
    "62 1  7654321 7654321 7654321  8 44",
    "51   87654321 7654321 87654321   55",
    "4                                 6",
    "3 0987654321 987654321 0987654321 7", 
    "2 0987654321 987654321 0987654321 8",
    "1 0987654321 987654321 0987654321 9" 
    
  }; 
  
  private static String[] SEAT_ROWS = {
    "Z CCCCCCCCCC FFFFFFFFF IIIIIIIIII K",
    "Z BBBBBBBBBB EEEEEEEEE HHHHHHHHHH K",
    "Z AAAAAAAAAA DDDDDDDDD GGGGGGGGGG K",
    "Z                                 K",
    "ZY   BBBBBBBB DDDDDDD FFFFFFFF   JK",
    "ZY T  AAAAAAA CCCCCCC EEEEEEE  H JK",
    "ZY TS                         GH JK",
    "ZY TS   CCCCCCFFFFFFFIIIIII   GH JK",
    "ZY TS X  BBBBBEEEEEEEHHHHH  L GH JK",
    "DC TS XW  AAAADDDDDDDGGGG  KL GH AB",
    "DC TS XWV --------------- JKL GH AB",
    "DC TS XWV|               |JKL GH AB",
    "DC TS XWV|               |JKL GH AB",
    "DC       |               |       AB",
    "DC RQ XWV|               |JKL IJ AB",
    "DC RQ XWV|               |JKL IJ AB",
    "DC RQ XWV --------------- JKL IJ AB",
    "DC RQ XW  SSSSPPPPPPPMMMM  KL IJ AB",
    "XW RQ X  TTTTTQQQQQQQNNNNN  L IJ LM",
    "XW RQ   UUUUUURRRRRRROOOOOO   IJ LM",
    "XW RQ                         IJ LM",
    "XW R  OOOOOOO MMMMMMM KKKKKKK  J LM",
    "XW   PPPPPPPP NNNNNNN LLLLLLLL   LM",
    "X                                 M",
    "X TTTTTTTTTT QQQQQQQQQ NNNNNNNNNN M",
    "X UUUUUUUUUU RRRRRRRRR OOOOOOOOOO M",
    "X VVVVVVVVVV SSSSSSSSS PPPPPPPPPP M" 
    
  }; 
  
  private static String[] SEAT_SECTIONS = {
    "3 3333333333 333333333 3333333333 3",
    "3 3333333333 333333333 3333333333 3",
    "3 3333333333 333333333 3333333333 3",
    "3                                 3",
    "33   22222222 2222222 22222222   33",
    "33 2  2222222 2222222 2222222  2 33",
    "33 22                         22 33",
    "33 22   1111111111111111111   22 33",
    "33 22 1  11111111111111111  1 22 33",
    "44 22 11  111111111111111  11 22 44",
    "44 22 111 --------------- 111 22 44",
    "44 22 111|               |111 22 44",
    "44 22 111|               |111 22 44",
    "44       |               |       44",
    "44 22 111|               |111 22 44",
    "44 22 111|               |111 22 44",
    "44 22 111 --------------- 111 22 44",
    "44 22 11  111111111111111  11 22 44",
    "33 22 1  11111111111111111  1 22 33",
    "33 22   1111111111111111111   22 33",
    "33 22                         22 33",
    "33 2  2222222 2222222 2222222  2 33",
    "33   22222222 2222222 22222222   33",
    "3                                 3",
    "3 3333333333 333333333 3333333333 3",
    "3 3333333333 333333333 3333333333 3",
    "3 3333333333 333333333 3333333333 3" 
    
  }; 
  
  private Seat[][] seats; 
  
  //Stadium constructor
  //Arguments: none
  //Return value: none
  //Organizes the seats field with Seat objects/null 
  //depending on if there is a seat at the location or not.
  public Stadium() { 
    seats = new Seat[ROWS][COLUMNS]; 
    
    for (int r=0; r< ROWS; r++) { 
      
      
      String secString = SEAT_SECTIONS[r]; 
      String rowString = SEAT_ROWS[r]; 
      String numString = SEAT_NUMBERS[r]; 
      for (int c=0; c< COLUMNS; c++) {
        
        
        byte section = (byte)Character.digit(secString.charAt(c),10);
        char row = (char)rowString.charAt(c);
        byte number = (byte)Character.digit(numString.charAt(c),10);
        if (!Character.isLetter(row))         
          seats[r][c] = null;
        else 
          seats[r][c] = new Seat(section, row, number);
      }
    }
  } 
  
  //Procedure getSeats
  //Arguments: none
  //Return value: Seat[][]
  //Returns the seats field
  public Seat[][] getSeats() { return seats; }
  
  //Procedure getSeat
  //Argument: row (int), col (int)
  //Return value: Seat object
  //Returns the seat at seats[row][col]
  public Seat getSeat(int row, int col) { return seats[row][col]; }
}