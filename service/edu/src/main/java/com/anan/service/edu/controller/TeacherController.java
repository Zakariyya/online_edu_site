package com.anan.service.edu.controller;


import com.anan.common.base.utils.R;
import com.anan.service.edu.orm.Teacher;
import com.anan.service.edu.service.TeacherService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

  // 2 page
  @ApiOperation(value = "分页讲师")
  @GetMapping("page/{current}/{pageSize}")
  public R page(@ApiParam(name = "current", value = "当前页", required = true) @PathVariable Long current,
                @ApiParam(name = "pageSize", value = "每页显示的记录数", required = true) @PathVariable Long pageSize){

    //创建page对象
    Page<Teacher> page = new Page<>(current, pageSize);

    //调用方法实现分页
    //调用方法时候，底层封装，把分页所有数据封装到page对象中
    teacherService.page(page, null);

    page.getTotal();//总记录数
    List<Teacher> records = page.getRecords(); //当前页的数据

    return R.success().data("records", records).data("total", page.getTotal());
  }


}

