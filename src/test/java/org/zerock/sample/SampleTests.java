package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j // lombok에 있는 log4j가 할당, log라는 필드를 사용할 수 있도록 자동으로 만들어 줌
public class SampleTests {
	
	@Autowired // 필드에 붙여도 자동으로 붙일 수 있지만 권장되는 	방법은 아니다.
	private ApplicationContext context;
	
	@Test
	public void testExist() {
		log.info("------");
		assertNotNull(context); 
		assertNotNull(context.getBean("chef"));
		assertNotNull(context.getBean("restaurant"));
	}
}
