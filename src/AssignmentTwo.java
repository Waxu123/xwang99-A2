import entity.Employee;
import entity.Ride;
import entity.Visitor;

public class AssignmentTwo {

    public static void main(String[] args) {
        partThree();
    }

    public static void partThree(){
        // 创建员工
        Employee operator = new Employee("操作员", 28, "男", "游乐设施操作员", 50000);

        // 创建游客
        Visitor visitor1 = new Visitor("张三", 25, "男", "成人票");
        Visitor visitor2 = new Visitor("李四", 30, "女", "成人票");
        Visitor visitor3 = new Visitor("王五", 22, "男", "学生票");
        Visitor visitor4 = new Visitor("赵六", 27, "女", "成人票");
        Visitor visitor5 = new Visitor("小明", 24, "男", "成人票");

        // 创建游乐设施并指定操作员
        Ride rollerCoaster = new Ride("过山车", operator);

        // 添加游客到排队队列
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);

        // 将一位访客从队列中移除
        rollerCoaster.removeVisitorFromQueue(visitor1);

        //打印所有访客
        rollerCoaster.printQueue();

    }
    public static void partFourA() {
        // 创建员工
        Employee operator = new Employee("操作员", 28, "男", "游乐设施操作员", 50000);

        // 创建游客
        Visitor visitor1 = new Visitor("张三", 25, "男", "成人票");
        Visitor visitor2 = new Visitor("李四", 30, "女", "成人票");
        Visitor visitor3 = new Visitor("王五", 22, "男", "学生票");
        Visitor visitor4 = new Visitor("赵六", 27, "女", "成人票");
        Visitor visitor5 = new Visitor("小明", 24, "男", "成人票");

        // 创建游乐设施并指定操作员
        Ride rollerCoaster = new Ride("过山车", operator);

        // 将访客添加到队列
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);

        // 运行三轮游乐设施（移除访客并将其添加到历史记录）
        rollerCoaster.runOneCycle1();
        rollerCoaster.runOneCycle1();

        // 检查访客是否在历史记录中
        rollerCoaster.checkVisitorFromHistory(visitor1);

        // 访客人数
        System.out.println("访客人数： " + rollerCoaster.numberOfVisitors());

        // 打印所有访客
        rollerCoaster.printRideHistory();
    }
    public static void partFourB() {
        // 创建员工
        Employee operator = new Employee("操作员", 28, "男", "游乐设施操作员", 50000);

        // 创建游客
        Visitor visitor1 = new Visitor("张三", 25, "男", "成人票");
        Visitor visitor2 = new Visitor("李四", 30, "女", "成人票");
        Visitor visitor3 = new Visitor("王五", 22, "男", "学生票");
        Visitor visitor4 = new Visitor("赵六", 27, "女", "成人票");
        Visitor visitor5 = new Visitor("小明", 24, "男", "成人票");

        // 创建游乐设施并指定操作员
        Ride rollerCoaster = new Ride("过山车", operator);

        // 将访客添加到游乐设施历史记录中
        rollerCoaster.addVisitorToHistory(visitor1);
        rollerCoaster.addVisitorToHistory(visitor2);
        rollerCoaster.addVisitorToHistory(visitor3);
        rollerCoaster.addVisitorToHistory(visitor4);
        rollerCoaster.addVisitorToHistory(visitor5);

        // 打印原始历史记录
        System.out.println("原始访问记录：");
        rollerCoaster.printRideHistory();

        // 按照自定义规则对历史记录中的访客进行排序
        rollerCoaster.sortVisitors();

        // 打印排序后的历史记录
        System.out.println("排序后的访客记录：");
        rollerCoaster.printRideHistory();
    }
    public static void partFive() {
        // 创建员工
        Employee operator = new Employee("操作员", 28, "男", "游乐设施操作员", 50000);

        // 创建游客
        Visitor visitor1 = new Visitor("张三", 25, "男", "成人票");
        Visitor visitor2 = new Visitor("李四", 30, "女", "成人票");
        Visitor visitor3 = new Visitor("王五", 22, "男", "学生票");
        Visitor visitor4 = new Visitor("赵六", 27, "女", "成人票");
        Visitor visitor5 = new Visitor("小明", 24, "男", "成人票");
        Visitor visitor6 = new Visitor("小蓝", 27, "女", "成人票");
        Visitor visitor7 = new Visitor("小李", 35, "男", "成人票");
        Visitor visitor8 = new Visitor("大黄", 28, "男", "成人票");
        Visitor visitor9 = new Visitor("小赵", 33, "男", "成人票");
        Visitor visitor10 = new Visitor("刘明", 20, "女", "成人票");


        // 创建游乐设施并指定操作员(运行三次)
        Ride rollerCoaster = new Ride("过山车", operator, 3);

        // 将访客添加到队列
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);
        rollerCoaster.addVisitorToQueue(visitor6);
        rollerCoaster.addVisitorToQueue(visitor7);
        rollerCoaster.addVisitorToQueue(visitor8);
        rollerCoaster.addVisitorToQueue(visitor9);
        rollerCoaster.addVisitorToQueue(visitor10);

        // 打印出当前的队列
        System.out.println("原始队列：");
        rollerCoaster.printQueue();

        // 运行一次游乐设施
        rollerCoaster.runOneCycle();

        // 打印出队列和历史记录
        System.out.println("游乐设施运行后的队列：");
        rollerCoaster.printQueue();

        System.out.println("游乐设施历史记录：");
        rollerCoaster.printRideHistory();
    }
    public static void partSix() {
        // 创建员工
        Employee operator = new Employee("操作员", 28, "男", "游乐设施操作员", 50000);

        // 创建一个游乐设施对象，设置每次最多接待 2 个访客
        Ride rollerCoaster = new Ride("过山车", operator, 2);

        Visitor visitor1 = new Visitor("张三", 25, "男", "成人票");
        Visitor visitor2 = new Visitor("李四", 30, "女", "成人票");
        Visitor visitor3 = new Visitor("王五", 22, "男", "学生票");
        Visitor visitor4 = new Visitor("赵六", 27, "女", "成人票");
        Visitor visitor5 = new Visitor("小明", 24, "男", "成人票");

        // 将这些游客添加到 entity.Ride 中
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);

        // 运行一次游乐设施
        rollerCoaster.runOneCycle();

        // 导出 entity.Ride 历史记录到文件
        String filename = "ride_history.txt";
        rollerCoaster.exportRideHistory(filename);
    }
    public static void partSeven() {
        // 创建一个操作员（员工）
        Employee operator = new Employee("John", 30, "Male", "Operator", 30000);

        // 创建一个游乐设施对象，设置每次最多接待 3 个访客
        Ride rollerCoaster = new Ride("Roller Coaster", operator, 3);


        // 导入游客信息从文件
        String filename = "ride_history.txt";  // 文件名与 Part 6 中导出的文件名相同
        rollerCoaster.importRideHistory(filename);

        // 打印导入的游客数量
        System.out.println("导入的游客数量: " + rollerCoaster.getRideHistory().size());

        // 打印所有游客的信息
        System.out.println("entity.Visitor details:");
        for (Visitor visitor : rollerCoaster.getRideHistory()) {
            System.out.println(visitor);
        }
    }
}
