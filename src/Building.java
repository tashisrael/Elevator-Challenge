import java.util.ArrayList;
import java.util.List;

public class Building {
    private int numFloors;
    private List<Floor> floors;
    private List<Elevator> elevators;

    public Building(int numFloors, int numElevators, int elevatorCapacity) {
        this.numFloors = numFloors;
        floors = new ArrayList<>(numFloors);
        for (int i = 0; i < numFloors; i++) {
            floors.add(new Floor());
        }
        elevators = new ArrayList<>(numElevators);
        for (int i = 0; i < numElevators; i++) {
            elevators.add(new Elevator(i, elevatorCapacity));
        }
    }

    public int getNumFloors() {
        return numFloors;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public List<Elevator> getElevators() {
        return elevators;
    }
}
