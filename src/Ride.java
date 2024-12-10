import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Ride implements RideInterface{
    private String rideName;
    private Employee operator;  // 操作员
    private LinkedList<Visitor> queue;  // 排队等候的访客队列（链表）
    private LinkedList<Visitor> rideHistory;  // 已乘坐游乐设施的访客记录（链表）

    // 默认构造函数
    public Ride() {
    }

    // 带参数的构造函数
    public Ride(String rideName, Employee operator) {
        this.rideName = rideName;
        this.operator = operator;
        this.queue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
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
    public void runOneCycle() {
        if (!queue.isEmpty()) {
            Visitor visitor = queue.removeFirst();  // 从队列中移除第一个访客
            addVisitorToHistory(visitor);  // 将访客添加到历史记录中
            System.out.println(visitor.getName() + " 正在乘坐游乐设施 " + rideName);
        } else {
            System.out.println("目前队列中没有访客。");
        }
    }
}
