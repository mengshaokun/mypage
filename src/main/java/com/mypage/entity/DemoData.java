package com.mypage.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by mengsk on 2019/10/18.
 */
@Data
public class DemoData {
    @ExcelProperty({"大标题","主标题","姓名"})
    private String name;
    @ExcelProperty({"大标题","主标题","年龄"})
    private Integer age;
    @ExcelProperty({"","主标题1","成绩"})
    private Double achievement;
    @ExcelProperty({"","主标题2","日期"})
    private Date date;
}
