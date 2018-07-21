package spring.boot.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.springboot.demo.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class GetProperties {

	@Autowired
	private Environment env;

	@Value("{spring.datasource.url}")
	private String url;

	@Test
	public void testEnv() {
		System.out.println("----");
		System.out.println(env.getProperty("spring.redis.database"));
	}

	@Test
	public void testValue() {
		System.out.println(env.getProperty("spring.datasource.url"));
	}

}
