package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name="users") //테이블생성
@Data
@NoArgsConstructor //빈생성자
@AllArgsConstructor //모든필드 생성자
@Builder //빌터 패턴

//ORAM ->언어드링 Object를 테이블로 매핑해주는 기술
@Entity //users 클래스가 자동으로 db에 테이블 생성
@SequenceGenerator(  //시퀀스 생성
		name="USER_SEQ_GENERATOR"
		, sequenceName = "USER_SEQ"
		, initialValue = 1
		, allocationSize = 1
		)


public class Users {
	@Id//primary key
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_SEQ_GENERATOR")
	//프로젝트에 연결된 DB의 넘버링 전략을 사용
	private int id; //시퀀스 칼럼

	@Column(nullable=false,length=30,unique=true) //not null
	private String username; //아이디 칼럼
	
	@Column(nullable=false,length=100) //해쉬로 변경하여 암호화. length를 크게
	private String password; //비밀번호 암호화 전.
	
	@Column(nullable=false,length=50)
	private String email; //이메일

	@Enumerated(EnumType.STRING) //Enum - 도메인 사용해야하면. 실습용으론 x. 프로젝트용
	/* @ColumnDefault("'user'") */ //적용 안되었다.
	private RoleType roles;
//예) admin, user, manager 권한 셋중에 하나만
	@CreationTimestamp
	private Timestamp createDate;
}
