package com.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DB;
import com.util.DateUtils;

public class fenxi_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
		DB mydb=new DB();
		
		try{
			
			//增加的资产
			String sql = "select count(1)shuliang,ifnull(sum(jiazhi),0)jiazhi from t_zichan where type=0 ";
			mydb.doPstm(sql, null);
			ResultSet rs=mydb.getRs();
			rs.next();
			double zjzcjz = rs.getDouble("jiazhi");
			Map zczj = new HashMap();
			zczj.put("sl", rs.getString("shuliang"));
			zczj.put("jz", zjzcjz);
			rs.close();
			
			//减少的资产
			sql = "select count(1)shuliang,ifnull(sum(jiazhi),0)jiazhi from t_zichan where type=1 ";
			mydb.doPstm(sql, null);
			rs=mydb.getRs();
			rs.next();
			double jszcjz = rs.getDouble("jiazhi");
			Map zcjs = new HashMap();
			zcjs.put("sl", rs.getString("shuliang"));
			zcjs.put("jz", jszcjz);
			rs.close();
			
			//总资产
			Map zongzichan = new HashMap();	//总资产
			double zzc = zjzcjz-jszcjz;
			zongzichan.put("zichan", zzc);
			
			//利润
			sql = "select 1, ifnull(sum(touru),0)touru,ifnull(sum(shouyi),0)shouyi,ifnull(sum(lirun),0)lirun " +
				  "from t_jingying";
			mydb.doPstm(sql, null);
			rs=mydb.getRs();
			rs.next();
			Map jingying = new HashMap();
			jingying.put("touru", rs.getDouble("touru"));
			jingying.put("shouyi", rs.getDouble("shouyi"));
			double zly = rs.getDouble("lirun");
			jingying.put("lirun", zly);
			rs.close();
			
			Map nz = new HashMap();
			nz.put("nz",zzc+zly);
			
			req.setAttribute("zczj", zczj);
			req.setAttribute("zcjs", zcjs);
			req.setAttribute("zongzichan", zongzichan);
			req.setAttribute("jingying", jingying);
			req.setAttribute("nz", nz);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		req.getRequestDispatcher("admin/fenxi/fenxi.jsp").forward(req, res);
	}

	public void dispatch(String targetURI,HttpServletRequest request,HttpServletResponse response) 
	{
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(targetURI);
		try 
		{
		    dispatch.forward(request, response);
		    return;
		} 
		catch (ServletException e) 
		{
             e.printStackTrace();
		} 
		catch (IOException e) 
		{
			
		    e.printStackTrace();
		}
	}
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
	}
	
	public void destroy() 
	{
		
	}
}
