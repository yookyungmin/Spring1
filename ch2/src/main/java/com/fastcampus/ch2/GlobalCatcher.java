package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.fastcampus.ch3") //지정된 패키지에서만 발생한 예외처리
//@ControllerAdvice// 모든 컨트롤러에서 발생하는 예외를처리
public class GlobalCatcher {
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
	@ExceptionHandler(Exception.class)//A에 대한 예외처리 ,, 위에 예외처리 배열로 두개이상 안되어 있으면 FileNotFound가 최고조상인 Exception에서 처리가능
	public String catcher(Exception ex, Model m) {
		m.addAttribute("ex",ex);
		return "error";
	
	}
}
