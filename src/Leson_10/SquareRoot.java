package Leson_10;

/**
 * написать программу для вычисления корней квадратного уравнения
 */
public class SquareRoot {

  public static void calculate ( int paramA, int paramB, int paramC) throws IllegalArgumentException {

      if ( paramA == 0 ) {
        throw new IllegalArgumentException ("Параметр 'a' не может быть равен нулю  ");
      }

      // вычислить дискриминант
      int discriminant = paramB * paramB - 4 * paramA * paramC;

      if ( discriminant < 0 ) {

        System.out.println("У квадратного уравнения нет корней");

      } else if ( discriminant == 0  ) {

        double x1 = (-1 * paramB + Math.sqrt(discriminant)) / ( 2 * paramA ) ;
        System.out.println("У квадратного уравнения один корень: " + x1);

      } else {

        double x1 = (-1 * paramB + Math.sqrt(discriminant)) / ( 2 * paramA ) ;
        double x2 = (-1 * paramB - Math.sqrt(discriminant)) / ( 2 * paramA ) ;
        System.out.println("У квадратного уравнения два корня: x1 = " + x1 + " | x2 " + x2);

      }
  }

}
