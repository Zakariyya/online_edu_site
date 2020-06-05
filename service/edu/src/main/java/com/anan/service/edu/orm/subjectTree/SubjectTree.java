package com.anan.service.edu.orm.subjectTree;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 课程分类，树形结构
 * 一级分类
 * @Author: anan
 * @Date: 2020/6/4 18:58
 */
@Data
public class SubjectTree {

  String id;
  String title;

  List<SubjectTree> children = new ArrayList<>();


}
