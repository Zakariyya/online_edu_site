package com.anan.service.edu.service;

import com.anan.service.edu.orm.Teacher;
import com.anan.service.edu.vo.TeacherQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author anan/CodeGenerator
 * @since 2020-05-11
 */
public interface TeacherService extends IService<Teacher> {

  Page pageCondition(Long current, Long pageSize, TeacherQuery query);

}
