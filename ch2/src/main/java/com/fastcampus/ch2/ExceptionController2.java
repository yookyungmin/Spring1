package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)// 500�� -> 400
class MyException extends RuntimeException{
	MyException(String msg){
		super(msg);
	}
	MyException(){this("");}//�⺻������
} // ����� ����
@Controller
public class ExceptionController2 {
	
	//@ExceptionHandler�� ���� Ʈ���� ĳġ �� ���� ����
	//FileNotFoundException ���� ���� ���ܰ� �߻��ϸ� �ְ������� Exception�� ó���ϰų� �ϳ��� ExceptionHandler�� �ΰ��̻��� ���ܸ� ó���ϰ������ �迭���߰�
	
	
	
	@RequestMapping("/ex3") 
	public String main() throws Exception {
			throw new MyException("���ܰ� �߻��߽��ϴ�");  //�巡�� ��Ŭ�� surround with , try catch block
	
		}

	
	@RequestMapping("/ex4")
	public String main2() throws Exception {
	
			throw new FileNotFoundException("���ܰ� �߻��߽��ϴ�");  //�巡�� ��Ŭ�� surround with , try catch block

		}
	

	}


