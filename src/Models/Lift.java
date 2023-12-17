package Models;

import lombok.Getter;
import lombok.Setter;

@Setter
public class Lift {

    private String name;
    private int currentFloor;
    private Direction direction;

    public Lift(String name) {
        this.name = name;
        this.currentFloor = 0;
        this.direction = Direction.NONE;
    }

    public String getName() {
        return name;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void moveUp() {
        currentFloor++;
        direction = Direction.UP;
    }

    public void moveDown() {
        currentFloor--;
        direction = Direction.DOWN;
    }

    public void stop() {
        direction = Direction.NONE;
    }
}
