package com.cos.blog.test;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




/*@RestController*/
@Controller
public class HttpControllerTest {
	//사용자 요청 -> 응답 (HTML파일: @Controller)
	//사용자 요청 -> 응답 (Data: @RestController)
	
	@GetMapping("/temp/home")
	public String tmpHome() {
		return "/home.html";
	}
	@GetMapping("/temp/test")
	public String tmpTest() {
		return "test";
	}
	
	
	@GetMapping("/http/lombok") //client가 request요청을 하면 method메소드 실행
	//method execute when client request
	public String lombokTest() {
		Member m = Member.builder().username("kim").password("1234").email("email").build();
		System.out.println("getter : "+m.getUsername());
		m.setUsername("yu");
		System.out.println("setter : "+m.getUsername());
		return "lombok test 완료";
	}

	//http://localhost:8007/http/get(select)
	@GetMapping("/http/get")  //url은 get방식
	public String getTest(Member m) {
		return "get 요청"+m.getId()+" "+m.getUsername();//Member에서 자동매칭
	}
	
	//http://localhost:8007/http/post(insert)
	@PostMapping("/http/post") //error 정상
	public String postTest(@RequestBody Member m) {
		return "post 요청  "+m.getId()+"  "+m.getUsername(); 
		
	}
	
	//http://localhost:8007/http/put(update)
	@PutMapping("/http/put")  //error 정상
	public String putTest(@RequestBody Member m) {
		return "put 요청"+m.getId()+" "+m.getUsername()+" "+m.getPassword();
	}
	
	//http://localhost:8007/http/deldete(delete)
	@DeleteMapping("/http/delete")  //error 정상 당연한것
	public String deleteTest(@RequestBody Member m) {
		return "delete 요청"+m.getId()+" "+m.getUsername()+" "+m.getPassword();
	}
}
