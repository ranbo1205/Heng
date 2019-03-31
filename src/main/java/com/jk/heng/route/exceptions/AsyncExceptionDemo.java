package com.jk.heng.route.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 *
 * 1.Spring boot 中 Java 异步调用方法 (1.在异步方法上加@Async  2.在启动类上加@EnableAsync )
 *
 * 2.Spring boot 中 java 异步调用 异常处理
 *
 */
@Component
public class AsyncExceptionDemo {

    private static final Logger log = LoggerFactory.getLogger(AsyncExceptionDemo.class);

    /**
     * 最简单的异步方法，返回void
     */
    @Async
    public void asyncInvokeSimplest(){
        log.info("asyncSimplest");
    }


    /**
     * 异步调用方法，传入参数
     * 对于返回值 void , 异常 会被 AsyncUncaughtExceptionHandler 处理掉
     * @param s
     */
    @Async
    public void asyncInvokeWithException(String s){
        log.info("异步调用传参数 ， parameter {} :"+s);
        throw new IllegalArgumentException(s);
    }


    @Async
    public Future<String>  asyncInvokeWithFuture(int i){

        log.info("异步方法调用返回Future , parameter {} :"+i);

        Future<String> future ;

        try {
            Thread.sleep(1000);
            future = new AsyncResult<>("Success:"+i);
            throw new IllegalArgumentException("a");
        } catch (InterruptedException e) {
            future = new AsyncResult<>("error -- InterruptedException");
        } catch (IllegalArgumentException e){
            future = new AsyncResult<>("error - IllegalArgumentException");
        }

        return future;

    }



}
