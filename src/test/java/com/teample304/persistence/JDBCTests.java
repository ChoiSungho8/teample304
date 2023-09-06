package com.teample304.persistence;

import static org.junit.Assert.fail;  

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j2;

@Log4j2//ë¡œê·¸ ì¶œë ¥
public class JDBCTests {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("JDBCTests.static ë¸”ëŸ­ ?˜¤ë¥?");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
	
		try (
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"book_ex",
					"book_ex")) {
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());//junit ?…Œ?Š¤?Š¸ ?‹¤?Œ¨ ? „?‹¬
		}
	}

}
