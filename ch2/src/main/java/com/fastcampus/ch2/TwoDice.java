package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//랜덤 주사위 찍히게 하기 실행마다 결과가 달라짐 = 

//동적리소스 = 스트리밍, 프로그램
//이미지 파일 , js, css , html= 정적 리소스

@Controller
public class TwoDice {
		
	@RequestMapping("/rollDice")
	public void main(HttpServletResponse response) throws IOException { //발생할수있기에 적어줌 
	
			int idx1 = (int)(Math.random()*6)+1;
			int idx2 = (int)(Math.random()*6)+1;
			
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<img src = 'resources/img/dice"+idx1+".jpg'>");
		out.println("<img src = 'resources/img/dice"+idx2+".jpg'>");
		out.println("</body>");
		out.println("</html>");
		

	}

}

//Thread pool 쓰레드를 여러개 만들어 놓고 작업하지않는 쓰레드가 요청이 오면 요청을 받아서 처리
//Thread pool Http processer Engine host context 서블릿ch2 컨트롤러 TwoDice