//メニュー表示とCLI操作を担当するクラス

import java.util.Scanner;

public class TaskApp {

    //タスク管理クラス・スキャナクラスのインスタンスを生成
    private TaskManager manager = new TaskManager();
    private Scanner scanner = new Scanner(System.in);

    //アプリ実行メソッド
    public void run() {
        //ユーザが終了を選ぶまで続くループでメニューを表示
        while (true) {
            //メニュー表示
            System.out.println("\n=== タスク管理アプリ ===");
            System.out.println("1: タスクを登録する");
            System.out.println("2: タスク一覧を表示する");
            System.out.println("3: タスクを完了にする");
            System.out.println("4: タスクを削除する");
            System.out.println("0: 終了");
            System.out.print("番号を入力してください > ");

            //ユーザ入力を取得し、数字に変換
            int select = Integer.parseInt(scanner.nextLine());

            //取得した番号に応じて処理を実行
            //switch文で分岐
            switch (select) {
                case 1:
                    addTask();
                    break;
                case 2:
                    manager.showTaskList();
                    break;
                case 3:
                    completeTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 0:
                    //終了時、タスクの登録件数と完了済みタスク数の表示
                    manager.showTaskCount();
                    manager.showCompletedTask();
                    System.out.println("終了します。");
                    return;
                //defaultケースで無効な入力を処理
                default:
                    System.out.println("無効な入力です。");
            }
        }
    }

    //タスク追加メソッド
    private void addTask() {
        try {
            System.out.print("タイトル: ");
            String title = scanner.nextLine();
            if (title.isBlank()) {
                throw new IllegalArgumentException("タイトルが空です");
            }

            System.out.print("期限: ");
            String deadline = scanner.nextLine();
            if (deadline.isBlank()) {
                throw new IllegalArgumentException("期限が空です");
            }

            manager.addTask(new Task(title, deadline));
            System.out.println("タスクを追加しました。");

        } catch (IllegalArgumentException e) {
            System.out.println("入力エラー: " + e.getMessage());
        }
    }

    //タスク完了メソッド
    private void completeTask() {
        System.out.print("完了したタスクの番号 > ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        manager.completeTask(index);
    }

    //タスク削除メソッド
    private void deleteTask() {
        //タスク一覧を表示してから削除するタスクの番号を入力させる
        manager.showTaskList();
        System.out.print("削除するタスクの番号 > ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        manager.deleteTask(index);
    }
}
