package com.fastcampus.ch2;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;

public class MethodInfo {
	public static void main(String[] args) throws Exception{

		//1.YoilTellerŬ���� ��ü����
		Class clazz = Class.forName("com.fastcampus.ch2.YoilTellerMVC"); //�ش� ������ �޼��� ������ ������
																	
		Object obj = clazz.newInstance();
		
		//2.yoilteller�Ǹ�� �޼��� ������ �����ͼ��迭�� ����
		Method[] methodArr = clazz.getDeclaredMethods();
		
		
		for(Method m : methodArr) {
			String name = m.getName(); //YoilTeller�� �޼��� �̸�
			Parameter[] paramArr = m.getParameters();//�Ű����� ���
//			Class[] paramTypeArr = m.getParameterTypes();
			Class returnType = m.getReturnType();//��ȯŸ��
			
			
			//������ ���λ� ���̻�
			StringJoiner paramList = new StringJoiner(", ", "(", ")");
			
			for(Parameter param : paramArr) {
				String paramName = param.getName();
				Class  paramType = param.getType();
				
				paramList.add(paramType.getName() + " " + paramName);
				//void main(javax.servlet.http.HttpServletRequest arg0, javax.servlet.http.HttpServletResponse arg1)
				//arg0 arg1 �Ź�ܺм� �̸� ������
				//windows preferences java compiler ��ؿ� store information about~ ������ �����Ͻ� �Ű����� �̸��� ���� 1.8���� ����
				//1.Reflection api �̿�
				//2.class File ���� �д¹�
			}
			
			System.out.printf("%s %s%s%n", returnType.getName(), name, paramList);
		}
	} // main
}