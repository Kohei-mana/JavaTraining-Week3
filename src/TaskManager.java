import java.util.ArrayList;

public class TaskManager {
    //フィールド
    private ArrayList<Task> tasks;
    private int nextId = 1;

    //コンストラクタ
    public TaskManager() {
        tasks = new ArrayList<>();
    }

    //タスク追加メソッド
    public void addTask(String title, String deadline) {
        Task newTask = new Task(title, deadline, nextId++);
        tasks.add(newTask);
    }

    //タスク一覧表示メソッド
    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("タスクは登録されていません。");
            return;
        }

        System.out.println("登録タスク一覧:");
        //ラムダ式を使用してタスクを表示
        tasks.forEach(task -> {
            String status = task.isCompleted() ? "完了" : "未完了";
            //printfメソッドを使用してフォーマットされた出力
            System.out.printf("ID: %d, タイトル: %s, 期限: %s, 状態: %s%n",
                    task.getId(), task.getTitle(), task.getDeadline(), status);
        });
    }

    //タスク削除メソッド
    public void deletTask(int taskId) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == taskId) {
                tasks.remove(i);
                System.out.println("タスクID " + taskId + " を削除しました。");
                return;
            } 
        }
        System.out.println("タスクID " + taskId + " は見つかりませんでした。");
    }

    //タスク完了メソッド
    public void completeTask(int taskId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                task.setCompleted(true);
                System.out.println("タスクID " + taskId + " を完了にしました。");
                return;
            }
        }
        System.out.println("タスクID " + taskId + " は見つかりませんでした。");
    }
}
