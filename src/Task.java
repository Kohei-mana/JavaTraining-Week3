//タスククラス

public class Task {

    //タイトル、期限、完了状態を持つフィールド
    private String title;
    private String deadline;
    private boolean isDone;

    //コンストラクタ
    public Task(String title, String deadline) {
        this.title = title;
        this.deadline = deadline;
        this.isDone = false;
    }

    //ゲッターメソッド
    public String getTitle() {
        return title;
    }

    public String getDeadline() {
        return deadline;
    }

    public boolean isDone() {
        return isDone;
    }

    public void complete() {
        this.isDone = true;
    }

    //タスクの情報を文字列で返すtoStringメソッド
    //タスクが完了済みなら"[✔完了]"をタイトルの後ろに付ける
    @Override
    public String toString() {
        String status = isDone ? "[✔完了] " : "";
        return title + " / " + deadline + status;
    }
}
