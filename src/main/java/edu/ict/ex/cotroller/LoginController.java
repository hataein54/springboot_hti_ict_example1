package edu.ict.ex.cotroller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(Model model) {

		log.info("login()..");
		return "login/login";
	}

	@GetMapping("/loginInfo")
	public String loginInfo(Authentication authentication, Principal principal, Model model) {
		log.info("loginInfo()..");

		if (principal != null) {
			System.out.println(principal);
			System.out.println(principal.getName());
			System.out.println(principal);
		}

		if (authentication != null) {
			System.out.println(authentication);
			System.out.println(authentication.getName());
			System.out.println(authentication.getAuthorities());
		}
		
		//1. SpringContextHolder를 통하여 가져오는 방법(일반적인 빈에서 사용할수 있음)
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		return "redirect:/";
	}

}
