package excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Author: anan
 * @Date: 2020/6/4 10:09
 */
@Data
public class DemoData {


  // 设置表头
  @ExcelProperty(value = "学生编号", index = 0)
  private Integer sno;

  @ExcelProperty(value = "学生姓名", index = 1)
  private String sname;

}
