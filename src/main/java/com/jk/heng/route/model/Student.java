package com.jk.heng.route.model;

public class Student {

    private int id;
    private String name ;

    Student Student(){
        return  new Student();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) { this.name = name; }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj){
            return  true;
        }

        if(obj instanceof Student){
            Student that = (Student) obj;
            return id == that.id ? true : false;
        }


        return super.equals(obj);
    }
}
