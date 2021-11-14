package ThreadPackage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ConcurrentHashMap;

public class CountLetterParallelMain {
    public static void main(String[] args) throws InterruptedException, IOException {
        ConcurrentHashMap<Character,Integer> map = new ConcurrentHashMap<>();
        String line = new String(Files.readAllBytes(Paths.get("ThreadPackage/sample-2mb-text-file.txt")));
        int lineLength = line.length();
        CountLetters countLettersObj1 = new CountLetters(line.substring(0,lineLength/4).toLowerCase(),map);
        CountLetters countLettersObj2 = new CountLetters(line.substring(lineLength/4,lineLength/2).toLowerCase(),map);
        CountLetters countLettersObj3 = new CountLetters(line.substring(lineLength/2,(3*lineLength)/4).toLowerCase(),map);
        CountLetters countLettersObj4 = new CountLetters(line.substring((3*lineLength)/4).toLowerCase(),map);
        Thread t1 = new Thread(countLettersObj1,"Thread-1");
        Thread t2 = new Thread(countLettersObj2,"Thread-2");
        Thread t3 = new Thread(countLettersObj3,"Thread-3");
        Thread t4 = new Thread(countLettersObj4,"Thread-4");
        long startTime = System.currentTimeMillis();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: "+(endTime-startTime)+" millis");
        map.forEach((k,v)-> System.out.println(k+"---->"+v));
    }
}
