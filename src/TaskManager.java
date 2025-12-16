import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    //タスクを追加
    public void addTask(Task task) {
        tasks.add(task);
    }

    //タスクを表示
    public void showTasks() {

        //空の場合、「タスクはありません」と表示
        if (tasks.isEmpty()) {
            System.out.println("タスクはありません。");
            return; //処理を強制終了して呼び出し元へ戻る
        }
        //出力
        tasks.forEach(task -> System.out.println((tasks.indexOf(task) + 1) + ": " + task));
    }

    //タスクを削除
    public void deleteTask(int index) {
        tasks.remove(index);
    }

    //タスクを完了
    public void completeTask(int index) {
        tasks.get(index).complete();
    }

    // タスク件数を表示
    public int getTaskCount() {
    return tasks.size(); 
}

}
