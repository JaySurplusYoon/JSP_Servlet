package com.javalec.ex1;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*일반 자바 Class파일 생성후 ServletContextListener를 구현한다
 *
 * 
 */
public class Ex_ContextListener_1 implements ServletContextListener {

	//WAS가 종료될때 구동되는 Destroyed
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ContextListener의 contextDestroyed메서드 실행됨");

	}
	//처음 WAS가 실행될 때 구동되는 Initialized
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ContextListener의 contextInitialized메서드 실행됨");
	}

}
