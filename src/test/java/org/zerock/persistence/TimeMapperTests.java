package org.zerock.persistence;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.zerock.mapper.TImeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class TimeMapperTests {

	@Setter(onMethod_ = @Autowired)
	private TImeMapper timeMapper;
	
	@Test
	public void test() {
		assertNotNull(timeMapper);
		
		log.info("--------------------------------");
		log.info(timeMapper.getClass().getName());
		log.info("--------------------------------");
		log.info(timeMapper.getTime());
	}

	@Test
	public void testGetTime2() {
		assertNotNull(timeMapper.getTime2());
		log.info(timeMapper.getTime2());
	}
}
