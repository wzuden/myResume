package com.wzuden.resume.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wzuden.resume.action.fo.User;
import com.wzuden.resume.dao.ILoginDao;

/**
 * ��¼������
 * @author wangzhen
 * @version 1.0
 * @since 2017��5��10�� ����9:18:47
 * @category 
 * @copyright
 */
public class LoginAction extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8150296099723756917L;
	/**�û�ʵ����*/
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
			tips = "�û������������";
			return "fail";
		}
		
		if(user.getPassword().equals(obj.getPassword())){
			/*��¼�ɹ�������session���ԣ����ڹ���������ʶ���Ƿ��¼*/
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("username", user.getUsername());
			return SUCCESS;
		}else{
			tips = "�û������������";
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
