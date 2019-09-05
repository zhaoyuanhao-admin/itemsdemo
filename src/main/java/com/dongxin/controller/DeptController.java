package com.dongxin.controller;


import com.dongxin.entity.Dept;
import com.dongxin.entity.Emp;
import com.dongxin.service.DeptService;
import com.liuzhousteel.swallow.extension.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author zhaoyuanhao
 * create on 2019-09-04 09:47:08
 */
@RestController
@Api(value = "/dept", description = "$tableInfo.comment接口")
@RequestMapping("/dept")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class DeptController extends BaseController<DeptService, Dept>{

	@ApiOperation("通过部门名称查询该部门的所有员工")
	@PostMapping("/find/emp/bydeptname")
	public List<Emp> findEmpByDeptNameController(String deptName){
		return service.findEmpByDeptNameService(deptName);
	}
    
}