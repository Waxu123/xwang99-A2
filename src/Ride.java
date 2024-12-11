import java.io.*;
import java.util.*;

public class Ride implements RideInterface{
    private String rideName;
    private Employee operator;  // 操作员
    private LinkedList<Visitor> queue;  // 排队等候的访客队列（链表）
    private LinkedList<Visitor> rideHistory;  // 已乘坐游乐设施的访客记录（链表）

    private int maxRider;  // 每次循环最多接待的访客数
    private int numOfCycles;  // 游乐设施运行的周期数

    // 默认构造函数
    public Ride() {
    }

    // 带参数的构造函数
    public Ride(String rideName, Employee operator) {
        this.rideName = rideName;
        this.operator = operator;
        this.queue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = maxRider;
        this.numOfCycles = 0;
    }

    // 构造器，初始化游乐设施名称和操作员
    public Ride(String rideName, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.operator = operator;
        this.queue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = maxRider;
        this.numOfCycles = 0;
    }

    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public List<Visitor> getQueue() {
        return queue;
    }

    public List<Visitor> getRideHistory() {
        return rideHistory;
    }

    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    public void setNumOfCycles(int numOfCycles) {
        this.numOfCycles = numOfCycles;
    }

    // 向队列中添加访客
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        queue.add(visitor);
    }

    // 从队列中移除访客
    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        queue.remove(visitor);
    }

    // 打印当前队列
    @Override
    public void printQueue() {
        System.out.println("目前排队等待 " + rideName + " 的访客：");
        for (Visitor visitor : queue) {
            System.out.println(visitor.getName());
        }
    }

    // 将访客添加到游乐设施历史记录中
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println(visitor.getName() + " 已添加到游乐设施历史记录中。");
    }

    // 检查访客是否在游乐设施历史记录中
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (rideHistory.contains(visitor)) {
            System.out.println(visitor.getName() + " 已在游乐设施历史记录中。");
            return true;
        } else {
            System.out.println(visitor.getName() + " 不在游乐设施历史记录中。");
            return false;
        }
    }

    // 获取历史记录中的访客数量
    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    // 打印游乐设施历史记录（所有乘坐过该游乐设施的访客）
    @Override
    public void printRideHistory() {
        System.out.println("游乐设施 " + rideName + " 的历史记录：");
        //迭代器
        Iterator<Visitor> iterator = rideHistory.iterator();
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println(visitor.getName() + " - " + visitor.getPassType());
        }
    }


    // 运行一轮游乐设施（移除队列中的第一个访客，并将其添加到历史记录中）
    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("无法运行游乐设施 " + rideName + "，没有操作员被分配。");
            return;
        }

        if (queue.isEmpty()) {
            System.out.println("无法运行游乐设施 " + rideName + "，队列中没有访客。");
            return;
        }

        // 计算这次循环能够接待的访客数
        int ridersToProcess = Math.min(maxRider, queue.size());

        // 从队列中移除并将访客添加到历史记录中
        for (int i = 0; i < ridersToProcess; i++) {
            Visitor visitor = queue.removeFirst();  // 移除队列中的第一个访客
            addVisitorToHistory(visitor);  // 将访客添加到历史记录中
        }

        // 增加游乐设施的运行周期数
        numOfCycles++;

        System.out.println("游乐设施 " + rideName + " 已成功运行一次，当前已运行 " + numOfCycles + " 个周期。");
    }


    //排序
    public void sortVisitors() {
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("游乐设施历史记录已排序。");
    }

    // 导出 Ride 历史记录到文件
    public void exportRideHistory(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Visitor visitor : rideHistory) {
                writer.write(visitor.toString()); // 将 Visitor 对象的字符串表示写入文件
                writer.newLine();  // 换行
            }
        } catch (IOException e) {
            System.out.println("导出时发生错误: " + e.getMessage());
        }
    }

//     导入 Ride 历史记录从文件
    public void importRideHistory(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // 假设游客信息的格式是 "Name: name, Age: age"
                String[] parts = line.split(", ");
                String name = parts[0].split(": ")[1];
                int age = Integer.parseInt(parts[1].split(": ")[1]);
                String gender = parts[2].split(": ")[1];
                String passType = parts[3].split(": ")[1];

                // 创建一个新的 Visitor 对象，并添加到 Ride 中
                Visitor visitor = new Visitor(name, age, gender, passType);
                addVisitorToHistory(visitor);
            }
            System.out.println("导入成功：" + filename);
        } catch (IOException e) {
            System.out.println("发生错误: " + e.getMessage());
        }
    }

}
