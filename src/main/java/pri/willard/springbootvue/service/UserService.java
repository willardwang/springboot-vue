package pri.willard.springbootvue.service;

import pri.willard.springbootvue.entity.User;

/**
 * @author wangshibao
 * Created on 2019/4/2
 */
public interface UserService {

	User register(String mobile, String password, String username);

	User login(String mobile);
}
