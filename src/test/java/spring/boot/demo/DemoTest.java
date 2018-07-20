package spring.boot.demo;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.springboot.demo.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class DemoTest {

	@Test
	public void test() {
		List<Hosting> list = new ArrayList<Hosting>();
		list.add(new Hosting(1, "Spring"));
		list.add(new Hosting(2, "SpringBoot"));
		list.add(new Hosting(3, "SpringCloud"));

		Map<Integer, String> result1 = list.stream().collect(Collectors.toMap(Hosting::getId, x -> x.getName()));
		System.out.println(result1);
	}

}

class Hosting {
	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hosting(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
}
