package com.jk.heng.route.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/**
 * 实现AsyncConfigurer接口对异常线程池更加细粒度的控制
 * a) 创建线程自己的线程池
 * b) 对void方法抛出的异常处理的类AsyncUncaughtExceptionHandler
 */

@Service
public class MyAsyncConfigurer implements AsyncConfigurer {

    public static final Logger log = LoggerFactory.getLogger(MyAsyncConfigurer.class);


    /**
     * 创建自定义的线程池
     * @return
     */
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        threadPool.setCorePoolSize(1);
        threadPool.setMaxPoolSize(1);
        threadPool.setWaitForTasksToCompleteOnShutdown(true);
        threadPool.setAwaitTerminationSeconds(60 * 15);
        threadPool.setThreadNamePrefix("MyAsync-");
        threadPool.initialize();
        return threadPool;
    }


    /**
     * 自定义异步方法异常处理的Handler
     * @return
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new MyAsyncUncaughtExceptionHandler();
    }


    /**
     * 自定义异常处理类
     */
    private class MyAsyncUncaughtExceptionHandler implements AsyncUncaughtExceptionHandler {
        @Override
        public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
            log.info("Exception message - "+throwable.getMessage());
            log.info("Exception method - "+method.getName());
            for(Object param : objects){
                log.info("Parameter value - "+ param );
            }
        }
    }
}
