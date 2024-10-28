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
import com.orm.TFeiyong;

public class feiyong_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
        if(type.endsWith("feiyongMana"))
        {
        	feiyongMana(req, res);
        }
        if(type.endsWith("feiyongList"))
        {
        	feiyongList(req, res);
        }
		if(type.endsWith("feiyongAdd"))
		{
			feiyongAdd(req, res);
		}
	}
	
	
	public void feiyongAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String mingcheng=req.getParameter("mingcheng");
		String shijian=req.getParameter("shijian");
		String feiyong=req.getParameter("feiyong");
		String leixing=req.getParameter("leixing");
		String sql="insert into t_feiyong (mingcheng,shijian,feiyong,leixing) values(?,?,?,?)";
		Object[] params={mingcheng,shijian,feiyong,leixing};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "feiyong?type=feiyongMana");
		
		String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void feiyongMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String sql="select * from t_feiyong";
		
		req.setAttribute("feiyongList", getfeiyongList(sql));
		req.getRequestDispatcher("admin/feiyong/feiyongMana.jsp").forward(req, res);
	}
	
	public void feiyongList(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String sql="select * from t_feiyong";
		
		req.setAttribute("feiyongList", getfeiyongList(sql));
		req.getRequestDispatcher("admin/feiyong/feiyongList.jsp").forward(req, res);
	}

	private List getfeiyongList(String sql)
	{
		List feiyongList=new ArrayList();
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				TFeiyong feiyong=new TFeiyong();
				feiyong.setId(rs.getInt("id"));
				feiyong.setMingcheng(rs.getString("mingcheng"));
				feiyong.setShijian(rs.getString("shijian"));
				feiyong.setFeiyong(rs.getString("feiyong"));
				
				int leixing = rs.getInt("leixing");
				feiyong.setLeixing(getLxmc(leixing));
				feiyongList.add(feiyong);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();	
		return feiyongList;
	}
	
	private String getLxmc(int leixing)
	{
		String result = "";
		switch(leixing)
		{
			case 0:
				result = "收入";
				break;
			case 1:
				result = "支出";
				break;
			case 2:
				result = "报销";
				break;
		}
		return result;
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
