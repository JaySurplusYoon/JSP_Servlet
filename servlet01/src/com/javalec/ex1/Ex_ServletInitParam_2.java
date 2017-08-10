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


    /* web.xml에 입력하여 불러오는 방법
     * Servlet클래스 제작 > web.xml에 기술 > ServletConfig클래스 이용하여 데이터불러옴
     *	(해당 클래스가 ServletConfig클래스를 이미 상속받고있으므로 바로 getInitParameter 활용)
     * 	서블릿 초기화 파라미터 : 특정 Servlet생성시 초기 필요한 데이터(ex 아이디, 특정경로) =>ServletConfig클래스
     * 
     *   1)web.xml기술
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
			  
			  
     * 초기화 파라미터를 web.xml이 아닌 Servlet파일에 직접기술도 가능
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
    	System.out.println("PostConstruct 선처리");
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	System.out.println("init()호출");
    }
    @Override
    public void destroy() {
    	// TODO Auto-generated method stub
    	super.destroy();
    	System.out.println("destroy()호출");
    }
    @PreDestroy
    public void pre_destroy() {
    	System.out.println("PreDestroy 후처리");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	//ServletConfig필요없이 바로 getInitOParameter메서드 활용(이미 상속받고있으므로 ServerConfig치고 cntl+t로 확인가능)
    	String id = getInitParameter("id");
    	String pw = getInitParameter("pw");
    	String path = getInitParameter("path");
    	
    	resp.setContentType("text/html; charset=UTF-8");
    	PrintWriter writer = resp.getWriter();
    	writer.println("<html><head></head><body>");
    	writer.println("아이디 :"+ id +"<br>");
      	writer.println("비밀번호 :"+ pw +"<br>");
      	writer.println("경로 :"+ path +"<br>");
      	writer.println("</body></html>");
      	writer.close();
        
    }
}
