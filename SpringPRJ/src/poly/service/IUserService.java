package poly.service;

import java.util.HashMap;
import java.util.List;

import poly.dto.MemberDTO;
import poly.dto.PagingDTO;
import poly.dto.UserDTO;

public interface IUserService {

	public int insertUser(UserDTO uDTO) throws Exception;
	public UserDTO login(UserDTO uDTO) throws Exception;
	
	public List<UserDTO> getUserList();
	public List<UserDTO> getUserList2(PagingDTO paging);
	public int getUserListTotalCount();
}