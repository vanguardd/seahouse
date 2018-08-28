package com.team.seahouse;

import com.team.seahouse.domain.User;
import com.team.seahouse.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemo2ApplicationTests {

	@Autowired
	private UserMapper userMapper;
	@Test
	public void contextLoads() {
		User user = userMapper.findByMobilePhone("17691229633");
		System.out.println(user);
	}

}
