package poly.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.MemberDTO;
import poly.persistance.mapper.MemberMapper;
import poly.service.IMemberService;

@Service("MemberService")
public class MemberService implements IMemberService {
	
	@Resource(name="MemberMapper")
	private MemberMapper memberMapper;
	
	@Override
	public int insertMember(MemberDTO mDTO) throws Exception {
		return memberMapper.insertMember(mDTO);
	}

	@Override
	public List<MemberDTO> getAllMember() throws Exception {
		return memberMapper.getAllMember();
	}

	@Override
	public MemberDTO getMemberOne(String memberId) throws Exception {
		return memberMapper.getMemberOne(memberId);
	}

	@Override
	public int deleteMember(String memberId) throws Exception {
		return memberMapper.deleteMember(memberId);
	}

	@Override
	public int updateMember(MemberDTO mDTO) throws Exception {
		return memberMapper.updateMember(mDTO);
	}

	@Override
	public MemberDTO getLogin(HashMap<String, String> param) throws Exception {
		return memberMapper.getLogin(param);
	}

	@Override
	public String getIdChk(MemberDTO mDTO) throws Exception {
		return memberMapper.getIdChk(mDTO);
	}

	@Override
	public List<MemberDTO> getSearchList(MemberDTO mDTO) throws Exception {
		return memberMapper.getSearchList(mDTO);
	}

}
