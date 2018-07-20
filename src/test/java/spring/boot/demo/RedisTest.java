package spring.boot.demo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.springboot.demo.Application;
import com.springboot.demo.common.utils.RedisUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class RedisTest {

	@Resource
	private RedisUtil redisutils;

	@Test
	public void test() {
		redisutils.set("1", "qwrtyu");
		System.out.println(redisutils.get("1"));
	}

}
