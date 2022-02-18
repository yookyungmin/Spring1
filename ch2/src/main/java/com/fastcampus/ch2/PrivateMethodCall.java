package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {
	public static void main(String[] args) throws Exception {
//		Hello hello = new Hello();
//		hello.main(); //private�� �ܺ�ȣ��Ұ�
		
		//Reflection API�� ��� -Ŭ���� ������ ��� �ٷ�� �ִ� ������ ������� !!!
		//java.lang.reflect ��Ű���� ���� !!
		
		//Hello Ŭ������ Class��ü(Ŭ���� ������ ����ִ´�ü)�� ���´�
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");//��Ű���� �Է�
		Hello hello = (Hello)helloClass.newInstance(); //Class ��ü�� ���������� ��ü ����
		
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true); //Private�� main(ȣ�Ⱑ���ϰ� �Ѵ�)
		
		main.invoke(hello); //hello.main()
	}
}

//Relfection API�� ����ؼ� Ŭ���� ������ ��� private�� �� �����Լ��� ȣ�� �����ϰԵ� // 
//���¹� ���ʿ���� Relflection api�� �ٸ������� ���̾�
