package com.huachuan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.javafx.collections.MappingChange.Map;

public class SqlHelper {
	public static Connection conn = mysqlconnection.getconnection();
public static Boolean checkinfo(String username,String password){
	
	 String sql = "select username,password from user where username=(?)";

     try {
         PreparedStatement state =  conn.prepareStatement(sql);
         state.setObject(1,username);
         ResultSet result=state.executeQuery();
         result.next();
         String p = result.getString(2);
         
         if(p.equals(password))
         {
        	 
             return true;
         }
     } catch (Exception e) {
    	 System.out.print("账号不存在");
     }
     return false;

	 
  
}
public static boolean register(String username,String password){
	
	
	 String sql = "insert into user (username,password) values(?,?)";

    try {
        PreparedStatement state =  conn.prepareStatement(sql);
        state.setObject(1,username);
        state.setObject(2,password);
        int result=state.executeUpdate();
       System.out.print(result);
        if(result==1)
        {
            return true;
        }
    } catch (Exception e) {
   	 System.out.print("注册账户重复");
   	 
    }
    return false;

}

public static String querybook(String classification){
	System.out.print(classification);
    String sql="select bookname,author,price,status from book where class="+"\""+classification+"\"";
    HashMap<String,Object> datamap = new HashMap<String,Object>();
    ResultSet rs=null;
    JSONObject json = new JSONObject();
    try {
        PreparedStatement stat = conn.prepareStatement(sql);
        rs = stat.executeQuery();
        while(rs.next()){
        	
        	datamap.put("author", rs.getString(2));
        	datamap.put("price", rs.getString(3));
        	datamap.put("status", rs.getString(4));
//        	datamap.put("count", rs.getString(5));
        	json.put( rs.getString(1), JSON.toJSONString(datamap));
        	
        }
        System.out.print(json.toJSONString());
        return json.toJSONString();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}







public static boolean insertbook(String bookname,String author,String price,String status,String classify){
	
	
	 String sql = "insert into book (bookname,author,price,status,class) values(?,?,?,?,?)";

   try {
       PreparedStatement state =  conn.prepareStatement(sql);
       state.setObject(1,bookname);
       state.setObject(2,author);
       state.setObject(3,price);
       state.setObject(4,status);
       state.setObject(5,classify);
       int result=state.executeUpdate();
      System.out.print(result);
       if(result==1)
       {
           return true;
       }
   } catch (Exception e) {
  	 System.out.print("录入成功");
  	 
   }
   return false;

}










}