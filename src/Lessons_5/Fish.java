package Lessons_5;

public class Fish extends Pet {

  public Fish(String name, int age, int weight, String color) {
    super(name, age, weight, color);
  }

  @Override
  public String voice() {
    return "....";
  }
}
