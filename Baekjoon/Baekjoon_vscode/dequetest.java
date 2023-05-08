import java.util.ArrayDeque;
import java.util.Deque;

public class dequetest {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        System.out.println(deque);
        for (int i : deque) {
            System.out.println(i);
        }
    }
}
