public class Task {
    //フィールド
    private String title;
    private String deadline;
    private boolean isCompleted;
    private int id;

    //コンストラクタ
    public Task(String title, String deadline, int id) {
        this.title = title;
        this.deadline = deadline;
        this.isCompleted = false;
        this.id = id;
    }

    //Getterメソッド
    public String getTitle() {
        return title;
    }

    public String getDeadline() {
        return deadline;
    }

    public int getId() {
        return id;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    //Setterメソッド
    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
