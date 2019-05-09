package poly.persistance.mapper;

import java.util.HashMap;
import java.util.List;

import config.Mapper;
import poly.dto.MemberDTO;
import poly.dto.NoticeDTO;
import poly.dto.PagingDTO;
import poly.dto.UserDTO;

@Mapper("UserMapper")
public interface UserMapper {

	public int insertUser(UserDTO uDTO) throws Exception;
	public UserDTO login(UserDTO uDTO) throws Exception;
	public UserDTO findid(UserDTO uDTO) throws Exception;
	public UserDTO findpw(UserDTO uDTO) throws Exception;
	public int updateUser(UserDTO uDTO) throws Exception;
	public int deleteUser(String usr_seq_no) throws Exception;
	
	public List<UserDTO> getUserList();
	public List<UserDTO> getUserList2(PagingDTO paging);
	public int getUserListTotalCount();
}
