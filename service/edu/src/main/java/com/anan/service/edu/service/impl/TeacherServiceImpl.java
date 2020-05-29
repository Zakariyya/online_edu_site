package com.anan.service.edu.service.impl;

import com.anan.service.edu.orm.Teacher;
import com.anan.service.edu.mapper.TeacherMapper;
import com.anan.service.edu.service.TeacherService;
import com.anan.service.edu.util.QueryParams;
import com.anan.service.edu.vo.TeacherQuery;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author anan/CodeGenerator
 * @since 2020-05-11
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {


  @Override
  public Page pageCondition(Long current, Long pageSize, TeacherQuery query ) {

    // 创建page对象
    Page<Teacher> page = new Page<>(current, pageSize);
    //构建wapper条件
    QueryWrapper<Teacher> qw = new QueryWrapper<>();

    //多条件组合查询
    //判断条件值是否为空，不空再拼接
//    QueryParams queryParams = QueryParams.build()
//      .add("userId", QueryParams.Operator.EQ, MapUtils.getLong(condition, "userId"))
//      .add("type", QueryParams.Operator.EQ, MapUtils.getInteger(condition, "type"))
//      .add("orderId", QueryParams.Operator.EQ, MapUtils.getString(condition, "orderId"));
//

    QueryParams qp = QueryParams.build(qw)
      .like("name", query.getName())
      .like("level", query.getLevel())
      .ge("gmt_create", query.getBegin())
      .le("gmt_modified", query.getEnd())
      .orderByDesc("gmt_create");



    //调用方法实现分页
    this.page(page, qp.getQw());
    return page;
  }
}
