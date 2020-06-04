package com.anan.service.edu.orm.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 课程分类 excel 对应字段的实体类
 * 与excel 形成对应关系
 * @Author: anan
 * @Date: 2020/6/4 14:37
 */
@Data
public class SubjectData {

  @ExcelProperty(index = 0)
  private String oneSubjectName;

  @ExcelProperty(index = 1)
  private String twoSubjectName;

}
