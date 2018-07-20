package spring.boot.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GetProperties {

	@Autowired
	private Environment env;
	
	@Value("{spring.datasource.url}")
	private String url;
	
	@Test
	public void testEnv() {
		System.out.println(env.getProperty("spring.redis.database"));
	}
	
	@Test
	public void testValue() {
		System.out.println(env.getProperty("spring.datasource.url"));
	}
	
	/**
	 * @ConfigurationProperties
	 */
}
