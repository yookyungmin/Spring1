package com.fastcampus.ch2;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

public class MethodCall3 {
	public static void main(String[] args) throws Exception{
		//1HTTP ��û�ҋ� ������ ���� ������� ���Ǵ°��� request.getParameter()
		//request.getParametrMap();
		Map map = new HashMap();
		map.put("year", "2021");
		map.put("month", "10");
		map.put("day", "1");
		

		
		Model model = null;
		Class clazz = Class.forName("com.fastcampus.ch2.YoilTellerMVC"); //	// YoilTellerMvc ��ü�� ����
		Object obj  = clazz.newInstance();
		
		// YoilTellerMVC.main(int year, int month, int day, Model model) 
		Method main = clazz.getDeclaredMethod("main", int.class, int.class, int.class, Model.class); //2.main �޼����� ������ �����´�.
		//"main" =main(int year, int month, int day, Model)
		//int.class, int.class, int.class, Model.class = �Ű�����
		//String viewName = (String)main.invoke(obj, new Object[] { 2021, 10, 1, model });//���÷��� api ��� O ��ü�迭 �ϵ��ڵ�		
		
		
		Parameter[] paramArr = main.getParameters();//main �޼����� �Ű���������� �����´�
		
		
		Object[] argArr = new Object[main.getParameterCount()]; //��ü �迭�� �ϵ��ڵ����ϰ� �������� ����(��û�ҋ� �Ѿ�� ��(���� Map)���� ������ ��ü�� �迭����	 
		// ���� �޼��� �Űܺ������� ���� ������ Object �迭����
		
		for(int i=0;i<paramArr.length;i++) {
			String paramName = paramArr[i].getName(); //�Ķ�����̸��ϰ�
			Class  paramType = paramArr[i].getType(); //Ÿ���� �о��
			Object value = map.get(paramName); // map���� ��ã���� value�� null

			// paramType�߿� Model�� ������, ���� & ���� 
			if(paramType==Model.class) { //Ÿ���� ���̸�
				argArr[i] = model = new BindingAwareModelMap(); //���� �����ؼ� �־��� 
			} else if(value != null) {  // map�� paramName�� ������, ã������
				// value�� parameter�� Ÿ���� ���ؼ�, �ٸ��� ��ȯ�ؼ� ����  
				argArr[i] = convertTo(value, paramType);		// converTo Ÿ���� �ٸ���String > int 		
			} 
		} //�ݺ����� ���鼭 argArr��ä���ִ°�  // �� ������ �ٽ�
		System.out.println("paramArr="+Arrays.toString(paramArr)); 
		//paramArr=[int year, int month, int day, org.springframework.ui.Model model]
		System.out.println("argArr="+Arrays.toString(argArr));
		//argArr=[2021, 10, 1, {}]
		
		
		// Controller�� main()�� ȣ�� - YoilTellerMVC.main(int year, int month, int day, Model model)
		String viewName = (String)main.invoke(obj, argArr); 	
		System.out.println("viewName="+viewName);	
		
		// Model�� ������ ��� 
		System.out.println("[after] model="+model);
				
		// �ؽ�Ʈ ������ �̿��� rendering
		render(model, viewName);			
	} // main
	
	private static Object convertTo(Object value, Class type) {
		if(type==null || value==null || type.isInstance(value)) // Ÿ���� ������ �״�� ��ȯ //Ÿ���� null�̰ų� Ÿ���� ������ �״�ι�ȯ,
			return value;
		//|| �ϳ��� true�� true, && ��� true�� Ʈ��
		

		//Object value(String�϶�), Class type �Ű����� Ÿ���� int�ΰ��
		// Ÿ���� �ٸ���, ��ȯ�ؼ� ��ȯ
		if(String.class.isInstance(value)&& type == int.class)
		if(String.class.isInstance(value) && type==int.class) { // String -> int
			return Integer.valueOf((String)value); //Integer Ÿ������ ��ȯ�Ϸ��� valueOf, intŸ������ ��ȯ�̸� parsInt
		} else if(String.class.isInstance(value) && type==double.class) { // String -> double
			return Double.valueOf((String)value);
		}
			
		return value;
	}
	
	private static void render(Model model, String viewName) throws IOException {
		String result = "";
		
		// 1. ���� ������ ���پ� �о �ϳ��� ���ڿ��� �����.
		Scanner sc = new Scanner(new File("src/main/webapp/WEB-INF/views/"+viewName+".jsp"), "utf-8");
		
		while(sc.hasNextLine())
			result += sc.nextLine()+ System.lineSeparator();
		
		// 2. model�� map���� ��ȯ 
		Map map = model.asMap();
		
		// 3.key�� �ϳ��� �о template�� ${key}�� value�ٲ۴�.
		Iterator it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String key = (String)it.next();

			// 4. replace()�� key�� value ġȯ�Ѵ�.
			result = result.replace("${"+key+"}", ""+map.get(key));
		}
		
		// 5.������ ����� ����Ѵ�.
		System.out.println(result);
	}
}