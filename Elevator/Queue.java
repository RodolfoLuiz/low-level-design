import java.util.ArrayList;
import java.util.List;

public class Queue {
    private final List<Request> requests = new ArrayList<>();

    public Queue() {}

    public void pop(){
        requests.removeFirst();
    }
    public Request peek(){
        return requests.getFirst();
    }
    public boolean isEmpty(){
        return requests.isEmpty();
    }
    public boolean isFull(){
        return requests.size() >= 4;
    }
    public void push(Request request){
        int size = 4;
        if(requests.size()< size){
            requests.add(request);
        }
    }
}
