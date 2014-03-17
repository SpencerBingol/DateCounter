/************************************************
  * 
  * An implementation of Zeller's Congruence - presuming MM/DD/YYYY input
  * more information here: 
  * http://en.wikipedia.org/wiki/Zeller's_congruence
  * 
  * ********************************************/

public class DayOfWeek {
  private String days[] = { "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };
  private String wkDay; 
  private DateFormat format;
  
  public DayOfWeek (DateFormat in) {
    format = in;
    if (in.checkBounds()) calculate();
    else wkDay = "NaN";
  }
  
  private void calculate() {
    int yr = format.getYear();
    int day = format.getDay();
    int mon = format.getMonth();
    int cenYr = yr % 100;
    int cen = yr / 100;
    
    if (mon <= 2) {
      yr -= 1;
      mon += 12;
    }
    
    /****************************************
      * ALGORITHM: 
      * weekDay = (day + [13(mon + 1)/5] + cenYear + [cenYear/4] + [cen/4] - [2*cen]) MOD 7
      * cenYear = year of the century
      * ************************************/
    
    int weekDay = (day + ( ( 13*(mon+1) )/5 ) + cenYr + (cenYr/4) + (cen/4) - (2*cen) );
    weekDay %= 7;

    wkDay = days[weekDay]; 
  }
  
  public String toString () {
    return wkDay; 
  }
}