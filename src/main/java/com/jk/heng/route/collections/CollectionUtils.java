package com.jk.heng.route.collections;

import com.jk.heng.route.model.Student;

import java.util.*;

import static java.util.Objects.hash;

public class CollectionUtils {

    public static void main(String[] args){
        ArrayList arrayList = new ArrayList();

        Collections.synchronizedList(arrayList);

        LinkedList linkedList = new LinkedList();
        linkedList.add("Jack");
        linkedList.add(0,"Nicole");

        System.out.println(linkedList.size());
        System.out.println("linkedList : \n"+linkedList);

        comareLinkedHashSet_HashSet();

    }

    /**
     * 1. HashSet 的本质 是 一个 hashMap , 只是所有的 Value 为 同一个 Object
     * 2. LinkedHashSet 本质 是一个 Linked HashMap 是有序的
     * 3. HashSet是无序的，因为 HashMap的key 是 根据 hash（Entry.hashCode） , 故无序的
     * 4. LinkedHashSet 是  一个 LinkedHashMap (HashMap + 双向链表),故 有序； 而 HashSet 是普通的 HashMap .
     * 5. LinkedHashMap = HashMap + 双向链表 ， 故 LinkedHashMap 是有序的 ， HashMap 是无序的
     */
    private static void comareLinkedHashSet_HashSet(){

        Student s1 = new Student();
        s1.setId(1);
        Student s2 = new Student();
        s2.setId(2);
        Student s3 = new Student();
        s3.setId(3);
        Student s6 = new Student();
        s6.setId(6);
        Student s5 = new Student();
        s5.setId(5);

        // LinkedHashSet 本质是 一个 LinkedHashMap (HashMap + 双向链表) ， 故有序
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(s5);
        linkedHashSet.add(s6);
        linkedHashSet.add(s3);
        linkedHashSet.add(s2);
        linkedHashSet.add(s1);

        // HashSet 本质是 一个 HashMap , 故无序
        Set hashSet = new HashSet();
        hashSet.add(s5);
        hashSet.add(s6);
        hashSet.add(s3);
        hashSet.add(s2);
        hashSet.add(s1);


        System.out.println("HashMap 中 hash <key.hashCode>");
        System.out.println("s1:"+hash(s1));
        System.out.println("s2:"+hash(s2));
        System.out.println("s3:"+hash(s3));
        System.out.println("s5:"+hash(s5));
        System.out.println("s6:"+hash(s6));


        Iterator it = linkedHashSet.iterator();
        System.out.println("LinkedHashSet:");
        while(it.hasNext()){
            Student s = (Student) it.next();
            System.out.println(s.getId());
        }

        System.out.println("LinkedHashSet : \n"+linkedHashSet);
        System.out.println("HashSet : \n"+hashSet);

    }

}
