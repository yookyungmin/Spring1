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
		//1HTTP 요청할떄 제공된 값을 얻기위해 사용되는것이 request.getParameter()
		//request.getParametrMap();
		Map map = new HashMap();
		map.put("year", "2021");
		map.put("month", "10");
		map.put("day", "1");
		

		
		Model model = null;
		Class clazz = Class.forName("com.fastcampus.ch2.YoilTellerMVC"); //	// YoilTellerMvc 객체를 생성
		Object obj  = clazz.newInstance();
		
		// YoilTellerMVC.main(int year, int month, int day, Model model) 
		Method main = clazz.getDeclaredMethod("main", int.class, int.class, int.class, Model.class); //2.main 메서드의 정보를 가져온다.
		//"main" =main(int year, int month, int day, Model)
		//int.class, int.class, int.class, Model.class = 매개변수
		//String viewName = (String)main.invoke(obj, new Object[] { 2021, 10, 1, model });//리플렉션 api 사용 O 객체배열 하드코딩		
		
		
		Parameter[] paramArr = main.getParameters();//main 메서드의 매개변수목록을 가져온다
		
		
		Object[] argArr = new Object[main.getParameterCount()]; //객체 배열을 하드코딩안하고 동적으로 구성(요청할떄 넘어온 값(위에 Map)들을 가지고 객체의 배열생성	 
		// 메인 메서드 매겨변수갯와 같이 길이의 Object 배열생성
		
		for(int i=0;i<paramArr.length;i++) {
			String paramName = paramArr[i].getName(); //파라미터이름하고
			Class  paramType = paramArr[i].getType(); //타입을 읽어옴
			Object value = map.get(paramName); // map에서 못찾으면 value는 null

			// paramType중에 Model이 있으면, 생성 & 저장 
			if(paramType==Model.class) { //타입이 모델이면
				argArr[i] = model = new BindingAwareModelMap(); //모델을 생성해서 넣어줌 
			} else if(value != null) {  // map에 paramName이 있으면, 찾았으면
				// value와 parameter의 타입을 비교해서, 다르면 변환해서 저장  
				argArr[i] = convertTo(value, paramType);		// converTo 타입이 다르면String > int 		
			} 
		} //반복문을 돌면서 argArr을채워주는것  // 이 예제의 핵심
		System.out.println("paramArr="+Arrays.toString(paramArr)); 
		//paramArr=[int year, int month, int day, org.springframework.ui.Model model]
		System.out.println("argArr="+Arrays.toString(argArr));
		//argArr=[2021, 10, 1, {}]
		
		
		// Controller의 main()을 호출 - YoilTellerMVC.main(int year, int month, int day, Model model)
		String viewName = (String)main.invoke(obj, argArr); 	
		System.out.println("viewName="+viewName);	
		
		// Model의 내용을 출력 
		System.out.println("[after] model="+model);
				
		// 텍스트 파일을 이용한 rendering
		render(model, viewName);			
	} // main
	
	private static Object convertTo(Object value, Class type) {
		if(type==null || value==null || type.isInstance(value)) // 타입이 같으면 그대로 반환 //타입이 null이거나 타입이 같으면 그대로반환,
			return value;
		//|| 하나라도 true면 true, && 모두 true면 트루
		

		//Object value(String일때), Class type 매개변수 타입이 int인경우
		// 타입이 다르면, 변환해서 반환
		if(String.class.isInstance(value)&& type == int.class)
		if(String.class.isInstance(value) && type==int.class) { // String -> int
			return Integer.valueOf((String)value); //Integer 타입으로 변환하려면 valueOf, int타입으로 변환이면 parsInt
		} else if(String.class.isInstance(value) && type==double.class) { // String -> double
			return Double.valueOf((String)value);
		}
			
		return value;
	}
	
	private static void render(Model model, String viewName) throws IOException {
		String result = "";
		
		// 1. 뷰의 내용을 한줄씩 읽어서 하나의 문자열로 만든다.
		Scanner sc = new Scanner(new File("src/main/webapp/WEB-INF/views/"+viewName+".jsp"), "utf-8");
		
		while(sc.hasNextLine())
			result += sc.nextLine()+ System.lineSeparator();
		
		// 2. model을 map으로 변환 
		Map map = model.asMap();
		
		// 3.key를 하나씩 읽어서 template의 ${key}를 value바꾼다.
		Iterator it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String key = (String)it.next();

			// 4. replace()로 key를 value 치환한다.
			result = result.replace("${"+key+"}", ""+map.get(key));
		}
		
		// 5.렌더링 결과를 출력한다.
		System.out.println(result);
	}
}