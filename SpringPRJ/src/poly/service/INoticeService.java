package poly.service;

import java.util.List;
import poly.dto.NoticeDTO;
import poly.dto.PagingDTO;
import poly.dto.UserDTO;

public interface INoticeService {
   public List<NoticeDTO> getNoticeList();
   public int getNoticeListTotalCount();
   public List<NoticeDTO> getNoticeList2(PagingDTO paging);
   
   //--------------------------글 등록 시작 ----------------------------------------
   public int insertNotice(NoticeDTO nDTO) throws Exception;		//
   //--------------------------글 등록 끝 ------------------------------------------
   
   
   //--------------------------글 상세보기 시작-------------------------------------------------
   public NoticeDTO getSubstance(String post_seq_no) throws Exception;	//
   //--------------------------글 상세보기 끝 ---------------------------------------------------
   
   
   //--------------------------글 수정 시작--------------------------------------------
   public int updateNotice(NoticeDTO nDTO) throws Exception;		//
   //--------------------------글 수정 끝---------------------------------------------
   
   
   //--------------------------글 삭제 시작------------------------------------------
   public int deleteNotice(String post_seq_no) throws Exception;		//
   //--------------------------글 삭제 끝 --------------------------------------------
   
   
   //--------------------------얘네는 뭐지 시작 -------------------------------------------------
   public List<NoticeDTO> getAllNotice() throws Exception;							//
   public NoticeDTO getNoticeOne(String session_id) throws Exception;		//
   //--------------------------얘네는 뭐지 끝 ---------------------------------------------------
   
   
	//------------------------------------------------------------------국어 매핑 시작!------------------------------------------------------
   
   public List<NoticeDTO> getKoreanList();
   public int getKoreanListTotalCount();
   public List<NoticeDTO> getKoreanList2(PagingDTO paging);
   
   //--------------------------글 등록 시작 ----------------------------------------
   public int insertKorean(NoticeDTO nDTO) throws Exception;		//
   //--------------------------글 등록 끝 ------------------------------------------
   
   
   //--------------------------글 상세보기 시작-------------------------------------------------
   public NoticeDTO getSubstanceKorean(String post_seq_no) throws Exception;	//
   //--------------------------글 상세보기 끝 ---------------------------------------------------
   
   
   //--------------------------글 수정 시작--------------------------------------------
   public int updateKorean(NoticeDTO nDTO) throws Exception;		//
   //--------------------------글 수정 끝---------------------------------------------
   
   
   //--------------------------글 삭제 시작------------------------------------------
   public int deleteKorean(String post_seq_no) throws Exception;		//
   //--------------------------글 삭제 끝 --------------------------------------------
   
   
   
//------------------------------------------------------------------수학 매핑 시작!------------------------------------------------------
   
   public List<NoticeDTO> getMathList();
   public int getMathListTotalCount();
   public List<NoticeDTO> getMathList2(PagingDTO paging);
   
   //--------------------------글 등록 시작 ----------------------------------------
   public int insertMath(NoticeDTO nDTO) throws Exception;		//
   //--------------------------글 등록 끝 ------------------------------------------
   
   
   //--------------------------글 상세보기 시작-------------------------------------------------
   public NoticeDTO getSubstanceMath(String post_seq_no) throws Exception;	//
   //--------------------------글 상세보기 끝 ---------------------------------------------------
   
   
   //--------------------------글 수정 시작--------------------------------------------
   public int updateMath(NoticeDTO nDTO) throws Exception;		//
   //--------------------------글 수정 끝---------------------------------------------
   
   
   //--------------------------글 삭제 시작------------------------------------------
   public int deleteMath(String post_seq_no) throws Exception;		//
   //--------------------------글 삭제 끝 --------------------------------------------
   
   
//------------------------------------------------------------------영어 매핑 시작!------------------------------------------------------
   
   public List<NoticeDTO> getEngList();
   public int getEngListTotalCount();
   public List<NoticeDTO> getEngList2(PagingDTO paging);
   
