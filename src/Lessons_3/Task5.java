package Lessons_3;

/*
Даны переменные x и n вычислить x^n.
*/
public class Task5 {
  public static void main(String[] args) {

    int x = 2; // основание
    int n = 8; // показатель степени
    double result = 1d;

    if ( n == 0 ) {

      result = 1d;

    } else if ( n > 0 ) {

      for (int i = 0; i < n; i++) {
        result *= x;
      }

    } else {

      n = Math.abs(n);
      for (int i = 0; i < n; i++) {
        result *= x;
      }

      result =  1 / result;
    }

    System.out.println("Результат возведения в степень n числа x:  " + result );
  }
}
