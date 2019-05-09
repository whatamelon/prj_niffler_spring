package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.MemberDTO;
import poly.dto.NoticeDTO;
import poly.dto.PagingDTO;
import poly.persistance.mapper.NoticeMapper;
import poly.service.INoticeService;

@Service("NoticeService")
public class NoticeService implements INoticeService{
	
	@Resource(name="NoticeMapper")
	private NoticeMapper noticeMapper;
	
	@Override
	public List<NoticeDTO> getNoticeList() {
		return (List<NoticeDTO>)noticeMapper.getNoticeList();
	}
	
	@Override
	public List<NoticeDTO> getNoticeList2(PagingDTO paging) {
		return (List<NoticeDTO>)noticeMapper.getNoticeList2(paging);
	}
	
	@Override
	public int getNoticeListTotalCount() {
		return noticeMapper.getNoticeListTotalCount();
	}
	

	//--------------------------글 등록 시작 -----------------------------------------
	@Override																					//
	public int insertNotice(NoticeDTO nDTO) throws Exception {		//
		return noticeMapper.insertNotice(nDTO);								//
	}																								//
	//--------------------------글 등록 끝 -------------------------------------------
	
	
	
	
	//--------------------------글 상세보기 시작------------------------------------------------
	@Override																									//
	public NoticeDTO getSubstance(String post_seq_no) throws Exception {		//
		return noticeMapper.getSubstance(post_seq_no);									//
	}																												//
	//--------------------------글 상세보기 끝--------------------------------------------------


	

	 //--------------------------글 수정 시작--------------------------------------------
	@Override																						//
	public int updateNotice(NoticeDTO nDTO) throws Exception {			//
		return noticeMapper.updateNotice(nDTO);									//
	}																									//
	 //--------------------------글 수정 끝---------------------------------------------

	

	
	//--------------------------글 삭제 시작------------------------------------------
	@Override																					//
	public int deleteNotice(String post_seq_no) throws Exception {		//
		return noticeMapper.deleteNotice(post_seq_no);								//
	}																								//
	//--------------------------글 삭제 끝-------------------------------------------
	
	
	

	//--------------------------얘내는 뭐지 시작----------------------------------------------------
	@Override																									//	
	public List<NoticeDTO> getAllNotice() throws Exception {							//
		return null;																							//
	}																												//
																													//
	@Override																									//
	public NoticeDTO getNoticeOne(String session_id) throws Exception {			//
		return null;																							//
	}																												//
	//--------------------------얘내는 뭐지 끝----------------------------------------------------

	
	//------------------------------------------------------------------국어 매핑 시작!------------------------------------------------------
	

	@Override
	public List<NoticeDTO> getKoreanList() {
		return (List<NoticeDTO>)noticeMapper.getKoreanList();
	}
	
	@Override
	public List<NoticeDTO> getKoreanList2(PagingDTO paging) {
		return (List<NoticeDTO>)noticeMapper.getKoreanList2(paging);
	}
	
	@Override
	public int getKoreanListTotalCount() {
		return noticeMapper.getKoreanListTotalCount();
	}
	

	//--------------------------글 등록 시작 -----------------------------------------
	@Override																					//
	public int insertKorean(NoticeDTO nDTO) throws Exception {		//
		return noticeMapper.insertKorean(nDTO);								//
	}																								//
	//--------------------------글 등록 끝 -------------------------------------------
	
	
	
	
	//--------------------------글 상세보기 시작------------------------------------------------
	@Override																									//
	public NoticeDTO getSubstanceKorean(String post_seq_no) throws Exception {		//
		return noticeMapper.getSubstanceKorean(post_seq_no);									//
	}																												//
	//--------------------------글 상세보기 끝--------------------------------------------------


	

	 //--------------------------글 수정 시작--------------------------------------------
	@Override																						//
	public int updateKorean(NoticeDTO nDTO) throws Exception {			//
		return noticeMapper.updateKorean(nDTO);									//
	}																									//
	 //--------------------------글 수정 끝---------------------------------------------

	

	
	//--------------------------글 삭제 시작------------------------------------------
	@Override																					//
	public int deleteKorean(String post_seq_no) throws Exception {		//
		return noticeMapper.deleteKorean(post_seq_no);								//
	}																								//
	//--------------------------글 삭제 끝-------------------------------------------
	
	
	
	
	//------------------------------------------------------------------수학 매핑 시작!------------------------------------------------------
	

