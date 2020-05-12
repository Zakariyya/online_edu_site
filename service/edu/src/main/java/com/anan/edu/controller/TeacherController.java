package com.anan.edu.controller;


import com.anan.edu.orm.Teacher;
import com.anan.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author anan/CodeGenerator
 * @since 2020-05-11
 */
@RestController
@RequestMapping("/edu/teacher")
public class TeacherController {

  @Autowired
  TeacherService teacherService;

  // 1 find all
  @GetMapping
  public List<Teacher> findAll(){
    List<Teacher> list = teacherService.list(null);
    return list;
  }




  // 4 del by id
  @DeleteMapping("{id}")
  public boolean deleteById(@PathVariable String id) {
    return teacherService.removeById(id);
  }



}

