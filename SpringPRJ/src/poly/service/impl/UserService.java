package poly.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.UserDTO;
import poly.persistance.mapper.UserMapper;
import poly.service.IUserService;

@Service("UserService")
public class UserService implements IUserService {
	
	@Resource(name="UserMapper")
	private UserMapper userMapper;

	@Override
	public int insertUser(UserDTO uDTO) throws Exception {
		return userMapper.insertUser(uDTO);
	}

	@Override
	public UserDTO login(UserDTO uDTO) throws Exception {
		return userMapper.login(uDTO);
	}
	
}
