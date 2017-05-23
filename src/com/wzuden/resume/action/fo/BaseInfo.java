package com.wzuden.resume.action.fo;

/**
 * 基本信息模块的信息
 * 
 * @author wangzhen
 * @version 1.0
 * @since 2017年5月18日 下午10:15:48
 * @category 
 * @copyright
 */
public class BaseInfo
{
	/**用户名*/
	private String username;
	/**姓名*/
	private String name;
	/**性别*/
	private String gender;
	/**出生日期*/
	private String birthday;
	/**城市*/
	private String city;
	/**手机号*/
	private String cellphone;
	/**邮箱*/
	private String email;

	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getName()
	{
		return name;
	}

	
	public void setName(String name)
	{
		this.name = name;
	}

	
	public String getGender()
	{
		return gender;
	}

	
	public void setGender(String gender)
	{
		this.gender = gender;
	}

	
	public String getBirthday()
	{
		return birthday;
	}

	
	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}

	
	public String getCity()
	{
		return city;
	}

	
	public void setCity(String city)
	{
		this.city = city;
	}

	
	public String getCellphone()
	{
		return cellphone;
	}

	
	public void setCellphone(String cellphone)
	{
		this.cellphone = cellphone;
	}

	
	public String getEmail()
	{
		return email;
	}

	
	public void setEmail(String email)
	{
		this.email = email;
	}


	@Override
	public String toString()
	{
		return "BaseInfo [name=" + name + ", gender=" + gender + ", birthday=" + birthday
				+ ", city=" + city + ", cellphone=" + cellphone + ", email=" + email
				+ "]";
	}
	
	
}
