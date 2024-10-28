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
import com.orm.TGongzi;
import com.orm.TZhigong;

public class gongzi_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
        if(type.endsWith("gongziMana"))
        {
        	gongziMana(req, res);
        }
		if(type.endsWith("gongzi_me"))
		{
			gongzi_me(req, res);
		}
		if(type.endsWith("gongziAdd"))
		{
			gongziAdd(req, res);
		}
		if(type.endsWith("gongziUpd"))
		{
			gongziUpd(req, res);
		}
	}
	
	
	public void gongziAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String zhigong_id=req.getParameter("zhigong_id");
		String jiben=req.getParameter("jiben");
		String gongling=req.getParameter("gongling");
		String zhiwu=req.getParameter("zhiwu");
		String butie=req.getParameter("butie");
		String sql="insert into t_gongzi (zhigong_id,jiben,gongling,zhiwu,butie) " +
				   "values(?,?,?,?,?)";
		Object[] params={zhigong_id,jiben,gongling,zhiwu,butie};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "gongzi?type=gongziMana");
		
		String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void gongziUpd(HttpServletRequest req,HttpServletResponse res)
	{
		String id=req.getParameter("id");
		String jiben=req.getParameter("jiben");
		String gongling=req.getParameter("gongling");
		String zhiwu=req.getParameter("zhiwu");
		String butie=req.getParameter("butie");
		String sql="update t_gongzi set jiben=?,gongling=?,zhiwu=?,butie=? where id=?";
		Object[] params={jiben,gongling,zhiwu,butie,id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "gongzi?type=gongziMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void gongzi_me(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		TZhigong zhigong = (TZhigong)req.getSession().getAttribute("user");
		String sql="select * from t_gongzi where zhigong_id="+zhigong.getId();
		req.setAttribute("gongzi", ((TGongzi)getGongziList(sql).get(0)));
		req.getRequestDispatcher("admin/gongzi/gongzi_me.jsp").forward(req, res);
	}
	
	public void gongziMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String sql="select * from t_gongzi";
		req.setAttribute("gongziList", getGongziList(sql));
		req.getRequestDispatcher("admin/gongzi/gongziMana.jsp").forward(req, res);
	}
	
	private List getGongziList(String sql)
	{
		List gongziList=new ArrayList();
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				TGongzi gongzi=new TGongzi();
				gongzi.setId(rs.getInt("id"));
				gongzi.setJiben(rs.getDouble("jiben"));
				gongzi.setGongling(rs.getDouble("gongling"));
				gongzi.setZhiwu(rs.getDouble("zhiwu"));
				gongzi.setButie(rs.getDouble("butie"));
				
				int zhigong_id = rs.getInt("zhigong_id");
				gongzi.setZgxx(getZhigongById(zhigong_id));
				
				double jiben = gongzi.getJiben();
				double gongling = gongzi.getGongling();
				double zhiwu = gongzi.getZhiwu();
				double butie = gongzi.getButie();
				
				double xishu = gongzi.getZgxx().getXishu();
				
				double hj = jiben*xishu+gongling+zhiwu+butie;
				
				gongzi.setHj(hj);
				gongziList.add(gongzi);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return gongziList;
	}
	
	private TZhigong getZhigongById(int id)
	{
		TZhigong zhigong=new TZhigong();
		String sql = "select ta.*,tb.mingcheng bmmc,tb.xishu from t_zhigong ta,t_bumen tb " +
				     "where ta.id=? and ta.bumen_id=tb.id";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				zhigong.setId(rs.getInt("id"));
				zhigong.setBumen_id(rs.getInt("bumen_id"));
				zhigong.setBianhao(rs.getString("bianhao"));
				zhigong.setLoginpw(rs.getString("loginpw"));
				zhigong.setXingming(rs.getString("xingming"));
				zhigong.setXingbie(rs.getString("xingbie"));
				zhigong.setRuzhi(rs.getString("ruzhi"));
				
				zhigong.setBmmc(rs.getString("bmmc"));
				zhigong.setXishu(rs.getDouble("xishu"));
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return zhigong;
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
