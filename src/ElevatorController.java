public class ElevatorController {
    private Building building;

    public ElevatorController(Building building) {
        this.building = building;
    }

    public void tick() {
        for (Elevator elevator : building.getElevators()) {
            if (elevator.isMoving()) {
                int nextFloor = elevator.getNextDestination();
                if (nextFloor == -1) {
                    elevator.stop();
                } else {
                    elevator.move(nextFloor);
                }
            } else {
                int currentFloor = elevator.getCurrentFloor();
                if (elevator.hasDestination(currentFloor)) {
                    elevator.removeDestination(currentFloor);
                    elevator.unload(building.getFloors().get(currentFloor).getNumPeopleWaiting());
                    building.getFloors().get(currentFloor).setNumPeopleWaiting(0);
                } else {
                    Direction direction = getDirection(elevator);
                    if (direction == Direction.UP) {
                        for (int i = currentFloor + 1; i < building.getNumFloors(); i++) {
                            if (elevator.hasDestination(i)) {
                                elevator.move(i);
                                break;
                            }
                        }
                    } else {
                        for (int i = currentFloor - 1; i >= 0; i--) {
                            if (elevator.hasDestination(i)) {
                                elevator.move(i);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    private Direction getDirection(Elevator elevator) {
        if (elevator.getNumDestinations() == 0) {
            return Direction.UP;
        }
        if (elevator.isGoingUp()) {
            return Direction.UP;
        }
        return Direction.DOWN;
    }
}
