package ThreadPackage;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadRace obj = new ThreadRace();
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
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.check(x, sellerID, loginId);
            }
        }, "A");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.check(y, sellerID2, loginId2);
            }
        }, "B");
        a.start();
        b.start();
    }
}
