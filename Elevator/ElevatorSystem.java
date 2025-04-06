import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ElevatorSystem {
    public static void run() {
        ElevatorController controller = new ElevatorController(3, 5);

        controller.requestElevator(5, 10);
        controller.requestElevator(3, 7);
        controller.requestElevator(8, 2);
        controller.requestElevator(1, 9);
    }
}
