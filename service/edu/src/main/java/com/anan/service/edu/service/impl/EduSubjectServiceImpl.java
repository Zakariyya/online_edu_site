package com.anan.service.edu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.anan.service.edu.listener.SubjectExcelListener;
import com.anan.service.edu.orm.Subject;
import com.anan.service.edu.mapper.EduSubjectMapper;
import com.anan.service.edu.orm.excel.SubjectData;
import com.anan.service.edu.orm.subjectTree.SubjectTree;
import com.anan.service.edu.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author anan/CodeGenerator
 * @since 2020-06-04
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, Subject> implements EduSubjectService {

  //添加课程分类
  @Override
  public void saveSubject(MultipartFile file, EduSubjectService service) {
    try{
      //文件输入的流
      InputStream inputStream = file.getInputStream();
      //调用方法进行读取
      EasyExcel.read(inputStream, SubjectData.class, new SubjectExcelListener(service)).doReadAll();

    }catch (Exception e){
      e.printStackTrace();

    }

  }

  @Override
  public List<SubjectTree> treeFindAll() {

    List<SubjectTree> finalList = new ArrayList<>();

    List<Subject> list = this.list(null);

    for (Subject itemOne : list) {
      if(itemOne.getParentId().equals("0")){
        SubjectTree tree = new SubjectTree();
        BeanUtils.copyProperties(itemOne, tree);

        for(Subject itemTwo: list){
          if(itemTwo.getParentId().equals(itemOne.getId())){
            SubjectTree two = new SubjectTree();
            BeanUtils.copyProperties(itemTwo, two);
            tree.getChildren().add(two);
          }
        }
        finalList.add(tree);
      }
    }

    return finalList;
  }

}
