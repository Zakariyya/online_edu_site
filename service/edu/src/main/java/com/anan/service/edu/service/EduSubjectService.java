package com.anan.service.edu.service;

import com.anan.service.edu.orm.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author anan/CodeGenerator
 * @since 2020-06-04
 */
public interface EduSubjectService extends IService<Subject> {

  void saveSubject(MultipartFile file,EduSubjectService service);

  List<Subject> treeFindAll();

}
