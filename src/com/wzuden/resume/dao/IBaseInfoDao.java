package com.wzuden.resume.dao;

import java.util.Map;

import com.wzuden.resume.action.fo.BaseInfo;

/**
 * 基本信息的接口
 * 
 * @author wangzhen
 * @version 1.0
 * @since 2017年5月22日 下午9:29:26
 * @category 
 * @copyright
 */
public interface IBaseInfoDao
{
	/**
	 * 添加基本信息
	 * @param baseInfo
	 */
	public void insertBaseInfo(BaseInfo baseInfo);
	/**
	 * 查询当前用户是否有记录
	 * @param username
	 * @return
	 */
	public String getTest(String username);
	/**
	 * 进行修改操作
	 * 
	 * @param baseInfo
	 */
	public void updateBaseInfo(BaseInfo baseInfo);
	/**
	 * 初始化页面查询
	 * 
	 * @param username
	 */
	public BaseInfo query(String username);
}
