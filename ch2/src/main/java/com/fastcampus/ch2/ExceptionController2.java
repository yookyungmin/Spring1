package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)// 500번 -> 400
class MyException extends RuntimeException{
	MyException(String msg){
		super(msg);
	}
	MyException(){this("");}//기본생성자
} // 사용자 예외
@Controller
public class ExceptionController2 {
	
	//@ExceptionHandler를 쓰면 트라이 캐치 문 제외 가능
	//FileNotFoundException 같이 없는 예외가 발생하면 최고조상인 Exception에 처리하거나 하나의 ExceptionHandler로 두개이상인 예외를 처리하고싶으면 배열로추가
	
	
	
	@RequestMapping("/ex3") 
	public String main() throws Exception {
			throw new MyException("예외가 발생했습니다");  //드래그 우클릭 surround with , try catch block
	
		}

	
	@RequestMapping("/ex4")
	public String main2() throws Exception {
	
			throw new FileNotFoundException("예외가 발생했습니다");  //드래그 우클릭 surround with , try catch block

		}
	

	}


