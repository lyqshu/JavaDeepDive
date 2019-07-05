package yingqiao.javadeepdive;

/* this example couldn't to see difference of */
public class VolatileTest1 {
    static   int normal_count = 0;
    static volatile int volatile_count=0;
    static final int TIMES = 50;
    static final int THREADS = 3;
    private static final long SPINTIMES=10000000000L;

    private static void spin(long times){
        long total=0;
        for(long i=0; i<times; i++){
            total+=i;
        }
    }
    public static void main(String[] args) throws InterruptedException {
           Thread t1[] = new Thread[THREADS];
           for(int i=0; i<THREADS; i++) {
               t1[i] = new Thread(() -> {
                   for (int j = 0; j < TIMES; j++) {
                       spin(SPINTIMES);
                       System.out.println(++normal_count);
                       spin(SPINTIMES);
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
