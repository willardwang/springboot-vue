package pri.willard.springbootvue.repository;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pri.willard.springbootvue.entity.User;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //不使用内嵌的数据库用来测试
@Commit //测试完成后提交（默认回滚）
public class UserRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository userRepository;

	@Test
	public void save() {
		User user = new User();
		user.setCreateDate(LocalDateTime.now());
		user.setMobile("15303385302");
		user.setPassword("pwd");
		user.setUsername("王石宝");

		userRepository.save(user);
	}

	@Test
	public void existsByMobile() {
		boolean result = userRepository.existsByMobile("15303385302");
		Assert.assertTrue(result);
	}

	@Test
	public void existsByMobileAndPassword() {
		boolean result = userRepository.existsByMobileAndPassword("15303385302", "pwd");
		Assert.assertTrue(result);
	}

	@Test
	public void getByMobile() {
		User user = userRepository.getByMobile("15303385302");
		Assert.assertNotNull(user);

		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println(mapper.writeValueAsString(user));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}