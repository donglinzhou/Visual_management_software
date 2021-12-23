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
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.ClassStudent;
import model.ClassTeaching;
import model.LoginId;
import model.StudentList;
import model.TeacherList;

public class ManagerController implements Initializable {

	//登录界面传递id的变量
	public static LoginId id = new LoginId();
	
	@FXML
    private Button classStudentBtn;
    @FXML
    private Label headTxt;
    @FXML
    private MenuItem studentAttendanceBtn;
    @FXML
    private Button teacherInfoBtn;
    @FXML
    private MenuItem studentInfoBtn;
    @FXML
    private Button classAttendanceBtn;
    @FXML
    private Button statisticsGradeScoreBtn;
    @FXML
    private MenuItem studentGrowingBtn;
    @FXML
    private Button statisticeClassScoreBtn;
    @FXML
    private MenuItem studentScoreBtn;
    @FXML
    private Button logOut;
    
    //记录所有被选择的文本
    private String itemSelect;
    
    //学生成长档案
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
    private TextField studentGrowingIdInput;
    @FXML
    private Label emptyWarning1;

    //学生考勤记录
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
    private BarChart<String, Integer> studentAttendanceAbsence;
    @FXML
    private CategoryAxis studentAttendanceLineXType;
    @FXML
    private Label emptyWarning2;
    
    //学生学业画像
    @FXML
    private LineChart<String, Number> studentGradeOptionalSubjects;
    @FXML
    private LineChart<String, Number> studentGradeRequiredSubjects;
    @FXML
    private TextField studentScoreIdInput;
    @FXML
    private MenuButton studentScoreTimesConfirm;
    @FXML
    private MenuItem studentGradeNearestThreeTimes;
    @FXML
    private MenuItem studentGradeNearestFiveTimes;
    @FXML
    private MenuItem studentGradeNearestTenTimes;
    @FXML
    private Label emptyWarning4;
    
    //查看班级学生名单
    @FXML
    private TableColumn<ClassStudent, String> colStudentName;
    @FXML
    private TableView<ClassStudent> tvClassStudent;
    @FXML
    private TextField classStudentIdInput;
    @FXML
    private Label emptyWarning3;
    
    //查看总体最近考勤特有的变量
    private String startY = "0";
    private String startM = "0";
    private String startD = "0";
    private String endY = "0";
    private String endM = "0";
    private String endD = "0";
    
    @FXML
    private Label warning11;
    @FXML
    private PieChart absenceTypes; //饼图
    @FXML
    private BarChart<String, Number> absenceNumberClass; //条形图
    @FXML
    private CategoryAxis lineXAxisClassId;
    @FXML
    private NumberAxis lineYAxisNumber;
    @FXML
    private MenuButton classAttendanceStartY;
    @FXML
    private MenuButton classAttendanceStartM;
    @FXML
    private MenuButton classAttendanceStartD;
    @FXML
    private MenuButton classAttendanceEndY;
    @FXML
    private MenuButton classAttendanceEndM;
    @FXML
    private MenuButton classAttendanceEndD;
    
    
    //年级学业
    private String subjectNumber1 = "0";
    @FXML
    private Label emptyWarning5;
    @FXML
    private LineChart<String, Number> gradeScore;
    @FXML
    private MenuButton statisticsGradeScoreTimesConfirm;
    @FXML
    private MenuButton statisticsGradeScoreSubjectConfirm;
    @FXML
    private MenuItem statisticsGradeScoreChineseBtn;
    @FXML
    private MenuItem statisticsGradeScorePhysicsBtn;
    @FXML
    private MenuItem statisticsGradeScoreEnglishBtn;
    @FXML
    private MenuItem statisticsGradeScoreBiologyBtn;
    @FXML
    private MenuItem statisticsGradeScorePoliticsBtn;
    @FXML
    private MenuItem statisticsGradeScoreMathBtn;
    @FXML
    private MenuItem statisticsGradeScoreChemistryBtn;
    @FXML
    private MenuItem statisticsGradeScoreHistoryBtn;
    @FXML
    private MenuItem statisticsGradeScoreGeographyBtn;
    @FXML
    private MenuItem gradeLastThreeTimesBtn;
    @FXML
    private MenuItem gradeLastFiveTimesBtn;
    @FXML
    private MenuItem gradeLastTenTimesBtn;
    
