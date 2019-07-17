package test;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author qiaoxin
 * @Date 2019/7/17
 */
public class ThreadTest {


    /**
     * 自动创建线程池
     */
    private static void autoThreadPool() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("xxx-pool-%d").build();
        Executor singleThreadExecutor = Executors.newSingleThreadExecutor();
        Executor newFixedThreadPool=Executors.newFixedThreadPool(5,threadFactory);
        Executor newCachedThreadPool=Executors.newCachedThreadPool();
        Executor newScheduledThreadPool=Executors.newScheduledThreadPool(5);

    }


    /**
     * 手动创建线程池
     */
    private static void manualThreadPool() {
        // 创建线程工厂
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("xxx-pool-%d").build();
        /*
          参数含义：
           corePoolSize : 线程池中常驻的线程数量。核心线程数，默认情况下核心线程会一直存活，即使处于闲置状态也不会受存keepAliveTime限制。除非将allowCoreThreadTimeOut设置为true。
           maximumPoolSize : 线程池所能容纳的最大线程数。超过这个数的线程将被阻塞。当任务队列为没有设置大小的LinkedBlockingDeque时，这个值无效。
           keepAliveTime : 当线程数量多于 corePoolSize 时，空闲线程的存活时长，超过这个时间就会被回收
           unit : keepAliveTime 的时间单位
           workQueue : 存放待处理任务的队列，该队列只接收 Runnable 接口
           threadFactory : 线程创建工厂
           handler : 当线程池中的资源已经全部耗尽，添加新线程被拒绝时，会调用RejectedExecutionHandler的rejectedExecution方法，参考 ThreadPoolExecutor 类中的内部策略类
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 200, 0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 1000; i++) {
            threadPoolExecutor.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
        threadPoolExecutor.shutdown();
    }


    public static void main(String[] args) {
        manualThreadPool();
        autoThreadPool();
    }

}
