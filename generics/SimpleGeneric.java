import java.util.Comparator;

class Generic<T> {
    T memeber;
    public void set(T memeber) {
        this.memeber = memeber;
    }

    public T get() {
        return memeber;
    }

    public static <E extends Comparable<E>> int isEqual(E first, E second) {
        return first.compareTo(second);
    }
}


public class SimpleGeneric {
    public static void main(String[] args) {
        Generic<Integer> g1 = new Generic(), g2 = new Generic();
        g1.set(100);
        g2.set(100);

        // since both string and integer extend comparable this will work
        int isEqual = Generic.<String>isEqual("12", "13");
        System.out.println(isEqual);
        isEqual = Generic.<Integer>isEqual(12, 12);
        System.out.println(isEqual);

        System.out.println("Example complete");
    }
}
