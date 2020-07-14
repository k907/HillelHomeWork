package Lessons_6;

public class RunAnimal {

  public static void main(String[] args) {

    Animal animal = new Animal(5,6, "brown");

    WildAnimal wildAnimal = new WildAnimal(15,50, "red", true);
    Pet pet = new Pet ("Paw",5, 15, "black");
    Dog dog = new Dog ("Figaro",5, 15, "black");
    Fish fish = new Fish ("Dori",1, 1, "gold");
    Cat cat = new Cat ("Matroskin",12, 4, "white");
    Wolf wolf = new Wolf (5,20, "gray", true);
    Lion lion = new Lion (6,60, "yellow", true);
    Giraffe giraffe = new Giraffe (4,500, "yellow", false);
    Crocodile crocodile = new Crocodile (2,70, "green", true);
    Hamster hamster = new Hamster ("Chip",1, 1,"gray");
    GuideDog guideDog = new GuideDog ("Lesi",6, 12,"black",true);

    System.out.println("Animal: " + animal.voice() );

    System.out.println("Pet: " + pet.voice() );

    System.out.println("WildAimal: " + wildAnimal.voice() );

    System.out.println("Dog: " + dog.voice() );

    System.out.println("Cat: " + cat.voice());

    System.out.println("Fish: " + fish.voice() );

    System.out.println("Wolf: " + wolf.voice() );

    System.out.println("Lion: " + lion.voice() );

    System.out.println("Giraffe: " + giraffe.voice() );

    System.out.println("Crocodile: " + crocodile.voice() );

    System.out.println("Hamster: " + hamster.voice() );

    System.out.println("GuideDog: " + guideDog.voice() );
    guideDog.takeHome();

  }


}
