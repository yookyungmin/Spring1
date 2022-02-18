package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller

//년 요일 입력하면 해당 날짜가 어떤 요일인지 알려주는프로그램
public class YoilTeller {//http://localhost:8000/ch2/getYoil?year=2021&month=10&day=1
	@RequestMapping("/getYoil")
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//브라우저에 결과를 나오게 하려면 HttpServletResponse response
		//HttpServletRequest request를통해서 겟파라미타로 꺼냄
		
		//1입력
		String year = request.getParameter("year");  //스트링이라 getParameter
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		
		
		
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		//2작업
		Calendar cal = Calendar.getInstance();
		
		cal.set(yyyy, mm-1, dd);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //1:일요일, 2:월요일
		char yoil = " 일월화수목금토".charAt(dayOfWeek);
		
		//출력
		response.setContentType("text/html"); //text이고 html 형식이다
		response.setCharacterEncoding("utf-8"); //text의 인코딩이 뭔지 알려줌 없으면 한글깨짐
		PrintWriter out = response.getWriter(); //response 객체에서 브라우져로의 출력 스트림을 얻는다.
		//브라우저에 결과를 찍히게 하려면 out. 
		out.println(year + "년 " + month + "월 "+day+ "일은");
		out.println(yoil+"요일입니다");
		
		//all Concern 관심사 해야할 작업
		//oop 5대 설계원칙 SOLID
		//SRP - 단일 책임 원칙 하나의 메서드는 하나의 책임만 진다
		//관심사의 분리, 변하는 것(Common)과 자주 변하지 않는것(uncommon) 분리, 공통코드 분리
	}

}
