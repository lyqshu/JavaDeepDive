package yingqiao.javadeepdive;

public class VolatileTest1 {
    static   int normal_count = 0;
    static volatile int volatile_count=0;
    static final int TIMES = 500;
    static final int THREADS = 1000;

    public static void main(String[] args) throws InterruptedException {
           Thread t1[] = new Thread[THREADS];
           for(int i=0; i<THREADS; i++) {
               t1[i] = new Thread(() -> {
                   for (int j = 0; j < TIMES; j++) {
                       System.out.println(++normal_count);
                       System.out.println(++volatile_count);
                       System.out.println();
                   }
               });
           }
           for(int i=0; i<THREADS; i++){
               t1[i].start();
           }
        for(int i=0; i<THREADS; i++){
            t1[i].join();
        }
        System.out.println("The total number is :");
        System.out.println(normal_count);
        System.out.println(volatile_count);
    }
}
