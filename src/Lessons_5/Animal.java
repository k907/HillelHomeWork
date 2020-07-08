package Lessons_5;

public class Animal {

  private int id;
  private int age;
  private int weight;
  private String color;

  public Animal( int age, int weight, String color) {
    this.id = (int) (Math.random() * 1000);
    this.age = age;
    this.weight = weight;
    this.color = color;
  }

  public String voice () {
    return "Hello, ";
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
}
