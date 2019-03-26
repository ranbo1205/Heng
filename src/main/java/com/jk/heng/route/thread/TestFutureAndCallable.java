package com.jk.heng.route.thread;

import java.util.concurrent.*;

// https://www.cnblogs.com/cz123/p/7693064.html
public class TestFutureAndCallable {

    // 例子: 突然想做饭，需要网购厨具和去超市买食材，厨具和食材都到齐后才能做饭。
    // 多线程 实现的 目的: 在等 网购厨具到达的同时，去超市买食材
    // 多线程 用 Future 和 Callable 实现 的原因 : Future 和 callable  能保存返回多线程的返回值（而 Runnable 不能返回多线程执行的返回值）
    // Callable --> FutureTask --> FutureTask.get()
    // Callable --> Future --> Future.get()
    // new Thread(Callable).start()  方法一: 启动线程
    // ExecutorService.submit(callable)   或者 ExecutorService.submit(Runnable)
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // 模拟 做饭，需要 厨具 + 食材。使用多线程模拟:等待网购厨具的同时，去超市买食材。

        long start = System.currentTimeMillis();

        // 第一步 ： 网购厨具
        Callable<Chuju> chujuCallable = new Callable<Chuju>() {
            @Override
            public Chuju call() throws Exception {

                System.out.println("第一步 :  网上下单买厨具");
                System.out.println("第一步 :  等待送货");
                Thread.sleep(5000); // 模拟送货时间
                System.out.println("第一步 :  快递 厨具 送达");
                return new Chuju();
            }
        };

        //          方法一：启动线程
        /*
        FutureTask<Chuju> futureTask = new FutureTask<>(chujuCallable);
        new Thread(futureTask).start();
        */

        //          方法二： 启动线程
        /*
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Chuju> chujuFuture = executorService.submit(chujuCallable);
        executorService.shutdown();
        */

        //          方法三： 启动线程
        ExecutorService executorService = Executors.newCachedThreadPool();
        FutureTask<Chuju> futureTask = new FutureTask<>(chujuCallable);
        executorService.submit(futureTask);
        executorService.shutdown();


        // 第二步： 去超市买食材
        Thread.sleep(2000);
        Shicai shicai = new Shicai();
        System.out.println("第二步 ： 食材到位");



        // 第三步：用厨具烹饪食材
       //         方法一 和 方法三：启动线程
       if(!futureTask.isDone()){
            System.out.println("第三步 ： 厨具还没到位，心情好就等着(心情不好就调用cancel方法取消订单)");
        }

        Chuju chuju = futureTask.get(); // get()方法 会阻塞线程，直到 futureTask线程执行结束，得到Chuju


       //        方法二: 启动线程
        /*
       if(chujuFuture.isDone()){
           System.out.println("第三步 ： 厨具还没到位，心情好就等着(心情不好就调用cancel方法取消订单)");
       }
       Chuju chuju = chujuFuture.get(); // get()方法 会阻塞线程，直到 Chuju 线程执行结束，得到Chuju
       */



        System.out.println("第三步 ： 厨具到位，开始展现厨艺");

        cook(chuju,shicai);


        long end = System.currentTimeMillis();
        System.out.println("总共耗时:"+(end - start)+"ms");

    }

    private static void cook(Chuju chuju, Shicai shicai) {}

    static class Chuju {}
    static class Shicai{}
}
