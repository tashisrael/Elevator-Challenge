import java.util.LinkedList;
import java.util.Queue;

public class Floor {
    private Queue<Person> waitingQueue;

    public Floor() {
        waitingQueue = new LinkedList<>();
    }

    public Queue<Person> getWaitingQueue() {
        return waitingQueue;
    }

    public void addPersonToQueue(Person person) {
        waitingQueue.add(person);
    }

    public int getNumPeopleWaiting() {
        return waitingQueue.size();
    }
}
