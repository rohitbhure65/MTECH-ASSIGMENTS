class Vehicle {
    String brand;
    Vehicle(String brand) {
        this.brand = brand;
    }
    void start() {
        System.out.println(brand + " vehicle start ho gayi.");
    }
    void stop() {
        System.out.println(brand + " vehicle band ho gayi.");
    }
}
class Car extends Vehicle {
    int numberOfDoors;
    Car(String brand, int numberOfDoors) {
        super(brand);
        this.numberOfDoors = numberOfDoors;
    }
    void drive() {
        System.out.println(brand + " car chal rahi hai (" + numberOfDoors + " doors).");
    }
}
class ElectricCar extends Car {
    int batteryCapacity; 
    ElectricCar(String brand, int numberOfDoors, int batteryCapacity) {
        super(brand, numberOfDoors);
        this.batteryCapacity = batteryCapacity;
    }
    void charge() {
        System.out.println(brand + " electric car charge ho rahi hai (" + batteryCapacity + " kWh battery).");
    }
    void showRange() {
        int range = batteryCapacity * 6;
        System.out.println(brand + " ki estimated range: " + range + " km.");
    }
}
public class MultilevelInheritance {
    public static void main(String[] args) {
        System.out.println("===== Multilevel Inheritance Demo =====\n");
        ElectricCar tesla = new ElectricCar("Tesla", 4, 100);
        tesla.start();
        tesla.stop();
        tesla.drive();
        tesla.charge();
        tesla.showRange();
        System.out.println("\nBrand: " + tesla.brand);
        System.out.println("Doors: " + tesla.numberOfDoors);
        System.out.println("Battery: " + tesla.batteryCapacity + " kWh");
    }
}
