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
import com.orm.TCatelog;
import com.orm.TZichan;

public class zichan_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
        
        if(type.endsWith("zichanList"))
        {
        	zichanList(req, res);
        }
		if(type.endsWith("zichanMana"))
		{
			zichanMana(req, res);
		}
		if(type.endsWith("zichanToAdd"))
		{
			zichanToAdd(req, res);
		}
		if(type.endsWith("zichanAdd"))
		{
			zichanAdd(req, res);
		}
	}
	
	public void zichanToAdd(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		req.setAttribute("catelogList", getCatelogList());
		req.getRequestDispatcher("admin/zichan/zichanAdd.jsp").forward(req, res);
	}
	
	public void zichanAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String catelog_id=req.getParameter("catelog_id");
		String bianhao=req.getParameter("bianhao");
		String mingcheng=req.getParameter("mingcheng");
		String shijian=req.getParameter("shijian");
		String jiazhi=req.getParameter("jiazhi");
		String type=req.getParameter("leixing");
		String fangshi=req.getParameter("fangshi");
		
		String sql="insert into t_zichan (catelog_id,bianhao,mingcheng,shijian,jiazhi,type,fangshi) " +
				   "values(?,?,?,?,?,?,?)";
		Object[] params={catelog_id,bianhao,mingcheng,shijian,jiazhi,type,fangshi};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "zichan?type=zichanMana");
		
		String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void zichanMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String sql="select ta.*,tb.name lbmc from t_zichan ta,t_catelog tb " +
		"where ta.catelog_id=tb.id";
		
		req.setAttribute("zichanList", getZichanList(sql));
		req.getRequestDispatcher("admin/zichan/zichanMana.jsp").forward(req, res);
	}
	public void zichanList(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String sql="select ta.*,tb.name lbmc from t_zichan ta,t_catelog tb " +
				   "where ta.catelog_id=tb.id";
		
		req.setAttribute("zichanList", getZichanList(sql));
		req.getRequestDispatcher("admin/zichan/zichanList.jsp").forward(req, res);
	}
	
	private List getZichanList(String sql)
	{
		List zichanList=new ArrayList();
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				TZichan zichan=new TZichan();
				zichan.setId(rs.getInt("id"));
				zichan.setBianhao(rs.getString("bianhao"));
				zichan.setMingcheng(rs.getString("mingcheng"));
				zichan.setShijian(rs.getString("shijian"));
				zichan.setJiazhi(rs.getString("jiazhi"));
				zichan.setLbmc(rs.getString("lbmc"));
				
				int type = rs.getInt("type");
				String fangshi = rs.getString("fangshi");
				
				zichan.setStrType(type==0?"增加":"减少");
				
				if(type==0)
					zichan.setStrFangshi(getZjfs(Integer.parseInt(fangshi)));
				else
					zichan.setStrFangshi(getJsfs(Integer.parseInt(fangshi)));
				zichanList.add(zichan);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();		
		return zichanList;
	}
	
	//资产增加的方式
	private String getZjfs(int type)
	{
		String result = "";
		switch(type)
		{
			case 0:
				result = "自建";
				break;
			case 1:
				result = "投资";
				break;
			case 2:
				result = "出租";
				break;
		}
		return result;
	}
	
	//资产减少的方式
	private String getJsfs(int type)
	{
		String result = "";
		switch(type)
		{
			case 0:
				result = "报废";
				break;
			case 1:
				result = "变卖";
				break;
		}
		System.out.println(result);
		return result;		
	}
	
	private List getCatelogList()
	{
		List catelogList=new ArrayList();
		String sql="select * from t_catelog where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				TCatelog catelog=new TCatelog();
				catelog.setId(rs.getInt("id"));
				catelog.setName(rs.getString("name"));
				catelogList.add(catelog);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return catelogList;
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
