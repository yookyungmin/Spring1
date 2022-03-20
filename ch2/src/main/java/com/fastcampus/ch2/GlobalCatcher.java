package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.fastcampus.ch3") //������ ��Ű�������� �߻��� ����ó��
//@ControllerAdvice// ��� ��Ʈ�ѷ����� �߻��ϴ� ���ܸ�ó��
public class GlobalCatcher {
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
	@ExceptionHandler(Exception.class)//A�� ���� ����ó�� ,, ���� ����ó�� �迭�� �ΰ��̻� �ȵǾ� ������ FileNotFound�� �ְ������� Exception���� ó������
	public String catcher(Exception ex, Model m) {
		m.addAttribute("ex",ex);
		return "error";
	
	}
}
