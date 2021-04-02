package ThreadPackage;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadRace obj = new ThreadRace();
        OddEven oddEven = new OddEven();
        Map<String, String> x = new HashMap<>();
        x.put("A", "A");
        x.put("B", "B");
        Map<String, String> y = new HashMap<>();
        y.put("A", "B");
        y.put("B", "A");
        String sellerID = "sellerID";
        String loginId = "loginId";
        String sellerID2 = "dummy";
        String loginId2 = "devesh";
        Thread a = new Thread(() -> obj.check(x, sellerID, loginId), "A");
        Thread b = new Thread(() -> obj.check(y, sellerID2, loginId2), "B");
        a.start();
        b.start();

        Thread even = new Thread(oddEven::printEven,"Even Thread");
        Thread odd = new Thread(oddEven::printOdd,"Odd Thread");
        even.start();
        odd.start();
        even.join();
        odd.join();

    }
}
