package entity;

import entity.Person;

public class Visitor extends Person {

    private String passType;

    public Visitor() {
        super(); // 调用父类构造方法
    }


    public Visitor(String name, int age, String gender, String passType) {
        super(name, age, gender); // 调用父类构造方法
        this.passType = passType;
    }

    public String getPassType() {
        return passType;
    }

    public void setPassType(String passType) {
        this.passType = passType;
    }

    @Override
    public String toString() {
        return super.toString() + ", PassType: " + passType;
    }
    
}
