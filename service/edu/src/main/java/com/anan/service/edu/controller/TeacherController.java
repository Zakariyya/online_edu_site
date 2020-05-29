package com.anan.service.edu.controller;


import com.anan.common.base.utils.R;
import com.anan.service.edu.orm.Teacher;
import com.anan.service.edu.service.TeacherService;
import com.anan.service.edu.vo.TeacherQuery;
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
@CrossOrigin
public class TeacherController {

  @Autowired
  TeacherService service;

  /**
   * 1 find all
   *
   * @return
   */
  @ApiOperation(value = "所有讲师列表")
  @GetMapping
  public R findAll(){
    List<Teacher> list = service.list(null);
    return R.success(list);
  }


  /**
   * 4 del by id
   *
   * @param id
   * @return
   */
  @ApiOperation(value = "逻辑删除讲师")
  @DeleteMapping("{id}")
  public R deleteById(@ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable String id) {
    return R.success(service.removeById(id),"讲师删除失败");
  }

  /**
   * 2 page
   *
   * @param current
   * @param pageSize
   * @return
   */
  @ApiOperation(value = "分页讲师")
  @GetMapping("page/{current}/{pageSize}")
  public R page(@ApiParam(name = "current", value = "当前页", required = true) @PathVariable Long current,
                @ApiParam(name = "pageSize", value = "每页显示的记录数", required = true) @PathVariable Long pageSize){

    //创建page对象
    Page<Teacher> page = new Page<>(current, pageSize);

    //调用方法实现分页
    //调用方法时候，底层封装，把分页所有数据封装到page对象中
    service.page(page, null);

    page.getTotal();//总记录数
    List<Teacher> records = page.getRecords(); //当前页的数据
    return R.success().data("records", records).data("total", page.getTotal());
  }


  /**
   * 3 page wrapper 条件查询
   *
   * @param query
   * @param current
   * @param pageSize
   * @return
   */
  @ApiOperation(value = "分页讲师 - 条件查询")
  @PostMapping("page/{current}/{pageSize}")
  public R pageCondition(
                @ApiParam(name = "query", value = "分页查询条件", required = true) @RequestBody TeacherQuery query,
                @ApiParam(name = "current", value = "当前页", required = true) @PathVariable Long current,
                @ApiParam(name = "pageSize", value = "每页显示的记录数", required = true) @PathVariable Long pageSize){

    Page page = service.pageCondition(current, pageSize, query);

    return R.success().data("records", page.getRecords()).data("total", page.getTotal());

  }


  /**
   * 根据ID查询讲师
   *
   * @param id
   * @return
   */
  @ApiOperation(value = "根据ID查询讲师")
  @GetMapping("{id}")
  public R findOne(@PathVariable String id) {
    Teacher byId = service.getById(id);
    return R.success(byId);
  }


  /**
   * 添加讲师
   *
   * @param t
   * @return
   */
  @ApiOperation(value = "添加讲师")
  @PostMapping()
  public R addTeacher(@RequestBody Teacher t) {
    boolean save = service.save(t);
    if (save)
      return R.success();
    else
      return R.failure("添加讲师失败");
  }


  /**
   * 修改讲师
   *
   * @param t
   * @return
   */
  @ApiOperation(value = "修改讲师")
  @PutMapping()
  public R updateTeacher(@RequestBody Teacher t) {

    boolean updateById = service.updateById(t);
    if (updateById)
      return R.success();
    else
      return R.failure("修改讲师失败");
  }

}
























