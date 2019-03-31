package com.jk.heng;

import com.jk.heng.route.exceptions.AsyncExceptionDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HengApplicationTests {

    @Autowired
    private AsyncExceptionDemo asyncDemo;

    @Test
    public void contextLoads() throws ExecutionException, InterruptedException {
        asyncDemo.asyncInvokeSimplest();
        asyncDemo.asyncInvokeWithException("test Exception thrown from void ");
        Future<String> future = asyncDemo.asyncInvokeWithFuture(100);
        System.out.println(future.get());
    }

}
