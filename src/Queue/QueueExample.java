package Queue;
import Queue.Queue;

public class QueueExample {
    public static void main(String[] args) throws Exception {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue().data);
        System.out.println(queue.dequeue().data);
        System.out.println(queue.front().data);
    }
}
