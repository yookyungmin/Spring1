package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//Dispatcher Servlet - ���� �մܿ��� HTTP �������� ������ ��� ��û�� ������� �޾� ������ ��Ʈ�ѷ��� �������ִ� ����Ʈ��Ʈ�ѷ�

@Controller

//�� ���� �Է��ϸ� �ش� ��¥�� � �������� �˷��ִ����α׷�
public class YoilTellerMVC { //http://localhost:8000/ch2/getYoilMVC?year=2021&month=10&day=1
	@RequestMapping("/getYoilMVC")
//	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException{
	public String main(int year, int month, int day, Model model) throws IOException{
		//�Ѱܹ����͵��� �Ű������� ����
		//VIEW �̸��� ���ڿ��̶� ��ȯŸ�� �޼����̸��� String���� view�̸��� ��ȯ
		//���ϰ� �� ����� void���ϸ� @RequestMapping("/getYoilMVC") ���ε�url���ܾ���̸�
		
		
		
		
		//1�Է�
//		String year = request.getParameter("year");  //��Ʈ���̶� getParameter
//		String month = request.getParameter("month");
//		String day = request.getParameter("day");
//		int yyyy = Integer.parseInt(year);
//		int mm = Integer.parseInt(month);
//		int dd = Integer.parseInt(day); //���� String���� int�� ����⋚���� ����
		//=========================== �Էºκ��� ��������
		
		//1. ��ȿ���˻�
		if(!isValid(year, month, day))  //isvalid� �����־ false�ε� !�پ��⶧���� Ʈ��� �Ǿ�yoilError ���
		//isvalid ��ȯ���� true�� ���⼭�� ! ������ false�� yoilError��� �ȵ�
			return "yoilError";
		
		//2. ���� ���
		char yoil = getYoil(year, month, day);
		//3.����� �۾� ����� model�� ����
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);
		
		return "yoil"; //Web-INF/ VIEWS/yoil.JSP
		//VIEW �̸��� ���ڿ��̶� ��ȯŸ�� �޼����̸��� String����
		//��� ����� ������ view�� �̸��� ��ȯ
		
//		//��� view
//		response.setContentType("text/html"); //text�̰� html �����̴�
//		response.setCharacterEncoding("utf-8"); //text�� ���ڵ��� ���� �˷��� ������ �ѱ۱���
//		PrintWriter out = response.getWriter(); //response ��ü���� ���������� ��� ��Ʈ���� ��´�.
//		//�������� ����� ������ �Ϸ��� out. 
//		out.println("<html>");
//		out.println("<head>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println(year + "�� " + month + "�� "+day+ "����");
//		out.println(yoil+"�����Դϴ�");
//		out.println("</body>");
//		out.println("</html>");
		//��� �κ��� �� ����� ���������� jsp���ϵ��� ����� ��ſ� ��� ����� ������ view�� �̸��� ��ȯ
		
		//all Concern ���ɻ� �ؾ��� �۾�
		//oop 5�� �����Ģ SOLID
		//SRP - ���� å�� ��Ģ �ϳ��� �޼���� �ϳ��� å�Ӹ� ����
		//���ɻ��� �и�, ���ϴ� ��(Common)�� ���� ������ �ʴ°�(uncommon) �и�, �����ڵ� �и�
	}

private boolean isValid(int year, int month, int day) {
	// TODO Auto-generated method stub
//	return false; //����� �־ false //yoilError.jsp ���
	return true;
} //isvalid�޼���

private char getYoil(int year, int month, int day) {
	Calendar cal = Calendar.getInstance();
	cal.set(year, month-1, day);
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //1:�Ͽ���, 2:������
	return " �Ͽ�ȭ�������".charAt(dayOfWeek);
}// �����Ŭ�� - refactor - extract method 
//�޼������ private�� ������ Ŭ���� �ȿ����� ���⋚����

}


//========== ModelAnview�ϰ�� �߾Ⱦ��������� ������


//Dispatcher Servlet - ���� �մܿ��� HTTP �������� ������ ��� ��û�� ������� �޾� ������ ��Ʈ�ѷ��� �������ִ� ����Ʈ��Ʈ�ѷ�

/*@Controller

//�� ���� �Է��ϸ� �ش� ��¥�� � �������� �˷��ִ����α׷�
public class YoilTellerMVC { //http://localhost:8000/ch2/getYoilMVC?year=2021&month=10&day=1
	@RequestMapping("/getYoilMVC")
//	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException{
	public ModelAndView main(int year, int month, int day //model�����ʴ´�
	
	) throws IOException{
	//1.ModelAndView�� �����ϰ�⺻�並 ����
	ModelAndView mv = new ModelAndView();
		mv.setViewName("yoilError");
	 
	 	//2��ȿ���˻�
	 	if(!isValid(year, month, day))
	 	return mv;
	
		//3. ���� ���
		char yoil = getYoil(year, month, day);
		
		//4.����� �۾� ����� model�� ����
		mv.addObject("year", year);
		mv.addObject("month", month);
		mv.addObject("day", day);
		mv.addObject("yoil", yoil);

		//5.����� ������ View�� ����	
		mv.setView("yoil");	
		//6.ModelAndView����ȯ
		return mv;


		
	
	}

private boolean isValid(int year, int month, int day) {
	// TODO Auto-generated method stub
//	return false; //����� �־ false //yoilError.jsp ���
	return true;
} //isvalid�޼���

private char getYoil(int year, int month, int day) {
	Calendar cal = Calendar.getInstance();
	cal.set(year, month-1, day);
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //1:�Ͽ���, 2:������
	return " �Ͽ�ȭ�������".charAt(dayOfWeek);
}// �����Ŭ�� - refactor - extract method 
//�޼������ private�� ������ Ŭ���� �ȿ����� ���⋚����

}
*/
