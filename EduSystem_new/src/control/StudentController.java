package control;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.LoginId;



public class StudentController implements Initializable {

	//登录界面传递id的变量
	public static LoginId id = new LoginId();
	
	
	
    @FXML
    private Button infoBtn;

    @FXML
    private Button growingBtn;
	
    @FXML
    private Button attendanceBtn;

    @FXML
    private Button consumptionBtn;

    @FXML
    private Button scoreBtn;
    
    @FXML
    private Button logOut;

    @FXML
    private Label headTxt;
    
    //查看学生成长档案特有的变量
    @FXML
	private LineChart<String, Number> growingGrade;//折线图
    @FXML
    private CategoryAxis xNearestTest;
    @FXML
    private NumberAxis yGrade;
    @FXML
    private MenuButton growingTimesConfirm;
    @FXML
    private MenuItem allGradeLastThreeTimesBtn;
    @FXML
    private MenuItem allGradeLastFiveTimesBtn;
    @FXML
    private MenuItem allGradeLastTenTimesBtn;
    //查看考勤记录特有的变量
    @FXML
    private MenuItem absenceNearestFiveMonthBtn;
    @FXML
    private MenuItem absenceNearestThreeMonthBtn;
    @FXML
    private MenuItem absenceNearestOneMonthBtn;
    @FXML
    private MenuButton attendanceMonthConfirm;
    @FXML
    private BarChart<String, Number> attendanceAbsence;
    @FXML
    private CategoryAxis studentAttendanceLineXType;
    //查看消费记录特有的变量
    @FXML
    private MenuItem consumptionNearestFiveMonth;
    @FXML
    private MenuItem consumptionNearestThreeMonth;
    @FXML
    private MenuItem consumptionNearestOneMonth;
    @FXML
    private MenuButton consumptionMonthConfirm;
    @FXML
    private PieChart consumptionNearestMonth;
    //查看学生学业画像特有的变量
    @FXML
    private LineChart<String, Number> gradeRequiredSubjects;
    @FXML
    private LineChart<String, Number> gradeOptionalSubjects;
    @FXML
    private MenuItem gradeNearestTenTimes;
    @FXML
    private MenuItem gradeNearestFiveTimes;
    @FXML
    private MenuItem gradeNearestThreeTimes;
    @FXML
    private MenuButton scoreTimesConfirm;
    //查看个人基本信息
    @FXML
    private Label studentHeadTeacher;
    @FXML
    private Label studentPolitics;
    @FXML
    private Label studentEnrollmentY;
    @FXML
    private Label enrollmentRanking;
    @FXML
    private Label studentId;
    @FXML
    private Label studentAge;
    @FXML
    private Label studentGender;
    @FXML
    private Label studentName;
    
    //连接服务端
    //特定功能需要的参数数组
    ArrayList<String> listInput = new ArrayList<String>();
    //传入的用户ID和密码
    ArrayList<String> loginData = new ArrayList<String>();
    
    private int btnCode; //输入client的按钮序号
    
