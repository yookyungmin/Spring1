package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller

//�� ���� �Է��ϸ� �ش� ��¥�� � �������� �˷��ִ����α׷�
public class YoilTeller {//http://localhost:8000/ch2/getYoil?year=2021&month=10&day=1
	@RequestMapping("/getYoil")
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//�������� ����� ������ �Ϸ��� HttpServletResponse response
		//HttpServletRequest request�����ؼ� ���Ķ��Ÿ�� ����
		
		//1�Է�
		String year = request.getParameter("year");  //��Ʈ���̶� getParameter
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		
		
		
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		//2�۾�
		Calendar cal = Calendar.getInstance();
		
		cal.set(yyyy, mm-1, dd);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //1:�Ͽ���, 2:������
		char yoil = " �Ͽ�ȭ�������".charAt(dayOfWeek);
		
		//���
		response.setContentType("text/html"); //text�̰� html �����̴�
		response.setCharacterEncoding("utf-8"); //text�� ���ڵ��� ���� �˷��� ������ �ѱ۱���
		PrintWriter out = response.getWriter(); //response ��ü���� ���������� ��� ��Ʈ���� ��´�.
		//�������� ����� ������ �Ϸ��� out. 
		out.println(year + "�� " + month + "�� "+day+ "����");
		out.println(yoil+"�����Դϴ�");
		
		//all Concern ���ɻ� �ؾ��� �۾�
		//oop 5�� �����Ģ SOLID
		//SRP - ���� å�� ��Ģ �ϳ��� �޼���� �ϳ��� å�Ӹ� ����
		//���ɻ��� �и�, ���ϴ� ��(Common)�� ���� ������ �ʴ°�(uncommon) �и�, �����ڵ� �и�
	}

}
