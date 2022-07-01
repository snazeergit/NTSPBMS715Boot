package com.nt.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("mySqlEmpDAO")
@Profile({"dev", "test"})
public class MySqlEmployeeDAOImpl implements IEmployeeDAO {

	private static final String GET_EMPS_BY_DESGS = "SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMPLOYEE WHERE JOB IN(?,?,?) ORDER BY JOB";

	@Autowired
	private DataSource ds;

	public MySqlEmployeeDAOImpl() {
	System.out.println("MySqlEmployeeDAOImpl.MySqlEmployeeDAOImpl()");
	}
	
	
	@Override
	public List<Employee> getEmployeesByDesgs(String desg1, String desg2, String desg3) throws Exception {

		System.out.println("EmployeeDAOImpl.getEmployeesByDesgs(): "+ds.getClass());

		List<Employee> empList = null;
		Connection con = ds.getConnection();
		PreparedStatement ps = con.prepareStatement(GET_EMPS_BY_DESGS);

		try (con; ps) {
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			ResultSet rs = ps.executeQuery();
			try (rs) {
				empList = new ArrayList<>();
				while (rs.next()) {
					Employee emp = new Employee();
					emp.setEno(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setJob(rs.getString(3));
					emp.setSalary(rs.getDouble(4));
					emp.setDeptNo(rs.getInt(5));
					empList.add(emp);
				}
			}
		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			throw e;
		}
		return empList;
	}
}
