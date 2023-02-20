package com.nt.repositary;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nt.document.Employee;

public interface IEmployeeRepo extends MongoRepository<Employee, Integer> {

	/* Projection Query */
	//@Query(fields = "{eno:0, eadd:1, salary:1}",value = "{eadd:?0}")  //where eadd=?
	@Query(fields = "{ename:1,eadd:1,salary:1}", value = "{eadd:?0}") //where eadd=?
	public List<Object[]> getEmpDataByAddrs(String addrs);

	/* Entity Query */
	//@Query(fields = "{}", value = "{eadd:?0}") //where eadd=?
	@Query(value = "{eadd:?0}") //where eadd=?
	public List<Employee> getEmpAllDataByAddrs(String addrs);

	/* Entity Query */
	//@Query(fields = "{}", value = "{eadd:?0,ename:?1}") //where eadd=? and ename=?
	@Query(value = "{eadd:?0,ename:?1}") //where eadd=? and ename=?
	public List<Employee> getEmpAllDataByAddrsAndName(String addrs, String name);

	/* Entity Query */
	//@Query(value = "{salary:{$gte:?0, $lte:?1} }") 	//where salary>=? and salary<=?
	@Query(value = "{salary:{$gte:?0},salary:{$lte:?1} }") //where salary>=? and salary<=?
	public List<Employee> getEmpAllDataBySalaryRange(Double startSalary, Double endSalary);

	/* Entity Query */
	@Query(value = "{$or:[{eadd:?0},{eadd:?1}]}") 	//where eadd=? or eadd=?
	public List<Employee> getEmpAllDataByAddresses(String address1, String address2);

	/* Entity Query */
	//@Query(value = "{ ename:{'$regex':?0, '$options' : 'i'}}" ) // 'i' for case-insensitivity is applied
	@Query(value = "{ename:{'$regex':?0}}") //where ename like('%') is applied
	public List<Employee> getEmpAllDataByEnameInitialChars(String initialChars);

}
