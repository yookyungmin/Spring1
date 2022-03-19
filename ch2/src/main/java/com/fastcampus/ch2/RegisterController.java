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
	

	
	@RequestMapping(value="/register/add", method={RequestMethod.GET, RequestMethod.POST})//GET요청 POST요청 둘다받을수있음
	public String register() {
		return "registerForm"; //web-inf/views/registerForm.jsp
	}  
	//<view-consdtroller path="/register/add" view-name="registerForm"/> servlet context.xml에 추가해서 대체
	
	
	
//	@RequestMapping("/register/save", method=RequestMethod.post) //get방식으로 하는걸 방지//PostMapping으로 간소화
	//http://localhost:8000/ch2/register/save?id=asdf&pwd=1234&name=aaaa <--겟방식
	@PostMapping("/register/save")//4.3부터 //post방식
	public String save(User user, Model m) throws Exception{
		//1. 유효성 검사
		if(!isValid(user)) { //유효하지 않으면
			String msg = URLEncoder.encode("id를 잘못입력하셨습니다","utf-8");
			
			m.addAttribute("msg", msg); //model 에 저장
//			return "redirect:/register/add"; //
		return "forward:/register/add"; //포스트로 요청이 한번밖에 안되기 떄문에 위에서 포스트, 겟 요청 다 받을수 있게 수정
//			return "redirect:/register/add?msg="+msg; //URL 재작성(rewriting) //위에 두줄과 동일	redirect = 재요청	
		
			}
		//2 DB에 신규회원 정보를 저장 //유효하면
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
