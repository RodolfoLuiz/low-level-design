import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ElevatorSystem {
    public static void main(String[] args) {
        ServiceLocator serviceLocator = ServiceLocator.getInstance();
        serviceLocator.registerElevatorController(new ElevatorController());
        ElevatorController elevatorController = serviceLocator.getElevatorController();
        elevatorController.createElevators(10);

        Thread user1 = new Thread(new ThreadUser(0, "user1"));
        Thread user2 = new Thread(new ThreadUser(0, "user2"));
        Thread user3 = new Thread(new ThreadUser(0, "user3"));
        Thread user4 = new Thread(new ThreadUser(0, "user4"));
        Thread user5 = new Thread(new ThreadUser(0, "user5"));
        Thread user6 = new Thread(new ThreadUser(0, "user6"));
        user1.start();
        user2.start();
        user3.start();
        user4.start();
        user5.start();
        user6.start();
    }

    static class ThreadUser implements Runnable {
        Random rand = new Random();
        private int currentFloor;
        private String userName;
        private final ElevatorController elevatorController;
        public ThreadUser(final int start, final String userName) {
            this.currentFloor = start;
            this.elevatorController = ServiceLocator.getInstance().getElevatorController();
            this.userName = userName;
        }
        @Override
        public void run() {
            this.elevatorController.notify(new Request(this.userName, this.currentFloor, rand.nextInt(100)));
        }
    }
}
