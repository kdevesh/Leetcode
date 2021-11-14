package ThreadPackage;

import java.util.concurrent.ConcurrentHashMap;

public class CountLetters implements Runnable {
    private final String line;
    private final ConcurrentHashMap<Character, Integer> concurrentHashMap;

    public CountLetters(String line, ConcurrentHashMap<Character, Integer> concurrentHashMap) {
        this.line = line;
        this.concurrentHashMap = concurrentHashMap;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" started at "+System.currentTimeMillis());
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) != ' ') {
                Integer value = concurrentHashMap.putIfAbsent(line.charAt(i), 1);
                if (value != null)
                    concurrentHashMap.computeIfPresent(line.charAt(i), (k, v) -> v + 1);
            }
        }
    }
}
