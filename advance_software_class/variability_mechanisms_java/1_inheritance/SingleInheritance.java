class Animal {
    String name;
    Animal(String name) {
        this.name = name;
    }
    void eat() {
        System.out.println(name + " khaana kha raha hai.");
    }
    void breathe() {
        System.out.println(name + " saans le raha hai.");
    }
}
class Dog extends Animal {
    String breed;
    Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }
    void bark() {
        System.out.println(name + " (" + breed + ") bhaunk raha hai: Woof! Woof!");
    }
}
public class SingleInheritance {
    public static void main(String[] args) {
        System.out.println("===== Single Inheritance Demo =====\n");
        Dog dog = new Dog("Bruno", "Labrador");
        dog.eat();
        dog.breathe();
        dog.bark();
        System.out.println("\nDog ka naam : " + dog.name);
        System.out.println("Dog ki breed: " + dog.breed);
    }
}
