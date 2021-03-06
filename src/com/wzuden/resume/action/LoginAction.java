package com.wzuden.resume.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wzuden.resume.action.fo.User;
import com.wzuden.resume.dao.ILoginDao;

/**
 * 登录请求处理
 * @author wangzhen
 * @version 1.0
 * @since 2017年5月10日 下午9:18:47
 * @category 
 * @copyright
 */
public class LoginAction extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8150296099723756917L;
	/**用户实体类*/
	private User user;
	
	private ILoginDao loginDao;
	
	private String tips;
	
	public String execute() throws Exception
	{
		System.out.println("enter loginaction...");
		List list = loginDao.getUser(user.getUsername());
		System.out.println("list length="+list.size());
		User obj = null;
		if(list.size() != 0){
			obj = (User) list.get(0);
		}else{
			tips = "用户名或密码错误！";
			return "fail";
		}
		
		if(user.getPassword().equals(obj.getPassword())){
			/*登录成功，设置session属性，便于过滤器进行识别是否登录*/
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("username", user.getUsername());
			return SUCCESS;
		}else{
			tips = "用户名或密码错误！";
			return "fail";
		}
		
	}
	
	public String getTips()
	{
		return tips;
	}
	
	public void setTips(String tips)
	{
		this.tips = tips;
	}

	public void setUser(User user)
	{
		this.user = user;
	}
	
	public User getUser()
	{
		return user;
	}

	public void setLoginDao(ILoginDao loginDao)
	{
		this.loginDao = loginDao;
	}
	
}
