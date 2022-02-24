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
	public void init() throws ServletException { //처음 한번만 호출
		//서블릿이 초기화 될때 자동 호출되는 메서드
		//1 서블릿의초기화 작업담당
		System.out.println("[HelloServic init() is claaed");
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.입력
		//2처리
		//3출력
		System.out.println("[HelloServlet] service() is called");
	} //요청이 올떄마다 반복출력

	@Override
	public void destroy() {
		
		//3 뒷정리 서블릿이 메모리에서 제거될떄 서블릿 컨테이너에서 의해서 자동호출
		System.out.println("[HelloServlet] destroy() is called");
	} //서블릿이 갱신, 종료 될때 

			
}
