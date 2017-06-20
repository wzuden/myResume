package com.wzuden.resume.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wzuden.resume.action.fo.BaseInfo;
import com.wzuden.resume.dao.IBaseInfoDao;
import com.wzuden.resume.serv.BaseInfoServ;

/**
 * ���������Ϣ
 * 
 * @author wangzhen
 * @version 1.0
 * @since 2017��5��18�� ����10:13:42
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
	
	public BaseInfo getBaseInfo()
	{
		return baseInfo;
	}
	
	public void setBaseInfo(BaseInfo baseInfo)
	{
		this.baseInfo = baseInfo;
	}
	/**
	 * ҵ��������
	 */
	private BaseInfoServ serv;
	
//	private IBaseInfoDao baseInfoDao;
	
	public String init() throws Exception
	{
		System.out.println("enter baseinfo action...");
		String name = baseInfo.toString();
		System.out.println(name);
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = (String) request.getSession().getAttribute("username");
		System.out.println(username);
		baseInfo.setUsername(username);
		/*
		 * ��Ҫ�ж�ҳ���Ƿ���ֵ����������ִ�в�����������޸Ĳ���
		 * �Ƚ��в�ѯ
		 */
		
		serv.insertBaseInfo(baseInfo);
		return "success";
	}

	/**
	 * ��ʼ����ѯ����
	 * 
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception{
		System.out.println("enter BaseInfoAction query...");
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = (String) request.getSession().getAttribute("username");
		System.out.println(username);
		baseInfo = serv.query(username);
		System.out.println("baseInfo="+baseInfo);
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
	
	public void setServ(BaseInfoServ serv)
	{
		this.serv = serv;
	}
	
}
