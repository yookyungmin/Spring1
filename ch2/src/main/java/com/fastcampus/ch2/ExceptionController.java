package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionController {
	
	//@ExceptionHandler를 쓰면 트라이 캐치 문 제외 가능 ,, controller에서만 사용 가능
	//FileNotFoundException 같이 없는 예외가 발생하면 최고조상인 Exception에 처리하거나 하나의 ExceptionHandler로 두개이상인 예외를 처리하고싶으면 배열로추가
	
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class}) //B, c 에대한 예외처리
	
	public String catcher2(Exception ex, Model m) { //발생한 예외를 view에 보내주려면 Model 선언하고 Model에 담아서 view 에 전달
		m.addAttribute("ex",ex);
		return "error";
	}
	@ExceptionHandler(Exception.class)//A에 대한 예외처리 ,, 위에 예외처리 배열로 두개이상 안되어 있으면 FileNotFound가 최고조상인 Exception에서 처리가능
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //200 > 500에러로
	public String catcher(Exception ex, Model m) {
		System.out.println("m="+m);
		System.out.println("catcher() in ExceptionController");
//		m.addAttribute("ex",ex);
		return "error";
	
	}
	
	@RequestMapping("/ex") //A
	public String main(Model m) throws Exception {
		m.addAttribute("msg", "message from ExceptionController.main()");
			throw new Exception("예외가 발생했습니다");  //드래그 우클릭 surround with , try catch block
	
		}

	
	@RequestMapping("/ex2")//B
	public String main2() throws Exception {
	
			throw new NullPointerException("예외가 발생했습니다");  //드래그 우클릭 surround with , try catch block

		}
	
//	@RequestMapping("/ex3")//c
//	public String main3() throws Exception{
//		throw new FileNotFoundException("예외가 발생했습니다");
//	}

	}


