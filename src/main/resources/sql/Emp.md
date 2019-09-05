queryByPage
===
SELECT 
@pageTag(){
    * 
@}
FROM emp 
WHERE 1=1


findDeptNameByEmpId
===
SELECT 
dept_name
FROM emp e JOIN dept d
ON e.deptId=d.dept_id
WHERE emp_id = #{empId}

findEmpBySalary
===
SELECT
emp_id,emp_name,emp_salary,deptId
FROM emp
WHERE emp_salary between #{lowSalary} and #{heightSalary}

findAny
===
SELECT
emp_id,emp_name,emp_salary,deptId,dept_name
FROM emp join dept
on deptId=dept_id
