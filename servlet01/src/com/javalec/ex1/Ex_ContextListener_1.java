package com.javalec.ex1;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*�Ϲ� �ڹ� Class���� ������ ServletContextListener�� �����Ѵ�
 *
 * 
 */
public class Ex_ContextListener_1 implements ServletContextListener {

	//WAS�� ����ɶ� �����Ǵ� Destroyed
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ContextListener�� contextDestroyed�޼��� �����");

	}
	//ó�� WAS�� ����� �� �����Ǵ� Initialized
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ContextListener�� contextInitialized�޼��� �����");
	}

}
