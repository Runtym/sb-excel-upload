package com.test.sb2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.sb2.repository.BoardRepository;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestApplicationTests {
	@Autowired
	private BoardRepository br;
	@Test
	public void contextLoads() {
		log.info("boardList=>{}",br.selectBoardList());
		assertEquals(11, br.selectBoardList().size());
	}

}