   //--------------------------글 등록 시작 ----------------------------------------
   public int insertEng(NoticeDTO nDTO) throws Exception;		//
   //--------------------------글 등록 끝 ------------------------------------------
   
   
   //--------------------------글 상세보기 시작-------------------------------------------------
   public NoticeDTO getSubstanceEng(String post_seq_no) throws Exception;	//
   //--------------------------글 상세보기 끝 ---------------------------------------------------
   
   
   //--------------------------글 수정 시작--------------------------------------------
   public int updateEng(NoticeDTO nDTO) throws Exception;		//
   //--------------------------글 수정 끝---------------------------------------------
   
   
   //--------------------------글 삭제 시작------------------------------------------
   public int deleteEng(String post_seq_no) throws Exception;		//
   //--------------------------글 삭제 끝 --------------------------------------------
   
   
//------------------------------------------------------------------공부템 매핑 시작!------------------------------------------------------
   
   public List<NoticeDTO> getItemList();
   public int getItemListTotalCount();
   public List<NoticeDTO> getItemList2(PagingDTO paging);
   
   //--------------------------글 등록 시작 ----------------------------------------
   public int insertItem(NoticeDTO nDTO) throws Exception;		//
   //--------------------------글 등록 끝 ------------------------------------------
   
   
   //--------------------------글 상세보기 시작-------------------------------------------------
   public NoticeDTO getSubstanceItem(String post_seq_no) throws Exception;	//
   //--------------------------글 상세보기 끝 ---------------------------------------------------
   
   
   //--------------------------글 수정 시작--------------------------------------------
   public int updateItem(NoticeDTO nDTO) throws Exception;		//
   //--------------------------글 수정 끝---------------------------------------------
   
   
   //--------------------------글 삭제 시작------------------------------------------
   public int deleteItem(String post_seq_no) throws Exception;		//
   //--------------------------글 삭제 끝 --------------------------------------------
   
   
//------------------------------------------------------------------독서실 매핑 시작!------------------------------------------------------
   
   public List<NoticeDTO> getRoomList();
   public int getRoomListTotalCount();
   public List<NoticeDTO> getRoomList2(PagingDTO paging);
   
   //--------------------------글 등록 시작 ----------------------------------------
   public int insertRoom(NoticeDTO nDTO) throws Exception;		//
   //--------------------------글 등록 끝 ------------------------------------------
   
   
   //--------------------------글 상세보기 시작-------------------------------------------------
   public NoticeDTO getSubstanceRoom(String post_seq_no) throws Exception;	//
   //--------------------------글 상세보기 끝 ---------------------------------------------------
   
   
   //--------------------------글 수정 시작--------------------------------------------
   public int updateRoom(NoticeDTO nDTO) throws Exception;		//
   //--------------------------글 수정 끝---------------------------------------------
   
   
   //--------------------------글 삭제 시작------------------------------------------
   public int deleteRoom(String post_seq_no) throws Exception;		//
   //--------------------------글 삭제 끝 --------------------------------------------
   
   
 //------------------------------------------------------------------좋아요!!!!!------------------------------------------------------
   
   public NoticeDTO getKoreanContentLikeUser(String Like_flag) throws Exception;
   
   //얘는 N - > L 로 바꿔줌
   public int updateKoreanContentLike(NoticeDTO nDTO) throws Exception;
   
   //좋아요 데이터베이스에도 글 정보 넘겨주기
   public int insertKoreanContentLike(NoticeDTO nDTO) throws Exception;
   
   //다른 유저 시퀀스 넘버라서 새로 하나 올려주기
   public int updatecntLike(NoticeDTO nDTO) throws Exception;
   
   //원래 좋아요한 유저라서 좋아요 하나 빼주기
   public int updatecntLike2(NoticeDTO nDTO) throws Exception;

   // 유저가 원래 좋아요했는지 지금 처음 하는지 비교하기
   public int compareUsrSeqNo(NoticeDTO nDTO) throws Exception;
   
 /*  //글 번호 가져오기
   public String selectPost(NoticeDTO nDTO) throws Exception;
   
   
  public int gogoKorean(String result1) throws Exception;*/

}
