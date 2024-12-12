package entity;

public class Employee extends Person {
    //职位
    private String position;
    //薪水
    private double salary;

    public Employee() {
        super(); // 调用父类构造方法
    }

    public Employee(String name, int age, String gender, String position, double salary) {
        super(name, age, gender); // 调用父类构造方法
        this.position = position;
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", Position: " + position + ", Salary: " + salary;
    }
}
