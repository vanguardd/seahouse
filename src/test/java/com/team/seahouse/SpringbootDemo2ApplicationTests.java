package com.team.seahouse;

import com.team.seahouse.commons.utils.StringUtils;
import com.team.seahouse.domain.Collections;
import com.team.seahouse.domain.User;
import com.team.seahouse.mapper.CollectionMapper;
import com.team.seahouse.mapper.UserMapper;
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
	@Test
	public void contextLoads() {
		User user = userMapper.findByMobilePhone("17691229633");
		System.out.println(user);
	}

	@Test
	public void testStringUtils() {
		String str = "123,234,5432";
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

}
