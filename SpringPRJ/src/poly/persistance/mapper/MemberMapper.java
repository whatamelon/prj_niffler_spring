package poly.persistance.mapper;

import java.util.HashMap;
import java.util.List;

import config.Mapper;
import poly.dto.MemberDTO;

@Mapper("MemberMapper")
public interface MemberMapper {
	public int insertMember(MemberDTO mDTO) throws Exception;
	public List<MemberDTO> getAllMember() throws Exception;
	public MemberDTO getMemberOne(String memberId) throws Exception;
	public int deleteMember(String memberId) throws Exception;
	public int updateMember(MemberDTO mDTO) throws Exception;
	public MemberDTO getLogin(HashMap<String, String> param) throws Exception;
	public String getIdChk(MemberDTO mDTO) throws Exception;
	public List<MemberDTO> getSearchList(MemberDTO mDTO) throws Exception;
}
