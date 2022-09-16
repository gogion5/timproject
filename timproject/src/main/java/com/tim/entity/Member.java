package com.tim.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.tim.constant.Role;
import com.tim.dto.MemberFormDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="member")
@Getter
@Setter
@ToString
public class Member {

	@Id
	@Column(name = "id")
	private String id;		// 아이디
	
	private String name;	// 이름
	
	private String pw;		// 비밀번호

	private String tel;		// 전화번호

	@Enumerated(EnumType.STRING)
	private Role role;
	
	public static Member createMember(MemberFormDto memberFormDto,
										PasswordEncoder passwordEncoder) {
		Member member = new Member();
		member.setId(memberFormDto.getUser_id());
		member.setName(memberFormDto.getUser_name());
		member.setTel(memberFormDto.getUser_tel());
		String pw = passwordEncoder.encode(memberFormDto.getUser_pw());
		member.setPw(pw);
		member.setRole(Role.USER);
		return member;
		
	}
}
