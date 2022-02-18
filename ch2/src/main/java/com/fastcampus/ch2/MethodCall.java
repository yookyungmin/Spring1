package com.fastcampus.ch2;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

//modelcotroller 라는 클래스에서 매개변수로 map을 선언하고 메인 메서드에서 매개변수로 map을 생성해서 넘겨줌
//
public class MethodCall {
	public static void main(String[] args) throws Exception{
		HashMap map= new HashMap();
	
		System.out.println("before:"+map); //비어있음
		
		ModelController mc = new ModelController(); 
		String viewName = mc.main(map);//mc를 호출해서 메인메서드드를 호출
		
		System.out.println("after:"+map);
		
		render(map, viewName); //viewName = "txtView2" //밑에 redner 메소드
	}
	static void render(HashMap map, String viewName) throws IOException{
	 String result = "";	
	 
	 //1.뷰의 내용을 한줄씩 읽어서 하나의 문자열로 만든다.
	 	Scanner sc = new Scanner(new File(viewName+".txt"));
	 	
	 	while(sc.hasNextLine())
	 		result += sc.nextLine()+System.lineSeparator(); // lineSeparator은 서로다른 os에서 \n으로 개행 줄바꿈 실행시 오류가 날수있는걸 방지
	
	 //2.map에 담긴 key를 하나씩 읽어서 template의 $(key)를 value로 바꾼다
	 	Iterator it = map.keySet().iterator(); //keySet key의 값만 출력
	 	
	
	 		while(it.hasNext()) {
	 			String key = (String)it.next();
	 			//3.replace()로 key를 value로 치환한다
	 			result = result.replace("${"+key+"}", (String)map.get(key));
	 		}
	 	//4.렌더링 결괄르 출력한다
	 	System.out.println(result);
	}
}

class ModelController {
	//메개변수로 map을생성, 그러면 메인메서드에서 map을생성해서 넘겨줌
	public String main(HashMap map) {
		//작업결과를 map에저장
		map.put("id", "asdf");
		map.put("pwd","1111");
		return "txtView2"; //뷰이름을 반환
	}
}
