package com.teample304.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teample304.spring.dto.UserDTO;
import com.teample304.spring.service.UserService;

import lombok.extern.log4j.Log4j2;

// ReadMe : home() : get방식으로 "/login" 요청이 들어오면 메서드가 실행되면서 ModelAndView 객체를 생성하고 사용자 화면에 뿌려줄 뷰 이름(login.jsp)를 전달
// login() : post방식으로 "/login" 요청이 들어오면(로그인 폼에서 submit 버튼 눌렀을 때) 메서드가 실행되면서 아이디, 비밀번호를 파라미터로 받고 로그인 검사 수행, 사용자가 입력한 정보 넘김
@Controller
@Log4j2
public class UserController {

	@Autowired
	UserService userService;

	//로그인 검사
	@RequestMapping(value = "/login", method = RequestMethod.GET) // get방식으로 "/login" 요청이 들어오면 메서드 실행
	public ModelAndView home(RedirectAttributes redirect) {
		log.info("home() 실행...");

		ModelAndView mav = new ModelAndView("user/login");// 전달한 뷰 login.jsp 이름 전달
		// 다른 메서드로부터 결과 메세지를 받아 처리
		if (redirect.getAttribute("msg") != null) {
			mav.addObject("msg", redirect.getAttribute("msg"));
		}
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST) // post 방식으로 "/login" 요청이 들어오면 메서드 실행
	public String login(UserDTO dto, RedirectAttributes redirect, HttpServletRequest request) {
		log.info("login() 실행...");
		UserDTO result = this.userService.checkUser(dto);// 로그인 검사 결과
		if (result != null) {
			HttpSession session = request.getSession();// 세션을 받아온다.
			session.setAttribute("UserInfo", result);// 사용자 정보 세션으로 넘김
			return "redirect:home";
		} else {
			redirect.addFlashAttribute("msg", "로그인 실패");
			return "redirect:login";
		}

	}
}
