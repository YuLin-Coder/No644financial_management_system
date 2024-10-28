package com.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DB;
import com.orm.TJingying;

public class jingying_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
        if(type.endsWith("jingyingMana"))
        {
        	jingyingMana(req, res);
        }
        if(type.endsWith("jingyingList"))
        {
        	jingyingList(req, res);
        }
		if(type.endsWith("jingyingAdd"))
		{
			jingyingAdd(req, res);
		}
	}
	
	
	public void jingyingAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String mingcheng=req.getParameter("mingcheng");
		String riqi=req.getParameter("riqi");
		String touru=req.getParameter("touru");
		String shouyi=req.getParameter("shouyi");
		String lirun=req.getParameter("lirun");
		String sql="insert into t_jingying (mingcheng,riqi,touru,shouyi,lirun) values(?,?,?,?,?)";
		Object[] params={mingcheng,riqi,touru,shouyi,lirun};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "²Ù×÷³É¹¦");
		req.setAttribute("path", "jingying?type=jingyingMana");
		
		String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	
	public void jingyingMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String sql="select * from t_jingying";
		
		req.setAttribute("jingyingList", getjingyingList(sql));
		req.getRequestDispatcher("admin/jingying/jingyingMana.jsp").forward(req, res);
	}
	
	public void jingyingList(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String sql="select * from t_jingying";
		
		req.setAttribute("jingyingList", getjingyingList(sql));
		req.getRequestDispatcher("admin/jingying/jingyingList.jsp").forward(req, res);
	}

	
	private List getjingyingList(String sql)
	{
		List jingyingList=new ArrayList();
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				TJingying jingying=new TJingying();
				jingying.setId(rs.getInt("id"));
				jingying.setMingcheng(rs.getString("mingcheng"));
				jingying.setRiqi(rs.getString("riqi"));
				jingying.setTouru(rs.getDouble("touru"));
				jingying.setShouyi(rs.getDouble("shouyi"));
				jingying.setLirun(rs.getDouble("lirun"));
				jingyingList.add(jingying);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();	
		return jingyingList;
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
