package pri.willard.springbootvue.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pri.willard.springbootvue.entity.User;
import pri.willard.springbootvue.exception.CustomException;
import pri.willard.springbootvue.exception.ExceptionCode;
import pri.willard.springbootvue.repository.UserRepository;

/**
 * @author wangshibao
 * Created on 2019/4/3
 */
@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User register(String mobile, String password, String username) {
		boolean exists = userRepository.existsByMobile(mobile);
		if (exists) {
			throw new CustomException(ExceptionCode.MOBILE_ALREADY_EXISTS, "该手机号已经注册");
		}

		User user = new User();
		user.setCreateDate(LocalDateTime.now());
		user.setUsername(username);
		user.setPassword(password);
		user.setMobile(mobile);
		return userRepository.save(user);
	}

	@Override
	public User login(String mobile) {
		return null;
	}
}
