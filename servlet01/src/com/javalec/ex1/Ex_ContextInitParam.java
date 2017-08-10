package com.javalec.ex1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*ServletContextȰ���Ͽ� ��� Ŭ�������� �ҷ��� �� �ִ� ������ Ȱ�� 
 * web.xml���� ���κ��� ��ܿ� ContextParam �Է�
 * 		<context-param>
			<param-name>id</param-name>
			<param-value>contextID</param-value>
		</context-param>
 * String id = getServletContext().getInitParameter("id");Ȱ���Ͽ� ������ �ҷ�����
 */

/**
 * Servlet implementation class ContextInitParam
 */
@WebServlet("/ServletContext")
public class Ex_ContextInitParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex_ContextInitParam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    @PostConstruct
    public void post_construct() {
    	System.out.println("PostConstruct ��ó��");
    }
	public void init(ServletConfig config) throws ServletException {

		System.out.println("init()ȣ��õ�");
		super.init(config);
		System.out.println("init()ȣ��Ϸ�");
		// TODO Auto-generated method stub
	}
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		super.destroy();
		System.out.println("destroy()�Ϸ�");
		// TODO Auto-generated method stub
	}
	@PreDestroy
	public void pre_destroy() {
		System.out.println("PreDestroy ��ó��");
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String id = getServletContext().getInitParameter("id");
		String pw = getServletContext().getInitParameter("pw");
		String path = getServletContext().getInitParameter("path");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		writer.println("<html><head><title>ServletContext</title></head><body>");
		writer.println("���̵� : "+id+"<br>");
		writer.println("��й�ȣ : "+pw+"<br>");
		writer.println("���"+ path+"</body></html>");
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}