public class Elevator {
    private int currentFloor;
    private int weightLimit;
    private int currentWeight;
    private boolean isMoving;
    private boolean isGoingUp;
    private List<Integer> destinations;

    public Elevator(int weightLimit) {
        this.currentFloor = 1;
        this.weightLimit = weightLimit;
        this.currentWeight = 0;
        this.isMoving = false;
        this.isGoingUp = true;
        this.destinations = new ArrayList<>();
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public boolean isGoingUp() {
        return isGoingUp;
    }

    public void move(int floor) {
        if (floor == currentFloor) {
            return;
        }
        isMoving = true;
        isGoingUp = floor > currentFloor;
        currentFloor = floor;
        destinations.remove(Integer.valueOf(floor));
    }

    public void load(int weight) {
        if (currentWeight + weight > weightLimit) {
            throw new IllegalStateException("Weight limit exceeded");
        }
        currentWeight += weight;
    }

    public void unload(int weight) {
        currentWeight -= weight;
    }

    public boolean isFull() {
        return currentWeight == weightLimit;
    }

    public boolean hasDestination(int floor) {
        return destinations.contains(floor);
    }

    public void addDestination(int floor) {
        if (!destinations.contains(floor)) {
            destinations.add(floor);
        }
    }

    public void removeDestination(int floor) {
        destinations.remove(Integer.valueOf(floor));
    }

    public int getNumDestinations() {
        return destinations.size();
    }

    public int getNextDestination() {
        if (destinations.isEmpty()) {
            return -1;
        }
        return destinations.get(0);
    }

    public void stop() {
        isMoving = false;
    }
}
