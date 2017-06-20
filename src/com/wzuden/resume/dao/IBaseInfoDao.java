package com.wzuden.resume.dao;

import java.util.Map;

import com.wzuden.resume.action.fo.BaseInfo;

/**
 * ������Ϣ�Ľӿ�
 * 
 * @author wangzhen
 * @version 1.0
 * @since 2017��5��22�� ����9:29:26
 * @category 
 * @copyright
 */
public interface IBaseInfoDao
{
	/**
	 * ��ӻ�����Ϣ
	 * @param baseInfo
	 */
	public void insertBaseInfo(BaseInfo baseInfo);
	/**
	 * ��ѯ��ǰ�û��Ƿ��м�¼
	 * @param username
	 * @return
	 */
	public String getTest(String username);
	/**
	 * �����޸Ĳ���
	 * 
	 * @param baseInfo
	 */
	public void updateBaseInfo(BaseInfo baseInfo);
	/**
	 * ��ʼ��ҳ���ѯ
	 * 
	 * @param username
	 */
	public BaseInfo query(String username);
}
