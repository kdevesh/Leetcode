import java.util.*;
class Counter{
    public int counter=0;
    public void add(){
        synchronized (this){
            this.counter+=1;
            System.out.println(this.counter);
            System.out.println(Thread.currentThread().getName());
        }
    }
}
class Sync implements Runnable{

    public Counter counter = null;
    Sync(Counter c){
        counter = c;
    }
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        for(int i=0;i<10;i++)
            counter.add();
    }
}

public class Test{
    public static void main(String[] args) {
        Counter c = new Counter();
        Sync obj = new Sync(c);
        Thread t1 = new Thread(obj);
        Thread t2 = new Thread(obj);
        t1.start();
        t2.start();

    }
}
