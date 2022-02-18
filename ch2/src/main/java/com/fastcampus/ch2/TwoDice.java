package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//���� �ֻ��� ������ �ϱ� ���ึ�� ����� �޶��� = 

//�������ҽ� = ��Ʈ����, ���α׷�
//�̹��� ���� , js, css , html= ���� ���ҽ�

@Controller
public class TwoDice {
		
	@RequestMapping("/rollDice")
	public void main(HttpServletResponse response) throws IOException { //�߻��Ҽ��ֱ⿡ ������ 
	
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

//Thread pool �����带 ������ ����� ���� �۾������ʴ� �����尡 ��û�� ���� ��û�� �޾Ƽ� ó��
//Thread pool Http processer Engine host context ����ch2 ��Ʈ�ѷ� TwoDice