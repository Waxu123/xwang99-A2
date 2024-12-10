
public class AssignmentTwo {

    public static void main(String[] args) {
        // 创建员工
        Employee operator = new Employee("张三", 28, "男", "游乐设施操作员", 50000);

        // 创建游客
        Visitor visitor1 = new Visitor("李四", 35, "女", "成人票");
        Visitor visitor2 = new Visitor("王五", 32, "男", "成人票");

        // 创建游乐设施并指定操作员
        Ride rollerCoaster = new Ride("过山车", operator);

        // 添加游客到排队队列
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);

        // 打印队列
        rollerCoaster.printQueue();

        // 执行一次游乐设施的循环
        rollerCoaster.runOneCycle();
        rollerCoaster.runOneCycle();

        // 打印乘坐历史
        rollerCoaster.printRideHistory();
    }
    public void partThree(){
    }
    public void partFourA(){
    }
    public void partFourB(){
    }
    public void partFive(){
    }
    public void partSix(){
    }
    public void partSeven(){
    }
}
