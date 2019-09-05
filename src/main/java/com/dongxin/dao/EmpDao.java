package com.dongxin.dao;

import com.dongxin.entity.Emp;
import com.dongxin.entity.EmpAndDept;
import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.mapper.BaseMapper;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Emp)表数据库访问层
 *
 * @author zhaoyuanhao
 * create on 2019-09-04 09:47:08
 */
@Repository
@SqlResource("Emp")
public interface EmpDao extends BaseMapper<Emp> {
    /**
     * 分页查询
     */
    void queryByPage(PageQuery<Emp> pageQuery);

    /**
     * 根据员工id查询员工部门名称
     * @param empId 员工id
     * @return
     */
    String findDeptNameByEmpId(@Param("empId") Integer empId);

    /**
     * 根据工资范围查找员工信息
     * @param lowSalary 最低工资
     * @param heightSalary 最高工资
     * @return
     */
    List<Emp> findEmpBySalary(@Param("lowSalary") Integer lowSalary , @Param("heightSalary") Integer heightSalary);

    /**
     * 把两张表的所有数据合并
     * @return
     */
    List<EmpAndDept> findAny();

}