package com.nju.assigntask.tools;

/**
 * @Author: wx
 * @Date: 2019/1/8 7:37
 * @Version 1.0
 */

import com.nju.assigntask.dao.tool.CheckTableMapper;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Map;

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
@Component
public class WriteSql {

    @Autowired
    CheckTableMapper checkTableMapper;
    @Autowired
    Constant constant;
    @Value("${spring.datasource.url}")
    public String dbUrl;
    @Value("${spring.datasource.driver-class-name}")
    public String className;
    @Value("${spring.datasource.username}")
    public String  dbUsername;
    @Value("${spring.datasource.password}")
    public String dbPassword;

    /**
     * 保存上传文件至:/项目路径/target/upload-files
     * @param fileUpload
     * @return
     */
    public boolean saveSqlFile(MultipartFile[] fileUpload) {
        //本地项目地址/target/clases
        String proPath = this.getClass().getClassLoader().getResource("").getPath();
        String filePath = proPath + "upload-files/";
        //获取文件名
        // List<String> fileNames = new ArrayList<>();
        for (int i = 0; i < fileUpload.length; i++) {
            String fileName = fileUpload[i].getOriginalFilename();//文件不能超过1M
            File file = new File(filePath + fileName);
            File fileParent = file.getParentFile();
            if (!fileParent.exists()) {
                fileParent.mkdirs();
            }
            try {
                //将文件保存到相应路径里
                fileUpload[i].transferTo(file);
                //写入数据库
                boolean writeStatus = WriteSqlFile(file);
                if (writeStatus == false){
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /**
     * 执行SQL脚本文件
     * @param file
     */
    public boolean WriteSqlFile(File file){

        try {

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
                return false;
            }
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        return true;
    }

    /**
     * 检验上传SQL文件的表字段及字段类型
     * @param recommandTableNames
     * @param request
     * @return
     */
    public String checkColNameType(String[] recommandTableNames, HttpServletRequest request){

        String inuputTableName = request.getParameter("input_tablename"); //检索内容表名
        List<Map> inputCol = checkTableMapper.selectColNameType(constant.getTABLENAME_INPUT()); //检索内容接口表，字段及字段类型
        List<Map> newInputCol = checkTableMapper.selectColNameType(inuputTableName); //上传的检索内容表，字段及字段类型
        if (!inputCol.equals(newInputCol)){
            //检验检索内容input表
            return "检索数据表字段错误！";
        }

        List<Map> targetRecommendTable = checkTableMapper.selectColNameType(constant.getTABLENAME_RECOMMEND()); //推荐结果接口表，字段及字段类型
        for (int i=0;i<recommandTableNames.length;i++){
            //检验推荐结果recommend表
            List<Map> newTableCol= checkTableMapper.selectColNameType(recommandTableNames[i]); //上传的推荐结果表，字段及字段类型
            if (!newTableCol.equals(targetRecommendTable)){
                return recommandTableNames[i] + "表字段错误！";
            }
        }
        return "success";

    }
}

