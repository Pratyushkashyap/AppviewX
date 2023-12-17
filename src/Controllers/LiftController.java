package Controllers;

import Models.Direction;
import Models.Lift;


import java.util.List;

public class LiftController {

    private List<Lift> Lifts;

    public LiftController(List<Lift> Lifts) {
        this.Lifts = Lifts;
    }

    public Lift requestLift(int fromFloor) {
        // Select the Lift closest to the requested floor
        Lift bestLift = Lifts.get(0);
        int minDistance = Math.abs(Lifts.get(0).getCurrentFloor() - fromFloor);

        for (Lift Lift : Lifts) {
            int distance = Math.abs(Lift.getCurrentFloor() - fromFloor);
            if (distance < minDistance) {
                minDistance = distance;
                bestLift = Lift;
            }
        }

        return bestLift;
    }

}
