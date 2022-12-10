package com.cos.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.Users;

//JSP의 DAO
//자동으로 Bean 등록이 된다.
//@Repository 생략가능
public interface UserRepository extends JpaRepository<Users,Integer> { //상속안하면 Repository를 쓸수없다
	
	/* security lib 사용//header
	 * //로그인을위한 함수 //JPA Naming 전략 //select * from users where username=? AND
	 * password=?; Users findByUsernameAndPassword(String username, String
	 * password);
	 */
	
	//위랑 같음
	//@Query(value="select * from users where username=?1
	//AND password=?2",nativeQuery=true)
	//User login(String username, String password);
	
	//select * from users where username=?;
	Optional<Users> findByUsername(String username);
}
