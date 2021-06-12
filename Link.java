
public class Link {
	public static void main(String[] args) {
		SinglyLink sl = new SinglyLink();
		sl.addFirst(12);
		sl.addFirst(22);
		
		
		SinglyLink.Iterator it = sl.new Iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}	
		sl.reverse();
		System.out.println("\nAfter reversing");
	
		SinglyLink.Iterator it2 = sl.new Iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
	}
}


class SinglyLink{
	Node head;
	SinglyLink(){
		head = null;
	}
	
	public void addFirst(int data) {
		Node nn = new Node(data);
		if(head == null) {
			head = nn;
		}else {
			nn.next = head;
			head = nn;
		}
	}
	
	
	//how do you want to see this class when called from sysout
	public String toString() {
		String res = "";
		Node temp = head;
		while(temp!=null) {
			res+=temp.data+",";
			temp = temp.next;
		}
		return res;
	}
	
	
	class Iterator{
		Node iterator = head;
//		This is why we should not add elements while iteration
//		new elements are added but the iterator still holds on to the head
		public boolean hasNext() {
			if(iterator!=null)
				return true;
			return false;
		}
		
		public int next() {
			int temp = iterator.data;
			iterator = iterator.next;
			return temp;
		}
	}
	
	public void reverse() {
		Node prev, curr, next;
		prev = null;
		curr = head;
		next = null;
		
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}
}

class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		next = null;
	}
}
