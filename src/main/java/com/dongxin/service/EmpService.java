package com.dongxin.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.ObjectUtil;
import com.dongxin.dao.EmpDao;
import com.dongxin.entity.Emp;
import com.dongxin.entity.EmpAndDept;
import com.liuzhousteel.swallow.extension.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * (Emp)表服务
 *
 * @author zhaoyuanhao
 * create on 2019-09-04 09:47:08
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class EmpService extends BaseService<EmpDao, Emp>{

    public String findDeptNameByEmpIdService(Integer empId){
    	return dao.findDeptNameByEmpId(empId);
    }

    public List<Emp> findEmpBySalaryService(Integer lowSalary, Integer heightSalary){
    	return dao.findEmpBySalary(lowSalary,heightSalary);
    }

    public List<EmpAndDept> findAnyService(){
    	return dao.findAny();
    }

	/**
	 * 先检查数据库，如果已经存在名字一样的数据，则认为是做更新操作，
	 * 反zhi，做插入操作
	 * @param
	 */
	@Transactional(rollbackFor = Exception.class)
	public void importData(List<Emp> empList){
		for(Emp emp :empList){
			Emp stu = dao.createLambdaQuery()
					.andEq(Emp::getEmpName, emp.getEmpName())
					.single();
			if(ObjectUtil.isNotNull(stu)){
				BeanUtil.copyProperties(emp,stu, CopyOptions.create().setIgnoreNullValue(true));
				dao.updateTemplateById(stu);
			}else {
				dao.insert(emp,true);
			}
		}
	}


}