    //服务端传回来的可能是一维数组也可能是二维数组
    private String[] data1 = new String[0];
    private String[][] data2 = new String[0][0];
    
    
    @FXML
    void logOutClick(ActionEvent event) {
    	System.out.println("退出登录");
    	
		Stage selectStage = (Stage) headTxt.getScene().getWindow();
		selectStage.close();
		
		try {	
			Pane infoPane = FXMLLoader.load(getClass().getResource("/view/Login_Select.fxml"));
			Scene infoScene = new Scene(infoPane);
			Stage managerStage = new Stage();
			managerStage.setScene(infoScene);
			managerStage.setTitle("数智教育");
			managerStage.show();	
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    //个人信息主页
    @FXML
    void infoBtnClick(ActionEvent event) {
    	clearClientParameter();
		
		loginData.add(id.getId());
		loginData.add(id.getPassword());
		listInput.add("14454"); //最终应该放的是id.getId()
		btnCode = 1;
		
		client(btnCode,listInput,loginData);
    	infoBtnClick1();
    	showStudentInfo();
    }

	@FXML
    public void infoBtnClick1() {
    	System.out.println("个人信息主页");
    	
		Stage selectStage = (Stage) headTxt.getScene().getWindow();
		
		try {	
			Pane infoPane = FXMLLoader.load(getClass().getResource("/view/studentHome.fxml"));
			studentHeadTeacher = (Label) infoPane.lookup("#studentHeadTeacher");
			studentPolitics = (Label) infoPane.lookup("#studentPolitics");
			studentEnrollmentY = (Label) infoPane.lookup("#studentEnrollmentY");
			enrollmentRanking = (Label) infoPane.lookup("#enrollmentRanking");
			studentId = (Label) infoPane.lookup("#studentId");
			studentAge = (Label) infoPane.lookup("#studentAge");
			studentGender = (Label) infoPane.lookup("#studentGender");
			studentName = (Label) infoPane.lookup("#studentName");
			
			Scene infoScene = new Scene(infoPane);
			selectStage.setScene(infoScene);
			selectStage.setTitle("学生端");
			selectStage.show();	
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void growingBtnClick(ActionEvent event) {
    	System.out.println("学生成长档案");
    	
		Stage selectStage = (Stage) headTxt.getScene().getWindow();

		try {	
			Pane scorePane = FXMLLoader.load(getClass().getResource("/view/studentGrowing.fxml"));
			Scene scoreScene = new Scene(scorePane);
			selectStage.setScene(scoreScene);
			selectStage.setTitle("学生端");
			selectStage.show();	
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

    }

    @FXML
    void attendanceBtnClick(ActionEvent event) {
    	System.out.println("学生考勤记录");
    	
		Stage selectStage = (Stage) headTxt.getScene().getWindow();

		try {	
			Pane scorePane = FXMLLoader.load(getClass().getResource("/view/studentAttendance.fxml"));
			Scene scoreScene = new Scene(scorePane);
			selectStage.setScene(scoreScene);
			selectStage.setTitle("学生端");
			selectStage.show();	
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

    }

    @FXML
    void consumptionBtnClick(ActionEvent event) {
    	System.out.println("学生消费记录");
    	
		Stage selectStage = (Stage) headTxt.getScene().getWindow();

		try {	
			Pane scorePane = FXMLLoader.load(getClass().getResource("/view/studentConsumption.fxml"));
			Scene scoreScene = new Scene(scorePane);
			selectStage.setScene(scoreScene);
			selectStage.setTitle("学生端");
			selectStage.show();	
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

    }

    @FXML
    void scoreBtnClick(ActionEvent event) {
    	System.out.println("学生成长档案");
    	
		Stage selectStage = (Stage) headTxt.getScene().getWindow();

		try {	
			Pane scorePane = FXMLLoader.load(getClass().getResource("/view/studentScore.fxml"));
			Scene scoreScene = new Scene(scorePane);
			selectStage.setScene(scoreScene);
			selectStage.setTitle("学生端");
			selectStage.show();	
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

    }
    
    

	//学生成长档案————折线图
    @FXML
    void growingClick(ActionEvent event) {
		System.out.println("学生成长档案——折线图");
		growingTimesConfirm.setText(((MenuItem)event.getTarget()).getText());
		clearClientParameter();
		
		loginData.add(id.getId());
		loginData.add(id.getPassword());
		listInput.add("14454"); //最终应该放的是id.getId()
		btnCode = 2;
		
		MenuItem item = (MenuItem) event.getTarget();
		if(item.getText().equals("最近3次的考试总分")) {
			listInput.add("3");
			allGradeLastThreeTimesBtn.setDisable(true);
			allGradeLastFiveTimesBtn.setDisable(false);
			allGradeLastTenTimesBtn.setDisable(false);
			
		}else if(item.getText().equals("最近5次的考试总分")) {
			listInput.add("5");
			allGradeLastFiveTimesBtn.setDisable(true);
			allGradeLastThreeTimesBtn.setDisable(false);
			allGradeLastTenTimesBtn.setDisable(false);
	
		}else if(item.getText().equals("最近10次的考试总分")) {
			listInput.add("10");
			allGradeLastTenTimesBtn.setDisable(true);
			allGradeLastThreeTimesBtn.setDisable(false);
			allGradeLastFiveTimesBtn.setDisable(false);
		}
		client(btnCode,listInput,loginData);
		
		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
		series.setName("总分");
        
		for (int i = 0; i < data1.length; i++) {
			series.getData().add(new XYChart.Data<String, Number>(Integer.toString(i + 1), Integer.parseInt(data1[i])));
		}
        
		growingGrade.getData().add(series);
	}
	
	//考勤记录————柱形图
	@FXML
    void attendanceClick(ActionEvent event) {
		
		System.out.println("考勤记录");
		attendanceMonthConfirm.setText(((MenuItem)event.getTarget()).getText());
		
		clearClientParameter();
		
		loginData.add(id.getId());
		loginData.add(id.getPassword());
		listInput.add("14454"); //最终应该放的是id.getId()
		btnCode = 3;
		
		MenuItem item = (MenuItem) event.getTarget();
		if(item.getText().equals("最近一个月缺勤次数")) {
			listInput.add("1");
			absenceNearestOneMonthBtn.setDisable(true);
			absenceNearestThreeMonthBtn.setDisable(false);
			absenceNearestFiveMonthBtn.setDisable(false);
			
		}else if(item.getText().equals("最近三个月缺勤次数")) {
			listInput.add("3");
			absenceNearestThreeMonthBtn.setDisable(true);
			absenceNearestOneMonthBtn.setDisable(false);
			absenceNearestFiveMonthBtn.setDisable(false);
	
		}else if(item.getText().equals("最近五个月缺勤次数")) {
			listInput.add("5");
			absenceNearestFiveMonthBtn.setDisable(true);
			absenceNearestOneMonthBtn.setDisable(false);
			absenceNearestThreeMonthBtn.setDisable(false);
		}
		client(btnCode,listInput,loginData);
		
		
//		studentAttendanceLineXType.setTickLabelRotation(45);
		
		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
		series.setName("缺勤次数"); 
		String[] types = {"迟到", "进校", "课间操请假", "离校", "默认信息", "请假离校", "晚到学校",
				"晚自修迟到", "校服", "校徽校服", "早上迟到", "早退", "住宿早晨锻炼"};
		
		for (int i = 0; i < data1.length; i++) {
			series.getData().add(new XYChart.Data<String, Number>(types[i], Integer.parseInt(data1[i])));
		}
		attendanceAbsence.getData().add(series);
	}
	
	//消费记录————饼图
		@FXML
	    void consumptionClick(ActionEvent event) {
			System.out.println("消费记录");
			consumptionMonthConfirm.setText(((MenuItem)event.getTarget()).getText());
			
			clearClientParameter();
			
			loginData.add(id.getId());
			loginData.add(id.getPassword());
			listInput.add("14454"); //最终应该放的是id.getId()1
			btnCode = 4;
			
			MenuItem item = (MenuItem) event.getTarget();
			if(item.getText().equals("最近一个月消费次数")) {
				listInput.add("1");
				consumptionNearestOneMonth.setDisable(true);
				consumptionNearestThreeMonth.setDisable(false);
				consumptionNearestFiveMonth.setDisable(false);
				
			}else if(item.getText().equals("最近三个月消费次数")) {
				listInput.add("3");
				consumptionNearestThreeMonth.setDisable(true);
				consumptionNearestOneMonth.setDisable(false);
				consumptionNearestFiveMonth.setDisable(false);
		
			}else if(item.getText().equals("最近五个月消费次数")) {
				listInput.add("5");
				consumptionNearestFiveMonth.setDisable(true);
				consumptionNearestOneMonth.setDisable(false);
				consumptionNearestThreeMonth.setDisable(false);
			}
			client(btnCode,listInput,loginData);
			
			ObservableList<Data> series = FXCollections.observableArrayList();
			
			for (int i = 0; i < data1.length; i++) {
				series.addAll(new PieChart.Data("最近第" + Integer.toString(i + 1) + "个月", Double.parseDouble(data1[i])));
			}
			
			consumptionNearestMonth.setData(series);
		}
		
		//学生学业画像（每一科）————折线图
		@FXML
	    void scoreClick(ActionEvent event) {
			System.out.println("学生学业画像——多道折线图");
			scoreTimesConfirm.setText(((MenuItem)event.getTarget()).getText());
			clearClientParameter();
			loginData.add(id.getId());
			loginData.add(id.getPassword());
			listInput.add("14454");
			btnCode = 5;
			
			MenuItem item = (MenuItem) event.getTarget();
			if(item.getText().equals("最近3次")) {
				listInput.add("3");
				gradeNearestThreeTimes.setDisable(true);
				gradeNearestFiveTimes.setDisable(false);
				gradeNearestTenTimes.setDisable(false);
				
			}else if(item.getText().equals("最近5次")) {
				listInput.add("5");
				gradeNearestFiveTimes.setDisable(true);
				gradeNearestTenTimes.setDisable(false);
				gradeNearestThreeTimes.setDisable(false);
		
			}else if(item.getText().equals("最近10次")) {
				listInput.add("10");
				gradeNearestTenTimes.setDisable(true);
				gradeNearestThreeTimes.setDisable(false);
				gradeNearestFiveTimes.setDisable(false);
			}
			client(btnCode,listInput,loginData);
			
			ObservableList<XYChart.Series<String, Number>> series1 = FXCollections.observableArrayList();
			ObservableList<XYChart.Series<String, Number>> series2 = FXCollections.observableArrayList();
			
			Series<String, Number> chinese = new Series<String, Number>();
			Series<String, Number> mathematics = new Series<String, Number>();
			Series<String, Number> english = new Series<String, Number>();
			Series<String, Number> physics = new Series<String, Number>();
			Series<String, Number> biology = new Series<String, Number>();
			Series<String, Number> politics = new Series<String, Number>();
			Series<String, Number> chemistry = new Series<String, Number>();
			Series<String, Number> history = new Series<String, Number>();
			Series<String, Number> geography = new Series<String, Number>();
			chinese.setName("语文");
			mathematics.setName("数学");
			english.setName("英语");
			physics.setName("物理");
			biology.setName("生物");
			politics.setName("政治");
			chemistry.setName("化学");
			history.setName("历史");
			geography.setName("地理");
	        
			for(int i = 0;i<data2[0].length;i++){
				chinese.getData().add(new javafx.scene.chart.XYChart.Data<String, Number>(Integer.toString(i+1), Integer.parseInt(data2[0][i])));
				mathematics.getData().add(new javafx.scene.chart.XYChart.Data<String, Number>(Integer.toString(i+1), Integer.parseInt(data2[1][i])));
				english.getData().add(new javafx.scene.chart.XYChart.Data<String, Number>(Integer.toString(i+1), Integer.parseInt(data2[2][i])));
				physics.getData().add(new javafx.scene.chart.XYChart.Data<String, Number>(Integer.toString(i+1), Integer.parseInt(data2[3][i])));
				biology.getData().add(new javafx.scene.chart.XYChart.Data<String, Number>(Integer.toString(i+1), Integer.parseInt(data2[4][i])));
				politics.getData().add(new javafx.scene.chart.XYChart.Data<String, Number>(Integer.toString(i+1), Integer.parseInt(data2[5][i])));
				chemistry.getData().add(new javafx.scene.chart.XYChart.Data<String, Number>(Integer.toString(i+1), Integer.parseInt(data2[6][i])));
				history.getData().add(new javafx.scene.chart.XYChart.Data<String, Number>(Integer.toString(i+1), Integer.parseInt(data2[7][i])));
				geography.getData().add(new javafx.scene.chart.XYChart.Data<String, Number>(Integer.toString(i+1), Integer.parseInt(data2[8][i])));
				
			}
			series1.addAll(chinese,mathematics,english);
			series2.addAll(physics,biology,politics,chemistry,history,geography);
			gradeRequiredSubjects.setData(series1);
			gradeOptionalSubjects.setData(series2);
		}
		

	    //个人信息主页初始化
	    private void showStudentInfo() {
	    	
	    	studentHeadTeacher.setText(data1[6]);
	    	studentPolitics.setText(data1[5]);
	    	studentEnrollmentY.setText(data1[4]);
	    	enrollmentRanking.setText("100"); // 接口缺失的数据：入学排名
	    	studentId.setText(data1[1]);
	    	studentAge.setText(data1[2]);
	    	studentGender.setText(data1[3]);
	    	studentName.setText(data1[0]);
			
		}
	    
	    
	    
	    
	    
	    
	  //传递登陆者id
	    @Override
  		public void initialize(URL arg0, ResourceBundle arg1) {
  			// TODO Auto-generated method stub
  			System.out.println(id.getId()+"   "+id.getPassword());
  		}
  		
  		public static void setText(String idTxt, String passwordTxt)
  	    {
  			id.setText(idTxt, passwordTxt);
  	    }		
  		
  		
  		//为了改变字符串数组的大小
  		public void addToData1(String element) //element为新元素
  		{
  			String[] array = new String[data1.length + 1]; //创建一个新数组 
  			for (int i = 0; i < data1.length; i++) {
  				array[i] = data1[i];
  			}
  			//将新元素添加到新数组
  			array[data1.length] = element;
  			data1 = array;
  			
  		}
  		
  		//清空用过的client参数
  		public void clearClientParameter() {
  			loginData.clear();
  			listInput.clear();
  		}
  		
  		public void client(int code, ArrayList<String> list, ArrayList<String> login) {
  			//参数注释：code是按钮序号，list是传入的参数，login是用户ID和密码
  			try {
  	            //1.创建客户端Socket，指定服务器地址和端口
  				//如果不是本机链接，则将localhost改为链接服务器的IP
//  	            Socket socket=new Socket("10.22.27.42", 8888);
  	          Socket socket=new Socket("172.16.99.168", 8888);
  	            //2.获取输出流，向服务器端发送信息
  	            OutputStream os=socket.getOutputStream();//字节输出流
  	            InputStream is=socket.getInputStream();//字节输入流

  	            //创建输出对象流，将对象输出
  	            ObjectOutputStream oos = new ObjectOutputStream(os);
  	            ObjectInputStream ois = new ObjectInputStream(is);
  	            //oos.writeObject(test);
  	            //根据输入的序号执行对应的功能
  	            //本功能目前没有实现传输数据，只是把得到的数据进行打印
  	            switch (code) {
  	            case 0: {
  	            	oos.writeObject(code);
  	            	oos.writeObject(list);
  	            	oos.writeObject(login);
  	            	ArrayList<Object> object =  (ArrayList<Object>) ois.readObject();
  	            	System.out.println(object);
  	            	object.add("-1");
  	            	
  	            	break;
  	            }
  	            case 1: {
  	            	
  	            	//查看学生个人信息
  	            	oos.writeObject(code);
  					oos.writeObject(list);
  					oos.writeObject(login);
  					ArrayList<String> object = (ArrayList<String>) ois.readObject();
  					System.out.println(object); 
  					data1 = new String[0];
  					for(int i=0;i<object.size();i++) {
  						addToData1(object.get(i).toString());
  					}
  					break;
  				}
  	            case 2: {
  	            	//查看成长档案
  	            	oos.writeObject(code);
  					oos.writeObject(list);
  					oos.writeObject(login);
  					ArrayList<Integer> object = (ArrayList<Integer>) ois.readObject();
  					System.out.println(object); 
  					data1 = new String[0];
  					for(int i=0;i<object.size();i++) {
  						addToData1(object.get(i).toString());
  					}
  	            	break;
  				}
  	            case 3: {
  	            	//查看考勤记录
  					oos.writeObject(code);
  					oos.writeObject(list);
  					oos.writeObject(login);
  					ArrayList<Integer> object = (ArrayList<Integer>) ois.readObject();
  					System.out.println(object); 
  					data1 = new String[0];
  					for(int i=0;i<object.size();i++) {
  						addToData1(object.get(i).toString());
  					}
  					break;
  				}
  				case 4: {
  					//查看消费记录
  					oos.writeObject(code);
  					oos.writeObject(list);
  					oos.writeObject(login);
  					ArrayList<Double> object = (ArrayList<Double>) ois.readObject();
  					System.out.println(object); 
  					data1 = new String[0];
  					for(int i=0;i<object.size();i++) {
  						addToData1(object.get(i).toString());
  					}
  					break;
  				}
  				case 5: {
  					//查看学业画像
  					oos.writeObject(code);
  					oos.writeObject(list);
  					oos.writeObject(login);
  					ArrayList<ArrayList<Integer>> object = (ArrayList<ArrayList<Integer>>) ois.readObject();
  					System.out.println(object); 
  					data2 = new String[object.size()][object.get(0).size()];
  					for(int i=0;i<object.size();i++) {
  						for(int j=0;j<object.get(i).size();j++) {
  							data2[i][j] = object.get(i).get(j).toString();
  						}
  					}
  	            	break;
  				}
  				case 6: {
  					//查看班级学生信息
  					oos.writeObject(code);
  					oos.writeObject(list);
  					oos.writeObject(login);
  					ArrayList<String> object = (ArrayList<String>) ois.readObject();
  					System.out.println(object); 
  					//输入：学生ID
  					//返回：学生姓名、年龄、性别、学号、入学年份、政治面貌，入学排名，查看班主任老师
  					data1 = new String[0];
  					for(int i=0;i<object.size();i++) {
  						addToData1(object.get(i).toString());
  					}
  	            	break;
  				}
  				case 7: {
  	            	
  	            	//查看学生考勤记录
  					oos.writeObject(code);
  					oos.writeObject(list);
  					oos.writeObject(login);
  					
  					ArrayList<Integer> object = (ArrayList<Integer>) ois.readObject();
  					System.out.println(object);  
  					//输入：学生ID、最近n次时间（最近1个月、3个月、5个月）
  					//返回：最近每个月缺勤次数(一维数组)
  					data1 = new String[0];
  					for(int i=0;i<object.size();i++) {
  						addToData1(object.get(i).toString());
  					}
  	            	break;
  	            }
  	            case 8: {
  	            	
  	            	//查看学生成长档案
  	            	oos.writeObject(code);
  					oos.writeObject(list);
  					oos.writeObject(login);
  					ArrayList<Integer> object = (ArrayList<Integer>) ois.readObject();
  					System.out.println(object);
  					//输入：学生ID（？）、最近n次时间（最近3次、5次、10次）
  					//返回：最近n次考试的总分(一维数组)
  					data1 = new String[0];
  					for(int i=0;i<object.size();i++) {
  						addToData1(object.get(i).toString());
  					}
  	            	break;
  	            }
  	            case 9: {
  	            	
  	            	//查看学生的学业画像
  	            	oos.writeObject(code);
  					oos.writeObject(list);
  					oos.writeObject(login);
  					ArrayList<ArrayList<Integer>> object = (ArrayList<ArrayList<Integer>>) ois.readObject();
  					System.out.println(object);
  					//输入：学生id(?),最近n次考试(最近3次、5次、10次)
//  					返回：二维数组，最近n次考试每科的总分/排名
//  					行是科目，列是次数
//  					[[语文1，语文2，…,语文n]
//  					[数学1，数学2，…,数学n]
  					data2 = new String[object.size()][object.get(0).size()];
  					for(int i=0;i<object.size();i++) {
  						for(int j=0;j<object.get(i).size();j++) {
  							data2[i][j] = object.get(i).get(j).toString();
  						}
  					}
  	            	break;
  	            }
  				case 10: {
  					//查看班级学业信息
  					oos.writeObject(code);
  					oos.writeObject(list);
  					oos.writeObject(login);
  					ArrayList<ArrayList<Integer>> object = (ArrayList<ArrayList<Integer>>) ois.readObject();
  					System.out.println(object); 
//  					输入：老师ID，学期ID、最近n次考试、考试科目ID
//  					返回：二维数组
//  					[[第1次考试平均分，第2次考试平均分，…,第n次考试平均分]，
//  					[第1次考试最高分，第2次考试最高分，…,第n次考试最高分]，
//  					[第1次考试最低分，第2次考试最低分，…,第n次考试最低分]
//  					]
  					data2 = new String[object.size()][object.get(0).size()];
  					for(int i=0;i<object.size();i++) {
  						for(int j=0;j<object.get(i).size();j++) {
  							data2[i][j] = object.get(i).get(j).toString();
  						}
  					}
  					break;
  				}
  				case 11: {
  	            	//查询老师基本信息
  					oos.writeObject(code);
  					oos.writeObject(list);
  					oos.writeObject(login);
  					ArrayList<String> object = (ArrayList<String>) ois.readObject();
  					System.out.println(object); 
//  					输入：老师ID
//  					返回：名字，年龄，性别，民族，政治面貌，学历，联系电话（参考教师表），邮箱，任课科目。
  					data1 = new String[0];
  					for(int i=0;i<object.size();i++) {
  						addToData1(object.get(i).toString());
  					}
  					break;
  				}
  	            case 12: {
  	            	//查看任课班级
  	            	oos.writeObject(code);
  	            	oos.writeObject(list);
  	            	oos.writeObject(login);
  	            	ArrayList<String> object = (ArrayList<String>) ois.readObject();
  	            	System.out.println(object);
//  	            	输入：老师ID
//  	            	返回：一维数组，老师任课的班级[4,7,8]
  	            	data1 = new String[0];
  					for(int i=0;i<object.size();i++) {
  						addToData1(object.get(i).toString());
  					}
  					break;
  				}
  	            case 13: {
  	            	//查看班级学生名单
  					oos.writeObject(code);
  					oos.writeObject(list);
  					oos.writeObject(login);
  					ArrayList<String> object = (ArrayList<String>) ois.readObject();
  					System.out.println(object); 
//  					输入：老师ID
//  					返回：一维数组（班级的每个学生的名字）
  					data1 = new String[0];
  					for(int i=0;i<object.size();i++) {
  						addToData1(object.get(i).toString());
  					}
  					break;
  				}
  	            //下面的都是教务处的
  	            case 14: {
  	            	
  	            	//查看学生的基本信息
  	            	oos.writeObject(code);
  					oos.writeObject(list);
  					oos.writeObject(login);
  					ArrayList<String> object = (ArrayList<String>) ois.readObject();
  					System.out.println(object);
//  					输入：学生ID
//  					返回：学生姓名、年龄、性别、学号、入学年份、政治面貌，入学排名，查看班主任老师
  					data1 = new String[0];
  					for(int i=0;i<object.size();i++) {
  						addToData1(object.get(i).toString());
  					}
  	            	break;
  	            }
  				case 15: {
  	            	
  	            	//查看学生考勤记录
  					oos.writeObject(code);
  					oos.writeObject(list);
  					oos.writeObject(login);
  					ArrayList<Integer> object = (ArrayList<Integer>) ois.readObject();
  					System.out.println(object); 
//  					输入：学生ID（？）、最近n次时间（最近1个月、3个月、5个月）
//  					返回：最近每个月缺勤次数(一维数组)
  					data1 = new String[0];
  					for(int i=0;i<object.size();i++) {
  						addToData1(object.get(i).toString());
  					}
  	            	break;
  	            }
  				case 16: {
  	            	
  	            	//查看学生成长档案
  					oos.writeObject(code);
  					oos.writeObject(list);
  					oos.writeObject(login);
  					ArrayList<Integer> object = (ArrayList<Integer>) ois.readObject();
  					System.out.println(object);
//  					输入：学生ID（？）、最近n次时间（最近3次、5次、10次）
//  					返回：最近n次考试的总分(一维数组)
  					data1 = new String[0];
  					for(int i=0;i<object.size();i++) {
  						addToData1(object.get(i).toString());
  					}
  	            	break;
  	            }
  				case 17: {
  	            	
  	            	//查看学生的学业画像
  					oos.writeObject(code);
  					oos.writeObject(list);
  					oos.writeObject(login);
  					ArrayList<ArrayList<Integer>> object = (ArrayList<ArrayList<Integer>>) ois.readObject();
  					System.out.println(object);
//  					输入：学生id（？）、最近n次考试(最近3次、5次、10次)
//  					返回：二维数组，最近n次考试每科的总分/排名
//  							行是科目，列是次数
//  							[[语文1，语文2，…,语文n]
//  							[数学1，数学2，…,数学n]
//  							…
//  							]
  					data2 = new String[object.size()][object.get(0).size()];
  					for(int i=0;i<object.size();i++) {
  						for(int j=0;j<object.get(i).size();j++) {
  							data2[i][j] = object.get(i).get(j).toString();
  						}
  					}
  	            	break;
  	            }
  				case 18: {
  	            	
  	            	//查看老师基本信息
  					oos.writeObject(code);
  					oos.writeObject(list);
  					oos.writeObject(login);
  					ArrayList<String> object = (ArrayList<String>) ois.readObject();
  					System.out.println(object);
//  					输入：老师ID
//  					返回：名字，年龄，性别，任课科目，学历，联系电话（参考教师表）
  					data1 = new String[0];
  					for(int i=0;i<object.size();i++) {
  						addToData1(object.get(i).toString());
  					}
  	            	break;
  	            }
  				case 19: {
  	            	
  	            	//查看班级学生信息表
  					oos.writeObject(code);
  					oos.writeObject(list);
  					oos.writeObject(login);
  					ArrayList<ArrayList<Integer>> object = (ArrayList<ArrayList<Integer>>) ois.readObject();
  					System.out.println(object);
//  					输入：班级ID
//  					返回：一维数组（班级的每个学生的名字）
  					data1 = new String[0];
  					for(int i=0;i<object.size();i++) {
  						addToData1(object.get(i).toString());
  					}
  	            	break;
  	            }
  				case 20: {
  	            	
  	            	//录入学生信息
  					oos.writeObject(code);
  					oos.writeObject(list);
  					oos.writeObject(login);
  					ArrayList<String> object = (ArrayList<String>) ois.readObject();
  					System.out.println(object);
  					//输入：ID、姓名、性别、民族、入学年份、出生日期、家庭住址、家庭类型、政治面貌、入学排名、宿舍号、是否退学
  	            	break;
  	            }
  				case 21: {
  	            	
  	            	//录入教师信息
  					oos.writeObject(code);
  					oos.writeObject(list);
  					oos.writeObject(login);
  					ArrayList<String> object = (ArrayList<String>) ois.readObject();
  					System.out.println(object);
//  					输入（表头）：教师ID、姓名、性别、民族、政治面貌、学历、出生日期、联系电话、邮箱
  	            	break;
  	            }
  				case 22: {
  	            	
  	            	//按照考勤类型查看考勤情况
  					oos.writeObject(code);
  					oos.writeObject(list);
  					oos.writeObject(login);
  					ArrayList<ArrayList<String>> object = (ArrayList<ArrayList<String>>) ois.readObject();
  					System.out.println(object);
  					//输入时间段
  					data2 = new String[object.size()][object.get(0).size()];
  					for(int i=0;i<object.size();i++) {
  						for(int j=0;j<object.get(i).size();j++) {
  							data2[i][j] = object.get(i).get(j).toString();
  						}
  					}
  	            	break;
  	            }
  				case 23: {
  	            	
  	            	//按照班级查看考勤情况
  					oos.writeObject(code);
  					oos.writeObject(list);
  					oos.writeObject(login);
  					ArrayList<ArrayList<String>> object = (ArrayList<ArrayList<String>>) ois.readObject();
  					System.out.println(object);
  					//输入时间段
  					data2 = new String[object.size()][object.get(0).size()];
  					for(int i=0;i<object.size();i++) {
  						for(int j=0;j<object.get(i).size();j++) {
  							data2[i][j] = object.get(i).get(j).toString();
  						}
  					}
  					
  	            	break;
  	            }
  				case 24: {
  	            	
  	            	//统计年级学业情况
  					oos.writeObject(code);
  					oos.writeObject(list);
  					oos.writeObject(login);
  					ArrayList<ArrayList<String>> object = (ArrayList<ArrayList<String>>) ois.readObject();
  					System.out.println(object);
//  					输入：学科ID、最近n次时间（最近3次、5次、10次）
//  					返回：二维数组（针对全年级的学生、查询时间需要很久）
//  					[[第1次考试平均分，第2次考试平均分，…,第n次考试平均分]，
//  					[第1次考试最高分，第2次考试最高分，…,第n次考试最高分]，
//  					[第1次考试最低分，第2次考试最低分，…,第n次考试最低分]
//  					]
  					data2 = new String[object.size()][object.get(0).size()];
  					for(int i=0;i<object.size();i++) {
  						for(int j=0;j<object.get(i).size();j++) {
  							data2[i][j] = object.get(i).get(j).toString();
  						}
  					}
  	            	break;
  	            }
  				case 25: {
  	            	
  	            	//统计班级学业
  					oos.writeObject(code);
  					oos.writeObject(list);
  					oos.writeObject(login);
  					ArrayList<ArrayList<String>> object = (ArrayList<ArrayList<String>>) ois.readObject();
  					System.out.println(object);
//  					输入：班级ID、学科ID、最近n次时间（最近3次、5次、10次）
//  					返回：二维数组（针对全年级的学生、查询时间需要很久）
//  					[[第1次考试平均分，第2次考试平均分，…,第n次考试平均分]，
//  					[第1次考试最高分，第2次考试最高分，…,第n次考试最高分]，
//  					[第1次考试最低分，第2次考试最低分，…,第n次考试最低分]
//  					]
  					data2 = new String[object.size()][object.get(0).size()];
  					for(int i=0;i<object.size();i++) {
  						for(int j=0;j<object.get(i).size();j++) {
  							data2[i][j] = object.get(i).get(j).toString();
  						}
  					}
  	            	break;
  	            }
  				case 26: {
  	            	
  	            	//查看年级班级学业情况
  					oos.writeObject(code);
  					oos.writeObject(list);
  					oos.writeObject(login);
  					ArrayList<ArrayList<String>> object = (ArrayList<ArrayList<String>>) ois.readObject();
  					System.out.println(object);
  					//学科ID
  					data2 = new String[object.size()][object.get(0).size()];
  					for(int i=0;i<object.size();i++) {
  						for(int j=0;j<object.get(i).size();j++) {
  							data2[i][j] = object.get(i).get(j).toString();
  						}
  					}
  	            	break;
  	            }
  				default:
  					System.out.println("没有对应的序号：" + code);
  					
  				}
  	          
  	            socket.close();
  	        } catch (UnknownHostException e) {
  	            e.printStackTrace();
  	        } catch (IOException e) {
  	            e.printStackTrace();
  	        } catch (ClassNotFoundException e) {
  				// TODO 自动生成的 catch 块
  				e.printStackTrace();
  			} 
  		}
  		

}
