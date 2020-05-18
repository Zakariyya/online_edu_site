package com.anan.service.edu.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 讲师 条件查询
 * @Author: anan
 * @Date: 2020/5/13 14:54
 */
@Data
public class TeacherQuery {

  @ApiModelProperty(value = "教师名称，模糊查询")
  private String name;

  @ApiModelProperty(value = "头衔 1高级讲师，2首席讲师")
  private String level;

  @ApiModelProperty(value = "查询开始时间",example = "2020-01-01 01:01:01")
  private String begin;

  @ApiModelProperty(value = "查询结束时间",example = "2020-05-10 00:00:00")
  private String end;

}
