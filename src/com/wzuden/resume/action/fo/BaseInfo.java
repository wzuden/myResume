package com.wzuden.resume.action.fo;

/**
 * ������Ϣģ�����Ϣ
 * 
 * @author wangzhen
 * @version 1.0
 * @since 2017��5��18�� ����10:15:48
 * @category 
 * @copyright
 */
public class BaseInfo
{
	/**�û���*/
	private String username;
	/**����*/
	private String name;
	/**�Ա�*/
	private String gender;
	/**��������*/
	private String birthday;
	/**����*/
	private String city;
	/**�ֻ���*/
	private String cellphone;
	/**����*/
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
