# JavaTraining-Week3
タスク管理アプリを作成しよう
# JavaTraining-Week3 タスク管理アプリ（CLI）

## 概要
本アプリケーションは，コマンドライン上でタスク（ToDo）を登録・一覧表示・削除・完了にできるタスク管理システムである．  
入力ミスを例外処理で検知し，再入力を促すことで安定して操作できるようにした．

## 実行方法
以下は Windows（PowerShell）での実行手順である．

```powershell
cd src
javac -encoding UTF-8 Task.java TaskManager.java TaskApp.java
java TaskApp
