package com.wzuden.resume.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ��¼״̬������
 * 
 * @author wangzhen
 * @version 1.0
 * @since 2017��5��11�� ����8:47:39
 * @category 
 * @copyright
 */
public class LoginFilter extends HttpServlet implements Filter
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3752954069905109050L;

	@Override
	public void doFilter(ServletRequest sRequest, ServletResponse sResponse, 
			FilterChain filterChain)
			throws IOException, ServletException
	{
		System.out.println("enter doFilter...");
		HttpServletRequest request = (HttpServletRequest) sRequest;        
        HttpServletResponse response = (HttpServletResponse) sResponse;        
        HttpSession session = request.getSession();        
        String url=request.getServletPath();    
        String contextPath=request.getContextPath();    
        if(url.equals("")) url+="/";    
        if((url.startsWith("/")&&!url.startsWith("/login"))){//�����ʺ�̨��Դ ���˵�login    
             String user=(String)session.getAttribute("username");
             System.out.println("user:"+user);
             if(user==null){//ת�����Ա��½ҳ�棬�ض���
                  response.sendRedirect(contextPath+"/login.html"); 
                  return;    
             }    
        }    
          filterChain.doFilter(sRequest, sResponse); 
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException
	{
		
	}
	
}
