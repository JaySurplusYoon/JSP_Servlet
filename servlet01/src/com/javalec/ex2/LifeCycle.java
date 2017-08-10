package com.javalec.ex2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet�� ����������Ŭ�� �˾ƺ���
/*���� ��û�� Servlet��ü ����  > (��ó��  @PostConstruct) > init()ȣ��
 *���� ��û���� DoGet()/DoPost(), Service() ȣ��
 *���� ����� destroy()ȣ�� > (��ó�� @PreDestroy)
 */

/**
 * Servlet implementation class LifeCycle
 */
@WebServlet("/LifeCycle")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init()����");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy()����");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet()����");
		
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h2>doGet�޼��� ����!</h2>");
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("doPost()����");
		
		//Post��Ŀ��� �ѱ�request�� �������ʰ� �� �޾ƿ��� ���� �ϴ� �ڵ� �ʿ�! 
		request.setCharacterEncoding("EUC-KR");
		
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter writer = response.getWriter();
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h2>doPost�޼��� ����!</h2>");
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
		
	}
	@PostConstruct
	private void initPostConstruct() {
		System.out.println("PostConstruct����");
	}
	@PreDestroy
	private void destroyPreDestroy() {
		System.out.println("PreDestroy����");
	}

}