package com.teample304.spring.service;

import java.util.Map; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teample304.spring.dao.UserDAO;
import com.teample304.spring.dto.UserDTO;

import lombok.extern.log4j.Log4j2;

//ReadMe : 컨트롤러에서 checkUser() 호출 당함, checkUser()는 DAO 참조 객체를 통해 메서드 호출

@Service
@Log4j2
public class UserService {

	@Autowired
	private UserDAO dao;
	
	//회원가입
	public String createUser(Map<String, Object> map) {
		log.info("createUser() 실행...");
		int affectRowCount = this.dao.insertUser(map);//삽입한 데이터(row)의 개수 반환
			if(affectRowCount == 1) {
			return map.get("id").toString();
			}
			return null;
	}
	
	//로그인 검사
	public UserDTO checkUser(UserDTO user) {
		log.info("checkUser() 실행...");
		return dao.select_user_by_userid_and_userpw(user);
	}
}
