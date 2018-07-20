package spring.boot.demo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.springboot.demo.Application;
import com.springboot.demo.model.User;
import com.springboot.demo.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
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
