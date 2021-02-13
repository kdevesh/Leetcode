package ThreadPackage;

import java.util.Map;

public class ThreadRace {
    public void check(Map<String, String> map, String selleId, String loginId) {
        if (Thread.currentThread().getName().equals("A")) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(selleId + " " + loginId + " " + map);
    }
}
