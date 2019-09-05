package com.dongxin.dao;

import com.dongxin.entity.Dept;
import com.dongxin.entity.Emp;
import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.mapper.BaseMapper;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Dept)表数据库访问层
 *
 * @author zhaoyuanhao
 * create on 2019-09-04 09:47:08
 */
@Repository
@SqlResource("Dept")
public interface DeptDao extends BaseMapper<Dept> {
    /**
     * 分页查询
     */
    void queryByPage(PageQuery<Dept> pageQuery);

    /**
     * 根据部门名称，查找对应部门的员工
     * @param deptName 部门名称
     * @return
     */
    List<Emp> findEmpByName(@Param("deptName") String deptName);



}










