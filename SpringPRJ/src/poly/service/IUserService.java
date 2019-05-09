package poly.service;

import java.util.HashMap;
import java.util.List;

import poly.dto.MemberDTO;
import poly.dto.PagingDTO;
import poly.dto.UserDTO;

public interface IUserService {

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