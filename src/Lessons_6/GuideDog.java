package Lessons_6;

/**
 *  GuideDog имплементирует интерфейс IAnimalGuide и расширяет класс Pet
 */
public class GuideDog extends Pet implements IAnimalGuide {

  private boolean isTrained;

  public GuideDog(String name, int age, int weight, String color, boolean isTrained) {
    super(name, age, weight, color);
    this.isTrained = isTrained;
  }
  @Override
  public void takeHome () {
    System.out.println("I take you home");
  }

  @Override
  public String voice() {
    return super.voice() + ((isTrained == true) ? ". I can take you home" : "");
  }

  public boolean isTrained() {
    return isTrained;
  }

  public void setTrained(boolean trained) {
    isTrained = trained;
  }

}