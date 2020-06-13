public class EvenOdd implements Runnable {
    int MAX = 10;
    Printer print;
    boolean isEven;

    public EvenOdd(Printer print, boolean isEven) {
        this.print = print;
        this.isEven = isEven;
    }

    @Override
    public void run() {
        int start = isEven ? 2 : 1;
        while (start <= MAX) {
            if (isEven)
                print.printEven(start);
            else
                print.printOdd(start);
            start += 2;
        }
    }

    public static void main(String[] args) {
        Printer print = new Printer();
        Thread t1 = new Thread(new EvenOdd(print, false), "ODD");
        Thread t2 = new Thread(new EvenOdd(print, true), "EVEN");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Printer {
    private volatile boolean isEven;

    public synchronized void printOdd(int num) {
        while (isEven) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " " + num);
        isEven = true;
        notify();
    }

    public synchronized void printEven(int num) {
        while (!isEven) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " " + num);
        isEven = false;
        notify();
    }
}
