package yingqiao.javadeepdive;

public class VolatileTest2 {
    /*if we do not use volatile here the loop will never stop due to not get latest value, both for primary type and
    * box type
    * */

    private static /*volatile*/   boolean  isStop = false;

    private static final int THREADCOUNT = 200;

    public static void main(String[] args) throws InterruptedException {

        Thread threads[] = new Thread[THREADCOUNT];

        for(int i=0; i<THREADCOUNT; i++){
            threads[i] = new Thread(()->{
                int tt =0;
                while(!isStop){
                      tt+=tt;
                }
            });
        }

        for(int i=0; i<THREADCOUNT; i++){
            threads[i].start();
        }

        isStop = true;
        Thread.sleep(2000);
        isStop = false;


        for(int i=0; i<THREADCOUNT; i++){
            threads[i].join();
        }
    }
}
