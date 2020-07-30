package Leson_10;

/**
 * написать программу для вычисления корней квадратного уравнения
 */
public class SquareRoot {

      /*
       получить исходнык данные a b с
       вычислить дискрменант
       выбрать формулу для решения
      */

  public static void calculate ( int paramA, int paramB, int paramC) throws IllegalArgumentException {

      if ( paramA == 0 ) {
        throw new IllegalArgumentException ("Параметр 'a' не может быть равен нулю  ");
      }

     // вычислить дискриминант
     int discriminant = paramB * paramB - 4 * paramA * paramC;

      if ( discriminant < 0 ) {

        System.out.println("");

      } else if ( discriminant == 0  ) {

        System.out.println("");

      } else {

      }
  }

}
