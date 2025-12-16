import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskApp {
    public static void main(String[] args) {
        //ScannerとTaskManagerのインスタンス化
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        
        int choice;

        System.out.println("====== タスク管理アプリへようこそ！ ======");

        //メインループ
        do {
            System.out.println("\n----------------------------------------");
            System.out.println("1: 登録 | 2: 一覧 | 3: 削除 | 4: 完了 | 0: 終了");
            System.out.print("操作を選択してください: ");

            //ユーザー入力の処理
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1: //タスク登録
                        System.out.println("\n--- 1: タスク登録 ---");
                        System.out.print("タイトルを入力してください: ");
                        String title = scanner.nextLine(); 

                        System.out.print("期限を入力してください (例: 2024-12-31): ");
                        String deadline = scanner.nextLine();

                        taskManager.addTask(title, deadline);
                        System.out.println("タスク「" + title + "」を登録しました。");
                        break;

                    case 2: //タスク一覧表示
                        System.out.println("\n--- 2: タスク一覧 ---");
                        taskManager.listTasks();
                        break;

                    case 3: //タスク削除
                        System.out.println("\n--- 3: タスク削除 ---");
                        //一覧表示してから削除IDを入力
                        taskManager.listTasks(); 
                        System.out.print("削除するタスクのIDを入力してください: ");
                        int deleteId = scanner.nextInt();
                        scanner.nextLine(); 
                        taskManager.deletTask(deleteId);
                        break;
                        
                    case 4: //タスク完了
                        System.out.println("\n--- 4: タスク完了 ---");
                        //一覧表示してから完了IDを入力
                        taskManager.listTasks(); 
                        System.out.print("完了するタスクのIDを入力してください: ");
                        int completeId = scanner.nextInt();
                        scanner.nextLine(); 
                        taskManager.completeTask(completeId);
                        break;
                        
                    case 0: //終了
                        System.out.println("アプリを終了します...");
                        break;
                        
                    default:
                        System.out.println("5無効な選択肢です。0から4の数字を入力してください。");
                        break;
                }

            } catch (InputMismatchException e) {
                //不正な文字入力をキャッチしてメッセージ表示
                System.out.println("エラー: メニュー番号は数字で入力してください。");
                scanner.nextLine(); 
                choice = -1;   
            } 
            
        } while (choice != 0); 
        
        // Scannerをクローズ
        scanner.close();
        System.out.println("タスク管理システムのご利用ありがとうございました。");
    }
}