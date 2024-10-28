package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.dao.DB;
import com.orm.TAdmin;
import com.orm.TZhigong;

public class loginService
{
	
	public String login(String userName,String userPw,int userType)
	{
		String result="no";
		if(userType==0)//ÏµÍ³¹ÜÀíÔ±µÇÂ½
		{
			String sql="select * from t_admin where userName=? and userPw=?";
			Object[] params={userName,userPw};
			DB mydb=new DB();
			mydb.doPstm(sql, params);
			try 
			{
				ResultSet rs=mydb.getRs();
				boolean mark=(rs==null||!rs.next()?false:true);
				if(mark==false)
				{
					result="no";
				}
				else
				{
					result="yes";
					TAdmin admin=new TAdmin();
					admin.setUserId(rs.getInt("userId"));
					admin.setUserName(rs.getString("userName"));
					admin.setUserPw(rs.getString("userPw"));
					WebContext ctx = WebContextFactory.get(); 
					HttpSession session=ctx.getSession(); 
					session.setAttribute("userType", 0);
					session.setAttribute("admin", admin);
				}
				rs.close();
			} 
			catch (SQLException e)
			{
				System.out.println("µÇÂ¼Ê§°Ü£¡");
				e.printStackTrace();
			}
			finally
			{
				mydb.closed();
			}
		}
		if(userType==1)//Ö°¹¤µÇÂ¼
		{
			String sql="select * from t_zhigong where bianhao=? and loginpw=? and del='no'";
			Object[] params={userName,userPw};
			DB mydb=new DB();
			mydb.doPstm(sql, params);
			try 
			{
				ResultSet rs=mydb.getRs();
				boolean mark=(rs==null||!rs.next()?false:true);
				if(mark==false)
				{
					 result="no";
				}
				else
				{
					 result="yes";
					 TZhigong zhigong=new TZhigong();
					 zhigong.setId(rs.getInt("id"));
					 zhigong.setBumen_id(rs.getInt("bumen_id"));
					 zhigong.setBianhao(rs.getString("bianhao"));
					 zhigong.setLoginpw(rs.getString("loginpw"));
					 zhigong.setXingming(rs.getString("xingming"));
					 zhigong.setXingbie(rs.getString("xingbie"));
					 zhigong.setRuzhi(rs.getString("ruzhi"));
					 WebContext ctx = WebContextFactory.get(); 
					 HttpSession session=ctx.getSession(); 
					 session.setAttribute("userType", 1);
			         session.setAttribute("user", zhigong);
				}
				rs.close();
			} 
			catch (SQLException e)
			{
				System.out.println("µÇÂ¼Ê§°Ü£¡");
				e.printStackTrace();
			}
			finally
			{
				mydb.closed();
			}
		}
		return result;
	}

    public String adminPwEdit(String userPwNew)
    {
		WebContext ctx = WebContextFactory.get(); 
		HttpSession session=ctx.getSession(); 
		TAdmin admin=(TAdmin)session.getAttribute("admin");
		
		String sql="update t_admin set userPw=? where userId=?";
		Object[] params={userPwNew,admin.getUserId()};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		
		return "yes";
    }
    
}
