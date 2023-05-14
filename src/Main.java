import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Building building = new Building(10, 2, 10);
        ElevatorController controller = new ElevatorController(building);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            controller.tick();
            printStatus(building);
            System.out.println("Enter a command: ");
            String command = scanner.nextLine();
            if (command.equals("q")) {
                break;
            }
            processCommand(building, command);
        }
    }

    private static void printStatus(Building building) {
        System.out.println("Building status:");
        for (int i = building.getNumFloors() - 1; i >= 0; i--) {
            System.out.print("Floor " + i + ": " + building.getFloors().get(i).getNumPeopleWaiting() + " people waiting | ");
            for (Elevator elevator : building.getElevators()) {
                if (elevator.getCurrentFloor().getNumber() == i) {
                    System.out.print("Elevator " + elevator.getId() + " | ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void processCommand(Building building, String command) {
        if (command.startsWith("c")) {
            int elevatorIndex = Integer.parseInt(command.substring(1));
            Elevator elevator = building.getElevators().get(elevatorIndex);
            int currentFloor = elevator.getCurrentFloor().getNumber();
            System.out.println("Elevator " + elevator.getId() + " is on floor " + currentFloor);
            System.out.println("Enter a new floor: ");
            int newFloor = Integer.parseInt(new Scanner(System.in).nextLine());
            controller.addDestination(elevator, building.getFloors().get(newFloor));
        } else if (command.startsWith("f")) {
            int floorIndex = Integer.parseInt(command.substring(1));
            Floor floor = building.getFloors().get(floorIndex);
            floor.addWaitingPassenger();
            System.out.println("Person added to floor " + floorIndex);
        } else {
            System.out.println("Invalid command!");
        }
    }
}
