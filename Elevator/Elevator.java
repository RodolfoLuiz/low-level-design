import java.util.ArrayList;
import java.util.List;
public class Elevator{
    private final int id;
    private final int capacity;
    private int currentFloor;
    private Direction currentDirection;
    private final List<Request> requests;

    public Elevator(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.currentFloor = 1;
        this.currentDirection = Direction.UP;
        this.requests = new ArrayList<>();
    }

    public synchronized void addRequest(Request request){
        if(requests.size()<capacity){
            requests.add(request);
            notifyAll();
        }
    }

    public synchronized Request getNextRequest(){
        while (requests.isEmpty()){
            try{
                wait();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        return requests.removeFirst();
    }

    public synchronized void processRequests(){
        while(true){
            while(!requests.isEmpty()){
                Request request = getNextRequest();
                processRequest(request);
            }
            try{
                wait();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private void processRequest(Request request){
        int startFloor = currentFloor;
        int endFloor = request.getDestinationFloor();

        if(startFloor<endFloor){
            currentDirection = Direction.UP;
            for (int i = startFloor; i <= endFloor; i++){
                currentFloor = i;
                try{
                    Thread.sleep(1000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        } else if(startFloor>endFloor){
            currentDirection = Direction.DOWN;
            for (int i = endFloor; i >= startFloor; i--){
                currentFloor = i;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public void run(){
        processRequests();
    }
    public int getCurrentFloor() {
        return currentFloor;
    }
}