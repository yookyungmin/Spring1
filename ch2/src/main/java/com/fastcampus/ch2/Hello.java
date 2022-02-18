package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. 원격 호출 가능한 프로그램으로 등록
@Controller
public class Hello {
	
		int iv = 10; //인스턴스 변수
		static int cv =20;// satic 변수 
		///2. url과 메서드를 연결
		@RequestMapping("/hello")
		
//		public void main() { //인스턴스 메서드 iv , cv 사용가능
//			System.out.println("Hello 인스턴스메서드로 사용하는게 좋음");
//			System.out.println(cv); //ok
////			System.out.println(iv); //ok
	
		//public 대신 private사용 가능 이유는 RequestMapping이 url과 연결이 되어있단 얘기는 메서드를 외부에서호출 가능하게
		//하겠단 뜻이라 접근제어자 상관없이 사용가능
		private void main() { 
			System.out.println("Hello private");
			System.out.println(cv); //ok
//			System.out.println(iv); //ok
	}
		public static void main2() { //스태틱 메서드  - cv만 사용가능
			System.out.println(cv); //ok
//			System.out.println(iv); //에러
		}

}

//public static void main으로 안쓰는이유는? 
//public void main은 인스턴메서드라 객체 생성후 호출이 되는데 톰캣이 
//객체생성을 자동으로 해주기에 static 제외가능 public void main으로 쓰는게좋음
