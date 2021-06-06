import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueEx {
    public static void main(String[] args) {
        Queue<Integer> q = new PriorityQueue<>(10, (o1, o2) -> o2-o1);
        q.add(10);
        q.add(-1);
        q.add(9);
        q.add(1);
        while(!q.isEmpty()){
            System.out.println(q.poll());
        }
    }
}
