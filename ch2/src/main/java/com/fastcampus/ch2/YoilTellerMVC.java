package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//Dispatcher Servlet - 가장 앞단에서 HTTP 프로토콜 들어오는 모든 요청을 가장먼저 받아 적합한 컨트롤러에 위임해주는 프론트컨트롤러

@Controller

//년 요일 입력하면 해당 날짜가 어떤 요일인지 알려주는프로그램
public class YoilTellerMVC { //http://localhost:8000/ch2/getYoilMVC?year=2021&month=10&day=1
	@RequestMapping("/getYoilMVC")
//	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException{
	public String main(int year, int month, int day, Model model) throws IOException{
		//넘겨받을것들은 매개변수로 선언
		//VIEW 이름이 문자열이라서 반환타입 메서드이름을 String으로 view이름을 반환
		//리턴값 다 지우고 void로하면 @RequestMapping("/getYoilMVC") 맵핑된url끝단어가뷰이름
		
		
		
		
		//1입력
//		String year = request.getParameter("year");  //스트링이라 getParameter
//		String month = request.getParameter("month");
//		String day = request.getParameter("day");
//		int yyyy = Integer.parseInt(year);
//		int mm = Integer.parseInt(month);
//		int dd = Integer.parseInt(day); //위에 String에서 int로 해줬기떄문에 생략
		//=========================== 입력부분은 지워도됨
		
		//1. 유효성검사
		if(!isValid(year, month, day))  //isvalid어떤 값을넣어도 false인데 !붙었기때문에 트루로 되어yoilError 출력
		//isvalid 반환값이 true면 여기서는 ! 떄문에 false라 yoilError출력 안됨
			return "yoilError";
		
		//2. 요일 계싼
		char yoil = getYoil(year, month, day);
		//3.계산한 작업 결과를 model에 저장
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);
		
		return "yoil"; //Web-INF/ VIEWS/yoil.JSP
		//VIEW 이름이 문자열이라서 반환타입 메서드이름을 String으로
		//출력 결과를 보여줄 view의 이름을 반환
		
//		//출력 view
//		response.setContentType("text/html"); //text이고 html 형식이다
//		response.setCharacterEncoding("utf-8"); //text의 인코딩이 뭔지 알려줌 없으면 한글깨짐
//		PrintWriter out = response.getWriter(); //response 객체에서 브라우져로의 출력 스트림을 얻는다.
//		//브라우저에 결과를 찍히게 하려면 out. 
//		out.println("<html>");
//		out.println("<head>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println(year + "년 " + month + "월 "+day+ "일은");
//		out.println(yoil+"요일입니다");
//		out.println("</body>");
//		out.println("</html>");
		//출력 부분은 위 내용과 같은내용의 jsp파일들을 만들고 대신에 출력 결과를 보여줄 view의 이름을 반환
		
		//all Concern 관심사 해야할 작업
		//oop 5대 설계원칙 SOLID
		//SRP - 단일 책임 원칙 하나의 메서드는 하나의 책임만 진다
		//관심사의 분리, 변하는 것(Common)과 자주 변하지 않는것(uncommon) 분리, 공통코드 분리
	}

private boolean isValid(int year, int month, int day) {
	// TODO Auto-generated method stub
//	return false; //어떤값을 넣어도 false //yoilError.jsp 출력
	return true;
} //isvalid메서드

private char getYoil(int year, int month, int day) {
	Calendar cal = Calendar.getInstance();
	cal.set(year, month-1, day);
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //1:일요일, 2:월요일
	return " 일월화수목금토".charAt(dayOfWeek);
}// 내용우클릭 - refactor - extract method 
//메서드들이 private인 이유는 클래스 안에서만 쓰기떄문에

}


//========== ModelAnview일경우 잘안쓰긴하지만 뭔지만


//Dispatcher Servlet - 가장 앞단에서 HTTP 프로토콜 들어오는 모든 요청을 가장먼저 받아 적합한 컨트롤러에 위임해주는 프론트컨트롤러

/*@Controller

//년 요일 입력하면 해당 날짜가 어떤 요일인지 알려주는프로그램
public class YoilTellerMVC { //http://localhost:8000/ch2/getYoilMVC?year=2021&month=10&day=1
	@RequestMapping("/getYoilMVC")
//	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException{
	public ModelAndView main(int year, int month, int day //model받지않는다
	
	) throws IOException{
	//1.ModelAndView를 생성하고기본뷰를 지정
	ModelAndView mv = new ModelAndView();
		mv.setViewName("yoilError");
	 
	 	//2유효성검사
	 	if(!isValid(year, month, day))
	 	return mv;
	
		//3. 요일 계싼
		char yoil = getYoil(year, month, day);
		
		//4.계산한 작업 결과를 model에 저장
		mv.addObject("year", year);
		mv.addObject("month", month);
		mv.addObject("day", day);
		mv.addObject("yoil", yoil);

		//5.결과를 보여줄 View를 지정	
		mv.setView("yoil");	
		//6.ModelAndView를반환
		return mv;


		
	
	}

private boolean isValid(int year, int month, int day) {
	// TODO Auto-generated method stub
//	return false; //어떤값을 넣어도 false //yoilError.jsp 출력
	return true;
} //isvalid메서드

private char getYoil(int year, int month, int day) {
	Calendar cal = Calendar.getInstance();
	cal.set(year, month-1, day);
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //1:일요일, 2:월요일
	return " 일월화수목금토".charAt(dayOfWeek);
}// 내용우클릭 - refactor - extract method 
//메서드들이 private인 이유는 클래스 안에서만 쓰기떄문에

}
*/
