public class TaskManager {
      private final ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(String title, LocalDate dueDate) {
        Task t = new Task(title, dueDate);
        tasks.add(t);
    }
        
    public void listTasks() {
        // 0件ならメッセージを出して終了
        if (tasks.size() == 0) {
            System.out.println("タスクはありません");
            return;
        }
        // 全件を表示
        tasks.forEach(t -> System.out.println(t));
    }


    public void deleteTask(int number) {
        int index = number - 1;

        // 範囲外なら例外で呼び出し元に知らせる
        if(index < 0 || index >= tasks.size()){
            throw new IndexOutOfBoundsException("存在しないタスク番号です");
        }

        // 指定位置のタスクを削除
        tasks.remove(index);
    }

    public void completeTask(int number) {
        int index = number - 1;

        // 範囲外なら例外
        if (index < 0 || index >= tasks.size()) {
            throw new IndexOutOfBoundsException("存在しないタスク番号です");
        }

          // 指定タスクを完了状態にする
        tasks.get(index).markCompleted();
    }

    public int size() {
        // 登録件数を返す
        return tasks.size();
    }
}
