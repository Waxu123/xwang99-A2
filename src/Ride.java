import java.util.ArrayList;
import java.util.List;

public class Ride implements RideInterface{
    private String rideName;
    private Employee operator;  // 操作员
    private List<Visitor> queue;  // 排队的游客
    private List<Visitor> rideHistory;  // 乘坐记录

    // 默认构造函数
    public Ride() {
    }

    // 带参数的构造函数
    public Ride(String rideName, Employee operator) {
        this.rideName = rideName;
        this.operator = operator;
        this.queue = new ArrayList<>();
        this.rideHistory = new ArrayList<>();
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

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        queue.add(visitor);
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        queue.remove(visitor);
    }

    @Override
    public void printQueue() {
        System.out.println("游客排队列表（" + rideName + "）：");
        for (Visitor visitor : queue) {
            System.out.println(visitor.getName());
        }
    }

    @Override
    public void runOneCycle() {
        if (!queue.isEmpty()) {
            Visitor visitor = queue.remove(0);  // 取出排队的第一个游客
            rideHistory.add(visitor);  // 添加到乘坐历史
            System.out.println(visitor.getName() + " 正在乘坐 " + rideName);
        } else {
            System.out.println("没有游客排队。");
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        System.out.println(rideName + " 乘坐历史：");
        for (Visitor visitor : rideHistory) {
            System.out.println(visitor.getName());
        }
    }
}
