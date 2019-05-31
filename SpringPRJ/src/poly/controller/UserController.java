package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysql.jdbc.StringUtils;

import poly.dto.PagingDTO;
import poly.dto.UserDTO;
import poly.service.IUserService;
import poly.util.CmmUtil;

@SuppressWarnings("unused")
@Controller
public class UserController {
	private Logger log = Logger.getLogger(this.getClass());
	

	
	//--------------------------------------------------회원가입 시작----------------------------------------------------------------------------------------
	
@Autowired
		private IUserService userService;


@RequestMapping(value="/user/intro")
public String intro (HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception{

	return "/user/intro";
}

@RequestMapping(value="/user/faq")
public String faq (HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception{

	return "/user/faq";
}
	
@RequestMapping(value="/user/weather")
public String weather (HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception{

	return "/user/weather";
}

@RequestMapping(value="/user/recommend")
public String recommend (HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception{

	return "/user/recommend";
}

@RequestMapping(value="/user/Trend")
public String Trend (HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception{

	return "/user/Trend";
}

@RequestMapping(value="/user/crawling")
public String crawling (HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception{

	return "/user/crawling";
}

	@RequestMapping(value="/user/createaccount")
	public String createaccount (HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception{
	
		return "/user/createaccount";
	}

	@RequestMapping(value="/user/createAccountProc")
	public String createAccountProc (HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception{
		log.info("createAcountProcStrat");
		String usr_no = request.getParameter("usr_no");
		String usr_id = request.getParameter("usr_id");
		String usr_password = request.getParameter("usr_password");
		String usr_name = request.getParameter("usr_name");
		String usr_hobby = request.getParameter("usr_hobby");
		String usr_age = request.getParameter("usr_age");
		String usr_job = request.getParameter("usr_job");
		
		log.info("usr_id :" + usr_id);
		log.info("usr_password :" + usr_password);
		log.info("usr_name :" + usr_name);
		log.info("usr_hobby :" + usr_hobby);
		log.info("usr_age :" + usr_age);
		log.info("usr_job :" + usr_job);
		
		UserDTO uDTO = new UserDTO();
		uDTO.setUsr_no(usr_no);
		uDTO.setUsr_id(usr_id);
		uDTO.setUsr_password(usr_password);
		uDTO.setUsr_name(usr_name);
		uDTO.setUsr_age(usr_age);
		uDTO.setUsr_hobby(usr_hobby);
		uDTO.setUsr_job(usr_job);
		
		int result = userService.insertUser(uDTO);
		
		return "/user/index";
	}
	//--------------------------------------------------회원가입 끝----------------------------------------------------------------------------------------
	
	
	//--------------------------------------------------로그인 proc 시작----------------------------------------------------------------------------------------
	
	@RequestMapping(value="user/loginProc")
	public String loginProc(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception{
		
		  String usr_id = CmmUtil.nvl(request.getParameter("usr_id"));
	      log.info("usr_id : " + usr_id);
	      String usr_password = CmmUtil.nvl(request.getParameter("usr_password"));
	      log.info("usr_password : " + usr_password);
	      
	      UserDTO uDTO = new UserDTO();
	      
	      uDTO.setUsr_id(usr_id);
	      log.info("usr_id : " + uDTO.getUsr_id());
	      
	      uDTO.setUsr_password(usr_password);
	      log.info("password : " + uDTO.getUsr_password());
	      
	      uDTO = userService.login(uDTO);

	         
	      if (
	         uDTO.getUsr_id() == null ||
	         uDTO.getUsr_name() == null ||
	         uDTO.getUsr_password() == null ||
	         uDTO.getUsr_age() == null ||
	         uDTO.getUsr_hobby() == null ||
	         uDTO.getUsr_job() == null 
	         
	           )
	      
	      {
	    	  log.info("userLoginProc End~~!!");
	    	  return "/main";
	      } else {
	    	  return "redirect:/main.do";
	      }
	}
	
	//--------------------------------------------------로그인proc 끝----------------------------------------------------------------------------------------
	
	//--------------------------------------------------세션접속된 홈페이지 시작---------------------------------------------------------------------------------------
	@RequestMapping(value="/user/index1")
	public String index1 (HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception{
	
		log.info("test");
		return "/user/index1";
}
	//--------------------------------------------------세션접속된 홈페이지 끝---------------------------------------------------------------------------------------
	
	
	//--------------------------------------------------세션접속된 홈페이지 시작---------------------------------------------------------------------------------------
	@RequestMapping(value="/user/admin")
	public String admin (HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception{
	
		log.info("test");
		return "/user/admin";
}
}
	//--------------------------------------------------세션접속된 홈페이지 끝---------------------------------------------------------------------------------------
	