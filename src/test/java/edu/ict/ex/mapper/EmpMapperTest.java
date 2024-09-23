package edu.ict.ex.mapper;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.ict.ex.page.Criteria;
import edu.ict.ex.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class EmpMapperTest {
	
	@Autowired
	private EmpMapper mapper;

	@Disabled
	@Test
	void testGetEmpSalgrade() {
		System.out.println(mapper.getEmpSalgrade());
	}
	
	@Test
	void testGetEmpDeptSalgrade() {
		System.out.println(mapper.getEmpDeptSalgrade());
	}
	


	

}
