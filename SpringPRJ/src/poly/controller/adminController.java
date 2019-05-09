package poly.controller;

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
import poly.service.impl.UserService;
import poly.util.CmmUtil;

@Controller
public class adminController {
   private Logger log = Logger.getLogger(this.getClass());

   @Resource(name = "NoticeService")
   private INoticeService noticeService;

   //-----------------------------------------------------------------------국어 게시판 매핑 시작------------------------------------------------------------------------------------------------------------------------------
   
   
   //--------------------------------------------------koreanPaging ( 글 페이징 시작 )---------------------------------------------------
   
   @SuppressWarnings("unused")
@RequestMapping(value="user/adminkoreanTable", method={RequestMethod.GET,RequestMethod.POST})
      public String koreanTable(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
         log.info(this.getClass().getName() + ".koreanTable start!");
         int totalCount = noticeService.getKoreanListTotalCount();
         int pageNum = 1;
         int pageCount = 10;      
         pageCount = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageCount"),"10"));
         pageNum = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageNum"),"1"));
         System.out.println(totalCount +"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
         // 페이징 Dto 생성
         PagingDTO paging = new PagingDTO();
         paging.setPage_num(pageNum);
         paging.setPage_count(pageCount);
         paging.setTotal_count(totalCount);

         List<NoticeDTO> rList = noticeService.getKoreanList2(paging);
         System.out.println(rList.size()+": SIZE <<<<<<<<<<<<<<<<<<<<<");
         
         if (rList==null){
            rList = new ArrayList<NoticeDTO>();
         }

         model.addAttribute("rList", rList);

         model.addAttribute("paging", paging);

         rList = null;
      
         log.info(this.getClass().getName() + ".koreanTable end!");
         
         return "/user/adminkoreanTable";
      }
      
      //--------------------------------------------------koreanPaging ( 글 페이징 끝 )---------------------------------------------------
      
    
      //--------------------------------------------------koreanDelete( 글 삭제 시작  )-----------------------------------------------------------------------
      
      @RequestMapping(value="user/adminkoreanDelete")
      public String koreanDelete(HttpServletRequest request, Model model,HttpSession session) throws Exception{
    	  log.info(this.getClass()+"koreanDelete start~~~~~!!!!!!");
    	  
         String post_seq_no = request.getParameter("post_seq_no");
         
         log.info("post_seq_no : " + post_seq_no);
         
         int result = noticeService.deleteKorean(post_seq_no);
         
         log.info("post_seq_no"+post_seq_no);
         
         if(result == 1){
            model.addAttribute("msg", "게시글이 삭제되었습니다");
            model.addAttribute("url", "/user/adminkoreanTable.do");
         }else{
            model.addAttribute("msg", "게시글을 삭제하는 데, 실패하였습니다.");
            model.addAttribute("url", "/user/adminkoreanTable.do");
         }
         
         log.info("result : "+result);
         
         log.info(this.getClass()+"koreanDelete END~~~~~!!!!!!");
         
         return "/notice_alert";
      }

      
    //--------------------------------------------------KoreanDelete ( 글 삭제 끝  )-----------------------------------------------------------------------
      
      
  //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  
      

    //-----------------------------------------------------------------------수학 게시판 매핑 시작------------------------------------------------------------------------------------------------------------------------------
      
      
      //--------------------------------------------------mathPaging ( 글 페이징 시작 )---------------------------------------------------
      
      @SuppressWarnings("unused")
   @RequestMapping(value="user/adminmathTable", method={RequestMethod.GET,RequestMethod.POST})
         public String adminmathTable(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
            log.info(this.getClass().getName() + ".adminmathTable start!");
            int totalCount = noticeService.getMathListTotalCount();
            int pageNum = 1;
            int pageCount = 10;      
            pageCount = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageCount"),"10"));
            pageNum = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageNum"),"1"));
            System.out.println(totalCount +"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            // 페이징 Dto 생성
            PagingDTO paging = new PagingDTO();
            paging.setPage_num(pageNum);
            paging.setPage_count(pageCount);
            paging.setTotal_count(totalCount);

            List<NoticeDTO> rList = noticeService.getMathList2(paging);
            System.out.println(rList.size()+": SIZE <<<<<<<<<<<<<<<<<<<<<");
            
            if (rList==null){
               rList = new ArrayList<NoticeDTO>();
            }

            model.addAttribute("rList", rList);

            model.addAttribute("paging", paging);

            rList = null;
         
            log.info(this.getClass().getName() + ".adminmathTable end!");
            
            return "/user/adminmathTable";
         }
         
         //--------------------------------------------------mathPaging ( 글 페이징 끝 )---------------------------------------------------
         
   
         //--------------------------------------------------mathDelete( 글 삭제 시작  )-----------------------------------------------------------------------
         
         @RequestMapping(value="user/adminmathDelete")
         public String mathDelete(HttpServletRequest request, Model model,HttpSession session) throws Exception{
       	  log.info(this.getClass()+"adminmathDelete start~~~~~!!!!!!");
       	  
            String post_seq_no = request.getParameter("post_seq_no");
            
            log.info("post_seq_no : " + post_seq_no);
            
            int result = noticeService.deleteMath(post_seq_no);
            
            log.info("post_seq_no"+post_seq_no);
            
            if(result == 1){
               model.addAttribute("msg", "게시글이 삭제되었습니다");
               model.addAttribute("url", "/user/adminmathTable.do");
            }else{
               model.addAttribute("msg", "게시글을 삭제하는 데, 실패하였습니다.");
               model.addAttribute("url", "/user/adminmathTable.do");
            }
            
            log.info("result : "+result);
            
            log.info(this.getClass()+"adminmathDelete END~~~~~!!!!!!");
            
            return "/notice_alert";
         }
         
       //--------------------------------------------------mathDelete ( 글 삭제 끝  )-----------------------------------------------------------------------
         
         
         //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  
         

         //-----------------------------------------------------------------------영어 게시판 매핑 시작------------------------------------------------------------------------------------------------------------------------------
           
           
           //--------------------------------------------------engPaging ( 글 페이징 시작 )---------------------------------------------------
           
           @SuppressWarnings("unused")
        @RequestMapping(value="user/adminengTable", method={RequestMethod.GET,RequestMethod.POST})
              public String adminengTable(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
                 log.info(this.getClass().getName() + ".adminengTable start!");
                 int totalCount = noticeService.getEngListTotalCount();
                 int pageNum = 1;
                 int pageCount = 10;      
                 pageCount = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageCount"),"10"));
                 pageNum = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageNum"),"1"));
                 System.out.println(totalCount +"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                 // 페이징 Dto 생성
                 PagingDTO paging = new PagingDTO();
                 paging.setPage_num(pageNum);
                 paging.setPage_count(pageCount);
                 paging.setTotal_count(totalCount);

                 List<NoticeDTO> rList = noticeService.getEngList2(paging);
                 System.out.println(rList.size()+": SIZE <<<<<<<<<<<<<<<<<<<<<");
                 
                 if (rList==null){
                    rList = new ArrayList<NoticeDTO>();
                 }

                 model.addAttribute("rList", rList);

                 model.addAttribute("paging", paging);

                 rList = null;
              
                 log.info(this.getClass().getName() + ".adminengTable end!");
                 
                 return "/user/adminengTable";
              }
              
              //--------------------------------------------------engPaging ( 글 페이징 끝 )---------------------------------------------------
              

              
              //--------------------------------------------------engDelete( 글 삭제 시작  )-----------------------------------------------------------------------
              
              @RequestMapping(value="user/adminengDelete")
              public String adminengDelete(HttpServletRequest request, Model model,HttpSession session) throws Exception{
            	  log.info(this.getClass()+"adminengDelete start~~~~~!!!!!!");
            	  
                 String post_seq_no = request.getParameter("post_seq_no");
                 
                 log.info("post_seq_no : " + post_seq_no);
                 
                 int result = noticeService.deleteEng(post_seq_no);
                 
                 log.info("post_seq_no"+post_seq_no);
                 
                 if(result == 1){
                    model.addAttribute("msg", "게시글이 삭제되었습니다");
                    model.addAttribute("url", "/user/adminengTable.do");
                 }else{
                    model.addAttribute("msg", "게시글을 삭제하는 데, 실패하였습니다.");
                    model.addAttribute("url", "/user/adminengTable.do");
                 }
                 
                 log.info("result : "+result);
                 
                 log.info(this.getClass()+"adminengDelete END~~~~~!!!!!!");
                 
                 return "/notice_alert";
              }
              
            //--------------------------------------------------engDelete ( 글 삭제 끝  )-----------------------------------------------------------------------
      
            //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  
              

  //-----------------------------------------------------------------------공부템 게시판 매핑 시작------------------------------------------------------------------------------------------------------------------------------
                
                
    //--------------------------------------------------itemPaging ( 글 페이징 시작 )---------------------------------------------------
                
           @SuppressWarnings("unused")
             @RequestMapping(value="user/adminitemTable", method={RequestMethod.GET,RequestMethod.POST})
                   public String itemTable(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
                      log.info(this.getClass().getName() + ".adminitemTable start!");
                      int totalCount = noticeService.getItemListTotalCount();
                      int pageNum = 1;
                      int pageCount = 10;      
                      pageCount = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageCount"),"10"));
                      pageNum = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageNum"),"1"));
                      System.out.println(totalCount +"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                      // 페이징 Dto 생성
                      PagingDTO paging = new PagingDTO();
                      paging.setPage_num(pageNum);
                      paging.setPage_count(pageCount);
                      paging.setTotal_count(totalCount);

                      List<NoticeDTO> rList = noticeService.getItemList2(paging);
                      System.out.println(rList.size()+": SIZE <<<<<<<<<<<<<<<<<<<<<");
                      
                      if (rList==null){
                         rList = new ArrayList<NoticeDTO>();
                      }

                      model.addAttribute("rList", rList);

                      model.addAttribute("paging", paging);

                      rList = null;
                   
                      log.info(this.getClass().getName() + ".adminitemTable end!");
                      
                      return "/user/adminitemTable";
                   }
                   
                   //--------------------------------------------------itemPaging ( 글 페이징 끝 )---------------------------------------------------
                   
    
                   //--------------------------------------------------itemDelete( 글 삭제 시작  )-----------------------------------------------------------------------
                   
                   @RequestMapping(value="user/adminitemDelete")
                   public String adminitemDelete(HttpServletRequest request, Model model,HttpSession session) throws Exception{
                 	  log.info(this.getClass()+"itemDelete start~~~~~!!!!!!");
                 	  
                      String post_seq_no = request.getParameter("post_seq_no");
                      
                      log.info("post_seq_no : " + post_seq_no);
                      
                      int result = noticeService.deleteItem(post_seq_no);
                      
                      log.info("post_seq_no"+post_seq_no);
                      
                      if(result == 1){
                         model.addAttribute("msg", "게시글이 삭제되었습니다");
                         model.addAttribute("url", "/user/adminitemTable.do");
                      }else{
                         model.addAttribute("msg", "게시글을 삭제하는 데, 실패하였습니다.");
                         model.addAttribute("url", "/user/adminitemTable.do");
                      }
                      
                      log.info("result : "+result);
                      
                      log.info(this.getClass()+"adminitemDelete END~~~~~!!!!!!");
                      
                      return "/notice_alert";
                   }
                   
                 //--------------------------------------------------itemDelete ( 글 삭제 끝  )-----------------------------------------------------------------------
                   

                   
                   //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  
                     

         //-----------------------------------------------------------------------독서실 게시판 매핑 시작------------------------------------------------------------------------------------------------------------------------------
                       
                       
           //--------------------------------------------------RoomPaging ( 글 페이징 시작 )---------------------------------------------------
                       
                  @SuppressWarnings("unused")
                    @RequestMapping(value="user/adminroomTable", method={RequestMethod.GET,RequestMethod.POST})
                          public String adminroomTable(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
                             log.info(this.getClass().getName() + ".adminroomTable start!");
                             int totalCount = noticeService.getRoomListTotalCount();
                             int pageNum = 1;
                             int pageCount = 10;      
                             pageCount = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageCount"),"10"));
                             pageNum = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageNum"),"1"));
                             System.out.println(totalCount +"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                             // 페이징 Dto 생성
                             PagingDTO paging = new PagingDTO();
                             paging.setPage_num(pageNum);
                             paging.setPage_count(pageCount);
                             paging.setTotal_count(totalCount);

                             List<NoticeDTO> rList = noticeService.getRoomList2(paging);
                             System.out.println(rList.size()+": SIZE <<<<<<<<<<<<<<<<<<<<<");
                             
                             if (rList==null){
                                rList = new ArrayList<NoticeDTO>();
                             }

                             model.addAttribute("rList", rList);

                             model.addAttribute("paging", paging);

                             rList = null;
                          
                             log.info(this.getClass().getName() + ".adminroomTable end!");
                             
                             return "/user/adminroomTable";
                          }
                          
                          //--------------------------------------------------roomPaging ( 글 페이징 끝 )---------------------------------------------------
                          
                         
    
                          
                          //--------------------------------------------------roomDelete( 글 삭제 시작  )-----------------------------------------------------------------------
                          
                          @RequestMapping(value="user/adminroomDelete")
                          public String adminroomDelete(HttpServletRequest request, Model model,HttpSession session) throws Exception{
                        	  log.info(this.getClass()+"adminroomDelete start~~~~~!!!!!!");
                        	  
                             String post_seq_no = request.getParameter("post_seq_no");
                             
                             log.info("post_seq_no : " + post_seq_no);
                             
                             int result = noticeService.deleteRoom(post_seq_no);
                             
                             log.info("post_seq_no"+post_seq_no);
                             
                             if(result == 1){
                                model.addAttribute("msg", "게시글이 삭제되었습니다");
                                model.addAttribute("url", "/user/adminroomTable.do");
                             }else{
                                model.addAttribute("msg", "게시글을 삭제하는 데, 실패하였습니다.");
                                model.addAttribute("url", "/user/adminroomTable.do");
                             }
                             
                             log.info("result : "+result);
                             
                             log.info(this.getClass()+"adminroomDelete END~~~~~!!!!!!");
                             
                             return "/notice_alert";
                          }
                          
         //--------------------------------------------------roomDelete ( 글 삭제 끝  )-----------------------------------------------------------------------
                          
                          
  //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  
                            

  
}
