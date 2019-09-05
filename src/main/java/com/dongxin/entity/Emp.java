package com.dongxin.entity;

import com.liuzhousteel.swallow.core.annotation.ExcelField;
import lombok.*;
import org.beetl.sql.core.TailBean;
import org.beetl.sql.core.annotatoin.Table;

import java.io.Serializable;

/**
 * (Emp)实体类
 *
 * @author zhaoyuanhao
 * create on 2019-09-04 09:47:08
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "emp")
public class Emp extends TailBean implements Serializable {
    private static final long serialVersionUID = 970066411333297584L;
    /**
     * 员工ID
     */
    @ExcelField("员工id")
    private Integer empId;
    /**
     * 员工姓名
     */
    @ExcelField("员工姓名")
    private String empName;
    /**
     * 员工工资
     */
    @ExcelField("工资")
    private Integer empSalary;
    /**
     * 员工所对应的部门id 
     */
    @ExcelField("所属部门编号")
    private Integer deptid;


}