    //班级学业
    private String subjectNumber2 = "0";
    @FXML
    private Label emptyWarning6;
    @FXML
    private TextField statisticsClassScoreIdInput;
    @FXML
    private MenuButton statisticsClassScoreSubjectConfirm;
    @FXML
    private MenuButton statisticsClassScoreTimesConfirm;
    @FXML
    private MenuItem classLastThreeTimesBtn;
    @FXML
    private MenuItem classLastFiveTimesBtn;
    @FXML
    private MenuItem classLastTenTimesBtn;
    @FXML
    private LineChart<String, Number> classScore;
    

    //学生基本信息
    @FXML
    private Label emptyWarning7;
    @FXML
    private Label emptyWarning8;
    @FXML
    private TextField studentInfoIdInput;
    @FXML
    private TableView<StudentList> tvStudentList;
    @FXML
    private TableColumn<StudentList, String> studentInfoColAge;
    @FXML
    private TableColumn<StudentList, String> studentInfoColEnrollmentY;
    @FXML
    private TableColumn<StudentList, String> studentInfoColPolitics;
    @FXML
    private TableColumn<StudentList, String> studentInfoColHeadTeacher;
    @FXML
    private TableColumn<StudentList, String> studentInfoColName;
    @FXML
    private TableColumn<StudentList, String> studentInfoColGender;
    @FXML
    private TableColumn<StudentList, String> studentInfoColId;
    @FXML
    private TextField studentInfoTfId;
    @FXML
    private TextField studentInfoTfPolitics;
    @FXML
    private TextField studentInfoTfRanking;
    @FXML
    private TextField studentInfoTfDormitory;
    @FXML
    private TextField studentInfoTfFamilyT;
    @FXML
    private TextField studentInfoTfDropOut;
    @FXML
    private TextField studentInfoTfNation;
    @FXML
    private TextField studentInfoTfGender;
    @FXML
    private TextField studentInfoTfBirth;
    @FXML
    private TextField studentInfoTfEnrollmentY;
    @FXML
    private TextField studentInfoTfName;
    @FXML
    private TextField studentInfoTfHomeA;


    
    //教师基本信息
    @FXML
    private Label emptyWarning9;
    @FXML
    private Label emptyWarning10;
    @FXML
    private TableView<TeacherList> tvTeacherList;
    @FXML
    private TableColumn<TeacherList, String> teacherInfoColName;
    @FXML
    private TableColumn<TeacherList, String> teacherInfoColGender;
    @FXML
    private TableColumn<TeacherList, String> teacherInfoColNation;
    @FXML
    private TableColumn<TeacherList, String> teacherInfoColEducation;
    @FXML
    private TableColumn<TeacherList, String> teacherInfoColPhone;
    @FXML
    private TableColumn<TeacherList, String> teacherInfoColAge;
    @FXML
    private TableColumn<TeacherList, String> teacherInfoColPolitics;
    @FXML
    private TextField teacherInfoTfName;
    @FXML
    private TextField teacherInfoTfPolitics;
    @FXML
    private TextField teacherInfoTfBirth;
    @FXML
    private TextField teacherInfoTfId;
    @FXML
    private TextField teacherInfoTfEducation;
    @FXML
    private TextField teacherInfoTfNation;
    @FXML
    private TextField teacherInfoTfPhone;
    @FXML
    private TextField teacherInfoTfEmail;
    @FXML
    private TextField teacherInfoTfGender;
    @FXML
    private TextField teacherInfoIdInput;
    
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
    
