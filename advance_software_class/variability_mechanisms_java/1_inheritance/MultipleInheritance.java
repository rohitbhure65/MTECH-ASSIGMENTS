interface Flyable {
    void fly();
    default void showFlySpeed() {
        System.out.println("Yeh creature ud sakta hai!");
    }
}
interface Swimmable {
    void swim();
    default void showSwimSpeed() {
        System.out.println("Yeh creature tair sakta hai!");
    }
}
interface Walkable {
    void walk();
}
class Duck implements Flyable, Swimmable, Walkable {
    String name;
    Duck(String name) {
        this.name = name;
    }
    @Override
    public void fly() {
        System.out.println(name + " ud raha hai: Quack Quack! (flying mode)");
    }
    @Override
    public void swim() {
        System.out.println(name + " tair raha hai: Splash Splash!");
    }
    @Override
    public void walk() {
        System.out.println(name + " chal raha hai: Waddle Waddle!");
    }
    void quack() {
        System.out.println(name + ": QUACK QUACK!");
    }
}
class FlyingFish implements Flyable, Swimmable {
    String species;
    FlyingFish(String species) {
        this.species = species;
    }
    @Override
    public void fly() {
        System.out.println(species + " paani se uchhal ke ud raha hai!");
    }
    @Override
    public void swim() {
        System.out.println(species + " paani mein tair raha hai.");
    }
}
public class MultipleInheritance {
    public static void main(String[] args) {
        System.out.println("===== Multiple Inheritance (via Interfaces) Demo =====\n");
        Duck donald = new Duck("Donald");
        System.out.println("--- Duck ---");
        donald.fly();
        donald.swim();
        donald.walk();
        donald.quack();
        donald.showFlySpeed();
        donald.showSwimSpeed();
        System.out.println();
        System.out.println("--- FlyingFish ---");
        FlyingFish nemo = new FlyingFish("Exocoetidae");
        nemo.fly();
        nemo.swim();
        System.out.println("\n--- Polymorphism via Interface Reference ---");
        Flyable f = donald;
        f.fly();
        Swimmable s = nemo;
        s.swim();
    }
}
