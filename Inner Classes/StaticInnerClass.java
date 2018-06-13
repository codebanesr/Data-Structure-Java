package innerclasses;

public class StaticInnerClass {
	public static void main(String[] args) {
		Demo.Inner i = new Demo.Inner();
		i.print();
	}
}

class Demo{
	static class Inner{
		public void print() {
			System.out.println("Instance of static inner class");
		}
	}
}


