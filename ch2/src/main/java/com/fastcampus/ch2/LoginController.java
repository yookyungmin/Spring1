package com.fastcampus.ch2;
//스프링 프로젝트만들ㅇ면 기본으로 만들어지는 컨트롤러인데,
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//1세션을 종료
		session.invalidate();
		//2홈으로 이동
		return "redirect:/";
	}
	@PostMapping("/login")
	public String login(@CookieValue("id")String cookieId, String id, String pwd, String toURL, boolean rememberId, HttpServletRequest request, HttpServletResponse response)throws Exception{
	
		//1. id와 pwd를 확인'
		if(!loginCheck(id,pwd)) {
			//2-1일치하지않으면 loginForm으로 이동
			String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다", "utf-8");  
			
			return "redirect:/login/login?msg="+msg;  //get으로감
		}
		
		//2-2. id와 pwd가 일치하면 홈으로 이동
		//세션 객체를얻어오기
		HttpSession session = request.getSession();
		//세션 객체에 id를저장
		session.setAttribute("id", id);  //home, board 게시판 한번 로그인만으로 이동가능해짐
		if(rememberId) {//true면 아이디기억체크하면 cookie를 생성
			//1. 쿠키를 생성, 
			Cookie cookie = new Cookie("id", id);// ctrl+shift+o 자동 import문 추가
			//2,응답에 저장, 
			response.addCookie(cookie);
			
		}else { //거짓이면 아이디기억 체크박스 체크안하면 삭제
			Cookie cookie = new Cookie("id", id);// ctrl+shift+o 자동 import문 추가
			cookie.setMaxAge(0); // 유효기간 0으로하면 쿠키 삭제
		}
		//3홈으로 이동
		toURL=toURL==null || toURL.equals("") ? "/" : toURL; //toURL이 null이거나 toURL이 빈문자열이면 home가게 그렇지않으면 toURL 자신으로가게
		return "redirect:"+toURL;
	}


	private boolean loginCheck(String id, String pwd) {

		return "asdf".equals(id) && "1234".equals(pwd);
	}
	
	
}
