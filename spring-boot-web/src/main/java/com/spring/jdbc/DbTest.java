package com.spring.jdbc;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

/**
 * jdbc 测试
 * Created by admin on 2018/8/23.
 */
public class DbTest {

    public static void main(String[] args) {
        readTxt("d://area.txt","d://destArea.txt");

    }

    public static void readTxt(String sourcePath,String destPath){

        try{

            Connection conn = ConnectionUtils.getConnection();
            String sql = "INSERT INTO `t_area_info_backup` ( `area_code`, `parent_code`, `area_name`, `level_type`) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            File file = new File(sourcePath);

            if(file.exists() && file.isFile()){

                InputStreamReader reader =
                        new InputStreamReader(new FileInputStream(file),"UTF-8");
                BufferedReader bufferedReader = new BufferedReader(reader);
                String lineTxt = null;
                String destTxt = null;

                String parentTxt = null;
                Map<Integer,String> map = new HashMap<>();

                while ( null != (lineTxt = bufferedReader.readLine())){
                    if(lineTxt.contains(":") ){
                        String level = "";
                        String[] lineTxts = lineTxt.split(":");
                        String key = lineTxts[0].trim().replace("\"","" ).replace("+","");
                        String value = lineTxts[1].trim().replace("\"","" );

                        if(value.contains("{")){
                            map = new HashMap<>();
                            String[] keys = key.split(",");
                            for(int i = 0 ;i< keys.length ;i++){
                                map.put(i,keys[i]);
                            }
                            parentTxt = keys[keys.length -1];
                            continue;
                        }

                        destTxt = parentTxt+ "," + key+ ","+value;
                        if(1 == map.size()){
                            level = "1";
                        }else if(2 == map.size()){
                            level = "2";
                        }else {
                            level = "3";
                        }

                        ps.setString(1, key);
                        ps.setString(2, parentTxt.replace(",",""));
                        ps.setString(3, value.replace(",",""));
                        ps.setString(4, level);
                        ps.execute();


                    }
                }

                reader.close();
                ConnectionUtils.close(conn,ps);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
