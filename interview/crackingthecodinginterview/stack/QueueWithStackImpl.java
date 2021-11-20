import java.util.*;
class QueueWithStack<T extends Object> {
	Stack<T> s1 = new Stack<>();
	Stack<T> s2 = new Stack<>();

    public boolean isEmpty() {
    	return s1.isEmpty() && s2.isEmpty();
    }
    public void enqueue(T element) {
    	s1.push(element);
    }
    public T dequeue() {
    	if(!s2.isEmpty()) {
    	    return s2.pop();
        }
        while(!s1.isEmpty()) {
        	s2.push(s1.pop());
        }
        return s2.pop();
    }
}


public class QueueWithStackImpl {
	public static void main(String args[]) {
    	QueueWithStack<Integer> q = new QueueWithStack<Integer>();
    	q.enqueue(1);
    	q.enqueue(99);
    	q.enqueue(3);
    	q.enqueue(4);
    	q.enqueue(5);
    	
        System.out.print("started ...");
    	
    	while(!q.isEmpty()) {
    	    System.out.print(q.dequeue() + ", ");
    	}
    }
}