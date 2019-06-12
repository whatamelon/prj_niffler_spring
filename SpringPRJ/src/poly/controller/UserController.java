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

import poly.dto.UserDTO;
import poly.dto.FeelDTO;
import poly.service.IFeelService;
import poly.service.IUserService;
import poly.util.CmmUtil;

@SuppressWarnings("unused")
@Controller
public class UserController {
	private Logger log = Logger.getLogger(this.getClass());
	
	
@Autowired
		private IUserService userService;
@Autowired
		private IFeelService feelService;


//----------------------------------------------------------------인트로페이지------------------------------------------------------------------------

@RequestMapping(value="/user/intro")
public String intro (HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception{

	return "/user/intro";
}

//----------------------------------------------------------------로그아웃리다이렉션매칭------------------------------------------------------------------------

@RequestMapping(value="/user/logout")
public String logout (HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception{

	return "/user/logout";
}

//----------------------------------------------------------------faq페이지------------------------------------------------------------------------

@RequestMapping(value="/user/faq")
public String faq (HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception{

	return "/user/faq";
}
	
//----------------------------------------------------------------날씨페이지------------------------------------------------------------------------

@RequestMapping(value="/user/weather")
public String weather (HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception{

	return "/user/weather";
}

//----------------------------------------------------------------추천페이지------------------------------------------------------------------------

@RequestMapping(value="/user/recommend")
public String recommend (HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception{

	return "/user/recommend";
}

//----------------------------------------------------------------트렌드 페이지------------------------------------------------------------------------

@RequestMapping(value="/user/Trend")
public String Trend (HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception{

	return "/user/Trend";
}

//----------------------------------------------------------------핫이슈 크롤링------------------------------------------------------------------------

@RequestMapping(value="/user/crawling")
public String crawling (HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception{

	return "/user/crawling";
}

//----------------------------------------------------------------기분페이지------------------------------------------------------------------------

@RequestMapping(value="/user/feel")
public String feel (HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception{

	log.info("getDate");
	
	FeelDTO fDTO = feelService.getDate();
	
	model.addAttribute("fDTO",fDTO);
	
	log.info("feel_date  : " + fDTO.getFeel_date());
	
	return "/user/feel";
}

//----------------------------------------------------------------기분 보내기 시작------------------------------------------------------------------------

@RequestMapping(value="/user/sendFeel")
public String sendFeel (HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception{
	log.info("sendFeelStart");
	String feel_no = request.getParameter("feel_no");
	String feel_val = request.getParameter("feelcheck");
	String feel_weather = request.getParameter("feel_weather");
	
	log.info("feel_val1 :" + feel_val);
	log.info("feel_weather1 :" + feel_weather);
	
	FeelDTO fDTO = new FeelDTO();
	
	log.info("feel_val2 :" + feel_val);
	log.info("feel_weather2 :" + feel_weather);
	
	fDTO.setFeel_no(feel_no);
	fDTO.setFeel_val(feel_val);
	fDTO.setFeel_weather(feel_weather);
	
	log.info("feel_val3 :" + feel_val);
	log.info("feel_weather3 :" + feel_weather);
	
	int result = feelService.insertFeel(fDTO);
	
	log.info("feel_val4 :" + feel_val);
	log.info("feel_weather4 :" + feel_weather);
	
	return "/user/feelOK";
}


//----------------------------------------------------------------기분 보내기 끝------------------------------------------------------------------------

//----------------------------------------------------------------트렌드 페이지------------------------------------------------------------------------

@RequestMapping(value="/user/feelOK")
public String feelOK (HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception{

	return "/user/feelOK";
}


//----------------------------------------------------------------회원가입 시작------------------------------------------------------------------------

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
		
		
		return "/user/intro";
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

}