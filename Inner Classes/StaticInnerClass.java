package innerclasses;

public class StaticInnerClass {
    public static void main(String[] args) {
        //Creating object for static inner class
        Demo.Inner i = new Demo.Inner();
        i.print();
        
        
        //creating object for non static inner class
        Demo d = new Demo();
        Demo.nonStaticInner nsi = d.new nonStaticInner();
    }
}

class Demo{
    
    private static int variable1 = 20;
    private int variable2 = 30;
    static class Inner{
        public void print() {
            System.out.println("Instance of static inner class");
            System.out.println(variable1);
        }
    }
    
    class nonStaticInner{
        public void accessprivate() {
            System.out.println(variable2);
        }
    }
}



