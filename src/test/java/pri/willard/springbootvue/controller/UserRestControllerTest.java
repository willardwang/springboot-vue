package pri.willard.springbootvue.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import pri.willard.springbootvue.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserRestControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void register() throws Exception {
		User user = new User();
		user.setMobile("15303385302");
		user.setPassword("pwd");
		user.setUsername("willard");

		ObjectMapper objectMapper = new ObjectMapper();
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/rest/user").accept(MediaType.APPLICATION_JSON)
																	  .contentType(MediaType.APPLICATION_JSON_UTF8)
																	  .content(objectMapper.writeValueAsString(user));
		MvcResult mvcResult = mockMvc.perform(builder).andReturn();
		System.out.println(mvcResult.getResponse().getContentAsString());
	}
}