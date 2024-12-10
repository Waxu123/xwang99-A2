public interface RideInterface {
    void addVisitorToQueue(Visitor visitor);  // 添加游客到队列
    void removeVisitorFromQueue(Visitor visitor);  // 移除游客出队列
    void printQueue();  // 打印当前队列
    void runOneCycle();  // 执行一次游乐设施的循环
    void addVisitorToHistory(Visitor visitor);  // 将游客添加到乘坐历史
    boolean checkVisitorFromHistory(Visitor visitor);  // 检查游客是否已经乘坐过
    int numberOfVisitors();  // 获取乘坐历史中的游客数量
    void printRideHistory();  // 打印乘坐历史
}