class Single {
    private static Single test;
    private Single(){

    }
    static {
        test = new Single();
    }
    public static Single getTest1(){
        return test;
    }
}
public class Singleton {
    public static void main(String[] args) {
        Thread t1 = new Thread("demo") {
            public void run() {
                Single obj = Single.getTest1();
                if(obj!=null)
                    System.out.println("Found");
            }
        };
        Thread t2 = new Thread("demo2") {
            public void run() {
                Single obj = Single.getTest1();
                if(obj!=null)
                    System.out.println("Found");
            }
        };
        t1.start();
        t2.start();
    }
}