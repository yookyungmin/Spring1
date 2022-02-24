package com.fastcampus.ch2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	@Override
	public void init() throws ServletException { //ó�� �ѹ��� ȣ��
		//������ �ʱ�ȭ �ɶ� �ڵ� ȣ��Ǵ� �޼���
		//1 �������ʱ�ȭ �۾����
		System.out.println("[HelloServic init() is claaed");
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.�Է�
		//2ó��
		//3���
		System.out.println("[HelloServlet] service() is called");
	} //��û�� �Ë����� �ݺ����

	@Override
	public void destroy() {
		
		//3 ������ ������ �޸𸮿��� ���ŵɋ� ���� �����̳ʿ��� ���ؼ� �ڵ�ȣ��
		System.out.println("[HelloServlet] destroy() is called");
	} //������ ����, ���� �ɶ� 

			
}
