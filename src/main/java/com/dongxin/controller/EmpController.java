package com.dongxin.controller;


import com.dongxin.entity.Emp;
import com.dongxin.entity.EmpAndDept;
import com.dongxin.service.EmpService;
import com.liuzhousteel.swallow.core.exception.PlatformRuntimeException;
import com.liuzhousteel.swallow.core.util.ExportUtil;
import com.liuzhousteel.swallow.core.util.ResultUtil;
import com.liuzhousteel.swallow.core.vo.ResultVO;
import com.liuzhousteel.swallow.extension.controller.BaseController;
import com.liuzhousteel.swallow.extension.hutool.SwallowExcelReader;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;


/**
 * @author zhaoyuanhao
 * create on 2019-09-04 09:47:08
 */
@RestController
@Api(value = "/emp", description = "$tableInfo.comment接口")
@RequestMapping("/emp")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class EmpController extends BaseController<EmpService, Emp>{


	@ApiOperation("两张表的数据一起查询")
	@PostMapping("/find/any")
	public List<EmpAndDept> findAnyController(){
		return service.findAnyService();
	}

	@ApiOperation("通过员工id查询部门名称")
	@PostMapping("/find/deptname/byempid")
	public String findDeptNameByEmpIdController(Integer empId){
		return service.findDeptNameByEmpIdService(empId);
	}

	@ApiOperation("查找工资区间的员工信息")
	@PostMapping("/find/emp/bysalary")
	public List<Emp> findEmpBySalaryController(@RequestParam(defaultValue = "0",value = "lowSalary") Integer lowSalary,
	                                           @RequestParam(defaultValue = "1000000",value = "heightSalary") Integer heightSalary){
		return service.findEmpBySalaryService(lowSalary,heightSalary);
	}

	@ApiOperation(value = "excel导入员工信息",consumes ="multipart/*" )
	@PostMapping(value = "/import",consumes = "multipart/*",headers = "content-type=multipart/form-data")
	public ResultVO<?> importExcel(MultipartFile file)  {
		if(file != null && !file.isEmpty()){

			try {
				InputStream inputStream = file.getInputStream();
				SwallowExcelReader reader = new SwallowExcelReader(inputStream,0,true);


				List<Emp> EmpList = reader.readAll(Emp.class);
				service.importData(EmpList);
				System.out.println(EmpList);

			} catch (IOException e) {
				throw new PlatformRuntimeException(e);
			}
		}

		return ResultUtil.success();
	}

	@ApiOperation("导出xls文件")
	@GetMapping("/export")
	public void export(HttpServletResponse response){
		List<Emp> studentList = service.findAll();
		Map<String, String> headerAliasMap = ExportUtil.getHeaderAliasMap(Emp.class);
		ExportUtil.export(response,studentList,"全部员工信息.xls",headerAliasMap);
	}

}