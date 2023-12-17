package Models;

public class Person {
    private String name;
    private int arrivingTime;
    private int fromFloor;
    private int toFloor;

    public Person(String name, int arrivingTime, int fromFloor, int toFloor) {
        this.name = name;
        this.arrivingTime = arrivingTime;
        this.fromFloor = fromFloor;
        this.toFloor = toFloor;
    }

    public String getName() {
        return name;
    }

    public int getArrivingTime() {
        return arrivingTime;
    }

    public int getFromFloor() {
        return fromFloor;
    }

    public int getToFloor() {
        return toFloor;
    }
}

