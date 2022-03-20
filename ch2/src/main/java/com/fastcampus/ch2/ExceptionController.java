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
	
	//@ExceptionHandler�� ���� Ʈ���� ĳġ �� ���� ���� ,, controller������ ��� ����
	//FileNotFoundException ���� ���� ���ܰ� �߻��ϸ� �ְ������� Exception�� ó���ϰų� �ϳ��� ExceptionHandler�� �ΰ��̻��� ���ܸ� ó���ϰ������ �迭���߰�
	
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class}) //B, c ������ ����ó��
	
	public String catcher2(Exception ex, Model m) { //�߻��� ���ܸ� view�� �����ַ��� Model �����ϰ� Model�� ��Ƽ� view �� ����
		m.addAttribute("ex",ex);
		return "error";
	}
	@ExceptionHandler(Exception.class)//A�� ���� ����ó�� ,, ���� ����ó�� �迭�� �ΰ��̻� �ȵǾ� ������ FileNotFound�� �ְ������� Exception���� ó������
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //200 > 500������
	public String catcher(Exception ex, Model m) {
		System.out.println("m="+m);
		System.out.println("catcher() in ExceptionController");
//		m.addAttribute("ex",ex);
		return "error";
	
	}
	
	@RequestMapping("/ex") //A
	public String main(Model m) throws Exception {
		m.addAttribute("msg", "message from ExceptionController.main()");
			throw new Exception("���ܰ� �߻��߽��ϴ�");  //�巡�� ��Ŭ�� surround with , try catch block
	
		}

	
	@RequestMapping("/ex2")//B
	public String main2() throws Exception {
	
			throw new NullPointerException("���ܰ� �߻��߽��ϴ�");  //�巡�� ��Ŭ�� surround with , try catch block

		}
	
//	@RequestMapping("/ex3")//c
//	public String main3() throws Exception{
//		throw new FileNotFoundException("���ܰ� �߻��߽��ϴ�");
//	}

	}


