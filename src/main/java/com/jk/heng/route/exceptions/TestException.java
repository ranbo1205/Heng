package com.jk.heng.route.exceptions;

public class TestException {

    public static void main (String [] args){

        String exceptionStr = "Runtime exception 不需要 处理(捕获或抛出)，代码可以编译通过\n"
                +"Exception 必须强制处理(捕获 或 抛出) , 否则代码 会编译错误";

        String LINE = "---------------------------------------------------------";
        System.out.println(exceptionStr);
        System.out.println(LINE);

        throwRuntimeExceptionHandle();

        System.out.println(LINE);

        try {
            throwException();
        } catch (Exception e) {

            System.out.println("find exception , 此处做处理");
            System.out.println(LINE);
        }


        System.out.println("run time exception not handle , 但是没有编译错误，只有 运行时 JVM 自动抛出异常");
        throwRuntimeExceptionNotHandle();
        System.out.println(LINE);

        throwMyRunException();
    }

    public static void throwRuntimeExceptionNotHandle(){
        throw new RuntimeException("Runtime Exception throw , not Handle , 但不会引起 编译错误，只会在运行时 JVM 自动抛出异常");
    }

    public static void throwException() throws Exception {
        throw new Exception("Exception");
    }

    public static void throwRuntimeExceptionHandle(){
        try{
            throw new RuntimeException("Runtime Exception throw , but Handle");
        }catch (Exception e){
            System.out.println("Runtime Exception 虽然不需要被处理，但也可以处理，可以被捕获 , 此处 捕获 Runtime Exception");
        }

    }

    public static void throwMyRunException(){
        throw new MyException("My run time exception");
    }

}
