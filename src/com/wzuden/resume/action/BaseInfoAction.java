package com.wzuden.resume.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wzuden.resume.action.fo.BaseInfo;
import com.wzuden.resume.dao.IBaseInfoDao;

/**
 * 处理基本信息
 * 
 * @author wangzhen
 * @version 1.0
 * @since 2017年5月18日 下午10:13:42
 * @category 
 * @copyright
 */
public class BaseInfoAction extends ActionSupport implements ModelDriven<BaseInfo>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -339474404090919580L;
	private BaseInfo baseInfo;
	
	private IBaseInfoDao baseInfoDao;
	
	@Override
	public String execute() throws Exception
	{
		System.out.println("enter baseinfo action...");
		String name = baseInfo.toString();
		System.out.println(name);
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = (String) request.getSession().getAttribute("username");
		System.out.println(username);
		baseInfo.setUsername(username);
		baseInfoDao.insertBaseInfo(baseInfo);
		return "success";
	}

	@Override
	public BaseInfo getModel()
	{
		if(baseInfo==null){
			baseInfo = new BaseInfo();
		}
		return baseInfo;
	}

	
	public void setBaseInfoDao(IBaseInfoDao baseInfoDao)
	{
		this.baseInfoDao = baseInfoDao;
	}
	
}
