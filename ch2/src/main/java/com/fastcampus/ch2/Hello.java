package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. ���� ȣ�� ������ ���α׷����� ���
@Controller
public class Hello {
	
		int iv = 10; //�ν��Ͻ� ����
		static int cv =20;// satic ���� 
		///2. url�� �޼��带 ����
		@RequestMapping("/hello")
		
//		public void main() { //�ν��Ͻ� �޼��� iv , cv ��밡��
//			System.out.println("Hello �ν��Ͻ��޼���� ����ϴ°� ����");
//			System.out.println(cv); //ok
////			System.out.println(iv); //ok
	
		//public ��� private��� ���� ������ RequestMapping�� url�� ������ �Ǿ��ִ� ���� �޼��带 �ܺο���ȣ�� �����ϰ�
		//�ϰڴ� ���̶� ���������� ������� ��밡��
		private void main() { 
			System.out.println("Hello private");
			System.out.println(cv); //ok
//			System.out.println(iv); //ok
	}
		public static void main2() { //����ƽ �޼���  - cv�� ��밡��
			System.out.println(cv); //ok
//			System.out.println(iv); //����
		}

}

//public static void main���� �Ⱦ���������? 
//public void main�� �ν��ϸ޼���� ��ü ������ ȣ���� �Ǵµ� ��Ĺ�� 
//��ü������ �ڵ����� ���ֱ⿡ static ���ܰ��� public void main���� ���°�����
