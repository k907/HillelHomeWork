package Lessons_5;

public class Dog extends Pet {

  public Dog(String name, int age, int weight, String color) {
    super(name, age, weight, color);
  }

  @Override
  public String voice() {
    return super.voice() + " Woof";
  }
}
