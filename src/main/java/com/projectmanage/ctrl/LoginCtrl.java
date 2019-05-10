package com.projectmanage.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/login.web")
public class LoginCtrl extends BaseCtrl{

	@RequestMapping()
	public String  LoadPage(Model model , HttpSession session, HttpServletRequest request) {
		System.out.println("==========LoginCtrl::LoadPage()==================");
		
		try {
			
			String account = getLoginAccount(session);
			Integer userid = 0;
			String realname = new String();
			
			if(false) {
				
			}
			else {
				
			}
			
			
		}catch(Exception e) {
			
		}
		
		
		return "login";
	}
}
