package com.fastcampus.ch2;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;

public class MethodInfo {
	public static void main(String[] args) throws Exception{

		//1.YoilTeller클래스 객체생성
		Class clazz = Class.forName("com.fastcampus.ch2.YoilTellerMVC"); //해당 파일의 메서드 정보를 보여줌
																	
		Object obj = clazz.newInstance();
		
		//2.yoilteller의모든 메서드 정보를 가져와서배열에 저장
		Method[] methodArr = clazz.getDeclaredMethods();
		
		
		for(Method m : methodArr) {
			String name = m.getName(); //YoilTeller의 메서드 이름
			Parameter[] paramArr = m.getParameters();//매개변수 목록
//			Class[] paramTypeArr = m.getParameterTypes();
			Class returnType = m.getReturnType();//반환타입
			
			
			//구분자 접두사 접미사
			StringJoiner paramList = new StringJoiner(", ", "(", ")");
			
			for(Parameter param : paramArr) {
				String paramName = param.getName();
				Class  paramType = param.getType();
				
				paramList.add(paramType.getName() + " " + paramName);
				//void main(javax.servlet.http.HttpServletRequest arg0, javax.servlet.http.HttpServletResponse arg1)
				//arg0 arg1 매배겨분수 이름 얻어오기
				//windows preferences java compiler 멘밑에 store information about~ 누르면 컴파일시 매개변수 이름을 저장 1.8부터 가능
				//1.Reflection api 이용
				//2.class File 직접 읽는법
			}
			
			System.out.printf("%s %s%s%n", returnType.getName(), name, paramList);
		}
	} // main
}