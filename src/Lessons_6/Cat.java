package Lessons_6;

public class Cat extends Pet {

  public Cat(String name, int age, int weight, String color) {
    super(name, age, weight, color);
  }

  @Override
  public String voice() {
    return super.voice() + " Meow";
  }

}
