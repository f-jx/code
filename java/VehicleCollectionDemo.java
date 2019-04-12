import java.util.*;

class Vehicle {
    public String type;
    public String size;
    public String color;

    public float weight(String type) {
        float weight = 0;
        switch (type) {
        case "Car":
            weight = 2;
            break;
        case "Truck":
            weight = 20;
            break;
        case "Bus":
            weight = 15;
            break;
        }
        return weight;
    }

    public int seat(String type) {
        int seat = 0;
        if (type == "Car") {
            seat = 5;
        } else if (type == "Truck") {
            seat = 3;
        } else if (type == "Bus") {
            seat = 60;
        }
        return seat;
    }

    public int whell(String type) {
        int whell = 0;
        if (type == "Car") {
            whell = 4;
        } else if (type == "Truck") {
            whell = 8;
        } else if (type == "Bus") {
            whell = 6;
        }
        return whell;
    }

    public String output() {
        String output = "\nThis is a " + this.size + " " + this.color + " " + this.type + ", weight: "
                + this.weight(this.type) + ", seat: " + this.seat(this.type) + ", whell: " + this.whell(this.type);
        return output;
    }
}

class Car extends Vehicle {
    public Car() {
        this.type = "Car";
        this.size = "small";
        this.color = "red";
    }

    public Car(String type, String size, String color) {
        this.type = type;
        this.size = size;
        this.color = color;
    }

}

class Truck extends Vehicle {
    public Truck() {
        this.type = "Truck";
        this.size = "middle";
        this.color = "yellow";
    }

    public Truck(String type, String size, String color) {
        this.type = type;
        this.size = size;
        this.color = color;
    }

}

class Bus extends Vehicle {
    public Bus() {
        this.type = "Bus";
        this.size = "big";
        this.color = "blue";
    }

    public Bus(String type, String size, String color) {
        this.type = type;
        this.size = size;
        this.color = color;
    }

}

public class VehicleCollectionDemo {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car("Car", "middle", "purple");
        Truck truck1 = new Truck();
        Truck truck2 = new Truck("Truck", "small", "green");
        Bus bus1 = new Bus();
        Bus bus2 = new Bus("Bus", "mini", "skyblue");
        Collection A = new ArrayList<>();
        A.add(car1.output());
        A.add(car2.output());
        A.add(truck1.output());
        A.add(truck2.output());
        A.add(bus1.output());
        A.add(bus2.output());
        System.out.println("ArrayList Elements\n " + A);
    }
}
