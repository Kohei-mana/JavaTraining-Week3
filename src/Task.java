public class Task {
    private String taskName;
    private String deadline;
    private boolean done;


    //新しいタスクを作成するコンストラクタ
    public Task(String taskName, String deadline){
        this.taskName = taskName;
        this.deadline = deadline;
        this.done = false; //初期は未完了設定
    }

    //完了にするメソッド
    public void complete(){
        this.done = true;
    }

    // 表示用の文字を作るメソッド
    @Override
    public String toString() {
    // 1. まず状態（完了か未か）を入れるための箱（変数）を作る
    String status;

    // 2. if文で中身を判定して代入する
    if (this.done == true) {
        status = "[ 完了 ]";
    } else {
        status = "[ 未 ]";
    }

    // 3. 全部の文字を合体させて1つの「結果」を作る
    String result = status + " " + this.taskName + " (期限: " + this.deadline + ")";

    return result;
}

}
