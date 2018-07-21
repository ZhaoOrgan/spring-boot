package spring.boot.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.springboot.demo.Application;

/**
 * @description: 动态创建定时任务
 * @author zhaoxuefeng
 * @date 2018年7月21日 上午12:23:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class QuartzTest {
	
	@Test
	public void createQuartz() {
		
	}

}
