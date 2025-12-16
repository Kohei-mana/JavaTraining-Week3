import java.util.Scanner;

public class TaskApp {
    public static void main(String args[]){
        TaskManager manager = new TaskManager();
        Scanner sc = new Scanner(System.in);

        while(true){
            try{   //try-catch構文 
                System.out.print("\n--- タスク管理システム ---");
                System.out.print("1:登録 2:一覧 3:削除 4:完了 0:終了  ");
                System.out.print("選択してください ： ");
                int menuNumber = Integer.parseInt(sc.nextLine()); //数字以外は例外

                //0が入力された場合
                if (menuNumber == 0){
                    System.out.print("アプリを終了します");
                    System.out.println("登録件数は" + manager.getTaskCount() + "件です");
                    break;
                }

                switch (menuNumber) {
                    
                    //1が入力された場合
                    case 1: //タスク名を入力
                        System.out.print("タスク名を入力してください：");
                        String taskName = sc.nextLine();
                        if(taskName.isEmpty()) throw new Exception("タスク名が空です"); //未入力の場合

                        //期限を入力
                        System.out.print("期限を入力してください(年/月/日)：");
                        String deadline = sc.nextLine();

                        //追加
                        manager.addTask(new Task(taskName, deadline));
                        break; //1の場合（登録）

                    
                    //2が入力された場合
                    case 2: //一覧表示

                        manager.showTasks();
                        break;


                    //3が入力された場合
                    case 3: //削除

                        //タスクを表示
                        manager.showTasks();

                        //消去するタスク番号を入力
                        System.out.print("消去する番号を入力してください（初めの番号は0です）：");
                        int deleteNum = Integer.parseInt(sc.nextLine());

                        //削除
                        manager.deleteTask(deleteNum);
                        break;


                    //4が入力された場合
                    case 4:

                        //タスクを表示
                        manager.showTasks();


                        System.out.print("完了にするタスク番号を入力してください（初めの番号は0です）： ");

                        //表示するタスク番号を入力
                        int completeNum = Integer.parseInt(sc.nextLine());
                        manager.completeTask(completeNum);
                        break;  

                    // 1〜4以外の場合
                    default: 
                    throw new Exception("1〜4の番号を選んでください");
                }
            } catch(Exception error) {
                System.out.println("エラー：正しい番号を入力してください：");
            }
        }
    }
}