package com.dongxin.service;

import com.dongxin.dao.DeptDao;
import com.dongxin.entity.Dept;
import com.dongxin.entity.Emp;
import com.liuzhousteel.swallow.extension.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Dept)表服务
 *
 * @author zhaoyuanhao
 * create on 2019-09-04 09:47:08
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class DeptService extends BaseService<DeptDao, Dept>{



	public List<Emp> findEmpByDeptNameService(String deptName){
		return dao.findEmpByName(deptName);
	}


}