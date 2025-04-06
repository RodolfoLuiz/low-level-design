import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ElevatorController {
    private final List<Elevator> elevators;

    public ElevatorController(int numElevators, int capacity) {
        elevators = new ArrayList<>();
        for(int i = 0; i < numElevators; i++) {
           Elevator elevator = new Elevator(i+1, capacity);
           elevators.add(elevator);
           elevators.add(elevator);
           new Thread(elevator::run).start();
        }
    }

    public void requestElevator(int sourceFloor, int destinationFloor) {
        Elevator optiomalElevator = findOptimalElevator(sourceFloor, destinationFloor);
        optiomalElevator.addRequest(new Request(sourceFloor, destinationFloor));
    }

    private Elevator findOptimalElevator(int sourceFloor, int destination) {
        Elevator optimalElevator = null;
        int minDistance = Integer.MAX_VALUE;
        for(Elevator elevator : elevators) {
            int distance = Math.abs(sourceFloor - elevator.getCurrentFloor());
            if(distance < minDistance) {
                minDistance = distance;
                optimalElevator = elevator;
            }
        }
        return optimalElevator;
    }
}