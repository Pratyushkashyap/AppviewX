import Controllers.LiftController;
import Models.*;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LiftSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of floors:");
        int numFloors = scanner.nextInt();

        System.out.println("Enter the number of Lifts:");
        int numLifts = scanner.nextInt();

        System.out.println("Enter the number of people:");
        int numPeople = scanner.nextInt();

        List<Lift> LiftsList = new ArrayList<>();
        for (int i = 1; i <= numLifts; i++) {
            LiftsList.add(new Lift("Lift" + i));
        }

        LiftController LiftController = new LiftController(LiftsList);

        List<Person> peopleList = new ArrayList<>();
        for (int i = 0; i < numPeople; i++) {
            System.out.println("Enter person_name, arriving_time, from_floor, to_floor:");
            String name = scanner.next();
            int arrivingTime = scanner.nextInt();
            int fromFloor = scanner.nextInt();
            int toFloor = scanner.nextInt();
            peopleList.add(new Person(name, arrivingTime, fromFloor, toFloor));
        }

        // Sort people based on arriving time
        peopleList.sort(Comparator.comparingInt(Person::getArrivingTime));

        for (Person person : peopleList) {
            Lift lift = LiftController.requestLift(person.getFromFloor());
            System.out.println("Pick up " + person.getName() + " from " + lift.getName());
            // Move Lift to the person's floor
            while (lift.getCurrentFloor() != person.getFromFloor()) {
                if (lift.getCurrentFloor() < person.getFromFloor()) {
                    lift.moveUp();
                } else {
                   lift.moveDown();
                }
            }
            System.out.println("Drop " + person.getName() + " at floor no -" + person.getToFloor() + " from " + lift.getName());
            // Move Lift to the person's destination floor
            while (lift.getCurrentFloor() != person.getToFloor()) {
                if (lift.getCurrentFloor() < person.getToFloor()) {
                    lift.moveUp();
                } else {
                    lift.moveDown();
                }
            }
            // Stop the Lift at the destination floor
            lift.stop();
        }
    }
}