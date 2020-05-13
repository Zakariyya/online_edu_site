package com.anan.service.edu.controller;


import com.anan.common.base.utils.R;
import com.anan.service.edu.orm.Teacher;
import com.anan.service.edu.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author anan/CodeGenerator
 * @since 2020-05-11
 */
@Api(tags = {"讲师管理"})
@RestController
@RequestMapping("/edu/teacher")
public class TeacherController {

  @Autowired
  TeacherService teacherService;

  // 1 find all
  @ApiOperation(value = "所有讲师列表")
  @GetMapping
  public R findAll(){
    List<Teacher> list = teacherService.list(null);
    return R.success(list);
  }


  // 4 del by id
  @ApiOperation(value = "逻辑删除讲师")
  @DeleteMapping("{id}")
  public R deleteById(@ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable String id) {
    return R.success(teacherService.removeById(id),"讲师删除失败");
  }




}

