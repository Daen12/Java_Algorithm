import java.util.Iterator;

public class memo {
    public static void main(String[] args) {
        System.out.println("test");
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        Iterator iter = set.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        // System.out.println(set.next());
        // System.out.println(set.next());
        // System.out.println(set.next());

    }
}
