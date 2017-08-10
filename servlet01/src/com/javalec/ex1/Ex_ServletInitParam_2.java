package com.javalec.ex1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


    /* web.xml�� �Է��Ͽ� �ҷ����� ���
     * ServletŬ���� ���� > web.xml�� ��� > ServletConfigŬ���� �̿��Ͽ� �����ͺҷ���
     *	(�ش� Ŭ������ ServletConfigŬ������ �̹� ��ӹް������Ƿ� �ٷ� getInitParameter Ȱ��)
     * 	������ �ʱ�ȭ �Ķ���� : Ư�� Servlet������ �ʱ� �ʿ��� ������(ex ���̵�, Ư�����) =>ServletConfigŬ����
     * 
     *   1)web.xml���
        	<servlet>
			  	<servlet-name>ServletInitParam</servlet-name>
			  	<servlet-class>com.javalec.ex1.ServletInitParam</servlet-class>
			  	
			  	<init-param>
			  		<param-name>id</param-name>
			  		<param-value>abc123</param-value>
			  	</init-param>
			  	<init-param>
			  		<param-name>password</param-name>
			  		<param-value>1234</param-value> 
			  	</init-param>
			  	<init-param>
			  		<param-name>path</param-name>
			  		<param-value>C:\\javalec\\workspace</param-value>
			  	</init-param>
			  </servlet>
			  <servlet-mapping>
			  	<servlet-name>ServletInitParam</servlet-name>
			  	<url-pattern>/InitParam</url-pattern>
			  </servlet-mapping>
			  
			  
     * �ʱ�ȭ �Ķ���͸� web.xml�� �ƴ� Servlet���Ͽ� ��������� ����
     * 
     */
/**
 * Servlet implementation class Config_Context_Listener
 */
//@WebServlet("/ccl")
public class Ex_ServletInitParam_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex_ServletInitParam_2() {
        super();
        // TODO Auto-generated constructor stub
    }
    @PostConstruct
    private void post_construct() {
    	System.out.println("PostConstruct ��ó��");
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	System.out.println("init()ȣ��");
    }
    @Override
    public void destroy() {
    	// TODO Auto-generated method stub
    	super.destroy();
    	System.out.println("destroy()ȣ��");
    }
    @PreDestroy
    public void pre_destroy() {
    	System.out.println("PreDestroy ��ó��");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	//ServletConfig�ʿ���� �ٷ� getInitOParameter�޼��� Ȱ��(�̹� ��ӹް������Ƿ� ServerConfigġ�� cntl+t�� Ȯ�ΰ���)
    	String id = getInitParameter("id");
    	String pw = getInitParameter("pw");
    	String path = getInitParameter("path");
    	
    	resp.setContentType("text/html; charset=UTF-8");
    	PrintWriter writer = resp.getWriter();
    	writer.println("<html><head></head><body>");
    	writer.println("���̵� :"+ id +"<br>");
      	writer.println("��й�ȣ :"+ pw +"<br>");
      	writer.println("��� :"+ path +"<br>");
      	writer.println("</body></html>");
      	writer.close();
        
    }
}