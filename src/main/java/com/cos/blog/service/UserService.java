package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.Users;
import com.cos.blog.repository.UserRepository;

//스프링이 컴표넌트 스캔을 통해서 Bean에 등록을 해준다. 
@Service // 비즈니스 로직
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encodeer;
	

	@Transactional
	public void 회원가입(Users user) {
		/* try { 글로벌익셉션GlobalExceptionHandler.java에서 처리됨 */
		
		//password 해쉬암호화encrypt <-> decrypt
		String rawPassword=user.getPassword(); //원본
		String encPassword=encodeer.encode(rawPassword); //암호화
		user.setPassword(encPassword);
		user.setRoles(RoleType.USER);
		userRepository.save(user); // 하나의 트랙잭션

		/*
		 * }catch(Exception e) { e.printStackTrace();
		 * System.out.println("UserService:회원가입(): "+e.getMessage()); }
		 */
	}

	/* security lib에서 처리 //header
	 * @Transactional(readOnly=true) public Users 로그인(Users user) { try {
	 * 글로벌익셉션GlobalExceptionHandler.java에서 처리됨 return
	 * userRepository.findByUsernameAndPassword(user.getUsername(),
	 * user.getPassword()); //하나의 트랙잭션
	 * 
	 * 
	 * }catch(Exception e) { e.printStackTrace();
	 * System.out.println("UserService:회원가입(): "+e.getMessage()); }
	 * 
	 * }
	 */
	//회우너정보 수정
	@Transactional
	public void 회원수정(Users user) {
		//수정시에는 영속성 컨텍스트 Users오브젝트를 영속화 시키고,
		//여속화된 Users오브젝트를 수정
		//select를 해서 Users오브젝트를DB로 부터 가져오는 이유는 영속화를 하기 위해서 
		Users persistance=userRepository.findById(user.getId()).orElseThrow(()->{
			return new IllegalArgumentException("회웢 찾기 실패");
		});
		String rawPassword=user.getPassword();
		String encPassword=encodeer.encode(rawPassword);
		persistance.setPassword(encPassword);
		persistance.setEmail(user.getEmail());
		
	}
	

}
