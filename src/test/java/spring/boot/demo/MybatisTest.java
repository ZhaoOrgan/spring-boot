package spring.boot.demo;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.demo.model.User;
import com.springboot.demo.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {

	@Resource
	@Lazy
	private UserService userservice;

	@Test
	public void readTest() {
		System.out.println(userservice.queryAllUser());
	}

	@Test
	public void writeTest() {
		System.out.println(userservice.save(new User()));
	}

}
