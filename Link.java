
public class Link {
	public static void main(String[] args) {
		SinglyLink sl = new SinglyLink();
		sl.addFirst(12);
		sl.addFirst(22);
		
		
		SinglyLink.Iterator it = sl.new Iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
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
}




class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		next = null;
	}
}
