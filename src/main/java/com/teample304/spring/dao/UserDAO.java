package com.teample304.spring.dao;

import java.util.Map; 

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teample304.spring.dto.UserDTO;

import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
public class UserDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	// 회원가입
	public int insertUser(Map<String, Object> map) {
		log.info("insertUser() 실행...");
		return this.sql.insert("insertUser", map);
	}

	// 로그인 검사
	public UserDTO select_user_by_userid_and_userpw(UserDTO user) {
		log.info("select_user_by_userid_and_userpw() 실행...");
		UserDTO udto = this.sql.selectOne("select user by userid and userpw", user);//mapper 파일 내 SQL 태그 실행
		log.info("�α��� �˻� ��� : " + udto);
		return udto;
	}
}
