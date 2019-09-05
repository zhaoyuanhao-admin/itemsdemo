package com.dongxin.entity;

import lombok.*;
import org.beetl.sql.core.TailBean;
import org.beetl.sql.core.annotatoin.Table;
import java.io.Serializable;

/**
 * (Dept)实体类
 *
 * @author zhaoyuanhao
 * create on 2019-09-04 09:47:08
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "dept")
public class Dept extends TailBean implements Serializable {
    private static final long serialVersionUID = 366180636702915605L;
    /**
     * 部门id
     */
    private Integer deptId;
    /**
     * 部门名称
     */
    private String deptName;

}