package com.cos.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {
// class BoardController 랑 충돌가능
	/*
	 * @GetMapping({"","/"}) public String index() { return "index"; } 이거랑 충돌나니  한번만
	 * 서블렛에서 충돌나듯이 
	 */
	
	//인증이 필요없는 곳에 /auth 븥인다.
	@GetMapping("/auth/joinForm") //header url와 멥핑.요청받을 url /user/login//메소드맵핑
	public String joinForm() {
		return "user/joinForm";
	}
	
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
	@GetMapping("/user/updateForm")
	public String updateForm() {
		return "user/updateForm";
	}
}
