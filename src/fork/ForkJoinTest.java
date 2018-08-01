package fork;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinMy forkJoinMy = new ForkJoinMy(1, 100000000);
        long start=System.currentTimeMillis();
        ForkJoinTask<Integer> submit = forkJoinPool.submit(forkJoinMy);
        long end=System.currentTimeMillis();
        System.out.println(end-start);


        long start1=System.currentTimeMillis();
        test1();
        long end1=System.currentTimeMillis();
        System.out.println("start1>>"+(end1-start1));
    }
    private static void test1(){
        int sum=0;
        for (int i=0;i<100000000;i++){
            sum+=i;
        }
    }
}


class ForkJoinMy extends RecursiveTask<Integer>{

    private static final int threadHold=3;
    private int start;
    private int end;

    public ForkJoinMy(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum=0;
        boolean can=(end-start)>threadHold;
        if (can){
            for (int i=start;i<end;i++){
                sum+=1;
            }
        }else {
            int middle=(start+end)/2;
            ForkJoinMy forkJoinMy = new ForkJoinMy(start, middle);
            ForkJoinMy forkJoinMy1 = new ForkJoinMy(middle + 1, end);
            invokeAll(forkJoinMy,forkJoinMy1);
            Integer join = forkJoinMy.join();
            Integer join1 = forkJoinMy1.join();
            sum=join+join1;
        }
        return sum;
    }


}
