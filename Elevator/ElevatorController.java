import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ElevatorController {
    List<RequestListener> listeners = new ArrayList<>();
    List<Elevator> elevators = new ArrayList<>();

    public ElevatorController(){
    }

    public void createElevators(final int qty) {
        if(!elevators.isEmpty()) {
            return;
        }
        Random rand = new Random();
        for (int i = 0; i < qty; i++) {
            elevators.add(new Elevator(rand.nextInt(10), i, rand.nextInt(100), Direction.UP));
            subscribe(elevators.get(i));
        }
    }

    private void subscribe(RequestListener listener){
        listeners.add(listener);
    }
    public void notify(Request request){
        for(RequestListener listener : listeners){
            listener.update(request);
        }
    }
}