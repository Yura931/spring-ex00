package org.zerock.sample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j // lombok에 있는 log4j가 할당, log라는 필드를 사용할 수 있도록 자동으로 만들어 줌
public class SampleTests {
	
	@Autowired // 필드에 붙여도 자동으로 붙일 수 있지만 권장되는 	방법은 아니다.
	private ApplicationContext context;
	
	@Setter(onMethod_ = {@Autowired}) // 메소드를 만들면, 오토와이어드, 오버라이드, 등 여러 어노테이션이 붙을 수 있어서 배열로 선언, 지금은 오토와이어드 하나만 사용하므로 중괄호 안에 값이 하나만 있는 것
	private Restaurant restaurant;
	
	@Test
	public void testExist() {
		assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("---------------------------");
		log.info(restaurant.getChef());
	}
	
	@Test
	public void testExist2() {
		Chef c1 = (Chef) context.getBean("chef");
		Restaurant r1 = (Restaurant) context.getBean("restaurant");
		
		assertNotNull(r1.getChef());
		assertEquals(c1, r1.getChef());
		
		log.info("------");
		assertNotNull(context); 
		assertNotNull(context.getBean("chef"));
		assertNotNull(context.getBean("restaurant"));
	}
}
