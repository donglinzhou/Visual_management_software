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
import java.util.ResourceBundle;

import com.sun.javafx.collections.MappingChange.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.ClassStudent;
import model.ClassTeaching;
import model.LoginId;
import control.LoginSelectControl;
import application.Main;


public class TeacherController implements Initializable {
	
	//登录界面传递id的变量
	public static LoginId id = new LoginId();
	
	@FXML
    private Label headTxt;
    @FXML
    private MenuItem studentAttendanceBtn;
    @FXML
    private MenuItem studentInfoBtn;
    @FXML
    private Button infoBtn;
    @FXML
    private Button classScoreBtn;
    @FXML
    private MenuItem studentScoreBtn;
    @FXML
    private Button classStudentBtn;
    @FXML
    private Button classTeachingBtn;
    @FXML
    private MenuItem studentGrowingBtn;
    @FXML
    private MenuButton includeStudentBtns;
    @FXML
    private Button logOut;
    
    private String itemSelect;
    
    //学生考勤特有变量
    @FXML
    private TextField studentAttendanceIdInput;
    @FXML
    private MenuItem studentAbsenceNearestFiveMonthBtn;
    @FXML
    private MenuItem studentAbsenceNearestThreeMonthBtn;
    @FXML
    private MenuItem studentAbsenceNearestOneMonthBtn;
    @FXML
    private MenuButton studentAttendanceMonthConfirm;
    @FXML
    private BarChart<String, Number> studentAttendanceAbsence;
    @FXML
    private CategoryAxis studentAttendanceLineXType;
    @FXML
    private Label emptyWarning1;
    
    //学生成长档案
    @FXML
    private TextField studentGrowingIdInput;
    @FXML
    private LineChart<String, Number> studentGrowingGrade;
    @FXML
    private MenuItem studentAllGradeLastTenTimesBtn;
    @FXML
    private MenuItem studentAllGradeLastFiveTimesBtn;
    @FXML
    private MenuItem studentAllGradeLastThreeTimesBtn;
    @FXML
    private MenuButton studentGrowingTimesConfirm;
    @FXML
    private Label emptyWarning2;
    
    //学生学业画像
    @FXML
    private TextField studentScoreIdInput;
    @FXML
    private Label emptyWarning4;
    @FXML
    private MenuItem studentGradeNearestThreeTimes;
    @FXML
    private MenuItem studentGradeNearestFiveTimes;
    @FXML
    private MenuItem studentGradeNearestTenTimes;
    @FXML
    private MenuButton studentScoreTimesConfirm;
    @FXML
    private LineChart<String, Number> studentGradeOptionalSubjects;
    @FXML
    private LineChart<String, Number> studentGradeRequiredSubjects;
    
    //班级学业
    private String subjectNumber = "0";
    private String semesterNumber = "0";
    @FXML
    private TextField ClassScoreIdInput;
    @FXML
    private Label emptyWarning5;
    @FXML
    private Button classLastTimesBtn;
    @FXML
    private LineChart<String, Number> classScore;
    @FXML
    private MenuItem classLastThreeTimesBtn;
    @FXML
    private MenuItem classLastFiveTimesBtn;
    @FXML
    private MenuItem classLastTenTimesBtn;
    @FXML
    private MenuButton classScoreSemesterConfirm;
    @FXML
    private MenuButton classScoreTimesConfirm;
    @FXML
    private MenuButton classScoreSubjectConfirm;

    
    //学生基本信息特有变量
    @FXML
    private Button studentInfoConfirmBtn;
    @FXML
    private Label studentHeadTeacher;
    @FXML
    private Label studentPolitics;
    @FXML
    private Label studentEntranceYear;
    @FXML
    private Label studentAge;
    @FXML
    private Label studentGender;
    @FXML
    private Label studentName;
    @FXML
    private Label studentEntranceRank;
    @FXML
    private Label studentIdNumber;
    @FXML
    private TextField studentInfoIdInput;
    @FXML
    private Label emptyWarning3;
    
    
    //教师基本信息
    @FXML
    private Label teacherAge;
    @FXML
    private Label teacherName;
    @FXML
    private Label teacherEducation;
    @FXML
    private Label teacherPhone;
    @FXML
    private Label teacherPolitics;
    @FXML
    private Label teacherGender;
    @FXML
    private Label teacherNation;
    @FXML
    private Label projectTeaching;

