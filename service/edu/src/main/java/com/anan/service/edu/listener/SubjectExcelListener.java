package com.anan.service.edu.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.anan.common.base.exception.AnanException;
import com.anan.service.edu.orm.Subject;
import com.anan.service.edu.orm.excel.SubjectData;
import com.anan.service.edu.service.EduSubjectService;
import com.anan.service.edu.util.QueryParams;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @Author: anan
 * @Date: 2020/6/4 14:42
 */
@NoArgsConstructor
@AllArgsConstructor
public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {

  //因为SubjectExcelListener不能交给spring进行管理，需要自己new，不能注入其他对象
  //不能实现数据库操作
  // 解决方案：手动创建有参构造，把service注入进来，然后生成有参，无参的构造，然后直接new这个类，我们就拿到service了
  public EduSubjectService service;

  //读取excel内容，一行一行进行读取
  @Override
  public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
    if (subjectData == null) {
      throw new AnanException(-1, "文件数据为空");
    }

    //一行一行读取，每次读取有两个值，第一个值一级分类，第二个值二级分类
    //判断一级分类是否重复
    Subject oneSubject = this.existOneSubject(subjectData.getOneSubjectName());
    if (oneSubject == null) { //没有相同的一级分类，进行添加
      oneSubject = new Subject();
      oneSubject.setParentId("0");
      oneSubject.setTitle(subjectData.getOneSubjectName());
      service.save(oneSubject);
    }

    String parentId = oneSubject.getId();
    //判断二级分类
    //判断二级分类是否重复
    Subject twoSubject = this.existTwoSubject(subjectData.getTwoSubjectName(), parentId);
    if (twoSubject == null) {
      twoSubject = new Subject();
      twoSubject.setParentId(parentId);
      twoSubject.setTitle(subjectData.getTwoSubjectName()); // 二级分类的名称
      service.save(twoSubject);
    }

  }

  @Override
  public void doAfterAllAnalysed(AnalysisContext analysisContext) {

  }


  //判断一级分类不能重复添加
  private Subject existOneSubject(String name) {
    QueryWrapper<Subject> w = new QueryWrapper<>();
    QueryParams q = QueryParams.build(w)
      .eq("title", name)
      .eq("parent_id", "0");
    Subject one = service.getOne(w);
    return one;
  }

  //判断二级分类不能重复添加
  private Subject existTwoSubject(String name, String parentId) {
    QueryWrapper<Subject> w = new QueryWrapper<>();
    QueryParams q = QueryParams.build(w)
      .eq("title", name)
      .eq("parent_id", parentId);
    Subject two = service.getOne(w);
    return two;
  }
}
