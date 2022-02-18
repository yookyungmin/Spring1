package com.fastcampus.ch2;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

//modelcotroller ��� Ŭ�������� �Ű������� map�� �����ϰ� ���� �޼��忡�� �Ű������� map�� �����ؼ� �Ѱ���
//
public class MethodCall {
	public static void main(String[] args) throws Exception{
		HashMap map= new HashMap();
	
		System.out.println("before:"+map); //�������
		
		ModelController mc = new ModelController(); 
		String viewName = mc.main(map);//mc�� ȣ���ؼ� ���θ޼���带 ȣ��
		
		System.out.println("after:"+map);
		
		render(map, viewName); //viewName = "txtView2" //�ؿ� redner �޼ҵ�
	}
	static void render(HashMap map, String viewName) throws IOException{
	 String result = "";	
	 
	 //1.���� ������ ���پ� �о �ϳ��� ���ڿ��� �����.
	 	Scanner sc = new Scanner(new File(viewName+".txt"));
	 	
	 	while(sc.hasNextLine())
	 		result += sc.nextLine()+System.lineSeparator(); // lineSeparator�� ���δٸ� os���� \n���� ���� �ٹٲ� ����� ������ �����ִ°� ����
	
	 //2.map�� ��� key�� �ϳ��� �о template�� $(key)�� value�� �ٲ۴�
	 	Iterator it = map.keySet().iterator(); //keySet key�� ���� ���
	 	
	
	 		while(it.hasNext()) {
	 			String key = (String)it.next();
	 			//3.replace()�� key�� value�� ġȯ�Ѵ�
	 			result = result.replace("${"+key+"}", (String)map.get(key));
	 		}
	 	//4.������ ����� ����Ѵ�
	 	System.out.println(result);
	}
}

class ModelController {
	//�ް������� map������, �׷��� ���θ޼��忡�� map�������ؼ� �Ѱ���
	public String main(HashMap map) {
		//�۾������ map������
		map.put("id", "asdf");
		map.put("pwd","1111");
		return "txtView2"; //���̸��� ��ȯ
	}
}
