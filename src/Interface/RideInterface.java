package Interface;

import entity.Visitor;

public interface RideInterface {
    void addVisitorToQueue(Visitor visitor);  // 向队列中添加访客
    void removeVisitorFromQueue(Visitor visitor);  // 从队列中移除访客
    void printQueue();// 打印队列中的访客
    void runOneCycle();//运行一次循环
    void addVisitorToHistory(Visitor visitor);  // 将访客添加到游乐设施历史记录中
    boolean checkVisitorFromHistory(Visitor visitor);  // 检查访客是否在历史记录中
    int numberOfVisitors();  // 获取游乐设施历史记录中的访客数量
    void printRideHistory();  // 用于打印乘坐过游乐设施的游客列表
}