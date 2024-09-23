package edu.ict.ex.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ict.ex.vo.DeptVO;

//DeptRepository

//@Bean = @Component 
//@Bean + Dao 의 의미 
@Repository
public class DeptDao {
	
	@Autowired
	private DataSource dataSource;
	
	public List<DeptVO> deptSelect() {

		List<DeptVO> vos = new ArrayList<>();

		Connection connetion = null;
		Statement statement = null;
		ResultSet rs = null;

	
		String sql = "select * from dept";

		try {
						
			connetion = dataSource.getConnection();

			statement = connetion.createStatement();
			rs = statement.executeQuery(sql);

			while (rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");

				DeptVO vo = new DeptVO(deptno, dname, loc);

				vos.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();

				if (statement != null)
					statement.close();

				if (connetion != null)
					connetion.close();
			} catch (Exception e) {
			}

		}

		return vos;

	}

}
