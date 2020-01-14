package com.challenge;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringChallengeApplicationTests {

	@Autowired
	UserService userService;

	@Test
	public void contextLoads() {
	}

	//UserService
	@Test
	public void findUserById() {
		User user = userService.findById(1l).get();
		Assert.assertThat(user.getFullName(), Matchers.equalTo("Jefferson adriano monteiro"));
	}

	@Test
	public void findByAccelerationName() {
		List<User> user = userService.findByAccelerationName("banco inter");
		String userName = user.stream().map(User::getFullName).findFirst().get();
		Assert.assertThat(userName, Matchers.equalTo("Jefferson adriano monteiro"));
	}
}
