package model;

import java.sql.*;
import java.util.ArrayList;
 
/**
 * 
 * 数据库控制类
 * 化简数据库的操作
 * 
 * **步骤总结**
 * 1、加载驱动
 * 2、连接数据库 DriverManager
 * 3、获取执行SQL的对象 Statement
 * 4、获得返回的结果集 ResultSet
 * 5、释放连接
 * 
 */
public class DatabaseModel {
    //1、加载驱动
    private final static String driver = "com.mysql.jdbc.Driver";
    
    //2.用户信息和url
    private String url = "jdbc:mysql://localhost:3306/wechat?useUnicode=true&characterEncoding=utf-8";
    //mysql 默认端口3306
    //协议 ：// 主机地址 ： 端口号 / 数据库名 ？ 参数1 & 参数2 & 参数3
    private String userName = "root";
    private String password = "123456";
    
    //3、连接成功，数据库对象 Connection 代表数据库
    private Connection connection;
    //connection = DriverManager.getConnection(url, userName, password);
    
    //4、执行sql的对象
    private Statement statement;//静态查询
    private PreparedStatement preparedStatement;//动态查询
    
    public DatabaseModel() {
 
    }
    
    /*
    链接数据库
     */
    public void connect(){
        try {
            Class.forName(driver); //固定写法，加载驱动
            connection = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    /**	查询
     *
     * 该方法用来执行Sql语句并返回结果集 适合需要返回结果集的查询语句 
     * 例如   execResult("select*from user where id = ? and name = ?","1","jack");
     * 用问号占位 然后传入个String数组代表对应问号的值 该方法返回个结果集 即 ResultSet
     *
     * @param Sql: String
     * @param data: ArrayList<String>
     * @return ResultSet
     * @throws SQLException
     * 
     */
    public ResultSet execResult(String Sql, ArrayList<String> data) throws SQLException {
        preparedStatement = connection.prepareStatement(Sql);
        for (int i = 1; i <= data.size(); i++) {
            preparedStatement.setString(i, data.get(i-1));
        }
        return preparedStatement.executeQuery(); //查询操作，返回ResultSet
    }
 
    /**	增 删 改
     *
     * 执行Sql语句 不返回任何东西 
     * 例如exec("update user set password = ? where account = ?","password","name");
     * exec("delete from user where name = ? and account = ?","name","account");
     * exec("insert into user values(?,?,?,?,?,?,?,?,?)",1,2,3,4,5,6,7,8,9);
     * @param Sql: String
     * @param data: ArrayList<String>
     * @throws SQLException
     * 
     */
    public void exec(String Sql, ArrayList<String> data) throws SQLException {
 
        preparedStatement = connection.prepareStatement(Sql);
        for (int i = 1; i <= data.size(); i++) {
            preparedStatement.setString(i, data.get(i-1));
        }
        preparedStatement.executeUpdate();
       //插入、删除、更新，都用executeUpdate()
    }
 
    
    /**
     * 执行静态SQL语句  
     * 例如exec("delete from user");
     * @param Sql：String
     */
    public void exec(String Sql) {
        try
        {
            preparedStatement = connection.prepareStatement(Sql);
            preparedStatement.executeUpdate();
        }catch (Exception e){
        }
    }
    
    
    /**
     * 该方法插入元组  
     * 例如insert(表名,要插入的数据(String数组的形式))
     * Sql = "INSERT INTO " + tableName + " VALUES(" + pre + ")"
     *
     * @param tableName：String
     * @param data：ArrayList<String> 
     * @throws SQLException
     */
    public void insert(String tableName, ArrayList<String> data) throws SQLException {
 
        String pre = "";
        for (int i = 0; i < data.size(); i++) {
 
            if (i != data.size() - 1)
                pre += "?,";
            else
                pre += "?";
 
        }
 
        String Sql = "INSERT INTO " + tableName + " VALUES(" + pre + ")";
        preparedStatement = connection.prepareStatement(Sql);
        for (int i = 1; i <= data.size(); i++) {
 
            preparedStatement.setString(i, data.get(i-1));
 
        }
        preparedStatement.executeUpdate();
 
    }
 
    
    /**
     * 该方法删除元组
     * "DELETE FROM " + tableName + " WHERE " + condition + "= ?";
     * 
     * @param tableName：String
     * @param condition：String
     * @param data：ArrayList<String>
     * @throws SQLException
     */
    public void delete(String tableName, String condition, ArrayList<String> data) throws SQLException {
 
 
        String Sql = "DELETE FROM " + tableName + " WHERE " + condition + "= ?";
 
 
        preparedStatement = connection.prepareStatement(Sql);
        for (int i = 1; i <= data.size(); i++) {
 
            preparedStatement.setString(i, data.get(i-1));
 
        }
        preparedStatement.executeUpdate();
 
    }
 
    
	/**
	 * 修改操作的设想，修改时前端整列数据（原数据）显示，修改后，照原样（表头格式）整列数据返回给后端，
	 * 即，没修改的数据也被一起返回 \\
	 * !!问题：UPDATE 学生六选三表 SET 主修学科ID=?, 次修学科ID1=?, 次修学科ID2=? WHERE 学生ID=? 
	 * 作为 检索条件的列 其对应值的位置需要前端参与（即返回的数组中 值的顺序 问题）
	 * 
	 * @param tableName：String
     * @param data：ArrayList<String> 
     * @throws SQLException
	 * */
    public void update(String Sql, ArrayList<String> data) throws SQLException {

//        String pre = "";
//        for (int i = 0; i < data.size(); i++) {
// 
//            if (i != data.size() - 1)
//                pre += "?,";
//            else
//                pre += "?";
// 
//        }
//    	
//        String Sql = "UPDATE " + tableName + " SET " + pre + " WHERE " + condition + "= ?";
        
        preparedStatement = connection.prepareStatement(Sql);
 
        for (int i = 1; i <= data.size(); i++) {
 
            preparedStatement.setString(i, data.get(i-1));
 
        }
        preparedStatement.executeUpdate();
 
    }
 
    /**
     * 动态查询数据  
     * 例如select(表名,查询条件(String数组的形式))
     * Sql = "SELECT" + targets + "FROM" + tables + " WHERE" + datas;
     *
     * @param tableName：String
     * @param data：ArrayList<String> 
     * @throws SQLException
     */
    public ResultSet select(ArrayList<String> tableName, ArrayList<String> target, ArrayList<String> data) throws SQLException {
 
        String tables = "", targets = "", datas = "";
        
        for (int i = 0; i < tableName.size(); i++) {
        	 
            if (i != tableName.size() - 1)
                tables += "?,";
            else
                tables += "?";
 
        }        
        
        for (int i = 0; i < target.size(); i++) {
 
            if (i != target.size() - 1)
            	targets += "?,";
            else
            	targets += "?";
 
        }
        for (int i = 0; i < data.size(); i++) {
 
            if (i != data.size() - 1)
                datas += "?,";
            else
                datas += "?";
 
        }
 
        String Sql = "SELECT" + targets + "FROM" + tables + " WHERE" + datas;
        
        preparedStatement = connection.prepareStatement(Sql);
        
        for (int i = 1; i <= target.size(); i++) {

            preparedStatement.setString(i, target.get(i-1));
 
        }
        
        for (int i = 1; i <= tableName.size(); i++) {

            preparedStatement.setString(i, tableName.get(i-1));
 
        }
        
        for (int i = 1; i <= data.size(); i++) {

            preparedStatement.setString(i, data.get(i-1));
 
        }
        
        return preparedStatement.executeQuery();
 
    }
    
    /**
     * 静态查询
     * 
     * @param Sql
     * @return
     * @throws SQLException
     */
    public ResultSet select(String Sql) throws SQLException {
 
        statement = connection.createStatement();
        return statement.executeQuery(Sql);
 
    }
 
    
    /**
     * 得到静态查询对象
     * @return
     */
    public Statement getStatement() {
        return statement;
    }
 
    
    /**
     * 得到动态查询对象
     * @return
     */
    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }
 
    
    /**
     * 得到数据库链接对象
     * @return
     */
    public Connection getConnection() {
        return connection;
    }
 
    
    /**
     * 数据库重连
     * @param Url
     * @param UserName
     * @param Password
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void reConnection(String Url, String UserName, String Password) throws ClassNotFoundException, SQLException {
 
        Class.forName(driver);
        connection = DriverManager.getConnection(Url, UserName, Password);
 
    }
    
}