	@Override
	public List<NoticeDTO> getMathList() {
		return (List<NoticeDTO>)noticeMapper.getMathList();
	}
	
	@Override
	public List<NoticeDTO> getMathList2(PagingDTO paging) {
		return (List<NoticeDTO>)noticeMapper.getMathList2(paging);
	}
	
	@Override
	public int getMathListTotalCount() {
		return noticeMapper.getMathListTotalCount();
	}
	

	//--------------------------글 등록 시작 -----------------------------------------
	@Override																					//
	public int insertMath(NoticeDTO nDTO) throws Exception {		//
		return noticeMapper.insertMath(nDTO);								//
	}																								//
	//--------------------------글 등록 끝 -------------------------------------------
	
	
	
	
	//--------------------------글 상세보기 시작------------------------------------------------
	@Override																									//
	public NoticeDTO getSubstanceMath(String post_seq_no) throws Exception {		//
		return noticeMapper.getSubstanceMath(post_seq_no);									//
	}																												//
	//--------------------------글 상세보기 끝--------------------------------------------------


	

	 //--------------------------글 수정 시작--------------------------------------------
	@Override																						//
	public int updateMath(NoticeDTO nDTO) throws Exception {			//
		return noticeMapper.updateMath(nDTO);									//
	}																									//
	 //--------------------------글 수정 끝---------------------------------------------

	

	
	//--------------------------글 삭제 시작------------------------------------------
	@Override																					//
	public int deleteMath(String post_seq_no) throws Exception {		//
		return noticeMapper.deleteMath(post_seq_no);								//
	}																								//
	//--------------------------글 삭제 끝-------------------------------------------
	
	
	//------------------------------------------------------------------영어 매핑 시작!------------------------------------------------------
	

		@Override
		public List<NoticeDTO> getEngList() {
			return (List<NoticeDTO>)noticeMapper.getEngList();
		}
		
		@Override
		public List<NoticeDTO> getEngList2(PagingDTO paging) {
			return (List<NoticeDTO>)noticeMapper.getEngList2(paging);
		}
		
		@Override
		public int getEngListTotalCount() {
			return noticeMapper.getEngListTotalCount();
		}
		

		//--------------------------글 등록 시작 -----------------------------------------
		@Override																					//
		public int insertEng(NoticeDTO nDTO) throws Exception {		//
			return noticeMapper.insertEng(nDTO);								//
		}																								//
		//--------------------------글 등록 끝 -------------------------------------------
		
		
		
		
		//--------------------------글 상세보기 시작------------------------------------------------
		@Override																									//
		public NoticeDTO getSubstanceEng(String post_seq_no) throws Exception {		//
			return noticeMapper.getSubstanceEng(post_seq_no);									//
		}																												//
		//--------------------------글 상세보기 끝--------------------------------------------------


		

		 //--------------------------글 수정 시작--------------------------------------------
		@Override																						//
		public int updateEng(NoticeDTO nDTO) throws Exception {			//
			return noticeMapper.updateEng(nDTO);									//
		}																									//
		 //--------------------------글 수정 끝---------------------------------------------

		

		
		//--------------------------글 삭제 시작------------------------------------------
		@Override																					//
		public int deleteEng(String post_seq_no) throws Exception {		//
			return noticeMapper.deleteEng(post_seq_no);								//
		}																								//
		//--------------------------글 삭제 끝-------------------------------------------
		
	
		//------------------------------------------------------------------공부템 매핑 시작!------------------------------------------------------
		

		@Override
		public List<NoticeDTO> getItemList() {
			return (List<NoticeDTO>)noticeMapper.getItemList();
		}
		
		@Override
		public List<NoticeDTO> getItemList2(PagingDTO paging) {
			return (List<NoticeDTO>)noticeMapper.getItemList2(paging);
		}
		
		@Override
		public int getItemListTotalCount() {
			return noticeMapper.getItemListTotalCount();
		}
		

