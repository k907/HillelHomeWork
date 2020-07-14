package Lessons_6;

/**
 * Данный интерфейс описывает поведение животного
 */
public interface IAnamal {

  /**
   *  подать голос
   */
  default String voice () {
    return "Hello, ";
  }

}
