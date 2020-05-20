import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

public class WorkerThread extends Thread {

    private final Double recN;
    private final Lock lock;
    private final CountDownLatch resultLatch;
    private final ValueWrapper<Double> result;

    private final Double x;
    private final Double y;

    public WorkerThread(int identity,
                        int n,
                        Double x,
                        Double y,
                        Lock lock,
                        CountDownLatch resultLatch,
                        ValueWrapper<Double> result) {
        super(identity + "WorkingThread");
        this.recN = (1.0 / (double)n);
        this.x = x;
        this.y = y;
        this.lock = lock;
        this.resultLatch = resultLatch;
        this.result = result;
    }

    @Override
    public void run() {
        lock.lock();
        System.out.println("Thread " + getName() + " is calculating now");
        result.apply(r -> r + recN * x * y);
        lock.unlock();
        resultLatch.countDown();
    }
}
