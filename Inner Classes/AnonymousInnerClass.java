package innerclasses;

public class AnonymousInnerClass {
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				for(int i=0; i<10; i++) {
					System.out.println("Anonymous");
				}
			}
		}.run();
		
		methodLocal();
	}
	public static void methodLocal() {
		class innerClass{
			public void print() {
				System.out.println("From the method local inner class");
			}
		}
		new innerClass().print();
	}
	
}



