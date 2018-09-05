package com.team.seahouse;

import com.team.seahouse.commons.utils.JwtTokenUtil;
import com.team.seahouse.commons.utils.StringUtils;
import com.team.seahouse.domain.Collections;
import com.team.seahouse.domain.User;
import com.team.seahouse.mapper.CollectionMapper;
import com.team.seahouse.mapper.UserMapper;
import com.team.seahouse.service.IRedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.team.seahouse.commons.utils.StringUtils.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemo2ApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private CollectionMapper collectionMapper;

	@Autowired
	private IRedisService<String> redisService;
	@Test
	public void contextLoads() {
		User user = userMapper.findByMobilePhone("17691229633");
		System.out.println(user);
	}

	@Test
	public void testStringUtils() {
		String str = "123";
		List<Long> list = StringUtils.stringToArray(str);
		for (Long item : list) {
			System.out.println(item);
		}
	}

	@Test
	public void testCount() {
		Collections collections = new Collections();
		Long userId = 18l;
		collections.setUserId(userId);
		int count = collectionMapper.selectCount(collections);
		System.out.println(count);
	}

	@Test
	public void testToken() {
		String token = "eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNpEjssKwjAURP_lrhNoEvPqviIoFqo7kdAmV4iWtvQBgvjvxm66nMOcYT4wLQ3kwLSyjHOrhAACy4SjiwFypglMvh8Q8htU5alwVbGvisvBXctjcYY7ga7vHL6HOGLqz-OCBFJMqhRGGKMVJxDreQVSW7UC7Oqm3YT_Rtv710aec0yvUKLNjPZUhCDoLmSeWjSKPlBLy1SQimv4_gAAAP__.5UjbzYI8xyp4VXHknHjk3SQkXG2eTWXwrmaMsb-plNo80lWj3yp0tIqpcTAMF2Nj5vbJ5lNAQ2xxnX69eVNpJw";
		JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
		String username = jwtTokenUtil.getUsernameFromToken(token);
		System.out.println(username);
	}

	@Test
	public void testRedisService() {
		redisService.set("user", "wang");
		boolean isExist = redisService.exists("user");
		System.out.println(isExist);
		System.out.println(redisService.get("user"));

	}

}
