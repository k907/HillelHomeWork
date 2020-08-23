package Lesson_13;

public class Pair {

   private String valueUpperCase;
   private String valueLowerCase;

   public Pair ( String s ) {
     valueUpperCase = s.toUpperCase();
     valueLowerCase = s.toLowerCase();
   }

  @Override
  public String toString() {
    return "{\"" + valueLowerCase + "\", \"" + valueUpperCase + "\"}";
  }

  public String getValueUpperCase() {
    return valueUpperCase;
  }

  public void setValueUpperCase(String valueUpperCase) {
    this.valueUpperCase = valueUpperCase;
  }

  public String getValueLowerCase() {
    return valueLowerCase;
  }

  public void setValueLowerCase(String valueLowerCase) {
    this.valueLowerCase = valueLowerCase;
  }

}