    //查看任课班级
    @FXML
    private TableView<ClassTeaching> tvClassTeaching;
    @FXML
    private TableColumn<ClassTeaching, String> colClassName;
    
    //查看班级学生名单
    @FXML
    private TableView<ClassStudent> tvClassStudent;
    @FXML
    private TableColumn<ClassStudent, String> colClassStudent;
    @FXML
    private TableColumn<ClassStudent, String> colClassTeaching;
    
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
    	listInput.add("51");
    	btnCode = 11;
    	client(btnCode, listInput, loginData);
    	infoBtnClick1();
    	showTeacherInfo();
    }
   
    @FXML
    public void infoBtnClick1() {
    	System.out.println("个人信息主页");
		Stage selectStage = (Stage) headTxt.getScene().getWindow();
		
		try {	
			Pane infoPane = FXMLLoader.load(getClass().getResource("/view/teacherHome.fxml"));
			teacherName = (Label) infoPane.lookup("#teacherName");
			teacherAge = (Label) infoPane.lookup("#teacherAge");
			teacherEducation = (Label) infoPane.lookup("#teacherEducation");
			teacherPhone = (Label) infoPane.lookup("#teacherPhone");
			teacherPolitics = (Label) infoPane.lookup("#teacherPolitics");
			teacherGender = (Label) infoPane.lookup("#teacherGender");
			teacherNation = (Label) infoPane.lookup("#teacherNation");
			projectTeaching = (Label) infoPane.lookup("#projectTeaching");
			Scene infoScene = new Scene(infoPane);
			selectStage.setScene(infoScene);
			selectStage.setTitle("教师端");
			selectStage.show();	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    }
    
    @FXML
    public void showTeacherInfo() {

		teacherName.setText(data1[0]);
		teacherAge.setText(data1[1]);
	    teacherEducation.setText(data1[5]);
	    teacherPhone.setText(data1[6]);
	    teacherPolitics.setText("党员");
	    teacherGender.setText(data1[2]);
	    teacherNation.setText(data1[3]);
	    projectTeaching.setText(data1[8]);
	}

    @FXML
    void studentInfoBtnClick(ActionEvent event) {
    	System.out.println("学生_个人信息主页");
    	Stage selectStage = (Stage) headTxt.getScene().getWindow();
		
		try {	
			Pane infoPane = FXMLLoader.load(getClass().getResource("/view/teacherStudentInfo.fxml"));
			Scene infoScene = new Scene(infoPane);
			selectStage.setScene(infoScene);
			selectStage.setTitle("教师端");
			selectStage.show();	
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void studentAttendanceBtnClick(ActionEvent event) {
    	System.out.println("学生_考勤记录");
    	
		Stage selectStage = (Stage) headTxt.getScene().getWindow();
		
		try {	
			Pane infoPane = FXMLLoader.load(getClass().getResource("/view/teacherStudentAttendance.fxml"));
			Scene infoScene = new Scene(infoPane);
			selectStage.setScene(infoScene);
			selectStage.setTitle("教师端");
			selectStage.show();	
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void studentGrowingBtnClick(ActionEvent event) {
    	System.out.println("学生_成长档案");
    	
		Stage selectStage = (Stage) headTxt.getScene().getWindow();
		
		try {	
			Pane infoPane = FXMLLoader.load(getClass().getResource("/view/teacherStudentGrowing.fxml"));
			Scene infoScene = new Scene(infoPane);
			selectStage.setScene(infoScene);
			selectStage.setTitle("教师端");
			selectStage.show();	
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void studentScoreBtnClick(ActionEvent event) {
    	System.out.println("学生_学业画像");
    	
		Stage selectStage = (Stage) headTxt.getScene().getWindow();
		
		try {	
			Pane infoPane = FXMLLoader.load(getClass().getResource("/view/teacherStudentScore.fxml"));
			Scene infoScene = new Scene(infoPane);
			selectStage.setScene(infoScene);
			selectStage.setTitle("教师端");
			selectStage.show();	
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void classScoreBtnClick(ActionEvent event) {
    	System.out.println("班级学业信息");
    	
		Stage selectStage = (Stage) headTxt.getScene().getWindow();
		
		try {	
			Pane infoPane = FXMLLoader.load(getClass().getResource("/view/teacherClassScore.fxml"));
			Scene infoScene = new Scene(infoPane);
			selectStage.setScene(infoScene);
			selectStage.setTitle("教师端");
			selectStage.show();	
		} catch (IOException e) {
			e.printStackTrace();
		}

    }
    
    //查看任课班级
    @FXML
    void classTeachingBtnClick(ActionEvent event) {
    	classTeachingBtnClick1();
    	showClassTeaching();
    }

    @FXML
    public void classTeachingBtnClick1() {
    	System.out.println("查看任课班级");
		Stage selectStage = (Stage) headTxt.getScene().getWindow();
		
		try {	
			Pane infoPane = FXMLLoader.load(getClass().getResource("/view/teacherClassTeaching.fxml"));
			tvClassTeaching = (TableView<ClassTeaching>) infoPane.lookup("#tvClassTeaching");
			colClassName = (TableColumn<ClassTeaching, String>) tvClassTeaching.getColumns().get(0);
			
			Scene infoScene = new Scene(infoPane);
			selectStage.setScene(infoScene);
			selectStage.setTitle("教师端");
			selectStage.show();	
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

	//班级学生名单
	@FXML
    void classStudentBtnClick(ActionEvent event) {
		classStudentBtnClick1();
		showClassStudent();
	}
	

	@FXML
    public void classStudentBtnClick1() {
    	System.out.println("班级学生名单");
    	
		Stage selectStage = (Stage) headTxt.getScene().getWindow();
		
		try {	
			Pane infoPane = FXMLLoader.load(getClass().getResource("/view/teacherClassStudent.fxml"));
			tvClassStudent = (TableView<ClassStudent>) infoPane.lookup("#tvClassStudent");
			colClassStudent = (TableColumn<ClassStudent, String>) tvClassStudent.getColumns().get(0);
			
			Scene infoScene = new Scene(infoPane);
			selectStage.setScene(infoScene);
			selectStage.setTitle("教师端");
			selectStage.show();	
		} catch (IOException e) {
			e.printStackTrace();
		}
		

    }
    
  //学生考勤记录————柱形图
	@FXML
    void studentAttendanceClick(ActionEvent event) {
  		System.out.println("考勤记录");
  		studentAttendanceMonthConfirm.setText(((MenuItem)event.getTarget()).getText());
  		if (!studentAttendanceIdInput.getText().equals("")) {
  			emptyWarning1.setText("");
  			
  			clearClientParameter();
  			
  			loginData.add(id.getId());
  			loginData.add(id.getPassword());
  			listInput.add(studentAttendanceIdInput.getText()); //最终应该放的是id.getId()
  			btnCode = 7;
  			
  			MenuItem item = (MenuItem) event.getTarget();
  			itemSelect = item.getText();
  			if(itemSelect.equals("最近一个月缺勤次数")) {
  				listInput.add("1");
  				studentAbsenceNearestOneMonthBtn.setDisable(true);
  				studentAbsenceNearestThreeMonthBtn.setDisable(false);
  				studentAbsenceNearestFiveMonthBtn.setDisable(false);
  				
  			}else if(itemSelect.equals("最近三个月缺勤次数")) {
  				listInput.add("3");
  				studentAbsenceNearestThreeMonthBtn.setDisable(true);
  				studentAbsenceNearestOneMonthBtn.setDisable(false);
  				studentAbsenceNearestFiveMonthBtn.setDisable(false);
  		
  			}else if(itemSelect.equals("最近五个月缺勤次数")) {
  				listInput.add("5");
  				studentAbsenceNearestFiveMonthBtn.setDisable(true);
  				studentAbsenceNearestOneMonthBtn.setDisable(false);
  				studentAbsenceNearestThreeMonthBtn.setDisable(false);
  			}
  			client(btnCode,listInput,loginData);
  			
  			
//  			studentAttendanceLineXType.setTickLabelRotation(45);
  			
  	  		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
  	  		series.setName("缺勤次数"); 
  			String[] types = {"迟到", "进校", "课间操请假", "离校", "默认信息", "请假离校", "晚到学校",
  					"晚自修迟到", "校服", "校徽校服", "早上迟到", "早退", "住宿早晨锻炼"};
  	  		
  	  		for (int i = 0; i < 3; i++) {
  	  			series.getData().add(new XYChart.Data<String, Number>(types[i], Integer.parseInt(data1[i])));
  	  		}
  	  		studentAttendanceAbsence.getData().add(series);
  		}else {
  			emptyWarning1.setText("请输入正确的学生id!");
  		}

  		
  	}
    
  //学生成长档案————折线图
	@FXML
    void studentGrowingClick(ActionEvent event) {
  		System.out.println("学生成长档案——折线图");
  		studentGrowingTimesConfirm.setText(((MenuItem)event.getTarget()).getText());
  		if(!studentGrowingIdInput.getText().equals("")) {
  			emptyWarning2.setText("");
  			clearClientParameter();
  			
  			loginData.add(id.getId());
  			loginData.add(id.getPassword());
  			listInput.add(studentGrowingIdInput.getText()); 
  			btnCode = 8;
  			
  			MenuItem item = (MenuItem) event.getTarget();
  			itemSelect = item.getText();
  			if(itemSelect.equals("最近3次的考试总分")) {
  				listInput.add("3");
  				studentAllGradeLastThreeTimesBtn.setDisable(true);
  				studentAllGradeLastFiveTimesBtn.setDisable(false);
  				studentAllGradeLastTenTimesBtn.setDisable(false);
  				
  			}else if(itemSelect.equals("最近5次的考试总分")) {
  				listInput.add("5");
  				studentAllGradeLastFiveTimesBtn.setDisable(true);
  				studentAllGradeLastThreeTimesBtn.setDisable(false);
  				studentAllGradeLastTenTimesBtn.setDisable(false);
  		
  			}else if(itemSelect.equals("最近10次的考试总分")) {
  				listInput.add("10");
  				studentAllGradeLastTenTimesBtn.setDisable(true);
  				studentAllGradeLastThreeTimesBtn.setDisable(false);
  				studentAllGradeLastFiveTimesBtn.setDisable(false);
  			}
  			client(btnCode,listInput,loginData);
  	  		
  	  		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
  	  		series.setName("总分");
  	          
  	  		for (int i = 0; i < data1.length; i++) {
  	  			series.getData().add(new XYChart.Data<String, Number>(Integer.toString(i+1), Integer.parseInt(data1[i])));
  	  		}
  	          
  	  		studentGrowingGrade.getData().add(series);
  		}else {
  			emptyWarning2.setText("请输入正确的学生id！");
  		}
  		
  	}
    
	//二维数组
  //学生学业画像（每一科）————折线图
	@FXML
    void studentScoreClick(ActionEvent event) {
		System.out.println("学生学业画像——多道折线图");
  		studentScoreTimesConfirm.setText(((MenuItem)event.getTarget()).getText());
			
		if(!studentScoreIdInput.getText().equals("")) {
			emptyWarning4.setText("");
			clearClientParameter();
			loginData.add(id.getId());
			loginData.add(id.getPassword());
			listInput.add(studentScoreIdInput.getText());
			btnCode = 9;
			
			MenuItem item = (MenuItem) event.getTarget();
  			itemSelect = item.getText();
  			if(itemSelect.equals("最近3次")) {
  				listInput.add("3");
  				studentGradeNearestThreeTimes.setDisable(true);
  				studentGradeNearestFiveTimes.setDisable(false);
  				studentGradeNearestTenTimes.setDisable(false);
  				
  			}else if(itemSelect.equals("最近5次")) {
  				listInput.add("5");
  				studentGradeNearestFiveTimes.setDisable(true);
  				studentGradeNearestThreeTimes.setDisable(false);
  				studentGradeNearestTenTimes.setDisable(false);
  		
  			}else if(itemSelect.equals("最近10次")) {
  				listInput.add("10");
  				studentGradeNearestTenTimes.setDisable(true);
  				studentGradeNearestThreeTimes.setDisable(false);
  				studentGradeNearestFiveTimes.setDisable(false);
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
			studentGradeRequiredSubjects.setData(series1);
			studentGradeOptionalSubjects.setData(series2);
			
		}else {
			emptyWarning4.setText("请输入正确的学生id！");
		}
			
		
	}
	
	//班级学业画像————选择学期（7）
	@FXML
    void classScoreSemesterClick(ActionEvent event) {	
  		classScoreSemesterConfirm.setText(((MenuItem)event.getTarget()).getText());
		MenuItem item = (MenuItem) event.getTarget();
		itemSelect = item.getText();
		if(itemSelect.equals("2017-2018-1")) {
			semesterNumber = "1";
				
		}else if(itemSelect.equals("2016-2017-2")) {
			semesterNumber = "2";
				
		}else if(itemSelect.equals("2014-2015-1")) {
			semesterNumber = "3";
				
		}else if(itemSelect.equals("2015-2016-1")) {
			semesterNumber = "4";
				
		}else if(itemSelect.equals("2014-2015-2")) {
			semesterNumber = "5";
				
		}else if(itemSelect.equals("2017-2018-2")) {
			semesterNumber = "6";
				
		}else if(itemSelect.equals("2018-2019-1")) {
			semesterNumber = "7";
				
		}else if(itemSelect.equals("2013-2014-1")) {
			semesterNumber = "8";
				
		}else if(itemSelect.equals("2013-2014-2")) {
			semesterNumber = "9";
				
		}else if(itemSelect.equals("2015-2016-2")) {
			semesterNumber = "10";
				
		}else if(itemSelect.equals("2016-2017-1")) {
			semesterNumber = "11";
				
		}
	}
  		
	//班级学业画像————选择学科（5）
	@FXML
    void classScoreSubjectClick(ActionEvent event) {
  		classScoreSubjectConfirm.setText(((MenuItem)event.getTarget()).getText());
		MenuItem item = (MenuItem) event.getTarget();
			itemSelect = item.getText();
		if(itemSelect.equals("语文")) {
			subjectNumber = "1";
				
		}else if(itemSelect.equals("数学")) {
			subjectNumber = "2";
				
		}else if(itemSelect.equals("英语")) {
			subjectNumber = "3";
		
		}else if(itemSelect.equals("物理")) {
			subjectNumber = "4";
				
		}else if(itemSelect.equals("化学")) {
			subjectNumber = "5";
				
		}else if(itemSelect.equals("生物")) {
			subjectNumber = "6";
				
		}else if(itemSelect.equals("历史")) {
			subjectNumber = "7";
				
		}else if(itemSelect.equals("地理")) {
			subjectNumber = "8";
				
		}else {
			subjectNumber = "17";
		}
    }		
	
  	//班级学业画像（每一科）————折线图（9）
	@FXML
    void classScoreClick(ActionEvent event) {
  		System.out.println("班级学业画像——多道折线图");
  		classScoreTimesConfirm.setText(((MenuItem)event.getTarget()).getText());
  		
  		if(semesterNumber.equals("0")) {
			emptyWarning5.setText("请先选择需要查询的学期！");
		}else if(subjectNumber.equals("0")) {
			emptyWarning5.setText("请先选择需要查询的学科！");
		}else {
			emptyWarning5.setText("");
			clearClientParameter();
			loginData.add(id.getId());
			loginData.add(id.getPassword());
			listInput.add("51");
			listInput.add(semesterNumber);
			
			MenuItem item = (MenuItem) event.getTarget();
  			itemSelect = item.getText();
  			if(itemSelect.equals("最近3次")) {
  				listInput.add("3");
  				classLastThreeTimesBtn.setDisable(true);
  				classLastFiveTimesBtn.setDisable(false);
  				classLastTenTimesBtn.setDisable(false);
  				
  			}else if(itemSelect.equals("最近5次")) {
  				listInput.add("5");
  				classLastFiveTimesBtn.setDisable(true);
  				classLastThreeTimesBtn.setDisable(false);
  				classLastTenTimesBtn.setDisable(false);
  		
  			}else if(itemSelect.equals("最近9次")) {
  				listInput.add("9");
  				classLastTenTimesBtn.setDisable(true);
  				classLastThreeTimesBtn.setDisable(false);
  				classLastFiveTimesBtn.setDisable(false);
  			}

			listInput.add(subjectNumber);
			btnCode = 10;
  			client(btnCode,listInput,loginData);
  			
  			ObservableList<XYChart.Series<String, Number>> series1 = FXCollections.observableArrayList();
			
  			Series<String, Number> highest = new Series<String, Number>();
  			Series<String, Number> average = new Series<String, Number>();
  			Series<String, Number> lowest = new Series<String, Number>();
  			highest.setName("最高分");
  			average.setName("平均分");
  			lowest.setName("最低分");
  		        
  			for(int i = 0;i<data2.length;i++){
				highest.getData().add(new javafx.scene.chart.XYChart.Data<String, Number>(Integer.toString(i+1), Integer.parseInt(data2[i][1])));
				average.getData().add(new javafx.scene.chart.XYChart.Data<String, Number>(Integer.toString(i+1), Integer.parseInt(data2[i][0])));
				lowest.getData().add(new javafx.scene.chart.XYChart.Data<String, Number>(Integer.toString(i+1), Integer.parseInt(data2[i][2])));
					
			}	
  			series1.addAll(highest,average,lowest);
  			classScore.setData(series1);
		}
	}			
  		

  		//查看学生个人信息
  		public void studentInfoConfirmBtnClick() {
  			if(!studentInfoIdInput.getText().equals("")) {
  				emptyWarning3.setText("");
  				clearClientParameter();
  	  			
  	  			loginData.add(id.getId());
  	  			loginData.add(id.getPassword());
  	  			listInput.add(studentInfoIdInput.getText()); //最终应该放的是id.getId()
  	  			btnCode = 6;
  	  			
  	  			client(btnCode,listInput,loginData);

  	  			studentHeadTeacher.setText(data1[6]);
  		    	studentPolitics.setText(data1[5]);
  		    	studentEntranceYear.setText(data1[4]);
  		    	studentEntranceRank.setText("100"); // 接口缺失的数据：入学排名
  		    	studentIdNumber.setText(data1[1]);
  		    	studentAge.setText(data1[2]);
  		    	studentGender.setText(data1[3]);
  		    	studentName.setText(data1[0]);
  			}else {
  				emptyWarning3.setText("请输入正确的学生id！");
  			}
  			
  		}
  		
  		//查看任课班级
  		public void showClassTeaching() {
  			clearClientParameter();
  			
  			loginData.add(id.getId());
  			loginData.add(id.getPassword());
  			listInput.add("51"); //最终应该放的是id.getId()
  			btnCode = 12;
  			
  			client(btnCode,listInput,loginData);

  			
  			ObservableList<ClassTeaching> classList = FXCollections.observableArrayList();
  			for (int i = 0; i < data1.length; i++) {
  				classList.add(new ClassTeaching(data1[i]));
  			}
  			
  			colClassName.setCellValueFactory(new PropertyValueFactory<ClassTeaching, String>("className"));
  			tvClassTeaching.setItems(classList);
  		}
  		
  		//查看班级学生名单
  	    private void showClassStudent() {
  	    	clearClientParameter();
  	    	loginData.add(id.getId());
  	    	loginData.add(id.getPassword());
  	    	listInput.add("51");
  	    	btnCode = 13;
  	    	client(btnCode, listInput, loginData);

  	    	ObservableList<ClassStudent> classStudentList = FXCollections.observableArrayList();
  			for (int i = 0; i < data1.length; i++) {
  				classStudentList.add(new ClassStudent(data1[i]));
  			}
  			
  			colClassStudent.setCellValueFactory(new PropertyValueFactory<ClassStudent, String>("studentName"));
  			tvClassStudent.setItems(classStudentList);
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
  					ArrayList<String> object = (ArrayList<String>) ois.readObject();
  					System.out.println(object);
  					data1 = new String[object.size()];
  					for(int i=0;i<object.size();i++) {
  						data1[i] = object.get(i).toString();
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
