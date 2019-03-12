package com.jk.heng.route.thread;

import com.jk.heng.route.model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestRunnable implements Runnable {

    BlockingQueue<Student> students;
    String threadName;

    public TestRunnable(String threadName){
        this.threadName = threadName;
    }

    public BlockingQueue<Student> getStudents() {
        return students;
    }

    public void setStudents(BlockingQueue<Student> students) {
        this.students = students;

        System.out.println("setting student blocking queue :" + students.size());
    }

    @Override
    public void run() {
        while (students.size()>0){
            try {
                System.out.println(threadName + " -- "+students.take().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args){

        BlockingQueue<Student> studentBlockingQ = getStudentBlockingQueue();
        System.out.println("total students in queue :"+studentBlockingQ.size());

//        List<Student> prepareStudentList = prepareStudentList();

        // 创建 2 个线程
        TestRunnable thread1 = new TestRunnable("Thread-001");
        thread1.setStudents(studentBlockingQ);
        Thread thread01 = new Thread(thread1);

        TestRunnable thread2 = new TestRunnable("Thread-002");
        thread2.setStudents(studentBlockingQ);
        Thread thread02 = new Thread(thread2);



        // 启动线程方法一: 使用 ExecutorService
//        ExecutorService service = Executors.newCachedThreadPool();
//        service.execute(thread1);
//        service.execute(thread2);
//        service.shutdown();


        // 启动线程方法二: 使用 Thread.start()方法
        thread01.start();
        thread02.start();

    }

    private static BlockingQueue<Student> getStudentBlockingQueue() {

        System.out.println("start enter getStudentBlockingQueue");

        BlockingQueue<Student> studentBlockingQ  =  new ArrayBlockingQueue<>(2000);
        for(int i = 0 ; i< 2000 ; i++){
            Student student = new Student();
            student.setName("Jack"+String.valueOf(i));
            try {
                studentBlockingQ.put(student);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("End of getStudentBlockingQueue");
        System.out.println("studentBlockingQ size : "+studentBlockingQ.size());
        return studentBlockingQ;
    }

    private static List<Student> prepareStudentList() {

        System.out.println("start enter prepareStudentList");

        List<Student> studentList  =  new ArrayList<>();
        Collections.synchronizedList(studentList);
        for(int i = 0 ; i< 2000 ; i++){
            Student student = new Student();
            student.setName("Jack"+String.valueOf(i));
            studentList.add(student);
            }

        System.out.println("End of prepareStudentList");
        return studentList;
    }

}
