package com.mypage.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by mengsk on 2019/10/28.
 */
@Getter
@Setter
@ContentRowHeight(20)
public class LinkInfoExport {

    @ExcelProperty(value = "序号",index = 0)
    private Integer no;
    @ColumnWidth(20)
    @ExcelProperty(value = "链接名称",index = 1)
    private String name;
    @ColumnWidth(100)
    @ExcelProperty(value = "链接地址",index = 2)
    private String url;
}
