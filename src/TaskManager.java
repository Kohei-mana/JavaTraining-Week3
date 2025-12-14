//タスク管理クラス

import java.util.ArrayList;

public class TaskManager {

    //タスクを格納するリスト
    private ArrayList<Task> tasks = new ArrayList<>();

    //タスク追加メソッド
    public void addTask(Task task) {
        tasks.add(task);
    }

    //タスク表示メソッド
    public void showTaskList() {
        if (this.tasks.isEmpty()) {
            System.out.println("タスクは登録されていません。");
            return;
        }
        //タスク一覧の表示
        System.out.println("===タスク一覧===");
        //ラムダ式を使ってインデックス付きで表示
        final int[] index = {1};
        this.tasks.forEach(task -> {
            System.out.println(index[0] + ": " + task);
            index[0]++;
        });
    }

    //タスク完了メソッド
    public void completeTask(int index) {
        if (index < 0 || index >= tasks.size()) {
            System.out.println("番号が不正です。");
            return;
        }
        tasks.get(index).complete();
    }

    //タスク削除メソッド
    public void deleteTask(int index) {
        //番号が不正な場合の処理
        if (index < 0 || index >= tasks.size()) {
            System.out.println("番号が不正です。");
            return;
        }
        //タスクを削除
        tasks.remove(index);
    }

    // 登録件数表示メソッド
    public void showTaskCount() {
        System.out.println("登録件数: " + tasks.size());
    }

    //完了済みタスク数表示メソッド(応用課題)
    public void showCompletedTask() {
        long count = tasks.stream().filter(Task::isDone).count();

        System.out.println("\n完了済みタスク数: " + count);

    }
}
