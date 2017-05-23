package com.wzuden.resume.action.fo;

/**
 * 用户实体类
 * 
 * @author wangzhen
 * @version 1.0
 * @since 2017年5月11日 下午9:34:32
 * @category 
 * @copyright
 */
public class User
{
	/**用户名*/
	private String username;
	/**密码*/
	private String password;

	
	public String getUsername()
	{
		return username;
	}

	
	public void setUsername(String username)
	{
		this.username = username;
	}

	
	public String getPassword()
	{
		return password;
	}

	
	public void setPassword(String password)
	{
		this.password = password;
	}


	@Override
	public String toString()
	{
		return "User [username=" + username + ", password=" + password + "]";
	}
	
	
}
