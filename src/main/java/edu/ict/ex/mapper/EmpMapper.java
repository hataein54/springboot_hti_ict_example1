package edu.ict.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.ict.ex.page.Criteria;
import edu.ict.ex.vo.BoardVO;
import edu.ict.ex.vo.DeptEmpVO;
import edu.ict.ex.vo.DeptVO;
import edu.ict.ex.vo.EmpDeptVO;
import edu.ict.ex.vo.EmpVO;
import edu.ict.ex.vo.join.EmpDeptSalgradeVO;
import edu.ict.ex.vo.join.EmpSalgradeVO;

//마이바티스용 인터페이스라는걸 알려주는 애노테이션
@Mapper
public interface EmpMapper {

	public List<EmpVO> getList();
	public int insert(EmpVO empVO);
	
	
	//페이징 관련
	int getTotalCount();
	List<EmpVO> getListWithPaging(Criteria cri);
	
	//연습문제 join 처리	
	List<EmpSalgradeVO> getEmpSalgrade();
	
	//연습문제 join 처리2	
	List<EmpDeptSalgradeVO> getEmpDeptSalgrade();
	
}
