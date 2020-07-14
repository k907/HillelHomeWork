package Lessons_6;

/**
 * Данный интерфейс описывает поведение животного
 */
public interface IAnimal {

  /**
   *  подать голос
   */
  default String voice () {
    return "Hello, ";
  }

}
