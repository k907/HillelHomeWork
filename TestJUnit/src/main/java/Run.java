import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class Run {

  public static void main(String[] args) {

    MyCollection colection = new MyCollection();

    colection.add("1");
    colection.add("2");
    colection.add("3");
    System.out.println(colection.toString());

  }
}
