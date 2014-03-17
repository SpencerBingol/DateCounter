public class Date {
  private DayOfWeek day;
  private DateFormat date;
  
  public Date (String dateIn) {
    date = new DateFormat(dateIn);
    day = new DayOfWeek(date);
  }
  
  public int[] getDateInt () {
    return date.getArr();
  }
  
  public int getMonth() {
    return date.getMonth();
  }
  
  public int getDayMon() {
    return date.getDay();
  }
  
  public int getYear() {
    return date.getYear();
  }
  
  public String getDay () {
    return day.toString();
  }
  
  public String getDate () {
    return date.toString();
  }
  
  public String toString () {
    return day + ", " + date;
  }
  
  public boolean validDate () {
    return date.checkBounds();
  }
}