package com.dongxin;


import com.dongxin.dao.DeptDao;
import com.dongxin.dao.EmpDao;
import com.dongxin.entity.Emp;
import com.dongxin.entity.EmpAndDept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class daoTest {

	@Autowired
	EmpDao empdao;
	@Autowired
	DeptDao deptdao;

	@Test
	public void findDeptNameByEmpId(){
		String deptName = empdao.findDeptNameByEmpId(2);
		System.out.println(deptName);
	}

	@Test
	public void findEmpByDeptName(){
		List<Emp> empList = deptdao.findEmpByName("研发部");
		for(Emp e : empList){
			System.out.println(e);
		}
	}

	@Test
	public void findEmpBySalary(){
		List<Emp> empList = empdao.findEmpBySalary(1000,6000);
		for(Emp emp : empList){
			System.out.println(emp);
		}
	}

	@Test
	public void findAll(){
		List<EmpAndDept> empList = empdao.findAny();
		for(EmpAndDept emp : empList){
			System.out.println(emp);
		}
	}

}
