public class Elevator implements RequestListener{
    private final int capacity;
    private final Queue requests = new Queue();
    private int currentFloor;
    private Direction currentDirection;
    private final int number;

    public Elevator(final int capacity, final int number, final int currentFloor, final Direction currentDirection) {
        this.capacity = capacity;
        this.number = number;
        this.currentFloor = currentFloor;
        this.currentDirection = currentDirection;
    }


    @Override
    public void update(Request request) {
        if(requests.isFull()){

        }
    }
}