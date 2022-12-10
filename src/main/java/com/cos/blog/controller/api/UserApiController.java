package com.cos.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;
/*import com.cos.blog.model.RoleType;*/
import com.cos.blog.model.Users;
import com.cos.blog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired //의존성 주입
	private UserService userService; 
	
	/*
	 * public int save(@RequestBody Users user) {
	 * System.out.println("UserApiController 호출됨"); return 1; }
	 */
	@PostMapping("/auth/joinProc") //회원가입 로직 실행
	public ResponseDto<Integer> save(@RequestBody Users user){
		System.out.println("UserApiController 호출됨");
		
		
		 //받아온 값은 username, password, email만 있다 
		// user.setRoles(RoleType.USER); //UserService.java - 회원가입(Users user);
		 
		
		//실제로 DB에 insert를 하고 아래에서 (1자리에) return 된다.
		userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
		//성공시 1리턴, 실패시 -1리턴 status코드404..200은 ok.
		//자바오브젝트를 리턴받음		
	}
	
	/* 스프링 시큐리티 태그를 이용하여 이미 처리하였다.
	 * @PostMapping("/api/user/login")//로그인 로직이 실행되는 부분 public ResponseDto<Integer>
	 * login(@RequestBody Users user, HttpSession session){
	 * System.out.println("UserApiController : login 호출됨."); Users principal =
	 * userService.로그인(user); System.out.println("principal : "+principal);
	 * 
	 * //principal 접근주체 if(principal != null) { session.setAttribute("principal",
	 * principal); return new ResponseDto<Integer>(HttpStatus.OK.value(),1); }else {
	 * return new ResponseDto<Integer>(HttpStatus.OK.value(),-1); } //result가 1이면 성공
	 * -1이면 실패 //자바 오브젝트를 리턴받아옴. }
	 */
	
	//회원정보 수정
	@PutMapping("/user") //user.js ajax에서 넘어온
	public ResponseDto<Integer> update(@RequestBody Users user){
		//json 형태를 받기 위한 RequstBody
		userService.회원수정(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	
	
}
