/*package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import oracle.net.aso.n;
import poly.dto.MemberDTO;
import poly.dto.NoticeDTO;
import poly.dto.PagingDTO;
import poly.dto.UserDTO;
import poly.service.INoticeService;
import poly.util.CmmUtil;

@Controller
public class NoticeController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "NoticeService")
	private INoticeService noticeService;

	// -----------------------------------------------------------------------국어 게시판 매핑 시작------------------------------------------------------------------------------------------------------------------------------

	// --------------------------------------------------koreanPaging ( 글 페이징 시작 )---------------------------------------------------

	@SuppressWarnings("unused")
	@RequestMapping(value = "user/koreanTable", method = { RequestMethod.GET, RequestMethod.POST })
	public String koreanTable(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws Exception {
		log.info(this.getClass().getName() + ".koreanTable start!");
		int totalCount = noticeService.getKoreanListTotalCount();
		int pageNum = 1;
		int pageCount = 10;
		pageCount = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageCount"), "10"));
		pageNum = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageNum"), "1"));
		System.out.println(totalCount + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		// 페이징 Dto 생성
		PagingDTO paging = new PagingDTO();
		paging.setPage_num(pageNum);
		paging.setPage_count(pageCount);
		paging.setTotal_count(totalCount);

		List<NoticeDTO> rList = noticeService.getKoreanList2(paging);
		System.out.println(rList.size() + ": SIZE <<<<<<<<<<<<<<<<<<<<<");

		if (rList == null) {
			rList = new ArrayList<NoticeDTO>();
		}

		model.addAttribute("rList", rList);

		model.addAttribute("paging", paging);

		rList = null;

		log.info(this.getClass().getName() + ".koreanTable end!");

		return "/user/koreanTable";
	}

	// --------------------------------------------------koreanPaging ( 글 페이징 끝)---------------------------------------------------

	// --------------------------------------------------koreanWrite ( 글 등록시작)---------------------------------------------------

	@RequestMapping(value = "user/koreanWrite")
	public String koreanWrite() throws Exception {

		return "/user/koreanWrite";
	}

	// --------------------------------------------------koreanWrite ( 글 등록 끝/ )---------------------------------------------------

	// --------------------------------------------------koreanInsert ( 글 등록 처리 시작 )---------------------------------------------------

	@RequestMapping(value = "/user/koreanInsert", method = {RequestMethod.POST, RequestMethod.GET})
	public String koreanInsert(HttpSession session, HttpServletRequest req, Model model) throws Exception {
		log.info("koreanInsert test");

		String title = CmmUtil.nvl(req.getParameter("title"));
		String contents = req.getParameter("contents");
		String teacher = req.getParameter("teacher");
		String subject = req.getParameter("subject");
		String spec_sub = req.getParameter("spec_sub");
		String usr_nickname = req.getParameter("usr_nickname");
		String reg_dt = req.getParameter("reg_dt");
		UserDTO uDTO = (UserDTO) session.getAttribute("uDTO");

		log.info("---------------------------------");

		log.info("string(title) " + title);
		log.info("string(contents) " + contents);
		log.info("string(teacher) " + teacher);
		log.info("string(usr_nickname) " + usr_nickname);
		log.info("string(reg_dt) " + reg_dt);

		NoticeDTO nDTO = new NoticeDTO();

		log.info("&&&&&&&&&&&&&&&");

		log.info("string(title) " + title);
		log.info("string(contents) " + contents);
		log.info("string(teacher) " + teacher);
		log.info("string(usr_nickname) " + usr_nickname);
		log.info("string(reg_dt) " + reg_dt);

		nDTO.setTitle(title);
		nDTO.setContents(contents);
		nDTO.setTeacher(teacher);
		nDTO.setSubject(subject);
		nDTO.setSpec_sub(spec_sub);
		nDTO.setUsr_nickname(usr_nickname);
		nDTO.setReg_dt(reg_dt);
		nDTO.setUsr_no(uDTO.getUsr_no());

		log.info("#####################");

		log.info("string(title) " + title);
		log.info("string(contents) " + contents);
		log.info("string(teacher) " + teacher);
		log.info("string(usr_nickname) " + usr_nickname);
		log.info("string(reg_dt) " + reg_dt);

		int result = noticeService.insertKorean(nDTO);
		
		String result1 = noticeService.selectPost(nDTO);
		
		nDTO.setPost_seq_no(result1);

		log.info("******************************");

		log.info("string(title) " + title);
		log.info("string(contents) " + contents);
		log.info("string(teacher) " + teacher);
		log.info("string(usr_nickname) " + usr_nickname);
		log.info("string(reg_dt) " + reg_dt);

		log.info("string(Usr_no) " + uDTO.getUsr_no());
		log.info("string(post_seq_no) " + nDTO.getPost_seq_no());
		
		if (result != 1) {
			model.addAttribute("msg", "글 작성에 실패하였습니다.");
			model.addAttribute("url", "/user/koreanWrite.do");
		} else {
			model.addAttribute("msg", "글 이 작성되었습니다.");
			model.addAttribute("url", "/user/koreanTable.do");
		}
		log.info("test");

		return "/notice_alert";
	}
	// --------------------------------------------------koreanInsert ( 글 등록 처리 끝 )---------------------------------------------------

	// --------------------------------------------------koreanlikeInsert ( 글 등록 like 테이블에도 추가 시작 )---------------------------------------------------

	@SuppressWarnings("unused")
	@RequestMapping(value = "/user/koreanlikeInsert", method ={RequestMethod.POST, RequestMethod.GET})
	public String koreanlikeInsert(HttpSession session, HttpServletResponse rep, HttpServletRequest req, ModelMap model) throws Exception {
		
		UserDTO uDTO = (UserDTO) session.getAttribute("uDTO");
		String post_seq_no = req.getParameter("post_seq_no");
		//String like_flag = req.getParameter("like_flag");
		
		log.info("string1(Usr_no) " + uDTO.getUsr_no());
		log.info("string1(post_seq_no) " + post_seq_no);
		
		
		NoticeDTO nDTO = new NoticeDTO();
		
		log.info("string1(Usr_no) " + uDTO.getUsr_no());
		log.info("string2(post_seq_no) " + post_seq_no);
		
		nDTO.setPost_seq_no(post_seq_no);
		nDTO.setUsr_no(uDTO.getUsr_no());
		
		log.info("string3(Usr_no) " + uDTO.getUsr_no());
		log.info("string3(post_seq_no) " + post_seq_no);
		
		int result = noticeService.insertKoreanContentLike(nDTO);
		
		log.info("string4(post_seq_no) " + post_seq_no);
		

		
		return koreanTable(req, rep, model);
	
	}
	
	// --------------------------------------------------koreanlikeInsert (  글 등록 like 테이블에도 추가 끝 )---------------------------------------------------
	
	// --------------------------------------------------koreanContent ( 글보기 시작 )---------------------------------------------------

	@RequestMapping(value = "/user/koreanContent")
	public String koreanContent(HttpServletRequest request, Model model) throws Exception {
		log.info(this.getClass() + "koreanContent start~~~~~!!!!!!");

		String post_seq_no = request.getParameter("post_seq_no");

		log.info("post_seq_no ;;" + post_seq_no);

		NoticeDTO nDTO = noticeService.getSubstanceKorean(post_seq_no);

		model.addAttribute("nDTO", nDTO);

		log.info(this.getClass() + "koreanContent End~~~~~!!!!!!");

		return "/user/koreanContent";
	}

	// --------------------------------------------------koreanContent ( 글보기 끝 )---------------------------------------------------

	// --------------------------------------------------koreanChange ( 글 수정 페이지 시작 )---------------------------------------------------

	@RequestMapping(value = "/user/koreanChange")
	public String koreanChange(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		log.info(this.getClass() + "koreanChange start~~~~~!!!!!!");

		String post_seq_no = request.getParameter("post_seq_no");

		log.info("post_seq_no : " + post_seq_no);

		NoticeDTO nDTO = noticeService.getSubstanceKorean(post_seq_no);

		nDTO.setPost_seq_no(post_seq_no);
		model.addAttribute("nDTO", nDTO);
		log.info("post_seq_no : " + post_seq_no);

		log.info(this.getClass() + "koreanChange end~~~~~!!!!!!");

		return "/user/koreanChange";
	}

	// --------------------------------------------------koreanChange ( 글 수정 페이지 끝 )---------------------------------------------------

	// --------------------------------------------------koreanChangeProc ( 글 수정 페이지Proc 시작 )---------------------------------------------------

	@RequestMapping(value = "/user/koreanChangeProc")
	public String koreanChangeProc(HttpServletRequest request, Model model, HttpSession session) throws Exception {

		log.info(this.getClass() + "koreanChangeProc start~~~~~!!!!!!");

		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		UserDTO uDTO = (UserDTO) session.getAttribute("uDTO");
		String subject = request.getParameter("subject");
		String spec_sub = request.getParameter("spec_sub");
		String teacher = request.getParameter("teacher");
		String post_seq_no = request.getParameter("post_seq_no");
		String Usr_no = uDTO.getUsr_no();

		log.info("string(title1) : " + title);
		log.info("string(teacher1) : " + teacher);
		log.info("string(contents1) : " + contents);
		log.info("string(Usr_no1) : " + Usr_no);
		log.info("string(post_seq_no1) : " + post_seq_no);

		NoticeDTO nDTO = new NoticeDTO();

		log.info("string(title2) : " + title);
		log.info("string(teacher2) : " + teacher);
		log.info("string(contents2) : " + contents);
		log.info("string(Usr_no2) : " + Usr_no);
		log.info("string(post_seq_no2) : " + post_seq_no);

		nDTO.setTitle(title);
		nDTO.setContents(contents);
		nDTO.setTeacher(teacher);
		nDTO.setSubject(subject); 
		nDTO.setSpec_sub(spec_sub);
		nDTO.setUsr_no(uDTO.getUsr_no());
		nDTO.setPost_seq_no(post_seq_no);

		log.info("string(title3) : " + title);

		int result = noticeService.updateKorean(nDTO);

		log.info("string(title4) : " + title);

		if (result != 1) {
			model.addAttribute("msg", "글 수정에 실패하였습니다.");
			model.addAttribute("url", "/user/koreanTable.do");
		} else {
			model.addAttribute("msg", "글 이 수정되었습니다..");
			model.addAttribute("url", "/user/koreanTable.do");
		}

		log.info(this.getClass() + "koreanChangeProc end~~~~~!!!!!!");

		return "/notice_alert";
	}

	// --------------------------------------------------koreanChangeProc ( 글 수정/ 페이지Proc 끝 )---------------------------------------------------

	// --------------------------------------------------koreanDelete( 글 삭제 시작 )-----------------------------------------------------------------------

	@RequestMapping(value = "user/koreanDelete")
	public String koreanDelete(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		log.info(this.getClass() + "koreanDelete start~~~~~!!!!!!");

		String post_seq_no = request.getParameter("post_seq_no");

		log.info("post_seq_no : " + post_seq_no);

		int result = noticeService.deleteKorean(post_seq_no);

		log.info("post_seq_no" + post_seq_no);

		if (result == 1) {
			model.addAttribute("msg", "게시글이 삭제되었습니다");
			model.addAttribute("url", "/user/koreanTable.do");
		} else {
			model.addAttribute("msg", "게시글을 삭제하는 데, 실패하였습니다.");
			model.addAttribute("url", "/user/koreanTable.do");
		}

		log.info("result : " + result);

		log.info(this.getClass() + "koreanDelete END~~~~~!!!!!!");

		return "/notice_alert";
	}

	// --------------------------------------------------KoreanDelete ( 글 삭제 끝 )-----------------------------------------------------------------------

	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	// -----------------------------------------------------------------------수학 게시판 매핑 시작------------------------------------------------------------------------------------------------------------------------------

	// --------------------------------------------------mathPaging ( 글 페이징 시작 )---------------------------------------------------

	@SuppressWarnings("unused")
	@RequestMapping(value = "user/mathTable", method = { RequestMethod.GET, RequestMethod.POST })
	public String mathTable(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		log.info(this.getClass().getName() + ".mathTable start!");
		int totalCount = noticeService.getMathListTotalCount();
		int pageNum = 1;
		int pageCount = 10;
		pageCount = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageCount"), "10"));
		pageNum = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageNum"), "1"));
		System.out.println(totalCount + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		// 페이징 Dto 생성
		PagingDTO paging = new PagingDTO();
		paging.setPage_num(pageNum);
		paging.setPage_count(pageCount);
		paging.setTotal_count(totalCount);

		List<NoticeDTO> rList = noticeService.getMathList2(paging);
		System.out.println(rList.size() + ": SIZE <<<<<<<<<<<<<<<<<<<<<");

		if (rList == null) {
			rList = new ArrayList<NoticeDTO>();
		}

		model.addAttribute("rList", rList);

		model.addAttribute("paging", paging);

		rList = null;

		log.info(this.getClass().getName() + ".mathTable end!");

		return "/user/mathTable";
	}

	// --------------------------------------------------mathPaging ( 글 페이징 끝 )---------------------------------------------------

	// --------------------------------------------------mathWrite ( 글 등록시작 )---------------------------------------------------

	@RequestMapping(value = "user/mathWrite")
	public String mathWrite() throws Exception {

		return "/user/mathWrite";
	}

	// --------------------------------------------------mathWrite ( 글 등록 끝 )---------------------------------------------------

	// --------------------------------------------------mathInsert ( 글 등록 처리 시작 )---------------------------------------------------

	@RequestMapping(value = "/user/mathInsert", method = RequestMethod.POST)
	public String mathInsert(HttpSession session, HttpServletRequest req, Model model) throws Exception {
		log.info("mathInsert test");

		String title = CmmUtil.nvl(req.getParameter("title"));
		String contents = req.getParameter("contents");
		String teacher = req.getParameter("teacher");
		String subject = req.getParameter("subject");
		String spec_sub = req.getParameter("spec_sub");
		log.info(spec_sub);
		String usr_nickname = req.getParameter("usr_nickname");
		String reg_dt = req.getParameter("reg_dt");
		UserDTO uDTO = (UserDTO) session.getAttribute("uDTO");

		log.info("---------------------------------");

		log.info("string(title) " + title);
		log.info("string(contents) " + contents);
		log.info("string(teacher) " + teacher);
		log.info("string(usr_nickname) " + usr_nickname);
		log.info("string(reg_dt) " + reg_dt);

		NoticeDTO nDTO = new NoticeDTO();

		log.info("&&&&&&&&&&&&&&&");

		log.info("string(title) " + title);
		log.info("string(contents) " + contents);
		log.info("string(teacher) " + teacher);
		log.info("string(usr_nickname) " + usr_nickname);
		log.info("string(reg_dt) " + reg_dt);

		nDTO.setTitle(title);
		nDTO.setContents(contents);
		nDTO.setTeacher(teacher);
		nDTO.setSubject(subject);
		nDTO.setSpec_sub(spec_sub);
		nDTO.setUsr_nickname(usr_nickname);
		nDTO.setReg_dt(reg_dt);
		nDTO.setUsr_no(uDTO.getUsr_no());

		log.info("#####################");

		log.info("string(title) " + title);
		log.info("string(contents) " + contents);
		log.info("string(teacher) " + teacher);
		log.info("string(usr_nickname) " + usr_nickname);
		log.info("string(reg_dt) " + reg_dt);

		int result = noticeService.insertMath(nDTO);

		log.info("******************************");

		log.info("string(title) " + title);
		log.info("string(contents) " + contents);
		log.info("string(teacher) " + teacher);
		log.info("string(usr_nickname) " + usr_nickname);
		log.info("string(reg_dt) " + reg_dt);

		if (result != 1) {
			model.addAttribute("msg", "글 작성에 실패하였습니다.");
			model.addAttribute("url", "/user/mathWrite.do");
		} else {
			model.addAttribute("msg", "글 이 작성되었습니다.");
			model.addAttribute("url", "/user/mathTable.do");
		}
		log.info("test");

		return "/notice_alert";
	}
	// --------------------------------------------------mathInsert ( 글 등록 처리 끝 )---------------------------------------------------

	// --------------------------------------------------mathContent ( 글보기 시작 )---------------------------------------------------

	@RequestMapping(value = "/user/mathContent")
	public String mathContent(HttpServletRequest request, Model model) throws Exception {
		log.info(this.getClass() + "mathContent start~~~~~!!!!!!");

		String post_seq_no = request.getParameter("post_seq_no");

		log.info("post_seq_no ;;" + post_seq_no);

		NoticeDTO nDTO = noticeService.getSubstanceMath(post_seq_no);

		model.addAttribute("nDTO", nDTO);

		log.info(this.getClass() + "mathContent End~~~~~!!!!!!");

		return "/user/mathContent";
	}

	// --------------------------------------------------mathContent ( 글보기 끝 )---------------------------------------------------

	// --------------------------------------------------mathChange ( 글 수정 페이지 시작 )---------------------------------------------------

	@RequestMapping(value = "/user/mathChange")
	public String mathChange(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		log.info(this.getClass() + "koreanChange start~~~~~!!!!!!");

		String post_seq_no = request.getParameter("post_seq_no");

		log.info("post_seq_no : " + post_seq_no);

		NoticeDTO nDTO = noticeService.getSubstanceMath(post_seq_no);

		nDTO.setPost_seq_no(post_seq_no);
		model.addAttribute("nDTO", nDTO);
		log.info("post_seq_no : " + post_seq_no);

		log.info(this.getClass() + "mathChange end~~~~~!!!!!!");

		return "/user/mathChange";
	}

	// --------------------------------------------------mathChange ( 글 수정 페이지 끝 )---------------------------------------------------

	// --------------------------------------------------mathChangeProc ( 글 수정 페이지Proc 시작 )---------------------------------------------------

	@RequestMapping(value = "/user/mathChangeProc")
	public String mathChangeProc(HttpServletRequest request, Model model, HttpSession session) throws Exception {

		log.info(this.getClass() + "mathChangeProc start~~~~~!!!!!!");

		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		UserDTO uDTO = (UserDTO) session.getAttribute("uDTO");
		String subject = request.getParameter("subject");
		String spec_sub = request.getParameter("spec_sub");
		String teacher = request.getParameter("teacher");
		String post_seq_no = request.getParameter("post_seq_no");
		String Usr_no = uDTO.getUsr_no();

		log.info("string(title1) : " + title);
		log.info("string(teacher1) : " + teacher);
		log.info("string(contents1) : " + contents);
		log.info("string(Usr_no1) : " + Usr_no);
		log.info("string(post_seq_no1) : " + post_seq_no);

		NoticeDTO nDTO = new NoticeDTO();

		log.info("string(title2) : " + title);
		log.info("string(teacher2) : " + teacher);
		log.info("string(contents2) : " + contents);
		log.info("string(Usr_no2) : " + Usr_no);
		log.info("string(post_seq_no2) : " + post_seq_no);

		nDTO.setTitle(title);
		nDTO.setContents(contents);
		nDTO.setTeacher(teacher);
		nDTO.setSubject(subject);
		nDTO.setSpec_sub(spec_sub);
		nDTO.setUsr_no(uDTO.getUsr_no());
		nDTO.setPost_seq_no(post_seq_no);

		log.info("string(title3) : " + title);

		int result = noticeService.updateMath(nDTO);

		log.info("string(title4) : " + title);

		if (result != 1) {
			model.addAttribute("msg", "글 수정에 실패하였습니다.");
			model.addAttribute("url", "/user/mathTable.do");
		} else {
			model.addAttribute("msg", "글 이 수정되었습니다..");
			model.addAttribute("url", "/user/mathTable.do");
		}

		log.info(this.getClass() + "mathChangeProc end~~~~~!!!!!!");

		return "/notice_alert";
	}

	// --------------------------------------------------mathChangeProc ( 글 수정 페이지Proc 끝 )---------------------------------------------------

	// --------------------------------------------------mathDelete( 글 삭제 시작 )-----------------------------------------------------------------------

	@RequestMapping(value = "user/mathDelete")
	public String mathDelete(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		log.info(this.getClass() + "mathDelete start~~~~~!!!!!!");

		String post_seq_no = request.getParameter("post_seq_no");

		log.info("post_seq_no : " + post_seq_no);

		int result = noticeService.deleteMath(post_seq_no);

		log.info("post_seq_no" + post_seq_no);

		if (result == 1) {
			model.addAttribute("msg", "게시글이 삭제되었습니다");
			model.addAttribute("url", "/user/mathTable.do");
		} else {
			model.addAttribute("msg", "게시글을 삭제하는 데, 실패하였습니다.");
			model.addAttribute("url", "/user/mathTable.do");
		}

		log.info("result : " + result);

		log.info(this.getClass() + "mathDelete END~~~~~!!!!!!");

		return "/notice_alert";
	}

	// --------------------------------------------------mathDelete ( 글 삭제 끝 )-----------------------------------------------------------------------

	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	// -----------------------------------------------------------------------영어 게시판 매핑 시작------------------------------------------------------------------------------------------------------------------------------

	// --------------------------------------------------engPaging ( 글 페이징 시작 )---------------------------------------------------

	@SuppressWarnings("unused")
	@RequestMapping(value = "user/engTable", method = { RequestMethod.GET, RequestMethod.POST })
	public String engTable(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		log.info(this.getClass().getName() + ".engTable start!");
		int totalCount = noticeService.getEngListTotalCount();
		int pageNum = 1;
		int pageCount = 10;
		pageCount = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageCount"), "10"));
		pageNum = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageNum"), "1"));
		System.out.println(totalCount + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		// 페이징 Dto 생성
		PagingDTO paging = new PagingDTO();
		paging.setPage_num(pageNum);
		paging.setPage_count(pageCount);
		paging.setTotal_count(totalCount);

		List<NoticeDTO> rList = noticeService.getEngList2(paging);
		System.out.println(rList.size() + ": SIZE <<<<<<<<<<<<<<<<<<<<<");

		if (rList == null) {
			rList = new ArrayList<NoticeDTO>();
		}

		model.addAttribute("rList", rList);

		model.addAttribute("paging", paging);

		rList = null;

		log.info(this.getClass().getName() + ".engTable end!");

		return "/user/engTable";
	}

	// --------------------------------------------------engPaging ( 글 페이징 끝
	// )---------------------------------------------------

	// --------------------------------------------------engWrite ( 글 등록시작
	// )---------------------------------------------------

	@RequestMapping(value = "user/engWrite")
	public String engWrite() throws Exception {

		return "/user/engWrite";
	}

	// --------------------------------------------------engWrite ( 글 등록 끝
	// )---------------------------------------------------

	// --------------------------------------------------engInsert ( 글 등록 처리 시작
	// )---------------------------------------------------

	@RequestMapping(value = "/user/engInsert", method = RequestMethod.POST)
	public String engInsert(HttpSession session, HttpServletRequest req, Model model) throws Exception {
		log.info("engInsert test");

		String title = CmmUtil.nvl(req.getParameter("title"));
		String contents = req.getParameter("contents");
		String teacher = req.getParameter("teacher");
		String subject = req.getParameter("subject");
		String spec_sub = req.getParameter("spec_sub");
		log.info(spec_sub);
		String usr_nickname = req.getParameter("usr_nickname");
		String reg_dt = req.getParameter("reg_dt");
		UserDTO uDTO = (UserDTO) session.getAttribute("uDTO");

		log.info("---------------------------------");

		log.info("string(title) " + title);
		log.info("string(contents) " + contents);
		log.info("string(teacher) " + teacher);
		log.info("string(usr_nickname) " + usr_nickname);
		log.info("string(reg_dt) " + reg_dt);

		NoticeDTO nDTO = new NoticeDTO();

		log.info("&&&&&&&&&&&&&&&");

		log.info("string(title) " + title);
		log.info("string(contents) " + contents);
		log.info("string(teacher) " + teacher);
		log.info("string(usr_nickname) " + usr_nickname);
		log.info("string(reg_dt) " + reg_dt);

		nDTO.setTitle(title);
		nDTO.setContents(contents);
		nDTO.setTeacher(teacher);
		nDTO.setSubject(subject);
		nDTO.setSpec_sub(spec_sub);
		nDTO.setUsr_nickname(usr_nickname);
		nDTO.setReg_dt(reg_dt);
		nDTO.setUsr_no(uDTO.getUsr_no());

		log.info("#####################");

		log.info("string(title) " + title);
		log.info("string(contents) " + contents);
		log.info("string(teacher) " + teacher);
		log.info("string(usr_nickname) " + usr_nickname);
		log.info("string(reg_dt) " + reg_dt);

		int result = noticeService.insertEng(nDTO);

		log.info("******************************");

		log.info("string(title) " + title);
		log.info("string(contents) " + contents);
		log.info("string(teacher) " + teacher);
		log.info("string(usr_nickname) " + usr_nickname);
		log.info("string(reg_dt) " + reg_dt);

		if (result != 1) {
			model.addAttribute("msg", "글 작성에 실패하였습니다.");
			model.addAttribute("url", "/user/engWrite.do");
		} else {
			model.addAttribute("msg", "글 이 작성되었습니다.");
			model.addAttribute("url", "/user/engTable.do");
		}
		log.info("test");

		return "/notice_alert";
	}
	// --------------------------------------------------engInsert ( 글 등록 처리 끝
	// )---------------------------------------------------

	// --------------------------------------------------engContent ( 글보기 시작
	// )---------------------------------------------------

	@RequestMapping(value = "/user/engContent")
	public String engContent(HttpServletRequest request, Model model) throws Exception {
		log.info(this.getClass() + "engContent start~~~~~!!!!!!");

		String post_seq_no = request.getParameter("post_seq_no");

		log.info("post_seq_no ;;" + post_seq_no);

		NoticeDTO nDTO = noticeService.getSubstanceEng(post_seq_no);

		model.addAttribute("nDTO", nDTO);

		log.info(this.getClass() + "engContent End~~~~~!!!!!!");

		return "/user/engContent";
	}

	// --------------------------------------------------engContent ( 글보기 끝
	// )---------------------------------------------------

	// --------------------------------------------------engChange ( 글 수정 페이지 시작
	// )---------------------------------------------------

	@RequestMapping(value = "/user/engChange")
	public String engChange(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		log.info(this.getClass() + "engChange start~~~~~!!!!!!");

		String post_seq_no = request.getParameter("post_seq_no");

		log.info("post_seq_no : " + post_seq_no);

		NoticeDTO nDTO = noticeService.getSubstanceEng(post_seq_no);

		nDTO.setPost_seq_no(post_seq_no);
		model.addAttribute("nDTO", nDTO);
		log.info("post_seq_no : " + post_seq_no);

		log.info(this.getClass() + "engChange end~~~~~!!!!!!");

		return "/user/engChange";
	}

	// --------------------------------------------------engChange ( 글 수정 페이지 끝
	// )---------------------------------------------------

	// --------------------------------------------------engChangeProc ( 글 수정
	// 페이지Proc 시작 )---------------------------------------------------

	@RequestMapping(value = "/user/engChangeProc")
	public String engChangeProc(HttpServletRequest request, Model model, HttpSession session) throws Exception {

		log.info(this.getClass() + "engChangeProc start~~~~~!!!!!!");

		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		UserDTO uDTO = (UserDTO) session.getAttribute("uDTO");
		String subject = request.getParameter("subject");
		String spec_sub = request.getParameter("spec_sub");
		String teacher = request.getParameter("teacher");
		String post_seq_no = request.getParameter("post_seq_no");
		String Usr_no = uDTO.getUsr_no();

		log.info("string(title1) : " + title);
		log.info("string(teacher1) : " + teacher);
		log.info("string(contents1) : " + contents);
		log.info("string(Usr_no1) : " + Usr_no);
		log.info("string(post_seq_no1) : " + post_seq_no);

		NoticeDTO nDTO = new NoticeDTO();

		log.info("string(title2) : " + title);
		log.info("string(teacher2) : " + teacher);
		log.info("string(contents2) : " + contents);
		log.info("string(Usr_no2) : " + Usr_no);
		log.info("string(post_seq_no2) : " + post_seq_no);

		nDTO.setTitle(title);
		nDTO.setContents(contents);
		nDTO.setTeacher(teacher);
		nDTO.setSubject(subject);
		nDTO.setSpec_sub(spec_sub);
		nDTO.setUsr_no(uDTO.getUsr_no());
		nDTO.setPost_seq_no(post_seq_no);

		log.info("string(title3) : " + title);

		int result = noticeService.updateEng(nDTO);

		log.info("string(title4) : " + title);

		if (result != 1) {
			model.addAttribute("msg", "글 수정에 실패하였습니다.");
			model.addAttribute("url", "/user/engTable.do");
		} else {
			model.addAttribute("msg", "글 이 수정되었습니다..");
			model.addAttribute("url", "/user/engTable.do");
		}

		log.info(this.getClass() + "engChangeProc end~~~~~!!!!!!");

		return "/notice_alert";
	}

	// --------------------------------------------------engChangeProc ( 글 수정
	// 페이지Proc 끝 )---------------------------------------------------

	// --------------------------------------------------engDelete( 글 삭제 시작
	// )-----------------------------------------------------------------------

	@RequestMapping(value = "user/engDelete")
	public String engDelete(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		log.info(this.getClass() + "engDelete start~~~~~!!!!!!");

		String post_seq_no = request.getParameter("post_seq_no");

		log.info("post_seq_no : " + post_seq_no);

		int result = noticeService.deleteEng(post_seq_no);

		log.info("post_seq_no" + post_seq_no);

		if (result == 1) {
			model.addAttribute("msg", "게시글이 삭제되었습니다");
			model.addAttribute("url", "/user/engTable.do");
		} else {
			model.addAttribute("msg", "게시글을 삭제하는 데, 실패하였습니다.");
			model.addAttribute("url", "/user/engTable.do");
		}

		log.info("result : " + result);

		log.info(this.getClass() + "engDelete END~~~~~!!!!!!");

		return "/notice_alert";
	}

	// --------------------------------------------------engDelete ( 글 삭제 끝
	// )-----------------------------------------------------------------------

	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	// -----------------------------------------------------------------------공부템
	// 게시판 매핑
	// 시작------------------------------------------------------------------------------------------------------------------------------

	// --------------------------------------------------itemPaging ( 글 페이징 시작
	// )---------------------------------------------------

	@SuppressWarnings("unused")
	@RequestMapping(value = "user/itemTable", method = { RequestMethod.GET, RequestMethod.POST })
	public String itemTable(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		log.info(this.getClass().getName() + ".itemTable start!");
		int totalCount = noticeService.getItemListTotalCount();
		int pageNum = 1;
		int pageCount = 10;
		pageCount = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageCount"), "10"));
		pageNum = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageNum"), "1"));
		System.out.println(totalCount + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		// 페이징 Dto 생성
		PagingDTO paging = new PagingDTO();
		paging.setPage_num(pageNum);
		paging.setPage_count(pageCount);
		paging.setTotal_count(totalCount);

		List<NoticeDTO> rList = noticeService.getItemList2(paging);
		System.out.println(rList.size() + ": SIZE <<<<<<<<<<<<<<<<<<<<<");

		if (rList == null) {
			rList = new ArrayList<NoticeDTO>();
		}

		model.addAttribute("rList", rList);

		model.addAttribute("paging", paging);

		rList = null;

		log.info(this.getClass().getName() + ".itemTable end!");

		return "/user/itemTable";
	}

	// --------------------------------------------------itemPaging ( 글 페이징 끝
	// )---------------------------------------------------

	// --------------------------------------------------itemWrite ( 글 등록시작
	// )---------------------------------------------------

	@RequestMapping(value = "user/itemWrite")
	public String itemWrite() throws Exception {

		return "/user/itemWrite";
	}

	// --------------------------------------------------itemWrite ( 글 등록 끝
	// )---------------------------------------------------

	// --------------------------------------------------itemInsert ( 글 등록 처리 시작
	// )---------------------------------------------------

	@RequestMapping(value = "/user/itemInsert", method = RequestMethod.POST)
	public String itemInsert(HttpSession session, HttpServletRequest req, Model model) throws Exception {
		log.info("itemInsert test");

		String title = CmmUtil.nvl(req.getParameter("title"));
		String contents = req.getParameter("contents");
		String usr_nickname = req.getParameter("usr_nickname");
		String reg_dt = req.getParameter("reg_dt");
		UserDTO uDTO = (UserDTO) session.getAttribute("uDTO");

		log.info("---------------------------------");

		log.info("string(title) " + title);
		log.info("string(contents) " + contents);
		log.info("string(usr_nickname) " + usr_nickname);
		log.info("string(reg_dt) " + reg_dt);

		NoticeDTO nDTO = new NoticeDTO();

		log.info("&&&&&&&&&&&&&&&");

		log.info("string(title) " + title);
		log.info("string(contents) " + contents);
		log.info("string(usr_nickname) " + usr_nickname);
		log.info("string(reg_dt) " + reg_dt);

		nDTO.setTitle(title);
		nDTO.setContents(contents);
		nDTO.setUsr_nickname(usr_nickname);
		nDTO.setReg_dt(reg_dt);
		nDTO.setUsr_no(uDTO.getUsr_no());

		log.info("#####################");

		log.info("string(title) " + title);
		log.info("string(contents) " + contents);
		log.info("string(usr_nickname) " + usr_nickname);
		log.info("string(reg_dt) " + reg_dt);

		int result = noticeService.insertItem(nDTO);

		log.info("******************************");

		log.info("string(title) " + title);
		log.info("string(contents) " + contents);
		log.info("string(usr_nickname) " + usr_nickname);
		log.info("string(reg_dt) " + reg_dt);

		if (result != 1) {
			model.addAttribute("msg", "글 작성에 실패하였습니다.");
			model.addAttribute("url", "/user/itemWrite.do");
		} else {
			model.addAttribute("msg", "글 이 작성되었습니다.");
			model.addAttribute("url", "/user/itemTable.do");
		}
		log.info("test");

		return "/notice_alert";
	}
	// --------------------------------------------------itemInsert ( 글 등록 처리 끝
	// )---------------------------------------------------

	// --------------------------------------------------itemContent ( 글보기 시작
	// )---------------------------------------------------

	@RequestMapping(value = "/user/itemContent")
	public String itemContent(HttpServletRequest request, Model model) throws Exception {
		log.info(this.getClass() + "mathContent start~~~~~!!!!!!");

		String post_seq_no = request.getParameter("post_seq_no");

		log.info("post_seq_no ;;" + post_seq_no);

		NoticeDTO nDTO = noticeService.getSubstanceItem(post_seq_no);

		model.addAttribute("nDTO", nDTO);

		log.info(this.getClass() + "itemContent End~~~~~!!!!!!");

		return "/user/itemContent";
	}

	// --------------------------------------------------itemContent ( 글보기 끝
	// )---------------------------------------------------

	// --------------------------------------------------itemChange ( 글 수정 페이지 시작
	// )---------------------------------------------------

	@RequestMapping(value = "/user/itemChange")
	public String item(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		log.info(this.getClass() + "itemChange start~~~~~!!!!!!");

		String post_seq_no = request.getParameter("post_seq_no");

		log.info("post_seq_no : " + post_seq_no);

		NoticeDTO nDTO = noticeService.getSubstanceItem(post_seq_no);

		nDTO.setPost_seq_no(post_seq_no);
		model.addAttribute("nDTO", nDTO);
		log.info("post_seq_no : " + post_seq_no);

		log.info(this.getClass() + "itemChange end~~~~~!!!!!!");

		return "/user/itemChange";
	}

	// --------------------------------------------------itemChange ( 글 수정 페이지 끝
	// )---------------------------------------------------

	// --------------------------------------------------itemChangeProc ( 글 수정
	// 페이지Proc 시작 )---------------------------------------------------

	@RequestMapping(value = "/user/itemChangeProc")
	public String itemChangeProc(HttpServletRequest request, Model model, HttpSession session) throws Exception {

		log.info(this.getClass() + "itemChangeProc start~~~~~!!!!!!");

		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		UserDTO uDTO = (UserDTO) session.getAttribute("uDTO");
		String post_seq_no = request.getParameter("post_seq_no");
		String Usr_no = uDTO.getUsr_no();

		log.info("string(title1) : " + title);
		log.info("string(contents1) : " + contents);
		log.info("string(Usr_no1) : " + Usr_no);
		log.info("string(post_seq_no1) : " + post_seq_no);

		NoticeDTO nDTO = new NoticeDTO();

		log.info("string(title2) : " + title);
		log.info("string(contents2) : " + contents);
		log.info("string(Usr_no2) : " + Usr_no);
		log.info("string(post_seq_no2) : " + post_seq_no);

		nDTO.setTitle(title);
		nDTO.setContents(contents);
		nDTO.setUsr_no(uDTO.getUsr_no());
		nDTO.setPost_seq_no(post_seq_no);

		log.info("string(title3) : " + title);

		int result = noticeService.updateItem(nDTO);

		log.info("string(title4) : " + title);

		if (result != 1) {
			model.addAttribute("msg", "글 수정에 실패하였습니다.");
			model.addAttribute("url", "/user/itemTable.do");
		} else {
			model.addAttribute("msg", "글 이 수정되었습니다..");
			model.addAttribute("url", "/user/itemTable.do");
		}

		log.info(this.getClass() + "itemChangeProc end~~~~~!!!!!!");

		return "/notice_alert";
	}

	// --------------------------------------------------itemChangeProc ( 글 수정
	// 페이지Proc 끝 )---------------------------------------------------

	// --------------------------------------------------itemDelete( 글 삭제 시작
	// )-----------------------------------------------------------------------

	@RequestMapping(value = "user/itemDelete")
	public String itemDelete(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		log.info(this.getClass() + "itemDelete start~~~~~!!!!!!");

		String post_seq_no = request.getParameter("post_seq_no");

		log.info("post_seq_no : " + post_seq_no);

		int result = noticeService.deleteItem(post_seq_no);

		log.info("post_seq_no" + post_seq_no);

		if (result == 1) {
			model.addAttribute("msg", "게시글이 삭제되었습니다");
			model.addAttribute("url", "/user/itemTable.do");
		} else {
			model.addAttribute("msg", "게시글을 삭제하는 데, 실패하였습니다.");
			model.addAttribute("url", "/user/itemTable.do");
		}

		log.info("result : " + result);

		log.info(this.getClass() + "itemDelete END~~~~~!!!!!!");

		return "/notice_alert";
	}

	// --------------------------------------------------itemDelete ( 글 삭제 끝
	// )-----------------------------------------------------------------------

	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	// -----------------------------------------------------------------------독서실
	// 게시판 매핑
	// 시작------------------------------------------------------------------------------------------------------------------------------

	// --------------------------------------------------RoomPaging ( 글 페이징 시작
	// )---------------------------------------------------

	@SuppressWarnings("unused")
	@RequestMapping(value = "user/roomTable", method = { RequestMethod.GET, RequestMethod.POST })
	public String roomTable(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		log.info(this.getClass().getName() + ".roomTable start!");
		int totalCount = noticeService.getRoomListTotalCount();
		int pageNum = 1;
		int pageCount = 10;
		pageCount = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageCount"), "10"));
		pageNum = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageNum"), "1"));
		System.out.println(totalCount + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		// 페이징 Dto 생성
		PagingDTO paging = new PagingDTO();
		paging.setPage_num(pageNum);
		paging.setPage_count(pageCount);
		paging.setTotal_count(totalCount);

		List<NoticeDTO> rList = noticeService.getRoomList2(paging);
		System.out.println(rList.size() + ": SIZE <<<<<<<<<<<<<<<<<<<<<");

		if (rList == null) {
			rList = new ArrayList<NoticeDTO>();
		}

		model.addAttribute("rList", rList);

		model.addAttribute("paging", paging);

		rList = null;

		log.info(this.getClass().getName() + ".roomTable end!");

		return "/user/roomTable";
	}

	// --------------------------------------------------roomPaging ( 글 페이징 끝
	// )---------------------------------------------------

	// --------------------------------------------------roomWrite ( 글 등록시작
	// )---------------------------------------------------

	@RequestMapping(value = "user/roomWrite")
	public String roomWrite() throws Exception {

		return "/user/roomWrite";
	}

	// --------------------------------------------------roomWrite ( 글 등록 끝
	// )---------------------------------------------------

	// -------------------------------------------------roomInsert ( 글 등록 처리 시작
	// )---------------------------------------------------

	@RequestMapping(value = "/user/roomInsert", method = RequestMethod.POST)
	public String roomInsert(HttpSession session, HttpServletRequest req, Model model) throws Exception {
		log.info("roomInsert test");

		String title = CmmUtil.nvl(req.getParameter("title"));
		String contents = req.getParameter("contents");
		String usr_nickname = req.getParameter("usr_nickname");
		String reg_dt = req.getParameter("reg_dt");
		String city = req.getParameter("city");
		UserDTO uDTO = (UserDTO) session.getAttribute("uDTO");

		log.info("---------------------------------");

		log.info("string(title) " + title);
		log.info("string(contents) " + contents);
		log.info("string(usr_nickname) " + usr_nickname);
		log.info("string(reg_dt) " + reg_dt);
		log.info("string(city) " + city);

		NoticeDTO nDTO = new NoticeDTO();

		log.info("&&&&&&&&&&&&&&&");

		log.info("string(title) " + title);
		log.info("string(contents) " + contents);
		log.info("string(usr_nickname) " + usr_nickname);
		log.info("string(reg_dt) " + reg_dt);
		log.info("string(city) " + city);

		nDTO.setTitle(title);
		nDTO.setContents(contents);
		nDTO.setUsr_nickname(usr_nickname);
		nDTO.setReg_dt(reg_dt);
		nDTO.setCity(city);
		nDTO.setUsr_no(uDTO.getUsr_no());

		log.info("#####################");

		log.info("string(title) " + title);
		log.info("string(contents) " + contents);
		log.info("string(usr_nickname) " + usr_nickname);
		log.info("string(reg_dt) " + reg_dt);
		log.info("string(city) " + city);

		int result = noticeService.insertRoom(nDTO);

		log.info("******************************");

		log.info("string(title) " + title);
		log.info("string(contents) " + contents);
		log.info("string(usr_nickname) " + usr_nickname);
		log.info("string(reg_dt) " + reg_dt);
		log.info("string(city) " + city);

		if (result != 1) {
			model.addAttribute("msg", "글 작성에 실패하였습니다.");
			model.addAttribute("url", "/user/roomWrite.do");
		} else {
			model.addAttribute("msg", "글 이 작성되었습니다.");
			model.addAttribute("url", "/user/roomTable.do");
		}
		log.info("test");

		return "/notice_alert";
	}
	// --------------------------------------------------itemInsert ( 글 등록 처리 끝
	// )---------------------------------------------------

	// --------------------------------------------------itemContent ( 글보기 시작
	// )---------------------------------------------------

	@RequestMapping(value = "/user/roomContent")
	public String roomContent(HttpServletRequest request, Model model) throws Exception {
		log.info(this.getClass() + "roomContent start~~~~~!!!!!!");

		String post_seq_no = request.getParameter("post_seq_no");

		log.info("post_seq_no ;;" + post_seq_no);

		NoticeDTO nDTO = noticeService.getSubstanceRoom(post_seq_no);

		model.addAttribute("nDTO", nDTO);

		log.info(this.getClass() + "roomContent End~~~~~!!!!!!");

		return "/user/roomContent";
	}

	// --------------------------------------------------roomContent ( 글보기 끝
	// )---------------------------------------------------

	// --------------------------------------------------roomChange ( 글 수정 페이지 시작
	// )---------------------------------------------------

	@RequestMapping(value = "/user/roomChange")
	public String roomChange(HttpServletRequest request, Model model, HttpSession session) throws Exception {

		log.info(this.getClass() + "roomChange start~~~~~!!!!!!");

		String post_seq_no = request.getParameter("post_seq_no");

		log.info("post_seq_no : " + post_seq_no);

		NoticeDTO nDTO = noticeService.getSubstanceRoom(post_seq_no);

		nDTO.setPost_seq_no(post_seq_no);
		model.addAttribute("nDTO", nDTO);
		log.info("post_seq_no : " + post_seq_no);

		log.info(this.getClass() + "roomChange end~~~~~!!!!!!");

		return "/user/roomChange";
	}

	// --------------------------------------------------roomChange ( 글 수정 페이지 끝
	// )---------------------------------------------------

	// --------------------------------------------------roomChangeProc ( 글 수정
	// 페이지Proc 시작 )---------------------------------------------------

	@RequestMapping(value = "/user/roomChangeProc")
	public String roomChangeProc(HttpServletRequest request, Model model, HttpSession session) throws Exception {

		log.info(this.getClass() + "roomChangeProc start~~~~~!!!!!!");

		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		UserDTO uDTO = (UserDTO) session.getAttribute("uDTO");
		String post_seq_no = request.getParameter("post_seq_no");
		String city = request.getParameter("city");
		String Usr_no = uDTO.getUsr_no();

		log.info("string(title1) : " + title);
		log.info("string(contents1) : " + contents);
		log.info("string(Usr_no1) : " + Usr_no);
		log.info("string(post_seq_no1) : " + post_seq_no);
		log.info("string(city1) : " + city);

		NoticeDTO nDTO = new NoticeDTO();

		log.info("string(title2) : " + title);
		log.info("string(contents2) : " + contents);
		log.info("string(Usr_no2) : " + Usr_no);
		log.info("string(post_seq_no2) : " + post_seq_no);
		log.info("string(city2) : " + city);

		nDTO.setTitle(title);
		nDTO.setContents(contents);
		nDTO.setUsr_no(uDTO.getUsr_no());
		nDTO.setPost_seq_no(post_seq_no);
		nDTO.setCity(city);

		log.info("string(title3) : " + title);

		int result = noticeService.updateRoom(nDTO);

		log.info("string(title4) : " + title);

		if (result != 1) {
			model.addAttribute("msg", "글 수정에 실패하였습니다.");
			model.addAttribute("url", "/user/roomTable.do");
		} else {
			model.addAttribute("msg", "글 이 수정되었습니다..");
			model.addAttribute("url", "/user/roomTable.do");
		}

		log.info(this.getClass() + "roomChangeProc end~~~~~!!!!!!");

		return "/notice_alert";
	}

	// --------------------------------------------------roomChangeProc ( 글 수정 페이지Proc 끝 )---------------------------------------------------

	// --------------------------------------------------roomDelete( 글 삭제 시작 )-----------------------------------------------------------------------

	@RequestMapping(value = "user/roomDelete")
	public String roomDelete(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		log.info(this.getClass() + "roomDelete start~~~~~!!!!!!");

		String post_seq_no = request.getParameter("post_seq_no");

		log.info("post_seq_no : " + post_seq_no);

		int result = noticeService.deleteRoom(post_seq_no);

		log.info("post_seq_no" + post_seq_no);

		if (result == 1) {
			model.addAttribute("msg", "게시글이 삭제되었습니다");
			model.addAttribute("url", "/user/roomTable.do");
		} else {
			model.addAttribute("msg", "게시글을 삭제하는 데, 실패하였습니다.");
			model.addAttribute("url", "/user/roomTable.do");
		}

		log.info("result : " + result);

		log.info(this.getClass() + "roomDelete END~~~~~!!!!!!");

		return "/notice_alert";
	}

	// --------------------------------------------------roomDelete ( 글 삭제 끝)-----------------------------------------------------------------------

	
	// --------------------------------------------------좋아요 + 싫어요 매핑 시작!!!-----------------------------------------------------------------------
	
	
	// --------------------------------------------------koreanContentLike ( 좋아요 시작 유저시퀀스확인 시작 )-----------------------------------------------------------------------

		@RequestMapping(value = "/user/koreanContentLike")
		public @ResponseBody String  koreanContentLike(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		log.info(this.getClass() + "koreanContentLike start~~~~~!!!!!!");
		
		UserDTO uDTO = (UserDTO) session.getAttribute("uDTO");
		String like_flag = request.getParameter("like_flag");
		String post_seq_no = request.getParameter("post_seq_no");
		String Usr_no = uDTO.getUsr_no();
		
		log.info("string1 : " + Usr_no);
		log.info("string1 : " + like_flag);
		log.info("string1 : " + post_seq_no);
		
		if (uDTO.getUsr_no() == null || "".equals(uDTO.getUsr_no())) {
			throw new Exception("미로그인");
		}
		
		log.info("string2 : " + Usr_no);
		log.info("string2 : " + like_flag);
		log.info("string2 : " + post_seq_no);
		
		NoticeDTO nDTO = new NoticeDTO();
		
		log.info("string3 : " + Usr_no);
		log.info("string3 : " + like_flag);
		log.info("string3 : " + post_seq_no);

		nDTO.setUsr_no(uDTO.getUsr_no());
		nDTO.setLike_flag(like_flag);
		nDTO.setPost_seq_no(post_seq_no);
		
		int result = noticeService.compareUsrSeqNo(nDTO);
		
		log.info("string4 : " + Usr_no);
		log.info("string4 : " + like_flag);
		log.info("string4 : " + post_seq_no);
		
		log.info("result : " + result );
		
		if (result == 1) {
			model.addAttribute("msg","좋아요를 이미 누르셨습니다. 좋아요가 취소됩니다.");
			model.addAttribute("url","/user/koreanContentLikeCancelProc.do");
			log.info("result 는 1이고 실행이 되었다" );
			model.addAttribute("like_flag",like_flag);
			model.addAttribute("post_seq_no",post_seq_no);
			return "/user/koreanContentLikeCancelProc.do";
		} else  {
			model.addAttribute("msg","좋아요를 눌렀습니다.");
			model.addAttribute("url","/user/koreanContentLikeProc.do");
			log.info("result 는 0이고 실행이 되었다" );
			model.addAttribute("like_flag",like_flag);
			model.addAttribute("post_seq_no",post_seq_no);
			return "/user/koreanContentLikeProc.do";
			
		} 
		//return "redirect:/notice_alert";
		
	}

		// --------------------------------------------------koreanContentLike ( 좋아요 유저 시퀀스 확인 끝 )-----------------------------------------------------------------------
		
	
		// --------------------------------------------------koreanContentLikeProc ( 좋아요 DB에서 값 변경 시작 + 좋아요 값 카운트 / 좋아요 올리는 PROC)-------------------------


	@SuppressWarnings("unused")
	@RequestMapping(value = "/user/koreanContentLikeProc")
	public String koreanContentLikeProc(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		log.info(this.getClass() + "koreanContentLikeProc start~~~~~!!!!!!");
		
			UserDTO uDTO = (UserDTO) session.getAttribute("uDTO");
			String post_seq_no = (String) request.getParameter("post_seq_no");
			String like_flag = (String) request.getParameter("like_flag");
			String Usr_no = uDTO.getUsr_no();

			log.info("string1 : " + Usr_no);
			log.info("string1 : " + like_flag);
			log.info("string1 : " + post_seq_no);
			
			NoticeDTO nDTO = new NoticeDTO();
			
			log.info("string2 : " + Usr_no);
			log.info("string2 : " + like_flag);
			log.info("string2 : " + post_seq_no);

			nDTO.setPost_seq_no(post_seq_no);
			nDTO.setUsr_no(uDTO.getUsr_no());
			nDTO.setLike_flag(like_flag);
			
			log.info("string3 : " + Usr_no);
			log.info("string3 : " + like_flag);
			log.info("string3 : " + post_seq_no);

			int result = noticeService.updateKoreanContentLike(nDTO);
			
			log.info("result : "  + result);
			log.info("string4 : " + Usr_no);
			log.info("string4 : " + like_flag);
			log.info("string4 : " + post_seq_no);
			
			if(result == 1) {
				
				String like_no = request.getParameter("like_no");
				NoticeDTO nDTO2 = (NoticeDTO) session.getAttribute("nDTO");
				String Usr_no1 = uDTO.getUsr_no();
				
				NoticeDTO nDTO3 = new NoticeDTO();
				
				nDTO.setUsr_no(uDTO.getUsr_no());
				nDTO.setLike_no(like_no);
				nDTO.setPost_seq_no(post_seq_no);
				int result1 = noticeService.updatecntLike(nDTO);
				
				model.addAttribute("msg","좋아요 했습니다.");
				model.addAttribute("url","/user/koreanContent.do?post_seq_no=" + post_seq_no);
				
			}


		log.info(this.getClass() + "koreanContentLikeProc End~~~~~!!!!!!");

		return "/notice_alert";
	}

	// --------------------------------------------------koreanContentLikeProc ( 좋아요 DB에서 값 변경 끝)-----------------------------------------------------------------------

	
	// --------------------------------------------------koreanContentLikeCancelProc ( 좋아요 DB에서 값 변경 시작 + 좋아요 값 카운트 / 좋아요 내리는 PROC)-----------------------------------------------------------------------

	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/user/koreanContentLikeCancelProc")
	public String koreanContentLikeCancelProc(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		log.info(this.getClass() + "koreanContentLikeCancelProc start~~~~~!!!!!!");
		
		UserDTO uDTO = (UserDTO) session.getAttribute("uDTO");
		String post_seq_no = request.getParameter("post_seq_no");
		String like_flag = request.getParameter("like_flag");
		String Usr_no = uDTO.getUsr_no();

		log.info("string1 : " + Usr_no);
		log.info("string1 : " + like_flag);
		log.info("string1 : " + post_seq_no);
		
		NoticeDTO nDTO = new NoticeDTO();
		
		log.info("string2 : " + Usr_no);
		log.info("string2 : " + like_flag);
		log.info("string2 : " + post_seq_no);

		nDTO.setPost_seq_no(post_seq_no);
		nDTO.setUsr_no(uDTO.getUsr_no());
		nDTO.setLike_flag(like_flag);

		log.info("string3 : " + Usr_no);
		log.info("string3 : " + like_flag);
		log.info("string3 : " + post_seq_no);

		int result = noticeService.updateKoreanContentLike(nDTO);
		
		log.info("result : "  + result);
		log.info("string4 : " + Usr_no);
		log.info("string4 : " + like_flag);
		log.info("string4 : " + post_seq_no);
		
		if(result == 1) {
			
			String like_no = request.getParameter("like_no");
			NoticeDTO nDTO2 = (NoticeDTO) session.getAttribute("nDTO");
			String Usr_no1 = uDTO.getUsr_no();
			
			NoticeDTO nDTO3 = new NoticeDTO();
			
			nDTO.setUsr_no(uDTO.getUsr_no());
			nDTO.setLike_no(like_no);
			
			int result1 = noticeService.updatecntLike2(nDTO);
			
			model.addAttribute("msg","좋아요를 취소 했습니다.");
			model.addAttribute("url","/user/koreanContent.do?post_seq_no=" + post_seq_no);
			
		}

		log.info(this.getClass() + "koreanContent End~~~~~!!!!!!");

		return "/notice_alert";
	}
	
	// --------------------------------------------------koreanContentLikeCancelProc ( 좋아요 DB에서 값 변경 끝)-----------------------------------------------------------------------

	
}
*/