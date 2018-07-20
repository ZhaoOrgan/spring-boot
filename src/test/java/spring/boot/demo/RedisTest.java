package spring.boot.demo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.demo.common.utils.RedisUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
	
	@Resource
	private RedisUtil redisutils;

	@Test
	public void test() {
		redisutils.set("1", "qwrtyu");
		System.out.println(redisutils.get("1"));
	}

}
