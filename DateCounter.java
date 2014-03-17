import java.util.Scanner;

public class DateCounter {
  static Scanner kbd = new Scanner(System.in);
  static int result;
  
  public static void main (String[] args) {      
    int response;
    
    System.out.println("\nDateCounter v1.1.0\n");
    
    while (true) {   
      System.out.println("\t1. Count days between dates\n\t2. Find day of week?\n\t3. Quit");
      System.out.print("Select Option: ");
      response = kbd.nextInt();
      kbd.nextLine();
      
      if (response == 1) {
        countDays(); 
      } else if (response == 2) {
        dayOfWeek();
      } else if (response == 3) {
        System.exit(0);
      } else System.out.println("Must enter either \"1\", \"2\", or \"3\"");
    }
  } 
  
  private static void countDays () {
      DayCounter count;
      Date start, end;
      
      do {
        System.out.print("Enter start date (e.g. MM/DD/YYYY): ");  
        start = new Date(kbd.nextLine());
      } while ( !start.validDate() );
      
      do {
        System.out.print("Enter end date (e.g. MM/DD/YYYY): ");
        end = new Date(kbd.nextLine());
      } while ( !end.validDate() );
      
      count = new DayCounter(start, end);
      result = count.getCount();
      
      System.out.println(result + " day(s) between " + start + " and " + end + ".");
  }
  
  private static void dayOfWeek () {
    Date date;
    
    do {
      System.out.print("Enter date (MM/DD/YYYY): ");
      date = new Date(kbd.nextLine());
    } while (!date.validDate()); 
    
    System.out.println("\n" + date.getDate() + " is a " + date.getDay() + ".\n");
  }
}