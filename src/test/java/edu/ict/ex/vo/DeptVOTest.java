package edu.ict.ex.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;


class DeptVOTest {

	@DisplayName("Dept 테스트")
	@Test
	void testDeptVO() {
		DeptVO deptVO = new DeptVO();
		
		deptVO.setDeptno(1000);
		deptVO.setDname("리서치");
		deptVO.setLoc("스위스");	
		
		
		System.out.println(deptVO.getDeptno());
		System.out.println(deptVO.getDname());
		System.out.println(deptVO.getLoc());	
		
		assumeTrue(deptVO.getLoc().contains("스위승"));
		assertThat(deptVO.getLoc()).contains("스위승");
		
	}
	
	

}
