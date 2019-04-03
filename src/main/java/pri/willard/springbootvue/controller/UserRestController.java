package pri.willard.springbootvue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pri.willard.springbootvue.entity.User;
import pri.willard.springbootvue.service.UserService;

/**
 * @author wangshibao
 * Created on 2019/4/3
 */
@RestController
@CrossOrigin
public class UserRestController {

	private final UserService userService;

	@Autowired
	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public String register(@RequestBody User user) {
		User resister = userService.register(user.getMobile(), user.getPassword(), user.getUsername());
		return resister.getId();
	}

}
