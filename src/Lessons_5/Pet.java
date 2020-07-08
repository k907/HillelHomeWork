package Lessons_5;

public class Pet extends Animal {

  private String name;
  private boolean isVaccinated;

  public Pet (String name, int age, int weight, String color) {
    super( age, weight, color);
    this.name = name;
  }

  public String voice () {
    return super.voice() + "my name is " + name;
  }

  @Override
  public String toString() {
    return "Pet {" +
            "id=" + getId() +
            " | age=" + getAge() +
            " | weight=" + getWeight() +
            " | color=" + getColor() +
            " | isVaccinated=" + isVaccinated +
            '}';
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isVaccinated() {
    return isVaccinated;
  }

  public void setVaccinated(boolean vaccinated) {
    isVaccinated = vaccinated;
  }
}
