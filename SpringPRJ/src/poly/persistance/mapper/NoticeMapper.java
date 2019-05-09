package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.UserDTO;
import poly.dto.NoticeDTO;
import poly.dto.PagingDTO;

@Mapper("NoticeMapper")
public interface NoticeMapper {

   public List<NoticeDTO> getNoticeList();
   public List<NoticeDTO> getNoticeList2(PagingDTO paging);
   public int getNoticeListTotalCount();
   //isertnotice추가
   
   public int insertNotice(NoticeDTO nDTO)  throws Exception;
   //게시글 정보
   public NoticeDTO getSubstance(String post_seq_no)  throws Exception;
  
   //게시글 수정
   public int updateNotice(NoticeDTO nDTO) throws Exception;
   public NoticeDTO getNoticeOne(String session_id) throws Exception;
   public int deleteNotice(String post_seq_no) throws Exception;
   
	//------------------------------------------------------------------귝어 매핑 시작!------------------------------------------------------
   
   public List<NoticeDTO> getKoreanList();
   public List<NoticeDTO> getKoreanList2(PagingDTO paging);
   public int getKoreanListTotalCount();
   
   public int insertKorean(NoticeDTO nDTO)  throws Exception;
   //게시글 정보
   public NoticeDTO getSubstanceKorean(String post_seq_no)  throws Exception;
  
   //게시글 수정
   public int updateKorean(NoticeDTO nDTO) throws Exception;
   public int deleteKorean(String post_seq_no) throws Exception;
   public NoticeDTO getKoreanOne(String session_id) throws Exception;
   
   
//------------------------------------------------------------------수학 매핑 시작!------------------------------------------------------
   
   public List<NoticeDTO> getMathList();
   public List<NoticeDTO> getMathList2(PagingDTO paging);
   public int getMathListTotalCount();
   
   public int insertMath(NoticeDTO nDTO)  throws Exception;
   //게시글 정보
   public NoticeDTO getSubstanceMath(String post_seq_no)  throws Exception;
  
   //게시글 수정
   public int updateMath(NoticeDTO nDTO) throws Exception;
   public int deleteMath(String post_seq_no) throws Exception;
   public NoticeDTO getMathOne(String session_id) throws Exception;
   
   
//------------------------------------------------------------------영어 매핑 시작!------------------------------------------------------
   
   public List<NoticeDTO> getEngList();
   public List<NoticeDTO> getEngList2(PagingDTO paging);
   public int getEngListTotalCount();
   
   public int insertEng(NoticeDTO nDTO)  throws Exception;
   //게시글 정보
   public NoticeDTO getSubstanceEng(String post_seq_no)  throws Exception;
  
   //게시글 수정
   public int updateEng(NoticeDTO nDTO) throws Exception;
   public int deleteEng(String post_seq_no) throws Exception;
   public NoticeDTO getEngOne(String session_id) throws Exception;
   
   
//------------------------------------------------------------------공부템 매핑 시작!------------------------------------------------------
   
   public List<NoticeDTO> getItemList();
   public List<NoticeDTO> getItemList2(PagingDTO paging);
   public int getItemListTotalCount();
   
   public int insertItem(NoticeDTO nDTO)  throws Exception;
   //게시글 정보
   public NoticeDTO getSubstanceItem(String post_seq_no)  throws Exception;
  
   //게시글 수정
   public int updateItem(NoticeDTO nDTO) throws Exception;
   public int deleteItem(String post_seq_no) throws Exception;
   public NoticeDTO getItemOne(String session_id) throws Exception;
   
   
//------------------------------------------------------------------독서실 매핑 시작!------------------------------------------------------
   
   public List<NoticeDTO> getRoomList();
   public List<NoticeDTO> getRoomList2(PagingDTO paging);
   public int getRoomListTotalCount();
   
   public int insertRoom(NoticeDTO nDTO)  throws Exception;
   //게시글 정보
   public NoticeDTO getSubstanceRoom(String post_seq_no)  throws Exception;
  
   //게시글 수정
   public int updateRoom(NoticeDTO nDTO) throws Exception;
   public int deleteRoom(String post_seq_no) throws Exception;
   public NoticeDTO getRoomOne(String session_id) throws Exception;
   
   // 좋습니까
   public int updateKoreanContentLike(NoticeDTO nDTO) throws Exception;
   
   public NoticeDTO getKoreanContentLikeUser(String Like_flag) throws Exception;
   
   public int insertKoreanContentLike(NoticeDTO nDTO) throws Exception;
   
   public int updatecntLike(NoticeDTO nDTO) throws Exception;
   
   public int updatecntLike2(NoticeDTO nDTO) throws Exception;

   public int compareUsrSeqNo(NoticeDTO nDTO) throws Exception;
   
/*   public String selectPost(NoticeDTO nDTO) throws Exception;

   public int gogoKorean(String result1) throws Exception;*/
   
}
