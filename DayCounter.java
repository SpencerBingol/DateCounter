public class DayCounter {
  private final int YEAR = 365;
  private int year[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
  private int startDay, startYear, endDay, endYear;
   
  private int counter = 0;
  
  public DayCounter(Date startDT, Date endDT) {
    int[] start = { startDT.getMonth(), startDT.getDayMon(), startDT.getYear() };
    int[] end = { endDT.getMonth(), endDT.getDayMon(), endDT.getYear() };
    
    startDay = 0;
    for (int i = 1; i < start[0]; ++i) {
      startDay += year[i-1];
      if ((start[2] % 4 == 0) && i == 2) counter++;
    }
    startDay += start[1];
    startYear = start[2];
    
    endDay = 0;
    for (int i = 1; i < end[0]; ++i) {
      endDay += year[i-1];
      if ((end[2] % 4 == 0) && i == 2) counter++;
    }
    endDay += end[1];
    endYear = end[2];
    
    count();
  }
  
  private void count () {
      counter = endDay - startDay;
      
      for (int i = startYear; i < endYear; ++i) { 
        counter += YEAR;
        if ((i % 4) == 0) counter++;
      } 
  }
  
  public int getCount() {
      return counter;
  }
}