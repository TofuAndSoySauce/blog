package com.cos.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //controller는 파일경로 RestController는 리턴을
public class BlogControllerTest {
	@GetMapping("/test/hello")
	public String hello() {
		return "<h1> hello spring boot</h1>";
	}
	/*
	 * @PostMapping("/test/hello") public String hello2(int a) { return
	 * "<h1> hello spring boot</h1>"; }
	 */
}
