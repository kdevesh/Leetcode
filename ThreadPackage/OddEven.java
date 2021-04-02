package ThreadPackage;

public class OddEven {
    static int counter = 1;
    static boolean isEven = false;

    public synchronized void printEven() {
        while (counter <= 10) {
            if (isEven) {
                System.out.println(Thread.currentThread().getName() + " " + counter);
                counter++;
                isEven = false;
                notify();
            } else {
                try {
                    wait();
                } catch (InterruptedException ignored) {

                }
            }
        }
    }

    public synchronized void printOdd() {
        while (counter <= 10) {
            if (!isEven) {
                System.out.println(Thread.currentThread().getName() + " " + counter);
                counter++;
                isEven = true;
                notify();
            } else {
                try {
                    wait();
                } catch (InterruptedException ignored) {

                }
            }
        }
    }
}