    //查看学生信息列表
    @FXML
    void studentInfoBtnClick(ActionEvent event) {
    	System.out.println("学生个人基本信息");
    	
		Stage selectStage = (Stage) headTxt.getScene().getWindow();
		
		try {	
			Pane infoPane = FXMLLoader.load(getClass().getResource("/view/managerStudentInfo.fxml"));
			
			Scene infoScene = new Scene(infoPane);
			selectStage.setScene(infoScene);
			selectStage.setTitle("教务端");
			selectStage.show();	
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void studentAttendanceBtnClick(ActionEvent event) {
    	System.out.println("学生个人考勤记录");
    	
		Stage selectStage = (Stage) headTxt.getScene().getWindow();
		
		try {	
			Pane infoPane = FXMLLoader.load(getClass().getResource("/view/managerStudentAttendance.fxml"));
			Scene infoScene = new Scene(infoPane);
			selectStage.setScene(infoScene);
			selectStage.setTitle("教务端");
			selectStage.show();	
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void studentGrowingBtnClick(ActionEvent event) {
    	System.out.println("学生个人成长档案");
    	
		Stage selectStage = (Stage) headTxt.getScene().getWindow();
		
		try {	
			Pane infoPane = FXMLLoader.load(getClass().getResource("/view/managerStudentGrowing.fxml"));
			Scene infoScene = new Scene(infoPane);
			selectStage.setScene(infoScene);
			selectStage.setTitle("教务端");
			selectStage.show();	
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void studentScoreBtnClick(ActionEvent event) {
    	System.out.println("学生个人学业画像");
    	
		Stage selectStage = (Stage) headTxt.getScene().getWindow();
		
		try {	
			Pane infoPane = FXMLLoader.load(getClass().getResource("/view/managerStudentScore.fxml"));
			Scene infoScene = new Scene(infoPane);
			selectStage.setScene(infoScene);
			selectStage.setTitle("教务端");
			selectStage.show();	
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    //查看教师信息列表
    @FXML
    void teacherInfoBtnClick(ActionEvent event) {
    	System.out.println("教师基本信息");
    	
		Stage selectStage = (Stage) headTxt.getScene().getWindow();
		
		try {	
			Pane infoPane = FXMLLoader.load(getClass().getResource("/view/managerTeacherInfo.fxml"));
			
			Scene infoScene = new Scene(infoPane);
			selectStage.setScene(infoScene);
			selectStage.setTitle("教务端");
			selectStage.show();	
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    //班级学生名单
    @FXML
    void classStudentBtnClick(ActionEvent event) {
    	System.out.println("班级学生名单");
    	
		Stage selectStage = (Stage) headTxt.getScene().getWindow();
		
		try {	
			Pane infoPane = FXMLLoader.load(getClass().getResource("/view/managerClassStudent.fxml"));
			
			Scene infoScene = new Scene(infoPane);
			selectStage.setScene(infoScene);
			selectStage.setTitle("教务端");
			selectStage.show();	
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void classAttendanceBtnClick(ActionEvent event) {
    	System.out.println("学生总考勤情况");
    	
		Stage selectStage = (Stage) headTxt.getScene().getWindow();
		
		try {	
			Pane infoPane = FXMLLoader.load(getClass().getResource("/view/managerClassAttendance.fxml"));
			Scene infoScene = new Scene(infoPane);
			selectStage.setScene(infoScene);
			selectStage.setTitle("教务端");
			selectStage.show();	
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void statisticsGradeScoreBtnClick(ActionEvent event) {
    	System.out.println("年级学业统计");
    	
		Stage selectStage = (Stage) headTxt.getScene().getWindow();
		
		try {	
			Pane infoPane = FXMLLoader.load(getClass().getResource("/view/managerStatisticsGradeScore.fxml"));
			Scene infoScene = new Scene(infoPane);
			selectStage.setScene(infoScene);
			selectStage.setTitle("教务端");
			selectStage.show();	
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void statisticsClassScoreBtnClick(ActionEvent event) {
    	System.out.println("班级学业统计");
    	
		Stage selectStage = (Stage) headTxt.getScene().getWindow();
		
		try {	
			Pane infoPane = FXMLLoader.load(getClass().getResource("/view/managerStatisticsClassScore.fxml"));
			Scene infoScene = new Scene(infoPane);
			selectStage.setScene(infoScene);
			selectStage.setTitle("教务端");
			selectStage.show();	
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    //不知道怎么根据MenuItem获取MenuButton，所以代码有点点ugly
    //学生总体考勤开始时间终止时间预记录
    @FXML
    void classAttendanceStartYClick(ActionEvent event) {

	    classAttendanceStartY.setText(((MenuItem)event.getTarget()).getText());
    }
    @FXML
    void classAttendanceStartMClick(ActionEvent event) {
    	
    	classAttendanceStartM.setText(((MenuItem)event.getTarget()).getText());
    }
    @FXML
    void classAttendanceStartDClick(ActionEvent event) {

    	classAttendanceStartD.setText(((MenuItem)event.getTarget()).getText());
    }
    @FXML
    void classAttendanceEndYClick(ActionEvent event) {

    	classAttendanceEndY.setText(((MenuItem)event.getTarget()).getText());
    }
    @FXML
    void classAttendanceEndMClick(ActionEvent event) {

    	classAttendanceEndM.setText(((MenuItem)event.getTarget()).getText());
    }
    @FXML
    void classAttendanceEndDClick(ActionEvent event) {

    	classAttendanceEndD.setText(((MenuItem)event.getTarget()).getText());
    }
    
    //学生考勤————每种类型、每个班
    @FXML
    void overallAttendanceClick(ActionEvent event) {

		System.out.println("班级最近考勤情况——饼图和条形图");
	    //把时间段组合出来，验证时间段是否符合格式要求
	    startY = classAttendanceStartY.getText();
	    startM = classAttendanceStartM.getText();
	    startD = classAttendanceStartD.getText();
	    endY = classAttendanceEndY.getText();
	    endM = classAttendanceEndM.getText();
	    endD = classAttendanceEndD.getText();
	    if(Integer.parseInt(startY)>Integer.parseInt(endY)) {//起始年份比终止年份大
	    	warning11.setText("时间段输入格式错误，请重新选择时间段！");
	    }else if((startY.equals(endY))&&(Integer.parseInt(startM)>Integer.parseInt(endM))) {
	    	warning11.setText("时间段输入格式错误，请重新选择时间段！");
	    }else if((startY.equals(endY))&&(startM.equals(endM))&&(Integer.parseInt(startD)>Integer.parseInt(endD))) {
	    	warning11.setText("时间段输入格式错误，请重新选择时间段！");
	    }else {
	    	clearClientParameter();
			loginData.add(id.getId());
			loginData.add(id.getPassword());
			listInput.add(startY + "-" + startM + "-" + startD);
			listInput.add(endY + "-" + endM + "-" + endD);
			
			btnCode = 22;
			client(btnCode,listInput,loginData);
			overallAttendancePieChart();
			
			btnCode = 23;
			client(btnCode,listInput,loginData);
			overallAttendanceBarChart();
	    }
		
    }
    
    
	//学生考勤————每种类型缺勤多少人————饼图
	public void overallAttendancePieChart() {
		System.out.println("班级最近十次考勤情况——饼图");
		ObservableList<Data> answer = FXCollections.observableArrayList();
		
		for (int i = 0; i < data2.length; i++) {
			answer.addAll(new PieChart.Data(data2[i][0], Double.parseDouble(data2[i][1])));
		}
		
        absenceTypes.setData(answer);
	}
	
	//学生考勤————每个班缺勤多少人————条形图
		public void overallAttendanceBarChart() {
			System.out.println("班级最近十次考勤情况——条形图");
			lineXAxisClassId.setTickLabelRotation(90);
			
			XYChart.Series<String, Number> series = new XYChart.Series<>(); 
			series.setName("各班缺勤人数"); 
			for (int i = 0; i < data2.length; i++) {
				series.getData().add(new XYChart.Data<>(data2[i][0], Double.parseDouble(data2[i][1])));
			}
			absenceNumberClass.getData().add(series);
			
		}
		//学生成长档案————折线图
		@FXML
	    void studentGrowingClick(ActionEvent event) {
			System.out.println("学生成长档案——折线图");
				studentGrowingTimesConfirm.setText(((MenuItem) event.getTarget()).getText());
			// TODO Auto-generated method stub
			if(!studentGrowingIdInput.getText().equals("")) {
				emptyWarning1.setText("");
				clearClientParameter();
				loginData.add(id.getId());
				loginData.add(id.getPassword());
				listInput.add(studentGrowingIdInput.getText());
				btnCode = 16;
				
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
				emptyWarning1.setText("请输入正确的学生id！");
			}
			
		}


		//学生考勤记录————柱形图
		@FXML
	    void studentAttendanceClick(ActionEvent event) {
			System.out.println("考勤记录");
			studentAttendanceMonthConfirm.setText(((MenuItem) event.getTarget()).getText());
			if(!studentAttendanceIdInput.getText().equals("")) {
				emptyWarning2.setText("");
				clearClientParameter();
				loginData.add(id.getId());
				loginData.add(id.getPassword());
				listInput.add(studentAttendanceIdInput.getText());
				btnCode = 15;
				
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
	  				studentAbsenceNearestThreeMonthBtn.setDisable(false);
	  				studentAbsenceNearestOneMonthBtn.setDisable(false);
	  			}
	  			client(btnCode,listInput,loginData);
	  			
				XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
				
				series.setName("缺勤次数"); 
				String[] types = {"迟到", "进校", "课间操请假", "离校", "默认信息", "请假离校", "晚到学校",
						"晚自修迟到", "校服", "校徽校服", "早上迟到", "早退", "住宿早晨锻炼"};
				
				for (int i = 0; i < data1.length; i++) {
					series.getData().add(new XYChart.Data<String, Integer>(types[i], Integer.parseInt(data1[i])));
				}
				studentAttendanceAbsence.getData().add(series);
			}else {
				emptyWarning2.setText("请输入正确的学生id！");
			}
			
		}
		//学生学业画像（每一科）————折线图
		@FXML
	    void studentScoreClick(ActionEvent event) {
			System.out.println("学生学业画像——多道折线图");
				studentScoreTimesConfirm.setText(((MenuItem) event.getTarget()).getText());
			if(!studentScoreIdInput.getText().equals("")) {
				emptyWarning4.setText("");
				clearClientParameter();
				loginData.add(id.getId());
				loginData.add(id.getPassword());
				listInput.add(studentScoreIdInput.getText());
				btnCode = 17;
				
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
		
		//年级学业画像（班级学业画像）————选择学科
		@FXML
	    void statisticsGradeScoreSubjectClick(ActionEvent event) {
			statisticsGradeScoreSubjectConfirm.setText(((MenuItem) event.getTarget()).getText());
			MenuItem item = (MenuItem) event.getTarget();
			itemSelect = item.getText();
  			if(itemSelect.equals("语文")) {
  				subjectNumber1 = "1";
  				
  			}else if(itemSelect.equals("数学")) {
  				subjectNumber1 = "2";
  				
  			}else if(itemSelect.equals("英语")) {
  				subjectNumber1 = "3";
  				
  			}else if(itemSelect.equals("物理")) {
  				subjectNumber1 = "4";
  				
  			}else if(itemSelect.equals("化学")) {
  				subjectNumber1 = "5";
  				
  			}else if(itemSelect.equals("生物")) {
  				subjectNumber1 = "6";
  				
  			}else if(itemSelect.equals("历史")) {
  				subjectNumber1 = "7";
  				
  			}else if(itemSelect.equals("地理")) {
  				subjectNumber1 = "8";
  				
  			}else {
  				subjectNumber1 = "17";
  			}
	    }
		
		//年级学业画像（班级学业画像）————选择学科
		@FXML
	    void statisticsClassScoreSubjectClick(ActionEvent event) {
			statisticsClassScoreSubjectConfirm.setText(((MenuItem) event.getTarget()).getText());
			MenuItem item = (MenuItem) event.getTarget();
			itemSelect = item.getText();
  			if(itemSelect.equals("语文")) {
  				subjectNumber2 = "1";
  				
  			}else if(itemSelect.equals("数学")) {
  				subjectNumber2 = "2";
  				
  			}else if(itemSelect.equals("英语")) {
  				subjectNumber2 = "3";
  				
  			}else if(itemSelect.equals("物理")) {
  				subjectNumber2 = "4";
  				
  			}else if(itemSelect.equals("化学")) {
  				subjectNumber2 = "5";
  				
  			}else if(itemSelect.equals("生物")) {
  				subjectNumber2 = "6";
  				
  			}else if(itemSelect.equals("历史")) {
  				subjectNumber2 = "7";
  				
  			}else if(itemSelect.equals("地理")) {
  				subjectNumber2 = "8";
  				
  			}else {
  				subjectNumber2 = "17";
  			}
	    }		
		
		//年级学业画像（每一科）————折线图
		@FXML
	    void gradeScoreClick(ActionEvent event) {
			System.out.println("学生学业画像——多道折线图");
				statisticsGradeScoreTimesConfirm.setText(((MenuItem) event.getTarget()).getText());

			if(!subjectNumber1.equals("0")) {
				emptyWarning5.setText("");
				clearClientParameter();
				loginData.add(id.getId());
				loginData.add(id.getPassword());
				listInput.add(subjectNumber1);
				btnCode = 24;
				
				MenuItem item = (MenuItem) event.getTarget();
				itemSelect = item.getText();
	  			if(itemSelect.equals("最近3次")) {
	  				listInput.add("3");
	  				gradeLastThreeTimesBtn.setDisable(true);
	  				gradeLastFiveTimesBtn.setDisable(false);
	  				gradeLastTenTimesBtn.setDisable(false);
	  				
	  			}else if(itemSelect.equals("最近5次")) {
	  				listInput.add("5");
	  				gradeLastFiveTimesBtn.setDisable(true);
	  				gradeLastThreeTimesBtn.setDisable(false);
	  				gradeLastTenTimesBtn.setDisable(false);
	  		
	  			}else if(itemSelect.equals("最近10次")) {
	  				listInput.add("10");
	  				gradeLastTenTimesBtn.setDisable(true);
	  				gradeLastThreeTimesBtn.setDisable(false);
	  				gradeLastFiveTimesBtn.setDisable(false);
	  			}
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
				gradeScore.setData(series1);
	  			
			}else {
				emptyWarning5.setText("请先选择要查询的学科再对时间段进行选择！");
			}
			
			
		}
			
		//班级学业画像（每一科）————折线图
		@FXML
	    void classScoreClick(ActionEvent event) {
			System.out.println("班级学业画像——多道折线图");
				statisticsClassScoreTimesConfirm.setText(((MenuItem) event.getTarget()).getText());
			
			if(statisticsClassScoreIdInput.getText().equals("")) {
				emptyWarning6.setText("请先输入班级ID！");
			}else if(subjectNumber2.equals("0")) {
				emptyWarning6.setText("请先选择需要查询的学科！");
			}else {
				emptyWarning6.setText("");
				clearClientParameter();
				loginData.add(id.getId());
				loginData.add(id.getPassword());
				listInput.add(statisticsClassScoreIdInput.getText());
				listInput.add(subjectNumber2);
				btnCode = 25;
				
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
	  		
	  			}else if(itemSelect.equals("最近10次")) {
	  				listInput.add("10");
	  				classLastTenTimesBtn.setDisable(true);
	  				classLastThreeTimesBtn.setDisable(false);
	  				classLastFiveTimesBtn.setDisable(false);
	  			}
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
		
		//输出班级学生名单
		@FXML
	    void showClassStudent(ActionEvent event) {
  	    	
			if(!classStudentIdInput.getText().equals("")) {
				emptyWarning3.setText("");
				clearClientParameter();
	  			
	  			loginData.add(id.getId());
	  			loginData.add(id.getPassword());
	  			listInput.add(classStudentIdInput.getText()); //最终应该放的是id.getId()
	  			btnCode = 19;
	  			
	  			client(btnCode,listInput,loginData);

	  			ObservableList<ClassStudent> classStudentList = FXCollections.observableArrayList();
	  			for (int i = 0; i < data1.length; i++) {
	  				classStudentList.add(new ClassStudent(data1[i]));
	  			}
	  			
	  			colStudentName.setCellValueFactory(new PropertyValueFactory<ClassStudent, String>("studentName"));
	  			tvClassStudent.setItems(classStudentList);
			}else {
				emptyWarning3.setText("请输入正确的班级id!");
			}
  	    	
  	    	
  			
  		}

  	    //录入学生基本信息之 查看学生
		@FXML
	    void studentInfoClick(ActionEvent event) {
			
  	    	if(!studentInfoIdInput.getText().equals("")) {
				emptyWarning7.setText("");
				clearClientParameter();
	  			
	  			loginData.add(id.getId());
	  			loginData.add(id.getPassword());
	  			listInput.add(studentInfoIdInput.getText()); 
	  			btnCode = 14;
	  			
	  			client(btnCode,listInput,loginData);

	  			ObservableList<StudentList> studentList = FXCollections.observableArrayList();
	  			for (int i = 0; i < 1; i++) {
	  				studentList.add(new StudentList(data1[0], data1[1], data1[2], data1[3], data1[4], data1[5], data1[6]));
	  			}
	  			
	  			studentInfoColName.setCellValueFactory(new PropertyValueFactory<StudentList, String>("name"));
	  			studentInfoColId.setCellValueFactory(new PropertyValueFactory<StudentList, String>("id"));
	  			studentInfoColAge.setCellValueFactory(new PropertyValueFactory<StudentList, String>("age"));
	  			studentInfoColGender.setCellValueFactory(new PropertyValueFactory<StudentList, String>("gender"));
	  			studentInfoColEnrollmentY.setCellValueFactory(new PropertyValueFactory<StudentList, String>("enrollmentY"));
	  			studentInfoColPolitics.setCellValueFactory(new PropertyValueFactory<StudentList, String>("politics"));
	  			studentInfoColHeadTeacher.setCellValueFactory(new PropertyValueFactory<StudentList, String>("headTeacher"));
	  			tvStudentList.setItems(studentList);
			}else {
				emptyWarning7.setText("请输入正确的学生id!");
			}
  			
  		}
  	    
  	    //录入学生信息之 添加学生
  	  @FXML
      void studentInfoAddClick(ActionEvent event) {

  		emptyWarning8.setText("");
		clearClientParameter();
			
		loginData.add(id.getId());
		loginData.add(id.getPassword());
		listInput.add(studentInfoTfId.getText()); 
		listInput.add(studentInfoTfName.getText()); 
		listInput.add(studentInfoTfGender.getText()); 
		listInput.add(studentInfoTfNation.getText()); 
		listInput.add(studentInfoTfEnrollmentY.getText()); 
		listInput.add(studentInfoTfBirth.getText()); 
		listInput.add(studentInfoTfHomeA.getText()); 
		listInput.add(studentInfoTfFamilyT.getText()); 
		listInput.add(studentInfoTfPolitics.getText()); 
		listInput.add(studentInfoTfRanking.getText()); 
		listInput.add(studentInfoTfDormitory.getText()); 
		listInput.add(studentInfoTfDropOut.getText()); 
		btnCode = 20;
			
		client(btnCode,listInput,loginData);
  		emptyWarning8.setText(data1[0]);
  		  
      }
  	    
  	//录入教师信息之 查看教师基本信息
  	  @FXML
  	  void teacherInfoClick(ActionEvent event) {
			
	    	if(!teacherInfoIdInput.getText().equals("")) {
	    		emptyWarning10.setText("");
				clearClientParameter();
	  			
	  			loginData.add(id.getId());
	  			loginData.add(id.getPassword());
	  			listInput.add(teacherInfoIdInput.getText()); //最终应该放的是id.getId()
	  			btnCode = 18;
	  			
	  			client(btnCode,listInput,loginData);

	  			ObservableList<TeacherList> teacherList = FXCollections.observableArrayList();
	  			for (int i = 0; i < 1; i++) {
	  				teacherList.add(new TeacherList(data1[0], data1[1], data1[2], data1[3], data1[4], data1[5], data1[6]));
	  			}
	  			
	  			teacherInfoColName.setCellValueFactory(new PropertyValueFactory<TeacherList, String>("name"));
	  			teacherInfoColAge.setCellValueFactory(new PropertyValueFactory<TeacherList, String>("age"));
	  			teacherInfoColGender.setCellValueFactory(new PropertyValueFactory<TeacherList, String>("gender"));
	  			teacherInfoColNation.setCellValueFactory(new PropertyValueFactory<TeacherList, String>("nation"));
	  			teacherInfoColPolitics.setCellValueFactory(new PropertyValueFactory<TeacherList, String>("politics"));
	  			teacherInfoColEducation.setCellValueFactory(new PropertyValueFactory<TeacherList, String>("education"));
	  			teacherInfoColPhone.setCellValueFactory(new PropertyValueFactory<TeacherList, String>("phone"));
	  			tvTeacherList.setItems(teacherList);
			}else {
				emptyWarning10.setText("请输入正确的教师id!");
			}
	    	
		}
	    
	  //录入教师信息之 添加教师
	  	  @FXML
	      void teacherInfoAddClick(ActionEvent event) {

	  		emptyWarning9.setText("");
			clearClientParameter();
				
			loginData.add(id.getId());
			loginData.add(id.getPassword());
			listInput.add(teacherInfoTfId.getText()); 
			listInput.add(teacherInfoTfName.getText()); 
			listInput.add(teacherInfoTfGender.getText()); 
			listInput.add(teacherInfoTfNation.getText()); 
			listInput.add(teacherInfoTfPolitics.getText()); 
			listInput.add(teacherInfoTfEducation.getText()); 
			listInput.add(teacherInfoTfBirth.getText()); 
			listInput.add(teacherInfoTfPhone.getText()); 
			listInput.add(teacherInfoTfEmail.getText());
			btnCode = 21;
				
			client(btnCode,listInput,loginData);
	  		emptyWarning9.setText(data1[0]);
	  		  
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
  					data1 = new String[object.size()];
  					for(int i=0;i<object.size();i++) {
  						data1[i] = object.get(i).toString();
  					}
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
  					data1 = new String[object.size()];
  					for(int i=0;i<object.size();i++) {
  						data1[i] = object.get(i).toString();
  					}
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
