package Lessons_3;

/*
Создайте массив, содержащий 10 первых нечетных чисел. Выведете элементы массива на консоль в одну строку, разделяя запятой.
 */
public class Task8 {
  public static void main(String[] args) {

    int[] arrayOddNumber = new int[10];
    String strArray = "";

    for ( int i = 0; i < 10; i++ ) {
      arrayOddNumber[i] = i*2+1;
      strArray += arrayOddNumber[i] + ", ";
    }

    System.out.println(strArray.replaceAll(", $", ""));
  }
}
