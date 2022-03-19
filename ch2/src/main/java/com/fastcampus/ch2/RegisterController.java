package com.fastcampus.ch2;

import java.io.Writer;
import java.net.URLEncoder;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class RegisterController {
	

	
	@RequestMapping(value="/register/add", method={RequestMethod.GET, RequestMethod.POST})//GET��û POST��û �Ѵٹ���������
	public String register() {
		return "registerForm"; //web-inf/views/registerForm.jsp
	}  
	//<view-consdtroller path="/register/add" view-name="registerForm"/> servlet context.xml�� �߰��ؼ� ��ü
	
	
	
//	@RequestMapping("/register/save", method=RequestMethod.post) //get������� �ϴ°� ����//PostMapping���� ����ȭ
	//http://localhost:8000/ch2/register/save?id=asdf&pwd=1234&name=aaaa <--�ٹ��
	@PostMapping("/register/save")//4.3���� //post���
	public String save(User user, Model m) throws Exception{
		//1. ��ȿ�� �˻�
		if(!isValid(user)) { //��ȿ���� ������
			String msg = URLEncoder.encode("id�� �߸��Է��ϼ̽��ϴ�","utf-8");
			
			m.addAttribute("msg", msg); //model �� ����
//			return "redirect:/register/add"; //
		return "forward:/register/add"; //����Ʈ�� ��û�� �ѹ��ۿ� �ȵǱ� ������ ������ ����Ʈ, �� ��û �� ������ �ְ� ����
//			return "redirect:/register/add?msg="+msg; //URL ���ۼ�(rewriting) //���� ���ٰ� ����	redirect = ���û	
		
			}
		//2 DB�� �ű�ȸ�� ������ ���� //��ȿ�ϸ�
		return "registerInfo";
	}
	
	private boolean isValid(User user) {
	
		return false;
	}

//////////////////
	@RequestMapping("register/test")
	public String test() {
		return "test";
	}
	@RequestMapping("register/test2")
	public String test2() {
		return "tes2";
	}
}
