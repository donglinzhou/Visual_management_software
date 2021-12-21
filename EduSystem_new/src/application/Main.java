package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = new AnchorPane();	//窗口
			root = FXMLLoader.load(getClass().getResource("/view/Login_Select.fxml"));	//getResource使用左斜杆表示路径
			Scene scene = new Scene(root);	//场景
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());	//给场景加样式
			primaryStage.setTitle("数智教育");	//舞台要有title
			primaryStage.setScene(scene);	//场景放入舞台
			primaryStage.show();	//show舞台
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
