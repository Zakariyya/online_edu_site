package com.anan.service.edu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.anan.service.edu.listener.SubjectExcelListener;
import com.anan.service.edu.orm.Subject;
import com.anan.service.edu.mapper.EduSubjectMapper;
import com.anan.service.edu.orm.excel.SubjectData;
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
  public List<Subject> treeFindAll() {

    List<Subject> finalList = new ArrayList<>();
    List<Subject> list = this.list(null);

    for (Subject item : list) {
      if (item.getParentId().equals("0")) {
        //遍历list中的元素 pid == item.getId()，返回列表
        List<Subject> childrenList = addChildren(item, list);

        //将列表传到item.getChildren()
        item.setChildren(childrenList);
        //将item传入 finaList 中
        finalList.add(item);
      }

    }
    return finalList;
  }


  public List<Subject> addChildren(Subject pSub, List<Subject> list){

    List<Subject> cList = new ArrayList<>();
    for (Subject item : list) {
      if (item.getParentId().equals(pSub.getId())) {
        item.setChildren(addChildren(item, list));
        cList.add(item);
      }
    }
    return cList;
  }


}
