public class DateFormat {
  private String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
  private String values[];
  private int date[];
  
  public DateFormat (String in) {
    values = in.split("[^a-zA-Z0-9']+");
    
    //values = removeNull(values);
    date = new int[]{0, 0, 0};
    if (values.length != 3) {
      //date = new int[]{-1,-1,-1};
    }  
   
    setMonth();
    setDay();
    setYear();
  } 
 
  private void setMonth () {
    try { 
      date[0] = Integer.parseInt(values[0]); 
    } catch (Exception e) { 
    }
  }
  
  private void setDay () {   
    try { 
      date[1] = Integer.parseInt(values[1]); 
    } catch (Exception e) { 
    } 
  }
  
  private void setYear() {
    try { 
      date[2] = Integer.parseInt(values[2]); 
    } catch (Exception e) { 
    }  
  }
  
  public boolean checkBounds () {
    Boolean valid = true;
    
    if (getMonth() <= 0 || getDay() <= 0 || getYear() <= 0) valid = false;    
    else if (getMonth() > 12) valid = false;   
    else if (getYear() >= 10000) valid = false;
    
    else if (getMonth() == 1 || getMonth() == 3 || getMonth() == 5 || getMonth() == 7 || getMonth() == 8 || getMonth() == 10 || getMonth() == 12) {
      if (getDay() >= 32) valid = false; 
    } 
    
    else if (getMonth() == 4 || getMonth() == 6 || getMonth() == 9 || getMonth() == 11) {
      if (getDay() >= 31) valid = false;
    } 
    
    else if (getMonth() == 2) {
      if ((getYear() % 4) == 0 && getDay() >= 30) valid = false;
      else if ((getYear() % 4) != 0 && getDay() >= 29) valid = false; 
    }
    
    return valid;
  }
  
  /*private String[] removeNull(String[] in) {
    int length = 1;
    String[] s = new String[in.length];
    String finalConvert[];
    
    for (int i = 0; i < s.length; i++) {
      if (in[i] != null) s[length-1] = in[i];
    }
    
    finalConvert = new String[length];
    System.arraycopy(s, 0, finalConvert, 0, length);
    
    for (String ss: finalConvert) {
      System.out.println(ss);
    }
    return finalConvert;
  }*/
  
  public int[] getArr () {
    return date;
  }
  
  public int getMonth() {
    return date[0];
  }
  
  public int getDay () {
    return date[1];
  }
  
  public int getYear () {
    return date[2];
  }
  
  public String toString () {
    return months[date[0]-1] + " " + date[1] + ", " + date[2];
  }
}