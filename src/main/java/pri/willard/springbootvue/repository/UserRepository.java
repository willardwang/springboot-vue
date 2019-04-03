package pri.willard.springbootvue.repository;

import org.springframework.data.repository.CrudRepository;

import pri.willard.springbootvue.entity.User;

/**
 * @author wangshibao
 * Created on 2019/4/2
 */
public interface UserRepository extends CrudRepository<User, String> {
	/**
	 * 检查某个手机号是否存在
	 *
	 * @param mobile 手机号
	 * @return 存在返回true，不存在返回false
	 */
	boolean existsByMobile(String mobile);

	/**
	 * 检查手机号和密码是否一致
	 *
	 * @param mobile 手机号
	 * @param password 密码
	 * @return 手机号和密码一致返回true，不一致返回false
	 */
	boolean existsByMobileAndPassword(String mobile, String password);

	/**
	 * 根据手机号码查询用户
	 *
	 * @param mobile 手机号码
	 * @return 存在返回该用户，不存在返回null
	 */
	User getByMobile(String mobile);
}
