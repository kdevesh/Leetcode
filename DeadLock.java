public class DeadLock {
    public static void main(String[] args) {
        String str1 = "Devesh";
        String str2 = "Kumar";
        Thread t1 = new Thread("First"){
          public void run(){
              while(true){
                  synchronized (str1){
                      synchronized (str2){
                          System.out.println(str1+str2);
                      }
                  }
              }
          }
        };
        Thread t2 = new Thread("First"){
            public void run(){
                while(true){
                    synchronized (str2){
                        synchronized (str1){
                            System.out.println(str1+str2);
                        }
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
