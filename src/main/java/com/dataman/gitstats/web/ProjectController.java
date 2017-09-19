package com.dataman.gitstats.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dataman.gitstats.param.AddProjectParam;
import com.dataman.gitstats.service.ProjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "/project")
@RestController
@RequestMapping(value = "/project", produces = "application/json;charset=utf-8")
public class ProjectController extends BaseController {
	
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	@ApiOperation(value = "添加需要统计的项目")
	public Object addProject(@Valid @RequestBody AddProjectParam param,BindingResult bingingresult){
		json.clear();
		if(bingingresult.hasErrors()){
			setJson(PARAMERR_CODE,bingingresult.getAllErrors());
			return json;
		}
		try {
			setJson(SUCCESS_CODE, projectService.addProject(param));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			setJson(FAIL_CODE, e.getMessage());
		}
		return json;
	}
}
