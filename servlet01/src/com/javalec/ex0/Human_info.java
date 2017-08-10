package com.javalec.ex0;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Human_info
 */
@WebServlet("/HI")
public class Human_info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Human_info() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    @PostConstruct
    public void post_construct(){
    	System.out.println("PostConstruct 선처리");
    }
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		System.out.println("init()호출");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("destroy()호출");
	}
	@PreDestroy
	public void pre_destroy() {
		System.out.println("PreDestroy 후처리");
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pwd");
		String car = request.getParameter("car");
		String [] hobby = request.getParameterValues("hobby");
		System.out.println(name);
		System.out.println(id);
		System.out.println(pw);
		System.out.println(car);
		System.out.println(Arrays.toString(hobby));
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("<html><head><title>회원정보</title></head><body>");
		writer.println("이름 : "+name+"<br>");
		writer.println("ID : "+id+"<br>");
		writer.println("비밀번호 : "+pw+"<br>");
		writer.println("차량유무 : "+car+"<br>");
		writer.println("취미 : "+Arrays.toString(hobby)+"</body></html>");
		writer.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pwd");
		String car = request.getParameter("car");
		String [] hobby = request.getParameterValues("hobby");
		
		PrintWriter writer = response.getWriter();
		writer.println("<html><head><title>회원정보</title></head><body>");
		writer.println("성명 :"+name+"<br>");
		writer.println("아이디 : "+id + "<br>");
		writer.println("비밀번호 : "+pw + "<br>");
		writer.println("차량유무 : "+car + "<br>");
		writer.println("취미 : "+Arrays.toString(hobby)+"</body></html>");
		writer.close();
	}

}
