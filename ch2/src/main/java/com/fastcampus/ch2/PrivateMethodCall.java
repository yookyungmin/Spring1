package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {
	public static void main(String[] args) throws Exception {
//		Hello hello = new Hello();
//		hello.main(); //private라서 외부호출불가
		
		//Reflection API를 사용 -클래스 정보를 얻고 다룰수 있는 강력한 기능제공 !!!
		//java.lang.reflect 패키지를 제공 !!
		
		//Hello 클래스의 Class객체(클래스 정보를 담고있는댁체)를 얻어온다
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");//패키지명 입력
		Hello hello = (Hello)helloClass.newInstance(); //Class 객체가 가진정보로 객체 생성
		
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true); //Private인 main(호출가능하게 한다)
		
		main.invoke(hello); //hello.main()
	}
}

//Relfection API를 사용해서 클래스 정보를 얻어 private로 된 메인함수도 호출 가능하게됨 // 
//쓰는법 알필요없고 Relflection api를 다른곳에서 많이씀
