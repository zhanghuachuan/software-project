package com.huachuan;
import java.io.File;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.sql.ResultSet;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
@Controller

@CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = "*")
public class control {
	
	
	@RequestMapping(value="/loginjudge",produces="application/json;charset=utf-8")
	   public @ResponseBody String checklogin(@RequestParam("username") String username,@RequestParam("password") String password) {
		boolean rs=false;
	
		  System.out.println(username);
		try {
			rs = SqlHelper.checkinfo(username, password);
			System.out.print(rs);
			 if(rs) {
				  return"{\"judgeresult\":\"登陆成功\"}";
			  }
			 else {
				  return"{\"judgeresult\":\"登陆失败\"}";
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
			  return"{\"judgeresult\":\"登陆失败\"}";
		  
		   
		   
	   }

	
	@RequestMapping(value="/loginregister",produces="application/json;charset=utf-8")
	   public @ResponseBody String loginregister(@RequestParam("username") String username,@RequestParam("password") String password) {
		  boolean rs=false;
		 
		  
		try {
			rs = SqlHelper.register(username, password);
			 if(rs) {
				 
				  return"{\"judgeresult\":\"注册成功\"}";
			  }
			 else {
				  
				  return"{\"judgeresult\":\"注册失败\"}";
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
			  return"{\"judgeresult\":\"注册失败\"}";
		  
		   
		   
	   }
	
	

	@RequestMapping(value="/querybook",produces="application/json;charset=utf-8")
	   public @ResponseBody String bookquery(@RequestParam("class") String classification) {
		 
		 return SqlHelper.querybook(classification);
		 
		  
		   
		   
	   }
	
	@RequestMapping(value="/addbook",produces="application/json;charset=utf-8")
	   public @ResponseBody String addbook(@RequestParam(value= "bookname",required=false) String bookname,@RequestParam(value="author",required=false) String author,@RequestParam(value="price",required=false) String price,@RequestParam(value="classify",required=false) String classify,@RequestParam(value="status",required=false) String status) throws UnsupportedEncodingException {
		Boolean flag=false;
		String  name = new String(bookname.getBytes("ISO8859_1"), "UTF-8");
		String  zuozhe = new String(author.getBytes("ISO8859_1"), "UTF-8");
		String zhuangtai = new String(status.getBytes("ISO8859_1"), "UTF-8");
		try {
			flag = SqlHelper.insertbook(name, zuozhe, price, zhuangtai, classify);
			 if(flag) {
				 
				 return"{\"judgeresult\":\"注册成功\"}";
			  }
			 else {
				  
				  return"{\"judgeresult\":\"注册失败\"}";
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
			  return"{\"judgeresult\":\"注册失败\"}";
		  
		   
		   
	   }
	
	
	@RequestMapping(value="/delbook",produces="application/json;charset=utf-8")
	   public @ResponseBody String delbook(@RequestParam(value= "bookname",required=false) String bookname) throws UnsupportedEncodingException {
		Boolean flag=false;
		String  name = new String(bookname.getBytes("ISO8859_1"), "UTF-8");
		
		try {
			flag = SqlHelper.delbook(name);
			 if(flag) {
				 
				 return"{\"judgeresult\":\"删除成功\"}";
			  }
			 else {
				  
				  return"{\"judgeresult\":\"删除失败\"}";
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
			  return"{\"judgeresult\":\"删除失败\"}";
		  
		   
		   
	   }
	
	
	
}
