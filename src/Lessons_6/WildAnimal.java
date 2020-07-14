package Lessons_6;

public class WildAnimal extends Animal {

  private boolean isPredator;

  public WildAnimal(int age, int weight, String color, boolean isPredator) {
    super( age, weight, color);
    this.isPredator = isPredator;
  }

  @Override
  public String voice () {
    return super.voice() + "I am a wild animal" + ((isPredator == true) ? " and I am angry" : "");
  }

  @Override
  public String toString() {
    return "WildAimal {" +
            "id=" + getId() +
            " | age=" + getAge() +
            " | weight=" + getWeight() +
            " | color=" + getColor() +
            " | isPredator=" + isPredator +
            '}';
  }

  public boolean isPredator() {
    return isPredator;
  }

  public void setPredator(boolean predator) {
    isPredator = predator;
  }

}
