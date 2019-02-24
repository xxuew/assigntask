package com.wx.assigntask.tools;

/**
 * @Author: wx
 * @Date: 2019/1/8 7:37
 * @Version 1.0
 */

import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 要用java调用mysql的命令 实现sql脚本的引入
 *
 * 一般分三步
 *
 *    1,运行到cmd 进入mysql命令，
 *
 *    2，选择数据库，
 *
 *    3，执行source语句 ，source + 路径，
 */
public class WriteSql {
//    @Autowired
//    SqlSessionFactory sqlSessionFactory;
//    @Value("${spring.datasource.driver-class-name}")
//    String className;
//    @Value("${spring.datasource.url}")
//    String dbUrl;
//    @Value("${spring.datasource.username}")
//    String dbUsername ;
//    @Value("${spring.datasource.password}")
//    String dbPassword;
    public void WriteSqlFile(File file){

////            Runtime runtime = Runtime.getRuntime();
////            String cmdarray[] = { "mysql -uroot -p123456", "use test","source F:\\IDEAProjects\\assigntask\\src\\main\\resources\\static\\uploadsqlfiles\\recommand.sql" };
////            Process process;
////            try {
////                process = runtime.exec("cmd /c " + cmdarray[0]);// cmd之后执行数组的第一个条件进入数据库
////                // 执行了第一条命令以后已经登录到mysql了
////                OutputStream os = process.getOutputStream();
////                OutputStreamWriter writer = new OutputStreamWriter(os);
////                writer.write(cmdarray[1]+"\r\n"+cmdarray[2]);//向图形界面输出第二第三条命令。中间 \r\n  作用是用来换行的
////                writer.flush();
////                writer.close();
////                os.close();
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
//            try {
//                SqlSession sqlSession = sqlSessionFactory.openSession();
//                Connection conn = sqlSession.getConnection();
//
//                String sqlPath = "F:\\IDEAProjects\\assigntask\\src\\main\\resources\\static\\uploadsqlfiles\\.sql";
//                FileSystemResource rc = new FileSystemResource(sqlPath);
//                EncodedResource er = new EncodedResource(rc, "GBK");
//                ScriptUtils.executeSqlScript(conn, er);
//            } catch (Exception e) {
//                e.printStackTrace();
//                throw e;
//            }


        try {

            String className = "com.mysql.cj.jdbc.Driver";
            String dbUrl = "jdbc:mysql://localhost:3306/assigntask?allowMultiQueries=true&useSSL=false";
            String dbUsername = "root";
            String dbPassword = "123456";

            Class.forName(className);
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            ScriptRunner runner = new ScriptRunner(conn);
            runner.setAutoCommit(true);

            try {
                if (file.getName().endsWith(".sql")) {
                    runner.setFullLineDelimiter(false);
                    runner.setDelimiter(";");//语句结束符号设置
                    runner.setLogWriter(null);//日志数据输出，这样就不会输出过程
                    runner.setSendFullScript(false);
                    runner.setAutoCommit(true);
                    runner.setStopOnError(true);
                    runner.runScript(new InputStreamReader(new FileInputStream(file), "utf8"));
                  //  logger.info(String.format("【%s】回滚成功", tableName));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }

    }
}

