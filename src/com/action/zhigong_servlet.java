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
import com.orm.TZhigong;

public class zhigong_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
        
        if(type.endsWith("zhigong_me"))
        {
        	zhigong_me(req, res);
        }
        if(type.endsWith("zhigongUpd_me"))
        {
        	zhigongUpd_me(req, res);
        }
		
        if(type.endsWith("zhigongMana"))
        {
        	zhigongMana(req, res);
        }
		if(type.endsWith("zhigongList"))
		{
			zhigongList(req, res);
		}
		if(type.endsWith("zhigongAdd"))
		{
			zhigongAdd(req, res);
		}
		if(type.endsWith("zhigongUpd"))
		{
			zhigongUpd(req, res);
		}
		if(type.endsWith("zhigongDel"))
		{
			zhigongDel(req, res);
		}
		
		
	}
	
	
	public void zhigongAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String bumen_id=req.getParameter("bumen_id");
		String bianhao=req.getParameter("bianhao");
		String loginpw=req.getParameter("loginpw");
		String xingming=req.getParameter("xingming");
		String xingbie=req.getParameter("xingbie");
		String ruzhi=req.getParameter("ruzhi");
		String del="no";
		String sql="insert into t_zhigong (bumen_id,bianhao,loginpw,xingming,xingbie,ruzhi,del) values(?,?,?,?,?,?,?)";
		Object[] params={bumen_id,bianhao,loginpw,xingming,xingbie,ruzhi,del};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "zhigong?type=zhigongMana");
		
		String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void zhigongUpd(HttpServletRequest req,HttpServletResponse res)
	{
		String id=req.getParameter("id");
		String bumen_id=req.getParameter("bumen_id");
		String loginpw=req.getParameter("loginpw");
		String xingming=req.getParameter("xingming");
		String xingbie=req.getParameter("xingbie");
		String ruzhi=req.getParameter("ruzhi");
		String sql="update t_zhigong set bumen_id=?,loginpw=?,xingming=?,xingbie=?,ruzhi=? where id=?";
		Object[] params={bumen_id,loginpw,xingming,xingbie,ruzhi,id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "zhigong?type=zhigongMana");
		
		String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void zhigongUpd_me(HttpServletRequest req,HttpServletResponse res)
	{
		String id=req.getParameter("id");
		String loginpw=req.getParameter("loginpw");
		String xingming=req.getParameter("xingming");
		String xingbie=req.getParameter("xingbie");
		String sql="update t_zhigong set loginpw=?,xingming=?,xingbie=? where id=?";
		Object[] params={loginpw,xingming,xingbie,id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "zhigong?type=zhigong_me");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void zhigongDel(HttpServletRequest req,HttpServletResponse res)
	{
		String sql="update t_zhigong set del='yes' where id="+Integer.parseInt(req.getParameter("id"));
		Object[] params={};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "zhigong?type=zhigongMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void zhigong_me(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		TZhigong zhigong = (TZhigong)req.getSession().getAttribute("user");
		String sql="select ta.*,tb.mingcheng bmmc,tb.xishu from t_zhigong ta,t_bumen tb " +
				   "where ta.del='no' and ta.bumen_id=tb.id and ta.id="+zhigong.getId();
		
		req.setAttribute("zhigong", (TZhigong)getZhigongList(sql).get(0));
		req.getRequestDispatcher("admin/zhigong/zhigong_me.jsp").forward(req, res);
	}
	
	public void zhigongMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String sql="select ta.*,tb.mingcheng bmmc,tb.xishu from t_zhigong ta,t_bumen tb " +
		"where ta.del='no' and ta.bumen_id=tb.id";
		String bianhao = req.getParameter("bianhao")==null?"":req.getParameter("bianhao");
		if(!("".equals(bianhao)))
			sql += " and bianhao like '%"+bianhao+"%'";
		
		req.setAttribute("bianhao", bianhao);
		req.setAttribute("zhigongList", getZhigongList(sql));
		req.getRequestDispatcher("admin/zhigong/zhigongMana.jsp").forward(req, res);
	}

	public void zhigongList(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String sql="select ta.*,tb.mingcheng bmmc,tb.xishu from t_zhigong ta,t_bumen tb " +
				   "where ta.del='no' and ta.bumen_id=tb.id and ta.id not in " +
				   "(select zhigong_id from t_gongzi)";
		
		req.setAttribute("zhigongList", getZhigongList(sql));
		req.getRequestDispatcher("admin/zhigong/zhigongList.jsp").forward(req, res);
	}
	
	private List getZhigongList(String sql)
	{
		List zhigongList=new ArrayList();
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				TZhigong zhigong=new TZhigong();
				zhigong.setId(rs.getInt("id"));
				zhigong.setBumen_id(rs.getInt("bumen_id"));
				zhigong.setBianhao(rs.getString("bianhao"));
				zhigong.setLoginpw(rs.getString("loginpw"));
				zhigong.setXingming(rs.getString("xingming"));
				zhigong.setXingbie(rs.getString("xingbie"));
				zhigong.setRuzhi(rs.getString("ruzhi"));
				
				zhigong.setBmmc(rs.getString("bmmc"));
				zhigong.setXishu(rs.getDouble("xishu"));
				zhigongList.add(zhigong);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return zhigongList;
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
