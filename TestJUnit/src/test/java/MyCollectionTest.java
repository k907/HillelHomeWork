import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MyCollectionTest {

   private MyCollection testCollection;

   @BeforeEach
   public void init () {
      testCollection = new MyCollection();
   }

   @Test
   public void testAdd () {
     System.out.println(" -------------- testAdd  --------------");
     Object[] expected =  { "1", null, null, null, null, null, null, null, null, null };

     // проверка возвращаемого значения
     Assertions.assertTrue(testCollection.add("1"));

     // проверка изменения внутреннего массива
     Object[] arrayData = getPrivateField ( "arrayData" );
     Assertions.assertArrayEquals(expected, arrayData);

   }

  @Test
  public void testAddIndx () {
    System.out.println(" -------------- testAddIndx  --------------");
    Object[] expected =  {"1", "2", null, null, null, null, null, null, null, null };

    // проверка возвращаемого значения
    testCollection.add("2");
    Assertions.assertTrue (testCollection.add(0,"1"));

    // проверка изменения внутреннего массива
    Object[] arrayData = getPrivateField ( "arrayData" );
    Assertions.assertArrayEquals(expected, arrayData);

    // проверка исключения ArrayIndexOutOfBoundsException
    Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> testCollection.add(10,"10") );

  }

  @Test
  public void testDelete () {

    System.out.println(" -------------- testDelete  --------------");
    Object[] expected =  {"1", null, null, null, null, null, null, null, null, null };

    testCollection.add("1");
    testCollection.add("2");

    // проверка возвращаемого значения
    Assertions.assertTrue (testCollection.delete("2"));

    // проверка изменения размера масива
    Assertions.assertEquals(1, testCollection.size());

    // проверка изменения внутреннего массива
    Object[] arrayData = getPrivateField ( "arrayData" );
    Assertions.assertArrayEquals(expected, arrayData);
  }

  @Test
  public void testGet () {

    System.out.println(" -------------- testGet  --------------");

    testCollection.add("1");

    Assertions.assertEquals("1", testCollection.get(0));

    // проверка исключения ArrayIndexOutOfBoundsException
    Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> testCollection.get(10) );

  }

  @Test
  public void testContain () {

    System.out.println(" -------------- testContain  --------------");

    testCollection.add("1");
    Assertions.assertTrue( testCollection.contain("1"));

    Assertions.assertFalse( testCollection.contain("10"));

  }

  @Test
  public void testEquals () {

    System.out.println(" -------------- testEquals  --------------");

    var arrListTrue = new ArrayList<String>();
    arrListTrue.add("1");
    arrListTrue.add("2");
    arrListTrue.add("3");

    var arrListFalse = new ArrayList<String>();
    arrListFalse.add("1");

    testCollection.add("1");
    testCollection.add("2");
    testCollection.add("3");

    Assertions.assertTrue( testCollection.equals(arrListTrue));
    Assertions.assertFalse( testCollection.equals(arrListFalse));

  }

  @Test
  public void testClear () {

    System.out.println(" -------------- testClear  --------------");

    testCollection.add("1");
    testCollection.add("2");
    testCollection.add("3");

    // проверка возвращаемого значения
    Assertions.assertTrue (testCollection.clear());

    Assertions.assertTrue (testCollection.size() == 0);

  }


  @Test
  public void testSize () {

    System.out.println(" -------------- testSize  --------------");

    testCollection.add("1");
    testCollection.add("2");
    testCollection.add("3");

    Assertions.assertTrue (testCollection.size() == 3);

  }


  // получить приватное поле
  private Object[] getPrivateField ( String nameField ) {

    try {

      Field f = MyCollection.class.getDeclaredField(nameField);
      f.setAccessible(true);
      return (Object[]) f.get(testCollection);

    } catch (NoSuchFieldException | IllegalAccessException  e) {

      e.printStackTrace();

    }

    return null;
  }


}
