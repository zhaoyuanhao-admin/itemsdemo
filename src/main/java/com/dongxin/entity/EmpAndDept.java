package com.dongxin.entity;

/**
 * 包含员工表和部门表信息的实体类
 */
public class EmpAndDept {

	private Integer empId;
	private String empName;
	private Integer empSalary;
	private Integer deptid;
	private String deptName;

	@Override
	public String toString() {
		return "EmpAndDept{" +
				"empId=" + empId +
				", empName='" + empName + '\'' +
				", empSalary=" + empSalary +
				", deptid=" + deptid +
				", deptName='" + deptName + '\'' +
				'}';
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(Integer empSalary) {
		this.empSalary = empSalary;
	}

	public Integer getDeptid() {
		return deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
