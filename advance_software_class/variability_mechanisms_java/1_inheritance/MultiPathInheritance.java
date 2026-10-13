interface GrandParent {
    default void displayMessage() {
        System.out.println("Main GrandParent hoon — shared behaviour.");
    }
    void identity();
}
interface Parent1 extends GrandParent {
    default void parent1Feature() {
        System.out.println("Parent1 ki khaasiyat: Engineering branch.");
    }
}
interface Parent2 extends GrandParent {
    default void parent2Feature() {
        System.out.println("Parent2 ki khaasiyat: Medical branch.");
    }
}
class Child implements Parent1, Parent2 {
    String childName;
    Child(String childName) {
        this.childName = childName;
    }
    @Override
    public void identity() {
        System.out.println("Main " + childName + " hoon — dono Parent1 aur Parent2 ka child.");
    }
    @Override
    public void displayMessage() {
        Parent1.super.displayMessage();
        System.out.println("(Diamond resolved: Parent1 ka message use kiya)");
    }
    void showAllAbilities() {
        System.out.println("\n--- " + childName + " ki saari abilities ---");
        identity();
        displayMessage();
        parent1Feature();
        parent2Feature();
    }
}
abstract class BaseVehicle {
    abstract void fuelType();
    void move() {
        System.out.println("Vehicle chal rahi hai.");
    }
}
abstract class LandVehicle extends BaseVehicle {
    void driveOnRoad() {
        System.out.println("Sadak par chal rahi hai.");
    }
}
abstract class WaterVehicle extends BaseVehicle {
    void sailOnWater() {
        System.out.println("Paani par chal rahi hai.");
    }
}
interface LandCapable {
    void driveOnLand();
}
interface WaterCapable {
    void floatOnWater();
}
class HoverCraft extends BaseVehicle implements LandCapable, WaterCapable {
    @Override
    public void fuelType() {
        System.out.println("HoverCraft: Petrol + Air cushion use karta hai.");
    }
    @Override
    public void driveOnLand() {
        System.out.println("HoverCraft zameen par chal sakta hai.");
    }
    @Override
    public void floatOnWater() {
        System.out.println("HoverCraft paani par tair sakta hai.");
    }
}
public class MultiPathInheritance {
    public static void main(String[] args) {
        System.out.println("===== Multipath / Diamond Inheritance Demo =====\n");
        System.out.println("--- Interface Diamond ---");
        Child child = new Child("Arjun");
        child.showAllAbilities();
        System.out.println("\n--- Polymorphism via GrandParent interface ---");
        GrandParent gp = child;
        gp.identity();
        gp.displayMessage();
        System.out.println("\n--- HoverCraft (class + interface multipath) ---");
        HoverCraft hc = new HoverCraft();
        hc.fuelType();
        hc.move();
        hc.driveOnLand();
        hc.floatOnWater();
    }
}
