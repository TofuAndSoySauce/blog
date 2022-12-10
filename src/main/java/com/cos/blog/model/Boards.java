package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="boards")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //빌더패턴
@Entity
@SequenceGenerator(
		name = "USER_SEQ_GENERATOR2"
		, sequenceName = "USER_SEQ2"
		, initialValue = 1
		, allocationSize = 1
		)

public class Boards {
	@Id //기본키
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="USER_SEQ_GENERATOR2")
	private int id;
	
	@Column(nullable=false,length=100)
	private String title;
	
	@Lob //대용량 데이터. 이미지나 폰트설정도 가능
	private String content; //댓글
	/* @ColumnDefault("0") */
	private int count; //조회수
	
	//연관관계
	//앞이 나자신 뒤는 다른 한명이 여러개의 게시글을 쓸수있다
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="userId")
	private Users users; //자바는 오브젝트를 저장할수있지만 DB는 오브젝트를 저장할수없기에 외래키를 사용한다
	
	@OneToMany (mappedBy="boards", fetch = FetchType.EAGER)
	private List<Reply> reply; //테이블 참조. 외래키x
	//mappedBy는 연관관계의 주인이 아니라, DB에 칼럼을 만들지 않는다는 의미
	//하나의 게시글에는 여러개의 댓글작성
	@CreationTimestamp
	private Timestamp createDate;
}