		//--------------------------글 등록 시작 -----------------------------------------
		@Override																					//
		public int insertItem(NoticeDTO nDTO) throws Exception {		//
			return noticeMapper.insertItem(nDTO);								//
		}																								//
		//--------------------------글 등록 끝 -------------------------------------------
		
		
		
		
		//--------------------------글 상세보기 시작------------------------------------------------
		@Override																									//
		public NoticeDTO getSubstanceItem(String post_seq_no) throws Exception {		//
			return noticeMapper.getSubstanceItem(post_seq_no);									//
		}																												//
		//--------------------------글 상세보기 끝--------------------------------------------------


		

		 //--------------------------글 수정 시작--------------------------------------------
		@Override																						//
		public int updateItem(NoticeDTO nDTO) throws Exception {			//
			return noticeMapper.updateItem(nDTO);									//
		}																									//
		 //--------------------------글 수정 끝---------------------------------------------

		

		
		//--------------------------글 삭제 시작------------------------------------------
		@Override																					//
		public int deleteItem(String post_seq_no) throws Exception {		//
			return noticeMapper.deleteItem(post_seq_no);								//
		}																								//
		//--------------------------글 삭제 끝-------------------------------------------
		
		
		//------------------------------------------------------------------독서실 매핑 시작!------------------------------------------------------
		

		@Override
		public List<NoticeDTO> getRoomList() {
			return (List<NoticeDTO>)noticeMapper.getRoomList();
		}
		
		@Override
		public List<NoticeDTO> getRoomList2(PagingDTO paging) {
			return (List<NoticeDTO>)noticeMapper.getRoomList2(paging);
		}
		
		@Override
		public int getRoomListTotalCount() {
			return noticeMapper.getRoomListTotalCount();
		}
		

		//--------------------------글 등록 시작 -----------------------------------------
		@Override																					//
		public int insertRoom(NoticeDTO nDTO) throws Exception {		//
			return noticeMapper.insertRoom(nDTO);								//
		}																								//
		//--------------------------글 등록 끝 -------------------------------------------
		
		
		
		
		//--------------------------글 상세보기 시작------------------------------------------------
		@Override																									//
		public NoticeDTO getSubstanceRoom(String post_seq_no) throws Exception {		//
			return noticeMapper.getSubstanceRoom(post_seq_no);									//
		}																												//
		//--------------------------글 상세보기 끝--------------------------------------------------


		

		 //--------------------------글 수정 시작--------------------------------------------
		@Override																						//
		public int updateRoom(NoticeDTO nDTO) throws Exception {			//
			return noticeMapper.updateRoom(nDTO);									//
		}																									//
		 //--------------------------글 수정 끝---------------------------------------------

		

		
		//--------------------------글 삭제 시작------------------------------------------
		@Override																					//
		public int deleteRoom(String post_seq_no) throws Exception {		//
			return noticeMapper.deleteRoom(post_seq_no);								//
		}																								//
		//--------------------------글 삭제 끝-------------------------------------------
		
		@Override
		public int updateKoreanContentLike(NoticeDTO nDTO)  throws Exception{
			System.out.println(nDTO.getPost_seq_no());
			System.out.println(nDTO.getUsr_seq_no());
			System.out.println(nDTO.getLike_flag());
			return noticeMapper.updateKoreanContentLike(nDTO);								//
		}

		@Override
		public NoticeDTO getKoreanContentLikeUser(String Like_flag) throws Exception {
			return noticeMapper.getKoreanContentLikeUser(Like_flag);	
		}

		@Override
		public int insertKoreanContentLike(NoticeDTO nDTO)  throws Exception{
			return noticeMapper.insertKoreanContentLike(nDTO);	
		}

		@Override
		public int updatecntLike(NoticeDTO nDTO) throws Exception {
			return noticeMapper.updatecntLike(nDTO);	
		}

		@Override
		public int updatecntLike2(NoticeDTO nDTO) throws Exception {
			return noticeMapper.updatecntLike2(nDTO);	
		}

		@Override
		public int compareUsrSeqNo(NoticeDTO nDTO) throws Exception {
			return noticeMapper.compareUsrSeqNo(nDTO);	
		}

/*		@Override
		public String selectPost(NoticeDTO nDTO) throws Exception{
			return noticeMapper.selectPost(nDTO);
		}


		@Override
		public int gogoKorean(String result1) throws Exception{
			return noticeMapper.gogoKorean(result1);
		}*/
}


