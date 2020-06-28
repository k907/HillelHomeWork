package Lessons_3;

/*
Вывести на экран шахматную доску 8х8 в виде 2 мерного массива (W - белые клетки , B - черные клети)
 */
public class Task13 {
  public static void main(String[] args) {

    int[][] chessBoard = new int[8][8];

    for (int line = 0; line < chessBoard.length; line++) {

      for (int column = 0; column < chessBoard.length; column++) {

        if (line % 2 != 0 ) { // нечетные строки (на доске)

             System.out.print( (column % 2 != 0 ) ? "W " : "B " );

        } else { // четные строки

             System.out.print( (column % 2 != 0 ) ? "B " : "W " );
        }
      }
      System.out.println();
    }
  }
}
