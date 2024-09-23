package edu.ict.ex.vo.join;

import java.sql.Timestamp;

import edu.ict.ex.vo.DeptVO;
import edu.ict.ex.vo.EmpVO;
import edu.ict.ex.vo.SalgradeVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmpDeptSalgradeVO {
	private EmpVO emp;
	private SalgradeVO salgrade;
	private DeptVO dept;
	
	public int getRandImgNum() {
		return (int)(Math.random()*6) + 1;
	}
}
