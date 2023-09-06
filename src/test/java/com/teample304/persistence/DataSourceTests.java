package com.teample304.persistence;

import static org.junit.Assert.fail; 

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class) //테스트 실행 방법 확장
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //빈 등록 설정 파일 경로 
@Log4j2 //로그 출력
public class DataSourceTests {
	
	@Setter( onMethod_ = {@Autowired})
	private DataSource dataSource;
	
	@Setter( onMethod_ = {@Autowired})
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testMybatis() {
		try (
				SqlSession session = sqlSessionFactory.openSession();//SqlSession를 생성, 세션을 열고 이 세션을 통해 DB 작업
				Connection con = session.getConnection();//DB 연결
				) {
				log.info(session);
				log.info(con);
		} catch (Exception e) {
				fail(e.getMessage());
		}
	}
	
	@Test
	public void testConnection() {
		
		try(Connection con = dataSource.getConnection()){
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
